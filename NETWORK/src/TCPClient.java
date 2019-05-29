import java.io.*;
import java.net.*;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		
		try {
			Socket s1;
			InputStream is1;
			DataInputStream is2;
			OutputStream os1;
			DataOutputStream os2;
			
			Scanner in = new Scanner(System.in);
			
			while(true) {
				System.out.print("할말 : ");
				String sendString = in.next();
				s1 = new Socket("192.168.23.98", 5432); //192.168.23.99
				is1 = s1.getInputStream();
				is2 = new DataInputStream(is1);
				String str = new String(is2.readUTF());
				System.out.println(str);
				os1 = s1.getOutputStream();
				os2 = new DataOutputStream(os1);
				os2.writeUTF("<전송 시작>" + sendString + "전송 마침");
				
				if(sendString.equals("exit")) {
					break;
				}
			}
			
			
			os2.close();
			os1.close();
			is2.close();
			is1.close();
			s1.close();
			in.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
