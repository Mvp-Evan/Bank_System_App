package DrawMoney;

import LogIn.LogInController;
import LogIn.UserAccount;
import LogIn.UserData;
import MainScene.MainSceneMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DrawMoneyController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label accountBalance;

    @FXML
    private TextField withdrawalAmount;

    UserAccount user = LogInController.user;
    UserData userData = new UserData();

    @FXML
    void backToMainScene(MouseEvent event) throws Exception {
        MainSceneMain mainScene = new MainSceneMain();
        mainScene.showWindow();
        Stage stage = (Stage) accountBalance.getScene().getWindow();
        stage.close();
    }

    @FXML
    void drawMoney(MouseEvent event) throws IOException {
        int money = Integer.parseInt(withdrawalAmount.getText());
        money = user.getAccountBalance() - money;
        if(money > 0){
            user.setAccountBalance(money);
            userData.changeUserAccount(user);

            accountBalance.setText(Integer.toString(money));
            withdrawalAmount.clear();
        }
        else {
            withdrawalAmount.clear();
            withdrawalAmount.setPromptText("Not enough");
        }
    }

    @FXML
    void initialize() {
        assert accountBalance != null : "fx:id=\"accountBalance\" was not injected: check your FXML file 'DrawMoneyScene.fxml'.";
        assert withdrawalAmount != null : "fx:id=\"withdrawalAmount\" was not injected: check your FXML file 'DrawMoneyScene.fxml'.";

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        accountBalance.setText(Integer.toString(user.getAccountBalance()));
    }
}
