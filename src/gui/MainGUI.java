package gui;

import java.util.*;

import game.*;

public class MainGUI {
	ArrayList<Player> players = new ArrayList<Player>();
	void start(){
		InitPlayers initPlayers = new InitPlayers();
		initPlayers.start();
		players = initPlayers.getPlayers();

	}
	public static void main(String arg[]){
		new MainGUI().start();
		
	}

}
