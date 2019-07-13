package map;

import java.util.ArrayList;

import game.Tools;
import item.*;

public class CorpseParty extends Store{

	public CorpseParty(){
		this.name = "Corpse Party";  
		
	}
	public void inStock(int qty){
		this.clearStock();
		for(int i=0; i < qty; i++){
			Corpse corp = new Corpse();
			corp.priceMultiplier(3);
			if(onSale.contains(corp.getName())){
				corp.discount(0.7);
			}
			addProduct(corp);}
		numberOfStock=qty;
	}
public void welcome(int width){
		
		System.out.println(new Tools().centreString("--Welcome to Corpse Party--", width));
		System.out.println(new Tools().centreString("We Offer wide varieties of fresh raw meats everyday!", width));
	}
	
	
	
	
}
