package sample;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.ListView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import static javafx.scene.paint.Color.BLACK;


public class loadgame {
    Stage stage;
    Scene scene;
    public loadgame(){
        stage=MainController.stage;
    }

    public void display() throws FileNotFoundException {
        AnchorPane gamePane=new AnchorPane();
        gamePane.setStyle("-fx-background-color: black;");
        Image image =new Image("resources/home.png");
        ImageView view=new ImageView(image);
        Image csback=new Image("resources/csback.png");
        ImageView view2=new ImageView(csback);
        view.setFitHeight(69);
        view.setFitWidth(69);
        view.setX(20);
        view.setY(450);
        view2.setY(450);
        view2.setX(150);
        view2.setFitWidth(369);
        view2.setFitHeight(169);
        HBox hor=new HBox();
        //hor.setFillHeight(true);
        hor.getChildren().add(view);
        ListView<savegame> gamelist=new ListView<>();
        ObservableList<savegame> savedlist= FXCollections.observableArrayList(glist.gameslist);
        gamelist.setItems(savedlist);
        gamelist.setStyle("-fx-background-color: black;");
//        gamelist.setMaxHeight(500);
        gamelist.setMaxSize(700,700);
        VBox items=new VBox();
        items.setMinWidth(700);
//        items.setFillWidth();
        items.setSpacing(100);
        items.getChildren().add(gamelist);
//        items.getChildren().add(hor);
        gamelist.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<savegame>() {
                    @Override
                    public void changed(ObservableValue<? extends savegame> observableValue, savegame savegame, savegame t1) {
                        //System.out.println("Selected is + "+t1);
                        Gameplay g=new Gameplay("ss");
                        g.pause=Pause.g.pause;
                        g.stage=MainController.stage;
                        Pause.g=g;
                        g.loadgame(t1);
                        g.play();

                    }
                }
        );
        view.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
               // System.out.println("Clicked");

                try {
                    MainController m=new MainController(MainController.stage);
                } catch (Exception e) {
                    System.out.println("Exception is : " + e);
                    e.printStackTrace();
                }


            }
        });;
        gamePane.getChildren().add(items);
        gamePane.getChildren().add(view);
        gamePane.getChildren().add(view2);
        scene=new Scene(gamePane,700,700, BLACK);
        stage.setScene(scene);
        stage.show();

    }
}