package ReportLoss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ReportLossMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("ReportLossScene.fxml"));
        primaryStage.setTitle("Report the Loss");
        primaryStage.setScene(new Scene(root, 600, 400));
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
