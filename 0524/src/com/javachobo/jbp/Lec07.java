package com.javachobo.jbp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @FileName : Lec07.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 파일 훓어보고 감잡기
 */
public class Lec07 {
	public static void main(String[] args) throws IOException {
		
		File f = new File("c:\\Study\\File\\THTSKS010H00.fmt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		@SuppressWarnings("unused")
		String readtxt;
		int lineCnt = 0;
		int n = -1;
		StringBuffer s = new StringBuffer();
		
		while(true) {
			
			char[] ch = new char[1000];
			n = br.read(ch);
			
			if(n == -1) break;
			
			for(char c : ch) {
				if(c == '\n') {
					System.out.printf("[%s]***\n", s.toString());
					s.delete(0,  s.length());
				} else {
					s.append(c);
				}
			}
			
			lineCnt++;
			if(lineCnt >= 1000) break;
		}
		System.out.printf("[%s]***\n", s.toString());
		br.close();
	}
}
