/**
 * 영수증 출력 프로그램
 * 서식을 활용해 영수증 모양을 똑같이 만들어보는 프로그램
 * @author JBP
 *
 */
public class Receipt {
	
	public static void main(String[] args) {
		
		//상단 셀러 정보
		
		System.out.printf("%40s \n", "농협");
		System.out.println("주소 : 경기 의정부시");
		System.out.print("대표 : 최영*");
		System.out.printf("%30s \n", "전화 : 031-***-****");
		System.out.println("사업자번호 : 127-82-88888");
		System.out.println("홈페이지 : http://www.nonghyup.com/");
		System.out.println("영수증 미지참시 교환/환불 불가(30일내)");
		System.out.println("교환/환불 구매점에서 가능(결제카드지참)");
		System.out.println("========================================");
		
		//캐셔 정보
		System.out.print("김갑순");
		System.out.printf("%41s \n", "2015-11-03 16:31:53  0002-00085");
		
		//인덱스
		System.out.print("상품(코드)");
		System.out.printf("%13s", "단가");
		System.out.printf("%13s", "수량");
		System.out.printf("%18s\n", "금액");
		System.out.println("----------------------------------------");
		
		//상품 목록
		System.out.print("001 P굿모닝우유 900ML");
		System.out.printf("%23s\n", "[2,150]");
		System.out.print("*8801104210645");
		System.out.printf("%10s", "1,350");
		System.out.printf("%6s", "1");
		System.out.printf("%10s\n", "1,350");
		System.out.println("002 P양파 .");
		System.out.print("*231973");
		System.out.printf("%17s", "3,300");
		System.out.printf("%6s", "1");
		System.out.printf("%10s\n", "3,300");
		System.out.println("003 P무 .");
		System.out.print("*231913");
		System.out.printf("%17s", "500");
		System.out.printf("%6s", "1");
		System.out.printf("%10s\n", "500");
		System.out.println("004 P깻잎 .");
		System.out.print("*231308");
		System.out.printf("%17s", "750");
		System.out.printf("%6s", "1");
		System.out.printf("%10s\n", "750");
		System.out.println("005 P하선정 바로먹기좋은장아찌 150g");
		System.out.print("*8801007265889");
		System.out.printf("%10s", "1,380");
		System.out.printf("%6s", "1");
		System.out.printf("%10s\n", "1,380");
		System.out.println("006 P브로커리 .");
		System.out.print("*232285");
		System.out.printf("%17s", "1,280");
		System.out.printf("%6s", "1");
		System.out.printf("%10s\n", "1,280");
		
		//계산
		System.out.println("----------------------------------------");
		System.out.printf("%44s", "판 매 총 액 :");
		System.out.printf("%14s\n", "8,560");
		System.out.printf("%40s\n", "-----------------------------");
		System.out.printf("%44s", "받 을 금 액 :");
		System.out.printf("%14s\n", "8,560");
		System.out.printf("%46s", "신   용   액 :");
		System.out.printf("%14s\n", "8,560");
		System.out.printf("%40s\n", ">>-----------------------------<<");
		System.out.printf("%36s", "부가세면세물품가액 :");
		System.out.printf("%14s\n", "7,180");
		System.out.printf("%36s", "부가세과세물품가액 :");
		System.out.printf("%14s\n", "1,255");
		System.out.printf("%46s", "부      가     세 :");
		System.out.printf("%14s\n", "1,255");
		
		//회원 정보
		System.out.println("----------------------------------------");
		System.out.println("바코드앞    *  면세 .   #  영세 .   상품명     P포인트");
		System.out.println("----------------------------------------");
		System.out.println("회원 : 2010190034*** 박*분 님");
		System.out.printf("%39s", "우수고객포인트 :");
		System.out.printf("%14s\n", "40");
		System.out.printf("%43s", "잔 여 포 인 트 :");
		System.out.printf("%14s\n", "14,198");
		System.out.printf("%39s", "사용가능포인트 :");
		System.out.printf("%14s\n", "14,190");
		
		//카드 정보
		System.out.println("****************************************");
		System.out.printf("%32s\n", "****** 신용카드 매출전표(고객용) ******");
		System.out.println("****************************************");
		System.out.println("우리카드 : 4902************");
		System.out.print("할부 : 00개월");
		System.out.printf("%24s", "매출금액 : ");
		System.out.printf("%13s\n", "8,560원");
		System.out.print("승인No : 75513401");
		System.out.printf("%20s\n", "가맹점 : 0000007490C");
		System.out.print("승인일자 : 20151103");
		System.out.printf("%17s\n", "카드밴사 : KIS(V3)");
		System.out.println("승    인");
		
		//꼬릿말
		System.out.println("----------------------------------------");
		System.out.println("좋은 하루 되세요!");
		System.out.println("언제나 고객님을 위해 최선을 다하겠습니다.");
		System.out.printf("%32s", "0111621511030002000850");
	}
}
