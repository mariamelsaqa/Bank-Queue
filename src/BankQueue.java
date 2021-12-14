import java.security.SecureRandom;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

import javax.swing.Spring;

public class BankQueue {
	private final BlockingDeque <Integer> customers;
	private SecureRandom random = new SecureRandom();
	
	public BankQueue() {
		customers = new LinkedBlockingDeque<Integer>();
	}
	
	public void blockingPut(int value, String flag) throws InterruptedException {
		if(flag.equals("V") || flag.equals("v")) 
			customers.addFirst(value);
		else if(flag.equals("R") || flag.equals("r")) 
			customers.addLast(value);
		Thread.sleep(random.nextInt(3000));
	}
	
	public int blockingGet() throws InterruptedException {
		int readValue = customers.take();
		return readValue;	
	}

	
}
