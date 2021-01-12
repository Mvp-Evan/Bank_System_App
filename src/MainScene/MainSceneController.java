package MainScene;

import CheckBalance.BalanceSceneMain;
import DrawMoney.DrawMoneyMain;
import Freeze.FreezeMain;
import MakeDeposit.MakeDepositMain;
import ReportLoss.ReportLossMain;
import Transform.TransformMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainSceneController {

    @FXML
    private AnchorPane mainScene;

    public void checkBalance(ActionEvent actionEvent) throws Exception{
        BalanceSceneMain balanceScene = new BalanceSceneMain();
        balanceScene.showWindow();
        Stage stage = (Stage) mainScene.getScene().getWindow();
        stage.close();
    }

    public void drawMoney(ActionEvent actionEvent) throws Exception {
        DrawMoneyMain drawMoney = new DrawMoneyMain();
        drawMoney.showWindow();
        Stage stage = (Stage) mainScene.getScene().getWindow();
        stage.close();
    }

    public void transForm(ActionEvent actionEvent) throws Exception {
        TransformMain transform = new TransformMain();
        transform.showWindow();
        Stage stage = (Stage) mainScene.getScene().getWindow();
        stage.close();
    }

    public void saveMoney(ActionEvent actionEvent) throws Exception {
        MakeDepositMain makeDeposit = new MakeDepositMain();
        makeDeposit.showWindow();
        Stage stage = (Stage) mainScene.getScene().getWindow();
        stage.close();
    }

    public void freezeOrThaw(ActionEvent actionEvent) throws Exception {
        FreezeMain freeze= new FreezeMain();
        freeze.showWindow();
        Stage stage = (Stage) mainScene.getScene().getWindow();
        stage.close();
    }

    public void reportALoss(ActionEvent actionEvent) throws Exception {
        ReportLossMain reportLoss = new ReportLossMain();
        reportLoss.showWindow();
        Stage stage = (Stage) mainScene.getScene().getWindow();
        stage.close();
    }

    @FXML
    void initialize() {
        assert mainScene != null : "fx:id=\"mainScene\" was not injected: check your FXML file 'MainScene.fxml'.";

    }
}
