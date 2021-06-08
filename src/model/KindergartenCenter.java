package model;

public class KindergartenCenter{
	//Maximum of rooms for pets
	private final int ROWMATRIX = 6;
	private final int COLUMNMATRIX = 5;

    //for cats
	private static final int MIN_CAT_ROW = 0;
	private static final int MAX_CAT_ROW = 2;
	private static final int MIN_CAT_COL = 0;
	private static final int MAX_CAT_COL = 2;

	//for dogs
	private static final int MIN_DOG_ROW = 3;
	private static final int MAX_DOG_ROW = 5;
	private static final int MIN_DOG_COL = 0;
	private static final int MAX_DOG_COL = 2;

	//for reptiles
	private static final int MIN_REPTILE_ROW = 0;
	private static final int MAX_REPTILE_ROW = 1;
	private static final int MIN_REPTILE_COL = 3;
	private static final int MAX_REPTILE_COL = 4;

	//for rabbits
	private static final int MIN_RABBIT_ROW = 2;
	private static final int MAX_RABBIT_ROW = 3;
	private static final int MIN_RABBIT_COL = 3;
	private static final int MAX_RABBIT_COL = 4;

	//for birds
	private static final int MIN_BIRD_ROW = 4;
	private static final int MAX_BIRD_ROW = 5;
	private static final int MIN_BIRD_COL = 3;
	private static final int MAX_BIRD_COL = 4;


    private PetHabitat[][] habitats;


    public KindergartenCenter(){
		habitats = new PetHabitat[ROWMATRIX][COLUMNMATRIX];
		createAreas();
	}

	//organize habitats
	private void createAreas(){
		organizeHabitats(MIN_DOG_ROW, MAX_DOG_ROW, MIN_DOG_COL, MAX_DOG_COL, 1);
		organizeHabitats(MIN_CAT_ROW, MAX_CAT_ROW, MIN_CAT_COL, MAX_CAT_COL, 2);
		organizeHabitats(MIN_BIRD_ROW, MAX_BIRD_ROW, MIN_BIRD_COL, MAX_BIRD_COL, 3);
		organizeHabitats(MIN_REPTILE_ROW, MAX_REPTILE_ROW, MIN_REPTILE_COL, MAX_REPTILE_COL, 4);
		organizeHabitats(MIN_RABBIT_ROW, MAX_RABBIT_ROW, MIN_RABBIT_COL, MAX_RABBIT_COL, 5);
	}

	private void organizeHabitats(int minRows, int maxRows, int minCol, int maxCol, int species){
		int contArea = 1;
		for( int rows = minRows; rows <=  maxRows; rows++ ){

			for( int col = minCol; col <= maxCol; col++ ){

				switch(species){
					case 1:
					habitats[rows][col] = new DogHabitat( "DH" + contArea, 3.5, 4.5, 5);
					break;

					case 2:
					habitats[rows][col] = new CatHabitat( "CH" + contArea, 4.5, 5.5, 7.5, 2.5);
					break;

					case 3:
					habitats[rows][col] = new BirdHabitat( "BH" + contArea, 6.5, 2.5, 7.5, 4, CageType.CAGE_IN_LAND);
					if( rows == 5 ){
						habitats[rows][col] = new BirdHabitat( "BH" + contArea, 6.5, 2.5, 7.5, 4, CageType.HANGING_CAGE);
					}
					break;

					case 4:
					habitats[rows][col] = new ReptileHabitat( "ReH" + contArea, 8.5, 7.5, "ACETATE", ReptileTypeH.FOR_AMPHIBIANS);
					if( rows == 1  ){
						habitats[rows][col] = new ReptileHabitat( "ReH" + contArea, 8.5, 7.5, "ACRYLIC", ReptileTypeH.ONLY_LAND);
					}
					break;

					case 5:
					habitats[rows][col] = new RabbitHabitat( "RaH" + contArea, 10, 5.5, "LETTUCE", 6);
					break;
				}		
				contArea++;
			}
		}
	}

	//Methods
	
	//To add CATS
	public boolean verifyIfThereRoomsForCAT(){
		boolean confirmation = false;
		
		for(int i = MIN_CAT_ROW; (i <= MAX_CAT_ROW) && !confirmation; i++){
			for(int j = MIN_CAT_COL; (j <= MAX_CAT_COL) && !confirmation; j++){
				if(habitats[i][j].getPetHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addCatInDaycare(Pet cat){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = MIN_CAT_ROW; (i <= MAX_CAT_ROW) && !sentinel; i++){
			for(int j = MIN_CAT_COL; (j <= MAX_CAT_COL) && !sentinel; j++){
				if(habitats[i][j].getPetHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetHabitat(cat);
					habitats[i][j].setUseState(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add DOGS
	public boolean verifyIfThereRoomsForDOG(){
		boolean confirmation = false;
		
		for(int i = MIN_DOG_ROW; (i <= MAX_DOG_ROW) && !confirmation; i++){
			for(int j = MIN_DOG_COL; (j <= MAX_DOG_COL) && !confirmation; j++){
				if(habitats[i][j].getPetHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addDogInDaycare(Pet dog){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = MIN_DOG_ROW; (i <= MAX_DOG_ROW) && !sentinel; i++){
			for(int j = MIN_DOG_COL; (j <= MAX_DOG_COL) && !sentinel; j++){
				if(habitats[i][j].getPetHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetHabitat(dog);
					habitats[i][j].setUseState(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add REPTILES
	public boolean verifyIfThereRoomsForREPTILE(){
		boolean confirmation = false;
		
		for(int i = MIN_REPTILE_ROW; (i <= MAX_REPTILE_ROW) && !confirmation; i++){
			for(int j = MIN_REPTILE_COL; (j <= MAX_REPTILE_COL) && !confirmation; j++){
				if(habitats[i][j].getPetHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addReptileInDaycare(Pet reptile){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = MIN_REPTILE_ROW; (i <= MAX_REPTILE_ROW) && !sentinel; i++){
			for(int j = MIN_REPTILE_COL; (j <= MAX_REPTILE_COL) && !sentinel; j++){
				if(habitats[i][j].getPetHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetHabitat(reptile);
					habitats[i][j].setUseState(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add RABBITS
	public boolean verifyIfThereRoomsForRABBIT(){
		boolean confirmation = false;
		
		for(int i = MIN_RABBIT_ROW; (i <= MAX_RABBIT_ROW) && !confirmation; i++){
			for(int j = MIN_RABBIT_COL; (j <= MAX_RABBIT_COL) && !confirmation; j++){
				if(habitats[i][j].getPetHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addRabbitInDaycare(Pet rabbit){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = MIN_RABBIT_ROW; (i <= MAX_RABBIT_ROW) && !sentinel; i++){
			for(int j = MIN_RABBIT_COL; (j <= MAX_RABBIT_COL) && !sentinel; j++){
				if(habitats[i][j].getPetHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetHabitat(rabbit);
					habitats[i][j].setUseState(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add BIRDS
	public boolean verifyIfThereRoomsForBIRD(){
		boolean confirmation = false;
		
		for(int i = MIN_BIRD_ROW; (i <= MAX_BIRD_ROW) && !confirmation; i++){
			for(int j = MIN_BIRD_COL; (j <= MAX_BIRD_COL) && !confirmation; j++){
				if(habitats[i][j].getPetHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addBirdInDaycare(Pet bird){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = MIN_BIRD_ROW; (i <= MAX_BIRD_ROW) && !sentinel; i++){
			for(int j = MIN_BIRD_COL; (j <= MAX_BIRD_COL) && !sentinel; j++){
				if(habitats[i][j].getPetHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetHabitat(bird);
					habitats[i][j].setUseState(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//For addPet
	public String addPet(int option, Pet newPet){
		String confirmation = "";
		boolean sentinel = false;
		boolean sentinel2 = false;
		
		if(option == 1){
			for(int i = MIN_DOG_ROW; (i <= MAX_DOG_ROW) && !sentinel; i++){
				for(int j = MIN_DOG_COL; (j <= MAX_DOG_COL) && !sentinel2; j++){
					if(habitats[i][j].getPetHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetHabitat(newPet);
						habitats[i][j].setUseState(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
					}
				}
			}
		} else if(option == 2){
			for(int i = MIN_CAT_ROW; (i <= MAX_CAT_ROW) && !sentinel; i++){
				for(int j = MIN_CAT_COL; (j <= MAX_CAT_COL) && !sentinel2; j++){
					if(habitats[i][j].getPetHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetHabitat(newPet);
						habitats[i][j].setUseState(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
					}
				}
			}
		} else if(option == 3){
			for(int i = MIN_RABBIT_ROW; (i <= MAX_RABBIT_ROW) && !sentinel; i++){
				for(int j = MIN_RABBIT_COL; (j <= MAX_RABBIT_COL) && !sentinel2; j++){
					if(habitats[i][j].getPetHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetHabitat(newPet);
						habitats[i][j].setUseState(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
					}
				}
			}
		} else if(option == 4){
			for(int i = MIN_REPTILE_ROW; (i <= MAX_REPTILE_ROW) && !sentinel; i++){
				for(int j = MIN_REPTILE_COL; (j <= MAX_REPTILE_COL) && !sentinel2; j++){
					if(habitats[i][j].getPetHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetHabitat(newPet);
						habitats[i][j].setUseState(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
					}
				}
			}
		} else if(option == 5){
			for(int i = MIN_BIRD_ROW; (i <= MAX_BIRD_ROW) && !sentinel; i++){
				for(int j = MIN_BIRD_COL; (j <= MAX_BIRD_COL) && !sentinel2; j++){
					if(habitats[i][j].getPetHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetHabitat(newPet);
						habitats[i][j].setUseState(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getId() + ", located in the pet nursery";
					}
				}
			}
		}
		
		
		return confirmation;
	}
	
	//For find a pet
	public String findPet(String namePet){
		
		String confirmation = "";
		boolean sentinel = false;
		boolean sentinel2 = false;
		
		for(int i = 0; (i < ROWMATRIX) && !sentinel; i++){
			for(int j = 0; (j < COLUMNMATRIX) && !sentinel2; j++){
				if(habitats[i][j].getPetHabitat() != null){
					if((habitats[i][j].getPetHabitat().getName()).equals(namePet)){
						sentinel = true;
						sentinel2 = true;
						confirmation += "\nThe pet " + namePet + " is found in the habitat " + habitats[i][j].getId() + "\nYour current state is "; 
						
						if(habitats[i][j].getUseState() == UseState.OCCUPIED_SICK){
							confirmation += "SICK\n===================================================";
						} else{
							confirmation += "HEALTHY\n===================================================";
						}
					}

				} else{
					confirmation = "Could not find the most\n===================================================";
				}
			}
		}
		
		return confirmation;
	}


	public String showMap(){
		String useType = "";
		String map = "";
		for( int i = 0; i < habitats.length; i++ ){
			for( int j = 0; j < habitats[0].length; j++ ){
				if(habitats[i][j].getUseState() == UseState.EMPTY){
					useType = "U";
				}
				else if(habitats[i][j].getUseState() == UseState.OCCUPIED_HEALTHY){
					useType = "H";
				}
				else if(habitats[i][j].getUseState() == UseState.OCCUPIED_SICK){
					useType = "S";
				}

				map += habitats[i][j].getId() + useType + " ";
			}
			map += "\n";
		}
		map += "\n";

		return map;
	}


	//For show Info about Habitat
	public String infoHabitat(String id){
		String info = "";
		boolean sentinel = false;
		boolean sentinel2 = false;
		
		for(int i = 0; (i < ROWMATRIX) && !sentinel; i++){
			for(int j = 0; (j < COLUMNMATRIX) && !sentinel2; j++){
				if(habitats[i][j].getId().equals(id)){
					sentinel = true;
					sentinel2 = true;
					info = habitats[i][j].toString();
					
				} else{info = "El ID ingresado no corresponde a ningun habitat\n===================================================";}
			}
		}
		
		return info;
	}




	//For Stats
	public String stats(){
		String info = "===============================\nESTADISTICAS SOBRE CADA HABITAT\n===============================\n";
		int countGeneral = 0;
		int countD = 0, countC = 0, countR = 0, countL = 0, countB = 0;
		int healthy = 0, sick = 0;
		
		for(int i = MIN_CAT_ROW; i <= MAX_CAT_ROW; i++){
			for(int j = MIN_CAT_COL; j <= MAX_CAT_COL; j++){
				if(habitats[i][j].getUseState() != UseState.EMPTY){
					countC++;
				}
			}
		}
		for(int i = MIN_DOG_ROW; i <= MAX_DOG_ROW; i++){
			for(int j = MIN_DOG_COL; j <= MAX_DOG_COL; j++){
				if(habitats[i][j].getUseState() != UseState.EMPTY){
					countD++;
				}
			}
		}
		for(int i = MIN_RABBIT_ROW; i <= MAX_RABBIT_ROW; i++){
			for(int j = MIN_RABBIT_COL; j <= MAX_RABBIT_COL; j++){
				if(habitats[i][j].getUseState() != UseState.EMPTY){
					countR++;
				}
			}
		}
		for(int i = MIN_REPTILE_ROW; i <= MAX_REPTILE_ROW; i++){
			for(int j = MIN_REPTILE_COL; j <= MAX_REPTILE_COL; j++){
				if(habitats[i][j].getUseState() != UseState.EMPTY){
					countL++;
				}
			}
		}
		for(int i = MIN_BIRD_ROW; i <= MAX_BIRD_ROW; i++){
			for(int j = MIN_BIRD_COL; j <= MAX_BIRD_COL; j++){
				if(habitats[i][j].getUseState() != UseState.EMPTY){
					countB++;
				}
			}
		}
		
		for(int i = 0; i < ROWMATRIX; i++){
			for(int j = 0; j < COLUMNMATRIX; j++){
				if(habitats[i][j].getUseState() != UseState.EMPTY){
					countGeneral++;
					if(habitats[i][j].getUseState() == UseState.OCCUPIED_HEALTHY){
						healthy++;
					} else{sick++;}
				}
			}
		}
		
		
		info += "Actualmente tenemos el " + ((100*countC)/9) + "% de los habitats para gatos ocupados\n";
		info += "Actualmente tenemos el " + ((100*countD)/9) + "% de los habitats para perros ocupados\n";
		info += "Actualmente tenemos el " + ((100*countR)/4) + "% de los habitats para conejos ocupados\n";
		info += "Actualmente tenemos el " + ((100*countL)/4) + "% de los habitats para reptiles ocupados\n";
		info += "Actualmente tenemos el " + ((100*countB)/4) + "% de los habitats para aves ocupados\n";
		
		info += "=================================================\n";
		info += "En total tenemos el " + ((100*countGeneral)/30) + "% de los habitats ocupados\n";
		info += "=================================================\n";
		
		int add = sick + healthy;
		if(add != 0){
			info += "Actualmente el " + ((100*sick)/add) + "% de las mascotas se encuentran enfermas y el " + ((100*healthy)/add) + "% de las mascotas estan sanas\n\n";
		} else{info += "Actualmente los habitats se encuentran vacios, por los tanto no hay mascotas enfermas ni sanas\n\n";}
		
		
	
		return info;
		
	}
	
	
	
	
	//For Test
	public String showPetDaycare(){
		String confirmation = "";
		
		for(int i = 0; i < ROWMATRIX; i++){
			for(int j = 0; j < COLUMNMATRIX; j++){
				if(habitats[i][j] != null){
					if(habitats[i][j].getPetHabitat() == null){
					confirmation += "En la posicion: FILA-" + i + "/COLUMNA-" + j + 
									"\nSe encuentra vacio el habitat\n";
					} else{
					confirmation += "En la posicion: FILA-" + i + "/COLUMNA-" + j + 
									"\nHay una mascota con los siguientes datos:\n" +
									"==========================================\n" + habitats[i][j].toString();
					}
				}
				
			}
		}
		
		return confirmation;
	}





}