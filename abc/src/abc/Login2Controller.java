/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package abc;

import static abc.LoginController.mystage;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Dialog;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Launcher
 */
public class Login2Controller implements Initializable {
    
    public static Stage mystage;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXTextField name;
    @FXML
    private Button back;
    @FXML
    private Button login;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void onback(MouseEvent event) {
        Abc.btnsound();
        try{
                    Parent p=FXMLLoader.load(getClass().getResource("start2.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Second Player");
                    stage.setScene(new Scene(p));
                    stage.show();
                    Start2Controller.mystage=stage;
                    mystage.hide();
                    }catch(Exception e){System.err.print("Error");}
                      
        //go to start2
    }

    @FXML
    private void onlogin(MouseEvent event) {
        Abc.btnsound();
        String n=name.getText();
        String p=pass.getText();
        Connection con=null;
		try {
			String nam="sql11230376";
			String pass="UHdfH9c7vf";
			String url="jdbc:mysql://sql11.freemysqlhosting.net/sql11230376";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(url,nam,pass);
			Statement stmt=con.createStatement();
			ResultSet res=null;
                        res=stmt.executeQuery("select * from playerinfo where name='"+n+"'");
                        if(res.next()){
                                String ps=res.getString("password");
                                if (ps.equals(p)) {
                                try{
                                        Game.name[1]=n;
                                        Game.score[1]=res.getInt("score");
                                        Parent p2=FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                                        Stage stage=new Stage(StageStyle.DECORATED);
                                        stage.setTitle("Morris Dual!");
                                        stage.setScene(new Scene(p2));
                                        stage.show();
                                        FXMLDocumentController.mystage=stage;
                                        mystage.hide();
                                        this.name.clear();
                                        this.pass.clear();
                                        return;
                                        }catch(Exception e){System.err.print("Error");}
                                }else{
                                Alert alert = new Alert(Alert.AlertType.WARNING);
                                alert.setTitle("Warning Dialog");
                                alert.setHeaderText("Look, a Warning Dialog");
                                alert.setContentText("The password is not correct");
                                return;
                                }       
                        }
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Warning Dialog");
                        alert.setHeaderText("Look, a Warning Dialog");
                        alert.setContentText("You should sign up");
                        this.name.clear();
                        this.pass.clear();
        
                }catch(Exception e2){
                    this.name.clear();
                    this.pass.clear();
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Look, a Warning Dialog");
                    alert.setContentText("Check your connection to Network");
        
                }
    }
    
}
