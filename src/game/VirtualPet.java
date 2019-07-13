package game;

import java.io.*;
import java.util.*;

import item.*;
import map.*;

import pet.*;

/**
 * <h1>Virtual Pet</h1>
 * This VirtualPet program implements an application that constructs 
 * the overall fundamental features of the game.
 * @author Lu-Yung Huang
 * @since 2017-04-15
 */
public class VirtualPet implements Serializable{

	transient Scanner in = new Scanner(System.in);
	protected static Date date;
	protected ArrayList<Player> players;
	protected Player currentPlayer;
	protected ArrayList<Pet> petsDone = new ArrayList<Pet>();
	protected static int noGamesPlayed = 0;
	protected int rounds, i=0, j=0, currentDay=0, numOfCus=5, actionDone, stage=0;
	protected Pet currentPet;
	protected boolean loaded=false, limit=true;
	protected Data data=new Data();
	protected Store bugWorld, corpseParty, grocery, growersMarket, neWorld, seaWorld, toyLand;
	
/**
 * 
 */
public VirtualPet(){
		this.date=new Date();
		data= new Data();
		data.setDate(date);
	}

/**
 * This method is used to display current date and day of week.
 */
void weekDay(Date dt){	
		String[] weeks = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		String[] months = {"Jan","Feb","Mar","Apr","May","June","July","Aug","Sep","Oct","Nov","Dec"};
		Calendar cal = Calendar.getInstance(); 
	    cal.setTime(dt);
	        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
	        if (w < 0){
	            w = 0;}
	        int m = cal.get(Calendar.MONTH);
            System.out.println("Today is "+weeks[w]+" "+cal.get(Calendar.DATE)+ " "+months[m]+ " " +cal.get(Calendar.YEAR) +", Such a nice day!\n.................."); 
	}

/**
 * This is the method which displays the introduction at the beginning in the out put
 * and implements some basic key options of the program.
 */
void introduction(){
		this.stage=1;
		System.out.println((this.noGamesPlayed>0)?"restarts: "+this.noGamesPlayed+"\n..................":"");
		weekDay(date);        
		System.out.println("Welcome to this virtual pet store...\nAs we are on promotion, every customer can have up to three pets for free!!");
		System.out.println("");		
		int opt=5;
		
		while(opt>1&&opt<=5){
			opt=chooseANumber(5, "\nQ:exit R:restart H:help\n(Note: You can use these commands throughout the whole game)\n\n1.Start   2.Help   3.Load(beta)   4.Exit   (5.Admin)",1);
		if(opt==2){
			new Help(0).manual();
		}
		if(opt==3){
			load();
			if(loaded){break;}
		}
		if(opt==4){
			exiting();
		}
		if(opt==5){
			boolean loop=true;
			System.out.println("Welcome to the testing modes ..");
			System.out.print("please enter the password: ");
			String pass=in.next();
			while(loop){				
				if(pass.equals("qwerty")){
					int ans = this.chooseANumber(4, "1. Save \n2. unlimited players and pets \n3. last saved\n5. quit",1);
					switch(ans){
					case 1:save();break;
					case 2:this.limit=false;System.out.println("Done!\n");break;
					case 3:System.out.println("not.. yet..");break;
					case 5:loop=false;break;
						default:
							
					}
				}else{
					System.out.print("XXXX incorrect password!! XXXX\n");
					break;
				}}}}}

/**
 * This method is used to input the number, names, age and gender of players.
 * The maximum number of players can be up to three.
 */
void initPlayers(){
		this.stage=2;
		players = new ArrayList<Player>();
		
		if(loaded&&numOfCus==0||!loaded){
		numOfCus = chooseANumber(3, "How many players are there? :) (at most 3 )",1);}
		Set<String> playersName = new HashSet<String>();
		for(int i=1; i<numOfCus+1; i++){
			this.i=i;
			if(loaded){
				i=this.i;
			}
			String name = askQuestion("What's your name? My precious Player " + i + ".");
			
			while(playersName.contains(name)){
				name = askQuestion("A different name please.");
			}
			playersName.add(name);
			
			int age = chooseANumber(Integer.MAX_VALUE, "How old are you?", 0);
			String gender = askQuestion("What is your gender? (F/M)");
			while(!gender.equalsIgnoreCase("F")&!gender.equalsIgnoreCase("M")){
				gender = this.askQuestion("Please choose either F or M");
			}
			Player p = new Player(i, name, age, gender);
			players.add(p);
			System.out.println(String.format("Please accept my most sincere welcome, %s, %s %s.\n",p.getAgeSpecial(), p.getGenderSpecial(), p.getName() ));
		}
		loaded = false;
		
	}

/**
 * This method is used to input game time, number, species and names of pets.
 * The number of pets is up to three and the name of each pet is unique.
 */
void pickPets(){
		this.stage=3;
		if(loaded && rounds==0||!loaded){
		rounds = chooseANumber(Integer.MAX_VALUE, "How many days?", 1);}
		System.out.println("Eveyone can choose up to 3 pets.");
		Set<String> petsNames = new HashSet<>();
		for(int i=0;i<this.numOfCus;i++){
			this.i = i;
			if(loaded){i = this.i;}
			String ask=String.format("How many pets would you like, %s?", this.players.get(i).getName());
			int numPets=chooseANumber(3, ask, 1);
			for(int j=0;j<numPets;j++){
				String order="";
				switch(j){
				case 0:order="first";break;
				case 1:order="second";break;
				case 2:order="third";break;
				default: System.out.println("Impossible!");break;
				}
				boolean done=false;
				int species=0;
				while(!done){
				ask=String.format("%s, What species should your %s pet be?\n1.Cat       2.Dog\n3.Owl       4.Rabbit\n5.Dinosaur  6.Wolf\n7.Exit ",players.get(i).getName().toUpperCase(), order);
				species=this.chooseANumber(8, ask, 1);
				if(species==7){
				exiting();continue;
				}
				petsAttributes(species);
				String opt = this.askQuestion("Confirm? (Y/N)");
				while(!opt.equalsIgnoreCase("Y")&&!opt.equalsIgnoreCase("N")){
					opt = this.askQuestion("Oooops, enter a poper command.");
				}
				if(opt.equalsIgnoreCase("Y")){
					done=true;
				}
				}
				String type="";
				switch(species){
				case 1:type="cat";break;
				case 2:type="dog";break;
				case 3:type="owl";break;
				case 4:type="rabbit";break;
				case 5:type="dinosaur";break;
				case 6:type="wolf";break;
				case 8:type="burger";break;
				default: System.out.println("Impossible!");break;
				}
				
				String petName=this.askQuestion(String.format("What's the name of your %s?", type));
					while(true){
						if(petsNames.contains(petName)){
							petName=this.askQuestion("Same name with another pet.");
								}
						else{
							petsNames.add(petName);
							break;
						}
				}
				switch(species){
				case 1:players.get(i).addPet(new Cat(j,petName));break;
				case 2:players.get(i).addPet(new Dog(j,petName));break;
				case 3:players.get(i).addPet(new Bird(j,petName));break;
				case 4:players.get(i).addPet(new Rabbit(j,petName));break;
				case 5:players.get(i).addPet(new Dinosaur(j,petName));break;
				case 6:players.get(i).addPet(new Wolf(j,petName));break;
				case 8:players.get(i).addPet(new Burger(j,petName));break;
				default: System.out.println("Impossible!");break;
				}	
		}
			loaded = false;
			}
	}

/**
 * This method is to generate different stores and default stock quantities.
 */
void initPlaces(){
	
	neWorld = new NeWorld();neWorld.inStock();

	seaWorld = new SeaWorld();seaWorld.inStock(10);

	bugWorld = new BugWorld();bugWorld.inStock(10);

	corpseParty = new CorpseParty();corpseParty.inStock(10);

	grocery = new Grocery();grocery.inStock(10);

	growersMarket = new GrowersMarket(); growersMarket.inStock(10);

	toyLand = new ToyLand(); toyLand.inStock(10);
}

/**
 * This method is used to generate stock quantity of each store.
 * @param qty
 */
void updateStocks(int qty){
	neWorld.inStock();

	seaWorld.inStock(qty);

	bugWorld.inStock(qty);

	corpseParty.inStock(qty);

	grocery.inStock(qty);

	growersMarket.inStock(qty);

	toyLand.inStock(qty);
	
}
	
/**
 * This method is the main part of the game which ensures game being run no longer
 * than the given game time input by players. By this method, players are allowed 
 * to choose different actions to perform on different pets.
 */
void progress(){
		stage=4;
		for(int day=0;day<rounds;day++){
			if(loaded){day=this.currentDay;}
			this.currentDay=day;
			for(int i=0;i<numOfCus;i++){
				this.updateStocks(10);
				if(loaded){i=this.i;}
				this.i=i;
				currentPlayer = players.get(i);
					ArrayList<Pet> allPets = currentPlayer.getAllPets();
					if(!loaded){modifyActionDone(allPets, 0);}
					while(actionSum(allPets)<allPets.size()*2){
						System.out.println(
										"\n"
										+bar(day+1, "Sunny",
														"Good morning.."+currentPlayer.getName(), 
														70, "*"));
					String ask =    banner(allPets, 63)
									+ "\nWhat action would you like to do, "+currentPlayer.getName()+"?"
									+ "\n1.Status"
									+ "\n2.Inventory"
									+ "\n3.Walk"
									+ "\n4.Toileting"
									+ "\n5.Discipline"
									+ "\n6.Go Shopping"
									+ "\n7.Sleep"
									+ "\n8.Skip all actions"
									+ "\n9.Settings";
					
					boolean chosen = false;
					System.out.println(ask);
					while(! chosen){
						int opt=chooseANumberOptional(9, ask, 1);
						int index=0;
					switch (opt){
					case 1:
						System.out.println("Your Pets current Stats-->\n");
						showPetsStats(21);chosen = true;break;
					case 3: 
						index=(allPets.size()!=1)?chooseAPet(allPets,"walk"):0;
						if (index!=-1){
							currentPet = allPets.get(index);
							reactToAction(currentPlayer,currentPet, opt);
							}chosen=true;
							break;
					case 4:
						index=(allPets.size()!=1)?chooseAPet(allPets,"interact"):0;
						if (index!=-1){
							currentPet = allPets.get(index);
							reactToAction(currentPlayer,currentPet, opt);
							}chosen=true;
							break;
					case 5:
						index=(allPets.size()!=1)?chooseAPet(allPets,"discipline"):0;
						if (index!=-1){
							currentPet = allPets.get(index);
							reactToAction(currentPlayer,currentPet, opt);
							}chosen=true;
							break;
					case 7:
						index=(allPets.size()!=1)?chooseAPet(allPets,"let it sleep"):0;
						if (index!=-1){
						currentPet = allPets.get(index);
						reactToAction(currentPlayer,currentPet, opt);
						}chosen=true;
						break;
					case 2:this.viewInventory();chosen=true;break;
					case 6:
						chooseStore();
						chosen = true;
						break;
					case 8:
						modifyActionDone(allPets, 2);
						j=allPets.size();
						chosen=true;
						break;
						
					case 9:
						settings();
						chosen=true;
						break;
					default:break;
					}}}
					this.loaded=false;
					
				}
			}
		finishing();
	}

/**
 * This method contains description of every store and allows players to choose which
 * store to visit.
 */
void chooseStore(){
	String ask = "Which store would you like to visit? (0:MENU)\n"
					+ "1. Ne World        -higher prices, contains everything\n"
					+ "2. Sea World       -sells sea food\n"
					+ "3. Bug World       -sells bugs\n"
					+ "4. Corpse Party    -sells raw meats\n"
					+ "5. Grocery         -sells somthing\n"
					+ "6. Growers Market  -sells\n"
					+ "7. Toy Land        -sells toys obvoiously\n";
	while(true){
	int chosen = this.chooseANumber(7, ask, 0);
	if(chosen==0){
		break;
	}
	if(chosen!=0){
		switch (chosen){
		case 1: 
			storeAsks(neWorld);break;
		case 2:
			storeAsks(seaWorld);break;
		case 3:
			storeAsks(bugWorld);break;
		case 4:
			storeAsks(corpseParty);break;
		case 5:
			storeAsks(grocery);break;
		case 6:
			storeAsks(growersMarket);break;
		case 7:
			storeAsks(toyLand);break;
		}
	}
	}
}

/**
 * This method is used to list products, price, store stock and inventory size.
 * @param store Places where provides various products.
 */
void storeAsks(Store store){
	
	
	int chosen=1;
	while(chosen!=0){
		String s = "What would you like to buy?(0:Cancel) \n\n";
	int i=0, size = store.getProducts().size();
	String[] inventory = inventory().split("\n");
	s += new Tools().twoSidedString("Store", "Inventory", 50)+"\n";
	int invSize = inventory.length;
	for(Item item:store.getProducts()){
		i++;
		String toBeAdded = "";
		toBeAdded += i + ". "+item.showPrice();
		if(item.isOnSale()){
			toBeAdded +="(On Sale! "+ item.getDiscount()+"% OFF)";
		}
		if(i<invSize){
		s += new Tools().twoSidedString(toBeAdded, inventory[i], 50);
		}else{
		s += toBeAdded;
		}
		s+="\n";
	}
	
	while(i<invSize){
		i++;
		if(i!=invSize){
		s += new Tools().twoSidedString("", inventory[i], 50)+"\n";}
	}
	chosen = this.chooseANumber(size, s, 0);
	
	if(chosen!=0){
		Item item = store.getProducts().get(chosen-1);
		boolean isFood = item instanceof Food;
	
		if(isFood){
			if(currentPlayer.buysFood((Food) item)){
				store.removeProduct(item);
			}else{
				System.out.println("\ninsufficient money!");
				chosen = this.chooseANumber(size, "", 0);
			}
			
		}
		else if(! isFood){			
				if(currentPlayer.buysToy((Toy) item)){
					store.removeProduct(item);
				}else{
					System.out.println("\ninsufficient money!");
					chosen = this.chooseANumber(size, "", 0);
				}
				
			
		}
	}
	}
	}

/**
 * This method shows introduction of each pet.
 * @param code
 */
void petsAttributes(int code){

		switch(code){
		case 1:new Cat(1,"Cat").introduction();System.gc();break;
		case 2:new Dog(1,"Dog").introduction();System.gc();break;
		case 3:new Bird(1,"Owl").introduction();System.gc();break;
		case 4:new Rabbit(1,"Rabbit").introduction();System.gc();break;
		case 5:new Dinosaur(1,"Dinosaur").introduction();System.gc();break;
		case 6:new Wolf(1,"Wolf").introduction();System.gc();break;
		case 8: new Burger(1,"Burger").introduction();System.gc();break;
		default: System.out.println("Impossible!");break;}
	}

/**
 * This method varies pets' reactions to players' actions.
 * @param player Users who play this game.
 * @param pet Animals which interact with players.
 * @param action Performed on pets by players.
 */
void reactToAction(Player player, Pet pet,int action){
		switch (action){
		case 3:String ask="\nWhere would you like to walk your pet..\n1. "
						+ "Cinema\n2. Clinic\n3. Park\n4. "
						+ "Store\n5. Woods";
		       int opt = chooseANumber(5, ask, 0);
		       break;
		case 4:
			pet.toileting();
			break;
		case 5: 
			player.discipline(pet);
		case 7: 
			pet.sleep();
			break;
			default:System.out.println("How could it be possible...");
			
		}
	}

/**
 * This method is used to implements a inventory feature which allows players to view
 * the names and quantities of products stored in it.
 * @return thingsYouOwn Products that players own and stored in inventory.
 */
public String inventory(){
	String thingsYouOwn = 
					"~~INVENTORY~~ (0:Back)\n";
	int i=0, j=0;
	ArrayList<Toy> toyBox = currentPlayer.getToyBox();
	ArrayList<Food> fridge = currentPlayer.getFridge();
	ArrayList<Integer> foodqty = currentPlayer.getFoodqty();
	ArrayList<Integer> toyqty = currentPlayer.getToyqty();
	if(toyBox.isEmpty()&&fridge.isEmpty()){
		i=1;
		thingsYouOwn += "\n--EMPTY--";
	}
	else{
		thingsYouOwn+="--FOOD--\n";
	for(Food food: fridge){
		i++;
		
		thingsYouOwn += food.getName();
		thingsYouOwn += (foodqty.get(i-1)!=1)?" ("+foodqty.get(i-1)+")":"";
		thingsYouOwn += "\n";
	}
	thingsYouOwn+="--TOYS--\n";
	for(Toy toy: toyBox){
		j++;
		thingsYouOwn += toy.getName();
		thingsYouOwn += (toyqty.get(j-1)!=1)?" ("+toyqty.get(j-1)+")":"";
		thingsYouOwn += "\n";
	}
	}
	return thingsYouOwn;
}

/**
 * This method lists products stored in inventory and allows players to consume them.
 */
public void viewInventory(){
	while(true){
	String thingsYouOwn = 
					"~~INVENTORY~~ (0:Back)\n";
	int i=0, j=0;
	ArrayList<Toy> toyBox = currentPlayer.getToyBox();
	ArrayList<Food> fridge = currentPlayer.getFridge();
	ArrayList<Integer> foodqty = currentPlayer.getFoodqty();
	ArrayList<Integer> toyqty = currentPlayer.getToyqty();
	if(toyBox.isEmpty()&&fridge.isEmpty()){
		i=1;
		thingsYouOwn += "\n--EMPTY--";
	}
	else{
		thingsYouOwn+="--FOOD--\n";
	for(Food food: fridge){
		i++;
		
		thingsYouOwn += i+j+" "+food.getName();
		thingsYouOwn += (foodqty.get(i-1)!=1)?" ("+foodqty.get(i-1)+")":"";
		thingsYouOwn += "\n";
	}
	thingsYouOwn+="--TOYS--\n";
	for(Toy toy: toyBox){
		j++;
		thingsYouOwn += j+" "+toy.getName();
		thingsYouOwn += (toyqty.get(j-1)!=1)?" ("+toyqty.get(j-1)+")":"";
		thingsYouOwn += "\n";
	}
	}
	int select=0;
	select = chooseANumber(i+j, thingsYouOwn, 0)-1;
	if(select == -1){
		break;
	}else{
		
	int pet=0;
	while(true){
		if(select<fridge.size()){
			while(true){
				pet = chooseAPet(currentPlayer.getAllPets(),"feed");
		if(pet==-1){
			break;
		}else{
			currentPlayer.feed(fridge.get(select), currentPlayer.getAllPets().get(pet));
			
			break;
		}
			}	
		}
		else{
			select-=fridge.size();
			System.out.println(select);
			while(true){
				pet = chooseAPet(currentPlayer.getAllPets(),"play");
			if(pet==-1){
				break;
			}else{
				currentPlayer.playWith(toyBox.get(select), currentPlayer.getAllPets().get(pet));;
				break;
			}
				}
			
			}
		break;
		}
	}
	}
	
}

/**
 * This method is used to count the number of times when actions being performed.
 * @param pets Animals which interact with players
 * @return actionSum The number of times when actions being performed in total.
 */
public int actionSum(ArrayList<Pet> pets){
		int actionSum=0;
		for(Pet pet:pets){actionSum+=pet.getActionDone();}
		return actionSum;
	}
	
/**
 * This method is used to make players choose a pet which they would like
 * to interact with.
 * @param pets Animals that interact with players.
 * @param action Performed on pets by players
 * @return opt Index of each action given to be chosen.
 */
public int chooseAPet(ArrayList<Pet> pets, String action){
		String ask=String.format("Please choose the pet to " + action + ". (0:cancel)");
		int k=0;
		this.loaded=false;
		System.out.println(ask);
		for(Pet pet:pets){
				k++;
				if(pet.isDead()){
					System.out.println(String.format("%d %s",k, pet.getName())+" (Dead)");
				}else{
					System.out.println(String.format("%d %s%s",k, pet.getName(),
									(pet.getActionDone()==2)?" (No actions remained)":" ("+pet.getActionDone()+"/ 2)"));
				}
				}
		int opt=this.chooseANumber(k, "", 0)-1;
		if(opt==-1){
			return -1;
		}
		while(pets.get(opt).getActionDone()==2){
			opt=this.chooseANumber(k, "No actions remained", 0)-1;
			if(opt==-1){
				return -1;
			}
		}
		return opt;
	}

/**
 * This method sets a done action to be num and execute a loop to generate next day.
 * @param pets
 * @param num
 */
public void modifyActionDone(ArrayList<Pet> pets, int num){
		for(Pet pet: pets){
			pet.setActionDone(num);
		}
	}

/**
 * This method displays status of pets.
 * @param pets Different species that interact with players.
 * @param size Size defines overall width.
 * @return banner Status of pets.
 */
String banner(ArrayList<Pet> pets, int size){
		String banner="";
		for(int i=0;i<size;i++){
			banner+="-";
		}
		banner+="\n";
		for(int i=0;i<size;i++){
			banner += " ";
		}
		banner += "\n";
		int j=0;
		banner += new Tools().centreString("Hi, player "+currentPlayer.getNum(), size);
		banner +="\n";
		banner += new Tools().beRightString("cash: $"+currentPlayer.getCash(), size);
		banner += "\n";
		for(int i=0;i<size;i++){
			banner+="-";
		}
		banner += "\n";
		for(Pet p:pets){
			banner+=new Tools().indentString("@ "+p.getName(), 20, ' ')+"|";
		}
		banner+="\n";
		for(Pet p:pets){
			banner += new Tools().indentString("Health: "+p.getHealth()+"%", 20,' ')+"|";
		}
		banner+="\n";
		for(Pet p:pets){
			banner += new Tools().indentString("Feels "+p.getMood(), 20,' ')+"|";
		}
		banner+="\n";
		for(Pet p:pets){
			banner += new Tools().indentString("Turn left: "+(2-p.getActionDone()), 20,' ')+"|";
		}
		banner+="\n";
		for(int i=0;i<size;i++){
			banner+="-";
		}
		banner += "\n";
		return banner;
	}
	
/**
 * This method is used to display status of a day.
 * @param day Day of a week.
 * @param weather Weather generated randomly.
 * @param greeting 
 * @param length Length of status displayed in terminal.
 * @param ind 
 * @return out Status of a day printed out in terminal.
 */
String bar(int day, String weather,String greeting, int length, String ind){
		int daySize = Integer.toString(day).length();
		int range = (daySize%2==0)?7+daySize+2:7+daySize+2+1;
		int weatherSize = 10+weather.length()*2-1;
		int cent= length-weatherSize*2-1;
		Tools tool = new Tools();
		String[] barLeft = new String[] {
				tool.indentString("", range, ind+" "),
				tool.indentString(ind+" Day: "+day,range-1 , " ")+ind.trim(),
				tool.indentString("",range, ind+" ")};
		String[] centre = new String[]{
				tool.indentString("", cent+2, " "),
				tool.indentString(tool.centreString(greeting, cent+3),cent+3," "),
				tool.indentString("", cent+2, " ")};
		String[] barRight = new String[]{
				tool.indentString("", weatherSize, ind+" "),
				tool.indentString(ind+" Weather: "+weather, weatherSize-1, ' ')+ind,
				tool.indentString("", weatherSize, ind+" ")
		};
		String out="";
		for (int i=0;i<3;i++){
			out +=barLeft[i]+centre[i]+barRight[i];
			
			out = out.trim();
			if(i!=2){
			out+="\n";}
		}
		return out;
	}

/**
 * This method is to show status of pets in terminal.
 * @param size
 */
void showPetsStats(int size){
	ArrayList<Pet> allPets = currentPlayer.getAllPets();
	for(Pet pet: allPets){
		System.out.print("@"+pet.statistic(size-1)[0]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(new Tools().beRightString("|", size+1));
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[1]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[2]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[3]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[4]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[5]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[6]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[7]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[8]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[9]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(pet.statistic(size)[10]+"|");
		
	}
	System.out.println();
	for(Pet pet: allPets){
		System.out.print(new Tools().indentString("", size+1, '*'));
		
	}
	System.out.println();
	System.out.println("0:Back");
	int op;
	do{
		op = this.chooseANumberOptional(0, "", 0);
	}while(op!=0);
	
}

/**
 * This methods provides options which allowed players to change the gameplay.
 */
void settings(){
	int opt=1;
	while(opt!=0){
		opt = this.chooseANumber(6, "Settings (0:Cancel)\n1. Help\n2. Save (beta)\n"
					+ "3. Load(beta)\n4. rename players\n5. rename pets \n6. Exit the game",0);
	switch(opt){
	case 1: new Help(0).manual();break;
	case 2: save();break;
	case 3: load();break;
	case 4: renamePlayers();break;
	case 5: renamePets();break;
	case 6: exiting();break;
		default:break;
	}}
	
}

/**
 * This method allows players to change their usernames.
 */
void renamePlayers(){

	int num=1;
	while(true){
	System.out.println("Who would you like to rename? (0:Cancel)");
	HashMap<Integer, Player> map= new HashMap<Integer, Player>();
	int i = 0;
	for(Player player:players){
		i++;
		System.out.println(String.format("%d. %s", player.getNum(), player.getName()));
		map.put(i, player);
	}
	num=this.chooseANumber(this.numOfCus, "", 0);
	if(num!=0){
		String opt=this.askQuestion("Renaminging (0:Cancel)");
		while(!opt.equals("0")){
			String oldName = map.get(num).getName();
			map.get(num).setName(opt);
			System.out.println("player "+num+" renamed as "+map.get(num).getName()+ " from "+ oldName+".\n");
			break;
		};
	}
	if(num==0){
		break;
	}
	}}

/**
 * This method allows players to change the names of their pets.
 */
void renamePets(){
	int num=1;
	while(true){
	System.out.println("Which one would you like to rename? (0:Cancel)");
	HashMap<Integer, Pet> map= new HashMap<Integer, Pet>();
	int i = 0;
	for(Player player:players){
		System.out.println(String.format("Player %d owns %d pet(s):", player.getNum(), player.getAllPets().size()));
		for(Pet pet:player.getAllPets()){
			i++;
			System.out.println(String.format("%d. %s", i, pet.getName()));
			map.put(i, pet);
		}
	}
	num=this.chooseANumber(i, "", 0);
	if(num!=0){
		String opt=this.askQuestion("Renaminging (0:Cancel)");
		while(!opt.equals("0")){
			String oldName = map.get(num).getName();
			map.get(num).setName(opt);
			System.out.println("Pet "+oldName+" renamed as "+map.get(num).getName()+".\n");
			break;
		};
	}
	if(num==0){
		break;
	}
	}
	
}

/**
 * This method allows players to save current game progress.
 */
public void save(){

		boolean loop=true;
		String fileName="", filePath="";
		while(loop){
		
				File dir =new
								File(".");
				dir.mkdirs();
				
				File tmp = new File(this.askQuestion("Enter the file"
								+ " name you want to save as: (in"
								+ "put Q to abort)")+".data");
				while(tmp.toString().equals(".data")){
					tmp = new File(this.askQuestion("it's not a good s"
									+ "aved file name.\nEnter anothe"
									+ "r one please\n(input Q to abort).")+".data");
				}
				 fileName = dir.getAbsolutePath() + File.separator + tmp;
				 filePath=dir.getAbsolutePath().substring(0, dir.getAbsolutePath().length()-1)+tmp;
				 String opt="";
				 if(tmp.toString().equalsIgnoreCase("Q.data")){break;}
				if(tmp.exists()){
				opt = this.askQuestion("this file already exist"
								+ "ed, do you wish to continue?(Y/N"
								+ ")\n(input Q to abort)");
			    if(opt.equalsIgnoreCase("N")){continue;}
			    }
				if(tmp.toString().equalsIgnoreCase("Q.data")||opt.equalsIgnoreCase("Q")){break;}
				try{
				FileOutputStream f_out = new
			    				  FileOutputStream (fileName);
			    ObjectOutputStream obj_out = new
			    		             ObjectOutputStream (f_out);
			    Store[] stores = new Store[] {bugWorld, corpseParty, grocery, growersMarket, neWorld, seaWorld, toyLand};
			    this.data.setStores(stores);
			    this.data.setDate(date);		
				this.data.storeNumOfCus(numOfCus);
				this.data.storePlayers(players);
				this.data.setCurrentPlayer(currentPlayer);
				this.data.storeCurrentPet(currentPet);
				this.data.storeCurrentRun(currentDay);
				this.data.storeRuns(rounds);
				this.data.storeIAndJ(i, j);
				this.data.setPetsDone(petsDone);
				this.data.setStage(stage);
				this.data.setNoGamesPlayed(noGamesPlayed);
				obj_out.writeObject(this.data);
				System.out.println("players and corresponding information saved.");
				System.out.println("Pets saved.");
				System.out.println("Progress saved.\n");
			    loop=false;   

	    }
	    catch (Exception e)
	    {
	    	e.printStackTrace();
	      System.out.println("\n\"\"\"Invalid file name, file unsaved.\"\"\"\n");
	    }
		}
		if(!loop){
			
		System.out.println("File saved successfully at "+filePath+"\n");
		}
	}

/**
 * This method allows players to load saved game progress.
 */
public void load(){
		while(true){
		File dir =new
						File(".");
		File tmp = new File(this.askQuestion("Enter the file name y"
						+ "ou want to load with.\n(input 0 to abort)")+".data");
		if(tmp.toString().equalsIgnoreCase("0.data")){
			break;
		}
		String fileName = dir.getAbsolutePath() + File.separator + tmp;
		String filePath=dir.getAbsolutePath().substring(0, dir.getAbsolutePath().length()-1);
		File file = new File(fileName);
		Object obj = new
						 Object ();
		try
	    {
	      FileInputStream f_in = new
	              FileInputStream (fileName);
	      ObjectInputStream obj_in = new
	              ObjectInputStream (f_in);
	      obj = obj_in.readObject ();
	      this.data=(Data) obj;
	      this.players=this.data.getPlayers();
	      this.actionDone=data.getActionDone();
	      this.currentDay=data.getCurrentRun();
	      this.date=data.getDate();
	      this.bugWorld = data.getStores()[0];
	      this.corpseParty = data.getStores()[1];
	      this.grocery = data.getStores()[2];
	      this.growersMarket = data.getStores()[3];
	      this.neWorld = data.getStores()[4];
	      this.seaWorld = data.getStores()[5];
	      this.toyLand = data.getStores()[6];
	      this.currentPet=data.getCurrentPet();
	      this.numOfCus=data.getNumOfCus();
	      this.rounds=data.getRuns();
	      this.i=data.getIAndJ()[0];
	      this.j=data.getIAndJ()[1];
	      this.petsDone=data.getPetsDone();
	      this.stage=data.getStage();
	      this.noGamesPlayed=data.getNoGamesPlayed();
	      this.currentPlayer=data.getCurrentPlayer();
	      this.loaded=true;
	      System.out.println("Loaded.\n");
	      break;
	    }
	    catch (Exception e)
	    {
	      System.out.println (e.toString ());
//	      System.out.println
//	      ("it is not the correct saved file.."+ "You should put the file at "+filePath);
	      
	    }

	if (!(obj instanceof Data))
	{
	  System.out.println
	      ("It is not the correct saved file..\n"+ "You should put the file at "+filePath+"\n");
	}
		}
		
		if(loaded){
			System.out.println("Welcome back..");
			switch(stage){
			case 1:
			case 2:if(stage==2)
				System.out.println("Why did you save your progress here...? okay..\n");
				this.initPlayers();
			case 3:
				if(stage==3)
				System.out.println("Petty~");
				this.pickPets();
			case 4:
				progress();break;
			}
		}
		}

/**
 * This method allows players to restart the game.
 */
public void restart(){

		String opt = this.askQuestion("Sure to restart? (Y/N)");
	while(true){
		if(!opt.equalsIgnoreCase("Y")&&!opt.equalsIgnoreCase("N")){
			opt = this.askQuestion("invalid");
		}
		if(opt.equalsIgnoreCase("Y")){
		    updateGamesPlayed();
		    new VirtualPet().start();
		}
		else{break;}
	}}
	
	
/**
 * This method returns a questions for confirmation.
 * @param q
 * @return
 */
public String askQuestion(String q){

String c="whaaaaaat";
Scanner in = new Scanner(System.in);
boolean stop=false;
while(! stop){
	System.out.println(q);
	c=in.nextLine();
switch(c){				
case "Q": exiting();break;
case "R": restart();break;
case "H": new Help(0).manual();break;
case "SAVE": save();break;
case "LOAD": load();break;
default:stop=true;break;}

}
//in.nextLine();
return c;
}

/**
 * This method prints out an ending when finishing.
 */
void finishing(){
	stage=5;
	System.out.println("Game finished.. bye bye~");System.exit(0);
}

/**
 * This method returns the confirmation question defined above when exiting.
 */
void exiting(){
	if(stage==4){
	int opt = this.chooseANumber(3, "Are you sure to leave? (0:Cancel)\n1.Save and quit\n2.Save without quitting\n3.Quit directly", 0 );
	
	switch(opt){
	case 1:save();System.out.print(" Bye~Bye~");System.exit(0);
	case 2:save();break;
	case 3:System.exit(0);break;
	default:break;
	}
	}else{
	String opt="N";
	while(true){
	opt=askQuestion("Are you sure to quit? (Y/N)\n(You cannot save the progress before all pets are created.) ");
	while(!opt.equalsIgnoreCase("Y")&&!opt.equalsIgnoreCase("N")){
		opt = this.askQuestion("invalid");
	}if(opt.equalsIgnoreCase("Y")){
	
		System.out.println("Bye....will miss you..");
		System.exit(0);
	}if(opt.equalsIgnoreCase("N")){
		break;
	}
}}}

/**
 * An optional method defines shortcut keys of different options.
 * @param upperBound Upper bound of the limit.
 * @param question
 * @param lowerBound Lower bound of the limit.
 * @return opt The shortcut keys input by players.
 */
int chooseANumberOptional(int upperBound, String question, int lowerBound){

	int opt;
	String str;
	while(true){try{
		opt = in.nextInt();
		in.nextLine();
		if(limit){while(opt<lowerBound||opt>upperBound ){
			System.out.println("There should not be integers ungiven or spaces.");
			opt=in.nextInt();
			in.nextLine();
		}}
		break;
		}catch(InputMismatchException e){
			String c = in.next();
			in.nextLine();
			if(c.equals("Q")
			||c.equals("R")
			||c.equals("H")
			||c.equals("SAVE")
			||c.equals("LOAD")){
				
				switch(c){				
			case "Q": exiting();break;
			case "R": restart();break;
			case "H": new Help(0).manual();break;
			case "SAVE": save();break;
			case "LOAD": load();break;
			}
				System.out.println(question);
		}else{
		System.out.println("Try again please, only integers.");}
			
		}}
	return opt;
}

void aDayPassed(){
	
}

/**
 * This method defines shortcut keys of different options.
 * @param upperBound Upper bound of the limit.
 * @param question 
 * @param lowerBound Lower bound of the limit.
 * @return opt The shorcut keys input by players.
 */
int chooseANumber(int upperBound, String question, int lowerBound){
	int opt;
	String str;
	System.out.println(question);
	while(true){try{		
		opt = in.nextInt();
		in.nextLine();
		if(limit){
			while(opt<lowerBound||opt>upperBound ){
			System.out.println("There should not be integers ungiven or spaces.");
			opt=in.nextInt();
			in.nextLine();
		}}
		break;
		}catch(InputMismatchException e){
			String c = in.next();
			in.nextLine();
			if(c.equals("Q")
			||c.equals("R")
			||c.equals("H")
			||c.equals("SAVE")
			||c.equals("LOAD")){
				
				switch(c){				
			case "Q": exiting();break;
			case "R": restart();break;
			case "H": new Help(0).manual();break;
			case "SAVE": save();break;
			case "LOAD": load();break;
			}
				System.out.println(question);
		}else{
		System.out.println("Try again please, only integers.");}
			
		}}
	return opt;
}
	public static void updateGamesPlayed() {
	    noGamesPlayed ++;
	}
	public void start(){
		introduction();
		if(loaded){
				switch(stage){
				case 1:break;
				case 2:this.initPlayers();
				loaded=false;
				case 3:this.pickPets();
				loaded=false;
				case 4:
					progress();
					loaded=false;
					break;
				}
			}else{
			initPlayers();
			pickPets();
			initPlaces();
			progress();
		}		
	}
	
	public static void main(String fafdg[]){
		System.setProperty("sun.io.serialization.extendedDebugInfo", "true");
		new VirtualPet().start();
	}
}
