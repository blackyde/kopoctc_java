package jbp;

import java.io.UnsupportedEncodingException;

public class Test {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		System.out.println("한우등심1등급100g".getBytes("EUC-KR").length);
		System.out.println("씨없는수박8kg".getBytes().length);
		
		String msg = "무농약발아현미3k";
		int 자르고싶은크기 = 20;
		byte[] bytes = msg.getBytes();
		if(bytes.length > 자르고싶은크기 ) {    
		  msg = new String(bytes, 0, 자르고싶은크기 );
		}
		System.out.println(msg);
		
		System.out.println(220 / (1.0 + 10/100.0));
		
		System.out.println(220 / 110.0 * 100);
		
		System.out.println(220 / 1.1f);


	}

}
