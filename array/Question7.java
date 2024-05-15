/*
7. Create a program with multi-dimensional List to store customer details (customerId,
customerName, customerCity).
This program to search the customer based on the customerName from a given array.
Note: use Binary search and Insertion sort algorithm.
 Create a constructor to initialize size of customer details for five customers.
 Create customer method which takes the array of customer elements (sorted as a
customerName).
 Create a method to getCustomer(customerId) method which will return the customer
details as a List.
 Create a method to sortCustomer() method which will return the array in a sorted
order based on customer city.
*/


package array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Customer {
    int customerId;
    String customerName;
    String customerCity;

    public Customer(int id, String name, String city) {
        this.customerId = id;
        this.customerName = name;
        this.customerCity = city;
    }
}

public class Question7 {
    static List<Customer> customerList;

    public Question7(int size) {
        customerList = new ArrayList<>(size);
    }

    public void addCustomer(int id, String name, String city) {
        customerList.add(new Customer(id, name, city));
    }

    public List<Customer> getCustomer(String name) {
        int index = binarySearchCustomer(name);
        if (index != -1) {
            List<Customer> result = new ArrayList<>();
            result.add(customerList.get(index));
            return result;
        }
        return null;
    }

    private int binarySearchCustomer(String name) {
        int left = 0;
        int right = customerList.size() - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (customerList.get(mid).customerName.equals(name)) {
                return mid;
            } else if (customerList.get(mid).customerName.compareTo(name) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public void sortCustomersByName() {
        Collections.sort(customerList, Comparator.comparing(customer -> customer.customerName));
    }

    public static void main(String[] args) {
    	Question7 customerDetails = new Question7(5);
        customerDetails.addCustomer(1, "Alice", "New York");
        customerDetails.addCustomer(2, "David", "Los Angeles");
        customerDetails.addCustomer(3, "Charlie", "Chicago");
        customerDetails.addCustomer(4, "Bob", "Houston");
        customerDetails.addCustomer(5, "Emily", "San Francisco");

        // Sort customers by name
        customerDetails.sortCustomersByName();
        
        for(Customer customer: customerList)
        	System.out.println("ID: " + customer.customerId + ", Name: " + customer.customerName + ", City: " + customer.customerCity);

        // Get customer details by name
        String searchName = "Bob";
        List<Customer> result = customerDetails.getCustomer(searchName);
        if (result != null) {
            System.out.println("Customer found:");
            for (Customer customer : result) {
                System.out.println("ID: " + customer.customerId + ", Name: " + customer.customerName + ", City: " + customer.customerCity);
            }
        } else {
            System.out.println("Customer not found.");
        }
    }
}
