package sample;

import Student.Student;
import Student.SubjectRegis;
import Subject.Subject;
import Subject.JsonControlData;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControlAddPage {
    Runnable callbackStd;
    Runnable callbackSub;
    Subject selecSubject;
    ArrayList<SubjectRegis> subjectRegis;
    ArrayList<Subject> subjects;
    @FXML
    Label labelSubject;
    @FXML
    ChoiceBox yearBox;
    @FXML
    ChoiceBox termBox;
    @FXML
    ChoiceBox gradeBox;

    @FXML
    Button addButton;
    @FXML Label exceptLabel;

    public ControlAddPage(){
    }

    public void init(Subject selecSubject, ArrayList<SubjectRegis> stdSubject,ArrayList<Subject> subjects, Runnable callbackStd,Runnable callbackSub) {
        this.subjectRegis = stdSubject;
        this.selecSubject = selecSubject;
        this.callbackStd = callbackStd;
        this.subjects = subjects;
        this.callbackSub = callbackSub;
        labelSubject.setText(selecSubject.getCode() + " : " + selecSubject.getName());

        gradeBox.setItems(FXCollections.observableArrayList(
                "A","B+", "B","C+", "C","D+", "D","F")
        );
        termBox.setItems(FXCollections.observableArrayList(
                "1","2")
        );

        yearBox.setItems(FXCollections.observableArrayList(
                "1","2","3","4")
        );
    }

    @FXML
    public void handleAddSubject(ActionEvent event) {
        if (selecSubject.getSubjectBase() != null){
            if (!checkSubjectBase()){
                exceptLabel.setText("ยังไม่ได้ลงวิชาพื้นฐาน");
            }
            else if (selecSubject.isCheck()){
                System.out.println(selecSubject.isCheck());
                exceptLabel.setText("วิชา นี้ ลงทะเบียนไปแล้ว");
            }
            else{ifcanRegis();}
        }
        else {
            if (selecSubject.isCheck()){
                System.out.println(selecSubject.isCheck());
                exceptLabel.setText("วิชา นี้ ลงทะเบียนไปแล้ว");
            }
            else {
                ifcanRegis();
            }
        }
    }

    private void ifcanRegis(){
        System.out.println('a');
        selecSubject.setCheck(true);
        subjectRegis.add(new SubjectRegis(Integer.parseInt(yearBox.getValue().toString()), Integer.parseInt(termBox.getValue().toString()), selecSubject, gradeBox.getValue().toString()));
        new JsonControlData().writeToJson(subjects);
        Student st = new Student();
        st.writeToJson(subjectRegis);
        callbackSub.run();
        callbackStd.run();
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.close();
    }

    private boolean checkSubjectBase() {
        int count = 0;
        for (String x : selecSubject.getSubjectBase()) {
            for (Subject y : subjectRegis) {
                if (y.getCode().equals(x)) {
                    count++;
                }
            }
        }
        System.out.println(count);
        System.out.println(selecSubject.getSubjectBase().length);
        if (count == selecSubject.getSubjectBase().length){
            return true;
        }
        else {
            return false;
        }
    }
}
