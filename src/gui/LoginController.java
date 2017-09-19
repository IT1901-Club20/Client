package gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

public class LoginController{
    @FXML
    Button btnLogin;

    @FXML
    TextField txtUsrName;

    @FXML
    TextField txtPassword;

    @FXML
    void handleLogin(){
        System.out.println("Logged in");
    }

}
