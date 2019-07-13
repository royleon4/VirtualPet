package map;

import java.util.Random;

import game.Tools;
import item.*;


public class ToyLand  extends Store{
	public ToyLand(){
		this.name = "Toy Land";
	}
	public void inStock(int qty){
		this.clearStock();
		Toy[] foodTypes = new Toy[] {
				new Ball(),
				new BirdsToy(),
				new Book(),
				new FeatherToy(),
				new Frisbee(),
				new PlayStation(),
				new Rock()};
		for (int i = 0;i < qty; i++){
			Toy food  = foodTypes[new Random().nextInt(foodTypes.length)];
			food.priceMultiplier(0.7);
			addProduct(food);
		}
		numberOfStock=qty;
		}
public void welcome(int width){
		
		System.out.println(new Tools().centreString("--Welcome to Toys' Land--", width));
		System.out.println(new Tools().centreString("We Offer wide varieties of toys!", width));
	}

}
