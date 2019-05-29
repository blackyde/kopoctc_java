package com.javachobo.jbp;

import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

/**
 * @FileName : File.java
 * @Project : 0524
 * @Date : 2019. 5. 25.
 * @Author : JBP
 * @Descript : 파일 쓰기 따라해보기
 */
public class FileEx {

	public static void main(String[] args) throws Exception {

		FileWriter fw = new FileWriter("c:\\Study\\File\\test.txt", true);
		//저장하고자 하는 파일이름(경로 포함)과 중복시 덮어쓰기 유무
		//BufferedWriter bw = new BufferedWriter(fw);
		//어라.. 쓰는 곳이 없네..
		StringBuffer sf = new StringBuffer();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = "";
		while(!(str = br.readLine()).startsWith("s")) {
			sf.append("\r\n"+ str); //스트링버퍼에 한줄씩 읽어 기록한다.
		}
		
		br.close(); //자원해제
		fw.write(sf.toString()); //스트링버퍼를 스트링형으로 변환하여 기록한다.
		fw.flush();
		fw.close(); //자원을 해제한다.
		System.out.println("저장이 완료되었습니다.");
	}
}