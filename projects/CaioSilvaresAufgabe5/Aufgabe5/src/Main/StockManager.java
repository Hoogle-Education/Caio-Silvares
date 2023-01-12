package Main;
import Prog1Tools.IOTools;
import java.awt.*;

public class StockManager {

    public static void main(String[] args){
        Pallet p = new Pallet();
        Slot s = new Slot();
        System.out.println("Current position: ");
        Slot [][] stock = new Slot [2][3];
        for(int i = 0; i < stock.length; i++){
            for(int j =0; j < stock[i].length; j++){
                stock [i][j] = s.createSlotFrom(j, i, i%2 == 0);
                System.out.println(stock [i][j].getText());
            }
        }

        boolean loop = true;
        char c = IOTools.readChar("Next? ('i'nfo, 'c'reate, 'r'elease, 's'wap, 'q'uit)");
        while (loop == true){
            if(c == 'i'){
            }
            if(c == 'c'){
                p.createPalletFromUserInput();
            }
            if (c == 'r'){
                Slot.release();
            }
            if(c == 's'){
                p.getNextID();
            }
            if(c == 'q'){
                System.exit(0);
            }
        }
       /** Slot[] storage = new Slot[6];
        storage[0] = Slot.createSlotFrom(0, 0, true);
        Pallet p = new Pallet();
        p = Pallet.createPalletForm("Description", 2, 2, 2, true, 12);
        System.out.println(storage[0].getPallet());
        storage[0].setPallet(p);
        System.out.println(storage[0].getPallet());
        */
    }
}
