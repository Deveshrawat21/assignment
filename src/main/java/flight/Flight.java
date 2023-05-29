package flight;

public class Flight implements Comparable<Flight> {

	public String name;
	public String price;
	
	public Flight(String n, String p)
	{
		name=n;
		price=p;
	}

	@Override
	public int compareTo(Flight o) {
		
	return price.compareTo(o.price);
		
	}

	public String getName() {
		return name;
	}

	public String getPrice() {
		return price;
	}


	
	
	
	
}
