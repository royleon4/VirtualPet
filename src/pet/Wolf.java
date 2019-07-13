package pet;

import item.Food;
import item.Toy;
import map.Place;

public class Wolf extends Pet{


	public Wolf(int num, String name) {
		super(num, name);
		// TODO Auto-generated constructor stub
		reset();
		
	}
	
	
	public void reset(){
		this.species="Wolf";
		this.favFood="Medium corpse";
		this.favPlace="Woods";
		this.favToy="Play station";
		this.weight=50;
		this.hunger = 80;
		this.hygiene = 60;
		this.energy = 90;
		this.happiness = 50;
		this.exercise = 70;
		this.updateHealth();
	}

	public void hostIsAway(){
		
	}
	

	public String[] description(){
		String[] description = new String[]{
				"* * * * * * * * Description * * * * * * * ** *\n",
				"* * * * ** * * * * * * * * * * * * * * * * * *\n",
				"*Need a partner to make your life more       *\n",
				"*colorful and exciting but don't want to     *\n",
				"*waste too much time and money on a gigantic *\n",
				"*beast which eats a lot? A wolf would be your*\n",
				"*best choice. Their appetites are similiar to*\n",
				"*dogs but they will make your life as much   *\n",
				"*exciting as dinosaurs do.                   *\n",
				"*                                            *\n",
				"* * * * * * * * * * * * * * * * * * * * * * *\n"
		};
		return description;
	}
	
	




}
