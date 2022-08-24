package sample;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

class Points extends Label {
    private int count;
    private final static String FONT_PATH = "/sample/Blissful Thinking.otf";

    public Points(String text) {
        count=0;
        setPrefWidth(130);
        setPrefHeight(50);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("/sample/red_info_label.png", 130, 50, false, false),
                BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background(backgroundImage));
        setAlignment(Pos.CENTER);
        setPadding(new Insets(10, 10, 10, 10));
        setLabelFont();
        setText(text);
    }
    public Points(int Points){
        this.count=Points;

    }
    public int getPoints() {
        return count;
    }

    public void setPoints(int points) {
        count = count + points;
    }



    private void setLabelFont() {
        setFont(Font.loadFont(getClass().getResourceAsStream(FONT_PATH), 20));
    }
}
