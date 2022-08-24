package sample;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Player {
    private double positionY;
    private Color current_color;
    private Circle player_ball;
    public Player()
    {
        this.current_color= Color.WHITE;
        this.positionY=600;
        this.player_ball=new Circle();
        this.player_ball.setCenterY(positionY);
        this.player_ball.setCenterX(350);
        this.player_ball.setRadius(20);
        this.player_ball.setFill(current_color);

    }
    public Player(Color curr, double positionY)
    {
        this.player_ball=new Circle();
        this.current_color=curr;
        this.positionY=positionY;
        this.player_ball.setCenterY(positionY);
        this.player_ball.setCenterX(350);
        this.player_ball.setRadius(20);
        this.player_ball.setFill(current_color);
    }

    public double getPositionY() {
        return positionY;
    }

    public Circle getPlayer_ball() {
        return player_ball;
    }

    public Color getCurrent_color() {
        return current_color;
    }

    public void setCurrent_color(Color current_color) {
        this.current_color = current_color;
        this.player_ball.setFill(current_color);
    }
}
