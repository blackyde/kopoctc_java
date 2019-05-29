
public class AgeOperationClass {
	
	AgeOperationClass() {
		
	}

	private int calculateAge(String registerNumber) {
		
		//나이 판별용
		int age = 0;
		int birthAge = 0;
		int older = 0;
		
		int currentYear = 2019;
		int today = 308;
		int birthYear = 0;
		int birth = 0;
		
		final int OLD = 65;
		final int BABY = 3;
		final int BOY = 12;
		final int TEEN = 18;
		final int ADULT = 19;
		
		//나이 처리
		birth = Integer.parseInt(registerNumber); //주민등록 번호를 받음		
		birthYear = birth / 10000; //앞 2자리만 남김
		
		//연나이
		if(birthYear <= 19) { //2000년대 생일때			
			age = currentYear - (birthYear + 2000) + 1;
		} else { //1900년대 생일때			
			age = currentYear - (birthYear + 1900) + 1;			
		}
		
		//만나이
		birth = birth - ((birth / 10000) * 10000);	//앞 2자리를 잘라냄
		if(birth > today) { //생일이 오늘보다 뒤면			
			birthAge = age - 2;			
		} else { //생일이 오늘이거나 지났으면			
			birthAge = age - 1;			
		}
		
		if(birthAge < BABY) {
			older = BABY;
		} else if((birthAge >= BABY && birthAge <= BOY) || birthAge >= OLD) {
			older = BOY;
		} else if(birthAge > BOY && birthAge <= TEEN) {
			older = TEEN;
		} else {
			older = ADULT;
		}
		
		return older;
	}
	
	private int calculateAge2(String registerNumber) {
		
		//나이 판별용
		int age = 0;
		int birthAge = 0;
		
		int currentYear = 2019;
		int today = 308;
		int birthYear = 0;
		int birth = 0;
		
		//나이 처리
		birth = Integer.parseInt(registerNumber); //주민등록 번호를 받음		
		birthYear = birth / 10000; //앞 2자리만 남김
		
		//연나이
		if(birthYear <= 19) { //2000년대 생일때			
			age = currentYear - (birthYear + 2000) + 1;
		} else { //1900년대 생일때			
			age = currentYear - (birthYear + 1900) + 1;			
		}
		
		//만나이
		birth = birth - ((birth / 10000) * 10000);	//앞 2자리를 잘라냄
		if(birth > today) { //생일이 오늘보다 뒤면			
			birthAge = age - 2;			
		} else { //생일이 오늘이거나 지났으면			
			birthAge = age - 1;			
		}
		
		return birthAge;
	}
	
	public int returnAge(String registerNumber) {
		int older = calculateAge(registerNumber);
		return older;
	}
	
	public int getAge(String registerNumber) {
		int birthAge = calculateAge2(registerNumber);
		return birthAge;
	}
	
}
