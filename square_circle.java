package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;

import java.util.ArrayList;

public class square_circle extends obstacle_shape
{
    Rectangle rectangle1;
    Rectangle rectangle2;
    Rectangle rectangle3;
    Rectangle rectangle4;
    Arc arc1;
    Arc arc2;
    Arc arc3;
    Arc arc4;
    public square_circle()
    {

    }

    @Override
    public void make_obstacle() {
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
        arc1.setStartAngle(315);
        arc1.setLength(75);
        arc1.setType(ArcType.OPEN);

        arc2.setCenterX(350);
        arc2.setCenterY(-50);
        arc2.setRadiusX(100);
        arc2.setRadiusY(100);
        arc2.setStartAngle(45);
        arc2.setLength(75);
        arc2.setType(ArcType.OPEN);
        arc2.setStrokeWidth(30);
        arc2.setStroke(Color.BLUE);

        arc3.setCenterX(350);
        arc3.setCenterY(-50);
        arc3.setRadiusX(100);
        arc3.setRadiusY(100);
        arc3.setStartAngle(135);
        arc3.setLength(75);
        arc3.setType(ArcType.OPEN);
        arc3.setStrokeWidth(30);
        arc3.setStroke(Color.YELLOW);

        arc4.setCenterX(350);
        arc4.setCenterY(-50);
        arc4.setRadiusX(100);
        arc4.setRadiusY(100);
        arc4.setStartAngle(225);
        arc4.setLength(75);
        arc4.setType(ArcType.OPEN);
        arc4.setStrokeWidth(30);
        arc4.setStroke(Color.WHITE);
        rectangle1=new Rectangle(200,-200,300,30);
        rectangle1.setFill(Color.BLUE);
        rectangle1.setArcWidth(15);
        rectangle1.setArcHeight(15);
        rectangle2=new Rectangle(200,-200,30,300);
        rectangle2.setFill(Color.YELLOW);
        rectangle2.setArcWidth(15);
        rectangle2.setArcHeight(15);
        rectangle3=new Rectangle(200,70,300,30);
        rectangle3.setFill(Color.WHITE);
        rectangle3.setArcWidth(15);
        rectangle3.setArcHeight(15);
        rectangle4=new Rectangle(470,-200,30,300);
        rectangle4.setFill(Color.RED);
        rectangle4.setArcWidth(15);
        rectangle4.setArcHeight(15);

    }
    public int move_obstacle() {
        rectangle1.setY(rectangle1.getY()+10);
        rectangle2.setY(rectangle2.getY()+10);
        rectangle3.setY(rectangle3.getY()+10);
        rectangle4.setY(rectangle4.getY()+10);
        arc1.setCenterY(arc1.getCenterY()+10);
        arc2.setCenterY(arc2.getCenterY()+10);
        arc3.setCenterY(arc3.getCenterY()+10);
        arc4.setCenterY(arc4.getCenterY()+10);

        if(rectangle1.getY() >=600 || rectangle2.getY() >=600 || rectangle3.getY() >=600 || rectangle4.getY() >=600)
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
    public Group generate_obstacle(Group object1) {

        object1.getChildren().addAll(rectangle1,rectangle2,rectangle3,rectangle4,arc1,arc2,arc3,arc4);
        return object1;
    }
    public void remove_obstacle(Group object) {
        object.getChildren().removeAll(rectangle1,rectangle2,rectangle3,rectangle4,arc1,arc2,arc3,arc4);
    }
    public boolean check_collision(Circle circle1) {
        Shape p=Shape.intersect(rectangle1,circle1);
        Shape p1=Shape.intersect(rectangle2,circle1);
        Shape p2=Shape.intersect(rectangle3,circle1);
        Shape p3=Shape.intersect(rectangle4,circle1);
        Shape p4=Shape.intersect(arc1,circle1);
        Shape p5=Shape.intersect(arc2,circle1);
        Shape p6=Shape.intersect(arc3,circle1);
        Shape p7=Shape.intersect(arc4,circle1);
        //System.out.println(circle1.getFill()==a1.getFill());
        if(p.getBoundsInParent().getWidth()!=-1){
            if(rectangle1.getFill()!=circle1.getFill()){
               // System.out.println("COLLISON With A1");
                return true;
            }
            return false;
        }
        else if(p1.getBoundsInParent().getWidth()!=-1){
            if(rectangle2.getFill()!=circle1.getFill()){
               // System.out.println("COLLISON With A2");
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
               // System.out.println("COLLISON With A4");
                return true;
            }
            return false;
        }
        else if(p4.getBoundsInParent().getWidth()!=-1){
            if(arc1.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A1");
                return true;
            }
            return false;
        }
        else if(p5.getBoundsInParent().getWidth()!=-1){
            if(arc2.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A2");
                return true;
            }
            return false;
        }
        else if(p6.getBoundsInParent().getWidth()!=-1){
            if(arc3.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A3");
                return true;
            }
            return false;
        }
        else if(p7.getBoundsInParent().getWidth()!=-1) {
            if (arc4.getStroke() != circle1.getFill()) {
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
    public ArrayList<Double> get_position() {
        ArrayList<Double> positions =new ArrayList<>();
        positions.add(arc1.getCenterY());
        positions.add(arc2.getCenterY());
        positions.add(arc3.getCenterY());
        positions.add(arc4.getCenterY());
        positions.add(rectangle1.getY());
        positions.add(rectangle2.getY());
        positions.add(rectangle3.getY());
        positions.add(rectangle4.getY());
        return positions;
    }

    @Override
    public void set_position(ArrayList<Double> position) {
        arc1.setCenterY(position.get(0));
        arc2.setCenterY(position.get(1));
        arc3.setCenterY(position.get(2));
        arc4.setCenterY(position.get(3));
        rectangle1.setY(position.get(4));
        rectangle2.setY(position.get(5));
        rectangle3.setY(position.get(6));
        rectangle4.setY(position.get(7));
    }

    @Override
    public String toString() {
        return "square_circle";
    }
}
