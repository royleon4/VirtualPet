package item;

public class Chocolate extends Food {
	public Chocolate(){
		String[] names = new String[] {
				"Kit kat",
				"Oreo",
				"Mars",
				"Cadbury",
				"Toblerone"};
		this.name=names[rand.nextInt(names.length)];
		this.price=40;
		this.nutrition=15;
		this.life=6;
		this.tastiness=6;
		this.size = 1;
		this.type = "Chocolate";
	}

}
