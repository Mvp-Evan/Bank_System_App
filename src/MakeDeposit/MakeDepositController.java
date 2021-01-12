package MakeDeposit;

import LogIn.LogInController;
import LogIn.UserAccount;
import LogIn.UserData;
import MainScene.MainSceneMain;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MakeDepositController implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button oKButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button backToMainScene;

    @FXML
    private Label idOutput;

    @FXML
    private Label nameOutput;

    @FXML
    private Label addressOutput;

    @FXML
    private Label depositTypeOutput;

    @FXML
    private Label interestRateOutput;

    @FXML
    private Label figureOutput;

    @FXML
    private TextField figureInput;

    @FXML
    private ChoiceBox<String> depositType;

    UserAccount usertest = LogInController.user;
    UserData datatest = new UserData();

    @FXML
    void backToMainScene(MouseEvent event) throws Exception {
        MainSceneMain mainScene = new MainSceneMain();
        mainScene.showWindow();
        Stage stage = (Stage) oKButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    void choiceDepositType(MouseEvent event) {
        int select = depositType.getSelectionModel().getSelectedIndex();
        if(select == 0){
            usertest.setDepositType(true);
        }
    }

    @FXML
    void informationDisplay(MouseEvent event) throws IOException {
        figureOutput.setText(figureInput.getText());
        idOutput.setText(Integer.toString(usertest.getId()));
        nameOutput.setText(usertest.getUserName());
        addressOutput.setText(usertest.getAddress());
        interestRateOutput.setText(String.valueOf(usertest.getInterestRate()));

        figureInput.clear();

        usertest.setAccountBalance(usertest.getAccountBalance()+Integer.parseInt(figureOutput.getText()));
        datatest.changeUserAccount(usertest);
    }

    @FXML
    void initialize() {
        assert oKButton != null : "fx:id=\"oKButton\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert cancelButton != null : "fx:id=\"cancelButton\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert backToMainScene != null : "fx:id=\"backToMainScene\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert idOutput != null : "fx:id=\"idOutput\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert nameOutput != null : "fx:id=\"nameOutput\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert addressOutput != null : "fx:id=\"addressOutput\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert depositTypeOutput != null : "fx:id=\"depositTypeOutput\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert interestRateOutput != null : "fx:id=\"interestRateOutput\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert figureOutput != null : "fx:id=\"figueOutput\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert figureInput != null : "fx:id=\"figureInput\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";
        assert depositType != null : "fx:id=\"depositType\" was not injected: check your FXML file 'MakeDepositScene.fxml'.";

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        depositType.getItems().add("Time Deposits");
        depositType.getItems().add("Demand deposits");
    }
}


