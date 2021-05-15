package model;

public class EmergencyCenter{

	public int MAX_VETS = 7;
	public int MAX_PETS = 120;
	
	//relaciones
	private Veterinary[] vets = new Veterinary[MAX_VETS];
	private Pet[] pets = new Pet[MAX_PETS];


	//constructor
	public EmergencyCenter(){
		

	}


	//get
	public Pet[] getPets(){
		return pets;
	}
	public Veterinary[] getVets(){
		return vets;
	}


	
	//Metodos


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public String addVeterinay(String idNumber, String name, String lastName, String idVeterinary){
		String confirmation = "";
		boolean sentinel = false;
		
		for(int i = 0; i < MAX_VETS && !sentinel; i++){

			if(vets[i] == null){
				sentinel = true;
				vets[i] = new Veterinary(idNumber, name, lastName, idVeterinary);
				confirmation = "\n----------------------\nVeterinanio REGISTRADO\n----------------------\n";
			}
			
		}if (sentinel == false) {
			confirmation = "\n-----------------------------------------\nSe supero el maximo de 7 veterinarios, NO se pueden agregar mas\n-----------------------------------------\n";
		}
		
		return confirmation;
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void deleteVeterinary(String id){
		boolean sentinel = false;
		for(int i = 0; i < MAX_VETS && !sentinel; i++){
			if(vets[i] != null && vets[i].getIdVeterinary().equalsIgnoreCase(id)){
				sentinel = true;
				vets[i] = null;
				System.out.println("El veterinario fue eliminado con exito");
			}
		} 
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	
	public void addPet(String name, int age, Specie specie, PetOwner petOwner, String symptoms, Priority priority, int order){
		boolean sentinel = false;

		for(int i = 0; i < MAX_PETS && !sentinel; i++){

			if(pets[i] == null){
				pets[i] = new Pet(name, age, specie, petOwner, symptoms, priority, order);
				sentinel = true;
				order ++;
				System.out.print("Se ingreso la mascota " + name + " correctamente");
			}
		}
	}





	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void removePet(String name, String idNumber){
		boolean sentinel = false;

		for(int i = 0; i < MAX_PETS && !sentinel; i++){

			if ((pets[i] != null && pets[i].getName().equalsIgnoreCase(name)) && (pets[i].getPetOwner() != null && pets[i].getPetOwner().getIdNumber().equalsIgnoreCase(idNumber))){
				pets[i].setConsultationStatus(ConsultationStatus.SALIDA_SIN_ATENCION);
				sentinel = true;
				System.out.println("La mascota fue enviada a Salidad sin atencion");
			}
		} if (sentinel == false) {
			System.out.println("La mascota no se puede retirar porque no esta en Espera de ser atentida");
		}
	}



	/*
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	
	public void startConsultation(String aFullName, int aYear, double aAmountDonation, PaymentMethod aPaymentMethod){
		int pos;
		boolean sentinel = false;
		
		for(pos = 0;(pos < MAX_DONORS)&& !sentinel; pos++){
			if(donors[pos] == null){
			donors[pos] = new Donor(aFullName, aYear, aAmountDonation, aPaymentMethod);
			sentinel = true;
			}
		}
		donorsNumber++;
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	
	public void finishConsultation(String aFullName, int aYear, double aAmountDonation, PaymentMethod aPaymentMethod){
		int pos;
		boolean sentinel = false;
		
		for(pos = 0;(pos < MAX_DONORS)&& !sentinel; pos++){
			if(donors[pos] == null){
			donors[pos] = new Donor(aFullName, aYear, aAmountDonation, aPaymentMethod);
			sentinel = true;
			}
		}
		donorsNumber++;
	}



	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	
	public void showMissingPets(String aFullName, int aYear, double aAmountDonation, PaymentMethod aPaymentMethod){
		int pos;
		boolean sentinel = false;
		
		for(pos = 0;(pos < MAX_DONORS)&& !sentinel; pos++){
			if(donors[pos] == null){
			donors[pos] = new Donor(aFullName, aYear, aAmountDonation, aPaymentMethod);
			sentinel = true;
			}
		}
		donorsNumber++;
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	
	public void closeCenter(String aFullName, int aYear, double aAmountDonation, PaymentMethod aPaymentMethod){
		int pos;
		boolean sentinel = false;
		
		for(pos = 0;(pos < MAX_DONORS)&& !sentinel; pos++){
			if(donors[pos] == null){
			donors[pos] = new Donor(aFullName, aYear, aAmountDonation, aPaymentMethod);
			sentinel = true;
			}
		}
		donorsNumber++;
	}
	








	//to String
	public String toString(){

		String answer = "";

		
		return answer;
	}
	*/


}