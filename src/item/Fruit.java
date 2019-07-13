package item;

import java.io.Serializable;

public class Fruit extends Food{
	public Fruit(){
		String[] names= new String[] {
				"Melon",
				"Apple",
				"Papaya",
				"Watermelon",
				"Banana",
				"Kiwi fruit",
				"Guava",
				"Mango",
				"Orange"};
		this.name=names[rand.nextInt(names.length)];
		this.price=40;
		this.nutrition=40;
		this.life=3;
		this.tastiness=4;
		this.size = 1;
		this.type = "Fruit";
	}
	

}
