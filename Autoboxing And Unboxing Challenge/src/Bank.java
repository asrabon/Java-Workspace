import java.util.ArrayList;

public class Bank {
	
	private ArrayList<Branch> bankBranches;
	private String bankName;
	
	public Bank(String name) {
		bankName = name;
		bankBranches = new ArrayList<Branch>();
	}
	
	public void addBranch(String name) {
		bankBranches.add(new Branch(name));
	}
	
	public void addCustomer(String bankName, String customerName, double initialTransaction) {
		int bankIndex = findBank(bankName);
		bankBranches.get(bankIndex).addCustomer(customerName, initialTransaction);
	}
	
	public void addTransaction(String bankName, String customerName, double transaction) {
		int bankIndex = findBank(bankName);
		bankBranches.get(bankIndex).addTransaction(customerName, transaction);
	}
	
	public String toString() {
		String s = bankName + "\n";
		for(Branch b: bankBranches) {
			s = b.toString();
		}
		s = s + "\n";
		return s;
	}
	
	private int findBank(String bankName) {
		int bankIndex = -1;
		boolean bankFound = false;
		int i = 0;
		while(!bankFound && i < bankBranches.size()) {
			Branch currentBranch = bankBranches.get(i);
			if(currentBranch.getName() == bankName) {
				bankFound = true;
				bankIndex = i;
			}
			i++;
		}
		return bankIndex;
	}

}
