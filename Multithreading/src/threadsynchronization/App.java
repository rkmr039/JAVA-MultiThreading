package threadsynchronization;

// use of volatile keyword


import java.util.Scanner;

class Processor extends Thread
{
	private volatile boolean running = true;
	@Override
	public void run()
	{
		while(running)
		{
			System.out.println("Hello");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void shutdown()
	{
		running = false;
	}
}
public class App {

	public static void main(String[] args) {

		Processor proc1 = new Processor();
		proc1.start();
		
		System.out.println("Press Return to stop........");
		Scanner sc = new Scanner(System.in);
		sc.nextLine();
		
		proc1.shutdown();
		sc.close();
	}

}
