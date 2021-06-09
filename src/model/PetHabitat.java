package model;

public abstract class PetHabitat{

	private String id;
    private double length;
    private double width;
    private UseState useState;
    private Pet petHabitat;

    public PetHabitat(String id, double length, double width) {
        this.id = id;
        this.length = length;
        this.width = width;
        useState = UseState.EMPTY;
        petHabitat = null;
    }

    //getters
    public String getId() {
        return id;
    }

    public UseState getUseState() {
        return useState;
    }

    public Pet getPetHabitat() {
        return petHabitat;
    }


    //setters
    public void setPetHabitat(Pet petHabitat) {
        this.petHabitat = petHabitat;
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
        		"\nLength: " + length + 
        		"\nWidth: " + width +
                "\n=================" + 
        		"\nUse State: " + useState;
    }

    



	

}