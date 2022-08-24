package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AllController  {
    public Stage primaryStage=new Stage();
    private AnchorPane rootPane;
    @FXML
    protected void loadgameover(MouseEvent event) throws IOException {
        //System.out.println("This is gameover");
        Parent screen = FXMLLoader.load(getClass().getResource("gameover.fxml"));
        Scene scene = new Scene(screen,755,532,Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Over Menu ");
        primaryStage.show();
            //main.primary
    }
    @FXML
    protected void loadpause(MouseEvent event) throws IOException {
        Parent screen = FXMLLoader.load(getClass().getResource("pause.fxml"));
        Scene scene = new Scene(screen,755,532,Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Over Menu ");
        primaryStage.show();
    }
    @FXML
    protected void loadtotal(MouseEvent event) throws IOException {
        Parent screen = FXMLLoader.load(getClass().getResource("total.fxml"));
        Scene scene = new Scene(screen,755,532,Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Over Menu ");
        primaryStage.show();
    }
    @FXML
    protected void loadstart(MouseEvent event) throws IOException {
        Parent screen = FXMLLoader.load(getClass().getResource("start.fxml"));
        Scene scene = new Scene(screen,755,532,Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Over Menu ");
        primaryStage.show();
    }
    @FXML
    protected void loadgame(MouseEvent event) throws Exception {
        Game g=new Game();

        Parent screen = FXMLLoader.load(getClass().getResource("gameover.fxml"));
        Scene scene = g.getScene();
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.show();
    }

    @FXML
    protected void loadloading(MouseEvent mouseEvent) throws IOException {
        Parent screen = FXMLLoader.load(getClass().getResource("loading.fxml"));
        Scene scene = new Scene(screen,755,532,Color.BLACK);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Game Over Menu ");
        primaryStage.show();
    }
}
