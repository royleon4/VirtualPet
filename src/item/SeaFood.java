package item;

import java.util.HashMap;
import java.util.Random;

public class SeaFood extends Food{
	private String species;
	private Random random=new Random();;
	private Randomizer prob;
	public SeaFood(){
		RandItem[] ran = new RandItem[] {
				new RandItem(2,52),
				new RandItem(3,30),
				new RandItem(5,1),
				new RandItem(7,5),};
		size =new Randomizer(ran).getAItem().getInt();
		life = 3;
		String[][] animals = new String[][]{
						{"SeaWeed", "Oyster", "Fish","Clam", "Mussel","Pipi"},
						{"Shrimp", "Tuna", "Small crab", "Salmon", "Black oreo"},
						{"Lanternfish", "Rock lobster"},
						{"Shark", "horseshoe crab", "Ray"}
						};
		int ind=0;
		switch(size){
		case 2:
			nutrition=15;
			price = 50;
			name=animals[0][rand.nextInt(animals[0].length)];
			tastiness=2;
			this.type="Tiny Seafood";break;
		case 3:
			nutrition=30;
			price = 80;
			name=animals[1][rand.nextInt(animals[1].length)];
			tastiness=5;
			this.type="Small seafood";break;
		case 5:
			nutrition=60;
			price = 200;
			name=animals[2][rand.nextInt(animals[2].length)];
			tastiness=8;
			this.type="Medium seafood";break;
		case 7:
			nutrition=20;
			price = 800;
			name=animals[3][rand.nextInt(animals[3].length)];
			tastiness=9;
			this.type="Big seafood";break;
		}
//		System.out.println("name: "+name+"  ind: "+ind);
	
	}
	
}
