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
		t2.showMenu();
		//t2.answerOption(showMenu());
	}
	
	//Method Menu
	public int showMenu(){
		int option;

    	System.out.println("MENU DE ACTIVIDADES\n");
        System.out.println("A continuacion selecciona una opcion:");
		System.out.println("(1) Añadir un nuevo veterinario");
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






		
		





}
	

