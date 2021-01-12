package ReportLoss;

import LogIn.LogInController;
import LogIn.UserAccount;
import LogIn.UserData;
import MainScene.MainSceneMain;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class ReportLossController {
    @FXML
    private TextField userName;
    @FXML
    private TextField newPassport;
    @FXML
    private TextField confirmPassport;

    UserAccount user1 = LogInController.user;
    UserData userData1 = new UserData();

    @FXML
    public String getuserName(){return userName.getText();}

    @FXML
    public String getnewPassport(){
        return newPassport.getText();
    }

    @FXML
    public String getconfirmPassport(){return confirmPassport.getText();}

    @FXML
    public void change(ActionEvent actionEvent) {
    	String un=getuserName();
    	String np=getnewPassport();
    	String cp=getconfirmPassport();
    	JOptionPane.showMessageDialog(null, user1.getUserName());
    	if(user1.getUserName().equals(un)) {
        if(np.equals(cp))
        {
        	JOptionPane.showMessageDialog(null, "Password reset successfully! ");
        	user1.setPassport(np);
            try {
				userData1.changeUserAccount(user1);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        }
        else
        {
            emptyAll();
            JOptionPane.showMessageDialog(null, "Your New and Verified passwords do not match, try again. ");
        }
    }
    	else {
    		emptyAll();
    		JOptionPane.showMessageDialog(null, "Wrong User Name ");
    	}
    }
    @FXML
    public void emptyAll(ActionEvent actionEvent) {
    	userName.setText("");
    	newPassport.setText("");
    	confirmPassport.setText("");
    }
    public void emptyAll() {
    	userName.setText("");
    	newPassport.setText("");
    	confirmPassport.setText("");
    }


    @FXML
    public void backToMainScene(ActionEvent actionEvent) throws Exception {
        MainSceneMain mainScene = new MainSceneMain();
        mainScene.showWindow();
        Stage stage = (Stage) userName.getScene().getWindow();
        stage.close();
    }
}
