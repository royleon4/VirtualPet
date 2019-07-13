package game;
import java.io.Serializable;
import java.util.*;

import item.*;
import map.Place;
import pet.*;

public class Player implements Serializable{
	/**
	 * 
	 */
	private final int num;
	public int getNum() {
		return num;
	}

	private String name;
	private int capacity;
	public int age;
	private int cash;
	private String gender;
	private ArrayList<Pet> petsOwned;
	private ArrayList<Food> fridge;
	private ArrayList<Integer> foodqty; 
	private ArrayList<Toy> toyBox;
	private ArrayList<Integer> toyqty; 
	
	/**
	 * This method is used to input the number, names, ages and genders of players.
	 * @param num Number of players
	 * @param name Names of players
	 * @param age Ages of players
	 * @param gender Genders of players.
	 */
	public Player(int num, String name, int age, String gender){
		this.num = num;
		this.name = name;
		this.age = age;
		this.gender = gender;
		capacity = 20;
		cash = 800;
		petsOwned= new ArrayList<Pet>();
		fridge = new ArrayList<Food>();
		toyBox = new ArrayList<Toy>();
		foodqty = new ArrayList<Integer>();
		toyqty = new ArrayList<Integer>();
	}
	/**
	 * This method returns the names input by players
	 * @return name Names of players.
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * This method set the names of players from the input names.
	 * @param name Names of players
	 */
	public void setName(String name){
		this.name=name;
	}
	
	/**
	 * This method returns the total cash amount after adding.
	 * @param cash Cash amount that players have.
	 */
	public void addCash(int cash){
		this.cash+=cash;
	}
	
	/**
	 * This method returns the total cash amount after deducting.
	 * @param cash Cash amount that players have.
	 */
	public void minusCash(int cash){
		this.cash-=cash;
	}
	
	/**
	 * This method returns the cash amount that players have earned.
	 */
	public int getCash(){
		return cash;
	}
	
	/**
	 * This method is used to input genders of players.
	 * @return The gender of a player.
	 */
	public String getGender(){
		if(gender.equals("f")||gender.equalsIgnoreCase("female")){
			return "female";
		}
		return "male"; 
	}
	
	/**
	 * This method is used to input ages of players.
	 * @return The age of a players.
	 */
	public int getAge(){
		return age;
	}
	
	/**
	 * This methods returns all the pets a player own.
	 * @return All the pets owned by a player.
	 */
	public ArrayList<Pet> getAllPets(){
		
		return petsOwned;
	}
	
	/**
	 * This method is used to call the players respectfully.
	 * @return Titles according to age.
	 */
	public String getAgeSpecial(){
		if(age<=3){
			return "adorable";
		}
		if(age>3 && age<10){
			return "cute";
		}
		if(age>=10 && age<20){
			return "young";
		}
		if(age>=20 && age <30){
			return "ambitious";
		}
		if(age>=30 && age<40){
			return "precious";
		}
		if(age>=40 && age<50){
			return "affectionate";
		}
		if(age>=50 && age <60){
			return "compassionate";
		}
		if(age>=60 && age <70){
			return "unassuming";
		}
		if(age>=70 && age<80){
			return "witty";
		}
		if(age>=80 && age <90){
			return "gorgeous";
		}
		if(age >=90 && age <100){
			return "supreme nonagenarian";
		}
		if(age>=100 && age<200){
			return "respectful centernarian";
		}
		return "Almighty";
	}
	
	/**
	 * This method is used to accordingly call players by their genders..
	 * @return Titles according to gender.
	 */
	public String getGenderSpecial(){
		if(gender.equals("m")){
			return "Mr.";
		}
		return "Ms.";
	}
	
	/**
	 * This method is used to add pet.
	 * @param pet
	 */
	public void addPet(Pet pet){
		this.petsOwned.add(pet);
	}
	
	/**
	 * This method returns food contained in a fridge.
	 * @return fridge
	 */
	public ArrayList<Food> getFridge(){
		return fridge;
	}
	
	/**
	 * THis method returns toys contained in a toy box.
	 * @return toybox
	 */
	public ArrayList<Toy> getToyBox(){
		return this.toyBox;
	}
	
	/**
	 * This method is used to decide whether players are able to buy food.
	 * @param food
	 * @return
	 */
	public boolean buysFood(Food food){
		if(cash>food.getPrice()){
		    cash -= food.getPrice();
			for(Food f: fridge){
				if(f.sameAs(food)){
					foodqty.set(fridge.indexOf(f),foodqty.get(fridge.indexOf(f))+1);
					return true;
				}
				
			}
			foodqty.add(1);
			fridge.add(food);
			return true;
		}
		return false;
	}
	
	/**
	 * This method is used to decide whether players are able to but toys.
	 * @param toy
	 * @return
	 */
	public boolean buysToy(Toy toy){
		if(cash>toy.getPrice()){
		    cash -= toy.getPrice();
			for(Toy f: toyBox){
				if(f.sameAs(toy)){
					toyqty.set(toyBox.indexOf(f),toyqty.get(toyBox.indexOf(f))+1);
					return true;
				}
				
			}
			toyqty.add(1);
			toyBox.add(toy);
			return true;
		}
		return false;
	}

	public void setAge(int age) {
		this.age = age;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * This method returns toy quantity.
	 * @return toyqty Toy quantity.
	 */
	public ArrayList<Integer> getToyqty() {
		return toyqty;
	}
	
	/**
	 * This method returns food quantity.
	 * @return foodqty Food quantity.
	 */
	public ArrayList<Integer> getFoodqty() {
		return foodqty;
	}

	/**
	 * This method is used to remove toys from a toy box.
	 * @param toy
	 */
	public void removeToy(Toy toy){
		toyqty.set(toyBox.indexOf(toy), toyqty.get(toyBox.indexOf(toy))-1);

		if(toyqty.get(toyBox.indexOf(toy))==0){
			toyqty.remove(toyBox.indexOf(toy));
			toyBox.remove(toy);
			}
		}
	
	/**
	 * This method is used to remove food from a fridge.
	 * @param food
	 */
	public void removeFood(Food food){
		foodqty.set(fridge.indexOf(food), foodqty.get(fridge.indexOf(food))-1);

		if(foodqty.get(fridge.indexOf(food))==0){
			foodqty.remove(fridge.indexOf(food));
			fridge.remove(food);
			}
	}
	

	/**
	 * This method is used to consume food for pets.
	 * @param food Lower bound of the limit.
	 * @param pet Animals which interact with players.
	 */
	public void feed(Food food, Pet pet){
		if(pet.getActionDone()<2){
		pet.eat(food);
		removeFood(food);
		}
		

	}


	/**
	 * This method is used to consume toys for pets.
	 * @param toy Lower bound of the limit.
	 * @param pet Animals which interact with players.
	 */
	public void playWith(Toy toy, Pet pet){
		if(pet.getActionDone()<2){
		pet.play(toy);
		if(toy.getDurability()<=0){
			removeToy(toy);
		}}
	}
	
	
	public void bringTo(Pet pet, Place place){
		pet.goTo(place);

		
	}
	
	public void earn(int money){
		this.cash+=money;
	}
	
	
	
	/**
	 * This method allows players to sell products to gain cash.
	 * @param item Products to be sold.
	 * @param decrease
	 */
	public void sellItem(Item item, double decrease){
		if(item instanceof Food){
			fridge.remove(item);
			this.cash += item.getPrice()/decrease;
		}
		else{
			toyBox.remove(item);
			this.cash += item.getPrice()/decrease;
		}
		
	}
	
	/**
	 * This method is used to decide whether pets are misbehaving.
	 * @param pet
	 */
	public void discipline(Pet pet){
		if(!pet.isMisbehave()){
			pet.setMisbehave(true);
		}
		else{
			Random r = new Random();
			if(r.nextInt(5)+1>3){
				pet.setMisbehave(false);
			}
		}
	}
	
	/**
	 * This method would remove the pet if it was chosen to be killed.
	 * @param pet 
	 */
	public void killAPet(Pet pet){
		petsOwned.remove(pet);
	}
	
	/**
	 * Remove the pet from what player owns by its corresponding index
	 * @param pet index of the pet
	 */
	public void removePet(int pet){
		this.petsOwned.remove(pet);
	}
	/**
	 * remove the pet by its instance
	 * @param pet The pet
	 */
	public void removePet(Pet pet){
		this.petsOwned.remove(pet);
	}

	public String toString(){
		return this.name;
	}

}
