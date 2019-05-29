/**
 * String 클래스의 메소드들을 확인해보자
 * @author JBP
 *
 */
import java.util.regex.Pattern;

public class GoodMorning {

	public static void main(String[] args) {

		String str = "Hello World";
		String str2 = "  Hello   World  ";
		
		System.out.println(str.startsWith("h"));
		//첫 글자는 " "로 시작하는가? 소문자 대문자 구별
		System.out.println(str.endsWith("d"));
		//마지막 글자는 " "로 시작하는가? 소문자 대문자 구별
		System.out.println(str.replace("l", "L"));
		//지정한 글자를 교체
		System.out.println(str.toUpperCase());
		//대문자로
		System.out.println(str.toLowerCase());
		//소문자로
		System.out.println(str.equalsIgnoreCase("HELLO WORLD"));
		//대소문자를 무시하고 글자가 같은지 비교
		System.out.println(str.indexOf("e"));
		//찾고자 하는 글자는 몇번째에 위치하는가? 0부터 첫자리
		System.out.println(str.length());
		//문자열의 길이
		System.out.println(str.substring(1, 4));
		//시작점 부터 끝점의 전까지 자르기
		System.out.println(String.valueOf(100));
		//valueOf(값) 을 문자열로 바꾼다.
		System.out.println(str.split("\\s"));
		System.out.println(str.split("\\s", 1));
		System.out.println(str.split("\\s")[0]);
		System.out.println(str.split("\\s", 1)[0]);
		//지정한 값으로 나누어 배열에 담는다. int와 동시에 사용하면 배열의 수를 제한한다.
		System.out.println(str.equals("Hello World"));
		//문자열이 같은지 비교
		System.out.println(str.charAt(0));
		//원하는 자리의 문자를 찾기
		System.out.println(str2.trim());
		//문자열 앞뒤 공백 제거
		System.out.println(str.contains("o"));
		//" "의 문자를 포함하는가
		System.out.println(str.concat("!"));
		//문자열을 합친다.
		System.out.println(Pattern.matches("^[a-zA-Z\\s]*$", str));
		//정규표현식에 맞는지 비교하여 boolean 값 반환
		System.out.println(String.format("%d + %d 은 %d 입니다.", 10, 20, 10+20));
		//printf 와 동일하게 사용 가능
		System.out.println(str.toString());
		//메서드는 객체가 가지고 있는 정보나 값들을 문자열로 만들어 리턴하는 메소드
		//String 클래스에서는 가진 값을 그대로 리턴
		
		
	}

}
