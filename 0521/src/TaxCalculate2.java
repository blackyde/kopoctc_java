
/**
 * @FileName : TaxCalculate2.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 소비자가 세금 계산 
 */
public class TaxCalculate2 {

	public static void main(String[] args) {

		/////////////////////////////////////////
		//소비자가 custom, 세전가 net, 세금 tax, 세율 rate
		//custom = net + tax
		//custom = net + net * rate = net * (1 + rate)
		//net = custom / (1 + rate)
		//tax = custom - net
		
		int k08_custom = 280;
		int k08_rate = 3;
		
		int k08_tax, k08_net;
		
		k08_net = (int)(k08_custom / (1 + k08_rate / 100.0));
		//세전가 = (정수로 형변환)(소비자가 / (1 + 세율 / 100.0))
		//net = (int)(280 / (1 + 3 / 100.0))
		//세율 3% 는 0.03 이므로 100으로 나누어 준다.
		k08_tax = k08_custom - k08_net;
		//세금 = 소비자가 - 세전가
		//tax = 280 - (int)(280 / (1 + 3 / 100.0))
		
		System.out.printf("***********************************\n");
		System.out.printf("*        소비자가 중심 세금 계산                   *\n");
		
		System.out.printf("소비자가격: %d   세전가격: %d   세금: %d\n",
				k08_custom, k08_net, k08_tax);
		System.out.printf("***********************************\n");
	}

}
