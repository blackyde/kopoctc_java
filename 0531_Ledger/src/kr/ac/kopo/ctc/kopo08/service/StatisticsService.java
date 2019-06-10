package kr.ac.kopo.ctc.kopo08.service;

import kr.ac.kopo.ctc.kopo08.domain.AccountItem;

public interface StatisticsService {
	//지출 분야별 비율
	AccountItem expendService(int account_id);
	
	//저번 달 수입 중 저축 비율
	AccountItem saveService();
	
	//월별 수입 : 지출
	AccountItem ratioService();
}
