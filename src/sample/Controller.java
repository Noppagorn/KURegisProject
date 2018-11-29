package sample;

import Student.Student;
import Subject.JsonControlData;
import Subject.Subject;
import Subject.ProMain;
import Student.SubjectRegis;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
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
    TableView<SubjectRegis> stdTable;
    @FXML
    TableColumn<SubjectRegis,String> stdYear;
    @FXML
    TableColumn<SubjectRegis,String> stdTerm;
    @FXML
    TableColumn<SubjectRegis,String> stdCode;
    @FXML
    TableColumn<SubjectRegis,String> stdName;
    @FXML TableColumn<SubjectRegis, String> stdBase;
    @FXML TableColumn<SubjectRegis,String> stdGrade;

    @FXML
    Button addButton;
    private ArrayList<Subject> subjects = null;
    private ArrayList<SubjectRegis> stdSubject = null;
    public Controller(){
        JsonControlData jSubject = new JsonControlData();
        ProMain proMain = new ProMain();
        Student student = new Student();

        try {
            if (!jSubject.checkFileExist()){
                subjects = proMain.createSubject();
                jSubject.writeToJson(subjects);
                proMain.createSubject();
                subjects = jSubject.readFromJson();
            }else
            {
                subjects = jSubject.readFromJson();
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
        try {
            if (!student.checkFileExist()){
                stdSubject = new  ArrayList<>();
                student.writeToJson(stdSubject);
                stdSubject = student.readFromJson();
            }else
            {
                stdSubject = student.readFromJson();
            }
        } catch (UnsupportedEncodingException e) {
            System.out.println(e);
        }
    }
    @FXML
    public void initialize(){
        tableSubject();
        tableStudent();
        colorOnRow();
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
        colorOnRow();
    }

    private void colorOnRow(){
        idSubject.setCellFactory(column -> {
            return new TableCell<Subject, String>() {
                @Override
                protected void updateItem(String item, boolean empty) {
                    super.updateItem(item, empty);

                    setText(empty ? "" : getItem().toString());
                    setGraphic(null);

                    TableRow<Subject> currentRow = getTableRow();


                    if (!isEmpty()) {

                        for(Subject x: subjects){
                            if ( x.getCode().equals(item) && x.isCheck()){
                                currentRow.setStyle("-fx-background-color:lightgreen");
                                break;
                            }
                            else if (x.getCode().equals(item) && x.getLevel() == 1){
                                currentRow.setStyle("-fx-background-color:#ffb075");
                                break;
                            }
                            else if (x.getCode().equals(item) && x.getLevel() == 2){
                                currentRow.setStyle("-fx-background-color:#ff6042");
                                break;
                            }
                            else if (x.getCode().equals(item) && x.getLevel() == 3){
                                currentRow.setStyle("-fx-background-color:red");
                                break;
                            }
                            else if (x.getCode().equals(item) && x.getLevel() == 4){
                                currentRow.setStyle("-fx-background-color:firebrick");
                                break;
                            }
                            else {
                                currentRow.setStyle(null);
                            }
                        }
                    }
                }
            };
        });
    }


    private void tableStudent(){
        upDateStudent();

        stdYear.setCellValueFactory(param -> new SimpleStringProperty(Integer.toString(param.getValue().getYear())));
        stdTerm.setCellValueFactory(param -> new SimpleStringProperty(Integer.toString(param.getValue().getTerm())));
        stdCode.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getCode()));

        stdName.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getName()));
        stdBase.setCellValueFactory(param -> new SimpleStringProperty(Integer.toString(param.getValue().getWeight())));
        stdGrade.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getGrade()));

    }
    private void upDateStudent(){
        ObservableList<SubjectRegis> subjectsObs = FXCollections.observableArrayList(stdSubject);
        stdTable.getItems().clear();
        stdTable.setItems(subjectsObs);
    }
    @FXML
    public void deleteSubjectStudent(ActionEvent event){
        SubjectRegis selectedItem = stdTable.getSelectionModel().getSelectedItem();
        if (selectedItem == null) return;
        stdTable.getItems().remove(selectedItem);
        stdSubject.remove(selectedItem);
        for(Subject x:subjects){
            if (x.getCode().equals(selectedItem.getCode())){
                x.setCheck(false);
            }
        }
        new JsonControlData().writeToJson(subjects);
        Student st = new Student();
        st.writeToJson(stdSubject);
        upDateStudent();
        upDateSubject();
    }
    @FXML
    public void handleAddButton(ActionEvent event){
            Subject selectedItem = tableSubject.getSelectionModel().getSelectedItem();
            if (selectedItem == null) return;
            tableSubject.getItems().remove(selectedItem);
            try {
                addChangeScreen(selectedItem);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        upDateSubject();

    }
    private void addChangeScreen(Subject selec) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("AddPage.fxml"));
        Parent root1 = null;
        root1 = (Parent) fxmlLoader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(root1));
        ControlAddPage controller = fxmlLoader.getController();
        controller.init(selec,stdSubject,subjects,this::upDateStudent,this::upDateSubject);
        stage.show();
    }



}
