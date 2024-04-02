/*
3. Write a Generic method that computes the Second minimum and Second maximum elements
of an array of type T and returns a pair containing the minimum and maximum value.
*/

package array;
import java.util.*;
//class Pair<T> {  
//    T smaximum, sminimum;  
//    public Pair(T smaximum, T sminimum) { 
//        this.smaximum = smaximum;  
//        this.sminimum = sminimum;  
//    }  
//} 

// Optimal approach
/*
class SecondMinMax {
	
	Pair getMinMax(int arr[], int n) {
		int maximum = arr[0];
		int smaximum = Integer.MIN_VALUE;
		for(int i=1;i<n;i++) {
			if(arr[i] > maximum) {
				smaximum = maximum;
				maximum = arr[i];
			}
			else if(arr[i] < maximum && arr[i] > smaximum) {
				smaximum = arr[i];
			}
		}
		
		int minimum = arr[0];
		int sminimum = Integer.MAX_VALUE;
		for(int i=1;i<n;i++) {
			if(arr[i] < minimum) {
				sminimum = minimum;
				minimum = arr[i];
			}
			else if(arr[i] != minimum && arr[i] < sminimum) {
				sminimum = arr[i];
			}
		}
		
		return new Pair(smaximum, sminimum);
	}
	
}
*/

class SecondMinMax<T extends Comparable<T>>{
	T getSecondMax(T arr[]) {
		T ma=arr[0];
		T mi=arr[0];
		for(int i=1;i<arr.length;i++) {
			if(ma.compareTo(arr[i])<0) {
				ma=arr[i];
			}
			if(ma.compareTo(arr[i])>0) {
				mi=arr[i];
			}
		}
//		System.out.println(ma + " " +  mi);
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != ma && arr[i].compareTo(mi)> 0) {
				mi=arr[i];
			}
		}
		
		return mi;
	}
	
	T getSecondMin(T arr[]) {
		T ma=arr[0];
		T mi=arr[0];
		for(int i=0;i<arr.length;i++) {
			if(ma.compareTo(arr[i])<0) {
				ma=arr[i];
			}
			if(mi.compareTo(arr[i])>0) {
				mi=arr[i];
			}
		}
//		System.out.println(ma + " " +  mi);
		for(int i=0;i<arr.length;i++) {
			if(arr[i] != mi && arr[i].compareTo(ma)<0) {
				ma=arr[i];
			}
		}
		
		return ma;
	}
}


public class Question3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer arr[] = {1, 2, 4, 7, 7, 5, 1};
		SecondMinMax<Integer> obj = new SecondMinMax();
		System.out.println("The second maximum and second minimum elements are: ");
		System.out.println(obj.getSecondMax(arr) + ", " + obj.getSecondMin(arr));
		
		SecondMinMax <Double> obj1 = new SecondMinMax<Double>();
		Double arr1[] = {1.2, 3.6, 0.5, 2.7, 4.5, 5.9};
		System.out.println("The second maximum and second minimum elements are: ");
		System.out.println(obj1.getSecondMax(arr1) + ", " + obj1.getSecondMin(arr1));
	}

}

/*
Output:

The second maximum and second minimum elements are: 
5, 2
The second maximum and second minimum elements are: 
4.5, 1.2
*/

