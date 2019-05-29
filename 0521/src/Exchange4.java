
/**
 * @FileName : Exchange4.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 수수료 포함 환전 계산(3) 
 */
public class Exchange4 {

	public static void main(String[] args) {

		int k08_won = 1000000;
		double k08_moneyEx = 1238.21; //달러 환율
		double k08_commission =0.003; //환전 수수료		
		double k08_comPerOne = k08_moneyEx * k08_commission; //1달러당 수수료
		//1달러당 수수료 = 환율 * 환전 수수료
		int k08_usd = (int)(k08_won / (k08_moneyEx + k08_comPerOne));
		//미화 = (int)(총 금액 / (환율 + 1달러당 수수료)
		double k08_totalCom = k08_usd * k08_comPerOne;
		//총 수수료 = 미화 * 1달러당 수수료

		int k08_i_totalCom;
		
		//총 수수료를 정수로 바꾸고 다시 실수로 바꿔주면 소수점이 떨어져 나간다.
		//수수료는 소수점이 있을 경우 올림해서 받아야 하므로
		//소수점이 존재하면 1원을 더해준다.
		if (k08_totalCom != (double)((int)k08_totalCom)) {
			k08_i_totalCom = (int)k08_totalCom + 1;
		} else {
			k08_i_totalCom = (int)k08_totalCom;
		}
		
		System.out.printf("******************************************\n");
		System.out.printf("*           (정확한) 수수료 적용환전                        *\n");
		System.out.printf("총 수수료: %d원 => 미화: %d달러, 달러당 수수료: %f원\n",
				k08_i_totalCom, k08_usd, k08_comPerOne);
		
		int k08_remain = (int)(k08_won - k08_usd * k08_moneyEx - k08_i_totalCom);
		System.out.printf("총 한화환전금액: %d원 => 미화: %d달러, 수수료징구: %d원, 잔돈: %d원\n",
				k08_won, k08_usd, k08_i_totalCom, k08_remain);
		System.out.printf("******************************************\n");
				
	}

}
