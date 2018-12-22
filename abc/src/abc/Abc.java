package abc;

import java.io.File;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;

public class Abc extends Application {
    public static int s=0;
    
    public static void btnsound(){
    File file = new File("src\\abc\\spures3.au");
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
    
    public static void music() 
    {       
        File file = new File("src\\abc\\CABOI1.au");
        try{
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(Clip.class, format);
            Clip audioClip = (Clip) AudioSystem.getLine(info);
            audioClip.open(audioStream);
            FloatControl gainControl = 
            (FloatControl) audioClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-5.0f);
            audioClip.start();
        }
        catch(Exception e){System.err.print("Not");}
    }
     public  static WorkerThread w2=new WorkerThread();
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("start.fxml"));
        
        Scene scene = new Scene(root);
        stage.setScene(scene);
        music();
        StartController.mystage=stage;
        stage.show();
        
    }

   
    public static void main(String[] args) {
        launch(args);
    }
    
}
