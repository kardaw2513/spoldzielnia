package Controllers;

import DataClasses.Employee;
import DataClasses.Person;
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

public class MieszkancyController extends BaseController {

    @FXML Button modyfikujButton;
    @FXML Button dodajButton;
    @FXML Button usunButton;
    @FXML Button odswiezButton;
    @FXML TextField imieText;
    @FXML TextField nazwiskoText;
    @FXML TextField plecText;
    @FXML TextField wiekText;
    @FXML TextField numerMieszkaniaText;
    @FXML TextField idMieszkaniaText;

    @FXML TextField idTextM;
    @FXML TextField imieTextM;
    @FXML TextField nazwiskoTextM;
    @FXML TextField plecTextM;
    @FXML TextField wiekTextM;
    @FXML TextField numerMieszkaniaTextM;
    @FXML TextField idMieszkaniaTextM;

    @FXML
    TableView mieszkancyTableView;

    @FXML
    TableColumn<Person,Integer> id;
    @FXML
    TableColumn<Person,String> imie;
    @FXML
    TableColumn<Person,String> nazwisko;
    @FXML
    TableColumn<Person,String> plec;
    @FXML
    TableColumn<Person,Integer> wiek;
    @FXML
    TableColumn<Person,Integer> numerMieszkania;
    @FXML
    TableColumn<Person,Integer> idMieszkania;


    @FXML
    void initialize()
    {
        id.setCellValueFactory(new PropertyValueFactory<Person,Integer>("id"));
        imie.setCellValueFactory(new PropertyValueFactory<Person,String>("name"));
        nazwisko.setCellValueFactory(new PropertyValueFactory<Person,String>("surname"));
        plec.setCellValueFactory(new PropertyValueFactory<Person,String>("sex"));
        wiek.setCellValueFactory(new PropertyValueFactory<Person,Integer>("age"));
        numerMieszkania.setCellValueFactory(new PropertyValueFactory<Person,Integer>("flatNumber"));
        idMieszkania.setCellValueFactory(new PropertyValueFactory<Person,Integer>("flatId"));

        onOdswiez(new ActionEvent());
    }

    public void onModyfikuj(ActionEvent actionEvent)
    {
        DatabaseHandler.modifyPerson(Integer.parseInt(idTextM.getText()),imieTextM.getText(),nazwiskoTextM.getText(), plecTextM.getText(), Integer.parseInt(wiekTextM.getText()),Integer.parseInt(numerMieszkaniaTextM.getText()),Integer.parseInt(idMieszkaniaTextM.getText()));
    }

    public void onDodaj(ActionEvent actionEvent)
    {
        DatabaseHandler.addPerson(imieText.getText(),nazwiskoText.getText(), plecText.getText(), Integer.parseInt(wiekText.getText()),Integer.parseInt(numerMieszkaniaText.getText()),Integer.parseInt(idMieszkaniaText.getText()));
    }

    public void onUsun(ActionEvent actionEvent)
    {
        DatabaseHandler.deletePerson(Integer.parseInt(idTextM.getText()));
    }

    public void onOdswiez(ActionEvent actionEvent)
    {
        List <Person> persons = DatabaseHandler.getAllPersonData();
        ObservableList<Person> fxCollectionsEmployeeList = FXCollections.observableArrayList();

        for(Person emp : persons)
        {
            fxCollectionsEmployeeList.add(emp);
        }
        mieszkancyTableView.setItems(fxCollectionsEmployeeList);
        mieszkancyTableView.refresh();
    }

}
