package abc;

import static abc.Player.music;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Board {
    public int index;
    
    public Player owner=null;
    public boolean tic=false;
    public boolean isocc=false;
    public ImageView pic=null;
    
    public static Board board[]=new Board[]{new Board(0),new Board(1),new Board(2),new Board(3),new Board(4),new Board(5),new Board(6),
         new Board(7),new Board(8),new Board(9),new Board(10),new Board(11),new Board(12),new Board(13),new Board(14),
         new Board(15),new Board(16),new Board(17),new Board(18),new Board(19),new Board(20),new Board(21),new Board(22),
         new Board(23),new Board(24)};
    
    Board(int n){
    index=n;
        
    }
    public  static void Return(Player player[],int cp){
    
        if (cp==0) {
            for (int i = 0; i < player[1].houses.size(); i++) {
                player[1].houses.get(i).tic=true;
            }
        }else{
        for (int i = 0; i < player[0].houses.size(); i++) {
                player[0].houses.get(i).tic=true;
            }
        }
    
    }
  
}
