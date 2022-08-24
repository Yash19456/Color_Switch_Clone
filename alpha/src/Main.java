package sample;


import javafx.application.Application;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        initUI(stage);
    }

    private void initUI(Stage stage) throws IOException {
        try{
            getdata gameread=new getdata();
            gameread.read();
            MainController m=new MainController(stage);

        }
        catch(Exception e){
            System.out.println(e);

        }


    }





    public static void main(String[] args) {
        String path = "src\\resources\\background.mp3";
        MusicPlayer m = new MusicPlayer(path,true);
        m.music_player.setVolume(0.5);
        Thread t1 = new Thread(m);
        t1.start();
        launch(args);
    }
}