package model;

public class Pet{

	private String name;
	private int age;
	private String symptoms;
	private int order;
	private String race;
	private int dyasStayed;


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

	public Pet(Specie specie, String race, String name, int age, PetOwner petOwner, int days){
		this.specie = specie;
		this.race = race;
		this.name = name;
		this.age = age;
		this.petOwner = petOwner;
		dyasStayed = days;
		}
	
	public Pet(Specie specie, String name, int age, PetOwner petOwner, int days){
		this.specie = specie;
		this.race = race;
		this.name = name;
		this.age = age;
		this.petOwner = petOwner;
		dyasStayed = days; 
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

	public Priority getPriority(){
		return priority;
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

	public void setOrder(int order){
		this.order = order;
	}

	public void setPriority(Priority priority){
		this.priority = priority;
	}
	
	public void setConsultationStatus(ConsultationStatus consultationStatus){
		this.consultationStatus = consultationStatus;
	}

	public void setVeterinary(Veterinary veterinary){
		this.veterinary = veterinary;
	} 





	//to String
	public String toString(){

		String answer = "\nNombres: " + name + 
		"\nEdad: " + age + 
		"\nEspecie: " + specie + 
		"\nDueno: " + petOwner.toString() + 
		"\nSintomas: " + symptoms + 
		"\nPrioridad: " + priority +
		"\nOrden de llegada: " + order;


		
		return answer;
	}

}