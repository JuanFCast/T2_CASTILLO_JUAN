package model;

public class BirdHabitat extends PetHabitat{
    private double height;
    private int capacity;
    private CageType cageType;


    public BirdHabitat(String id, double length, double width, double height, int capacity, CageType cageType) {
        super(id, length, width);
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