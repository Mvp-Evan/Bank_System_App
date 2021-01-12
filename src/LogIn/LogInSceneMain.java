package LogIn;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LogInSceneMain extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../LogIn/LogInScene.fxml"));
        primaryStage.setTitle("Bank System");
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

    public void Close() {
        Stage stage = new Stage();
        try{
            stage.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
