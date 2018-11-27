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
                //System.out.println("Must complete SubjectBase");
                //throw new RuntimeException("Must complete SubjectBase");
                exceptLabel.setText("Must complete SubjectBase");
            }
            ifcanRegis();
        }
        else {
            ifcanRegis();
        }
    }

    private void ifcanRegis(){
        System.out.println('a');
        subjectRegis.add(new SubjectRegis(Integer.parseInt(yearText.getText()), Integer.parseInt(termText.getText()), selecSubject, gradeText.getText()));
        subjects.remove(selecSubject);
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
        if (count == selecSubject.getSubjectBase().length){
            return true;
        }
        else {
            return false;
        }
    }
    private double ChangeGradeToInt(){
        if (gradeText.getText().equals("A")){
            return 4;
        }
        else if (gradeText.getText().equals("B+")){
            return 3.5;
        }
        else if (gradeText.getText().equals("B")){
            return 3;
        }
        else if (gradeText.getText().equals("C+")){
            return 2.5;
        }
        else if (gradeText.getText().equals("C")){
            return 2;
        }
        else if (gradeText.getText().equals("D+")){
            return 1.5;
        }
        else if (gradeText.getText().equals("D")){
            return 1;
        }
        else {
            return 0;
        }

    }
}
