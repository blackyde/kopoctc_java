package com.javachobo.jbp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @FileName : FileReadWrite.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : Buffered 읽고 쓰기
 */
public class FileReadWrite {
	
	public static void FileWrite() throws IOException {
		File f = new File("c:\\Study\\File\\test.txt");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));
		//버퍼 = 손으로 푸는걸 삽이나 포크레인으로 푸는 느낌
		bw.write("안녕 파일ㅋ");   //파일에 문자열을 쓰고
		bw.newLine();           //개행
		bw.write("hello 헬로");  //파일에 문자열을 쓰고
		bw.newLine();           //개행
		
		bw.close();
	}
	
	public static void FileRead() throws IOException {
		File f = new File("c:\\Study\\File\\test.txt");
		BufferedReader br = new BufferedReader(new FileReader(f));
		
		String readtxt;
		
		while((readtxt = br.readLine()) != null) {
			System.out.printf("%s\n", readtxt);
			//null 이 아니면 파일을 읽어서 콘솔에 출력
		}
		br.close();
	}
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileWrite();
		FileRead();
	}
}