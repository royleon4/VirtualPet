package map;

import game.Tools;
import item.*;

public class NeWorld extends Store{
	public NeWorld(){
		this.name = "Ne World"; 
	}
	public void inStock(){
		this.clearStock();
		Food[] foodTypes = new Food[] {
				new Corpse(),
				new Chocolate(),
				new SeaFood(),
				new Drink(),
				new Egg(),
				new Insects(),
				new Fruit(),
				new Steak()
		};
		for(Food food : foodTypes){
			food.priceMultiplier(2);
			addProduct(food);
		}
		numberOfStock=8;
		}
	
	
	
	@ Override
	
	public void sold(int number){
		
	}
public void welcome(int width){
		
		System.out.println(new Tools().centreString("--Welcome to Ne World!!--", width));
		System.out.println(new Tools().centreString("We Offer everything!", width));
	}
	

}
