
/**
 * @FileName : StringEx.java
 * @Project : 0520
 * @Date : 2019. 5. 20.
 * @Author : JBP
 * @Descript : String 클래스의 연산
 */
public class StringEx {

	public static void main(String[] args) {
		
		String k08_name = "Ja" + "va";
		String k08_str = k08_name + "8.0";
		
		System.out.println(k08_name);
		System.out.println(k08_str);
		System.out.println(7 + " "); // "7 "
		System.out.println(" " + 7); // " 7"
		System.out.println(7 + ""); // "7"
		System.out.println("" + 7); // "7"
		System.out.println("" + ""); // ""
		System.out.println(7 + 7 + ""); // "14"
		System.out.println("" + 7 + 7); // "77"
		
	}

}
