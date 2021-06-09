package model;

public class DogHabitat extends PetHabitat{
	private int amountToys;  // Output


    /**
    * Create a Bird habitat <br>
    * <b> pre:</b> The attributes must to be declared<br>
    * @param id and relationships, types must match and must be other than null
    * @param length and relationships, types must match and must be other than null
    * @param width and relationships, types must match and must be other than null
    * @param amountToys and relationships, types must match and must be other than null
    */
    public DogHabitat(String id, double length, double width, int amountToys) {
        super(id, length, width);
        this.amountToys = amountToys;
    }



    @Override
    public String toString() {
        return super.toString() +
        	   "\nAmount toys: " + amountToys + "\n";
    }

}