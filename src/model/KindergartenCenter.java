package model;

public class KindergartenCenter{
	//Maximum of rooms for pets
	private final int ROWMATRIX = 6;
	private final int COLUMNMATRIX = 5;

    //for cats
	private static final int MIN_CAT_ROWS = 0;
	private static final int MAX_CAT_ROWS = 2;
	private static final int MIN_CAT_COL = 0;
	private static final int MAX_CAT_COL = 2;

	//for dogs
	private static final int MIN_DOG_ROWS = 3;
	private static final int MAX_DOG_ROWS = 5;
	private static final int MIN_DOG_COL = 0;
	private static final int MAX_DOG_COL = 2;

	//for reptiles
	private static final int MIN_REPTILE_ROWS = 0;
	private static final int MAX_REPTILE_ROWS = 1;
	private static final int MIN_REPTILE_COL = 3;
	private static final int MAX_REPTILE_COL = 4;

	//for rabbits
	private static final int MIN_RABBIT_ROWS = 2;
	private static final int MAX_RABBIT_ROWS = 3;
	private static final int MIN_RABBIT_COL = 3;
	private static final int MAX_RABBIT_COL = 4;

	//for birds
	private static final int MIN_BIRD_ROWS = 4;
	private static final int MAX_BIRD_ROWS = 5;
	private static final int MIN_BIRD_COL = 3;
	private static final int MAX_BIRD_COL = 4;


    private PetHabitat[][] habitats;


    public KindergartenCenter(){
		habitats = new PetHabitat[ROWMATRIX][COLUMNMATRIX];
		createAreas();
	}

	//organize habitats
	private void createAreas(){
		organizeHabitats(MIN_DOG_ROWS, MAX_DOG_ROWS, MIN_DOG_COL, MAX_DOG_COL, 1);
		organizeHabitats(MIN_CAT_ROWS, MAX_CAT_ROWS, MIN_CAT_COL, MAX_CAT_COL, 2);
		organizeHabitats(MIN_BIRD_ROWS, MAX_BIRD_ROWS, MIN_BIRD_COL, MAX_BIRD_COL, 3);
		organizeHabitats(MIN_REPTILE_ROWS, MAX_REPTILE_ROWS, MIN_REPTILE_COL, MAX_REPTILE_COL, 4);
		organizeHabitats(MIN_RABBIT_ROWS, MAX_RABBIT_ROWS, MIN_RABBIT_COL, MAX_RABBIT_COL, 5);
	}

	private void organizeHabitats(int minRows, int maxRows, int minCol, int maxCol, int species){
		int contArea = 1;
		for( int rows = minRows; rows <=  maxRows; rows++ ){

			for( int col = minCol; col <= maxCol; col++ ){

				switch(species){
					case 1:
					habitats[rows][col] = new DogHabitat( "DH" + contArea, 3.5, 4.5, UseState.EMPTY, 5);
					break;

					case 2:
					habitats[rows][col] = new CatHabitat( "CH" + contArea, 4.5, 5.5, UseState.EMPTY, 7.5, 2.5);
					break;

					case 3:
					habitats[rows][col] = new BirdHabitat( "BH" + contArea, 6.5, 2.5, UseState.EMPTY, 7.5, 4, CageType.CAGE_IN_LAND);
					if( rows == 5 ){
						habitats[rows][col] = new BirdHabitat( "BH" + contArea, 6.5, 2.5, UseState.EMPTY, 7.5, 4, CageType.HANGING_CAGE);
					}
					break;

					case 4:
					habitats[rows][col] = new ReptileHabitat( "ReH" + contArea, 8.5, 7.5, UseState.EMPTY,  "ACETATE", ReptileType.FOR_AMPHIBIANS);
					if( rows == 1  ){
						habitats[rows][col] = new ReptileHabitat( "ReH" + contArea, 8.5, 7.5, UseState.EMPTY, "ACRYLIC", ReptileType.ONLY_LAND);
					}
					break;

					case 5:
					habitats[rows][col] = new RabbitsHabitat( "RaH" + contArea, 10, 5.5, UseState.EMPTY, "LETTUCE", 6);
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
		
		for(int i = ROWMINIMUM_FORCAT; (i <= ROWLIMIT_FORCAT) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORCAT; (j <= COLUMNLIMIT_FORCAT) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addCatInDaycare(Pet cat){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORCAT; (i <= ROWLIMIT_FORCAT) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORCAT; (j <= COLUMNLIMIT_FORCAT) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(cat);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add DOGS
	public boolean verifyIfThereRoomsForDOG(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORDOG; (i <= ROWLIMIT_FORDOG) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORDOG; (j <= COLUMNLIMIT_FORDOG) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addDogInDaycare(Pet dog){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORDOG; (i <= ROWLIMIT_FORDOG) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORDOG; (j <= COLUMNLIMIT_FORDOG) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(dog);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add REPTILES
	public boolean verifyIfThereRoomsForREPTILE(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORREPTILE; (i <= ROWLIMIT_FORREPTILE) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORREPTILE; (j <= COLUMNLIMIT_FORREPTILE) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addReptileInDaycare(Pet reptile){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORREPTILE; (i <= ROWLIMIT_FORREPTILE) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORREPTILE; (j <= COLUMNLIMIT_FORREPTILE) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(reptile);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add RABBITS
	public boolean verifyIfThereRoomsForRABBIT(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORRABBIT; (i <= ROWLIMIT_FORRABBIT) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORRABBIT; (j <= COLUMNLIMIT_FORRABBIT) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addRabbitInDaycare(Pet rabbit){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORRABBIT; (i <= ROWLIMIT_FORRABBIT) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORRABBIT; (j <= COLUMNLIMIT_FORRABBIT) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(rabbit);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
				}
			}
		}
		
		return confirmation;
	}
	
	//To add BIRDS
	public boolean verifyIfThereRoomsForBIRD(){
		boolean confirmation = false;
		
		for(int i = ROWMINIMUM_FORBIRD; (i <= ROWLIMIT_FORBIRD) && !confirmation; i++){
			for(int j = COLUMNMINIMUM_FORBIRD; (j <= COLUMNLIMIT_FORBIRD) && !confirmation; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					confirmation = true;
				} else{confirmation = false;}
			}
		}
		
		return confirmation;
	}
	
	public String addBirdInDaycare(Pet bird){
		boolean sentinel = false;
		String confirmation = "";
		
		for(int i = ROWMINIMUM_FORBIRD; (i <= ROWLIMIT_FORBIRD) && !sentinel; i++){
			for(int j = COLUMNMINIMUM_FORBIRD; (j <= COLUMNLIMIT_FORBIRD) && !sentinel; j++){
				if(habitats[i][j].getPetInsideTheHabitat() == null){
					sentinel = true;
					habitats[i][j].setPetInsideTheHabitat(bird);
					habitats[i][j].setUseType(UseState.OCCUPIED_SICK);
					confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
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
			for(int i = ROWMINIMUM_FORDOG; (i <= ROWLIMIT_FORDOG) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORDOG; (j <= COLUMNLIMIT_FORDOG) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
					}
				}
			}
		} else if(option == 2){
			for(int i = ROWMINIMUM_FORCAT; (i <= ROWLIMIT_FORCAT) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORCAT; (j <= COLUMNLIMIT_FORCAT) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
					}
				}
			}
		} else if(option == 3){
			for(int i = ROWMINIMUM_FORRABBIT; (i <= ROWLIMIT_FORRABBIT) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORRABBIT; (j <= COLUMNLIMIT_FORRABBIT) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
					}
				}
			}
		} else if(option == 4){
			for(int i = ROWMINIMUM_FORREPTILE; (i <= ROWLIMIT_FORREPTILE) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORREPTILE; (j <= COLUMNLIMIT_FORREPTILE) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
					}
				}
			}
		} else if(option == 5){
			for(int i = ROWMINIMUM_FORBIRD; (i <= ROWLIMIT_FORBIRD) && !sentinel; i++){
				for(int j = COLUMNMINIMUM_FORBIRD; (j <= COLUMNLIMIT_FORBIRD) && !sentinel2; j++){
					if(habitats[i][j].getPetInsideTheHabitat() == null){
						sentinel = true;
						sentinel2 = true;
						habitats[i][j].setPetInsideTheHabitat(newPet);
						habitats[i][j].setUseType(UseState.OCCUPIED_HEALTHY);
						confirmation = "The pet was moved to the habitat " + habitats[i][j].getIdNumber() + ", located in the pet nursery";
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
				if(habitats[i][j].getPetInsideTheHabitat() != null){
					if((habitats[i][j].getPetInsideTheHabitat().getName()).equals(namePet)){
						sentinel = true;
						sentinel2 = true;
						confirmation += "\nThe pet " + namePet + " is found in the habitat " + habitats[i][j].getIdNumber() + "\nYour current state is "; 
						
						if(habitats[i][j].getUseType() == UseState.OCCUPIED_SICK){
							confirmation += "SICK\n===================================================";
						} else{
							confirmation += "FURY\n===================================================";
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
				if(habitats[i][j].getIdNumber().equals(id)){
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
		
		for(int i = ROWMINIMUM_FORCAT; i <= ROWLIMIT_FORCAT; i++){
			for(int j = COLUMNMINIMUM_FORCAT; j <= COLUMNLIMIT_FORCAT; j++){
				if(habitats[i][j].getUseType() != UseState.EMPTY){
					countC++;
				}
			}
		}
		for(int i = ROWMINIMUM_FORDOG; i <= ROWLIMIT_FORDOG; i++){
			for(int j = COLUMNMINIMUM_FORDOG; j <= COLUMNLIMIT_FORDOG; j++){
				if(habitats[i][j].getUseType() != UseState.EMPTY){
					countD++;
				}
			}
		}
		for(int i = ROWMINIMUM_FORRABBIT; i <= ROWLIMIT_FORRABBIT; i++){
			for(int j = COLUMNMINIMUM_FORRABBIT; j <= COLUMNLIMIT_FORRABBIT; j++){
				if(habitats[i][j].getUseType() != UseState.EMPTY){
					countR++;
				}
			}
		}
		for(int i = ROWMINIMUM_FORREPTILE; i <= ROWLIMIT_FORREPTILE; i++){
			for(int j = COLUMNMINIMUM_FORREPTILE; j <= COLUMNLIMIT_FORREPTILE; j++){
				if(habitats[i][j].getUseType() != UseState.EMPTY){
					countL++;
				}
			}
		}
		for(int i = ROWMINIMUM_FORBIRD; i <= ROWLIMIT_FORBIRD; i++){
			for(int j = COLUMNMINIMUM_FORBIRD; j <= COLUMNLIMIT_FORBIRD; j++){
				if(habitats[i][j].getUseType() != UseState.EMPTY){
					countB++;
				}
			}
		}
		
		for(int i = 0; i < ROWMATRIX; i++){
			for(int j = 0; j < COLUMNMATRIX; j++){
				if(habitats[i][j].getUseType() != UseState.EMPTY){
					countGeneral++;
					if(habitats[i][j].getUseType() == UseState.OCCUPIED_HEALTHY){
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
					if(habitats[i][j].getPetInsideTheHabitat() == null){
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