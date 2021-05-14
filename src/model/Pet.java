package model;

public class Pet{

	private String name;
	private int year;
	private String symptoms;

	// relaciones
	private Specie specie;
	private Priority priority;
	private PetOwner petOwner;
	private ConsultationStatus consultationStatus;
	private Veterinary veterinary;



	//constructor
	public Pet(String name, int year, String symptoms, Specie specie, Priority priority, PetOwner petOwner, ConsultationStatus consultationStatus, Veterinary veterinary){
		this.name = name;
		this.year = year;
		this.symptoms = symptoms;
		this.specie = specie;
		this.priority = priority;
		this.petOwner = petOwner;
		this.consultationStatus = consultationStatus;
		this.veterinary = veterinary;
	}



	//to String
	public String toString(){

		String answer = "";

		
		return answer;
	}

}