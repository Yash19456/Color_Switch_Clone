package sample;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public class change_color extends obstacle_shape {
    Arc arc1;
    Arc arc2;
    Arc arc3;
    Arc arc4;
    public void make_obstacle()
    {
        arc1=new Arc();
        arc2=new Arc();
        arc3=new Arc();
        arc4=new Arc();

        arc1.setCenterX(350);
        arc1.setCenterY(-40);
        arc1.setRadiusY(20);
        arc1.setRadiusX(20);
        arc1.setStartAngle(0);
        arc1.setLength(90);
        arc1.setType(ArcType.ROUND);
        arc1.setFill(Color.RED);

        arc2.setCenterX(350);
        arc2.setCenterY(-40);
        arc2.setRadiusY(20);
        arc2.setRadiusX(20);
        arc2.setStartAngle(90);
        arc2.setLength(90);
        arc2.setType(ArcType.ROUND);
        arc2.setFill(Color.YELLOW);

        arc3.setCenterX(350);
        arc3.setCenterY(-40);
        arc3.setRadiusY(20);
        arc3.setRadiusX(20);
        arc3.setStartAngle(180);
        arc3.setLength(90);
        arc3.setType(ArcType.ROUND);
        arc3.setFill(Color.BLUE);

        arc4.setCenterX(350);
        arc4.setCenterY(-40);
        arc4.setRadiusY(20);
        arc4.setRadiusX(20);
        arc4.setStartAngle(270);
        arc4.setLength(90);
        arc4.setType(ArcType.ROUND);
        arc4.setFill(Color.WHITE);
    }
    public int move_obstacle()
    {
        arc1.setCenterY(arc1.getCenterY()+10);
        arc2.setCenterY(arc2.getCenterY()+10);
        arc3.setCenterY(arc3.getCenterY()+10);
        arc4.setCenterY(arc4.getCenterY()+10);
        return 0;
    }
    public Group generate_obstacle(Group object1)
    {
        make_obstacle();
        object1.getChildren().addAll(arc1,arc2,arc3,arc4);
        return object1;
    }
    public void remove_obstacle(Group object1)
    {
        //System.out.println(" after "+object1.getChildren().size());
        object1.getChildren().removeAll(arc1,arc2,arc3,arc4);
    }
    public boolean check_collision(Circle circle1)
    {
        Shape p= Shape.intersect(arc1,circle1);
        Shape p1= Shape.intersect(arc2,circle1);
        Shape p2= Shape.intersect(arc3,circle1);
        Shape p3= Shape.intersect(arc4,circle1);
        if(p.getBoundsInParent().getWidth()!=-1 || p1.getBoundsInParent().getWidth()!=-1 || p2.getBoundsInParent().getWidth()!=-1 || p3.getBoundsInParent().getWidth()!=-1)
        {
            return true;
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
        return positions;
    }

    @Override
    public void set_position(ArrayList<Double> position) {
        arc1.setCenterY(position.get(0));
        arc2.setCenterY(position.get(1));
        arc3.setCenterY(position.get(2));
        arc4.setCenterY(position.get(3));
    }

}
