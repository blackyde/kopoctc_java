package com.wara.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MiddlePoint {
	
	static String[] placeName = new String[10];
	static double[] latitude = new double[10];
	static double[] longitude = new double[10];
	
	public static void dataSort(List<Result> lr) {
		Comparator<Result> asc = new Comparator<Result>() {

			@Override
			public int compare(Result r1, Result r2) {
				// TODO Auto-generated method stub
				if(r1.getDist() > r2.getDist()) {
					return 1;
				} else if(r1.getDist() < r2.getDist()) {
					return -1;
				} else {
					return 0;
				}
			}
			
		};
		Collections.sort(lr, asc);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		placeName[0] = "서현";
		latitude[0] = 37.384931;
		longitude[0] = 127.12324899999999;
		
		placeName[1] = "명동";
		latitude[1] = 37.56371620000001;
		longitude[1] = 126.98449060000007;
		
		placeName[2] = "강남";
		latitude[2] = 37.5004509;
		longitude[2] = 127.02676300000007;
		
		placeName[3] = "논현";
		latitude[3] = 37.506317;
		longitude[3] = 127.02441299999998;
		
		placeName[4] = "가로수길";
		latitude[4] = 37.5178868;
		longitude[4] = 127.02322750000008;
		
		placeName[5] = "이태원";
		latitude[5] = 37.534533;
		longitude[5] = 126.99457899999993;
		
		placeName[6] = "홍대";
		latitude[6] = 37.556608;
		longitude[6] = 126.924799;
		
		placeName[7] = "신촌";
		latitude[7] = 37.5594793;
		longitude[7] = 126.94358379999994;
		
		placeName[8] = "선릉";
		latitude[8] = 37.504479;
		longitude[8] = 127.04894100000001;
		
		placeName[9] = "건대";
		latitude[9] = 37.5401534;
		longitude[9] = 127.07040630000006;		
		
		List<HotPlace> lhp = new ArrayList<HotPlace>();
		
		for(int i = 0; i < placeName.length; i++) {
			HotPlace hp = new HotPlace();
			hp.setPlaceName(placeName[i]);
			hp.setLatitude(latitude[i]);
			hp.setLongitude(longitude[i]);
			lhp.add(hp);
		}
		
		HotPlace park = new HotPlace("박준범", 37.369427, 127.143655);
		HotPlace kim = new HotPlace("김기윤", 37.378435, 127.11421599999994);
		HotPlace lee = new HotPlace("이길준", 37.366766, 127.10826500000007);
		HotPlace no = new HotPlace("노윤호", 37.484102, 127.03436899999997);
		HotPlace lee2 = new HotPlace("이승준", 37.275657, 127.11594400000001);
		HotPlace person1 = new HotPlace("목동", 37.5370192, 126.87352970000006);
		HotPlace person2 = new HotPlace("김포", 37.6152464, 126.71563249999997);
		HotPlace person3 = new HotPlace("의정부", 37.73809800000001, 127.03368190000003);
		HotPlace person4 = new HotPlace("홍제", 37.58551120000001, 126.94898310000008);
		HotPlace person5 = new HotPlace("송파", 37.5145437,127.10659710000004);
		
		List<HotPlace> group1 = new ArrayList<HotPlace>();
		group1.add(park);
		group1.add(kim);
		group1.add(lee);
		group1.add(no);
		group1.add(lee2);
		
		double sumLat = 0.0;
		double sumLng = 0.0;
		
		for(HotPlace h : group1) {
			sumLat += h.getLatitude();
			sumLng += h.getLongitude();
		}
		
		//중간
		double avgLat = sumLat / group1.size();
		double avgLng = sumLng / group1.size();
		//park, 1, 4, 5 의 경우 서초구 반포동
		//park, 1, 2, 3, 4, 5 의 경우 중구 의주로(서울역 부근)
		//park, kim, lee, no, lee2 의 경우 분당구 백현동
		System.out.println("중간 위치 : " + avgLat + "," + avgLng);
		
		List<Result> lr = new ArrayList<Result>();
		
		for(HotPlace h : lhp) {
			Result r = new Result();
			double distance = Math.sqrt(Math.pow(h.getLatitude() - avgLat, 2)
					+ Math.pow(h.getLongitude() - avgLng, 2));
			r.setPlaceName(h.getPlaceName());
			r.setDist(distance);
			lr.add(r);
		}
		
		dataSort(lr);
		
		for(Result r : lr) {
			System.out.println(r.getPlaceName() + ", 중간지점과의 거리 : " + r.getDist());
		}
	}

}
