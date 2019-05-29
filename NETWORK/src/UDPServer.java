import java.net.*;

public class UDPServer { //

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		
		String rs1, rs2;
		
		try {
			DatagramSocket ds = new DatagramSocket(9999);
			
			
			while(true) {
			
				try {
					rs1 = "";
					rs2 = "";
					byte[] bf = new byte[30]; 
					DatagramPacket dp = new DatagramPacket(bf, bf.length); 
					ds.receive(dp);
					rs1 = new String(dp.getData());
					rs2 = new String(rs1.trim());
					rs2 = new String(rs2.getBytes("UTF-8"), "UTF-8");
					System.out.println("Address:" + dp.getAddress() + "  port : " + dp.getPort());
					System.out.println("(Client->Server): " + rs2); 
					
				} catch(Exception e) {
					e.printStackTrace();
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
