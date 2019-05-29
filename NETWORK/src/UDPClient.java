import java.net.*;
import java.util.Scanner;
public class UDPClient {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		while(true) {
			try {
				DatagramSocket ds = new DatagramSocket();
				InetAddress ia = InetAddress.getByName("192.168.23.99");
				System.out.print("할말 : ");
				String sendMSG = in.nextLine();
				sendMSG = new String(sendMSG.getBytes("UTF-8"), "UTF-8");
				byte[] bf = sendMSG.getBytes();

				DatagramPacket dp = new DatagramPacket(bf, bf.length, ia, 9999);
				ds.send(dp);
				
				if(sendMSG.equals("exit")) {
					break;
				}
		         
			} catch(Exception e){ 
				System.out.println(e);
			}
		}
		
		in.close();
		
	}
} 