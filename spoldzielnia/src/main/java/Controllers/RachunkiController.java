package Controllers;

import DataClasses.Bill;
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

public class RachunkiController extends BaseController {

    @FXML Button modyfikujButton;
    @FXML Button dodajButton;
    @FXML Button usunButton;
    @FXML Button odswiezButton;
    @FXML TextField idMieszkaniaText;
    @FXML TextField numerMieszkaniaText;
    @FXML CheckBox oplaconySelection;
    @FXML TextField wodaText;
    @FXML TextField gazText;
    @FXML TextField pradText;

    @FXML TextField idTextM;
    @FXML TextField idMieszkaniaTextM;
    @FXML TextField numerMieszkaniaTextM;
    @FXML CheckBox oplaconySelectionM;
    @FXML TextField wodaTextM;
    @FXML TextField gazTextM;
    @FXML TextField pradTextM;

    @FXML
    TableView rachunkiTableView;

    @FXML
    TableColumn<Bill,Integer> id;
    @FXML
    TableColumn<Bill,Integer> idMieszkania;
    @FXML
    TableColumn<Bill,Integer> numerMieszkania;
    @FXML
    TableColumn<Bill,Boolean> oplacony;
    @FXML
    TableColumn<Bill,Double> woda;
    @FXML
    TableColumn<Bill,Double> gaz;

    @FXML
    TableColumn<Bill,Double> prad;


    @FXML
    void initialize()
    {
        id.setCellValueFactory(new PropertyValueFactory<Bill,Integer>("id"));
        idMieszkania.setCellValueFactory(new PropertyValueFactory<Bill,Integer>("flatId"));
        numerMieszkania.setCellValueFactory(new PropertyValueFactory<Bill,Integer>("flatNumber"));
        oplacony.setCellValueFactory(new PropertyValueFactory<Bill,Boolean>("paid"));
        woda.setCellValueFactory(new PropertyValueFactory<Bill,Double>("water"));
        gaz.setCellValueFactory(new PropertyValueFactory<Bill,Double>("gas"));
        prad.setCellValueFactory(new PropertyValueFactory<Bill,Double>("electricity"));

        onOdswiez(new ActionEvent());
    }

    public void onModyfikuj(ActionEvent actionEvent)
    {
        DatabaseHandler.modifyBill(Integer.parseInt(idTextM.getText()),Integer.parseInt(idMieszkaniaTextM.getText()),Integer.parseInt(numerMieszkaniaTextM.getText()),oplaconySelectionM.isSelected(),Double.parseDouble(wodaTextM.getText()),Double.parseDouble(gazTextM.getText()),Double.parseDouble(pradTextM.getText()));
    }

    public void onDodaj(ActionEvent actionEvent)
    {
        DatabaseHandler.addBill(Integer.parseInt(idMieszkaniaText.getText()),Integer.parseInt(numerMieszkaniaText.getText()),oplaconySelection.isSelected(),Double.parseDouble(wodaText.getText()),Double.parseDouble(gazText.getText()),Double.parseDouble(pradText.getText()));
    }

    public void onUsun(ActionEvent actionEvent)
    {
        DatabaseHandler.deleteBill(Integer.parseInt(idTextM.getText()));
    }

    public void onOdswiez(ActionEvent actionEvent)
    {
        List <Bill> bills = DatabaseHandler.getAllBillData();
        ObservableList<Bill> fxCollectionsEmployeeList = FXCollections.observableArrayList();

        for(Bill bl : bills)
        {
            fxCollectionsEmployeeList.add(bl);
        }
        rachunkiTableView.setItems(fxCollectionsEmployeeList);
        rachunkiTableView.refresh();
    }

}
