package item;

import java.util.*;

public class Drink extends Food {
	private Random random= new Random();
	public Drink(){
		HashMap<String,String[]> drinkTypes = new HashMap<String,String[]>();
		String[] types = new String[] {"soda", "juice",  "tea", "coffee"};
		String[][] drinks = new String[][]{
			{"Coke", "Pepsi", "Ginger Beer", "7Ups", "Lemon", "Sarsi"},
			{"Lemon juice","Papaya juice", "Apple juice", "Orange juice", "Banana juice"},
			{"Barly tea", "White tea","Milk tea","Green tea", "Black tea", "Asam milk tea", "Flowering tea"},
			{"Latte","Americano","Mocha","Cappucino"}};
		for (int i=0;i<types.length;i++){
				drinkTypes.put(types[i],drinks[i]);		
	}
		type=types[random.nextInt(types.length)];
		name = drinkTypes.get(type)[random.nextInt(drinkTypes.get(type).length)];
		price = 60;
		nutrition = 30;
		tastiness = 5;
		life = 5;
		size = 1;
		}


}
