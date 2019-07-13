package pet;

import item.Food;
import item.Item;
import item.Toy;
import map.Place;

/**
 * this class inherits Pet, has properties and method that specific for cat.
 * @author Leon
 *
 */
public class Cat extends Pet{

	
	public Cat(int num, String name) {
		super(num, name);
		// TODO Auto-generated constructor stub
		reset();
	
	}
	
	public void reset(){
		this.species= "Cat";
		this.favFood="Tiny corpse";
		this.favPlace="Park";
		this.favToy="Feather toy";
		this.weight=4.5;
		this.hunger = 60;
		this.hygiene = 100;
		this.energy = 60;
		this.happiness = 80;
		this.exercise = 70;
		this.updateHealth();
	}
	public void hostIsAway(){
		
	}

	public String[] description(){
		String[] description = new String[]{
				"* * * * * * * * Description * * * * * * * ** *\n",
				"* * * * ** * * * * * * * * * * * * * * * * * *\n",
				"*Have a lot of stories to share but have no  *\n",
				"*one to whisper to? Well, a little kitten wo-*\n",
				"*uld be your choice! Its nature of being qui-*\n",
				"*et and clean will save you a lot of time. No*\n",
				"*matter when you are in a good mood or bad m-*\n",
				"*ood, it will always tbe your best friend to *\n",
				"*share moments with.                         *\n",
				"*                                            *\n",
				"* * * * * * * * * * * * * * * * * * * * * * *\n"
		};
		return description;
	}
}