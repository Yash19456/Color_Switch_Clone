package sample;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class MainController {
    protected Scene scene;
    static Stage stage=new Stage();
    Gameplay game;
    PauseController pause;
    static boolean resume=false;
    Pause pausefunc=new Pause();
    public  MainController() throws IOException {
        pause=new PauseController();
        Pause.stage =MainController.stage;
        game =new Gameplay(0);
        game.stage=MainController.stage;
        game.pause=pause;
        Pause.g =game;
        //System.out.println("g is in maien  : "+game.scene);
        if(resume){
            MainController.resume=false;
            game.play();
        }
    }
    public  MainController(int points) throws IOException {
        //System.out.println("POINTS ARE : "+points);
        pause=new PauseController();
        Pause.stage =MainController.stage;
        game =new Gameplay(points);
        game.stage=MainController.stage;
        game.pause=pause;
        Pause.g =game;
        //System.out.println("g is in maien  : "+game.scene);
        game.play();

    }
    public MainController(Stage stage) throws IOException {
        try{
            MainController.stage = stage;
            Parent p= FXMLLoader.load(getClass().getResource("start.fxml"));
            Scene scene = new Scene(p,700,700, Color.BLACK);
            stage.setScene(scene);
            stage.setTitle("Color Switch ");
            stage.show();
        }
        catch(Exception e){
            System.out.println(e);

        }

    }

    @FXML
    protected void playgame() {
        try{
            game.play();

        }
        catch(Exception e){
            System.out.println(e);

        }

    }

    @FXML
    protected void disptotalstats() throws IOException, ClassNotFoundException {
        TotalstatsController t=new TotalstatsController(1,2);
    }

    @FXML
    protected void loadgame() throws IOException, ClassNotFoundException {

        if(glist.gameslist==null){
            Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("No games saved ");
            a.show();
            //System.out.println("No games avialable ");
        }
        else{
            loadgame l=new loadgame();
            l.display();

        }


//        if(glist.gameslist!=null){
//            for(int i=0;i<glist.gameslist.size();i++){
//                System.out.println("OHH");
//                System.out.println(glist.gameslist.get(i).toString());
//            }
//
//        }
//        Scanner in=new Scanner(System.in);
//        int choice=in.nextInt();
//        savegame choicegame=glist.gameslist.get(choice);


    }
    @FXML
    protected  void exitgame() throws IOException, ClassNotFoundException {
        getdata write=new getdata();
        write.write();
        System.exit(0);
    }

}