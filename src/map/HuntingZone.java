package map;

import game.Tools;

public class HuntingZone extends Place{
	public HuntingZone(){
		this.name = "Hunting Zone";
		
	}
	public void welcome(int width){
		System.out.println(new Tools().centreString("--Welcome to Hunting Zone--",width));
		System.out.println(new Tools().centreString("You may hunt at most three animals once!",width));
		

}

}