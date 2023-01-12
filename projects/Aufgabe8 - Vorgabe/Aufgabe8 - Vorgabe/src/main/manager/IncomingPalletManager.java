package main.manager;

import main.goods.Pallet;
import main.goods.Solid;

import java.util.Arrays;

public class IncomingPalletManager {

    private Pallet[] pallets;

    IncomingPalletManager() {
        pallets = new Pallet[0];
    }

    public Pallet[] getPallets() {
        return pallets;
    }

    /**
     * Registers given pallets
     * @param pallets - pallets to register
     */
    public void registerPallets(Pallet... pallets) {
        if (pallets == null || pallets.length == 0) {
            return;
        }

        Pallet[] oldPallets = this.pallets;
        Pallet[] newPallets = new Pallet[oldPallets.length + pallets.length];

        for (int i = 0; i < newPallets.length; i++) {
            if (i < oldPallets.length) {
                newPallets[i] = oldPallets[i];
            } else {
                newPallets[i] = pallets[i-oldPallets.length];
            }
        }

        this.pallets = newPallets;

        //Remove leading null values in this.pallets here
    }

    /**
     * Removes a given Pallet from registered pallets
     * @param pallet - pallet to remove
     * @return removed pallet or null (if given pallet wasn't in array)
     */
    public Pallet removePallet(Pallet pallet) {
        if(pallet == null)
            return null;

        int indexToRemove = -1;
        Pallet removedPallet = null;

        for(int i = 0; i < this.pallets.length; i++) {
            Pallet actualPallet = this.pallets[i];
            if(actualPallet.equals(pallet)){
                System.out.println("find in position: " + i);
                indexToRemove = i;
                break;
            }
        }

        // if index still in -1, not found pallet
        if(indexToRemove == -1)
            return null;

        Pallet[] newPallets = new Pallet[this.pallets.length - 1];

        for(int oldIndex = 0, newIndex = 0; oldIndex < this.pallets.length; oldIndex++){

            newPallets[newIndex] = this.pallets[oldIndex];

            if(oldIndex != indexToRemove)
                newIndex++;
            else
                removedPallet = this.pallets[indexToRemove];
        }

        this.pallets = newPallets;
        return removedPallet;
    }

    public static void main(String[] args) {
        IncomingPalletManager manager = new IncomingPalletManager();

        Pallet p1 = new Solid("a", 2, true, 5, 1.2, 30);
        Pallet p2 = new Solid("b", 2, true, 5, 1.2, 30);
        Pallet p3 = new Solid("c", 2, true, 5, 1.2, 30);
        Pallet p4 = new Solid("d", 2, true, 5, 1.2, 30);

        Pallet p5 = new Solid("b", 2, true, 5, 1.2, 30);
        Pallet p6 = new Solid("e", 2, true, 5, 1.2, 30);

        manager.registerPallets(p1, p2, p3, p4);

        System.out.println("removing p5: " + manager.removePallet(p5));
        System.out.println("removing p6: " + manager.removePallet(p6));

        System.out.println("-----------------------------");

        for(Pallet p : manager.getPallets()){
            System.out.println(p);
        }

    }
}