package com.javachobo.jbp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @FileName : Lec03.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 파일 분리, 데이터 보정
 */
public class Lec03 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("c:\\Study\\File\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		File f1 = new File("c:\\Study\\File\\전국무료와이파이표준데이터_SKT.txt");
		File f2 = new File("c:\\Study\\File\\전국무료와이파이표준데이터_KT.txt");
		File f3 = new File("c:\\Study\\File\\전국무료와이파이표준데이터_LGU.txt");
		BufferedWriter bw1 = new BufferedWriter(new FileWriter(f1));
		BufferedWriter bw2 = new BufferedWriter(new FileWriter(f2));
		BufferedWriter bw3 = new BufferedWriter(new FileWriter(f3));
		
		String readtxt;
		if((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다\n");
			return;
		}
		
		bw1.write(readtxt); bw1.newLine();
		bw2.write(readtxt); bw2.newLine();
		bw3.write(readtxt); bw3.newLine();
		
		int lineCnt = 0;
		while((readtxt = br.readLine()) != null) {
			
			String[] field = readtxt.split("\t");
			
			if(field[5].trim().equals("SKT")) {
				bw1.write(readtxt); bw1.newLine();
			} else if(field[5].trim().equals("SK")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll("SK", "SKT");
				bw1.write(tmp); bw1.newLine();
			} else if(field[5].trim().equals("SK텔레콤")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "SKT");
				bw1.write(tmp); bw1.newLine();
			} else if(field[5].trim().equals("\"SKT,경기도 광주시청\"")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "SKT");
				bw1.write(tmp); bw1.newLine();
			} else if(field[5].trim().equals("SKT Giga WiFi")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "SKT");
				bw1.write(tmp); bw1.newLine();
			} else if(field[5].trim().equals("skt")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "SKT");
				bw1.write(tmp); bw1.newLine();
			} else if(field[5].trim().equals("서울시(SKT)")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "SKT");
				bw1.write(tmp); bw1.newLine();
			} else if(field[5].trim().equals("KT")) {
				bw2.write(readtxt); bw2.newLine();
			} else if(field[5].trim().equals("㈜케이티")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "KT");
				bw2.write(tmp); bw2.newLine();
			} else if(field[5].trim().equals("㈜KT")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "KT");
				bw2.write(tmp); bw2.newLine();
			} else if(field[5].trim().equals("kt")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "KT");
				bw2.write(tmp); bw2.newLine();
			} else if(field[5].trim().equals("KT올레")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "KT");
				bw2.write(tmp); bw2.newLine();
			} else if(field[5].trim().equals("\"KT, 하남시\"")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "KT");
				bw2.write(tmp); bw2.newLine();
			} else if(field[5].trim().equals("미래부(KT)")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "KT");
				bw2.write(tmp); bw2.newLine();
			} else if(field[5].trim().equals("서울시(KT)")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "KT");
				bw2.write(tmp); bw2.newLine();
			} else if(field[5].trim().equals("LGU+")) {
				bw3.write(readtxt); bw3.newLine();
			} else if(field[5].trim().equals("LG")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU+");
				bw3.write(tmp); bw3.newLine();
			} else if(field[5].trim().equals("LG U+")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU");
				bw3.write(tmp); bw3.newLine();
			} else if(field[5].trim().equals("LGU")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU+");
				bw3.write(tmp); bw3.newLine();
			} else if(field[5].trim().equals("Lgu+")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU");
				bw3.write(tmp); bw3.newLine();
			} else if(field[5].trim().equals("(주)엘지유플러스")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU");
				bw3.write(tmp); bw3.newLine();
			} else if(field[5].trim().equals("LG유플러스")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU");
				bw3.write(tmp); bw3.newLine();
			} else if(field[5].trim().equals("미래부(LGU+)")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU");
				bw3.write(tmp); bw3.newLine();
			} else if(field[5].trim().equals("서울시(LGU+)")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU");
				bw3.write(tmp); bw3.newLine();
			} else if(field[5].trim().equals("LGT")) {
				String tmp = readtxt;
				tmp = tmp.replaceAll(field[5], "LGU");
				bw3.write(tmp); bw3.newLine();
			} else {
				System.out.printf("알 수 없는 통신사[%d번째 항목][%s]***\n",
						lineCnt, field[5]);
			}
			lineCnt++;
		}
		br.close();
		bw1.close();
		bw2.close();
		bw3.close();

	}

}
