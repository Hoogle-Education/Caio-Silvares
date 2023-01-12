package main.goods;

public abstract class Pallet {

    private String description = "";
    private int id;
    private int width;
    private int depth;
    protected int height;
    private boolean cooling;
    private long incoming;
    private long outgoing;
    private int price;

    private static int nextid = 1;

    /**
     * Creates a pallet from given values
     * @param description - describes the content
     * @param width - width of the pallet
     * @param depth - depth of the pallet
     * @param height - height of the pallet
     * @param cooling - true, if the pallet requires cooling
     * @param duration - estimated duration of stocking in days
     * @param price - price per liter or unit
     */
    protected Pallet(String description, int width, int depth, int height, boolean cooling, int duration, int price) {
        this.id = nextid++;
        this.description = description;
        this.width = width;
        this.depth = depth;
        this.height = height;
        this.cooling = cooling;
        this.incoming = System.currentTimeMillis();
        this.outgoing = this.incoming + (duration * 24 * 60 * 60 * 1000);
        this.price = price;
    }

    /**
     * Calculates the current weight of the pallet.
     * @return weight in gram
     */
    public abstract int getWeight();

    /**
     * Calculates the current total value of the pallet.
     * @return total value in Euro.
     */
    public abstract int getValue();


    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public int getHeight() {
        return height;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Pallet{" +
                "description='" + description + '\'' +
                ", id=" + id +
                ", width=" + width +
                ", depth=" + depth +
                ", height=" + height +
                ", cooling=" + cooling +
                ", incoming=" + incoming +
                ", outgoing=" + outgoing +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pallet pallet = (Pallet) o;

        if (width != pallet.width) return false;
        if (depth != pallet.depth) return false;
        if (height != pallet.height) return false;
        if (cooling != pallet.cooling) return false;
        if (price != pallet.price) return false;
        return description.equals(pallet.description);
    }

    @Override
    public int hashCode() {
        int result = description.hashCode();
        result = 31 * result + width;
        result = 31 * result + depth;
        result = 31 * result + height;
        result = 31 * result + (cooling ? 1 : 0);
        result = 31 * result + price;
        return result;
    }
}
