public class HouseBuilder {
    static TreeHouse bauHaus(int height, int width) {
        TreeHouse b = new TreeHouse();
        b.height = height;
        b.width = width;
        return b;
    }
    static TreeHouse machBreiter(TreeHouse b)
    {
        TreeHouse bb = new TreeHouse();
        bb.height = b.height;
        bb.width = b.width + 1;
        return bb;
    }
    static TreeHouse machHoeher(TreeHouse b)
    {
        b.height++;
        return b;
    }
    public static void main(String[] args) {
        TreeHouse b = bauHaus(2, 3);  // b = TreeHouse(n = 0, h = 2, w = 3, neighbor = null)
        TreeHouse c = machBreiter(b); // c = TreeHouse(n = 1, h = 2, w = 4, neighbor = null)
        c.houseNeighbor = b; // c = TreeHouse(n = 1, h = 2, w = 4, neighbor = b)
        TreeHouse d = machHoeher(b); // d = b = TreeHouse(n = 0, h = 3, w = 3, neighbor = null)
        d.houseNeighbor = b; // d = b = TreeHouse(n = 0, h = 2, w = 3, neighbor = b)
        ++c.height; // c = TreeHouse(n = 1, h = 3, w = 4, neighbor = b)
        TreeHouse e = machHoeher(b); // d = e = b = TreeHouse(n = 0, h = 3, w = 3, neighbor = b)
        e.houseNeighbor = c; // d = e = b = TreeHouse(n = 0, h = 3, w = 3, neighbor = c)
        e.width = b.width - 1; // d = e = b = TreeHouse(n = 0, h = 3, w = 2, neighbor = c)
        c.height++;  // c = TreeHouse(n = 1, h = 4, w = 4, neighbor = b)
        c.width -= 2; // c = TreeHouse(n = 1, h = 4, w = 2, neighbor = b)
        boolean bUndCBenachbart = (b.houseNeighbor == c || c.houseNeighbor == b);
        System.out.println(bUndCBenachbart);
    }
}
class TreeHouse {
    public int height;
    public int width;
    public TreeHouse houseNeighbor;
    public int number = ++nextNumber;
    static int nextNumber = 0;
}