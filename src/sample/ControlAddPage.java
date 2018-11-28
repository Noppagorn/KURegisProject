package sample;

import Student.Student;
import Student.SubjectRegis;
import Subject.Subject;
import Subject.JsonControlData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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
    TextField yearText;
    @FXML
    TextField termText;
    @FXML
    TextField gradeText;

    @FXML
    Button addButton;
    @FXML Label exceptLabel;

    public void init(Subject selecSubject, ArrayList<SubjectRegis> stdSubject,ArrayList<Subject> subjects, Runnable callbackStd,Runnable callbackSub) {
        this.subjectRegis = stdSubject;
        this.selecSubject = selecSubject;
        this.callbackStd = callbackStd;
        this.subjects = subjects;
        this.callbackSub = callbackSub;
        labelSubject.setText(selecSubject.getCode() + " : " + selecSubject.getName());
    }

    @FXML
    public void handleAddSubject(ActionEvent event) {
        if (selecSubject.getSubjectBase() != null){
            if (!checkSubjectBase()){
                exceptLabel.setText("Must complete SubjectBase");
            }
            else if (selecSubject.isCheck()){
                System.out.println(selecSubject.isCheck());
                exceptLabel.setText("Don't Regis Twice");
            }
            else{ifcanRegis();}
        }
        else {
            if (selecSubject.isCheck()){
                System.out.println(selecSubject.isCheck());
                exceptLabel.setText("Don't Regis Twice");
            }
            else {
                ifcanRegis();
            }
        }
    }

    private void ifcanRegis(){
        System.out.println('a');
        selecSubject.setCheck(true);
        subjectRegis.add(new SubjectRegis(Integer.parseInt(yearText.getText()), Integer.parseInt(termText.getText()), selecSubject, gradeText.getText()));
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
