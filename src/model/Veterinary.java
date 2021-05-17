package model;

public class Veterinary{

	private String idNumber;
	private String name;
	private String lastName;
	private String idVeterinary;
	private String status;
	private int petsAttended;

	



	//constructor
	public Veterinary(String idNumber, String name, String lastName, String idVeterinary){
		this.idNumber = idNumber; 
		this.name = name;
		this.lastName = lastName;
		this.idVeterinary = idVeterinary;
		status = "Disponible";
		petsAttended = 0;

	}

	//get 
	public String getIdNumber(){
		return idNumber;
	}

	public String getName(){
		return name;
	}

	public String getLastName(){
		return lastName;
	}

	public String getIdVeterinary(){
		return idVeterinary;
	}

	public String getStatus(){
		return status;
	}

	public int getPetsAttended(){
		return petsAttended;
	}


	//set
	public void setIdNumber(String idNumber){
		this.idNumber = idNumber;
	} 

	public void setName(String name){
		this.name = name;
	}

	public void setIdVeterinary(String idVeterinary){
		this.idVeterinary = idVeterinary;
	}

	public void setStatus(String status){
		this.status = status;
	} 

	public void setPetsAttended(int petsAttended){
		this.petsAttended = petsAttended;
	} 


	//to String
	public String toString(){

		String answer = "Numero de identificacion: " + idNumber + 
		"\nNombres : " + name +
		"\nApellidos: " + lastName + 
		"\nRegistro unico veterinario: " + idVeterinary +
		"\nEstado del veterinario: " + status + 
		"\nMascotas atentidas: " + petsAttended;

		
		return answer;
	}

}