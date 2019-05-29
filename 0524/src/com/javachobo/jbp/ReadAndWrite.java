package com.javachobo.jbp;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;


/**
 * @FileName : ReadAndWrite.java
 * @Project : 0524
 * @Date : 2019. 5. 25.
 * @Author : JBP
 * @Descript : 무식하게 읽고 쓰기
 */
public class ReadAndWrite {

	public static void main(String[] args) {

		try {
			File f = new File("c:\\Study\\File\\test.txt");
			//파일 객체 생성
			FileWriter fw = new FileWriter(f);
			//파일을 쓸 준비
			
			fw.write("안녕 파일\r\n");
			fw.write("hello 헬로\r\n");
			//문자열 입력
			fw.close();
			//FileWriter 를 닫아준다.
			FileReader fr = new FileReader(f);
			//파일을 읽을 준비
			int n = -1;
			char[] ch;
			//char 타입의 배열을 만든다
			while(true) {
				ch = new char[100];
				n = fr.read(ch);
				//100칸의 char배열을 입력하고 char배열 단위로 파일을 읽는다.
				if(n == -1) break;
				//n 이 -1 이다? = 읽은게 없다.
				for(int i = 0; i < n; i++) {
					System.out.printf("%c", ch[i]);
					//읽어들인게 있으면 char단위로 출력해준다.
				}
			}
			
			fr.close();
			//파일리더 닫기
			
		} catch(Exception e) {
			System.out.printf("나 에러[%s]\n", e);
		}
	}

}
