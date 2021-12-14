import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
public class main{

	static int N,M;
	static BlockingDeque <Integer> customers = new LinkedBlockingDeque<Integer>();
	static Scanner S = new Scanner(System.in);
	static ArrayList<String> customerType = new ArrayList<String>(M);
	
	public static void TakeInputs() throws InterruptedException{
		System.out.println("How many tellers?");

		N = S.nextInt();
		System.out.println("How many customers?");
		M = S.nextInt();
		
	}
	
	public static String CustomerArrived(int i) {
		String customer_type = null;
			System.out.println("Customer " + i +", Are you a VIP(V/v) or Regular(R/r)customer?");
			customer_type = S.next();
			while(!customer_type.equals("V") && !customer_type.equals("v") && !customer_type.equals("R") && !customer_type.equals("r")) {
				System.out.println("Please enter a valid input. V/v or R/r");
				customer_type = S.next();
			}
		return customer_type;
	}
		
	
	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		TakeInputs();
		
		ExecutorService executorService = Executors.newCachedThreadPool();
		
		BankQueue customers = new BankQueue();
		
		for(int i=0; i<M; i++) {
			customerType.add(CustomerArrived(i));
			executorService.execute(new Customer(customers,customerType.get(i), i,M));
		}
		for(int i=0; i<N; i++) 
			executorService.execute(new Teller(customers,i));

		executorService.shutdown();
	}

}
