import java.util.Deque;

public class Customer extends Thread{
	private final BankQueue customers;
	private String customer_type;
	private int i,M;
	private int Num = 0;
	
	Customer(BankQueue customers,String customer_type, int i, int M){
		this.customers = customers;
		this.customer_type = customer_type;
		this.i = i;
		this.M = M;
	}
	

	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		
		try {
			customers.blockingPut(i, customer_type);
			if(customer_type.equals("V") || customer_type.equals("v")) {
				System.out.println("Customer "+i + " is getting added to the queue, there is 0 Customers before him. He is a VIP customer.");
			}
			else { 
				System.out.println("Customer "+i + " is getting added to the queue, there is "+ i+" Customers before him. He is a regular customer.");
			}
		}
		catch(Exception exp) {
			Thread.currentThread().interrupt();
		}
	}
}
