package ui;
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
	* Description: 
	*/ 
	private EmergencyCenter emergency;


	/**
	* Description: 
	*/ 
	private static int optionM;
	

	//Constructor para evitar el static
	public Main() {
    sc = new Scanner(System.in);
    emergency = new EmergencyCenter();
	optionM = 0;
    }

	public static void main(String[] args) {
		Main t2 = new Main();
		System.out.println("------------------------------------------");
		System.out.println("-----BIENVENID@ AL CENTRO VETERINARIO-----");
		System.out.println("------------------------------------------");

		

		
		do{
			optionM = t2.showMenu();
			
			switch(optionM){
				case 1:
				t2.addVeterinay();
				break;

				case 2:
				t2.deleteVet();
				break;

				case 3:
				t2.newPet();
				break;

				case 4:
				t2.removePet();
				break;
				
				case 5:
				t2.startConsultation();
				break;

				case 6:
				t2.finishConsultation();
				break;

				case 7:
				t2.petNumber();
				break;

				case 8:
				t2.closeCenter();
				break;

				default:
				optionM = 0;
				break;
			}
			
		}while(optionM != 0);
	}
	

	//Metodos


	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public int showMenu(){
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

		System.out.println("(0) Finalizar programa\n");

		System.out.print("Opcion: ");
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
    	
	}

	
	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void addVeterinay(){
		String idNumber = "", name = "", lastName = "", idVeterinary = "";
		
		System.out.println("==========================\n Formato de Registro de Nuev@ Veterinari@ \n==========================\n");
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
			System.out.print("NO se puede eliminar un veterinario, porque ya hay mascotas registradas");
			sentinel = true;
			}

		} if(sentinel == false){
			System.out.println("Por favor ingrese el numero de identificacion del veterinario que desea eliminar:\n");
			System.out.print("Numero de identificacion: ");
			String idNumber = sc.nextLine();
			System.out.println("------------------------------------------");
			emergency.deleteVeterinary(idNumber);
		}
	}




	/**
	* Description: This method is in charge of calculating the projection of the IPC for the year 2021.
	* pre: The IPC variable must have the values from the table or the values entered by the user. 
	* @param pib int, the parameter is that the program can only continue if the values are integers.
	* @return count String, returns a text string with the prediction of 2021 requested by the user.
	*/
	public void newPet(){
		System.out.println("==========================\n Formato de Registro de Nueva mascota \n==========================\n");
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

		System.out.println("A continuacion ingresa la informacion del propietario de la mascota");
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
		System.out.println("Selecciona el numero que corresponde a la prioridad para la mascota\n"+
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
		System.out.println("Ingrese el nombre de la mascota");
		String petName = sc.nextLine();
		System.out.println("Ingrese el ID del propietario de la mascota");
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
			System.out.println("Porfavor digita el numero de identificacion del veterinario que iniciara su consulta: ");
			System.out.print("CC: ");
			String idNumber = sc.nextLine();
			System.out.println("");
			
			int indexToStartConsult = emergency.findVet(idNumber);
			
			if(indexToStartConsult != -1){
				System.out.println(emergency.startConsult(indexToStartConsult));
			} else{System.out.println("No existe ningun veterinario con esa identificacion");}
			
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
			System.out.println("Por favor ingrese el numero de identificacion del veterinario que desea finalizar su consulta:\n");
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
		System.out.println("El numero de mascotas que faltan por atender son: " + emergency.petsNumber());
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
				System.out.println("El veterinario que tuvo el mayor numero de consultas fue: " + emergency.getVets()[max].getName());
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
			for (int i = 0; i < emergency.getPets().length; i++) {
				if (emergency.getPets()[i] != null && emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.SALIDA_SIN_ATENCION) {
					without++;
				} total++;
			} 
			percentage = (without * 100)/total;
			System.out.println("El porcentaje de mascotas que se fueron sin atender son: "+percentage+" %");
			for (int i = 0; i < emergency.getPets().length; i++) {
				if (emergency.getPets()[i] != null && emergency.getPets()[i].getConsultationStatus() == ConsultationStatus.SALIDA_AUTORIZADA) {
					emergency.getPets()[i] = null;
				}
			}
			
			optionM = 0;
		}
	}

}
	

