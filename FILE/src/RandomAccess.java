import java.io.*;

public class RandomAccess {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		try {
			
			RandomAccessFile raf;
			String readStr;
			raf = new RandomAccessFile("c:\\study\\JAVA\\NETWORK\\src\\file.txt", "rw");
			while((readStr = raf.readLine()) != null) {
				readStr = new String(readStr.getBytes("ISO-8859-1"), "EUC_KR");
				System.out.println(readStr);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
