package threadsynchronization;

class ChildThread extends Thread{
	public void run()
	{
		System.out.println("1. isAlive Child Thread : "+ isAlive());
	}
}

public class JoinChild {
	
	public static void main(String[] args) {
		
		
		ChildThread a = new ChildThread ();
		a.start();
		try {
			a.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("2. isAlive Child Thread : "+a.isAlive());		
	}

}
