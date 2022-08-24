package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class square extends obstacle_shape{
    Rectangle rectangle1;
    Rectangle rectangle2;
    Rectangle rectangle3;
    Rectangle rectangle4;
    public square(){
    }

    @Override
    public void make_obstacle() {
        rectangle1=new Rectangle(250,-150,200,30);
        rectangle1.setFill(Color.WHITE);
        rectangle1.setArcWidth(15);
        rectangle1.setArcHeight(15);
        rectangle2=new Rectangle(250,-150,30,220);
        rectangle2.setFill(Color.RED);
        rectangle2.setArcWidth(15);
        rectangle2.setArcHeight(15);
        rectangle3=new Rectangle(250,40,220,30);
        rectangle3.setFill(Color.YELLOW);
        rectangle3.setArcWidth(15);
        rectangle3.setArcHeight(15);
        rectangle4=new Rectangle(440,-150,30,220);
        rectangle4.setFill(Color.BLUE);
        rectangle4.setArcWidth(15);
        rectangle4.setArcHeight(15);

    }

    @Override
    public int move_obstacle() {
        rectangle1.setY(rectangle1.getY()+10);
        rectangle2.setY(rectangle2.getY()+10);
        rectangle3.setY(rectangle3.getY()+10);
        rectangle4.setY(rectangle4.getY()+10);

        if(rectangle1.getY() >=550 || rectangle2.getY() >=550 || rectangle3.getY() >=550 || rectangle4.getY() >=550)
        {
            int x=1;
            if(rectangle1.getY() >=750 || rectangle2.getY() >=750 || rectangle3.getY() >=750 || rectangle4.getY() >=750)
            {
                x=2;
            }
            return x;
        }
        else
        {
            int y=0;
            return y;
        }
    }

    @Override
    public Group generate_obstacle(Group object1) {
        object1.getChildren().addAll(rectangle1,rectangle2,rectangle3,rectangle4);
        return object1;
    }

    @Override
    public void remove_obstacle(Group object) {
        object.getChildren().removeAll(rectangle1,rectangle2,rectangle3,rectangle4);
    }
    public boolean check_collision(Circle circle1) {
        Shape p=Shape.intersect(rectangle1,circle1);
        Shape p1=Shape.intersect(rectangle2,circle1);
        Shape p2=Shape.intersect(rectangle3,circle1);
        Shape p3=Shape.intersect(rectangle4,circle1);
        //System.out.println(circle1.getFill()==a1.getFill());
        if(p.getBoundsInParent().getWidth()!=-1){
            if(rectangle1.getFill()!=circle1.getFill()){
                //System.out.println("COLLISON With A1");
                return true;
            }
            return false;
        }
        else if(p1.getBoundsInParent().getWidth()!=-1){
            if(rectangle2.getFill()!=circle1.getFill()){
                //System.out.println("COLLISON With A2");
                return true;
            }
            return false;
        }
        else if(p2.getBoundsInParent().getWidth()!=-1){
            if(rectangle3.getFill()!=circle1.getFill()){
                //System.out.println("COLLISON With A3");
                return true;
            }
            return false;
        }
        else if(p3.getBoundsInParent().getWidth()!=-1) {
            if (rectangle4.getFill() != circle1.getFill()) {
                //System.out.println("COLLISON With A4");
                return true;
            }
            return false;
        }
        else
        {
            return false;
        }
    }

    @Override
    public ArrayList<Double> get_position() {
        ArrayList<Double> positions = new ArrayList<>();
        positions.add(rectangle1.getY());
        positions.add(rectangle2.getY());
        positions.add(rectangle3.getY());
        positions.add(rectangle4.getY());
        return positions;
    }

    @Override
    public void set_position(ArrayList<Double> position) {
        rectangle1.setY(position.get(0));
        rectangle2.setY(position.get(1));
        rectangle3.setY(position.get(2));
        rectangle4.setY(position.get(3));
    }

    @Override
    public String toString() {
        return "square";
    }
}
