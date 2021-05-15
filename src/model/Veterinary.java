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
	public Veterinary(String idNumber, String name, String lastName, String idVeterinary){
		this.idNumber = idNumber; 
		this.name = name;
		this.lastName = lastName;
		this.idVeterinary = idVeterinary;
		status = "Available";
		this.petsAttended = 0;

		

	}


	//to String
	public String toString(){

		String answer = "";

		
		return answer;
	}

}