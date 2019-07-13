package item;

import java.io.Serializable;

public class RandItem implements Serializable{
	private Object thing;
	private int prob=0;
	public RandItem(Object thing, int prob){
		this.thing=thing;
		this.prob=prob;
	}
	public RandItem(int thing, int prob){
		this.thing=thing;
		this.prob=prob;
	}
	
	public RandItem(String thing, int prob){
		this.thing=thing;
		this.prob=prob;
	}
	
	public int getProb(){
		return this.prob;
	}
	public int getInt(){
		return (int) thing;
	}
	public Object getThing(){
		return thing;
	}
	public void printOut(){
		System.out.println(thing+" " + prob);
	}
	public static void main(String arfre[]){
		RandItem r = new RandItem(9, 10);
		r.printOut();
		System.out.println(r.getProb());
	}
}
