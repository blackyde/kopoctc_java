
public class ProcessOne extends Thread {
	
	Thread t;
	
	ProcessOne() {
		t = new Thread(this);
		t.start();
	}
	
	public void run() { //run() 메서드는 필수. 이름을 바꿀 수 없다
		for(int i = 0; i < 100; i++) {
			System.out.println("One : " + i);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
