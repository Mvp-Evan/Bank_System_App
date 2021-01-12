package CheckBalance;

import LogIn.LogInController;
import LogIn.UserAccount;
import MainScene.MainSceneMain;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class BalanceSceneController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label balance;
    UserAccount usertest1 = LogInController.user;
    @FXML
    void AccountBalance(MouseEvent event) {
        balance.setText(Integer.toString(usertest1.getAccountBalance()));
    }

    @FXML
    void backToMainScene(MouseEvent event) throws Exception {
        MainSceneMain mainScene = new MainSceneMain();
        mainScene.showWindow();
        Stage stage = (Stage) balance.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert balance != null : "fx:id=\"balance\" was not injected: check your FXML file 'BalanceScene.fxml'.";

    }
}
