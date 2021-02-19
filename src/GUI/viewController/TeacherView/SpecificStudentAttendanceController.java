package GUI.viewController.TeacherView;


import BE.Class;
import GUI.Model.TeacherModel;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.Axis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;

import java.net.URL;
import java.util.Collections;
import java.util.ResourceBundle;

public class SpecificStudentAttendanceController implements Initializable {

    private TeacherModel teacherModel;

    ObservableList<Class> allClasses;

    @FXML
    ChoiceBox<String> lstView;
    @FXML
    ChoiceBox<Class> lstClasses;
    @FXML
    private LineChart<String, Number> lineChart;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        teacherModel = new TeacherModel();

        allClasses = teacherModel.getAllClasses();
        lstClasses.setItems(allClasses);

        lstView.getItems().add("Whole semester");
        lstView.getItems().add("Weekdays");

        XYChart.Series<String, Number> semesterSeriesITO = new XYChart.Series<>();
        XYChart.Series<String, Number> semesterSeriesSCO = new XYChart.Series<>();
        XYChart.Series<String, Number> semesterSeriesSDE = new XYChart.Series<>();
        XYChart.Series<String, Number> semesterSeriesDBOS = new XYChart.Series<>();

        XYChart.Series<String, Number> weekDaysSeries = new XYChart.Series<>();

        Axis<String> xAxis = lineChart.getXAxis();
        Axis<Number> yAxis = lineChart.getYAxis();

        yAxis.setLabel("Attendance %");

        lstView.setOnAction(event -> {
            int selectedIndexView = lstView.getSelectionModel().getSelectedIndex();
            if (selectedIndexView == 0) {
                weekDaysSeries.getData().removeAll(Collections.singleton(lineChart.getData().setAll()));

                xAxis.setLabel("Month");

                semesterSeriesITO.setName("ITO");
                semesterSeriesITO.getData().add(new XYChart.Data<>("September", 100));
                semesterSeriesITO.getData().add(new XYChart.Data<>("October", 80));
                semesterSeriesITO.getData().add(new XYChart.Data<>("November", 95));
                semesterSeriesITO.getData().add(new XYChart.Data<>("December", 70));
                lineChart.getData().add(semesterSeriesITO);

                semesterSeriesSCO.setName("SCO");
                semesterSeriesSCO.getData().add(new XYChart.Data<>("September", 40));
                semesterSeriesSCO.getData().add(new XYChart.Data<>("October", 50));
                semesterSeriesSCO.getData().add(new XYChart.Data<>("November", 60));
                semesterSeriesSCO.getData().add(new XYChart.Data<>("December", 20));
                lineChart.getData().add(semesterSeriesSCO);

                semesterSeriesSDE.setName("SDE");
                semesterSeriesSDE.getData().add(new XYChart.Data<>("September", 90));
                semesterSeriesSDE.getData().add(new XYChart.Data<>("October", 68));
                semesterSeriesSDE.getData().add(new XYChart.Data<>("November", 88));
                semesterSeriesSDE.getData().add(new XYChart.Data<>("December", 100));
                lineChart.getData().add(semesterSeriesSDE);

                semesterSeriesDBOS.setName("DBOS");
                semesterSeriesDBOS.getData().add(new XYChart.Data<>("September", 67));
                semesterSeriesDBOS.getData().add(new XYChart.Data<>("October", 44));
                semesterSeriesDBOS.getData().add(new XYChart.Data<>("November", 90));
                semesterSeriesDBOS.getData().add(new XYChart.Data<>("December", 98));
                lineChart.getData().add(semesterSeriesDBOS);

            } else if(selectedIndexView == 1) {
                semesterSeriesITO.getData().removeAll(Collections.singleton(lineChart.getData().setAll()));
                semesterSeriesSCO.getData().removeAll(Collections.singleton(lineChart.getData().setAll()));
                semesterSeriesSDE.getData().removeAll(Collections.singleton(lineChart.getData().setAll()));
                semesterSeriesDBOS.getData().removeAll(Collections.singleton(lineChart.getData().setAll()));

                xAxis.setLabel("Day");

                weekDaysSeries.setName("Attendance for weekdays");
                weekDaysSeries.getData().add(new XYChart.Data<>("Monday", 90));
                weekDaysSeries.getData().add(new XYChart.Data<>("Tuesday", 88));
                weekDaysSeries.getData().add(new XYChart.Data<>("Wednesday", 100));
                weekDaysSeries.getData().add(new XYChart.Data<>("Thursday", 30));
                weekDaysSeries.getData().add(new XYChart.Data<>("Friday", 95));
                lineChart.getData().add(weekDaysSeries);
            }
        });
    }
}
