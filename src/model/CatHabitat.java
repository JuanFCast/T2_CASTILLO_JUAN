package model;

public class CatHabitat extends PetHabitat{
	private double height; //Output
    private double weight; //Output

    /**
    * Create a Bird habitat <br>
    * <b> pre:</b> The attributes must to be declared<br>
    * @param id and relationships, types must match and must be other than null
    * @param length and relationships, types must match and must be other than null
    * @param width and relationships, types must match and must be other than null
    * @param height and relationships, types must match and must be other than null
    * @param weight and relationships, types must match and must be other than null
    */
    public CatHabitat(String id, double length, double width, double height, double weight) {
        super(id, length, width);
        this.height = height;
        this.weight = weight;
    }



    @Override
    public String toString() {
        return super.toString() +
               "\nHeight: " + height +
               "\nMaximum Weight: " + weight + "\n";
    }

}