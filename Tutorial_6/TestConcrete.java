package Tutorial_6;

import java.util.ArrayList;

public class TestConcrete {
	public static void main(String[] args) {
		// Create a 6mx3m pool maximumDepth = 2
		Pool myPool = new Pool(6, 3, 2);
		// Create a 20mx5m house slab
		HouseSlab myHouseSlab = new HouseSlab(20, 5, 1);
		// Both object should be stored in an array
		// of ConcreateProduct object
		ArrayList<ConcreteProduct> myProducts = new ArrayList<ConcreteProduct>();
		myProducts.add(myPool);
		myProducts.add(myHouseSlab);
		// Print the volumes
		for (int i = 0; i < myProducts.size(); i++) {
			System.out.println("Concreate volume "
					+ myProducts.get(i).findVolume());
		}

	}

}
