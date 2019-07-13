package item;

import java.io.Serializable;
import java.util.Random;

import game.Tools;
import pet.Cat;

public abstract class Food implements Item, Serializable{
	protected String name, type;
	protected int nutrition, size, tastiness, price, life;
	protected double off;
	protected Random rand= new Random();
	protected boolean expired=false, isOnSale=false;
	
	public int nutrition(){
		return this.nutrition;
	};
	public int getSize(){
		return this.size;
	};
	public String getType() {
		return type;
	}
	public int getPrice(){
		return this.price;
	};
	public void setPrice(int price){
		this.price=price;
	}
	public void priceMultiplier(int mult){
		this.price = this.price*mult;
	}
	public void priceMultiplier(double mult){
		this.price = (int) (this.price*mult);
	}
	public int tastiness(){
		return this.tastiness;
	};
	public String getName(){
		return this.name;
	};
	public void setExpired(){
		expired = true;
	}
	public void setTastiness(int number){
		if(number>=1){
			this.tastiness = number;
		}
		
	}
	public boolean expired(){
		return this.expired;
	};
	
	public void discount(double off){
		isOnSale = true;
		this.off = off;
		this.price = (int) (this.price*off);
	}
	public String toString(){
		return name;
	}
	public boolean isOnSale(){
		return isOnSale;
	}
	public double getDiscount(){
		return (1-off)*100;
	}
	public String introduction(){
		String out = "";
		out += String.format(
			new Tools().twoSidedString("Name: " + name, "Price: $"+price, 58)
			 + "\nType: %s\n"
			 + "Nutrition: %3d    "
			 + "Tastiness: %2d  "
			 + "Size: %2d   "
			 + "Expiry: %2d days"
			 ,type,nutrition, tastiness,size,life);
		return out;
	}
	public String betterIntro(int width){
		String out = "";
		Tools tool = new Tools();
//		out += tool.indentString("Name:_" + name, width, "_") 
//				+ tool.indentString("Price:_$_" + price, width, "_")
//				+ tool.indentString("Type:_"+type, width, "_")
//				+ tool.indentString("Nutrition:_"+nutrition, width, "_")
//				+ tool.indentString("Tastiness:_"+tastiness, width, "_")
//				+ tool.indentString("Size:_"+size, width, "_")
//				+ tool.indentString("Expiry:_"+life+"_days", width, "_");
		out += name + "<br>";
		out += "Price:&nbsp;$&nbsp;" + price + "<br>";
		out += "Nutrition:&nbsp;"+nutrition+ "<br>";
		out += "Size:&nbsp;"+size + "<br>";
		out += "Expiry:&nbsp;"+life+ "&nbsp;days";
		
		return out;
	}
	public String showPrice(){
		String out = "";
		out += "A " + name + " ($" + price+")";
		return out;
	}
	
	public boolean sameAs(Item item){
		if(item.getName().equals(name)){
			return true;
		}
		return false;
	}
	
	public static void main(String arg[]){
		Cat cat = new Cat(1, "sad");
		Corpse c = new Corpse();
		System.out.println(new Tools().indentString("Expiry: "+"life"+" days", 50, " "));
		System.out.println(c.betterIntro(30).length());
	}

}
