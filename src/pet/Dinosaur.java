package pet;

import item.Food;
import item.Toy;
import map.Place;

public class Dinosaur extends Pet{

	
	public Dinosaur(int num, String name) {
		super(num, name);
		// TODO Auto-generated constructor stub
		this.number=num;
		this.name=name;
		reset();
		
	}
	
	public void reset(){
		this.species="Dinosaur";
		this.favFood="Giant corpse";
		this.favPlace="woods";
		this.favToy="Rock";
		this.hunger = 80;
		this.hygiene = 50;
		this.energy = 100;
		this.happiness = 70;
		this.exercise = 70;
		this.weight = 30000;
		this.updateHealth();
	}
	

	public void hostIsAway(){
		
	}

	
	public String[] description()
	{
		String[] description = new String[]{
				"* * * * * * * * Description * * * * * * * ** *\n",
				"* * * * ** * * * * * * * * * * * * * * * * * *\n",
				"*Are you always feeling your life lacking of *\n",
				"*excitements, strangeness and passions? With *\n",
				"*them, your life is going to be full of surp-*\n",
				"*rises and joys. (Don't worry they ain't gon-*\n",
				"*na bite ya since they are well fed.)        *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"* * * * * * * * * * * * * * * * * * * * * * *\n"
		};
		return description;
	}


}
