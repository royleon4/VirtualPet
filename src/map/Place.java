package map;

import java.io.Serializable;

public abstract class Place implements Serializable{
	protected boolean isOpen=true;
	protected String name;
	public void close(){
		this.isOpen=false;
	}
	public void open(){
		this.isOpen=true;
	}
	
	public String getName(){
		
		return name;
		
	}
	
}
