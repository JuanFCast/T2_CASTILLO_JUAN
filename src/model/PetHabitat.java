package model;

public abstract class PetHabitat{

	private String id;
    private double length;
    private double width;
    private UseState useState;
    private Pet pet;

    public PetHabitat(String id, double length, double width, UseState useState) {
        this.id = id;
        this.length = length;
        this.width = width;
        this.useState = UseState.EMPTY;
    }

    //getters
    public String getId() {
        return id;
    }

    public UseState getUseState() {
        return useState;
    }

    public Pet getPet() {
        return pet;
    }


    //setters
    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setUseState(UseState useState) {
        this.useState = useState;
    }




    @Override
    public String toString() {
        return "==Habitat==" + 
        		"\nId: " + id + 
                "\n=================" + 
                "\nDimensions: " +
        		"\nLong: " + length + 
        		"\nWidth: " + width +
                "\n=================" + 
        		"\nUse State: " + useState;
    }

    



	

}