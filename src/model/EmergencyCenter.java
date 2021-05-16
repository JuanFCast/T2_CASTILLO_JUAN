package model;

public class EmergencyCenter{

	public int MAX_VETS = 7;
	public int MAX_PETS = 120;
	private int order = 1;
	
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
	public String addVeterinay(String idNumber, String name, String lastName, String idVeterinary, String status){
		String confirmation = "";
		boolean sentinel = false;
		
		for(int i = 0; i < MAX_VETS && !sentinel; i++){

			if(vets[i] == null){
				sentinel = true;
				vets[i] = new Veterinary(idNumber, name, lastName, idVeterinary, status);
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
	public void deleteVeterinary(String idNumber){
		boolean sentinel = false;
		for(int i = 0; i < MAX_VETS && !sentinel; i++){
			if(vets[i] != null && vets[i].getIdNumber().equalsIgnoreCase(idNumber)){
				sentinel = true;
				vets[i] = null;
				System.out.println("El veterinario fue eliminado con exito\n");
			}
		}if (sentinel == false) {
			System.out.println("El Numero de registro que ingreso no existe en nuestra base de datos\n");
		}
	}



	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void addPet(String name, int age, Specie specie, PetOwner petOwner, String symptoms, Priority priority){
		boolean sentinel = false;

		for(int i = 0; i < MAX_PETS && !sentinel; i++){

			if(pets[i] == null){
				pets[i] = new Pet(name, age, specie, petOwner, symptoms, priority, order);
				sentinel = true;
				order ++;
				System.out.print("Se ingreso la mascota " + name + " correctamente\n");
			}
		}if (sentinel == false) {
			System.out.println("\n-----------------------------------------\nSe supero el maximo de 120 mascotas, NO se pueden agregar mas\n-----------------------------------------\n");
		}
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void addPet(String name, int age, Specie specie, PetOwner petOwner, String symptoms, Priority priority, String race){
		boolean sentinel = false;

		for(int i = 0; i < MAX_PETS && !sentinel; i++){

			if(pets[i] == null){
				pets[i] = new Pet(name, age, specie, petOwner, symptoms, priority, order, race);
				sentinel = true;
				order ++;
				System.out.print("Se ingreso la mascota " + name + " correctamente");
			}
		}if (sentinel == false) {
			System.out.println("\n-----------------------------------------\nSe supero el maximo de 120 mascotas, NO se pueden agregar mas\n-----------------------------------------\n");
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
				System.out.println("La mascota fue enviada a Salidad sin atencion\n");
			}
		} if (sentinel == false) {
			System.out.println("La mascota no se puede retirar porque no esta en Espera de ser atentida\n");
		}
	}



	

}