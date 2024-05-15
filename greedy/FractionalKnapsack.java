package greedy;
import java.util.*;

//class Item {
//	int value, weight;
//	Item(int value, int weight) {
//		this.value = value;
//		this.weight = weight;
//	}
//}

class Item implements Comparable<Item> {

	int value, weight;
	
	Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
	
	public int compareTo(Item o) {
		// TODO Auto-generated method stub
		double a = this.value / this.weight;
		double b = o.value / o.weight;
		
		if(a < b) return 1;
		else if(a > b) return -1;
		else return 0;
	}
	
}

public class FractionalKnapsack {

	public static double fractionalKnapsack(int W, List<Item> item) {
		double maxValue = 0.0;
		int currWeight = 0;
		
		for(Item it: item) {
			if(currWeight + it.weight <= W) {
				currWeight += it.weight;
				maxValue += it.value;
			}
			else {
				int remain = W - currWeight;
				maxValue += ((double) it.value / (double) it.weight) * (double) remain;
				break;
			}
		}
		
		return maxValue;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<Item> item = new ArrayList<>();
		item.add(new Item(120, 30));
		item.add(new Item(100, 20));
		item.add(new Item(60, 10));
		
		Collections.sort(item);
		
		int W = 50;
		
		System.out.println("Maximum value after including items: " + fractionalKnapsack(W, item));
		
		List<Item> item2 = new ArrayList<>();
		item2.add(new Item(10, 2));
		item2.add(new Item(5, 3));
		item2.add(new Item(15, 5));
		item2.add(new Item(7, 7));
		item2.add(new Item(6, 1));
		item2.add(new Item(18, 4));
		item2.add(new Item(3, 1));
		
		Collections.sort(item2);
		
		int W2 = 15;
		
		System.out.println("Maximum value after including items: " + fractionalKnapsack(W2, item2));
	}

}

/*

Output:

Maximum value after including items: 240.0
Maximum value after including items: 55.333333333333336

*/