package Controllers;

import DataClasses.Employee;
import core.DatabaseHandler;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;

public class PracownicyController extends BaseController {

    @FXML Button modyfikujButton;
    @FXML Button dodajButton;
    @FXML Button usunButton;
    @FXML Button odswiezButton;
    @FXML TextField imieText;
    @FXML TextField nazwiskoText;
    @FXML TextField wiekText;
    @FXML TextField stanowiskoText;
    @FXML TextField idTextM;
    @FXML TextField imieTextM;
    @FXML TextField nazwiskoTextM;
    @FXML TextField wiekTextM;
    @FXML TextField stanowiskoTextM;

    @FXML
    TableView pracownicyTableView;

    @FXML
    TableColumn<Employee,Integer> id;
    @FXML
    TableColumn<Employee,String> imie;
    @FXML
    TableColumn<Employee,String> nazwisko;
    @FXML
    TableColumn<Employee,Integer> wiek;
    @FXML
    TableColumn<Employee,String> stanowisko;


    @FXML
    void initialize()
    {
        id.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("id"));
        imie.setCellValueFactory(new PropertyValueFactory<Employee,String>("name"));
        nazwisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("surname"));
        wiek.setCellValueFactory(new PropertyValueFactory<Employee,Integer>("age"));
        stanowisko.setCellValueFactory(new PropertyValueFactory<Employee,String>("title"));

        onOdswiez(new ActionEvent());
    }

    public void onModyfikuj(ActionEvent actionEvent)
    {
        DatabaseHandler.modifyEmployee(Integer.parseInt(idTextM.getText()),imieTextM.getText(),nazwiskoTextM.getText(),Integer.parseInt(wiekTextM.getText()),stanowiskoTextM.getText());
    }

    public void onDodaj(ActionEvent actionEvent)
    {
        DatabaseHandler.addEmployee(imieText.getText(),nazwiskoText.getText(),Integer.parseInt(wiekText.getText()),stanowiskoText.getText());
    }

    public void onUsun(ActionEvent actionEvent)
    {
        DatabaseHandler.deleteEmployee(Integer.parseInt(idTextM.getText()));
    }

    public void onOdswiez(ActionEvent actionEvent)
    {
        List <Employee> employees = DatabaseHandler.getAllEmployeesData();
        ObservableList<Employee> fxCollectionsEmployeeList = FXCollections.observableArrayList();

        for(Employee emp : employees)
        {
            fxCollectionsEmployeeList.add(emp);
        }
        pracownicyTableView.setItems(fxCollectionsEmployeeList);
        pracownicyTableView.refresh();
    }

}
