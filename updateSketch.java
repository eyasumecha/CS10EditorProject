package PS6;

import PS6.*;
import PS6.Ellipse;
import PS6.Rectangle;
import PS6.Shape;

import java.awt.*;

public class updateSketch {      // a method that acts on the requests of the clients using the message and the sketch as parameter
    public static synchronized void updatesSketch(String message, Sketch sketch){
        {
            String[] pieces = message.split(" ");     // split the string and find its important information
            Shape temp;
            if(pieces[0].equals("DRAW") || pieces[0].equals("MOVE") || pieces[0].equals("RECOLOR")){        // for all draw and move and recolor requests
                                                                                                            // create a new shape using the information of the message string
                                                                                                            // and then overwrite or add to the sketchMap
                if(pieces[2].equals("ellipse")){
                    temp = new Ellipse(Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Integer.parseInt(pieces[5]), Integer.parseInt(pieces[6]),
                            new Color(Integer.parseInt(pieces[7]), Integer.parseInt(pieces[8]), Integer.parseInt(pieces[9])));
                    sketch.add(Integer.parseInt(pieces[1]), temp);
                }
                else if(pieces[2].equals("rectangle")){
                    temp = new Rectangle(Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Integer.parseInt(pieces[5]), Integer.parseInt(pieces[6]),
                            new Color(Integer.parseInt(pieces[7]), Integer.parseInt(pieces[8]), Integer.parseInt(pieces[9])));
                    sketch.add(Integer.parseInt(pieces[1]), temp);
                }
                else if(pieces[2].equals("segment")){
                    temp = new Segment(Integer.parseInt(pieces[3]), Integer.parseInt(pieces[4]), Integer.parseInt(pieces[5]), Integer.parseInt(pieces[6]),
                            new Color(Integer.parseInt(pieces[7]), Integer.parseInt(pieces[8]), Integer.parseInt(pieces[9])));
                    sketch.add(Integer.parseInt(pieces[1]), temp);
                }
            }
            else if(pieces[0].equals("DELETE")){    // if delete, use the ID to delete from the Map
                sketch.delete(Integer.parseInt(pieces[1]));
            }
        }
    }
}
