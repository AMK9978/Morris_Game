/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import static abc.TableController.mystage;
import java.net.URL;
import java.util.ResourceBundle;
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
public class TutorialController implements Initializable {

    public static Stage mystage;
    @FXML
    private ImageView back;
    
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
    
}
