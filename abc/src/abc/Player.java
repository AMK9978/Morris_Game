package abc;

import static abc.FXMLDocumentController.player;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;

public class Player {
        public int ad=0;
        Board b1[][]=new Board[][]{{Board.board[1],Board.board[2],Board.board[3]},{Board.board[4],Board.board[5],Board.board[6]},{Board.board[7],Board.board[8],Board.board[9]}};
        Board b2[][]=new Board[][]{{Board.board[1],Board.board[4],Board.board[7]},{Board.board[10],Board.board[11],Board.board[12]},{Board.board[22],Board.board[19],Board.board[16]}};
        Board b3[][]=new Board[][]{{Board.board[9],Board.board[6],Board.board[3]},{Board.board[13],Board.board[14],Board.board[15]},{Board.board[18],Board.board[21],Board.board[24]}};
        Board b4[][]=new Board[][]{{Board.board[16],Board.board[17],Board.board[18]},{Board.board[19],Board.board[20],Board.board[21]},{Board.board[22],Board.board[23],Board.board[24]}};        
        Board barr[][][]=new Board[][][]{b1,b2,b3,b4};
        Board barr2[][]=new Board[3][3];
    public int pfree=12;
    public boolean wanttodelete=false;
    public int pnum=12;
    public String name;
    public int score;
    int ps[]=new int[]{0,0};
    
    public ArrayList<Board> houses=new ArrayList();
    public ArrayList<Board> houses2=new ArrayList();
    Player(String s,int sc,int cp)
    {
        score=sc;
        name=s;
    }

    public void checker(){
        
        for (int i = 0; i < 25; i++) {
            Board.board[i].tic=false;
        }
        for (int i = 0; i < 4; i++) {
           barr2= barr[i];
            for (int j = 0; j < 3; j++) {
                if(barr2[j][0].owner!=null){
                       if (barr2[j][0].owner==barr2[j][1].owner) {
                            if (barr2[j][1].owner==barr2[j][2].owner) {
                               barr2[j][0].tic=true;
                               barr2[j][1].tic=true;
                               barr2[j][2].tic=true;
                           }
                        }
            }
            }
        for (int j = 0; j < 3; j++) {
            if (barr2[0][j].owner!=null) {
            if (barr2[0][j].owner==barr2[1][j].owner) {
                            if (barr2[1][j].owner==barr2[2][j].owner) {
                               barr2[0][j].tic=true;
                               barr2[1][j].tic=true;
                               barr2[2][j].tic=true;
                           }
                        }
            }
        }
        }
    }
    public boolean Ticfind(Board b){
        checker();
        
    for (int i = 0; i < 4; i++) {
           barr2= barr[i];
        for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                
                if (barr2[j][k]==b) {
                //proccess
                int n=0;
                    for (int l = 0; l < 3; l++) {
                       if (b.owner==barr2[j][l].owner) {
                        n++;    
                       }
                    }
                    if (n==3) {
                        for (int l = 0; l < 3; l++) {
                            barr2[j][l].tic=true;
                        }
                        
                        //music plays
                        //Time Increase
                        
                        
                        return true;
                    }
                
            }
            }
            
            }
         for (int j = 0; j < 3; j++) {
            for (int k = 0; k < 3; k++) {
                if (barr2[k][j]==b) {
                //proccess
                int n=0;
                    for (int l = 0; l < 3; l++) {
                        
                        if (barr2[l][j].owner==b.owner) {
                        n++;    
                        }
                    }
                    if (n==3) {
                        for (int l = 0; l < 3; l++) {
                            barr2[l][j].tic=true;
                        }
                        //music plays
                        //Time Increase
                        
                        
                        return true;
                    }
                
            }
            }
            
            }
        }
    
    return false;
    }
    public boolean Wanttomove(Player player,Board b){
    
        if (b.isocc==true) {
            if (b.owner==player) {
                return true;
            }
        }
        
    return false;
    }
    public boolean Choose(Player player,Board b){
     if (b.isocc==false) {
            b.isocc=true;
            b.owner=player;
            player.houses.add(b);
            player.pfree--;
            
            if (Ticfind(b)) {
                player.wanttodelete=true;
            }
            return true;
        }
    
    return false;
    }
    public boolean Delete(Player player[],Board b,int cp){
        int a=0;
        if (b.isocc) {
            
            if (b.owner!=player[cp]) {
              
                if (b.tic==false) {
                    b.isocc=false;
                    b.owner=null;
                    b.pic.setImage(null);
                    player[cp].wanttodelete=false;
                    
                    if (ad==1) {
                        Board.Return(player,cp);
                        ad=0;
                    }
                    
                    if (cp==0) {
                        player[1].pnum--;
                        player[1].houses.remove(b);
                    }else{
                        player[0].pnum--; 
                        player[0].houses.remove(b);
                    }
                    
                    if (Gamecon(player,cp)==false) {
                        
                        try{
                           Parent p=FXMLLoader.load(getClass().getResource("table.fxml"));
                           Stage stage=new Stage(StageStyle.DECORATED);
                           stage.setTitle("Scores");
                           stage.setScene(new Scene(p));
                           stage.show();
                           TableController.mystage=stage;
                           music();
                           FXMLDocumentController.mystage.hide();
                        }catch(Exception e){System.err.print("Error");}
                        
                    }
                    
                    return true;
                }
            }
        }
       return false;
    }
     public static void music() 
    {       
        File file = new File("src\\abc\\victory.au");
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            audioClip.start();
        }
        catch(Exception e){System.err.print("Not");}
    }
    public boolean Gamecon(Player player[],int cp){
            if (player[0].pnum==2) {
                player[0].score-=1;
                player[1].score+=3;
                //player[0] lost
                //Put Scores into DB
                //Sort and Put Top5 Names and Scores in TableController
                putscore(player);
                //backing datas to earlier
                
                
                return false;
            }
            if (player[1].pnum==2) {
                player[0].score+=3;
                player[1].score-=1;
                //player[1] lost
                //Put Scores into DB
                //Sort and Put Top5 Names and Scores in TableController
                putscore(player);
                
                //
                
                return false;
            }
        
    return true;
    }
    public boolean Move(Player player[],Board b,Board h,int cp){
    
        //We must check Accessibility condition for moving from h to b here
        if (b.isocc==false) {
            for (int i = 0; i < 4; i++) {
               barr2= barr[i];
               for (int j = 0; j < 3; j++) {
                 for (int k = 0; k < 3; k++) {
                      if (barr2[j][k]==h) {
                          try{
                               if (barr2[j][k-1]==b) {
                                    player[cp].houses.remove(h);
                                    h.isocc=false;
                                    h.owner=null;
                                    h.tic=false;
                                    h=null;
                                    player[cp].houses.add(b);
                                    b.isocc=true;
                                    b.owner=player[cp];
                                    if (Ticfind(b)) {
                                        player[cp].wanttodelete=true;
                                    }
                                    
                                    return true;
                               }
                           
                           }catch(Exception e){}
                           try{
                               if (barr2[j][k+1]==b) {
                                   player[cp].houses.remove(h);
                                   h.isocc=false;
                                    h.owner=null;
                                    h.tic=false;
                                    h=null;
                                    
                                    player[cp].houses.add(b);
                                    b.isocc=true;
                                    b.owner=player[cp];
                                    if (Ticfind(b)) {
                                        player[cp].wanttodelete=true;
                                    }
                                    return true;
                           }
                           
                        }catch(Exception e2){}
                        }
                    }
                }
                for (int j = 0; j < 3; j++) {
                   for (int k = 0; k < 3; k++) {
                         if (barr2[k][j]==h) {
                           //proccess
                           try{
                               if (barr2[k-1][j]==b) {
                                   
                                    player[cp].houses.remove(h);
                                    h.isocc=false;
                                    h.owner=null;
                                    h.tic=false;
                                    h=null;
                                    player[cp].houses.add(b);
                                    b.isocc=true;
                                    b.owner=player[cp];
                                    if (Ticfind(b)) {
                                        player[cp].wanttodelete=true;
                                    }
                                    
                                    return true;
                               }
                           
                           }catch(Exception e){}
                           try{
                               if (barr2[k+1][j]==b) {
                                    player[cp].houses.remove(h);
                                    h.isocc=false;
                                    h.owner=null;
                                    h.tic=false;
                                    h=null;
                                    player[cp].houses.add(b);
                                    b.isocc=true;
                                    b.owner=player[cp];
                                    if (Ticfind(b)) {
                                        player[cp].wanttodelete=true;
                                    }
                                    return true;
                           }
                           
                        }catch(Exception e2){}
                    }
            
                }
            } 
        }
        
     }
    return false;
    }
    public boolean AccessMove(){
        int turns;
        if (houses.isEmpty()) {
            return true;
        }
        //We can be sure that current player has house
        //We want to check all of his houses
        for (int i = 0; i < houses.size(); i++) {
            System.out.print(houses.get(i).index+" ");
        }
        for (int m = 0; m < houses.size(); m++) {   
            turns=0;
            for (int i = 0; i < 4; i++) {
            //Houses was divided into 4 arrays and we check all of them
                barr2=barr[i];
                for (int j = 0; j < 3; j++) {
                     for (int k = 0; k < 3; k++) {
                        if (houses.get(m)==barr2[k][j]) {//processing on the a house starts
                            ArrayList<Board>b=new ArrayList<>();//to contain it's neighbours
                            try{
                                 b.add(barr2[k-1][j]);
                            }catch(Exception e){}
                            try{
                                b.add(barr2[k+1][j]);
                            }catch(Exception e){}
                            try{
                                b.add(barr2[k][j-1]);
                            }catch(Exception e){}
                            try{
                                b.add(barr2[k][j+1]);
                            }catch(Exception e){}
                            //Maximum of a house neighbours is 4 houses
                            //All of it's neighbours are saved to checked
                            for (int l = 0; l < 4; l++) {
                                try {
                                    if (b.get(l).isocc==false) {
                                    //means that one house exists that's not occupied
                                        System.out.println("current house: "+houses.get(m).index+houses.get(m).owner.name);
                                        System.out.println("free house: "+b.get(l).index+b.get(l).owner);
                                        return true;
                                    }
                                } catch (Exception e) {}
                            }
                            //Whene compiler becomes here means that the house finded but It had no neighbours
                            //So it's essential to check another array of 4 array to check has any neighbour?
                            if (turns!=1) {
                                turns=1;
                            }
                        }
                    }    
                }
            }    
        }  
        
        //means that current player has no neighbours that are non occupied
        player[0].score+=1;
        player[1].score+=1;
        //So scores must be sended to DB
        putscore(player);
        try{
            Parent p=FXMLLoader.load(getClass().getResource("table.fxml"));
            Stage stage=new Stage(StageStyle.DECORATED);
            stage.setTitle("Scores");
            stage.setScene(new Scene(p));
            stage.show();
            TableController.mystage=stage;
            FXMLDocumentController.mystage.hide();
            //Put Scores into DB
            }catch(Exception e){System.err.print("Error");}
                        
       return false;
    }
    
    public boolean AccessDelete(){
        int a=0;
        for (int i = 0; i < houses.size(); i++) {
            if (houses.get(i).tic==true) {
                a++;
            }
        }
        if (a==houses.size()) {
            for (int i = 0; i < houses.size(); i++) {
                houses.get(i).tic=true;
            }
            ad=1;
            return false;
        }
        return true;
    }
    
    public static void putscore(Player player[]){
        
        for (int i = 0; i < 25; i++) {
                            Board.board[i].isocc=false;
                            Board.board[i].owner=null;
                            Board.board[i].pic=null;
                            Board.board[i].tic=false;
                    }
        
        player[0].pnum=12;
        player[0].wanttodelete=false;
        player[0].ad=0;
        player[0].houses.clear();
        player[0].pfree=12;
        player[1].pnum=12;
        player[1].wanttodelete=false;
        player[1].ad=0;
        player[1].houses.clear();
        player[1].pfree=12;
        
        String n=player[0].name;
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
                        System.out.println(n+" : "+player[0].score);
                        stmt.executeUpdate("update playerinfo set score='"+player[0].score+"'"
                        +"where name='"+n+"'");
                        System.out.println("Successful");
                        
		}catch(Exception e) {System.out.println("Coudl'nt connect to db");}
                
         n=player[1].name;
        //we must define pattern for validation of email address
        con=null;
		try {
			String name="sql11230376";
			String pass="UHdfH9c7vf";
			String url="jdbc:mysql://sql11.freemysqlhosting.net/sql11230376";
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			con=DriverManager.getConnection(url,name,pass);
			Statement stmt=con.createStatement();
			ResultSet res=null;
                        System.out.println(n+" : "+player[1].score);
                        stmt.executeUpdate("update playerinfo set score='"+player[1].score+"'"
                        +"where name='"+n+"'");
                        System.out.println("Successful");
                        
		}catch(Exception e) {System.out.println("Coudl'nt connect to db");}
		finally {
			//backing datas to earlier
                        
                        
			if(con!=null) {try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}}
		}        
    }

}