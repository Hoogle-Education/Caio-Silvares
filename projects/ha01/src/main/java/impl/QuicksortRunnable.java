package impl;

import util.Monitor;
import util.Partition;

public class QuicksortRunnable extends Monitor implements Runnable {

    protected Partition p;

    /**
     * Do not modify.
     * @param p Contains all information required for a recursion step.
     */
    public QuicksortRunnable(Partition p) {
        super(p);
        this.p = p;
    }

    @Override
    public void run() {
        // TODO: implement

    }

    private int partitionIndex(Partition p) {
        int pivot = p.right;
        int end = p.array.length;
        int i = p.left - 1;

        for(int j = p.left; j < p.right; j++) {
            if(p.array[j] < pivot) {
                i++;

                var aux = p.array[i];
                p.array[i] = p.array[j];
                p.array[j] = aux;
            }
        }

        var aux = p.array[i+1];
        p.array[i+1] = p.array[end - 1];
        p.array[end - 1] = p.array[i+1];

        return i;
    }
}
