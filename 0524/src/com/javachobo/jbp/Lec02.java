package com.javachobo.jbp;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * @FileName : Lec02.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 거리계산
 */
public class Lec02 {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f = new File("c:\\Study\\File\\전국무료와이파이표준데이터.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		if((readtxt = br.readLine()) == null) {
			System.out.printf("빈 파일입니다.\n");
			return;
		}
		String[] field_name = readtxt.split("\t");
		//쉼표로 구분하는 방법은 "12,23" 같은 하나의 데이터까지 분리해 버리므로 탭으로 구분한다.
		//융합기술교육원 위도 경도 37.3857959,127.12127099999998
		double lat = 37.3857959;
		double lng = 127.12127099999998;
		
		int lineCnt = 0;
		double maxDist = 1.0;
		double minDist = 1.0;
		int max = 0;
		int min = 0;
		String maxPlace = "";
		String minPlace = "";
		while((readtxt = br.readLine()) != null) {
			
			String[] field = readtxt.split("\t");
			System.out.printf("**[%d번째 항목]***************\n", lineCnt);
			System.out.printf(" %s : %s\n", field_name[9], field[9]);
			//9번 필드 : 지번 주소
			System.out.printf(" %s : %s\n", field_name[12], field[12]);
			//12번 필드 : 위도
			System.out.printf(" %s : %s\n", field_name[13], field[13]);
			//13번 필드 : 경도
			double dist = Math.sqrt(Math.pow(Double.parseDouble(field[12]) - lat, 2)
					+ Math.pow(Double.parseDouble(field[13]) - lng, 2));
			if(dist > maxDist) {
				maxDist = dist;
				max = lineCnt;
				maxPlace = field[9];
			}
			if(dist < minDist) {
				minDist = dist;
				min = lineCnt;
				minPlace = field[9];
			}
			//거리 = sqrt((위도1 - 위도2)^2 + (경도1 - 경도2)^2)
			System.out.printf(" 현재지점과 거리 : %f\n", dist);
			System.out.printf("*******************************\n");
			lineCnt++;
		}
		System.out.printf("최대거리 : %d번째 - %f, %s\n", max, maxDist, maxPlace);
		System.out.printf("최소거리 : %d번째 - %f, %s", min, minDist, minPlace);
		br.close();

	}

}
