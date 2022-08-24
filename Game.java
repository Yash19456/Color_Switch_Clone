package sample;

import javafx.animation.ParallelTransition;
import javafx.animation.RotateTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;
import javafx.util.Duration;

class Game{

    protected Scene getScene() throws Exception{

        //Parent p=FXMLLoader.load(getClass().getResource("sample.fxml"));
        Circle circleball =new Circle();
        circleball.setRadius(11);
        circleball.setCenterX(300);
        circleball.setCenterY(750);
        circleball.setFill(Color.BLUE);
        Button button = new Button("");
        button.setStyle("-fx-background-color: #000000; ");
        EventHandler<ActionEvent> event=new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                TranslateTransition t1=new TranslateTransition(Duration.millis(600),circleball);
                t1.setCycleCount(1);
                t1.setByY(-50f);

                TranslateTransition t2=new TranslateTransition(Duration.millis(700),circleball);
                t2.setCycleCount(1);
                t2.setToY(0f);

                SequentialTransition s=new SequentialTransition(t1,t2);
                s.setCycleCount(1);
                s.play();
                //t3.play();

            }
        };
        button.setOnAction(event);

        Arc arc=new Arc();
        Arc arc1=new Arc();
        Arc arc2=new Arc();
        Arc arc3=new Arc();
        Circle circle=new Circle();
        circle.setCenterX(300);
        circle.setCenterY(200);
        circle.setRadius(80);
        circle.setFill(Color.BLACK);

        arc.setCenterX(300);
        arc.setCenterY(200);
        arc.setRadiusX(100);
        arc.setRadiusY(100);
        arc.setFill(Color.RED);
        arc.setStartAngle(0);
        arc.setLength(90);
        arc.setType(ArcType.ROUND);

        arc1.setCenterX(300);
        arc1.setCenterY(200);
        arc1.setRadiusX(100);
        arc1.setRadiusY(100);
        arc1.setFill(Color.BLUE);
        arc1.setStartAngle(90);
        arc1.setLength(90);
        arc1.setType(ArcType.ROUND);

        arc2.setCenterX(300);
        arc2.setCenterY(200);
        arc2.setRadiusX(100);
        arc2.setRadiusY(100);
        arc2.setFill(Color.YELLOW);
        arc2.setStartAngle(180);
        arc2.setLength(90);
        arc2.setType(ArcType.ROUND);

        arc3.setCenterX(300);
        arc3.setCenterY(200);
        arc3.setRadiusX(100);
        arc3.setRadiusY(100);
        arc3.setFill(Color.WHITE);
        arc3.setStartAngle(270);
        arc3.setLength(90);
        arc3.setType(ArcType.ROUND);

        Arc color1=new Arc();
        Arc color2=new Arc();
        Arc color3=new Arc();
        Arc color4=new Arc();

        color1.setCenterX(300);
        color1.setCenterY(400);
        color1.setRadiusX(15);
        color1.setRadiusY(15);
        color1.setFill(Color.RED);
        color1.setStartAngle(0);
        color1.setLength(90);
        color1.setType(ArcType.ROUND);

        color2.setCenterX(300);
        color2.setCenterY(400);
        color2.setRadiusX(15);
        color2.setRadiusY(15);
        color2.setFill(Color.BLUE);
        color2.setStartAngle(90);
        color2.setLength(90);
        color2.setType(ArcType.ROUND);

        color3.setCenterX(300);
        color3.setCenterY(400);
        color3.setRadiusX(15);
        color3.setRadiusY(15);
        color3.setFill(Color.YELLOW);
        color3.setStartAngle(180);
        color3.setLength(90);
        color3.setType(ArcType.ROUND);

        color4.setCenterX(300);
        color4.setCenterY(400);
        color4.setRadiusX(15);
        color4.setRadiusY(15);
        color4.setFill(Color.WHITE);
        color4.setStartAngle(270);
        color4.setLength(90);
        color4.setType(ArcType.ROUND);

        Rectangle rectangle1=new Rectangle(230,200,45,15);
        rectangle1.setFill(Color.WHITE);
        rectangle1.setArcWidth(10);
        rectangle1.setArcHeight(10);
        Rectangle rectangle2=new Rectangle(275,200,50,15);
        rectangle2.setFill(Color.RED);
        rectangle2.setArcWidth(10);
        rectangle2.setArcHeight(10);
        Rectangle rectangle3=new Rectangle(270,205,15,50);
        rectangle3.setFill(Color.YELLOW);
        rectangle3.setArcWidth(10);
        rectangle3.setArcHeight(10);
        Rectangle rectangle4=new Rectangle(270,160,15,55);
        rectangle4.setFill(Color.BLUE);
        rectangle4.setArcWidth(10);
        rectangle4.setArcHeight(10);


        Rectangle rect1=new Rectangle(225,500,150,20);
        rect1.setFill(Color.WHITE);
        rect1.setArcWidth(15);
        rect1.setArcHeight(15);
        Rectangle rect2=new Rectangle(225,500,20,150);
        rect2.setFill(Color.ORANGE);
        rect2.setArcWidth(15);
        rect2.setArcHeight(15);
        Rectangle rect3=new Rectangle(225,640,150,20);
        rect3.setFill(Color.YELLOW);
        rect3.setArcWidth(15);
        rect3.setArcHeight(15);
        Rectangle rect4=new Rectangle(360,500,20,160);
        rect4.setFill(Color.BLUE);
        rect4.setArcWidth(15);
        rect4.setArcHeight(15);

        Group root = new Group();
        Group root1=new Group();
        Group root2=new Group();
        Group root3=new Group();
        Group root4=new Group();
        root.getChildren().addAll(rectangle1,rectangle2,rectangle4,rectangle3);
        root1.getChildren().addAll(arc,arc1,arc2,arc3,circle);
        root3.getChildren().addAll(color1,color2,color3,color4);
        root4.getChildren().addAll(rect1,rect2,rect3,rect4);
        RotateTransition rotate = new RotateTransition();
        RotateTransition rotate1=new RotateTransition();
        RotateTransition rotate2=new RotateTransition();

        rotate.setAxis(Rotate.Z_AXIS);
        rotate.setByAngle(360);
        rotate.setCycleCount(500);
        rotate.setDuration(Duration.millis(4000));
//        rotate.setAutoReverse(true);
        rotate.setNode(root);
        rotate.play();

        rotate1.setAxis(Rotate.Z_AXIS);
        rotate1.setByAngle(360);
        rotate1.setCycleCount(500);
        rotate1.setDuration(Duration.millis(4000));
        rotate1.setAutoReverse(true);
        rotate1.setNode(root1);
        rotate1.play();

        rotate2.setAxis(Rotate.Z_AXIS);
        rotate2.setByAngle(360);
        rotate2.setCycleCount(500);
        rotate2.setDuration(Duration.millis(4000));
        //rotate1.setAutoReverse(true);
        rotate2.setNode(root4);
        rotate2.play();

        root2.getChildren().addAll(root1,root,circleball,button,root4, root3);

        Scene scene = new Scene(root2,600,800,Color.BLACK);
        return scene;
    }

}