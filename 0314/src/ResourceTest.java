
public class ResourceTest {

	public static void main(String[] args) {
		long st = System.currentTimeMillis();
		Magic.main(null);
		long et = System.currentTimeMillis();
		
		System.out.println((et - st) + " ms");
	}
	
}
