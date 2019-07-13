package map;

import game.Tools;
import item.*;

public class BugWorld extends Store {
	public BugWorld(){
		this.name = "Bug World";  
	}
	
	public void inStock(int qty){
		this.clearStock();
		for(int i=0; i < qty; i++){
			Insects bug = new Insects();
			bug.priceMultiplier(0.8);
			if(onSale.contains(bug.getName())){
				bug.discount(0.7);
			}
			addProduct(bug);}
		numberOfStock=qty;
	}
	public void welcome(int width){
		
		System.out.println(new Tools().centreString("--Welcome to Bugs World--", width));
		System.out.println(new Tools().centreString("We Offer wide varieties of fresh bugs everyday!", width));
	}
	@Override
public String introduction(){
		return "--Welcome to Bugs World--/nWe Offer wide varieties of fresh bugs everyday!";
	}
	

}
