package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class gameovercontroller {
    Stage stage;
    Parent p;
    Scene scene;
    gameovercontroller c;
    public gameovercontroller()
    {
        this.stage=MainController.stage;

    }
    @FXML
    protected void usestars() throws IOException {
        int points=Pause.g.pointsLabel.getPoints();
        if(points>=5){
            //System.out.println("ddd");
            if(points==5){
                points=0;
            }
            else{
                points=points-5;
            }
//            Pause.g.pointsLabel.setPoints(points);
            MainController m=new MainController(points);
        }
        else{
            Alert a=new Alert(Alert.AlertType.WARNING);
            a.setContentText("Not enough stars ");
            a.show();
            //System.out.println("Not enough stats ");
        }
    }


    @FXML
    protected void restart() throws IOException {
        MainController.resume=true;
        MainController m=new MainController();

    }
    public void loadscreen(){
        try {
            p=FXMLLoader.load(getClass().getResource("gameover.fxml"));

            Label score = (Label) p.lookup("#score");
            score.setText(Integer.toString(Pause.g.pointsLabel.getPoints()*2));
            Label stars = (Label) p.lookup("#stars");
            stars.setText(Integer.toString(Pause.g.pointsLabel.getPoints()));
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
    @FXML
    public void exitgame() throws IOException {
        MainController m=new MainController(MainController.stage);

    }



}

