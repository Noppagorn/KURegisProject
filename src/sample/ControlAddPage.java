package sample;

import Student.Student;
import Student.SubjectRegis;
import Subject.Subject;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControlAddPage {
    Runnable callback;
    Subject selecSubject;
    ArrayList<SubjectRegis> subjectRegis;
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

    public void init(Subject selecSubject, ArrayList<SubjectRegis> stdSubject, Runnable callback) {
        this.subjectRegis = stdSubject;
        this.selecSubject = selecSubject;
        this.callback = callback;
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
        }
        else {
            subjectRegis.add(new SubjectRegis(Integer.parseInt(yearText.getText()), Integer.parseInt(termText.getText()), selecSubject, Integer.parseInt(gradeText.getText())));
            Student st = new Student();
            st.writeToJson(subjectRegis);
            callback.run();
            Stage stage = (Stage) addButton.getScene().getWindow();
            stage.close();

        }
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
        System.out.println("count "+ count);
        System.out.println(selecSubject.getSubjectBase().length);
        if (count == selecSubject.getSubjectBase().length){
            return true;
        }
        else {
            return false;
        }
    }
}
