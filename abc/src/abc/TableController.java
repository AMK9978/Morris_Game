package abc;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Launcher
 */
public class TableController implements Initializable {

    public static Stage mystage;
    @FXML
    private Label p1label;
    @FXML
    private Label p2abel;
    @FXML
    private Label p3label;
    @FXML
    private Label p4label;
    @FXML
    private Label p5label;
    @FXML
    private Label p1lscoreabel;
    @FXML
    private Label p2lscoreabel;
    @FXML
    private Label p3lscoreabel;
    @FXML
    private Label p4lscoreabel;
    @FXML
    private Label p5lscoreabel;
    @FXML
    private Button ok;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url2, ResourceBundle rb) {
        Label lname[]=new Label[]{p1label,p2abel,p3label,p4label,p5label};
        Label lscore[]=new Label[]{p1lscoreabel,p2lscoreabel,p3lscoreabel,p4lscoreabel,p5lscoreabel};
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
                        int j=0;
                        ArrayList<Integer>scores=new ArrayList<>();
                        while(res.next()){
                            String n=res.getString("name");
                            Integer i=res.getInt("score");
                            scores.add(i);
                            j++;
                        }
                        Statement stmt2=con.createStatement();
                        ResultSet res2=stmt2.executeQuery("select * from playerinfo");
                        String sarr[][]=new String[j][2];
                        int yoyo=0;
                        while(res2.next()){
                            String n=res2.getString("name");
                            Integer i=res2.getInt("score");
                            System.out.println(n+": "+i);
                            sarr[yoyo][0]=n;
                            sarr[yoyo][1]=Integer.toString(i);                        
                            yoyo++;
                        }
                        ArrayList<String>namha=new ArrayList<>();
                        Collections.sort(scores);
                        Collections.reverse(scores);
                        for (int i = 0; i < 5; i++) {
                            lscore[i].setText(Integer.toString(scores.get(i)));
                        }
                        for (int i = 0; i < j; i++) {
                            for (int k = 0; k < j; k++) {
                                 if (Integer.toString(scores.get(i)).equals(sarr[k][1])) {
                                        namha.add(sarr[k][0]);
                            }
                            }
                        }
                        for (int i = 0; i < 5; i++) {
                            lname[i].setText(namha.get(i));
                        }
            }catch(Exception e) {System.out.println("Coudl'nt connect to db");}
                    finally {
			
			if(con!=null) {try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
                            }
                        }
		}
        
    }
    @FXML
    private void onok(MouseEvent event) {
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
