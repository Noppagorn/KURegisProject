package sample;

import Student.Student;
import Subject.JsonControlData;
import Subject.Subject;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {

    @FXML
    TableColumn<Subject,String> idSubject;
    @FXML
    TableView<Subject> tableSubject;
    @FXML
    TableColumn<Subject,String> nameSubTable;
    @FXML TableColumn<Subject, String> BaseTable;

    @FXML
    TableView<Subject> stdTable;
    @FXML
    TableColumn<Subject,String> stdCode;
    @FXML
    TableColumn<Subject,String> stdName;
    @FXML TableColumn<Subject, String> stdBase;
    @FXML TableColumn<Subject,String> stdGrade;

    @FXML
    Button addButton;
    private ArrayList<Subject> subjects = null;
    private ArrayList<Subject> stdSubject = null;
    public Controller(){
        JsonControlData jSubject = new JsonControlData();
        subjects = jSubject.readFromJson();

        Student student = new Student();
        stdSubject = student.readFromJson();
    }
    @FXML
    public void initialize(){
        tableSubject();
    }

    private void tableSubject(){
        upDateSubject();
        idSubject.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCode()));

        nameSubTable.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        BaseTable.setCellValueFactory(param -> new SimpleStringProperty(Integer.toString(param.getValue().getWeight())));

    }
    private void upDateSubject(){
        ObservableList<Subject> subjectsObs = FXCollections.observableArrayList(subjects);
        tableSubject.getItems().clear();
        tableSubject.setItems(subjectsObs);
    }
    @FXML
    public void handleAddButton(ActionEvent event){
        final int[] temp = new int[1];
        addButton.setOnAction(e -> {
            Subject selectedItem = tableSubject.getSelectionModel().getSelectedItem();
            tableSubject.getItems().remove(selectedItem);
            //subjects.remove(selectedItem);
            upDateSubject();
        });
    }
    private void addChangeScreen(Subject selec) throws IOException {
        System.out.println("xml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPage.fxml"));
        Parent root1 = null;
        root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControlAddPage controller = fxmlLoader.getController();
        controller.init(selec, this::upDateSubject);
        stage.show();
    }


}
