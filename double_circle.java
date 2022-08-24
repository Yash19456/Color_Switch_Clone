package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class double_circle extends obstacle_shape
{
    Arc arc1;
    Arc arc2;
    Arc arc3;
    Arc arc4;
    Arc ar1;
    Arc ar2;
    Arc ar3;
    Arc ar4;
    public double_circle()
    {

    }

    @Override
    public void make_obstacle() {
        arc1=new Arc();
        arc2=new Arc();
        arc3=new Arc();
        arc4=new Arc();
        ar1=new Arc();
        ar2=new Arc();
        ar3=new Arc();
        ar4=new Arc();
        arc1.setCenterX(350);
        arc1.setCenterY(-40);
        arc1.setRadiusX(130);
        arc1.setRadiusY(130);
        arc1.setStrokeWidth(30);
        arc1.setStroke(Color.RED);
        arc1.setStartAngle(0);
        arc1.setLength(75);
        arc1.setType(ArcType.OPEN);

        arc2.setCenterX(350);
        arc2.setCenterY(-40);
        arc2.setRadiusX(130);
        arc2.setRadiusY(130);
        arc2.setStartAngle(90);
        arc2.setLength(75);
        arc2.setType(ArcType.OPEN);
        arc2.setStrokeWidth(30);
        arc2.setStroke(Color.BLUE);

        arc3.setCenterX(350);
        arc3.setCenterY(-40);
        arc3.setRadiusX(130);
        arc3.setRadiusY(130);
        arc3.setStartAngle(180);
        arc3.setLength(75);
        arc3.setType(ArcType.OPEN);
        arc3.setStrokeWidth(30);
        arc3.setStroke(Color.YELLOW);

        arc4.setCenterX(350);
        arc4.setCenterY(-40);
        arc4.setRadiusX(130);
        arc4.setRadiusY(130);
        arc4.setStartAngle(270);
        arc4.setLength(75);
        arc4.setType(ArcType.OPEN);
        arc4.setStrokeWidth(30);
        arc4.setStroke(Color.WHITE);

        ar1.setCenterX(350);
        ar1.setCenterY(-40);
        ar1.setRadiusX(90);
        ar1.setRadiusY(90);
        ar1.setStrokeWidth(30);
        ar1.setStroke(Color.RED);
        ar1.setStartAngle(0);
        ar1.setLength(75);
        ar1.setType(ArcType.OPEN);

        ar2.setCenterX(350);
        ar2.setCenterY(-40);
        ar2.setRadiusX(90);
        ar2.setRadiusY(90);
        ar2.setStartAngle(90);
        ar2.setLength(75);
        ar2.setType(ArcType.OPEN);
        ar2.setStrokeWidth(30);
        ar2.setStroke(Color.BLUE);

        ar3.setCenterX(350);
        ar3.setCenterY(-40);
        ar3.setRadiusX(90);
        ar3.setRadiusY(90);
        ar3.setStartAngle(180);
        ar3.setLength(75);
        ar3.setType(ArcType.OPEN);
        ar3.setStrokeWidth(30);
        ar3.setStroke(Color.YELLOW);

        ar4.setCenterX(350);
        ar4.setCenterY(-40);
        ar4.setRadiusX(90);
        ar4.setRadiusY(90);
        ar4.setStartAngle(270);
        ar4.setLength(75);
        ar4.setType(ArcType.OPEN);
        ar4.setStrokeWidth(30);
        ar4.setStroke(Color.WHITE);
    }
    public int move_obstacle() {
        arc1.setCenterY(arc1.getCenterY()+10);
        arc2.setCenterY(arc2.getCenterY()+10);
        arc3.setCenterY(arc3.getCenterY()+10);
        arc4.setCenterY(arc4.getCenterY()+10);
        ar1.setCenterY(ar1.getCenterY()+10);
        ar2.setCenterY(ar2.getCenterY()+10);
        ar3.setCenterY(ar3.getCenterY()+10);
        ar4.setCenterY(ar4.getCenterY()+10);


        //System.out.println(arc1.getCenterY()+" "+arc2.getCenterY()+" "+arc3.getCenterY()+" "+arc4.getCenterY());
        if(arc1.getCenterY() >= 550 || arc2.getCenterY() >= 550 || arc3.getCenterY() >= 550 || arc4.getCenterY() >= 550)
        {
            int x=1;
            if(arc1.getCenterY() >= 750 || arc2.getCenterY() >= 750 || arc3.getCenterY() >= 750 || arc4.getCenterY() >= 750)
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
    public Group generate_obstacle(Group object1)
    {
        object1.getChildren().addAll(arc1,arc2,arc3,arc4,ar1,ar2,ar3,ar4);
        return  object1;
    }

    @Override
    public void remove_obstacle(Group object)
    {
        object.getChildren().removeAll(arc1,arc2,arc3,arc4,ar1,ar2,ar3,ar4);
    }
    public boolean check_collision(Circle circle1) {
        Shape p=Shape.intersect(arc1,circle1);
        Shape p1=Shape.intersect(arc2,circle1);
        Shape p2=Shape.intersect(arc3,circle1);
        Shape p3=Shape.intersect(arc4,circle1);
        Shape p4=Shape.intersect(ar1,circle1);
        Shape p5=Shape.intersect(ar2,circle1);
        Shape p6=Shape.intersect(ar3,circle1);
        Shape p7=Shape.intersect(ar4,circle1);
        //System.out.println(circle1.getFill()==a1.getFill());
        if(p.getBoundsInParent().getWidth()!=-1){
            if(arc1.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A1");
                return true;
            }
            return false;
        }
        else if(p1.getBoundsInParent().getWidth()!=-1){
            if(arc2.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A2");
                return true;
            }
            return false;
        }
        else if(p2.getBoundsInParent().getWidth()!=-1){
            if(arc3.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A3");
                return true;
            }
            return false;
        }
        else if(p3.getBoundsInParent().getWidth()!=-1) {
            if (arc4.getStroke() != circle1.getFill()) {
                //System.out.println("COLLISON With A4");
                return true;
            }
            return false;
        }
        else if(p4.getBoundsInParent().getWidth()!=-1){
            if(ar1.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A1");
                return true;
            }
            return false;
        }
        else if(p5.getBoundsInParent().getWidth()!=-1){
            if(ar2.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A2");
                return true;
            }
            return false;
        }
        else if(p6.getBoundsInParent().getWidth()!=-1){
            if(ar3.getStroke()!=circle1.getFill()){
                //System.out.println("COLLISON With A3");
                return true;
            }
            return false;
        }
        else if(p7.getBoundsInParent().getWidth()!=-1) {
            if (ar4.getStroke() != circle1.getFill()) {
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
        positions.add(ar1.getCenterY());
        positions.add(ar2.getCenterY());
        positions.add(ar3.getCenterY());
        positions.add(ar4.getCenterY());
        return positions;
    }

    @Override
    public void set_position(ArrayList<Double> position) {
        arc1.setCenterY(position.get(0));
        arc2.setCenterY(position.get(1));
        arc3.setCenterY(position.get(2));
        arc4.setCenterY(position.get(3));
        ar1.setCenterY(position.get(4));
        ar2.setCenterY(position.get(5));
        ar3.setCenterY(position.get(6));
        ar4.setCenterY(position.get(7));
    }

    @Override
    public String toString() {
        return "double_circle";
    }
}
