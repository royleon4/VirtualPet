package item;

import java.util.*;

import pet.*;

public class Corpse extends Food{
	private String species;
	private Random random=new Random();;
	private Randomizer prob;
	private int prob1=52, prob2=30, prob3=20, prob4=15, prob5=3;
	public Corpse(){
		RandItem[] items = new RandItem[] {
				new RandItem(2,prob1),
				new RandItem(3,prob2),
				new RandItem(5,prob3),
				new RandItem(7,prob4),
				new RandItem(10,prob5)};
		prob = new Randomizer(items);
		size =prob.getAItem().getInt();
		life = 3;
		String[][] animals = new String[][]{
						{"Mouse", "Spider", "Ant","Squirrel"},
						{"Donkey", "Chicken", "Pig", "Liver"},
						{"Kangaroo", "Lion","Tiger","Leopard","Cow","Horse"},
						{"Elephant", "Giraffe","Rhino", "Pterosaurus"},
						{"T-rex","Whale"}};
						int ind=0;
		switch(size){
		case 2:
			nutrition=15;
			price = 50;
			name= animals[0][rand.nextInt(animals[0].length)];
			tastiness=2;
			this.type="Tiny corpse";break;
		case 3:
			nutrition = 50;
			price = 100;
			name = animals[1][rand.nextInt(animals[1].length)];
			tastiness = 3;
			this.type="Small corpse";break;
		case 5:
			nutrition = 70;
			price = 500;
			name = animals[2][rand.nextInt(animals[2].length)];
			tastiness = 8;
			this.type="Medium corpse";break;
		case 7:
			nutrition = 80;
			price = 1000;
			name = animals[3][rand.nextInt(animals[3].length)];
			tastiness = 7;
			this.type = "Big corpse";break;
		case 10:
			nutrition = 99;
			price = 1500;
			tastiness=10;
			name = animals[4][rand.nextInt(animals[4].length)];
			this.type = "Giant corpse";break;
		}
//		System.out.println("name: "+name+"  ind: "+ind);
	
	}
	
	public Corpse(int size, int prop){
		switch (size){
		case 1: this.prob1=prop;
		case 2: this.prob2=prop;
		case 3: this.prob3=prop;
		case 4: this.prob4=prop;
		case 5: this.prob5=prop;
		}
		RandItem[] items = new RandItem[] {
				new RandItem(2,prob1),
				new RandItem(3,prob2),
				new RandItem(5,prob3),
				new RandItem(7,prob4),
				new RandItem(10,prob5)};
		prob = new Randomizer(items);
		size =prob.getAItem().getInt();
		life = 3;
		String[][] animals = new String[][]{
						{"Mouse", "Spider", "Ant","Squirrel"},
						{"Donkey", "Chicken", "Pig", "Body"},
						{"Kangaroo", "Lion","Tiger","Leopard","Cow","Horse"},
						{"Elephant", "Giraffe","Rhino", "Sabertooth Wyvern"},
						{"T-rex","Whale"}};
						int ind=0;
		switch(size){
		case 2:
			nutrition = rand.nextInt(19)+2;
			price = rand.nextInt(11)+10;
			name = animals[0][rand.nextInt(animals[0].length)];
			tastiness = 2;
			this.type ="Tiny corpse";break;
		case 3:
			nutrition=rand.nextInt(31)+20;
			price = rand.nextInt(26)+25;
			name=animals[1][rand.nextInt(animals[1].length)];
			tastiness=3;
			this.type="Small corpse";break;
		case 5:
			nutrition=rand.nextInt(21)+50;
			price = rand.nextInt(101)+100;
			name=animals[2][rand.nextInt(animals[2].length)];
			tastiness=8;
			this.type="Medium corpse";break;
		case 7:
			nutrition=rand.nextInt(11)+70;
			price = rand.nextInt(301)+200;
			name=animals[3][rand.nextInt(animals[3].length)];
			tastiness=7;
			this.type="Big corpse";break;
		case 10:
			nutrition=rand.nextInt(11)+90;
			price = rand.nextInt(511)+500;
			tastiness=9;
			name=animals[4][rand.nextInt(animals[4].length)];
			this.type="Giant corpse";break;
		}
//		System.out.println("name: "+name+"  ind: "+ind);
	
	}
	private RandItem RandItem(int i, int j) {
		// TODO Auto-generated method stub
		return null;
	}
	public Corpse(Pet pet){
		this.type="Corpse";
		this.species=pet.getSpecies();
		this.name=pet.getName();
		this.nutrition=(int)pet.getHealth();
		if (nutrition>10){
			nutrition = 10;
		}
		this.tastiness=(pet.getHappiness()+pet.getExercise())/20;
		if(tastiness > 10){
			tastiness=10;
		}
		this.price=(int) (pet.getHealth()*pet.getAge());
		this.life=3;
	}

	public void setNutrition(int nutrition) {
		this.nutrition = nutrition;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public void setTastiness(int tastiness) {
		this.tastiness = tastiness;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String toString(){
		return String.format("There is a corpse of %s, worth $%d.0, and has %d in nutrition, %d in tastiness, Yum!", name, price, nutrition, tastiness);
	}
	
	public static void main(String arge[]){
		Corpse c= new Corpse();
		System.out.println(c.toString());
	}

}
