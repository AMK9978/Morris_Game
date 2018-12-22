/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Launcher
 */
public class Start2Controller implements Initializable {

    public static Stage mystage;
    @FXML
    private Button signup;
    @FXML
    private Button login;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onsign(MouseEvent event) {
        Abc.btnsound();
        try{
                    Parent p=FXMLLoader.load(getClass().getResource("sign2.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Second Player");
                    stage.setScene(new Scene(p));
                    stage.show();
                    Sign2Controller.mystage=stage;
                    mystage.hide();    
                    }catch(Exception e){System.err.print("Error");}
                      
    }

    @FXML
    private void onlogin(MouseEvent event) {
        Abc.btnsound();
        try{
                    Parent p=FXMLLoader.load(getClass().getResource("login2.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Login");
                    stage.setScene(new Scene(p));
                    stage.show();
                    Login2Controller.mystage=stage;
                    mystage.hide();    
                    }catch(Exception e){System.err.print("Error");}
                      
    }

    @FXML
    private void onback(MouseEvent event) {
        Abc.btnsound();
        //go to start and delete logination or signation up of first player
        try{
                    Parent p=FXMLLoader.load(getClass().getResource("start.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Start");
                    stage.setScene(new Scene(p));
                    stage.show();
                    StartController.mystage=stage;
                    mystage.hide();    
                    }catch(Exception e){System.err.print("Error");}
                      
        
    }
    
}
