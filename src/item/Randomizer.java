package item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Randomizer implements Serializable{
	RandItem[] itemsWithProb;
	Random rand	 = new Random();
	int totalSum = 0;
	public Randomizer(RandItem[] items){
//		itemsWithProb = new RandItem[] items;
		itemsWithProb= items;
		for(RandItem item :items){
//			System.out.println(item.getProb());
			totalSum+=item.getProb();
		}
	}
	
	public RandItem getAItem(){
		int index = rand.nextInt(totalSum);
        int sum = 0;
        int i=0;
        while(sum < index ) {
             sum = sum + this.itemsWithProb[i++].getProb();
        }
        return itemsWithProb[Math.max(0,i-1)];
    }

}
