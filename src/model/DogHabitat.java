package model;

public class DogHabitat extends PetHabitat{
	private int amountToys;


    public DogHabitat(String id, double length, double width, int amountToys) {
        super(id, length, width, useState);
        this.amountToys = amountToys;
    }



    @Override
    public String toString() {
        return super.toString() +
        	   "\nAmount toys: " + amountToys + "\n";
    }

}