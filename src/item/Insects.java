package item;

public class Insects extends Food {

	public Insects(){
		String[] names = new String[] {
				"Butterfly",
				"Earthworm",
				"Ladybug",
				"Mantis"};
		this.name = names[rand.nextInt(names.length)];
		this.size=1;
		this.nutrition=10;
		this.life=2;
		this.type="Insect";
		this.tastiness = 6;
		this.price = 100;
	}

}
