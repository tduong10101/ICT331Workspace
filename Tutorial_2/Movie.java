package Tutorial_2;

public class Movie{
	private int id;
	private int price;
	protected Movie (){
		this.id = 0;
		this.price = 70;
	}
	protected Movie (int id, int price){
		this.id = id;
		this.price = price;
	}
	public double getCost (){
		return this.price;
	}

}
