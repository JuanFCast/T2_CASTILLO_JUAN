package model;

public class Veterinary{

	private String idNumber;
	private String name;
	private String lastName;
	private String idVeterinary;
	private String status;
	private int petsAttended;

	// relaciones



	//constructor
	public Veterinary(String idNumber, String name, String lastName, String idVeterinary, String status){
		this.idNumber = idNumber; 
		this.name = name;
		this.lastName = lastName;
		this.idVeterinary = idVeterinary;
		this.status = status;
		this.petsAttended = 0;

	}

	//get 
	public String getIdVeterinary(){
		return idVeterinary;
	}


	//set
	public void setiIdVeterinary(String idVeterinary){
		this.idVeterinary = idVeterinary;
	} 


	//to String
	public String toString(){

		String answer = "Numero de identificacion: " + idNumber + 
		"Nombres : " + name +
		"Apellidos: " + lastName + 
		"Registro unico veterinario: " + idVeterinary +
		"Estado del veterinario: " + status + 
		"Mascotas atentidas: " + petsAttended;

		
		return answer;
	}

}