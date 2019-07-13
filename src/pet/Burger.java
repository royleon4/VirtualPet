package pet;

import item.Food;
import item.Toy;
import map.Place;

public class Burger extends Pet{

	public Burger(int c, String n) {
		super(c, n);
		// TODO Auto-generated constructor stub
		this.number = c;
		this.name =n;
		reset();
		
	}

	public void reset(){
		this.species="Burger";
		this.favFood="Vege";
		this.favPlace="Cinema";
		this.favToy="freesbie";
		this.weight=0.05;
		this.hunger = 100;
		this.hygiene = 40;
		this.energy = 40;
		this.happiness = 40;
		this.exercise = 40;
		this.updateHealth();
	}

	public void hostIsAway(){
		
	}
	
	public String[] description(){
		String[] description = new String[]{
				"* * * * * * * * Description * * * * * * * ** *\n",
				"* * * * ** * * * * * * * * * * * * * * * * * *\n",
				"*Huh? A worthless yet idiotic human ever dare*\n",
				"*to own me? How will you promise that you    *\n",
				"*will never bite me? Nah, I ain't afraid of  *\n",
				"*you. I loathe being with you! Hum!          *\n",
				"*(Store owner's been compromised by a burger)*\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"* * * * * * * * * * * * * * * * * * * * * * *\n"
		};
		return description;
	}


}
