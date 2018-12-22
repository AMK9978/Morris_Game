 package abc;

import static abc.Player.music;
import static abc.Player.putscore;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

/**
 *
 * @author Launcher
 */

public class FXMLDocumentController implements Initializable {
    
    public static Stage mystage;
    private Label label;
    @FXML
    private ImageView btn1;
    @FXML
    private ImageView btn2;
    @FXML
    private ImageView btn3;
    @FXML
    private ImageView btn4;
    @FXML
    private ImageView btn5;
    @FXML
    private ImageView btn6;
    @FXML
    private ImageView btn7;
    @FXML
    private ImageView btn8;
    @FXML
    private ImageView btn9;
    @FXML
    private ImageView btn10;
    @FXML
    private ImageView btn11;
    @FXML
    private ImageView btn12;
    @FXML
    private ImageView btn13;
    @FXML
    private ImageView btn14;
    @FXML
    private ImageView btn15;
    @FXML
    private ImageView btn16;
    @FXML
    private ImageView btn17;
    @FXML
    private ImageView btn18;
    @FXML
    private ImageView btn19;
    @FXML
    private ImageView btn20;
    @FXML
    private ImageView btn21;
    @FXML
    private ImageView btn22;
    @FXML
    private ImageView btn23;
    @FXML
    private ImageView btn24;
    @FXML
    private Label pfreelbl;
    @FXML
    private Label msg;
    
     public static void pmusic(int n) 
    {       
        //File file = new File("src\\procc.au");
        File f[]=new File[]{new File("src\\abc\\p1.au"),new File("src\\abc\\p2.au")};
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(f[n]);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();
        }
        catch(Exception e){System.err.print("Not");}
    }    
    @FXML
    private ImageView resign;
    @FXML
    private Label time;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        player[0].name=Game.name[0];
        player[0].score=Game.score[0];
        player[1].name=Game.name[1];
        player[1].score=Game.score[1];
       msg.setText(player[0].name+" , Start!");
      
       
       
       
    }    
    
    static Player player[]=new Player[]{new Player(Game.name[0],Game.score[0],0),new Player(Game.name[1],Game.score[1],1)};
    public static int cp=0;
    String imgs[]=new String[]{"wp4.png","wp6.png"};
    String imgs2[]=new String[]{"wp41.png","wp61.png"};
    Board homes;
    static int oi=60;
    
    public void process(Board b){
        System.out.println(Game.name[0]+" : "+Game.score[0]);
        System.out.println(Game.name[1]+" : "+Game.score[1]);
        pmusic(cp);
        if (player[cp].wanttodelete==false) {//means that I don't want to delete the piece of this house
            //Move method or Choose method?
            if (player[cp].pfree>0) {// Choose() method Actives
                if (player[cp].Choose(player[cp],b)) {//Choose() proccessing was Successful
                      Image image=new Image(getClass().getResourceAsStream(imgs[cp]));
                      b.pic.setImage(image);
                      
                       if(player[cp].wanttodelete==false){//It's possible that after puting piece,Dooz happend
                            if(cp==0){
                                cp=1;
                                player[cp].AccessMove();
                                msg.setText(player[cp].name+" Move!");
                                pfreelbl.setText(Integer.toString(player[cp].pnum)+" , "+Integer.toString(player[cp].pfree));
                            }
                            else{
                                cp=0;
                                player[cp].AccessMove();
                                msg.setText(player[cp].name+" Move!");
                                pfreelbl.setText(Integer.toString(player[cp].pnum)+" , "+Integer.toString(player[cp].pfree));
                            }
                         }else{
                           msg.setText(player[cp].name+" Delete!");
                       }
                }
            }
            else{// Move() method Actives
                  /*In the first We must recognize Player Want to move this board's piece or want to put 
                  here a piece that he caugth earlier*/
                    if (player[cp].Wanttomove(player[cp], b)) {
                        if (homes!=null) {
                           Image image=new Image(getClass().getResourceAsStream(imgs[cp]));
                           homes.pic.setImage(image);
                        }
                    Image image=new Image(getClass().getResourceAsStream(imgs2[cp]));
                    b.pic.setImage(image);
                    homes=b;
                    msg.setText(player[cp].name+" choose the destination");
                    }else if (homes!=null) {
                            //means that a piece choosed and now Player wants to put it here
                            if (player[cp].Move(player, b,homes,cp)) {//Move() proccessed Successfull
                                Image image=new Image(getClass().getResourceAsStream(imgs[cp]));
                                b.pic.setImage(image);
                                homes.pic.setImage(null);
                                homes=null;
                                if(player[cp].wanttodelete==false){//It's possible that after puting piece,Dooz happend
                                        if(cp==0){
                                                cp=1;
                                                player[cp].AccessMove();
                                                msg.setText(player[cp].name+" Move!");
                                                pfreelbl.setText(Integer.toString(player[cp].pnum)+" , "+Integer.toString(player[cp].pfree));
                                        }
                                        else{
                                            cp=0;
                                            player[cp].AccessMove();
                                            msg.setText(player[cp].name+" Move!");
                                            pfreelbl.setText(Integer.toString(player[cp].pnum)+" , "+Integer.toString(player[cp].pfree));
                                        }
                                }else{
                                        msg.setText(player[cp].name+" Delete!");
                                    }
                            }
                        }
                }
            
        }else{//Player want to Delete the piece of this house
                if (player[cp].Delete(player, b, cp)) {
                     if(cp==0){
                                cp=1;
                                player[cp].AccessMove();
                                msg.setText(player[cp].name+" Move!");
                                pfreelbl.setText(Integer.toString(player[cp].pnum)+" , "+Integer.toString(player[cp].pfree));
                            }
                            else{
                                cp=0;
                                player[cp].AccessMove();
                                msg.setText(player[cp].name+" Move!");
                                pfreelbl.setText(Integer.toString(player[cp].pnum)+" , "+Integer.toString(player[cp].pfree));
                            }
                }
            }
    }
    @FXML
    private void onbtn1(MouseEvent event) {
       
        Board b=Board.board[1];
        b.pic=btn1;
        process(b);
    }

    @FXML
    private void onresign(MouseEvent event) {
       
        if (cp==0) {
            player[0].score-=1;
            player[1].score+=3;
            //player[0] lost
            //Put Scores into DB
            //Sort and Put Top5 Names and Scores in TableController
            Player.putscore(player);
        }else{
            player[1].score-=1;
            player[0].score+=3;
            //player[1] lost
            //Put Scores into DB
            //Sort and Put Top5 Names and Scores in TableController
            Player.putscore(player);
        }
        
        try{
            Abc.btnsound();
                    Parent p=FXMLLoader.load(getClass().getResource("table.fxml"));
                    Stage stage=new Stage(StageStyle.DECORATED);
                    stage.setTitle("Scores");
                    stage.setScene(new Scene(p));
                    stage.show();
                    Player.music();
                    TableController.mystage=stage;
                    FXMLDocumentController.mystage.hide();
                    //Put Scores into DB
                    }catch(Exception e){System.err.print("Error");}
    }

    @FXML
    private void onbtn2(MouseEvent event) {
        Board b=Board.board[2];
        b.pic=btn2;
        process(b);
        
    }

    @FXML
    private void onbtn3(MouseEvent event) {
        Board b=Board.board[3];
        b.pic=btn3;
        process(b);
    }

    @FXML
    private void onbtn4(MouseEvent event) {
        Board b=Board.board[4];
        b.pic=btn4;
        process(b);
    }

    @FXML
    private void onbtn5(MouseEvent event) {
        Board b=Board.board[5];
        b.pic=btn5;
        process(b);
    }

    @FXML
    private void onbtn6(MouseEvent event) {
        Board b=Board.board[6];
        b.pic=btn6;
        process(b);
    }

    @FXML
    private void onbtn7(MouseEvent event) {
        Board b=Board.board[7];
        b.pic=btn7;
        process(b);
    }

    @FXML
    private void onbtn8(MouseEvent event) {
        Board b=Board.board[8];
        b.pic=btn8;
        process(b);
    }

    @FXML
    private void onbtn9(MouseEvent event) {
        Board b=Board.board[9];
        b.pic=btn9;
        process(b);
    }

    @FXML
    private void onbtn10(MouseEvent event) {
        Board b=Board.board[10];
        b.pic=btn10;
        process(b);
    }

    @FXML
    private void onbtn11(MouseEvent event) {
        Board b=Board.board[11];
        b.pic=btn11;
        process(b);
    }

    @FXML
    private void onbtn12(MouseEvent event) {
        Board b=Board.board[12];
        b.pic=btn12;
        process(b);
    }

    @FXML
    private void onbtn13(MouseEvent event) {
        Board b=Board.board[13];
        b.pic=btn13;
        process(b);
    }

    @FXML
    private void onbtn14(MouseEvent event) {
        Board b=Board.board[14];
        b.pic=btn14;
        process(b);
    }

    @FXML
    private void onbtn15(MouseEvent event) {
        Board b=Board.board[15];
        b.pic=btn15;
        process(b);
    }

    @FXML
    private void onbtn16(MouseEvent event) {
        Board b=Board.board[16];
        b.pic=btn16;
        process(b);
    }

    @FXML
    private void onbtn17(MouseEvent event) {
        Board b=Board.board[17];
        b.pic=btn17;
        process(b);
    }

    @FXML
    private void onbtn18(MouseEvent event) {
        Board b=Board.board[18];
        b.pic=btn18;
        process(b);
    }

    @FXML
    private void onbtn19(MouseEvent event) {
        Board b=Board.board[19];
        b.pic=btn19;
        process(b);
    }

    @FXML
    private void onbtn20(MouseEvent event) {
        Board b=Board.board[20];
        b.pic=btn20;
        process(b);
    }

    @FXML
    private void onbtn21(MouseEvent event) {
        Board b=Board.board[21];
        b.pic=btn21;
        process(b);
    }

    @FXML
    private void onbtn22(MouseEvent event) {
        Board b=Board.board[22];
        b.pic=btn22;
        process(b);
    }

    @FXML
    private void onbtn23(MouseEvent event) {
        Board b=Board.board[23];
        b.pic=btn23;
        process(b);
    }

    @FXML
    private void onbtn24(MouseEvent event) {
        Board b=Board.board[24];
        b.pic=btn24;
        process(b);
    }
    
}