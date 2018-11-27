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
import java.util.concurrent.atomic.AtomicReference;

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
        tableStudent();
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

    private void tableStudent(){
        upDateStudent();
        stdCode.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCode()));

        stdName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        stdBase.setCellValueFactory(param -> new SimpleStringProperty(Integer.toString(param.getValue().getWeight())));
        stdGrade.setCellValueFactory(param -> new SimpleStringProperty(Integer.toString(param.getValue().getWeight())));

    }
    private void upDateStudent(){
        ObservableList<Subject> subjectsObs = FXCollections.observableArrayList(stdSubject);
        stdTable.getItems().clear();
        stdTable.setItems(subjectsObs);
    }
    @FXML
    public void deleteSubjectStudent(ActionEvent event){
        Subject selectedItem = stdTable.getSelectionModel().getSelectedItem();
        stdTable.getItems().remove(selectedItem);
        stdSubject.remove(selectedItem);
        Student st = new Student();
        st.writeToJson(stdSubject);
        upDateStudent();
    }
    @FXML
    public void handleAddButton(ActionEvent event){
            Subject selectedItem = tableSubject.getSelectionModel().getSelectedItem();
            tableSubject.getItems().remove(selectedItem);
            stdSubject.add(selectedItem);
            try {
                addChangeScreen(selectedItem);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            subjects.remove(selectedItem);
        upDateSubject();
        Student st = new Student();
        st.writeToJson(stdSubject);

    }
    private void addChangeScreen(Subject selec) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPage.fxml"));
        Parent root1 = null;
        root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControlAddPage controller = fxmlLoader.getController();
        controller.init(selec, this::upDateStudent);
        stage.show();
    }


}
