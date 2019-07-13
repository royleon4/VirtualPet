package pet;

import item.Food;
import item.Toy;
import map.Place;

/**
 * this class inherits Pet, has properties and method that specific for dog.
 * @author Leon
 *
 */
public class Dog extends Pet{
	
	

	public Dog(int num, String name) {
		super(num, name);
		// TODO Auto-generated constructor stub
		reset();
	}
	

	public void reset(){
		this.species="Dog";
		this.favFood="Steak";
		this.favPlace="Park";
		this.favToy="Ball";
		this.weight=25;
		this.hunger = 60;
		this.hygiene = 60;
		this.energy = 90;
		this.happiness = 80;
		this.exercise = 60;
		this.updateHealth();
	}
	
	public void hostIsAway(){
		
	}
	
	
	

	
	public String[] description(){
		String[] description = new String[]{
				"* * * * * * * * Description * * * * * * * ** *\n",
				"* * * * ** * * * * * * * * * * * * * * * * * *\n",
				"*Friendly puppies are always the best friends*\n",
				"*all around the world, our puppies are very  *\n",
				"*kind and discipline, and they are concerned *\n",
				"*about your feelings.  Supple paws, watery e-*\n",
				"*yes and fluffy furs like soft pillows, are  *\n",
				"*to ease your pressure away infinitely!      *\n",
				"*                                            *\n",
				"*                                            *\n",
				"* * * * * * * * * * * * * * * * * * * * * * *\n"
		};
		return description;
	}
}	