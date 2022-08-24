package sample;
import java.io.*;

class TotalStats implements Serializable
{
    private int stars_collected;
    private int points_collected;
    private int games_played;
    private int total_collisions;
    private int obstacles_crossed;
    TotalStats()
    {
        stars_collected=0;
        points_collected=0;
        games_played=0;
        total_collisions=0;
        obstacles_crossed=0;
    }

    public int getStars_collected() {
        return stars_collected;
    }

    public int getPoints_collected() {
        return points_collected;
    }

    public int getGames_played() {
        return games_played;
    }

    public int getTotal_collisions() {
        return total_collisions;
    }

    public int getObstacles_crossed() {
        return obstacles_crossed;
    }


    public void setStars_collected(int stars_collected) {
        this.stars_collected = stars_collected;
    }

    public void setPoints_collected(int points_collected) {
        this.points_collected = points_collected;
    }

    public void setGames_played(int games_played) {
        this.games_played = games_played;
    }

    public void setTotal_collisions(int total_collisions) {
        this.total_collisions = total_collisions;
    }

    public void setObstacles_crossed(int obstacles_crossed) {
        this.obstacles_crossed = obstacles_crossed;
    }

}

class DisplayStats
{
    private TotalStats ts;
    private String filename;
    DisplayStats()
    {
        this.ts=null;
        this.filename="Stats.txt";
    }

    public TotalStats read()
    {

        try {
            FileInputStream file=new FileInputStream(filename);
            try {
                ObjectInputStream in = new ObjectInputStream(file);
                ts = (TotalStats) in.readObject();
                in.close();
            }
                catch (StreamCorruptedException e){
//                System.out.println("Reading error");
                    e.printStackTrace();
            }
            file.close();


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return ts;
    }
    public void write(TotalStats stats)
    {
        System.out.println(stats.getPoints_collected());
        try
        {
            FileOutputStream file= new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(stats);
            out.close();
            file.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }
}