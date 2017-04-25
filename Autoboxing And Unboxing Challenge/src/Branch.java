import java.util.ArrayList;

public class Branch {
	
	private ArrayList<Customer> branchCustomers;
	private String branchName;
	
	public Branch(String name) {
		branchName = name;
		branchCustomers = new ArrayList<Customer>();
	}
	
	public void addCustomer(String s, double initialTransaction) {
		branchCustomers.add(new Customer(s, initialTransaction));
	}
	
	public void addTransaction(String name, double transactionAmount) {
		int customerIndex = findCustomer(name);
		branchCustomers.get(customerIndex).addTransaction(transactionAmount);
	}
	
	public String toString() {
		String s = branchName + "\n";
		for(Customer c: branchCustomers) {
			s = s + c.toString();
		}
		s = s + "\n";
		return s;
	}

	private int findCustomer(String name) {
		int customerIndex = -1;
		boolean customerFound = false;
		int i = 0;
		while(!customerFound && i < branchCustomers.size()) {
			Customer currentCustomer = branchCustomers.get(i);
			if(currentCustomer.getName() == name) {
				customerFound = true;
				customerIndex = i;
			}
			i++;
		}
		return customerIndex;
	}
	
	public String getName() {
		return branchName;
	}

}
