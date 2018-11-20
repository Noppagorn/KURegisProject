package sample;

import Combine.ComputerScience;
import Student.AllStudent;
import Subject.Subject;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.util.ArrayList;

public class Controller {

    @FXML
    TableColumn<Subject,String> idSubject;
    @FXML
    TableView<Subject> tableSubject;

    @FXML
    TableColumn<Subject,String> nameSubTable;
    @FXML TableColumn<Subject,String> BaseTable;
    private ArrayList<Subject> subjects = null;
    public Controller(){
        ComputerScience computerScience = new ComputerScience();
        computerScience.readFromFile();
        subjects = computerScience.getAllSubject();
    }
    @FXML
    public void initialize(){
        showAllID();
        showAllName();
        showAllBase();
    }

    private void showAllID(){
        //subjects = new ArrayList<>();
        ObservableList<Subject> subjectsObs = FXCollections.observableArrayList(this.subjects);
        tableSubject.setItems(subjectsObs);
        idSubject.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCode()));
    }

    private void showAllName(){
        ObservableList<Subject> subjectsObs = FXCollections.observableArrayList(this.subjects);
        tableSubject.setItems(subjectsObs);
        nameSubTable.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
    }

    private void showAllBase(){
        ObservableList<Subject> subjectsObs = FXCollections.observableArrayList(this.subjects);
        tableSubject.setItems(subjectsObs);
        BaseTable.setCellValueFactory(param -> new SimpleStringProperty(Integer.toString(param.getValue().getWeight())));
    }


}
