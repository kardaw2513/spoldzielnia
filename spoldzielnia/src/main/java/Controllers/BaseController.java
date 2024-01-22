package Controllers;

import core.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class BaseController {
    @FXML Button pracownicyButton;
    @FXML Button mieszkancyButton;
    @FXML Button GBDButton;

    protected Parent root;
    protected Stage stage;
    protected Scene scene;

    @FXML void initialize()
    {

    }

    public void switchToScene(Stage currentStage, String sceneName)
    {
        try{
            root = FXMLLoader.load(Objects.requireNonNull(HelloApplication.class.getResource(sceneName+".fxml")));
            stage=currentStage;
            scene=new Scene(root);
            stage.setScene(scene);
            stage.show();
        }catch (IOException e)
        {
            e.printStackTrace();
        }

    }

    protected Stage GSFAevnt(ActionEvent actionEvent)
    {
        return (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
    }

    public void onPracownicyButton(ActionEvent actionEvent)
    {
        System.out.println("Pressed pracownicy Button");
        this.switchToScene(GSFAevnt(actionEvent),"pracownicy");
    }

    public void onMieszkancyButton(ActionEvent actionEvent)
    {
        System.out.println("Pressed mieszkancy Button");
        this.switchToScene(GSFAevnt(actionEvent),"mieszkancy");

    }

    public void onGBDButton(ActionEvent actionEvent)
    {
        System.out.println("Pressed glowna baza danych Button");
        this.switchToScene(GSFAevnt(actionEvent),"bloki");

    }


}
