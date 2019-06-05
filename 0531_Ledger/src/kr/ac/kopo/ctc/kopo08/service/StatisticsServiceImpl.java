package kr.ac.kopo.ctc.kopo08.service;

import java.util.List;

import kr.ac.kopo.ctc.kopo08.dao.AccountItemDao;
import kr.ac.kopo.ctc.kopo08.dao.AccountItemDaoImpl;
import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public class StatisticsServiceImpl implements StatisticsService {

	@SuppressWarnings("unused")
	@Override
	public AccountItem expendService() {
		// 지출 분야별 비율
		// 전체 소비금액에서 각 분야가 차지하는 비율
		AccountItemDao dao = new AccountItemDaoImpl();
		List<AccountItem> list = dao.selectAll();
		int sum = 0;
		int FOOD = 0;
		int HOME = 0;
		int LIVING = 0;
		int CLOTH = 0;
		int CULTURE = 0;
		int EDUCATION = 0;
		int TRAFFIC = 0;
		int DUES = 0;
		int TAX = 0;
		int ETC = 0;
		int CREDIT = 0;
		int SAVE = 0;
		int WIRE = 0;
		
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getWhether() == 0) {
				sum += list.get(i).getPrice();
				if (list.get(i).getCategory().equals("CULTURE")) {
					CULTURE += list.get(i).getPrice();
				}
			}
		}
		
		System.out.println(sum);
		System.out.printf("%s : %.2f%s", "건강/문화", CULTURE / (double)sum * 100, "%");
		return null;
	}

	@Override
	public AccountItem saveService() {
		// 저번달 수입 중 저축 비율
		return null;
	}

	@Override
	public AccountItem ratioService() {
		// 월별 수입 : 지출 비 (지난 1년)
		return null;
	}

}
enum Cat {
	 
    FOOD("식비"),
    HOME("주거/통신"),
    LIVING("생활용품"),
    CLOTH("의복/미용"),
    CULTURE("건강/문화"),
    EDUCATION("교육/육아"),
    TRAFFIC("교통/차량"),
    DUES("경조사/회비"),
    TAX("세금/이자"),
    ETC("용돈/기타"),
    CREDIT("카드대금"),
    SAVE("저축/보험"),
    WIRE("이체/대체");
     
    final private String name;
     
    public String getName() {
        return name;
    }
 
    private Cat(String name){
        this.name = name;
    }
}