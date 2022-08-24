package sample;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;

public class getdata {
    public getdata() throws IOException, ClassNotFoundException {
//        read();
    }
    public void read() throws IOException, ClassNotFoundException {
        FileInputStream getgames=new FileInputStream("gameplaystate");
        System.out.println(getgames.available());
        if(getgames.available()==0)
        {
            getgames.close();
            glist.gameslist=null;
            //glist.gameslist=null;
            //System.out.println("No games available ");
//            if(glist.gameslist==null){
//                    Alert a=new Alert(Alert.AlertType.WARNING);
//                    a.setContentText("No games saved ");
//                    a.show();
//                //System.out.println("No games avialable ");
//            }
//            else{
////                System.out.println("size is : "+glist.gameslist.size());
////                for (int i = 0; i < glist.gameslist.size(); i++) {
////                    System.out.println(glist.gameslist.get(i).toString());
////                    System.out.println("__");
////                }
//
//            }

        }
        else
        {
            if(glist.gameslist==null){
                glist.gameslist=new ArrayList<>();
            }
            ObjectInputStream getobj = new ObjectInputStream(getgames);
            //getobj.flush();
            ArrayList<savegame> savelist = new ArrayList<>();
            ArrayList<savegame> list = null;
            list = (ArrayList) getobj.readObject();
            glist.gameslist.addAll(list);
            //System.out.println("After reading ");
            for (int i = 0; i < glist.gameslist.size(); i++) {
                System.out.println(glist.gameslist.get(i).toString());
            }
            getgames.close();
            getobj.close();


        }
        //System.out.println(glist.gameslist);
//        System.out.println();

    }
    public void write() throws IOException {
        //System.out.println("int write "+ glist.gameslist.size());
        if(glist.gameslist!=null){

            FileOutputStream f=new FileOutputStream("gameplaystate");
            ObjectOutputStream writing=new ObjectOutputStream(f);
            System.out.println("Size : "+glist.gameslist.size());
            writing.writeObject(glist.gameslist);
            System.out.println("written");
            f.close();
            writing.close();

        }
        else{
            System.out.println("it is null;");
        }


    }
}