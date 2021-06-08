package model;

public class RabbitHabitat{
	private String plantType;
    private int amountOfPlants;

    public RabbitHabitat(String id, String longHabitat, String width, String plantType, int amountOfPlants) {
        super(id, longHabitat, width);
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