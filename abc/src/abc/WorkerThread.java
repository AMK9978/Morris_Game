
package abc;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Label;

public class WorkerThread extends Thread{
    Integer i=60;    
    public static int ss=0;
    FXMLDocumentController f;
    
   
    public void run(){
        System.err.println("in running");
            while(i!=0){
             System.err.println("in while");
            i--;
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WorkerThread.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println(i);
             } 
          
     
    }
    
}