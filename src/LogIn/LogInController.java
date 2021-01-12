package LogIn;

import CreatAccount.CreatAccountMain;
import MainScene.MainSceneMain;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class LogInController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField idNumber;

    @FXML
    private PasswordField passport;

    public static UserAccount user = new UserAccount();
    public UserData userData = new UserData();

    @FXML
    void logIn(MouseEvent event) throws Exception {
        String id = idNumber.getText();
        String key = passport.getText();

        user = userData.getUserAccountById(id, key);

        if(!userData.isFoundUser()){
            idNumber.setText("");
            passport.clear();
            idNumber.setPromptText("Can't found, ID or passport was wrong");
        }
        else{
            MainSceneMain mainScene = new MainSceneMain();
            mainScene.showWindow();
            Stage stage = (Stage) idNumber.getScene().getWindow();
            stage.close();
            //LogInSceneMain logInScene = new LogInSceneMain();
            //logInScene.Close();
        }

    }

    @FXML
    void logOn(MouseEvent event) throws Exception {
        CreatAccountMain creatAccount = new CreatAccountMain();
        creatAccount.showWindow();
        Stage stage = (Stage) idNumber.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert idNumber != null : "fx:id=\"idNumber\" was not injected: check your FXML file 'LogInScene.fxml'.";
        assert passport != null : "fx:id=\"passport\" was not injected: check your FXML file 'LogInScene.fxml'.";

    }
}
