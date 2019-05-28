package ReentrantLocks;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Runner {
	/*
	 * The ReentrantLock class implements the Lock interface and provides synchronization to methods 
	 * while accessing shared resources. The code which manipulates the shared resource is surrounded
	 * by calls to lock and unlock method. This gives a lock to the current working thread and blocks 
	 * all other threads which are trying to take a lock on the shared resource.
	 */
	

	private int count = 0;
	private Lock lock = new ReentrantLock();
	private Condition cond = lock.newCondition();
	
	/*
	 * A java.util.concurrent.locks.Condition interface provides a thread ability to suspend its execution,
	 * until the given condition is true. 
	 * A Condition object is necessarily bound to a Lock and to be obtained using the newCondition() method.
	 */
	private void increment() {
		for(int i=0; i<10000; i++) {
			count++;
		}
	}
	public void firstThread() throws InterruptedException{
		lock.lock();
		System.out.println("Waiting....");
		cond.await();
		
		System.out.println("Woken up....");
		
		try {
			increment();
		}finally{
			lock.unlock();	
		}
		
	}
	public void secondThread() throws InterruptedException{
		
		Thread.sleep(1000);
		lock.lock();
		
		System.out.println("Press the Return key....");
		new Scanner(System.in).nextLine();
		System.out.println("Got Return Key.....");
		cond.signal();
		
		try {
			increment();
		}finally{
			lock.unlock();	
		}
	}
	public void finished() {
		System.out.println("Count is : "+ count);
	}
}
