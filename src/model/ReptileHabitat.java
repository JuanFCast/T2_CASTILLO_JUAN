package model;

public class ReptileHabitat extends PetHabitat{
	private String material;
	private ReptileTypeH reptileTypeH;



    public ReptileHabitat(String id, double length, double width, String material, ReptileTypeH reptileTypeH){
        super(id, length, width);
        this.material = material;
        this.reptileTypeH = reptileTypeH;
    }



    @Override
    public String toString() {
        return super.toString() +
        	   "\nMaterial: " + material + 
        	   "\nType of reptile" + reptileTypeH + "\n";
    }

}