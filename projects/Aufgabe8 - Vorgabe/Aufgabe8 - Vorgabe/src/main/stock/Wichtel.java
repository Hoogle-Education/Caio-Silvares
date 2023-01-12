package main.stock;

import main.goods.Pallet;
import main.manager.StockManager;

public class Wichtel implements IStockWorker {

    @Override
    public String computeNextOperation(int x, int y, Pallet[] registeredPallets, Stack[] stacks, Pallet inventory, Pallet requested) {

        if(inventory == null){
            if(x == 0 && y == 0){
                return "P";
            } else {
                return "W";
            }
        }

        if(x  != StockManager.NUMBEROFSTACKS) {
            return "E";
        } else {
            if(x == 1) return "D";
            else return "S";
        }



    }
}
