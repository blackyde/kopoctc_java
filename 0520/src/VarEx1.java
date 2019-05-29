
/**
 * @FileName : VarEx1.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : 변수를 사용해 본다.
 */
public class VarEx1 {

	public static void main(String[] args) {
		
		int k08_year = 0;
		int k08_age = 14;
		
		System.out.println(k08_year);
		System.out.println(k08_age);
		
		k08_year = k08_age + 2000; // 변수 age의 값에 2000을 더해서 변수 year에 저장
		k08_age = k08_age + 1; // 변수 age에 저장된 값을 1 증가시킨다.
		
		System.out.println(k08_year);
		System.out.println(k08_age);

	}

}
