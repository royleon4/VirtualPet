package map;

import java.util.Random;

import game.Tools;
import item.Chocolate;
import item.Drink;
import item.Egg;
import item.Food;
import item.Fruit;
import item.*;

public class GrowersMarket extends Store{
	
	public GrowersMarket(){
		this.name = "Growers Market";  
		
	}
	public void inStock(int qty){
		this.clearStock();
		Food[] foodTypes = new Food[] {
				new Fruit(),
				new Vege(),};
		for (int i = 0;i < qty; i++){
			Food food  = foodTypes[new Random().nextInt(foodTypes.length)];
			food.setTastiness(food.tastiness()-2);
			
			addProduct(food);
		}
		numberOfStock=qty;
	}
public void welcome(int width){
		
		System.out.println(new Tools().centreString("--Welcome to Growers Market!!--", width));
		System.out.println(new Tools().centreString("We Offer fresh Vegetables and fruits everyday!", width));
	}
}
