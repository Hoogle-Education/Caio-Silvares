package Main;

public class Slot {

    private int xpos;
    private int ypos;
    private boolean cooling;
    private Pallet pallet;

    public boolean isCooling(){
        return cooling;
    }

    public static Slot createSlotFrom(int xpos, int ypos, boolean cooling){
        Slot slot = new Slot();
        slot.xpos = xpos;
        slot.ypos = ypos;
        slot.cooling = cooling;
        slot.pallet = null;
        return slot;

        //Slot obj = new Slot();
        //this.xpos = obj.xpos;
        //this.ypos = obj.ypos;
       //this.cooling = obj.cooling;

        //pallet = null;

        //return obj;
    }

    public String getText(){
        String s = " ";
        int a = xpos;
        int b = ypos;
        boolean c = cooling;
        if(this.getPallet() == null){
            s = "free" + ", " + "cooled(true/ false)" + isCooling() + ", " + a + ", " + "Position " + b;
        }
        else{
            s = "occupied" + ", " + "cooled(true/ false)" + isCooling() + ", " + a + ", " + "Position " + b;
        }
        return s;
    }

    public boolean setPallet(Pallet pallet){
        if(this.pallet == null & pallet.isCooling() == this.cooling){
            this.pallet = pallet;
            return true;
        }
        else return false;
        //boolean fits = false;
        //if(this.used == false && pallet.isColling() == this.cooling){
            //fits = true;
            //this.pallet = pallet;
        //}
        //return fits;
    }
    public void release() {
        this.pallet = null;
    }


    public static void fillSlot(Slot[] storage){

    }

    public Pallet getPallet() {
        return pallet;
    }
}
