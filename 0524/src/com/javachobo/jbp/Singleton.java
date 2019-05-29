package com.javachobo.jbp;

/**
 * @FileName : Singleton.java
 * @Project : 0524
 * @Date : 2019. 5. 24.
 * @Author : JBP
 * @Descript : 디자인 패턴중 singleton 패턴
 *	싱글톤 패턴은 고정된 메모리 영역(static)을 얻으면서
 *	한번의 new 로 인스턴스를 사용하기 때문에 메모리 낭비를 방지
 *	또한 전역 인스턴스이기 때문에 다른 클래스의 인스턴스들이 데이터를 공유하기 쉽다.
 */
final class Singleton {
	private static Singleton s = new Singleton();
	//전역 인스턴스를 생성한다.
	
	public Singleton() {
		//실제로는 private 으로 지정하여 외부에서 객체 생성을 하지 못하도록 하지만
		//테스트를 위해 public 으로 설정하였다.
	}
	
	public static Singleton getInstance() {
		if(s == null) {
			s = new Singleton();
			//전역 인스턴스를 생성했기 때문에 null 일 일은 없지만
		}
		return s;
	}
}
