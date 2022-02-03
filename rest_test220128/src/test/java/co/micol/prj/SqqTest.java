package co.micol.prj;

public class SqqTest {

	public static long seq = 40;
	
	public static void main(String[] args) {
		seq++;
		String strSeq = "00000000" + seq;
		
		

		// 9자리로 1씩 증가된 값을 생성, 랜덤, 시간
		long t1 = System.nanoTime();
		long t2 = System.currentTimeMillis();
		//System.out.println(t1);
		//System.out.println(t2);
		
		//String result = String.valueOf(t1).substring(7);
		String result = String.valueOf(t1);
		result = result.substring(result.length()-9);
		
		System.out.println(result);

		
	}

}
