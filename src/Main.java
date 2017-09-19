import connector.*;
import gui.*;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.json.JSONObject;


public class Main extends Application implements UIListener{
    static tcpSocketHandler s;

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(this.getClass().getResource("/gui/loginUI.fxml"));

        LoginController loginController = new LoginController();
        fxmlLoader.setController(loginController);
        loginController.addUIListener(this);

        Parent root = (Parent) fxmlLoader.load(/*this.getClass().getResource("/gui.loginUI.fxml")*/);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        s = new tcpSocketHandler("127.0.0.1", 1337);
        launch(args);

    }

    @Override
    public void sendRequest(JSONObject jsonObject) {
        s.send(jsonObject.toString());
    }
    /*
    public static void main(String[] args){
        tcpSocketHandler s;
        s = new tcpSocketHandler("127.0.0.1", 1337);
        s.send("Hei på deg");
        s.disconnect();
    }*/
}
