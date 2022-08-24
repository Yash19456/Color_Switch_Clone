package sample;

import javafx.scene.Group;
import javafx.scene.shape.Circle;


import java.util.ArrayList;

public abstract class obstacle_shape {
    public abstract void make_obstacle();
    public abstract int move_obstacle();
    public abstract Group generate_obstacle(Group object);
    public abstract void remove_obstacle(Group object);
    public abstract boolean check_collision(Circle circle1);
    public abstract ArrayList<Double> get_position();
    public abstract void set_position(ArrayList<Double> position);

}
