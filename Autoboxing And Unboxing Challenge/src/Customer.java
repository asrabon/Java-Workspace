import java.util.ArrayList;

public class Customer {
	
	private ArrayList<Double> customerTransactions;
	private String customerName;
	
	public Customer(String name, double initialTransaction) {
		customerName = name;
		customerTransactions.add(initialTransaction);
	}
	
	public void addTransaction(double transactionAmount) {
		customerTransactions.add(transactionAmount);
	}
	
	public String getName() {
		return customerName;
	}
	
	public String toString() {
		String s = customerName + "\n";
		for(Double transaction: customerTransactions) {
			s = s + "Transaction:\t" + transaction + "\n";
		}
		return s;
	}

}
