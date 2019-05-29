
public class PriceClass {
	
	PriceClass() {
		
	}
	
	private int setPay(int older, int ticket, int merit) {
		
		int sum = 0;
		//나이 구분
		final int BABY = 3;
		final int BOY = 12;
		final int TEEN = 18;
		
		//요금 테이블
		//성인 일반요금
		final int DAY_ADULT = 54000;
		final int DAY_TEEN = 46000;
		final int DAY_BOY = 43000;
		final int NIGHT_ADULT = 45000;
		final int NIGHT_TEEN = 39000;
		final int NIGHT_BOY = 36000;
		final int TWO_DAY_ADULT = 84000;
		final int TWO_DAY_TEEN = 71000;
		final int TWO_DAY_BOY = 67000;
		
		//장애인
		final int DISABLED_DAY_ADULT = 33000;
		final int DISABLED_DAY_TEEN = 28000;
		final int DISABLED_DAY_BOY = 26000;
		final int DISABLED_NIGHT_ADULT = 27000;
		final int DISABLED_NIGHT_TEEN = 24000;
		final int DISABLED_NIGHT_BOY = 23000;
		
		//유공자
		final int MERIT_DAY_ADULT = 27000;
		final int MERIT_DAY_TEEN = 23000;
		final int MERIT_DAY_BOY = 21500;
		final int MERIT_NIGHT_ADULT = 22500;
		final int MERIT_NIGHT_TEEN = 19500;
		final int MERIT_NIGHT_BOY = 18000;
		
		//다자녀
		final int MULTI_DAY_ADULT = 43000;
		final int MULTI_DAY_TEEN = 36000;
		final int MULTI_DAY_BOY = 34000;
		final int MULTI_NIGHT_ADULT = 36000;
		final int MULTI_NIGHT_TEEN = 31000;
		final int MULTI_NIGHT_BOY = 28000;
		
		//임산부
		final int PREGNANT_DAY = 45000;
		final int PREGNANT_NIGHT = 36000;
		
		switch(merit) {
		
		case 1 : //없음
			switch(ticket) {
			case 1 : //주간권
				switch(older) {
				case BABY : 
					sum = 0;
					break;
				case BOY : //소인과 경로 포함
					sum = DAY_BOY; 
					break;
				case TEEN :
					sum = DAY_TEEN;
					break;
				default :
					sum = DAY_ADULT;
					break;
				}
				break;
			case 2 : //야간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = NIGHT_BOY;
					break;
				case TEEN :
					sum = NIGHT_TEEN;
					break;
				default :
					sum = NIGHT_ADULT;
					break;
				}
				break;
			case 3 : //2일권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = TWO_DAY_BOY;
					break;
				case TEEN :
					sum = TWO_DAY_TEEN;
					break;
				default :
					sum = TWO_DAY_ADULT;
					break;
				}
				break;
			}
			break;
			
		case 2 : //장애인
			switch(ticket) {
			case 1 : //장애인 주간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = DISABLED_DAY_BOY;
					break;
				case TEEN :
					sum = DISABLED_DAY_TEEN;
					break;
				default :
					sum = DISABLED_DAY_ADULT;
					break;
				}
				break;
			case 2 : //장애인 야간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = DISABLED_NIGHT_BOY;
					break;
				case TEEN :
					sum = DISABLED_NIGHT_TEEN;
					break;
				default :
					sum = DISABLED_NIGHT_ADULT;
					break;
				}
				break;
			//우대권엔 2일권이 따로 없으므로 1일권 x 2 의 가격을 받는다.
			case 3 : //장애인 2일권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = DISABLED_DAY_BOY * 2;
					break;
				case TEEN :
					sum = DISABLED_DAY_TEEN * 2;
					break;
				default :
					sum = DISABLED_DAY_ADULT * 2;
					break;
				}
				break;
			}
			break;
			
		case 3 : //유공자
			switch(ticket) {
			case 1 : //유공자 주간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MERIT_DAY_BOY;
					break;
				case TEEN :
					sum = MERIT_DAY_TEEN;
					break;
				default :
					sum = MERIT_DAY_ADULT;
					break;
				}
				break;
			case 2 : //유공자 야간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MERIT_NIGHT_BOY;
					break;
				case TEEN :
					sum = MERIT_NIGHT_TEEN;
					break;
				default :
					sum = MERIT_NIGHT_ADULT;
					break;
				}
				break;
			case 3 : //유공자 2일권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MERIT_DAY_BOY * 2;
					break;
				case TEEN :
					sum = MERIT_DAY_TEEN * 2;
					break;
				default :
					sum = MERIT_DAY_ADULT * 2;
					break;
				}
				break;
			}
			break;
			
		case 4 : //다자녀
			switch(ticket) {
			case 1 : //다자녀 주간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MULTI_DAY_BOY;
					break;
				case TEEN :
					sum = MULTI_DAY_TEEN;
					break;
				default :
					sum = MULTI_DAY_ADULT;
					break;
				}
				break;
			case 2 : //다자녀 야간권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MULTI_NIGHT_BOY;
					break;
				case TEEN :
					sum = MULTI_NIGHT_TEEN;
					break;
				default :
					sum = MULTI_NIGHT_ADULT;
					break;
				}
				break;
			case 3 : //다자녀 2일권
				switch(older) {
				case BABY :
					sum = 0;
					break;
				case BOY :
					sum = MULTI_DAY_BOY * 2;
					break;
				case TEEN :
					sum = MULTI_DAY_TEEN * 2;
					break;
				default :
					sum = MULTI_DAY_ADULT * 2;
					break;
				}
				break;
			}
			break;
			
		case 5 : //임산부
			switch(ticket) {
			case 1 : //임산부 주간권
				sum = PREGNANT_DAY;
				break;
			case 2 : //임산부 야간권
				sum = PREGNANT_NIGHT;
				break;
			case 3 : //임산부 2일권
				sum = PREGNANT_DAY * 2;
				break;
			}
		}
		
		return sum;
		
	}
	
	public int getPay(int older, int ticket, int merit) {
		int sum = setPay(older, ticket, merit);
		return sum;
	}

}
