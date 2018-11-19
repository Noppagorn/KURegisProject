package sample;

import Combine.ComputerScience;
import Student.AllStudent;
import Subject.Subject;
import javafx.fxml.FXML;

import java.util.ArrayList;

public class Controller {
    private ArrayList<Subject> subjects = null;
    public Controller(){
        ComputerScience computerScience = new ComputerScience();
        computerScience.readFromFile();
        subjects = computerScience.getAllSubject();
    }
    @FXML
    public void initialize(){
        ShowAll();
    }
    private void ShowAll(){
        for (Subject x: subjects
             ) {
            System.out.println(x);
        }
    }

}
