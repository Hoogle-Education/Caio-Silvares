package main.stock;

import main.goods.Pallet;
import main.manager.StockManager;

public class Elf implements IStockWorker {

    @Override
    public String computeNextOperation(int x, int y, Pallet[] registeredPallets, Stack[] stacks, Pallet inventory, Pallet requested) {
        return "W";
    }
}
