package PS6;
import java.util.TreeMap;

public class Sketch {   // creating a class to account for the different shapes and to store them
    TreeMap<Integer, Shape> shapeMap;

    public Sketch() {           // initialize our shapeMap
        shapeMap = new TreeMap<>();
    }
    public synchronized void add(int id, Shape shape){  //add a shape to the map
        shapeMap.put(id, shape);
    }
    public synchronized void remove(int id){            // remove using ID
        shapeMap.remove(id);
    }
    public synchronized Shape get(int id){              // get shape using ID
        return shapeMap.get(id);
    }
    public synchronized void delete(int id){          // delete using ID
        shapeMap.remove(id);
    }
    public synchronized TreeMap<Integer, Shape> getMap (){    // return Map
        return shapeMap;
    }



}
