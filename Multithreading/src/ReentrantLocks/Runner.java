package ReentrantLocks;

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
	private void increment() {
		for(int i=0; i<10000; i++) {
			count++;
		}
	}
	public void firstThread() throws InterruptedException{
		lock.lock();
		increment();
		lock.unlock();
	}
	public void secondThread() throws InterruptedException{
		lock.lock();
		increment();
		lock.unlock();
	}
	public void finished() {
		System.out.println("Count is : "+ count);
	}
}
