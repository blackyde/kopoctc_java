package kr.ac.kopo.ctc.kopo08.service;

import java.text.DecimalFormat;
import java.util.List;

import kr.ac.kopo.ctc.kopo08.dao.AccountItemDao;
import kr.ac.kopo.ctc.kopo08.dao.AccountItemDaoImpl;
import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public class StatisticsServiceImpl implements StatisticsService {

	@Override
	public AccountItem expendService(int account_id) {
		// 지출 분야별 비율
		// 전체 소비금액에서 각 분야가 차지하는 비율
		AccountItemDao dao = new AccountItemDaoImpl();
		List<AccountItem> list = dao.selectAll();
		DecimalFormat df = new DecimalFormat("###,###,###,###,###");
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
		int SAL = 0;
		
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getWhether() == 0 && list.get(i).getAccount().getId() == account_id) {
				sum += list.get(i).getPrice();
				if (list.get(i).getCategory().equals("식비")) {
					FOOD += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("주거/통신")) {
					HOME += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("생활용품")) {
					LIVING += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("의복/미용")) {
					CLOTH += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("건강/문화")) {
					CULTURE += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("교육/육아")) {
					EDUCATION += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("교통/차량")) {
					TRAFFIC += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("경조사/회비")) {
					DUES += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("세금/이자")) {
					TAX += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("용돈/기타")) {
					ETC += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("카드대금")) {
					CREDIT += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("저축/보험")) {
					SAVE += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("이체/대체")) {
					WIRE += list.get(i).getPrice();
				}
				if (list.get(i).getCategory().equals("급여")) {
					SAL += list.get(i).getPrice();
				}
			}
		}
		
		System.out.println("\n총 소비 금액\t: " + df.format(sum) + "원");
		System.out.printf("\n%s\t\t: %.2f%s", "식비", FOOD / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "주거/통신", HOME / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "생활용품", LIVING / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "의복/미용", CLOTH / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "건강/문화", CULTURE / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "교육/육아", EDUCATION / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "교통/차량", TRAFFIC / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "경조사/회비", DUES / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "세금/이자", TAX / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "용돈/기타", ETC / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "카드대금", CREDIT / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "저축/보험", SAVE / (double)sum * 100, "%");
		System.out.printf("\n%s\t: %.2f%s", "이체/대체", WIRE / (double)sum * 100, "%");
		System.out.printf("\n%s\t\t: %.2f%s\n", "급여", SAL / (double)sum * 100, "%");
		
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
