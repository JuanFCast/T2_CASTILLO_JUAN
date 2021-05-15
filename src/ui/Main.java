package ui;
import model.EmergencyCenter;

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
		do{
			option = t2.showMenu();
			
			switch(option){
				case 1:
				t2.addVeterinay();
				break;

				case 2:
				System.out.println("(2) Eliminar un veterinario");
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
		String idNumber = "", name = "", lastName = "", idVeterinary = "";
		
		System.out.println("Porfavor ingrese los siguientes datos del Veterinario:\n");
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





		
		





}
	

