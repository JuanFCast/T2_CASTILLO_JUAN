package model;

public class KindergartenCenter{

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


    private PetHabitat[][] pethabitat;


    public KindergartenCenter(){
		//Habitats for DayCare -> TI3
		habitats = new PetHabitat[6][5];
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
					habitats[rows][col] = new DogHabitat( "D" + contArea, 3.5, 4.5, UseState.EMPTY, 5);
					break;

					case 2:
					habitats[rows][col] = new CatHabitat( "C" + contArea, 4.5, 5.5, UseState.EMPTY, 7.5, 2.5);
					break;

					case 3:
					habitats[rows][col] = new BirdHabitat( "B" + contArea, 6.5, 2.5, UseState.EMPTY, 7.5, 4, CageType.CAGE_IN_LAND);
					if( rows == 5 ){
						habitats[rows][col] = new BirdHabitat( "B" + contArea, 6.5, 2.5, UseState.EMPTY, 7.5, 4, CageType.HANGING_CAGE);
					}
					break;

					case 4:
					habitats[rows][col] = new ReptileHabitat( "R" + contArea, 8.5, 7.5, UseState.EMPTY,  "ACETATE", ReptileType.FOR_AMPHIBIANS);
					if( rows == 1  ){
						habitats[rows][col] = new ReptileHabitat( "R" + contArea, 8.5, 7.5, UseState.EMPTY, "ACRYLIC", ReptileType.ONLY_LAND);
					}
					break;

					case 5:
					habitats[rows][col] = new RabbitsHabitat( "RA" + contArea, 10, 5.5, UseState.EMPTY, "GRASSES", 6);
					break;
				}		
				contArea++;
			}
		}
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

}