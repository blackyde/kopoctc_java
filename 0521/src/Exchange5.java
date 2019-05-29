import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @FileName : Exchange5.java
 * @Project : 0521
 * @Date : 2019. 5. 21.
 * @Author : JBP
 * @Descript : 콤마 찍기 
 */
public class Exchange5 {

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
		
		DecimalFormat k08_df = new DecimalFormat("###,###,###,###,###");
		//java.text.DecimalFormat 라이브러리를 import 하고 3자리마다 ,를 찍도록 설정
		
		System.out.printf("******************************************\n");
		System.out.printf("*             콤마찍기, 날짜적용                            *\n");
		System.out.printf("총 수수료: %s원 => 미화: %s달러, 달러당 수수료: %f원\n",
				k08_df.format(k08_i_totalCom), //총 수수료에 format 적용
				k08_df.format(k08_usd), //미화에 format 적용
				k08_comPerOne);
		
		int k08_remain = (int)(k08_won - k08_usd * k08_moneyEx - k08_i_totalCom);
		System.out.printf("총 한화환전금액: %s원 => 미화: %s달러, 수수료징구: %s원, 잔돈: %s원\n",
				k08_df.format(k08_won), //총 금액에 format 적용
				k08_df.format(k08_usd), //미화에 format 적용
				k08_df.format(k08_i_totalCom), //총 수수료에 format 적용
				k08_df.format(k08_remain)); //잔돈에 format 적용
		
		Calendar k08_cal = Calendar.getInstance();
		//java.util.Calendar 라이브러리 import		
		SimpleDateFormat k08_sdt = new SimpleDateFormat("YYYY/MM/dd HH:mm:ss");
		//java.text.SimpleDateFormat 라이브러리 import
		//2019/05/21 23:59:59 의 형식으로 설정
		System.out.printf("최종실행시간: %s\n", k08_sdt.format(k08_cal.getTime()));
		
		System.out.printf("******************************************\n");

	}

}
