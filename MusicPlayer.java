package sample;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class MusicPlayer implements Runnable {
    Media music;
    public MediaPlayer music_player;
    String path;
    boolean infinite;
    MusicPlayer(String p, boolean i ){
        this.path = p;
        this.music = new Media(new File(path).toURI().toString());
        this.music_player = new MediaPlayer(music);
        this.infinite = i;
//        if(this.infinite == true){
//            infinitePlay();
//        }
    }

    @Override
    public void run() {
        music_player.setAutoPlay(true);
        if(this.infinite == true){
            infinitePlay();
        }
    }
    public void infinitePlay(){
        music_player.setOnEndOfMedia(new Runnable() {
            @Override
            public void run() {
                music_player.seek(Duration.ZERO);
            }
        });
    }
}