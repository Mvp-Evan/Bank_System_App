package Transform;

import LogIn.LogInController;
import LogIn.UserAccount;
import LogIn.UserData;
import MainScene.MainSceneMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class TransformController implements Initializable {
    @FXML
    private TextField TargetAccountinput;

    @FXML
    private TextField Amountinput;

    @FXML
    private Label AccountBalance;

    UserAccount user1 = LogInController.user;
    UserData userData = new UserData();

    @FXML
    public void backToMainScene(ActionEvent actionEvent) throws Exception {
        MainSceneMain mainScene = new MainSceneMain();
        mainScene.showWindow();
        Stage stage = (Stage) TargetAccountinput.getScene().getWindow();
        stage.close();
    }

    @FXML
    public void transformDo(ActionEvent actionEvent) throws IOException {

        int temp=user1.getAccountBalance();
        temp-=getAmount();
        user1.setAccountBalance(temp);
        userData.changeUserAccount(user1);
        setAmount();
    }

    @FXML
    public String getTargetAccount()
    {
        return TargetAccountinput.getText();
    }

    @FXML
    public int getAmount()
    {
        int i = Integer.parseInt( Amountinput.getText());
        return i;
    }

    public void setAmount()
    {
        AccountBalance.setText(Integer.toString(user1.getAccountBalance()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        setAmount();

    }
}
