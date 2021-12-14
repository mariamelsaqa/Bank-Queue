
public class Teller extends Thread{
	private final BankQueue customers;
	private int i;
	private String customer_type;
	
	Teller(BankQueue customers,int i){
		this.customers = customers;
		this.i = i;
	}
	
	
	@Override
	public synchronized void run() {
		// TODO Auto-generated method stub
		try {
			int turn = customers.blockingGet();
			System.out.println("Customer "+ turn + " turn. Served by Teller "+ i);
			Thread.sleep((long) (Math.random()*1000));
			System.out.println("Teller "+ i +" done serving customer "+ turn);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
