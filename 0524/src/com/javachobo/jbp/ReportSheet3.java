package com.javachobo.jbp;

/**
 * @FileName : ReportSheet3.java
 * @Project : 0524
 * @Date : 2019. 5. 26.
 * @Author : JBP
 * @Descript : 클래스의 ArrayList 실행 부
 */
public class ReportSheet3 {

	public static void main(String[] args) {
		
		Main01.dataSet();
		Main01.headerPrint();
		for (int i = 0; i < Main01.aor.size(); i++) {
			Main01.itemPrint(i);
		}
		Main01.tailPrint();
	}

}
