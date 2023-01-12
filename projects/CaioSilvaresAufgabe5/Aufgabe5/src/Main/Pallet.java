package Main;
import Prog1Tools.IOTools;
import java.util.Arrays;

public class Pallet {

    private int id;
    private String description;
    private int width;
    private int depth;
    private int height;
    private boolean cooling;
    private long incoming;
    private long outgoing;
    private int nextID;
    private long duration;
    private static int idCounter = 0;

    public static Pallet createPalletForm(String description, int width, int depth, int height, boolean cooling, long duration){
        Pallet pa = new Pallet();
        pa.description = description;
        pa.width = width;
        pa.depth = depth;
        pa.height = height;
        pa.cooling = cooling;
        pa.incoming = System.currentTimeMillis();
        pa.duration = duration;
        pa.outgoing = pa.incoming + duration;

        //Cargo.duration = duration;
        //long timeCreated = System.currentTimeMillis();
        //pa.id = idCounter++;
        //duration = pa.incoming + pa.outgoing;

        return pa;

    }

    //public String getText(){
        //return description + " " + id + " " + cooling;
    //}

    public String getText(){
        String str_pallet = description + " " + id + " " + cooling;
        return str_pallet;
    }

    public static Pallet createPalletFromUserInput(){
        Pallet user_Pallet = createPalletForm(IOTools.readLine("Description: "), IOTools.readInt("Give length: "),
                IOTools.readInt("Height: "), IOTools.readBoolean("Cooled(true/false): ", IOTools.readLong("Duration: ")));
        return user_Pallet;
        //Pallet input_pallet = createPalletForm(IOTools.readLine("Description: "), IOTools.readInt("Give width: "));
        //return input_pallet;
    }

    //private static Pallet createPalletForm(String readLine, int readInt) {
    //}

    public int getID(){
        return id;
    }

    public int getWidth(){
        return width;
    }

    public int getDepth(){
        return depth;
    }
    public boolean isCooling(){
        return cooling;
    }
    public int getNextID(){
        nextID = 0;
        id = nextID++;
        return nextID;
    }
}
