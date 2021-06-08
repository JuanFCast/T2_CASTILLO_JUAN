package model;

public class RabbitHabitat extends PetHabitat{
	private String plantType;
    private int amountOfPlants;

    public RabbitHabitat(String id, double length, double width, String plantType, int amountOfPlants) {
        super(id, length, width);
        this.plantType = plantType;
        this.amountOfPlants = amountOfPlants;
    }

    @Override
    public String toString() {
        return super.toString() +
               "\nType of plant: " + plantType +
               "\nAmount of plants: " + amountOfPlants + "\n";
    }

}