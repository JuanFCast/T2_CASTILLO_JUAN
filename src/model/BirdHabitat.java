package model;

public class BirdHabitat{
    private double height;
    private int capacity;
    private CageType cageType;


    public BirdHabitat(String id, String longHabitat, String width, String height, int capacity, CageType cageType) {
        super(id, longHabitat, width);
        this.height = height;
        this.capacity = capacity;
        this.cageType = cageType;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nHeight:" + height +
               "\nCapacity: " + capacity +
               "\nCage type: " + cageType + "\n";
    }
}