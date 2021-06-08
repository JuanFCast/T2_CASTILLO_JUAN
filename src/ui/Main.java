package ui;                                             // javac -cp src src/ui/Main.java -d bin
														// java -cp bin ui.Main
														// javadoc -cp src -subpackages model:ui -d docs/javadoc/                                        
import model.EmergencyCenter;
import model.KindergartenCenter;
import model.Pet;
import model.Specie;
import model.ConsultationStatus;
import model.Priority;
import model.PetOwner;


import java.util.Scanner;

/**
* @author Juan Felipe Castillo Gomez
* Description: This is the main class of the TI3
*/
public class Main{


	/**
	* Description: It is a class in the java package. Used to get input from primitive types like int, double etc. and also String.
	*/ 
	public Scanner sc;


	/**
	* Description: Esta clase se encarga de unir los metodos que sirven para el funcionamiento del programa 
	*/ 
	private EmergencyCenter emergency;


	/**
	* Description: Esta clase se encarga de unir los metodos que sirven para el funcionamiento del programa 
	*/ 
	private KindergartenCenter ki;


	

	//No se que colocar aqui
	public Main() {
    sc = new Scanner(System.in);
    emergency = new EmergencyCenter();
    ki = new KindergartenCenter();
    }


    /**
	* Description: class main method
	* @param args String, I don't know what to write but I put it because when I generated the documentation it told me that it had no parameters, and then I write this so that that message stops appearing xD
	*/
	public static void main(String[] args) {
		Main t2 = new Main();
		boolean sentinel;
		int option;

		System.out.println("------------------------------------------");
		System.out.println("-----WELCOME TO THE VETERINARY CENTER-----");
		System.out.println("------------------------------------------");

		do{
            option = t2.showGeneralMenu();
            sentinel = t2.functions(option);
        }while(sentinel);
		

	}
	

	//Metodos

	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public int showGeneralMenu(){
		int option;

    	System.out.println("==Choose the service you want to enter==\n");
        System.out.println(	"(1) Emergencies veterinaries\n" +
                			"(2) Pet's kindergarten\n" +
                			"(0) End program");
        option = sc.nextInt();
        sc.nextLine();

        return option;
    	
	}




	public boolean functions(int option){
        boolean sentinel = true;
        int election;
        boolean cent = false;


        switch (option) {
            case 1:
                do {
                    election = emergencyMenu();
                    cent = emergencyFunctions(election);
                }while (cent);
                break;

            case 2:
                do {
                    election = kindergartenMenu();
                    cent = kindergartenFunctions(election);
                }while (cent);
                break;

            case 0:
                sentinel = false;
                break;
            }

        return sentinel;
    }




	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public int emergencyMenu(){
		int option;

    	System.out.println("MENU DE ACTIVIDADES\n");
        System.out.println("A continuacion selecciona una opcion:");
		System.out.println("(1) A\u00f1adir un nuevo veterinario");
		System.out.println("(2) Eliminar un veterinario");
		System.out.println("(3) Registrar una mascota");
		System.out.println("(4) Retirar una mascota");
		System.out.println("(5) Iniciar una consulta");
		System.out.println("(6) Finalizar una consulta");
		System.out.println("(7) Numero de mascotas que NO han sido atentidas");
		System.out.println("(8) Cierre diario del Centro\n");

		System.out.println("(0) End program\n");

		System.out.print("Opcion: ");
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
    	
	}


	public boolean emergencyFunctions(int option){
        boolean sentinel = true;

        switch(option){
				case 1:
				addVeterinay();
				break;

				case 2:
				deleteVet();
				break;

				case 3:
				newPet();
				break;

				case 4:
				removePet();
				break;
				
				case 5:
				startConsultation();
				break;

				case 6:
				finishConsultation();
				break;

				case 7:
				petNumber();
				break;

				case 8:
				closeCenter();
				break;

				case 9:
				//showPets();
				break;

				case 10:
				//showVets();
				break;

				default:
				sentinel = false;
				break;
			}

        return sentinel;
    }



    /**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public int kindergartenMenu(){
		int option;

    	System.out.println("MENU DE ACTIVIDADES\n");
        System.out.println("A continuacion selecciona una opcion:");
		System.out.println("(1) Ingresar una mascota a la guarderia");
		System.out.println("(2) Buscar una mascota en la guarderia");
		System.out.println("(3) Mostrar mapa de la guarderia");
		System.out.println("(4) Mostrar informacion sobre un habitat");
		System.out.println("(5) Mostrar informe de la guarderia");
		System.out.println("(0) End program\n");

		System.out.print("Opcion: ");
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
    	
	}



	public boolean kindergartenFunctions(int option){
        boolean sentinel = true;

        switch(option){
				case 1:
				addPetInPetDaycare();
				break;

				case 2:
				findPetInPetDaycare();
				break;

				case 3:
				showPetDaycareMap();
				break;

				case 4:
				showInfoHabitat();
				break;
				
				case 5:
				showStats();
				break;

				default:
				sentinel = false;
				break;
			}

        return sentinel;
    }
	





    //TAREA INTEGRADORA 2
	
	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void addVeterinay(){
		String idNumber = "", name = "", lastName = "", idVeterinary = "";
		
		System.out.println("===========================================\n Formato de Registro de Nuev@ Veterinari@ \n===========================================\n");
		System.out.print("Numero de identificacion: ");
		idNumber = sc.nextLine();

		System.out.print("Nombres: ");
		name = sc.nextLine();

		System.out.print("Apellidos: ");
		lastName = sc.nextLine();

		System.out.print("Registro unico veterinario: ");
		idVeterinary = sc.nextLine();

		
		System.out.println(emergency.addVeterinay(idNumber, name, lastName, idVeterinary));
		
	}



	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void deleteVet(){
		boolean sentinel = false;

		for (int i = 0; i < emergency.getPets().length && !sentinel ; i++) {

			if (emergency.getPets()[i] != null) {
			System.out.println("------------------------------------------");
			System.out.print("NO se puede eliminar un veterinario, porque ya hay mascotas registradas\n");
			sentinel = true;
			}

		} if(sentinel == false){
			System.out.println("Por favor ingrese el numero de identificacion del veterinario que desea eliminar:\n");
			System.out.print("Numero de identificacion: ");
			String idNumber = sc.nextLine();
			System.out.println("------------------------------------------");
			emergency.deleteVeterinary(idNumber);
			System.out.println("------------------------------------------");
		}
	}




	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void newPet(){
		System.out.println("=====================================\n Formato de Registro de Nueva mascota \n=====================================\n");
		System.out.print("Ingrese el nombre de la mascota: ");
		String petName = sc.nextLine();

		System.out.print("Ingrese la edad de la mascota: ");
		int age = sc.nextInt();
		sc.nextLine();

		System.out.println("Selecciona el numero que corresponde a la especie de la mascota\n"+
		"(1) PERRO\n" + 
		"(2) GATO\n" + 
		"(3) CONEJO\n" + 
		"(4) REPTIL\n" + 
		"(5) PAJARO");
		int ch = sc.nextInt();
		sc.nextLine();

		String race = "";
		Specie specie = Specie.PERRO;
		if (ch == 1) {
			specie = Specie.PERRO;
			System.out.println("Ingrese la raza de la mascota");
			race = sc.nextLine();
		} else if (ch == 2) {
			specie = Specie.GATO;
			System.out.println("Ingrese la raza de la mascota");
			race = sc.nextLine();
		} else if (ch == 3) {
			 specie = Specie.CONEJO;
		} else if (ch == 4) {
			 specie = Specie.REPTIL;
		} else {
			 specie = Specie.PAJARO;
		}

		System.out.println("\nA continuacion ingresa la informacion del propietario de la mascota");
		System.out.print("Numero de identificacion: ");
		String idNumber = sc.nextLine();							
		System.out.print("Nombre: ");
		String ownerName = sc.nextLine();
		System.out.print("Telefono: ");
		String phone = sc.nextLine();
		System.out.print("Direccion: ");
		String address = sc.nextLine();

		System.out.println("\nIngresa ahora los sintomas de la mascota");
		String sintomas = sc.nextLine();
		System.out.println("\nSelecciona el numero que corresponde a la prioridad para la mascota\n"+
		"(1) Necesita atencion de forma inmediata\n" + 
		"(2) El tiempo de espera es maximo 10 minutos\n" + 
		"(3) La atencion puede demorarse 60 minutos\n" +
		"(4) La atencion puede demorarse 2 horas\n" +
		"(5) La atencion puede demorarse 4 horas");                    
		int chose1 = sc.nextInt();
		sc.nextLine();
		Priority prioridad = Priority.PRIORIDAD_1;
		if (chose1 == 1) {
			prioridad = Priority.PRIORIDAD_1;
		} else if (chose1 == 2) {
			prioridad = Priority.PRIORIDAD_2;
		} else if (chose1 == 3) {
			prioridad = Priority.PRIORIDAD_3;
		} else if (chose1 == 4) {
			prioridad = Priority.PRIORIDAD_4;
		} else {
			prioridad = Priority.PRIORIDAD_5;
		}
		if (comprobation(petName, ownerName)) {
			System.out.println("Esta combinacion de nombre de la mascota y del propietario ya existe");
		} else {
			if (ch == 1 || ch == 2) {
				emergency.addPet(petName, age, specie, new PetOwner(idNumber, ownerName, phone, address),  sintomas,  prioridad, race);
			} else {
				emergency.addPet(petName, age, specie, new PetOwner(idNumber, ownerName, phone, address),  sintomas,  prioridad);
			}
		}
	}



	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public boolean comprobation(String petName, String ownerName){
		boolean sentinel = false;
		for(int i = 0; i < emergency.getPets().length && !sentinel; i++){
			if ((emergency.getPets()[i] != null && emergency.getPets()[i].getName().equalsIgnoreCase(petName)) && (emergency.getPets()[i].getPetOwner() != null && emergency.getPets()[i].getPetOwner().getName().equalsIgnoreCase(ownerName))) {
				sentinel = true;
			}
		} 
		return sentinel;
	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void removePet(){
		boolean sentinel = false;

		for (int i = 0; i < emergency.getPets().length && !sentinel; i++) {

			if (emergency.verifyIfPetsIsNull() == true) {
			System.out.println("------------------------------------------");
			System.out.println("NO se pueden remover mascotas, porque no hay ninguna registrada");
			sentinel = true;
			}

		} if(sentinel == false){
			System.out.println("Ingrese el nombre de la mascota");
			String petName = sc.nextLine();
			System.out.println("Ingrese el Numero de identificacion del propietario de la mascota");
			String idNumber = sc.nextLine();
			boolean find = false;
			for(int i = 0; i < emergency.getPets().length && !find; i++){
				if ((emergency.getPets()[i] != null && emergency.getPets()[i].getName().equalsIgnoreCase(petName)) && (emergency.getPets()[i].getPetOwner() != null && emergency.getPets()[i].getPetOwner().getIdNumber().equalsIgnoreCase(idNumber))) {
					if (emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.ESPERANDO_SER_ATENDIDO) {
					emergency.removePet(petName, idNumber);
					}
				find = true;
			}
		}
		}







	}


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void startConsultation(){
		
		System.out.println(emergency.showVets());
		if((emergency.showVets()).equals("No hay veterinarios registrados")){
			System.out.println();
		} else{
			System.out.println("\nPorfavor digita el numero de identificacion del veterinario que iniciara su consulta: ");
			System.out.print("Numero de identificacion: ");
			String idNumber = sc.nextLine();
			System.out.println("");
			
			int indexToStartConsult = emergency.findVet(idNumber);
			
			if(indexToStartConsult != -1){
				System.out.println(emergency.startConsult(indexToStartConsult));
			} else{
				System.out.println("------------------------------------------");
				System.out.println("No existe ningun veterinario con esa identificacion");
				System.out.println("------------------------------------------");
			}
			
			System.out.println("===============================================================");
		}
		
	}

	


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void finishConsultation(){
		String idNumber, namePet;
		int indexVet, option = 0;
		
		System.out.println(emergency.showVets());
		if((emergency.showVets()).equals("No hay veterinarios registrados")){
			System.out.println();
		} else{
			System.out.println("\nPor favor ingrese el numero de identificacion del veterinario que desea finalizar su consulta:");
			System.out.print("Numero de identificacion: ");
			idNumber = sc.nextLine();
			System.out.print("Nombre de la mascota quien esta atendiendo: ");
			namePet = sc.nextLine();
			
			indexVet = emergency.findVet(idNumber);
			
			if(indexVet != -1){
				do{
					System.out.println("Escoja la opcion que desea:");
					System.out.println("(1) Para autorizar la salida");
					System.out.println("(2) Para pasar la mascota a hospitalizacion");
					System.out.print("Opcion: ");
					option = sc.nextInt();
					sc.nextLine();
					
					switch(option){
						case 1:
						option = 1;
						break;
						case 2:
						option = 2;
						break;
						default:
						option = 0;
						break;
					}
					
				}while(option == 0);
				
				Pet petToTransfer = emergency.finishConsult(indexVet, namePet, option);
				
				
				if(petToTransfer.getPetAux() == 1){
					System.out.println("Se ha autorizado la salida de la mascota");
				} 
				else if(petToTransfer.getPetAux() == 3)

				{
					System.out.println("El veterinario escogido no se encuentra atendiendo una mascota con esas caracteristicas");
				} else if(petToTransfer.getPetAux() == 4){
					System.out.println("Actualmente no hay mascotas registradas en el centro");
				} else{
					transferToPetDaycare(emergency.finishConsult(indexVet, namePet, option));
				}
				
			} else{System.out.println("No existe ningun veterinario con esa identificacion");}
				System.out.println("===================================");
		}
		
	}



	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void petNumber(){
		System.out.println("-----------------------------------------------------");
		System.out.println("El numero de mascotas que faltan por atender son: " + emergency.petsNumber());
		System.out.println("-----------------------------------------------------\n");
	}





	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void closeCenter(){
		
		boolean sentinel = false;

		for (int i = 0; i < emergency.getPets().length && !sentinel; i++) {
			if (emergency.getPets()[i] != null && emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.ESPERANDO_SER_ATENDIDO) {
				System.out.println("No se puede realizar el cierre del PetCenter porque aun quedan mascotas por atender");
				sentinel = true;
			}
		} 
		
		if (sentinel == false) {

			int max = 0;
			for (int i = 0; i < emergency.getVets().length ; i++) {
				if (emergency.getVets()[i] != null && max < emergency.getVets()[i].getPetsAttended()) {
					max = emergency.getVets()[i].getPetsAttended();
				}
			}
			

			if(emergency.getVets()[max] != null){
				if (max == 0) {
					System.out.println("Ningun veterinario atendio una mascota, por lo tanto no hay mayor");

				}else{
					System.out.println("El veterinario que tuvo el mayor numero de consultas fue: " + emergency.getVets()[max].getName());
				}
				
			}else{
				System.out.println("No existen veterinarios");
			}
			
			int count =0;
			for (int i = 0; i < emergency.getPets().length && ! sentinel; i++) {
				if ((emergency.getPets()[i] != null && emergency.getPets()[i].getPriority() == Priority.PRIORIDAD_1) && (emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.SALIDA_AUTORIZADA || emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.TRASLADO_A_HOSPITALIZACION)) {
					count++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 1 fueron: "+ count); 
			int count1 =0;
			for (int i = 0; i < emergency.getPets().length && ! sentinel; i++) {
				if ((emergency.getPets()[i] != null && emergency.getPets()[i].getPriority() == Priority.PRIORIDAD_2) && (emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.SALIDA_AUTORIZADA || emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.TRASLADO_A_HOSPITALIZACION)) {
					 count1++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 2 fueron: "+ count1);
			int count2 =0;
			for (int i = 0; i < emergency.getPets().length && ! sentinel; i++) {
				if ((emergency.getPets()[i] != null && emergency.getPets()[i].getPriority() == Priority.PRIORIDAD_3) && (emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.SALIDA_AUTORIZADA || emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.TRASLADO_A_HOSPITALIZACION)) {
					 count2++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 3 fueron: "+ count2);
			int count3 =0;
			for (int i = 0; i < emergency.getPets().length && ! sentinel; i++) {
				if ((emergency.getPets()[i] != null && emergency.getPets()[i].getPriority() == Priority.PRIORIDAD_4) && (emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.SALIDA_AUTORIZADA || emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.TRASLADO_A_HOSPITALIZACION)) {
					 count3++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 4 fueron: "+ count3);
			int count4 =0;
			for (int i = 0; i < emergency.getPets().length && ! sentinel; i++) {
				if ((emergency.getPets()[i] != null && emergency.getPets()[i].getPriority() == Priority.PRIORIDAD_5) && (emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.SALIDA_AUTORIZADA || emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.TRASLADO_A_HOSPITALIZACION)) {
					 count4++;
				} 
			} System.out.println("La cantidad de mascotas atendidas de prioridad 5 fueron: "+ count4);

			int percentage = 0;
			int without = 0;
			int total = 0;

			if (emergency.verifyIfPetsIsNull() == false) {
				for (int i = 0; i < emergency.getPets().length; i++) {
					if (emergency.getPets()[i] != null) {
						if (emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.SALIDA_SIN_ATENCION) {
							without++;
						}
						total++;
					} 
					
				} 
				
			}else{
				System.out.println("No hay mascotas");
			}

			if (emergency.verifyIfPetsIsNull() == false) {
				percentage = (without * 100)/total;
				System.out.println("El porcentaje de mascotas que se fueron sin atender son: "+percentage+" %");
			}


		}
	}


	//TAREA INTEGRADORA 3

	public void transferToPetDaycare(Pet petToTransfer){
		
		if(petToTransfer.getSpecie() == Specie.PERRO){
			if(ki.verifyIfThereRoomsForDOG() == true){
				
				System.out.println(ki.addDogInDaycare(petToTransfer));
				
			} else{System.out.println("No hay espacio para hospitalizar la mascota");}
			
		} else if(petToTransfer.getSpecie() == Specie.GATO){
			if(ki.verifyIfThereRoomsForCAT() == true){
				
				System.out.println(ki.addCatInDaycare(petToTransfer));
				
			} else{System.out.println("No hay espacio para hospitalizar la mascota");}
			
		} else if(petToTransfer.getSpecie() == Specie.CONEJO){
			if(ki.verifyIfThereRoomsForRABBIT() == true){
				
				System.out.println(ki.addRabbitInDaycare(petToTransfer));
				
			} else{System.out.println("No hay espacio para hospitalizar la mascota");}
			
		} else if(petToTransfer.getSpecie() == Specie.REPTIL){
			if(ki.verifyIfThereRoomsForREPTILE() == true){
				
				System.out.println(ki.addReptileInDaycare(petToTransfer));
				
			} else{System.out.println("No hay espacio para hospitalizar la mascota");}
			
		} else if(petToTransfer.getSpecie() == Specie.PAJARO)

		{
			if(ki.verifyIfThereRoomsForBIRD() == true){
				
				System.out.println(ki.addBirdInDaycare(petToTransfer));
				
			} else{
				System.out.println("No hay espacio para hospitalizar la mascota");
			}
			
		}
			
	}
	
	public void addPetInPetDaycare(){
		
		int option = 0;
		
		do{
			System.out.println("Porfavor llene el siguiente formulario de inscripcion:");
			System.out.println("- Especie de la mascota: ");
			System.out.println("( 1 ) PERRO");
			System.out.println("( 2 ) GATO");
			System.out.println("( 3 ) CONEJO");
			System.out.println("( 4 ) REPTIL");
			System.out.println("( 5 ) AVE");
			
			System.out.print("opcion: ");
			option = sc.nextInt();
			sc.nextLine();
			
			switch(option){
			case 1:
			if(ki.verifyIfThereRoomsForDOG() == true){
				Specie dog = Specie.PERRO;
				System.out.print("Raza de la mascota: ");
				String race = sc.nextLine();
				System.out.print("Nombre de la mascota: ");
				String namePet = sc.nextLine();
				System.out.print("Edad de la mascota: ");
				int agePet = sc.nextInt();
				sc.nextLine();
				
				System.out.println("===============================");
				System.out.println("==== DATOS DEL RESPONSABLE ====");
				System.out.println("===============================\n");
				System.out.print("ID: ");
				String idOwner = sc.nextLine();
				System.out.print("Nombre: ");
				String nameOwner = sc.nextLine();
				System.out.print("Telefono: ");
				String phone = sc.nextLine();
				System.out.print("Direccion: ");
				String address = sc.nextLine();
				System.out.println("===================================");
				System.out.print("Dias de hospitalizacion: ");
				int days = sc.nextInt();
				sc.nextLine();

				
				PetOwner owner = new PetOwner(idOwner, nameOwner, phone, address);
				Pet newDog = new Pet(dog, race, namePet, agePet, owner, days);
				
				System.out.println(ki.addPet(option, newDog));
				
			} else{
				System.out.println("No hay habitats disponibles para perros");
			}
			break;
			case 2:
			if(ki.verifyIfThereRoomsForCAT() == true){
				Specie cat = Specie.GATO;
				System.out.print("Raza de la mascota: ");
				String race = sc.nextLine();
				System.out.print("Nombre de la mascota: ");
				String namePet = sc.nextLine();
				System.out.print("Edad de la mascota: ");
				int agePet = sc.nextInt();
				sc.nextLine();
				
				System.out.println("===============================");
				System.out.println("==== DATOS DEL RESPONSABLE ====");
				System.out.println("===============================\n");
				System.out.print("ID: ");
				String idOwner = sc.nextLine();
				System.out.print("Nombre: ");
				String nameOwner = sc.nextLine();
				System.out.print("Telefono: ");
				String phone = sc.nextLine();
				System.out.print("Direccion: ");
				String address = sc.nextLine();
				System.out.println("===================================");
				System.out.print("Dias de hospitalizacion: ");
				int days = sc.nextInt();
				sc.nextLine();
				
				PetOwner owner = new PetOwner(idOwner, nameOwner, phone, address);
				Pet newCat = new Pet(cat, race, namePet, agePet, owner, days);
				
				System.out.println(ki.addPet(option, newCat));
				
			} else{System.out.println("No hay habitats disponibles para gatos");}
			break;
			case 3:
			if(ki.verifyIfThereRoomsForRABBIT() == true){
				Specie rabbit = Specie.CONEJO;
				System.out.print("Nombre de la mascota: ");
				String namePet = sc.nextLine();
				System.out.print("Edad de la mascota: ");
				int agePet = sc.nextInt();
				sc.nextLine();
				
				System.out.println("===============================");
				System.out.println("==== DATOS DEL RESPONSABLE ====");
				System.out.println("===============================\n");
				System.out.print("ID: ");
				String idOwner = sc.nextLine();
				System.out.print("Nombre: ");
				String nameOwner = sc.nextLine();
				System.out.print("Telefono: ");
				String phone = sc.nextLine();
				System.out.print("Direccion: ");
				String address = sc.nextLine();
				System.out.println("===================================");
				System.out.print("Dias de hospitalizacion: ");
				int days = sc.nextInt();
				sc.nextLine();
				
				PetOwner owner = new PetOwner(idOwner, nameOwner, phone, address);
				Pet newRabbit = new Pet(rabbit, namePet, agePet, owner, days);
				
				System.out.println(ki.addPet(option, newRabbit));
				
			} else{
				System.out.println("No hay habitats disponibles para conejos");
			}
			break;
			case 4:
			if(ki.verifyIfThereRoomsForREPTILE() == true){
				Specie reptil = Specie.REPTIL;
				System.out.print("Nombre de la mascota: ");
				String namePet = sc.nextLine();
				System.out.print("Edad de la mascota: ");
				int agePet = sc.nextInt();
				sc.nextLine();
				
				System.out.println("===============================");
				System.out.println("==== DATOS DEL RESPONSABLE ====");
				System.out.println("===============================\n");
				System.out.print("ID: ");
				String idOwner = sc.nextLine();
				System.out.print("Nombre: ");
				String nameOwner = sc.nextLine();
				System.out.print("Telefono: ");
				String phone = sc.nextLine();
				System.out.print("Direccion: ");
				String address = sc.nextLine();
				System.out.println("===================================");
				System.out.print("Dias de hospitalizacion: ");
				int days = sc.nextInt();
				sc.nextLine();
				
				PetOwner owner = new PetOwner(idOwner, nameOwner, phone, address);
				Pet newReptile = new Pet(reptil, namePet, agePet, owner, days);
				
				System.out.println(ki.addPet(option, newReptile));
				
			} else{
				System.out.println("No hay habitats disponibles para reptiles");
			}
			break;
			case 5:
			if(ki.verifyIfThereRoomsForBIRD() == true){
				Specie bird = Specie.PAJARO;
				System.out.print("Nombre de la mascota: ");
				String namePet = sc.nextLine();
				System.out.print("Edad de la mascota: ");
				int agePet = sc.nextInt();
				sc.nextLine();
				
				System.out.println("===============================");
				System.out.println("==== DATOS DEL RESPONSABLE ====");
				System.out.println("===============================\n");
				System.out.print("ID: ");
				String idOwner = sc.nextLine();
				System.out.print("Nombre: ");
				String nameOwner = sc.nextLine();
				System.out.print("Telefono: ");
				String phone = sc.nextLine();
				System.out.print("Direccion: ");
				String address = sc.nextLine();
				System.out.println("===================================");
				System.out.print("Dias de hospitalizacion: ");
				int days = sc.nextInt();
				sc.nextLine();							//YA GUARDEMOS Y PROBEMOS LA OPCION UNO DE LA GUARDERIA
				
				PetOwner owner = new PetOwner(idOwner, nameOwner, phone, address);
				Pet newBird = new Pet(bird, namePet, agePet, owner, days);
				
				System.out.println(ki.addPet(option, newBird));
				
			} else{System.out.println("No hay habitats disponibles para aves");}
			break;
			default:
			option = 0;
			break;
		}
			
		}while(option == 0);
		
	
		
		
	}
	
	public void findPetInPetDaycare(){
		System.out.println("Porfavor ingrese el nombre de la mascota que desea buscar:");
		System.out.print("Nombre: ");
		String namePet = sc.nextLine();
		
		System.out.println(ki.findPet(namePet));
		
	}
	
	public void showPetDaycareMap(){
		
		System.out.println(ki.showMap());
	}
	
	public void showInfoHabitat(){
		System.out.println("Porfavor ingrese el identificador del habitat:");
		System.out.print("ID: ");
		String idHabitat = sc.nextLine();
		
		System.out.println(ki.infoHabitat(idHabitat));
		
	}
	
	public void showStats(){
		System.out.println(ki.stats());
	}
	
	






}
	

