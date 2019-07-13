package map;

import game.Tools;
import item.*;

public class SeaWorld extends Store{
	
	public SeaWorld(){
		this.name = "Sea World"; 
	}
	public void inStock(int qty){
		this.clearStock();
		for(int i=0; i < qty; i++){
			SeaFood seafood = new SeaFood();
			seafood.priceMultiplier(0.8);
			if(onSale.contains(seafood.getName())){
				seafood.discount(0.7);
			}
			addProduct(seafood);}
		numberOfStock=qty;
	}
public void welcome(int width){
		
		System.out.println(new Tools().centreString("--Welcome to Sea World--", width));
		System.out.println(new Tools().centreString("We Offer wide varieties of fresh Sea Food everyday!", width));
	}

}
