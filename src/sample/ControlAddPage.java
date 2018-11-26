package sample;

import Subject.Subject;

import java.util.ArrayList;

public class ControlAddPage {
    Runnable callback;
    Subject selecSubject;
    public void init(Subject selecSubject, Runnable callback) {
        this.selecSubject = selecSubject;
        this.callback = callback;
    }

}
