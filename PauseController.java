package sample;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class PauseController {

    Parent p;
    Stage stage;
    Gameplay g;
    Scene scene;
    static ArrayList<savegame> gamelist=new ArrayList<>();

    public PauseController(){
        stage=MainController.stage;


    }
    public void exitgame() throws IOException {
        MainController m=new MainController(MainController.stage);

    }
    public void loadgame() throws IOException, ClassNotFoundException {
        savegame save=new savegame();
        save.setpos();
        if(glist.gameslist==null){
            glist.gameslist=new ArrayList<>();
            //System.out.println("size is : "+glist.gameslist.size());
            glist.gameslist.add(save);
            //System.out.println("After adding size is : "+glist.gameslist.size());
        }
        else{
            //System.out.println("size is : "+glist.gameslist.size());
            glist.gameslist.add(save);
            //System.out.println("After adding size is : "+glist.gameslist.size());
        }
        Alert a=new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(" Game saved ");
        a.show();
    }
    public void resumegame(){
        //System.out.println("g in pause is : "+Pause.g.scene);
        //Pause.g.
        MainController.stage.setScene(Pause.g.scene);

    }
    public void restartgame() throws IOException {
        MainController.resume=true;
        MainController m=new MainController();


    }
    public void loadscreen(){
        try {
            p=FXMLLoader.load(getClass().getResource("pause.fxml"));
            scene = new Scene(p,700,700, Color.BLACK);
            stage.setScene(scene);
            stage.setTitle("Color Switch ");
            stage.show();
        }
        catch(Exception e){
            System.out.println("Exception is : "+e);
            e.printStackTrace();
        }

    }





}
