public abstract class Customer{
	private String name;
	private String address;
	private String city;
	private String state;
	
	protected Customer(String name, String address, String city, String state) {
		
		this.name = name;
		this.address = address;
		this.city = city;
		this.state = state;
	}

	protected Customer (){
		
	}
	public int compareTo(Object o){
		int result = 0;
		int resultAddress = 0;

		if (this.name.compareTo(((Customer)o).name)<0){
			result = -1;
		}
		else if (this.name.compareTo(((Customer)o).name)==0){
			result = 0;
		}
		else if (this.name.compareTo(((Customer)o).name)>0){
			result = 1;
		}
		
		if (this.name.compareTo(((Customer)o).address)<0){
			resultAddress = -3;
		}
		else if (this.address.compareTo(((Customer)o).address)== 0){
			resultAddress = 0;
		}
		else if (this.address.compareTo(((Customer)o).address)>0){
			resultAddress = 3;
		}
		return result+resultAddress;
		
	}
	public boolean equals(Object o){
		boolean result = true;
		if (this.name.equals(((Customer)o).name)){
			result = true;
		}
		else if (!(this.name.equals(((Customer)o).name))){
			result = false;
		}
		return result;
	}
	public String toString() {
		return "Customer: " + name + " Address: " + address + " City: "+ city + " State: " + state;
	}
}