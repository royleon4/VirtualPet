package pet;

import java.io.Serializable;
import java.util.*;

import game.*;
import item.*;
import map.Place;
/**
 * An abstract class that represents a Pet that players
 * own, a pet has ability to eat, sleep, play etc., and 
 * has attributes that could affect its behaviours.
 * @author Leon
 *
 */
public abstract class Pet implements Serializable{
	protected String name, species, favToy, favFood, favPlace, weather;	
	protected int number, size, age=1,hunger, hygiene, energy, 
	happiness, exercise,actionDone, sickness, injury;
	public int getSickness() {
		return sickness;
	}

	public void setSickness(int sickness) {
		this.sickness = sickness;
	}

	public int getInjury() {
		return injury;
	}

	public void setInjury(int injury) {
		this.injury = injury;
	}

	protected double weight, health, growthRate;
	protected boolean isMisbehave=false, needsToilet=false, slept=false,
					hasRevived=false, isDead=false, isSick=false;
	protected String[] dislikes=new String[]{};
	protected Tools tool= new Tools();

	public Pet(int num, String name){
		this.number=num;
		this.name = name;
		}

	public void setWeather(String weather) {
		this.weather = weather;
	}
	
	public int getSize() {
		return size;
	}


	public void setSize(int size) {
		this.size = size;
	}

	public void setExercise(int exercise) {
		this.exercise = exercise;
		updateHealth();
	}


	public double getGrowthRate() {
		return growthRate;
	}


	public void setGrowthRate(double growthRate) {
		this.growthRate = growthRate;
	}


	public boolean isNeedsToilet() {
		return needsToilet;
	}


	public void setNeedsToilet(boolean needsToilet) {
		this.needsToilet = needsToilet;
	}


	public boolean isSick() {
		return isSick;
		
	}


	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}


	public String[] getDislikes() {
		return dislikes;
	}


	public void setDislikes(String[] dislikes) {
		this.dislikes = dislikes;
	}


	public String getFavPlace() {
		return favPlace;
	}


	public void setName(String name) {
		this.name = name;
	}


	public void setSpecies(String species) {
		this.species = species;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public void setHunger(int hunger) {
		updateHealth();
		this.hunger = hunger;
	}


	public void setHygiene(int hygiene) {
		updateHealth();
		this.hygiene = hygiene;
	}


	public void setEnergy(int energy) {
		updateHealth();
		this.energy = energy;
	}


	public void setHappiness(int happiness) {
		updateHealth();
		this.happiness = happiness;
	}

	public void setMisbehave(boolean isMisbehave) {
		this.isMisbehave = isMisbehave;
	}


	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}


	public int getHygiene(){
		return hygiene;
	}
	public String getFavFood() {
		return favFood;
	}
	public String getFavToy() {
		return favToy;
	}
	public String getName(){
		return name;
	}
	public String getSpecies(){
		return species;
	}
	public int getAge(){
		return age;
	}
	public int getHunger(){
		return hunger;
	}
	public int getEnergy(){
		return energy;
	}
	public int getExercise(){
		return exercise;
	}
	public int getHappiness(){
		return happiness;
	}
	
	public void updateHealth() {
		this.health=
	    (this.hunger*0.5+this.exercise)*0.25+
	    this.hygiene*0.25+this.energy*0.25+
	    this.happiness*0.25-this.injury*0.5-this.sickness*0.5;
	}
	
	public double getHealth(){
		return health;
	}
	public boolean isMisbehave(){
		return isMisbehave;
	}
	public boolean isDead(){
		return isDead;
	}	 
	public boolean needsToilet(){
		return needsToilet;
	}
	public void setActionDone(int number){
		if(number<3){
		this.actionDone=number;}
		}
	
	public int getActionDone(){
		return actionDone;
	}
	
	public String getMood(){
		int[] counting = new int[]{
				happiness,
				hunger,
				energy,
				hygiene,
				exercise,
				sickness,
				injury
		};
		int comp=0;
		for (int spec : counting){
			if(spec<40){
				comp += 1;
			}
		}
		
		switch(comp){
		case 1:return "happy";
		case 2:return "great";
		case 3:return "ok";
		case 4:return "upset";
		case 5:return "terrible";
		case 6:return "exhausting";
		case 7:return "dying";
			default: return "wonderful";
		}
	}
	
	public void eat(Food food){
		if(this.actionDone<2){
			actionDone+=1;
		
		if(food.expired()){
			this.isSick=true;
			hunger += food.nutrition()*0.15;
			hygiene -= food.getSize()*8;
			happiness -= food.tastiness()*3;
		}
		else{
			if(food.getName().equals(favFood)){
				hunger += 20;
				happiness += 20;
			}
		hunger += food.nutrition()*0.2;
		hygiene -= food.getSize()*5;
		happiness += food.tastiness()*3;
		}
		updateHealth();}
		
	}
	
	
	
	public void sleep(){
		if(this.actionDone<2){
		actionDone+=1;
		slept=true;
		energy += 10;
		this.updateHealth();
		}
	}
	
	public void aDayPassed(){
		actionDone=0;
		if(slept){
			slept=false;
		}else{
			energy -= 20;
			hunger -= 10;

		}
		this.updateHealth();
		
	}
	
	public void toileting(){
		if(this.actionDone<2){
		actionDone+=1;
		this.updateHealth();
		}
	}
	
	public void play(Toy toy){
		if(this.actionDone<2){
		actionDone+=1;
		toy.setDurability(toy.getDurability()-1);;
		this.updateHealth();
		}
	}
	
	public void goTo(Place place){
		if(actionDone<2){
			if(place.equals(this.favPlace))
		actionDone+=1;
		this.updateHealth();
		}
		
	}
	public void getInject(){
		if(isSick){
			isSick = false;
			sickness = sickness/2;
		}else{
			isSick = true;
			isMisbehave = true;
			sickness += 20;
		}
		this.updateHealth();
	}
	
	public void revive(){
		if(!hasRevived && isDead){
		this.hasRevived = true;
		this.reset();
		}
		else{
			if(hasRevived){
			System.out.println("You cant revive "+name+"! because you have revived it once!");
		}
			if(!isDead){
				System.out.println(name+" is still alive...!!!");
			}	
			}
	}
	
	public void reset(){}
	
	public void hostIsAway(){
		
	}
	

	public void statsOfPet(){
		String statistics = String.format("Name: %s \nSpecies: %s\nAge: %d\nHealth   : %,.1f\nHunger   : %3d Hygiene : %3d Energy: %3d\nHappiness: %3d Exercise: %3d",this.getName(),this.getSpecies(), this.getAge(), getHealth(), hunger, hygiene, energy, happiness, exercise);
		System.out.println(this.name + "'s current statistic\n" + statistics);
	
	}
	
	public String[] statistic(int space){
		
		String[] stat = new String[] {
				tool.indentString(name, space, " "),
				tool.indentString("Species: "+species, space, " "),
				tool.indentString("Age: "+age+" day(s)", space, " "),
				tool.indentString("Health: "+health+"%", space, " "),
				tool.indentString("Hunger: " + hunger+"%",space, " "),
				tool.indentString("Hygiene: " + hygiene+"%",space, " "),
				tool.indentString("Energy: " + energy+"%",space, " "),
				tool.indentString("Happiness: " + happiness+"%",space, " "),
				tool.indentString("Exercise: " + exercise+"%",space, " "),
				tool.indentString("sickness: " + sickness+"%",space, " "),
				tool.indentString("Injury: " + injury+"%",space, " "),
				};
		return stat;
		
	}
	
	public void introduction(){
		String[] attribute = attributes(44);
		String[] description = description();
		if(attribute.length==description.length){
		for (int i=0; i<attribute.length;i++){
			System.out.print(attribute[i]+description[i]);
		}}
		}
	public String intro(){
		String[] attribute = attributes(44);
		String[] description = description();
		String descript = "";
		if(attribute.length==description.length){
		for (int i=0; i<attribute.length;i++){
			descript += attribute[i]+description[i];

		}}
		return descript;
		}
	
	public String[] description(){
		String[] description = new String[]{
				"* * * * * * * * Description * * * * * * * ** *\n",
				"* * * * ** * * * * * * * * * * * * * * * * * *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"*                                            *\n",
				"* * * * * * * * * * * * * * * * * * * * * * *\n"
		};
		return description;
	}
	
	public String[] attributes(int space){
		String title= tool.indentString(this.species +"'s attributes ", space, ' ');
		String[] attribute = new String[] {
				title, 
				tool.indentString("Age: "+age+" day(s)",space,' '),
				tool.indentString("Weight: "+this.weight+" kg", space,' '),
				tool.indentString("", space, ' '),
				tool.indentString("Favorite", space, ' '),				
				tool.indentString("Place:       Food:         Toy:", space, ' '),
				tool.indentString(this.favPlace, 13, ' ')+tool.indentString(this.favFood, 14, ' ')+tool.indentString(this.favToy, 17, ' '),
				tool.indentString(String.format("Health: %.1f%%", this.health), space, ' '),
				tool.indentString(String.format("Hunger   : %3d%% Hygiene : %3d%% Energy: %3d%%", this.hunger, this.hygiene, this.energy), space, ' '),
				tool.indentString(String.format("Happiness: %3d%% Exercise: %3d%%",happiness, exercise), space, ' '),
				tool.indentString("", space, ' ')
		};
		return attribute;
	}
	public String toString(){
		return this.name;
	}

	public static void main(String args[]){
		Pet p = new Cat(0,"Dinosaur");
		Food s = new Corpse();
		p.eat(s);
		p.statsOfPet();
		p.introduction();
	}
}
