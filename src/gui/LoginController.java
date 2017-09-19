package gui;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import org.json.JSONObject;
import connector.Socket;

public class LoginController implements Initializable{
    HashMap<String, String> values;
    List<UIListener> listeners;

    public LoginController(){
        values = new HashMap<String, String>();
        listeners = new ArrayList<UIListener>();
    }

    public void addUIListener(UIListener listener){
        listeners.add(listener);
    }

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
        values.put("username", username);
        values.put("password", password);

        JSONObject loginRequest = new JSONObject();
        loginRequest.put("request", "login");
        loginRequest.put("values", values);

        System.out.println(loginRequest.toString());

        listeners.get(0).sendRequest(loginRequest);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnLogin.setOnAction(this::handleLogin);
    }
}
