import java.io.*;

public class FileCopyBetterThread extends Thread {
	
	Thread t;
	
	FileCopyBetterThread() {
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		
		long start = System.currentTimeMillis();
		
		InputStream in = null;
		OutputStream out = null;
		
		byte[] buffer = new byte[8192 * 16]; //buffer 단위의 바가지를 만들자
		
		try {
			in = new FileInputStream("c:\\study\\file\\Clipart.cab");
			
			out = new FileOutputStream("c:\\study\\file\\copy_new.cab");  //저장 위치 C:\Study\JAVA\FILE = workspace 밑에 클래스 밑.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			int data = 0;
			try {
				data = in.read(buffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(data == -1) {
				break;
			}
			
			try {
				out.write(buffer, 0, data);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			in.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long end = System.currentTimeMillis();
		
		System.out.println("Thread : " + (end - start));
		
	}
	
}
