package ui;                                             // javac -cp src src/ui/Main.java -d bin
														// java -cp bin ui.Main
														// javadoc -cp src -subpackages model:ui -d docs/javadoc/                                        
import model.EmergencyCenter;
import model.Specie;
import model.ConsultationStatus;
import model.Priority;
import model.PetOwner;


import java.util.Scanner;


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
	* Description: Esta variable se encarga de cerrar el programa
	*/ 
	private static int optionM;
	

	//No se que colocar aqui
	public Main() {
    sc = new Scanner(System.in);
    emergency = new EmergencyCenter();
	optionM = 0;
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
                    //election = kindergartenMenu();
                    //cent = kindergartenFunctions(election);
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



	public boolean kindergartenFunctions(int option){
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
				
				System.out.println(emergency.finishConsult(indexVet, namePet, option));
				
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


			optionM = 0;
		}
	}


	//TAREA INTEGRADORA 3


	

	




}
	

