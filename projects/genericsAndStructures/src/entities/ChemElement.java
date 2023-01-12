package entities;

public class ChemElement implements Comparable<ChemElement> {

    private String name;
    private double density;

    public ChemElement(String name, double density) {
        this.name = name;
        this.density = density;
    }

    @Override
    public int compareTo(ChemElement other) {
        return Double.compare(this.density, other.density);
    }

    @Override
    public String toString() {
        return "ChemElement{" +
                "name='" + name + '\'' +
                ", density=" + density +
                '}';
    }
}
