package gui;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;

import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable{
    @FXML
    Button btnLogin;

    @FXML
    TextField txtUsrName;

    @FXML
    TextField txtPassword;

    @FXML
    void handleLogin(ActionEvent event){
        String username = txtUsrName.getText();
        String password = txtPassword.getText();
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
