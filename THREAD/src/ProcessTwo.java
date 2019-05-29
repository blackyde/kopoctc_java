
public class ProcessTwo extends Thread {
	
	Thread t;
	
	ProcessTwo() {
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.println("Two : " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
