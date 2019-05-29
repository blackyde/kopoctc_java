package com.javachobo.jbp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @FileName : Lec08.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 감 잡은 내용으로 파일정제 git 에 올리기
 */
public class Lec08 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("c:\\Study\\File\\THTSKS010H00.dat");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		//File f1 = new File("c:\\Study\\File\\StockDailyPrice.csv");
		//File f1 = new File("c:\\Study\\File\\A005930.csv");
		//File f1 = new File("c:\\Study\\File\\20150112.csv");
		File f1 = new File("c:\\Study\\File\\20150112A005930.csv");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		
		String readtxt;
		
		int cnt = 0; int wcnt = 0;
		while((readtxt = br.readLine()) != null) {
			StringBuffer s = new StringBuffer();
			String[] field = readtxt.split("%_%");
			
//			if(field.length > 2 &&
//					field[2].replace("^", "").trim().substring(0, 1).equals("A")) {
			if(field.length > 2 &&
					field[1].replace("^", "").trim().substring(0,4).equals("2015") &&
					field[2].replace("^", "").trim().equals("A005930")) {
				s.append(field[0].replace("^", "").trim());
				for (int j = 1; j < field.length; j++) {
					s.append("," + field[j].replace("^", "").trim());
				}
				
				bw1.write(s.toString()); bw1.newLine();
				wcnt++;
				//System.out.printf("write [%d][%d][%s]\n", cnt, wcnt, s.toString());
			}
			
			cnt++;
//			if (cnt > 1000) {
//				break;
//			}
		}
		
		br.close();
		bw1.close();
		
		System.out.printf("Program End[%d][%d]records\n", cnt, wcnt);
	}

}
