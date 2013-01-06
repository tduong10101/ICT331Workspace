public abstract class Customer  {
	private String name;
	private String address;
	private String city;
	private String state;
	
	protected Customer(String name, String address, String city, String state) throws IllegalArgumentException{
		
			this.name = name;
			String stringException = "must contain more than zero character!";
			this.address = address;
			this.city = city;
			this.state = state;
			if (name.equals("")){
				throw new IllegalArgumentException ("Customer name "+stringException);
			} else if (address.equals("")){
				throw new IllegalArgumentException ("Customer address "+stringException);
			}else if (city.equals("")){
				throw new IllegalArgumentException ("Customer city "+stringException);
			} else if (state.equals("")){
				throw new IllegalArgumentException ("Customer state "+stringException);
			}
	}

	public String getAddress() {
		return address;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	protected Customer (){
		
	}
	public int compareTo(Object o){
		int result = 0;
		int resultAddress = 0;

		if (this.name.compareTo(((Customer)o).name)<0){
			result = 1;
		}
		else if (this.name.compareTo(((Customer)o).name)==0){
			result = 0;
		}
		else if (this.name.compareTo(((Customer)o).name)>0){
			result = 2;
		}
		
		if (this.name.compareTo(((Customer)o).address)<0){
			resultAddress = 10;
		}
		else if (this.address.compareTo(((Customer)o).address)== 0){
			resultAddress = 0;
		}
		else if (this.address.compareTo(((Customer)o).address)>0){
			resultAddress = 20;
		}
		return result+resultAddress;
		
	}
	public String getName() {
		return name;
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
		return "Customer" + "|" + name + "|" + address + "|"+ city + "|" + state;
	}
}