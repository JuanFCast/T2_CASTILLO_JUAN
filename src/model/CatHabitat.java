package model;

public class CatHabitat extends PetHabitat{
	private double height;
    private double weight;

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