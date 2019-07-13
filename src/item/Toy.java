package item;

import java.io.Serializable;

import game.Tools;

public abstract class Toy implements Item, Serializable {
	protected int price, joyness, energyNeeded, exercise, size=1, durability;
	protected String name;
	
	public int getJoyness() {
		return joyness;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setJoyness(int joyness) {
		this.joyness = joyness;
	}
	public int getEnergyNeeded() {
		return energyNeeded;
	}
	public void setEnergyNeeded(int energyNeeded) {
		this.energyNeeded = energyNeeded;
	}
	public int getExercise() {
		return exercise;
	}
	public void setExercise(int exercise) {
		this.exercise = exercise;
	}
	public int getPrice(){
		return this.price;
	};
	public void setPrice(int price){
		this.price=price;
	}
	public int getDurability() {
		return durability;
	}
	public void setDurability(int durability) {
		this.durability = durability;
	}
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void priceMultiplier(int mult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void priceMultiplier(double mult) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean expired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void discount(double off) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isOnSale() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public double getDiscount() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public boolean sameAs(Item item){
		if(item.getName().equals(name)){
			return true;
		}
		return false;
	}
	
	public String betterIntro(int width){
		return "";
	}

	public String introduction(){
		String out = "";
		out += String.format(
			new Tools().twoSidedString("Name: " + name, "Price: $"+price, 58)
			 + "\n"
			 + "Energy Needs: %3d  "
			 + "Exercise: %2d  "
			 + "Size: %2d      "
			 + "Durability: %2d"
			 ,this.energyNeeded,this.exercise, size,durability);
		return out;
	}
	public String showPrice(){
		String out = "";
		out += "A " + name + " ($" + price+")";
		return out;
	}
}
