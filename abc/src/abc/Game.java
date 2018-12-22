package abc;

import javax.swing.JOptionPane;

public class Game {
    //We shoould recieve name of players from login or Register Pages 
    public static String[] name=new String[2];
    //We should recieve scores of players from Database
    public static int score[]=new int []{0,0};
    
    public static String getname(int n){
    
        return name[n];
    
    }
    public static int getscore(int n){
    
        return score[n];
    }
    
}
