package item;

import java.io.Serializable;



public interface Item extends Serializable{
	public int getSize();
	public int getPrice();
	public void setPrice(int price);
	public void priceMultiplier(int mult);
	public void priceMultiplier(double mult);
	public String getName();
	public boolean expired();
	public void discount(double off);
	public String toString();
	public boolean isOnSale();
	public double getDiscount();
	public String introduction();
	public String showPrice();
	public boolean sameAs(Item item);
	public String betterIntro(int width);
	
}
