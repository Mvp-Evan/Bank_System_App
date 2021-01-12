package MakeDeposit;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MakeDepositMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("MakeDepositScene.fxml"));
        primaryStage.setTitle("MakeDeposit");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public void  showWindow() throws Exception {
        Stage stage = new Stage();
        try{
            start(stage);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
