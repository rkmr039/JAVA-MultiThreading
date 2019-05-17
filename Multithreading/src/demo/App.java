package demo;

class Runner extends Thread {
	
	@Override
	public void run()
	{
		for(int i=0; i<10; i++) {
			System.out.println("T1 : "+i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
public class App {
	
	public static void main(String []args)
	{
	Runner runner1 = new Runner();
	runner1.start();
	
	Runner runner2 = new Runner();
	runner2.start();
	}
}
