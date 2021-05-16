package model;

public class Pet{

	private String name;
	private int age;
	private String symptoms;
	private int order;
	private String race;

	// relaciones
	private Priority priority;
	private Specie specie;
	private PetOwner petOwner;
	private ConsultationStatus consultationStatus;
	private Veterinary veterinary;



	//constructor
	public Pet(String name, int age, Specie specie, PetOwner petOwner, String symptoms, Priority priority, int order){
		this.name = name;
		this.age = age;
		this.specie = specie;
		this.petOwner = petOwner;
		this.symptoms = symptoms;
		this.priority = priority;
		this.order = order;
		consultationStatus = ConsultationStatus.ESPERANDO_SER_ATENDIDO;
	}

	public Pet(String name, int age, Specie specie, PetOwner petOwner, String symptoms, Priority priority, int order, String race){
		this.name = name;
		this.age = age;
		this.specie = specie;
		this.petOwner = petOwner;
		this.symptoms = symptoms;
		this.priority = priority;
		this.order = order;
		this.race = race;
		consultationStatus = ConsultationStatus.ESPERANDO_SER_ATENDIDO;
	}

	
	//get 
	public String getName(){
		return name;
	}

	public PetOwner getPetOwner(){
		return petOwner;
	}

	public int getOrder(){
		return order;
	}

	public ConsultationStatus getConsultationStatus(){
		return consultationStatus;
	}

	public Veterinary getVeterinary(){
		return veterinary;
	}


	//set
	public void setName(String name){
		this.name = name;
	}
	
	public void setPetOwner(PetOwner petOwner){
		this.petOwner = petOwner;
	}
	
	public void setConsultationStatus(ConsultationStatus consultationStatus){
		this.consultationStatus = consultationStatus;
	}

	public void setVeterinary(Veterinary veterinary){
		this.veterinary = veterinary;
	} 



	//to String
	public String toString(){

		String answer = "Nombres: " + name + 
		"Edad: " + age + 
		"Especie: " + specie + 
		"Dueno: " + petOwner.toString() + 
		"Sintomas: " + symptoms + 
		"Prioridad: " + priority +
		"Orden de llegada: " + order;


		
		return answer;
	}

}