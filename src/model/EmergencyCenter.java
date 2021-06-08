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
				System.out.println("\n-----------------------------------------\nSe ingreso la mascota " + name + " correctamente\n-----------------------------------------\n");
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
				System.out.println("\n-----------------------------------------\nSe ingreso la mascota " + name + " correctamente\n-----------------------------------------\n");
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
				System.out.println("\n-------------------------------------------------");
				System.out.println("La mascota fue enviada a Salida sin atencion");
				System.out.println("-------------------------------------------------\n");

			}
		} if (sentinel == false) {
			System.out.println("\n---------------------------------------------------------------------------------");
			System.out.println("La mascota no se puede retirar porque no esta en Espera de ser atentida");
			System.out.println("---------------------------------------------------------------------------------\n");
		}
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public String showVets(){
		String text = "-------------\n= VETERINARIOS =\n-------------";
		int count = 0;
		
		for(int i = 0; i < MAX_VETS; i++){
			if(vets[i] != null){
				
				text += vets[i].toString();
				
			}else{
				count++;

			}
		}
		
		if(count == MAX_VETS){text = "------------------------------------------\nNo hay veterinarios registrados\n------------------------------------------\n";}
		
		return text;
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public int findVet(String idNumber){
		int index = -1;
		boolean sentinel = false;
		
		for(int i = 0; i < MAX_VETS && !sentinel; i++){
			if(vets[i] != null){
				if(idNumber.equals(vets[i].getIdNumber())){
					sentinel = true;
					index = i;
				}
			}
		}
		if(sentinel = false){index = -1;}
		
		return index;
	}


	public String startConsult(int index){
		String confirmation = "";
		boolean sentinel = false;
		int i1 = -1, i2 = -1, i3 = -1, i4 = -1, i5 = -1, count = 0;
		
		for(int i = 0; i < MAX_PETS; i++){
			if(pets[i] == null){
				count++;
			}
		}
		
		if(count != MAX_PETS){
			if((vets[index].getStatus()).equals("Disponible")){
			
				for(int i = 0; i < MAX_PETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getConsultationStatus() == ConsultationStatus.ESPERANDO_SER_ATENDIDO){
							if(pets[i].getPriority() == Priority.PRIORIDAD_1){
								sentinel = true;
								i1 = i;
							}
						}
					}
				}
				sentinel = false;
				for(int i = 0; i < MAX_PETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getConsultationStatus() == ConsultationStatus.ESPERANDO_SER_ATENDIDO){
							if(pets[i].getPriority() == Priority.PRIORIDAD_2){
								sentinel = true;
								i2 = i;
							}
						}
					}
				}
				sentinel = false;
				for(int i = 0; i < MAX_PETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getConsultationStatus() == ConsultationStatus.ESPERANDO_SER_ATENDIDO){
							if(pets[i].getPriority() == Priority.PRIORIDAD_3){
								sentinel = true;
								i3 = i;
							}
						}
					}
				}
				sentinel = false;
				for(int i = 0; i < MAX_PETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getConsultationStatus() == ConsultationStatus.ESPERANDO_SER_ATENDIDO){
							if(pets[i].getPriority() == Priority.PRIORIDAD_4){
								sentinel = true;
								i4 = i;
							}
						}
					}
				}
				sentinel = false;
				for(int i = 0; i < MAX_PETS && !sentinel; i++){
					if(pets[i] != null){
						if(pets[i].getConsultationStatus() == ConsultationStatus.ESPERANDO_SER_ATENDIDO){
							if(pets[i].getPriority() == Priority.PRIORIDAD_5){
								sentinel = true;
								i5 = i;
							}
						}
					}
				}
			
			
				if(i1 != -1){pets[i1].setVeterinary(vets[index]); pets[i1].setConsultationStatus(ConsultationStatus.EN_CONSULTA); vets[index].setStatus("In consultation"); vets[index].setPetsAttended(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";
				
				}else if(i2 != -1){
					pets[i2].setVeterinary(vets[index]); pets[i2].setConsultationStatus(ConsultationStatus.EN_CONSULTA); vets[index].setStatus("In consultation"); vets[index].setPetsAttended(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";
				}
				
           		else if(i3 != -1){
           			pets[i3].setVeterinary(vets[index]); pets[i3].setConsultationStatus(ConsultationStatus.EN_CONSULTA); vets[index].setStatus("In consultation"); vets[index].setPetsAttended(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";
           		}
            	
            	else if(i4 != -1){
            		pets[i4].setVeterinary(vets[index]); pets[i4].setConsultationStatus(ConsultationStatus.EN_CONSULTA); vets[index].setStatus("In consultation"); vets[index].setPetsAttended(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";
            	}
            	
            	else if(i5 != -1){
            		pets[i5].setVeterinary(vets[index]); pets[i5].setConsultationStatus(ConsultationStatus.EN_CONSULTA); vets[index].setStatus("In consultation"); vets[index].setPetsAttended(1); confirmation = "Desde este momento, el veterinario " + vets[index].getName() + " " + vets[index].getLastName() + " pasa a consulta veterinaria";
            	
            	}else{
            		confirmation += "No hay mascotas pendientes por atender\n";
            	}

			} else{confirmation = "Lo sentimos, el veterinario seleccionado ya esta en consulta actualmente";}
		} else{confirmation = "No hay mascotas registradas en el centro";}
				
		return confirmation;
	}
	



	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public Pet finishConsult(int indexVet, String namePet, int option){
		int index = -1;
		boolean sentinel = false;
		int numberOfReturn = 0;
		
		Pet newPet = null;
		
		for(int i = 0; i < MAX_PETS && !sentinel; i++){
			if(pets[i] != null){
				if(pets[i].getVeterinary() == vets[indexVet]){
					if((pets[i].getName()).equals(namePet)){
						index = i;
						sentinel = true;
						if(option == 1){
							pets[index].setConsultationStatus(ConsultationStatus.SALIDA_AUTORIZADA);
							vets[indexVet].setStatus("Disponible");
							numberOfReturn = 1;
						} else{
							pets[index].setConsultationStatus(ConsultationStatus.TRASLADO_A_HOSPITALIZACION);
							newPet = pets[index];
						}
						
					} else{
						numberOfReturn = 3;
					}
				}
			}
		}
		
		if(sentinel == false){numberOfReturn = 4;}
		
		if(numberOfReturn != 0){
			newPet = new Pet(numberOfReturn);
		}
		
		
		return newPet;
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public int petsNumber(){
		int number = 0;
		
		for(int i = 0; i < MAX_PETS; i++){
			if(pets[i] != null){
				if(pets[i].getConsultationStatus() == ConsultationStatus.ESPERANDO_SER_ATENDIDO){
					number++;
				}
			}
		}
		return number;
	}
	
	

	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public boolean verifyIfPetsIsNull(){
		int count = 0;
		boolean confirmation = false;
		
		for(int i = 0; i < MAX_PETS; i++){
			if(pets[i] == null){count++;}
		}
		
		if(count == MAX_PETS){
			confirmation = true;
		}
		
		return confirmation;
	}

	

}