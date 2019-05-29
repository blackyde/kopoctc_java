
/**
 * @FileName : TaxCalculate.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 단순 세금 계산 
 */
public class TaxCalculate {
	
	/////////////////////////////////////////
	//반올림은 유효숫자를 높여 오차를 줄이는 방법이나, 세금계산 문제 같으면 손해를 안봐야 되는 문제
	//즉 세율을 나눠서 원가단위가 딱 떨어지면 그대로 세금을 먹이나, 아니면 +1원을 더해야 한다.
	
	public static int taxcal(int val, int rate) { 
		//method 를 따로 정의 int 형 method 는 int 형 return 값이 필요하다.
		int ret;
		
		if( ((double)val * (double)rate / 100.0 ) == val * rate / 100 ) {
			//입력받은 물건값과 세율을 계산하여 실수형과 정수형의 값이 같다면 그대로 반환
			ret = val * rate / 100;
		} else {
			//실수형과 정수형의 값이 다르다 = 소숫점이 존재한다 => 1원을 더한다.
			ret = val * rate / 100 + 1;
		}
		
		return ret;
	}

	public static void main(String[] args) {

		int k08_val = 271; //세전 물건값
		int k08_rate = 3; //세금 3퍼센트
		
		int k08_tax = taxcal(k08_val, k08_rate); //method 호출과 동시에 값을 넘긴다.
		
		System.out.printf("*******************************\n");
		System.out.printf("*         단순 세금 계산                      *\n");
		System.out.printf("실제 세금계산: %f\n", k08_val * k08_rate / 100.0);
		//세전 물건값 * 세율 / 100.0 = 실수형 실제 세금
		System.out.printf("세전가격: %d 세금: %d 세포함가격: %d\n", k08_val, k08_tax, k08_val + k08_tax);
		//실제 세금에 소수점 값이 존재하므로(8.13원) 올림하여 9원으로 만든다. 
		System.out.printf("*******************************\n");
		
		
	}

}
