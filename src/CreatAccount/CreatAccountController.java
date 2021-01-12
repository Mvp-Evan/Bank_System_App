package CreatAccount;

import LogIn.LogInController;
import LogIn.LogInSceneMain;
import LogIn.UserAccount;
import LogIn.UserData;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class CreatAccountController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField idRandom;

    @FXML
    private TextField nameInput;

    @FXML
    private TextField addressInput;

    @FXML
    private TextField passportInput;

    @FXML
    private TextField passportAffirm;

    @FXML
    private Button okButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Label logonSuccess;

    @FXML
    void backToMainScene(MouseEvent event) throws Exception {
        LogInSceneMain logInScene = new LogInSceneMain();
        logInScene.showWindow();
        Stage stage = (Stage) okButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void collectData(MouseEvent event) throws Exception {
        UserData tempUserData = new UserData();
        UserAccount tempUser = LogInController.user;

        tempUser.setId(Integer.parseInt(idRandom.getText()));
        tempUser.setUserName(nameInput.getText());
        tempUser.setAddress(addressInput.getText());
        tempUser.setPassport(passportInput.getText());

        tempUserData.setUserAccount(tempUser);

        logonSuccess.setText("Logon Successful, Back to Login");
    }

    @FXML
    void initialize() {
        assert idRandom != null : "fx:id=\"idRandom\" was not injected: check your FXML file 'CreatAccount.fxml'.";
        assert nameInput != null : "fx:id=\"nameInput\" was not injected: check your FXML file 'CreatAccount.fxml'.";
        assert addressInput != null : "fx:id=\"addressInput\" was not injected: check your FXML file 'CreatAccount.fxml'.";
        assert passportInput != null : "fx:id=\"passportInput\" was not injected: check your FXML file 'CreatAccount.fxml'.";
        assert passportAffirm != null : "fx:id=\"passportAffirm\" was not injected: check your FXML file 'CreatAccount.fxml'.";
        assert okButton != null : "fx:id=\"okButton\" was not injected: check your FXML file 'CreatAccount.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'CreatAccount.fxml'.";
        assert logonSuccess != null : "fx:id=\"logonSuccess\" was not injected: check your FXML file 'CreatAccount.fxml'.";
    }
}
