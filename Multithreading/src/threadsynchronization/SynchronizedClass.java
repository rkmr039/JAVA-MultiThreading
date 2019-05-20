package threadsynchronization;

public class SynchronizedClass {
	
	private int count = 0;
	
	// synchronized will create a monitor or mutex for count variable
	public synchronized void increment() {
		count++;
	}
	public static void main(String []args) 
	{
		SynchronizedClass obj = new SynchronizedClass();
		obj.doWork();
	}
	
	public void doWork()  {
		
		Thread t1 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0; i<10000; i++)
					increment();
			}
			
		});
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {
				for(int i=0; i<10000; i++)
					increment();
			}
			
		});
		t1.start();
		t2.start();
		try {
			t1.join();System.out.println("1. isAlive t1 Thread : "+t1.isAlive());
			t2.join();System.out.println("2. isAlive t2 Thread : "+t2.isAlive());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		System.out.println("Count : " + count); 
	}

}
