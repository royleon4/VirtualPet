package map;


import java.util.*;

import game.VirtualPet;
import item.*;


public class Store extends Place{
	protected ArrayList<Item> products;
	protected HashMap<Item, Integer> stock;
	protected ArrayList<String> onSale=new ArrayList<String>();
	protected int numberOfStock;
	transient Scanner in;
	public String getName() {
		return name;
	}
	protected String name;

	public Store(){
		products = new ArrayList<Item>();
		stock = new HashMap<Item, Integer>();
		numberOfStock=0;
		in = new Scanner(System.in);

	}
	public void addProduct(Item item){
			stock.put(item, 1);
			products.add(item);
		
	}
	public void removeProduct(Item item){
		products.remove(item);
	}
	
	public void clearStock(){
		products.clear();
	}
	public void removeAll(){
		products.removeAll(products);
	}
	public String type(){
		return "store";
	}
	public ArrayList<Item> getProducts(){
		return products;
	}
	public String Ask(){
		String s = "What would you like to buy? \n\n";
		int i=0;
		for(Item food:products){
			i++;
			s += i + ". "+food.showPrice();
			if(food.isOnSale()){
				s+="(On Sale! "+ food.getDiscount()+"% OFF)";
			}
			s+="\n";
		}
		VirtualPet v = new VirtualPet();
		
		return s;
	}
	public void inStock(int i){
		
	}
	public void inStock(){
		
	}
	public void welcome(){}
	public String introduction(){return"";}
	
	public void onSale(Item item){
		onSale.add(item.getName());
	}
	public void setDiscount(String name, double discount){
		for(Item c:products){
			if(c.getName().equals(name)){
			c.discount(discount);}
		}
	}
	public void sold(int number){
		products.remove(number-1);
	}
}
