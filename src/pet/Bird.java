package pet;

import java.util.Arrays;

import item.Food;
import item.Toy;
import map.Place;

public class Bird extends Pet{

	public Bird(int c, String n) {
		super(c,n);
		// TODO Auto-generated constructor stub
		this.number = c;
		this.name = n;
		reset();
	}

	public void hostIsAway(){

	}

	public void reset(){
		this.dislikes=new String[] {""};
		this.favFood="insect";
		this.favPlace="woods";
		this.favToy="Birds' toy";
		this.species="Bird";
		this.weight = 0.5;
		this.hunger = 50;
		this.hygiene = 90;
		this.energy = 40;
		this.happiness = 100;
		this.exercise = 50;
	}

	public String[] description(){
		String[] description = new String[]{
				"* * * * * * * * Description * * * * * * * ** *\n",
				"* * * * ** * * * * * * * * * * * * * * * * * *\n",
				"*Heavy academic and work pressure makes your *\n",
				"*life much stressful? Do you uusually get mad*\n",
				"*by traffic jams? Birds that are capable of  *\n",
				"*singing joyful songs will tremendously reli-*\n",
				"*eve your pressures.                         *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"* * * * * * * * * * * * * * * * * * * * * * *\n"
		};
		return description;
	}

}
