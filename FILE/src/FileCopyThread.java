import java.io.*;

public class FileCopyThread extends Thread {
	
	Thread t;
	
	FileCopyThread() {
		t = new Thread(this);
		t.start();
	}
	
	public void run() {
		
		InputStream in = null;
		OutputStream out = null;
		
		try {
			in = new FileInputStream("c:\\study\\file\\Clipart.cab");
			
			out = new FileOutputStream("c:\\study\\file\\copy.cab");  //저장 위치 C:\Study\JAVA\FILE = workspace 밑에 클래스 밑.
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		while(true) {
			int data = 0;
			try {
				data = in.read();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if(data == -1) {
				break;
			}
			
			try {
				out.write(data);
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
		
	}
	
}
