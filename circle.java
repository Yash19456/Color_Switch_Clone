package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class circle extends obstacle_shape{
    Arc arc1;
    Arc arc2;
    Arc arc3;
    Arc arc4;
    public circle (){

    }
    public void make_obstacle()
    {

        arc1=new Arc();
        arc2=new Arc();
        arc3=new Arc();
        arc4=new Arc();

        arc1.setCenterX(350);
        arc1.setCenterY(-50);
        arc1.setRadiusX(100);
        arc1.setRadiusY(100);
        arc1.setStrokeWidth(30);
        arc1.setStroke(Color.RED);
        arc1.setStartAngle(0);
        arc1.setLength(75);
        arc1.setType(ArcType.OPEN);

        arc2.setCenterX(350);
        arc2.setCenterY(-50);
        arc2.setRadiusX(100);
        arc2.setRadiusY(100);
        arc2.setStartAngle(90);
        arc2.setLength(75);
        arc2.setType(ArcType.OPEN);
        arc2.setStrokeWidth(30);
        arc2.setStroke(Color.BLUE);

        arc3.setCenterX(350);
        arc3.setCenterY(-50);
        arc3.setRadiusX(100);
        arc3.setRadiusY(100);
        arc3.setStartAngle(180);
        arc3.setLength(75);
        arc3.setType(ArcType.OPEN);
        arc3.setStrokeWidth(30);
        arc3.setStroke(Color.YELLOW);

        arc4.setCenterX(350);
        arc4.setCenterY(-50);
        arc4.setRadiusX(100);
        arc4.setRadiusY(100);
        arc4.setStartAngle(270);
        arc4.setLength(75);
        arc4.setType(ArcType.OPEN);
        arc4.setStrokeWidth(30);
        arc4.setStroke(Color.WHITE);
    }
    public void first_obstacle()
    {
        arc1.setCenterY(200);
        arc2.setCenterY(200);
        arc3.setCenterY(200);
        arc4.setCenterY(200);
    }

    @Override
    public int move_obstacle() {
        arc1.setCenterY(arc1.getCenterY()+10);
        arc2.setCenterY(arc2.getCenterY()+10);
        arc3.setCenterY(arc3.getCenterY()+10);
        arc4.setCenterY(arc4.getCenterY()+10);

        //System.out.println(arc1.getCenterY()+" "+arc2.getCenterY()+" "+arc3.getCenterY()+" "+arc4.getCenterY());
        if(arc1.getCenterY() >= 500 || arc2.getCenterY() >= 500 || arc3.getCenterY() >= 500 || arc4.getCenterY() >= 500)
        {
            int x=1;
            if(arc1.getCenterY() >= 700 || arc2.getCenterY() >= 700 || arc3.getCenterY() >= 700 || arc4.getCenterY() >= 700)
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

        object1.getChildren().addAll(arc1,arc2,arc3,arc4);
        return  object1;
    }

    @Override
    public void remove_obstacle(Group object) {
        object.getChildren().removeAll(arc1,arc2,arc3,arc4);
    }

    @Override
    public boolean check_collision(Circle circle1) {
        Shape p=Shape.intersect(arc1,circle1);
        Shape p1=Shape.intersect(arc2,circle1);
        Shape p2=Shape.intersect(arc3,circle1);
        Shape p3=Shape.intersect(arc4,circle1);
        //System.out.println(circle1.getFill()==a1.getFill());
        if(p.getBoundsInParent().getWidth()!=-1){
            if(arc1.getStroke()!=circle1.getFill()){
                System.out.println("COLLISON With A1");
                return true;
            }
            return false;
        }
        else if(p1.getBoundsInParent().getWidth()!=-1){
            if(arc2.getStroke()!=circle1.getFill()){
                System.out.println("COLLISON With A2");
                return true;
            }
            return false;
        }
        else if(p2.getBoundsInParent().getWidth()!=-1){
            if(arc3.getStroke()!=circle1.getFill()){
                System.out.println("COLLISON With A3");
                return true;
            }
            return false;
        }
        else if(p3.getBoundsInParent().getWidth()!=-1) {
            if (arc4.getStroke() != circle1.getFill()) {
                System.out.println("COLLISON With A4");
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
        ArrayList<Double> positions =new ArrayList<>();
        positions.add(arc1.getCenterY());
        positions.add(arc2.getCenterY());
        positions.add(arc3.getCenterY());
        positions.add(arc4.getCenterY());
        return positions;
    }

    @Override
    public void set_position(ArrayList<Double> position) {
        arc1.setCenterY(position.get(0));
        arc2.setCenterY(position.get(1));
        arc3.setCenterY(position.get(2));
        arc4.setCenterY(position.get(3));
    }

    @Override
    public String toString() {
        return "circle";
    }
}
