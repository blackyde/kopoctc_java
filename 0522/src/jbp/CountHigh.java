package jbp;

/**
 * @FileName : CountHigh.java
 * @Project : 0522
 * @Date : 2019. 5. 22.
 * @Author : JBP
 * @Descript : 숫자읽기 고급
 */
public class CountHigh {

	public static void main(String[] args) {

		int k08_iNumVal = 1001034567;
		//임의의 숫자를 설정
		String k08_sNumVal = String.valueOf(k08_iNumVal);
		//설정한 숫자를 문자열로 받는다.
		String k08_sNumVoice = "";
		
		System.out.printf("==> %s [%d자리]\n", k08_sNumVal, k08_sNumVal.length());
		//숫자와 몇자리 숫자인지 표현
		int k08_i, k08_j;
		
		String[] k08_units = {"영","일","이","삼","사","오","육","칠","팔","구"};
		String[] k08_unitx = {"","십","백","천","만","십","백","천","억","십"};
		//숫자를 읽을 한글의 배열을 생성
		k08_i = 0;
		k08_j = k08_sNumVal.length() - 1;
		//i는 0부터, j는 9부터 시작
		while(true) {
			if(k08_i >= k08_sNumVal.length()) break;
			//i 값이 자릿수와 같거나 커지면 break
			System.out.printf("%s[%s]", 
					k08_sNumVal.substring(k08_i, k08_i + 1), 
					k08_units[Integer.parseInt(k08_sNumVal.substring(k08_i, k08_i + 1))]);
			//i번째 index부터 그다음 index(숫자한자리)를 자르고 읽는 방법을 표시한다.
			
			if(k08_sNumVal.substring(k08_i, k08_i + 1).equals("0")) {
				//자른 숫자가 0이면
				if(k08_unitx[k08_j].equals("만") || k08_unitx[k08_j].equals("억")) {
					//만이나 억일 경우
					k08_sNumVoice = k08_sNumVoice + "" + k08_unitx[k08_j];
					//읽는법에 해당 단위 읽는법을 누적한다.
				} else {
					//만이나 억이 아닌경우 아무것도 입력하지 않는다.
				}
			} else {				
				k08_sNumVoice = k08_sNumVoice
						+ k08_units[Integer.parseInt(k08_sNumVal.substring(k08_i, k08_i + 1))]
						+ k08_unitx[k08_j];
				//읽는 법에 숫자읽는 법과 단위 읽는법을 누적한다.
				//일십 일백 같은 경우 통상적으로 쓰지 않지만 정확한 표기를 위해 사용한다.
			}
			k08_i++;
			k08_j--;
			//i값은 0부터 자릿수와 같아질때까지, j값은 자릿수부터 0이 될때까지
		}
		System.out.printf("\n %s[%s]\n", k08_sNumVal, k08_sNumVoice);
		//누적된 읽는 법을 출력한다.
	}

}