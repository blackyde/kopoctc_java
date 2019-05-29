
/**
 * @FileName : Exchange.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 단순 환전 계산
 */
public class Exchange {

	public static void main(String[] args) {

		int k08_won = 1000000;
		double k08_moneyEx = 1238.21; //달러 환율
		@SuppressWarnings("unused")
		double k08_commission =0.003; //환전 수수료
		
		int k08_usd = (int)(k08_won / k08_moneyEx);
		//전체 금액을 환율로 나누고 정수로 형변환 하면 소수점이 버려진다.
		int k08_remain = (int)(k08_won - k08_usd * k08_moneyEx);
		//총 금액에서 환율 * 환전된 달라 금액을 빼면 나머지 돈이 나온다.
		
		System.out.printf("**********************************************\n");
		System.out.printf("*                수수료없이 계산                                    *\n");
		System.out.printf("총 한화환전금액: %d원 => 미화: %d달러, 잔돈: %d원\n",
				k08_won, k08_usd, k08_remain);
		System.out.printf("**********************************************\n");
		
	}

}
