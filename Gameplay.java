package sample;
import java.io.*;

import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

class Gameplay
{
    Player player;
    int count=1;
    Group object1=new Group();
    Group object2=new Group();
    Group change_color=new Group();
    Group gstar= new Group();
    obstacle_shape first=null;
    obstacle_shape second=null;
    change_color cc=null;
    Points pointsLabel;
    Scene scene ;
    DisplayStats displayStats;
    TotalStats stats;
    AnimationTimer timer = new MyTimer();
    PauseController pause;
    private boolean keypressed;
    boolean initiate=false;
    boolean created=false;
    Stage stage;
    ImageView star;
    String image="/sample/star_gold.png";
    public Gameplay(int points) throws IOException {
        this.stage=MainController.stage;
        player=new Player();
        pointsLabel=new Points(" POINTS : 00");
        pointsLabel.setPoints(points);
        first=new circle();
        first.make_obstacle();
        first.generate_obstacle(object1);
//        stats=new TotalStats();
//        displayStats.write(stats);
        displayStats=new DisplayStats();
        stats=displayStats.read();
        stats.setGames_played(stats.getGames_played()+1);
    }

    public Gameplay(String s){
        this.stage=MainController.stage;
        player=new Player();
        pointsLabel=new Points(" POINTS : 00");


    }
    public void play(){
        Image i1=new Image("resources/pauseb.png");
        ImageView image1=new ImageView(i1);
        image1.setX(540);
        image1.setY(60);
        image1.setFitWidth(60);
        image1.setFitHeight(40);
        image1.setPreserveRatio(true);
        image1.setPickOnBounds(true);
        image1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {
                //System.out.println("Clicked");

                try {
                    timer.stop();
                    displayStats.write(stats);
                    pause.loadscreen();
                } catch (Exception e) {
                    System.out.println("Exception is : " + e);
                    e.printStackTrace();
                }


            }
        });;

        AnchorPane gamePane=new AnchorPane();
        star=new ImageView(image);
        star.setLayoutY(-60);
        star.setLayoutX(335);
        gstar.getChildren().addAll(star);

        pointsLabel.setLayoutY(30);
        pointsLabel.setLayoutX(30);
        Button b=new Button();
        gamePane.getChildren().addAll(object1,object2,change_color,gstar,player.getPlayer_ball(),image1,pointsLabel);
        gamePane.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));

        //first.first_obstacle();
        //System.out.println(" created 1");

        scene = new Scene(gamePane, 700, 700, Color.BLACK);

        stage.setTitle("AnimationTimer");
        stage.setScene(scene);
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.SPACE)
                {
                    timer.start();
                }
                else if(keyEvent.getCode() == KeyCode.UP)
                {
                    String Path = "src\\resources\\bouncing-trimmed.mp3";
                    MusicPlayer m = new MusicPlayer(Path,false);
                    Thread t1 = new Thread(m);
                    t1.start();
                    keypressed=true;
                    try {
                        t1.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                if(keyEvent.getCode()== KeyCode.UP)
                {
                    keypressed=false;
                }
            }
        });

        stage.show();
    }
    private class MyTimer extends AnimationTimer {
        private boolean alpha;
        @Override
        public void handle(long now) {

            object1.setRotate(object1.getRotate()+difficulty_spin(pointsLabel));
            object2.setRotate(object2.getRotate()+difficulty_spin(pointsLabel));
            doHandle();
            if(alpha)
            {
                dorelease();
            }
        }

        private void doHandle() {
            int test1;
            int test2=0;

            if(keypressed)
            {

                //System.out.println("Circle is : "+circle1.getCenterY());
                if(player.getPlayer_ball().getCenterY()>350)
                    player.getPlayer_ball().setCenterY(player.getPlayer_ball().getCenterY()-difficulty_speed(pointsLabel));
                    //circle1.setCenterY(circle1.getCenterY()-10);
                else {
                    test1=first.move_obstacle();
                    if(created)
                    {
                        test2=second.move_obstacle();
                    }
                    if(change_color.getChildren().size()!=0)
                    {

                        cc.move_obstacle();
                        if(cc.check_collision(player.getPlayer_ball()))
                        {
                            cc.remove_obstacle(change_color);
                            //System.out.println(change_color.getChildren().size());
                            if(player.getCurrent_color()==Color.WHITE)
                            {
                                player.setCurrent_color(Color.RED);
                            }
                            else if(player.getCurrent_color()==Color.RED)
                            {
                                player.setCurrent_color(Color.YELLOW);
                            }
                            else if(player.getCurrent_color()==Color.YELLOW)
                            {
                                player.setCurrent_color(Color.BLUE);
                            }
                            else if(player.getCurrent_color()==Color.BLUE)
                            {
                                player.setCurrent_color(Color.SILVER);
                            }
                            else if(player.getCurrent_color()==Color.SILVER)
                            {
                                player.setCurrent_color(Color.WHITE);
                            }

                        }
                    }
                    if(gstar.getChildren().size()!=0)
                    {
                        star.setLayoutY(star.getLayoutY()+10);

                        if(star.getLayoutY()>330)
                        {
                            pointsLabel.setPoints(1);
                            String text=" POINTS : ";
                            pointsLabel.setText(text + pointsLabel.getPoints());
                            stats.setStars_collected(stats.getStars_collected()+1);
                            gstar.getChildren().remove(star);
                        }
                    }

                    if(test1==1 || test2==1)
                    {
                        create_obstacle();
                        created=true;
                    }
                    if(test1==2)
                    {
                        destroy_obstacle(1);
                    }
                    else if(test2==2)
                    {
                        destroy_obstacle(2);
                    }
                }
                alpha=true;
                if(first.check_collision(player.getPlayer_ball()) && player.getCurrent_color()!=Color.SILVER )
                {
                    gameovercontroller over=new gameovercontroller();
                    stats.setTotal_collisions(stats.getTotal_collisions()+1);
                    over.loadscreen();
                    this.stop();
                }
                if(created)
                {
                    if(second.check_collision(player.getPlayer_ball()) && player.getCurrent_color()!=Color.SILVER)
                    {
                        gameovercontroller over=new gameovercontroller();
                        stats.setTotal_collisions(stats.getTotal_collisions()+1);
                        over.loadscreen();
                        this.stop();
                    }
                }


            }
        }
        private void dorelease()
        {
            player.getPlayer_ball().setCenterY(player.getPlayer_ball().getCenterY()+2);
            if(player.getPlayer_ball().getCenterY()>=600)
            {
                alpha=false;
            }
            if(first.check_collision(player.getPlayer_ball()) && player.getCurrent_color()!=Color.SILVER)
            {
               gameovercontroller over=new gameovercontroller();
                stats.setTotal_collisions(stats.getTotal_collisions()+1);
                over.loadscreen();
                this.stop();
            }
            if(created)
            {
                if(second.check_collision(player.getPlayer_ball()) && player.getCurrent_color()!=Color.SILVER )
                {
                    gameovercontroller over=new gameovercontroller();
                    stats.setTotal_collisions(stats.getTotal_collisions()+1);
                    over.loadscreen();
                    this.stop();
                }
            }
        }
    }

    void create_obstacle()
    {
        //System.out.println("IN maing of obstacle ");
        if(!initiate)
        {
            //System.out.println("In first if ");
            if(change_color.getChildren().size()==0)
            {
                cc=new change_color();
                cc.generate_obstacle(change_color);
            }
            //System.out.println(" created 2");
            second=new square();
            second.make_obstacle();
            second.generate_obstacle(object2);
            initiate=true;
        }
        else
        {
            if(object1.getChildren().size()==0)
            {
                if(gstar.getChildren().size()==0)
                {
                    //System.out.println("here");
                    star=new ImageView(image);
                    star.setLayoutY(-70);
                    star.setLayoutX(335);
                    gstar.getChildren().addAll(star);
                }
                int random= ThreadLocalRandom.current().nextInt(0,5);
                switch (random)
                {
                    case 0:
                    {
                        first=new circle();
                        //System.out.println("hii0");
                        break;
                    }
                    case 1:
                    {
                        first=new square();
                        //System.out.println("hii1");
                        break;
                    }
                    case 2:
                    {
                        first=new plus();
                        break;
                    }
                    case 3:
                    {
                        first=new square_circle();
                        break;
                    }
                    case 4:
                    {
                        first=new double_circle();
                        break;
                    }
                }
                //first=new circle();
                first.make_obstacle();
                first.generate_obstacle(object1);
                System.out.println(" created  1 in make obstacle ");

            }
            else if(object2.getChildren().size()==0)
            {
                //System.out.println("IN else if of make : "+object2.getChildren().size());
                int random1= ThreadLocalRandom.current().nextInt(0,5);
                if(change_color.getChildren().size()==0)
                {
                    cc=new change_color();
                    cc.generate_obstacle(change_color);
                }
                if(random1<=2)
                {
                    second=new square();

                }
                else
                {
                    second=new square_circle();
                    //System.out.println("i did it");
                }
                second.make_obstacle();
                second.generate_obstacle(object2);

                System.out.println(" created 2");

            }
        }
    }
    void destroy_obstacle(int choose)
    {
        if((choose==1) && (object1.getChildren().size()!=0))
        {
            first.remove_obstacle(object1);
            stats.setObstacles_crossed(stats.getObstacles_crossed()+1);
            //System.out.println(object1.getChildren().size()+" destroyed 1");
        }
        else if((choose==2) && (object2.getChildren().size()!=0))
        {
            second.remove_obstacle(object2);
            stats.setObstacles_crossed(stats.getObstacles_crossed()+1);
            //System.out.println(object2.getChildren().size()+" destroyed 2");
        }
    }

    public double difficulty_spin(Points point)
    {
        if(point.getPoints()<5)
        {
            return 2;
        }
        else if(point.getPoints()<10)
        {
            return 2.2;
        }
        else if(point.getPoints()<15)
        {
            return 2.5;
        }
        else
        {
            return 3;
        }
    }
    public double difficulty_speed(Points point)
    {
        if(point.getPoints()<5)
        {
            return 10;
        }
        else if(point.getPoints()<10)
        {
            return 10.2;
        }
        else if(point.getPoints()<15)
        {
            return 10.5;
        }
        else
        {
            return 12;
        }
    }

    void loadgame(savegame save){
        player.getPlayer_ball().setCenterY(save.getBall_pos());
        switch (save.getColor()) {
            case "red":
                player.setCurrent_color(Color.RED);
                break;
            case "blue":
                player.setCurrent_color(Color.BLUE);
                break;
            case "white":
                player.setCurrent_color(Color.WHITE);
                break;
            default:
                player.setCurrent_color(Color.YELLOW);
                break;
        }
        String s=save.store.get("first");
        switch (s) {
            case "circle":
                first = new circle();
                break;
            case "square":
                first = new square();
                break;
            case "plus":
                first = new plus();
                break;
            case "double_circle":
                first=new double_circle();
                break;
            case "square_circle":
                first=new square_circle();
                break;
        }
        first.make_obstacle();
        first.set_position(save.getFirst_pos());
        first.generate_obstacle(object1);
        s=save.store.get("second");
        if(s!=null){
            System.out.println(s);
            switch (s) {
                case "circle":
                    second = new circle();
                    break;
                case "square":
                    second = new square();
                    break;
                case "plus":
                    second = new plus();
                    break;
                case "square_circle":
                    second=new square_circle();
                    break;
                case "double_circle":
                    second=new double_circle();
                    break;
            }

            second.make_obstacle();
            second.set_position(save.getSecond_pos());
            second.generate_obstacle(object2);

            initiate=true;
            created=true;
            //System.out.println("Size of object 2 is : "+object2.getChildren().size());
        }
        if(save.getColorchanger_pos()!=null){
            cc=new change_color();
            //cc.make_obstacle();
            cc.generate_obstacle(change_color);
            cc.set_position(save.getColorchanger_pos());
            //System.out.println("Bhaean chu 2 : "+save.getColorchanger_pos());


        }
        //System.out.println(save.getPoints());
        pointsLabel.setPoints(save.getPoints());
        String text="POINTS : ";
        pointsLabel.setText(text+pointsLabel.getPoints());
        displayStats=new DisplayStats();
        stats=displayStats.read();
    }


}
