package semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class App {
	
	public static void main(String args[]) throws Exception{
		/*
		* Semaphore is a simple integer variable that apart from initialization can be accessed through 
		* two standard methods wait() and signal()
		* used in mutual exclusive manner by various concurrent cooperative process
		* in order to achieve synchronization
		* it is used to prevent raise condition
		* counting semaphore can be used when 
		* we need to have more than one process in the critical section at the same time.
		 *
		 * acquire(): When a thread needs to access a resource, it acquires the permit from the Semaphore using acquire() method. 
		 * If the permit is not available, it holds until one is available. 
		 * release(): Once the thread is finished using resource, it needs to return the permit. 
		 * Using release() method of Semaphore, thread releases the permit back to Semaphore. 
		 */
		Semaphore sem = new Semaphore(1);
		
		//sem.release(); // method to increment number of permits
		//sem.acquire(); // method to decrement number of permits
		
		
		ExecutorService executor = Executors.newCachedThreadPool();
		
		for(int i=0;i<200;i++) {
			executor.submit(new Runnable() {
				
				@Override
				public void run() {
					Connection.getInstance().connect();
					
				}
			});
		}  executor.isShutdown();
		
		executor.awaitTermination(1, TimeUnit.DAYS );
		
	}

}
