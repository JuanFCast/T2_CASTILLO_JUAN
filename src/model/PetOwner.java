package model;
//5
public class PetOwner{

	private String idNumber;
	private String name;
	private String phone;
	private String address;

	// relaciones



	//constructor
	public PetOwner(String idNumber, String name, String phone, String address){
		this.idNumber = idNumber;
		this.name = name;
		this.phone = phone;
		this.address = address;
	}



	//get 
	public String getIdNumber(){
		return idNumber;
	}

	public String getName(){
		return name;
	}

	
	//set
	public void setIdNumber(String idNumber){
		this.idNumber = idNumber;
	}

	public void setName(String name){
		this.name = name;
	}
	
	


	//to String
	public String toString(){

		String answer = "";

		
		return answer;
	}


}