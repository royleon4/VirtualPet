package map;

import java.util.Random;

import game.Tools;
import item.*;

public class Grocery extends Store {
	public Grocery(){
		this.name = "Grocery";  
		
	}
	public void inStock(int qty){
		this.clearStock();
		Food[] foodTypes = new Food[] {
				new Egg(),
				new Drink(),
				new Steak(),
				new Chocolate()};
		for (int i = 0;i < qty; i++){
			Food food  = foodTypes[new Random().nextInt(foodTypes.length)];
			food.priceMultiplier(0.7);
			addProduct(food);		
		}
		numberOfStock=qty;
		
		}
	
public void welcome(int width){
		
		System.out.println(new Tools().centreString("--Welcome to this ordinary Groceries--", width));
		System.out.println(new Tools().centreString("We Offer Groceri...(yawn)", width));
	}
	}


