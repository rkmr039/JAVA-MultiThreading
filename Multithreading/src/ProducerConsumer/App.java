package ProducerConsumer;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class App {
	
	private static BlockingQueue<Integer> queue = new ArrayBlockingQueue<Integer>(10);
	/*
	 * BlockingQueue Interface supports flow control (in addition to queue) by introducing blocking 
	 * if either BlockingQueue is full or empty.
	 * A thread trying to enqueue an element in a full queue is blocked until some other thread
	 * makes space in the queue, either by dequeuing one or more element or clearing the queue completely. 
	 * 
	 * */
	
	public static void main(String []args) {
		
		Thread t1 = new Thread(new Runnable() {
			public void run() {
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2 = new Thread(new Runnable() {
			public void run() {
				try {
					consumer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	private static void producer() throws InterruptedException {
		Random random = new Random();
		
		while(true) {
			queue.put(random.nextInt(100));
		}
	}
	
	private static void consumer() throws InterruptedException {
		Random random = new Random();
		while(true) {
			Thread.sleep(100);
			
			if(random.nextInt(10) == 0) {
				Integer value = queue.take();
				System.out.println("Taken value : "+ value + " QueueSize is : " + queue.size());
				
			}
			
		}
	}

}
