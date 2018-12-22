/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import static abc.StartController.mystage;
import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Launcher
 */
public class AboutmeController implements Initializable {
    public static Stage mystage;
    @FXML
    private ImageView back;
    @FXML
    private ImageView in;
    @FXML
    private ImageView tele;
    @FXML
    private ImageView git;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void onback(MouseEvent event) {
        try{
            Abc.btnsound();
                    Parent p=FXMLLoader.load(getClass().getResource("start.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Start");
                    stage.setScene(new Scene(p));
                    stage.show();
                    StartController.mystage=stage;
                    mystage.hide();
                    }catch(Exception e){System.err.print("Error");}
        
        
    }

    @FXML
    private void onin(MouseEvent event) {
        Abc.btnsound();
        try {
            String url="https://www.linkedin.com/in/amk9978/";
            
             Desktop.getDesktop().browse(URI.create(url));
            // TODO add your handling code here:
        } catch (Exception ex) {
        }

       
    }

    @FXML
    private void ontele(MouseEvent event) {
        Abc.btnsound();
        try {
            String url="http://t.me/amk9978";
            
             Desktop.getDesktop().browse(URI.create(url));
            // TODO add your handling code here:
        } catch (Exception ex) {
        }

    }

    @FXML
    private void ongit(MouseEvent event) {
        Abc.btnsound();
        try {
            String url="https://github.com/AMK9978";
            
             Desktop.getDesktop().browse(URI.create(url));
            // TODO add your handling code here:
        } catch (Exception ex) {
        }

    }
    
}
