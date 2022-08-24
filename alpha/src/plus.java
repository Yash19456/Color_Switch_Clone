package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class plus extends obstacle_shape{
    Rectangle rect1;
    Rectangle rect2;
    Rectangle rect3;
    Rectangle rect4;

    public plus(){


    }

    @Override
    public void make_obstacle() {
        rect1=new Rectangle(50,40,150,30);
        rect1.setFill(Color.WHITE);
        rect1.setArcWidth(15);
        rect1.setArcHeight(15);
        rect2=new Rectangle(200,40,150,30);
        rect2.setFill(Color.RED);
        rect2.setArcWidth(15);
        rect2.setArcHeight(15);
        rect3=new Rectangle(185,50,30,150);
        rect3.setFill(Color.YELLOW);
        rect3.setArcWidth(15);
        rect3.setArcHeight(15);
        rect4=new Rectangle(185,-100,30,150);
        rect4.setFill(Color.BLUE);
        rect4.setArcWidth(15);
        rect4.setArcHeight(15);
    }
    public int move_obstacle() {
        rect1.setY(rect1.getY()+10);
        rect2.setY(rect2.getY()+10);
        rect3.setY(rect3.getY()+10);
        rect4.setY(rect4.getY()+10);

        if(rect1.getY() >=500 || rect2.getY() >=500 || rect3.getY() >=500 || rect4.getY() >=500)
        {
            int x=1;
            if(rect1.getY() >=700 || rect2.getY() >=700 || rect3.getY() >=700 || rect4.getY() >=700)
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
    public Group generate_obstacle(Group object) {
        object.getChildren().addAll(rect1,rect2,rect3,rect4);
        return object;
    }

    @Override
    public void remove_obstacle(Group object) {
        object.getChildren().removeAll(rect1,rect2,rect3,rect4);
    }
    public boolean check_collision(Circle circle1) {
        Shape p=Shape.intersect(rect1,circle1);
        Shape p1=Shape.intersect(rect2,circle1);
        Shape p2=Shape.intersect(rect3,circle1);
        Shape p3=Shape.intersect(rect4,circle1);
        //System.out.println(circle1.getFill()==a1.getFill());
        if(p.getBoundsInParent().getWidth()!=-1){
            if(rect1.getFill()!=circle1.getFill()){
                //System.out.println("COLLISON With A1");
                return true;
            }
            return false;
        }
        else if(p1.getBoundsInParent().getWidth()!=-1){
            if(rect2.getFill()!=circle1.getFill()){
                //System.out.println("COLLISON With A2");
                return true;
            }
            return false;
        }
        else if(p2.getBoundsInParent().getWidth()!=-1){
            if(rect3.getFill()!=circle1.getFill()){
                //System.out.println("COLLISON With A3");
                return true;
            }
            return false;
        }
        else if(p3.getBoundsInParent().getWidth()!=-1) {
            if (rect4.getFill() != circle1.getFill()) {
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
        positions.add(rect1.getY());
        positions.add(rect2.getY());
        positions.add(rect3.getY());
        positions.add(rect4.getY());
        return positions;
    }

    @Override
    public void set_position(ArrayList<Double> position) {
        rect1.setY(position.get(0));
        rect2.setY(position.get(1));
        rect3.setY(position.get(2));
        rect4.setY(position.get(3));
    }

    @Override
    public String toString() {
        return "plus";
    }
}
