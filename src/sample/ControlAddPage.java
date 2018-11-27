package sample;

import Subject.Subject;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.util.ArrayList;

public class ControlAddPage {
    Runnable callback;
    Subject selecSubject;
    @FXML
    Label labelSubject;
    public void init(Subject selecSubject, Runnable callback) {
        this.selecSubject = selecSubject;
        this.callback = callback;
        labelSubject.setText(selecSubject.getCode() + " : " + selecSubject.getName());
    }
}
