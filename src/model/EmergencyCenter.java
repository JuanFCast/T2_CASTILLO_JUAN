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
			
		}
		
		return confirmation;
	}


	/*
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	
	public void addPet(String aFullName, int aYear, double aAmountDonation, PaymentMethod aPaymentMethod){
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
	
	public void register(String aFullName, int aYear, double aAmountDonation, PaymentMethod aPaymentMethod){
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
	
	public void petRemoval(String aFullName, int aYear, double aAmountDonation, PaymentMethod aPaymentMethod){
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