package main.java.com.company.Music;

import java.io.*;

public class Stream {

    public void Input(MusicalNode item, String filename){
        ObjectOutputStream out = null;
        try {
            out = new ObjectOutputStream(new BufferedOutputStream(
                    new FileOutputStream(filename)));
            out.writeObject(item);
        } catch ( IOException ex ) {
            ex.printStackTrace();
        }finally {
            if ( out != null )
                try {
                    out.close();
                } catch ( IOException ex ) {
                    ex.printStackTrace();
                }
        }
    }

    public MusicalNode Output (String filename){
        ObjectInputStream in = null;
        MusicalNode <Song> item = null;
        try {
            in = new ObjectInputStream(new BufferedInputStream(
                    new FileInputStream(filename)));
            item = (MusicalNode) in.readObject();
        } catch ( IOException ex ) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } return item;
    }
}
