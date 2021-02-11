package GUI.viewController.TeacherView;

import BE.Student;
import GUI.Model.TeacherModel;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClassAttendanceController implements Initializable {

    private TeacherModel teacherModel;
    private ObservableList<Student> allStudents;

    @FXML
    private TableView<Student> lstAllStudents;
    @FXML
    private TableColumn<Student, String> nameColumn;
    @FXML
    private TableColumn<Student, Integer> absenceColumn;


    public ClassAttendanceController(){
        teacherModel = new TeacherModel();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        allStudents = teacherModel.getAllStudents();

        lstAllStudents.setItems(allStudents);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
        absenceColumn.setCellValueFactory(new PropertyValueFactory<>("Absence"));
    }

    @FXML
    public void getSpecificStudentInfo(){
        showSpecificStudentInfo("/GUI/viewController/TeacherView/SpecificStudentAttendanceView.fxml");
    }
    public void showSpecificStudentInfo(String fxmlPath) {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(fxmlPath));
            Parent mainLayout = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(mainLayout));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
