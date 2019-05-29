
/**
 * @FileName : Exchange2.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 수수료 포함 환전 계산(1) 
 */
public class Exchange2 {

	public static void main(String[] args) {

		int k08_won = 1000000;
		double k08_moneyEx = 1238.21; //달러 환율
		double k08_commission =0.003; //환전 수수료
		
		int k08_usd = (int)(k08_won / k08_moneyEx);
		//전체 금액을 환율로 나누고 정수로 형변환 하면 소수점이 버려진다.
		
		double k08_comPerOne = k08_moneyEx * k08_commission; //1달러당 수수료
		//1달러당 수수료 = 환율 * 환전 수수료
		
		double k08_totalCom = k08_usd * k08_comPerOne;
		//총 수수료 = 1달러당 수수료 * 총 달러
		
		System.out.printf("**********************************************\n");
		System.out.printf("*                  수수료 계산                                     *\n");
		System.out.printf("총 수수료: %f원 => 미화: %d달러, 달러당 수수료: %f원\n",
				k08_totalCom, k08_usd, k08_comPerOne);
		System.out.printf("**********************************************\n");
		
	}

}
