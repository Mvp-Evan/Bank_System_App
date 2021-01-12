package Freeze;

import MainScene.MainSceneMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class FreezeController {
    @FXML
    private TextField identityNumber;
    @FXML
    private TextField phoneNumber;
    @FXML
    private TextField verifyMessage;

    //UserAccount user = LogInController.user;
    @FXML
    public String getIdentityNumber(){return identityNumber.getText();}

    @FXML
    public int getPhoneNumber(){
        return Integer.parseInt(phoneNumber.getText());
    }

    @FXML
    public int getVerifyMessage(){return Integer.parseInt(verifyMessage.getText());}

    @FXML
    public void check(ActionEvent actionEvent) {
        //与数据库内用户信息进行核验
        if(true)
        {
            emptyAll();
        }
    }

    @FXML
    public void emptyAll(ActionEvent actionEvent) {
        identityNumber.setText("");
        phoneNumber.setText("");
        verifyMessage.setText("");
    }
    public void emptyAll() {
        identityNumber.setText("");
        phoneNumber.setText("");
        verifyMessage.setText("");
    }


    @FXML
    public void backToMainScene(ActionEvent actionEvent) throws Exception {
        MainSceneMain mainScene = new MainSceneMain();
        mainScene.showWindow();
        Stage stage = (Stage) phoneNumber.getScene().getWindow();
        stage.close();
    }
}
