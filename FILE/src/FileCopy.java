import java.io.*;

/**
 * 파일을 복사하는 프로그램
 */

public class FileCopy {

	public static void main(String[] args) throws Exception {
		
		InputStream in = new FileInputStream("c:\\study\\file\\snorlax.jpg");
		
		OutputStream out = new FileOutputStream("c:\\study\\file\\copy.jpg");  //저장 위치 C:\Study\JAVA\FILE = workspace 밑에 클래스 밑.
		
		long start = System.currentTimeMillis();
		
		while(true) {
			int data = in.read();
			
			if(data == -1) {
				break;
			}
			
			out.write(data);
		}
		
		new FileCopyThread();
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
		in.close();
		out.close();
		
	}
	
}
