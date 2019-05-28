package ProducerConsumer;

import java.util.Scanner;

/*
 * Solving Producer Consumer Problem Using Thread Level Synchronization
 */

public class Processor {
	
	public void produce() throws InterruptedException{
		synchronized (this) {
			System.out.println("Producer thread running.....");
			wait(); 
			/*
			 * The java.lang.Object.wait() causes current thread to wait until another thread invokes the
			 * notify() method or the notifyAll() method for this object.
			 * */
			System.out.println("Resumed...");
		}
	} 
	public void consume() throws InterruptedException{
		
	Scanner sc = new Scanner(System.in);
	Thread.sleep(2000);
		synchronized (this) {
			System.out.println("Waiting for Return key.....");
			sc.nextLine();
			System.out.println("Return key pressed... ");
			notify();			
		}
	}

}
