package abc;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
public class SignupController implements Initializable {

    public static Stage mystage;
    @FXML
    private JFXTextField name;
    @FXML
    private JFXPasswordField pass;
    @FXML
    private JFXTextField emai;
    @FXML
    private Button sign;
    @FXML
    private Button back;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void onsign(MouseEvent event) throws InterruptedException {
        
        String n=name.getText();
        String p=pass.getText();
        String em=emai.getText();
        //we must define pattern for validation of email address
        Connection con=null;
		try {
			String name="sql11230376";
			String pass="UHdfH9c7vf";
			String url="jdbc:mysql://sql11.freemysqlhosting.net/sql11230376";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(url,name,pass);
			Statement stmt=con.createStatement();
			ResultSet res=null;
                        res=stmt.executeQuery("select * from playerinfo");
                        Statement stmt2=con.createStatement();
			ResultSet res2=null;
                        res2=stmt2.executeQuery("select * from playerinfo where name='"+n+"'");
                        if (res2.next()) {
                            String p2=res2.getString("password");
                            if (p2.equals(p)) {
                            Dialog d=new Dialog();
                            d.setWidth(100);
                            d.setHeight(100);
                            d.setContentText(n+",You must Login");
                            d.show();
                            return;
                            }
                    }
                        stmt.executeUpdate("INSERT INTO playerinfo (name,password,email,score)"
                        +"values('"+n+"','"+p+"','"+em+"','"+0+"')");
                        
                        Game.name[0]=n;
                        Game.score[0]=0;
                        System.out.println(n);
                        System.out.println(Game.name[0]+" : "+Game.score[0]);
                        Abc.btnsound();
                        System.out.println("Successful");
                        try{
                    Parent p2=FXMLLoader.load(getClass().getResource("start2.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Second Player");
                    stage.setScene(new Scene(p2));
                    stage.show();
                    Start2Controller.mystage=stage;
                    mystage.hide();
                    }catch(Exception e){
                        System.err.print("Error");
                        this.name.clear();
                        this.emai.clear();
                        this.pass.clear();
                    }
                      
		}catch(Exception e) {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Warning Dialog");
                    alert.setHeaderText("Look, a Warning Dialog");
                    alert.setContentText("Check your connection to Network");
                    alert.showAndWait();
                    System.out.println("Coudl'nt connect to db");
                    this.name.clear();
                    this.emai.clear();
                    this.pass.clear();
                }
		finally {
			
			if(con!=null) {try {
                            
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}
        
        
    }

    @FXML
    private void onback(MouseEvent event) {
        Abc.btnsound();
        mystage.hide();
        try{
                    Parent p2=FXMLLoader.load(getClass().getResource("start.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Start");
                    stage.setScene(new Scene(p2));
                    stage.show();
                    Start2Controller.mystage=stage;
                    }catch(Exception e){System.err.print("Error");}
        mystage.hide();
    }
    
}
