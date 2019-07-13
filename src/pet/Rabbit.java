package pet;

import item.Food;
import item.Toy;
import map.Place;

public class Rabbit extends Pet{


	public Rabbit(int num, String name) {
		super(num, name);
		// TODO Auto-generated constructor stub
		this.name=name;
		reset();
	}

	
	public void eat(Food food){
		this.actionDone+=1;
		if(food.equals(favFood));
		if(food.expired()){
			this.isSick=true;
			hunger += food.nutrition()*0.15;
			hygiene -= food.getSize()*8;
			happiness -= food.tastiness()*3;
		}
		else{
		hunger += food.nutrition()*0.2*this.growthRate;
		hygiene -= food.getSize()*5;
		happiness += food.tastiness()*3;
		}
	}
	
	public void reset(){
		this.species="Rabbit";
		this.favFood="Vege";
		this.favPlace="Cinema";
		this.favToy="Book";
		this.weight=2;
		this.hunger = 60;
		this.hygiene = 80;
		this.energy = 50;
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
				"*Do you wish to raise a pet but don't want it*\n",
				"*to be too noisy? You should really take an  *\n",
				"*adorable rabbit into consideration! All you *\n",
				"*need to do is give them food and a soft     *\n",
				"*weedy bed, then enjoy watching them.        *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"* * * * * * * * * * * * * * * * * * * * * * *\n"
		};
		return description;
	}



}
