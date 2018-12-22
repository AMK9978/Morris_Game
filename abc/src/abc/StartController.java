package abc;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class StartController implements Initializable {

    public static Stage mystage;
    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private Button exit;
    @FXML
    private Button toturial;
    @FXML
    private Button aboutme;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    }    

    @FXML
    private void onlogin(MouseEvent event) {
        Abc.btnsound();
                try{
                    Parent p=FXMLLoader.load(getClass().getResource("login.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Login");
                    stage.setScene(new Scene(p));
                    stage.show();
                    LoginController.mystage=stage;
                    mystage.hide();
                    }catch(Exception e){System.err.print("Error");}
                        
    }

    @FXML
    private void onsign(MouseEvent event) {
        Abc.btnsound();
        try{
                    Parent p=FXMLLoader.load(getClass().getResource("signup.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("SignUp");
                    stage.setScene(new Scene(p));
                    stage.show();
                    SignupController.mystage=stage;
                    mystage.hide();
                    }catch(Exception e){System.err.print("Error");}
                      
        
    }

    @FXML
    private void onexit(MouseEvent event) {
        System.exit(1);
    }

    @FXML
    private void ontutorial(MouseEvent event) {
        Abc.btnsound();
         try{
                    Parent p=FXMLLoader.load(getClass().getResource("tutorial.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Tutorial");
                    stage.setScene(new Scene(p));
                    stage.show();
                    TutorialController.mystage=stage;
                    mystage.hide();
                    }catch(Exception e){System.err.print("Error");}
        
    }

    @FXML
    private void onaboutme(MouseEvent event) {
        Abc.btnsound();
        
        try{
                    Parent p=FXMLLoader.load(getClass().getResource("Aboutme.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("About Me");
                    stage.setScene(new Scene(p));
                    stage.show();
                    AboutmeController.mystage=stage;
                    mystage.hide();
                    }catch(Exception e){System.err.print("Error");}
        
    }
    
}
