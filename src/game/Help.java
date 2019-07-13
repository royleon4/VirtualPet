package game;

import java.io.Serializable;
import java.util.Scanner;

public class Help extends VirtualPet implements Serializable{
	private int number; 
	public Help(int num) {
		this.number=num;
	}
	public void manual(){
		System.out.println();
		System.out.println("**********************MANUAL OF VIRTUAL PET GAME**********************");
		System.out.println("               Made by Lu-Yunng Huang, and Don-Lin Yu.                ");
		System.out.println("**********************************************************************");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("*                                                                    *");
		System.out.println("**********************************************************************");
		
		askToQuit();
	}
	public void askToQuit(){
//		Scanner in=new Scanner(System.in);
		String input = this.askQuestion("0:go back");
		while(!input.equalsIgnoreCase("0")){
			input = this.askQuestion("No such command.");

		}

	}
	
	
	public static void main(String arg[]){
		Help h=new Help(0);
		h.manual();
	}
	
	

}
