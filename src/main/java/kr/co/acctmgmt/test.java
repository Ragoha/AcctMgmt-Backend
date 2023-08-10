package kr.co.acctmgmt;

public class test {
	public static void main(String[] args) {
		String bgtCd = "11119000";
		int divFg = 5; // 예를 들어 4번 위치의 multiNum 값을 알고 싶다면
		    // 해당 위치의 숫자를 가져옴
		    int num = Character.getNumericValue(bgtCd.charAt(divFg-1));
		    // 해당 위치의 multiNum는 숫자에서 1을 뺀 값
		    int multiNum = num - 1;
		System.out.println("Position " + divFg + " multiNum: " + multiNum);  // 해당 위치의 multiNum 출력
	   
	}
}