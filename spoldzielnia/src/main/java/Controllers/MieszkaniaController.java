package Controllers;

import DataClasses.Bill;
import DataClasses.Employee;
import DataClasses.Flat;
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

public class MieszkaniaController extends BaseController {

    @FXML Button modyfikujButton;
    @FXML Button dodajButton;
    @FXML Button usunButton;
    @FXML Button odswiezButton;

    @FXML TextField numerMieszkaniaText;
    @FXML TextField idBlokuText;

    @FXML TextField idTextM;
    @FXML TextField numerMieszkaniaTextM;
    @FXML TextField idBlokuTextM;

    @FXML
    TableView mieszkaniaTableView;

    @FXML
    TableColumn<Flat,Integer> id;
    @FXML
    TableColumn<Flat,Integer> numerMieszkania;
    @FXML
    TableColumn<Flat,Integer> idBloku;

    @FXML
    void initialize()
    {
        id.setCellValueFactory(new PropertyValueFactory<Flat,Integer>("id"));
        numerMieszkania.setCellValueFactory(new PropertyValueFactory<Flat,Integer>("number"));
        idBloku.setCellValueFactory(new PropertyValueFactory<Flat,Integer>("blockId"));

        onOdswiez(new ActionEvent());
    }

    public void onModyfikuj(ActionEvent actionEvent)
    {
        DatabaseHandler.modifyFlat(Integer.parseInt(idTextM.getText()),Integer.parseInt(numerMieszkaniaTextM.getText()),Integer.parseInt(idBlokuTextM.getText()));
    }

    public void onDodaj(ActionEvent actionEvent)
    {
        DatabaseHandler.addFlat(Integer.parseInt(numerMieszkaniaText.getText()),Integer.parseInt(idBlokuText.getText()));
    }

    public void onUsun(ActionEvent actionEvent)
    {
        DatabaseHandler.deleteFlat(Integer.parseInt(idTextM.getText()));
    }

    public void onOdswiez(ActionEvent actionEvent)
    {
        List <Flat> flats = DatabaseHandler.getAllFlatsData();
        ObservableList<Flat> fxCollectionsEmployeeList = FXCollections.observableArrayList();

        for(Flat flt : flats)
        {
            fxCollectionsEmployeeList.add(flt);
        }
        mieszkaniaTableView.setItems(fxCollectionsEmployeeList);
        mieszkaniaTableView.refresh();
    }

}
