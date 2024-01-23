package Controllers;

import DataClasses.Block;
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

public class BlokiController extends BaseController {

    @FXML Button modyfikujButton;
    @FXML Button dodajButton;
    @FXML Button usunButton;
    @FXML Button odswiezButton;
    @FXML TextField numerBlokuText;
    @FXML TextField idTextM;
    @FXML TextField numerBlokuTextM;

    @FXML
    TableView blokiTableView;

    @FXML
    TableColumn<Block,Integer> id;
    @FXML
    TableColumn<Block,Integer> numerBloku;
    @FXML
    TableColumn<Block,Integer> liczbaMieszkancow;
    @FXML
    TableColumn<Block,Double> sredniWiek;

    @FXML
    void initialize()
    {
        id.setCellValueFactory(new PropertyValueFactory<Block,Integer>("id"));
        numerBloku.setCellValueFactory(new PropertyValueFactory<Block,Integer>("number"));
        liczbaMieszkancow.setCellValueFactory(new PropertyValueFactory<Block,Integer>("occupantsNumber"));
        sredniWiek.setCellValueFactory(new PropertyValueFactory<Block,Double>("averageAge"));

        onOdswiez(new ActionEvent());
    }

    public void onModyfikuj(ActionEvent actionEvent)
    {
        DatabaseHandler.modifyBlock(Integer.parseInt(idTextM.getText()),Integer.parseInt(numerBlokuTextM.getText()));
    }

    public void onDodaj(ActionEvent actionEvent)
    {
        DatabaseHandler.addBlock(Integer.parseInt(numerBlokuText.getText()));
    }

    public void onUsun(ActionEvent actionEvent)
    {
        DatabaseHandler.deleteBlock(Integer.parseInt(idTextM.getText()));
    }

    public void onOdswiez(ActionEvent actionEvent)
    {
        DatabaseHandler.callBlockStatisticsProcedure();

        List <Block> blocks = DatabaseHandler.getAllBlocksData();
        ObservableList<Block> fxCollectionsEmployeeList = FXCollections.observableArrayList();

        for(Block blc : blocks)
        {
            fxCollectionsEmployeeList.add(blc);
        }
        blokiTableView.setItems(fxCollectionsEmployeeList);
        blokiTableView.refresh();
    }

}
