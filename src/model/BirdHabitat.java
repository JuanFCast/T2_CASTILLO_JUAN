package model;

public class BirdHabitat extends PetHabitat{
    private double height;         //Output
    private int capacity;          //Output
    private CageType cageType;     //Output


    /**
    * Create a Bird habitat <br>
    * <b> pre:</b> The attributes must to be declared<br>
    * @param id and relationships, types must match and must be other than null
    * @param length and relationships, types must match and must be other than null
    * @param width and relationships, types must match and must be other than null
    * @param height and relationships, types must match and must be other than null
    * @param capacity and relationships, types must match and must be other than null
    * @param cageType and relationships, types must match and must be other than null
    */
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