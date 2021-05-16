package ui;
import model.EmergencyCenter;
import model.Specie;
import model.ConsultationStatus;
import model.Priority;
import model.PetOwner;

import java.util.Scanner;


public class Main{
	public Scanner sc;
	private EmergencyCenter emergency;

	//Constructor para evitar el static
	public Main() {
    sc = new Scanner(System.in);
    emergency = new EmergencyCenter();
    	
    }

	public static void main(String[] args) {
		Main t2 = new Main();
		System.out.println("------------------------------------------");
		System.out.println("-----BIENVENID@ AL CENTRO VETERINARIO-----");
		System.out.println("------------------------------------------");

		int option;

		//t2.mostrar();
		do{
			option = t2.showMenu();
			
			switch(option){
				case 1:
				t2.addVeterinay();
				break;

				case 2:
				t2.deleteVet();
				break;

				case 3:
				System.out.println("(3) Registrar una mascota");
				break;

				case 4:
				System.out.println("(4) Retirar una mascota\n");
				break;
				case 5:
				System.out.println("(5) Iniciar una consulta");
				break;

				case 6:
				
				break;

				case 7:
				
				break;

				case 8:
				
				break;

				default:
				option = 0;
				break;
			}
			
		}while(option != 0);
	}
	
	//Method Menu
	public int showMenu(){
		int option;

    	System.out.println("MENU DE ACTIVIDADES\n");
        System.out.println("A continuacion selecciona una opcion:");
		System.out.println("(1) A\u00f1adir un nuevo veterinario");
		System.out.println("(2) Eliminar un veterinario");
		System.out.println("(3) Registrar una mascota");
		System.out.println("(4) Retirar una mascota\n");
		System.out.println("(5) Iniciar una consulta");
		System.out.println("\n( ) Cualquier otro numero para salir\n");

		System.out.print("Opcion: ");
		option = sc.nextInt();
		sc.nextLine();
		
		return option;
    	
	}

	

	public void addVeterinay(){
		String idNumber = "", name = "", lastName = "", idVeterinary = "", status = "";
		
		System.out.println("Porfavor ingrese los siguientes datos del Veterinario:\n");
		System.out.print("Numero de identificacion: ");
		idNumber = sc.nextLine();

		System.out.print("Nombres: ");
		name = sc.nextLine();

		System.out.print("Apellidos: ");
		lastName = sc.nextLine();

		System.out.print("Registro unico veterinario: ");
		idVeterinary = sc.nextLine();

		System.out.print("REstado del veterinario: ");
		idVeterinary = sc.nextLine();
		
		System.out.println(emergency.addVeterinay(idNumber, name, lastName, idVeterinary, status));
		
	}




	public void deleteVet(){
		boolean sentinel = false;

		for (int i = 0; i < emergency.getPets().length && !sentinel ; i++) {

			if (emergency.getPets()[i] != null) {
			System.out.print("NO se puede eliminar un veterinario, porque ya hay mascotas registradas");
			sentinel = true;
			}

		} if(sentinel == false){
			System.out.println("Porfavor ingrese el numero de identificacion del veterinario que desea eliminar:\n");
			System.out.print("Numero de identificacion: ");
			String idNumber = sc.nextLine();
			System.out.println("------------------------------------------");
			emergency.deleteVeterinary(idNumber);
		}
	}

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
		System.out.print("Direccion");
		String address = sc.nextLine();

		System.out.println("\nIngresa ahora los sintomas de la mascota");
		String sintomas = sc.nextLine();
		System.out.println("Selecciona el numero que corresponde a la prioridad para la mascota\n"+
		"(1) Prioridad 1\n" + 
		"(2) Prioridad 2\n" + 
		"(3) Prioridad 3\n" +
		"(4) Prioridad 4\n" +
		"(5) Prioridad 5");                    
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




	public boolean comprobation(String petName, String ownerName){
		boolean sentinel = false;
		for(int i = 0; i < emergency.getPets().length && !sentinel; i++){
			if ((emergency.getPets()[i] != null && emergency.getPets()[i].getName().equalsIgnoreCase(petName)) && (emergency.getPets()[i].getPetOwner() != null && emergency.getPets()[i].getPetOwner().getName().equalsIgnoreCase(ownerName))) {
				sentinel = true;
			}
		} 
		return sentinel;
	}


	/*
	public void removePet(){
		System.out.println("Ingrese el nombre de la mascota");
		String petName = sc.nextLine();
		System.out.println("Ingrese el ID del propietario de la mascota");
		String idNumber = sc.nextLine();
		boolean find = false;
		for(int i = 0; i < emergency.getPets().length && !find; i++){
			if ((emergency.getPets()[i] != null && emergency.getPets()[i].getName().equalsIgnoreCase(petName)) && (emergency.getPets()[i].getOwner() != null && emergency.getPets()[i].getOwner().getIdNumber().equalsIgnoreCase(idNumber))) {
				if (emergency.getPets()[i].getStatus() == Status.ESPERANDO_SER_ATENDIDO) {
					emergency.removePet(petName, idNumber);
				}
				find = true;
			}
		}
	}
	*/

	

}
	

