package sample;

import javafx.scene.paint.Color;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class savegame implements Serializable {
    private ArrayList<Double> first_pos;
    private ArrayList <Double> second_pos;
    private ArrayList<Double> colorchanger_pos;
    private Double image_pos;
    private Double ball_pos;
    private int points;
    private int stars;

    public String getColor() {
        return color;
    }

    private String color ;
    HashMap<String,String> store;

    public int getPoints() {
        return stars;
    }

    public savegame(){
        store=new HashMap<>();
        first_pos=new ArrayList<Double>();
        colorchanger_pos=new ArrayList<Double>();
        second_pos=new ArrayList<Double>();
        image_pos= (double) 0;
        ball_pos=(double)0;
        points=0;
        stars=0;


    }
    public void setpos(){
        first_pos=Pause.g.first.get_position();
        store.put("first",Pause.g.first.toString());
        if(Pause.g.second==null)
        {
            second_pos=null;
            store.put("second",null);

        }
        else{
            second_pos=Pause.g.second.get_position();
            store.put("second",Pause.g.second.toString());
        }
        ball_pos=Pause.g.player.getPlayer_ball().getCenterY();
        if(Pause.g.cc==null)
            colorchanger_pos=null;
        else{
            colorchanger_pos=Pause.g.cc.get_position();
        }
        if(Pause.g.star==null)
            image_pos=null;
        else
            image_pos=Pause.g.star.getY();
        //System.out.println(Color.RED.toString()+" is : "+Pause.g.player.getCurrent_color().toString());
        if(Pause.g.player.getCurrent_color().toString().equals(Color.RED.toString()))
            color="red";
        else if(Pause.g.player.getCurrent_color().toString().equals(Color.BLUE.toString()))
            color="blue";
        else if(Pause.g.player.getCurrent_color().toString().equals(Color.WHITE.toString()))
            color="white";
        else
            color="yellow";
        //System.out.println("color was : "+color);

        stars=Pause.g.pointsLabel.getPoints();
        points=stars*2;
    }

    public ArrayList<Double> getFirst_pos() {
        return first_pos;
    }

    public ArrayList<Double> getSecond_pos() {
        return second_pos;
    }

    public ArrayList<Double> getColorchanger_pos() {
        return colorchanger_pos;
    }

    public Double getImage_pos() {
        return image_pos;
    }

    public Double getBall_pos() {
        return ball_pos;
    }

    @Override
    public String toString() {
        return " Point : "+points+" First Obstacle : "+first_pos+" Second Obstacle position : "+second_pos+" Ball position : "+ball_pos+"\n";
    }
}
class glist{
    static ArrayList<savegame> gameslist=null;

}