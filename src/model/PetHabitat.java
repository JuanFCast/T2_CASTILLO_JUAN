package model;

public abstract class PetHabitat{

	private String id;
    private double length;
    private double width;
    private UseState useState;
    private Pet pet;
    private int daysToUse;

    public PetHabitat(String id, double length, double width) {
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

    public void setDaysToUse(int daysToUse) {
        this.daysToUse = daysToUse;
    }


    @Override
    public String toString() {
        return "==Habitat==" + 
        		"\nId: " + id + 
        		"\nLong: " + length + 
        		"\nWidth: " + width +
        		"\nUse State: " + useState +
        		"\nDays to use:" + daysToUse;
    }

    



	

}