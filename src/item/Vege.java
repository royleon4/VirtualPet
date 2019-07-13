package item;

import java.util.HashMap;

public class Vege extends Food{
	public Vege(){
		String[] names = new String[] {
				"Broccoli",
				"Cabbage",
				"Celery",
				"Lettuce",
				"Pea",
				"Spinach"};
		this.name = names[rand.nextInt(names.length)];
		this.price = 40;
		this.nutrition = 15;
		this.life = 5;
		this.tastiness=3;
		this.size = 1;
		this.type = "Vege";
	}
}
