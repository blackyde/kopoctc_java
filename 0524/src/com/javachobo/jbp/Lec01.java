package com.javachobo.jbp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @FileName : Lec01.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 실제 파일에 응용
 */
public class Lec01 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("c:\\Study\\File\\전국무료와이파이표준데이터.csv");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		if((readtxt = br.readLine()) == null) {
			//파일에 내용이 있는지 파악
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		String[] field_name = readtxt.split(",");
		//파일을 읽고 쉼표로 잘라서 배열에 저장. 제목부분
		//현재는 0행(첫번째줄)이 readLine으로 읽혀져 있다. if문에서 한번 사용
		int lineCnt = 0;
		while((readtxt = br.readLine()) != null) {
			//readLine 이 또 실행되면서 1행(두번째줄)이 읽히고 다음행이 없을때까지 루프
			String[] field = readtxt.split(",");
			//내용부분을 읽어들여 쉼표로 잘라서 배열에 저장
			System.out.printf("**[%3d번째 항목]***************\n", lineCnt);
			for (int j = 0; j < field_name.length; j++) {
				if (j == 0) {
					String substringTxt = field_name[j].substring(1);
					//첫번째 행 첫번째 문자 앞에 UTF-8 BOM문자가 붙어있다. 제거해 준다.
					System.out.printf(" %s : %s\n", substringTxt, field[j]);
				} else {
					System.out.printf(" %s : %s\n", field_name[j], field[j]);
				}
			}
			System.out.printf("*******************************\n");
			if(lineCnt == 100) break;
			//100행째를 출력하고 나면 break
			lineCnt++;
		}		
		br.close();
	}
}