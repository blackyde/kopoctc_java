import java.io.*;

public class FileCopyBetter {

	public static void main(String[] args) throws Exception {
		
		InputStream in = new FileInputStream("c:\\study\\file\\Clipart.cab");

		OutputStream out = new FileOutputStream("c:\\study\\file\\copy_new.cab");
		
		byte[] buffer = new byte[1024 * 8]; //buffer 단위의 바가지를 만들자
		
		long start = System.currentTimeMillis();
		
		while(true) {
			int count = in.read(buffer);
			
			if(count == -1) {
				break;
			}
			
			out.write(buffer, 0, count);
		}
		
		new FileCopyBetterThread();
		
		long end = System.currentTimeMillis();
		
		System.out.println(end - start);
		
		in.close();
		out.close();
	}

}
