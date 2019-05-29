package com.javachobo.jbp;

/**
 * @FileName : SingletonMain.java
 * @Project : 0524
 * @Date : 2019. 5. 24.
 * @Author : JBP
 * @Descript : singleton 패턴 사용
 */
public class SingletonMain {
	public static void main(String[] args) {
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		Singleton s4 = Singleton.getInstance();
		//아무리 인스턴스를 많이 생성해도 실제 인스턴스는 전역 인스턴스 하나이다.		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		//주소값을 찍어보면 모두 동일하다.
		Singleton s5 = new Singleton();
		Singleton s6 = new Singleton();
		Singleton s7 = new Singleton();
		Singleton s8 = new Singleton();
		//생성자를 public 으로 풀어주고 new 로 생성
		System.out.println(s5);
		System.out.println(s6);
		System.out.println(s7);
		System.out.println(s8);
		//주소값을 찍어보면 모두 다르다.
	}
}
