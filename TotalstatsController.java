package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;

public class TotalstatsController implements Initializable {
    Stage stage;
    @FXML
    private Label points_collected;
    @FXML
    private Label obstacles_crossed;
    @FXML
    private Label stars_collected;
    public TotalstatsController(){

    }
    public  TotalstatsController(int point,int o) throws IOException, ClassNotFoundException {
        this.stage=MainController.stage;
        Parent p= FXMLLoader.load(getClass().getResource("total.fxml"));
        Scene scene = new Scene(p,700,700, Color.BLACK);
        stage.setScene(scene);
        stage.setTitle("Color Switch ");
        stage.show();
        // write();


    }

    @FXML
    protected void backmain() throws IOException {
        MainController m=new MainController(MainController.stage);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DisplayStats ds = new DisplayStats();
        TotalStats ts = ds.read();

        points_collected.setText(String.valueOf(ts.getStars_collected()*2));
        obstacles_crossed.setText(String.valueOf(ts.getObstacles_crossed()));
        stars_collected.setText(String.valueOf(ts.getStars_collected()));
    }
}