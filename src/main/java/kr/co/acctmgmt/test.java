package kr.co.acctmgmt;

public class test {
	public static void main(String[] args) {
		String bgtCd = "11119000";
		int divFg = 5; // ���� ��� 4�� ��ġ�� multiNum ���� �˰� �ʹٸ�
		    // �ش� ��ġ�� ���ڸ� ������
		    int num = Character.getNumericValue(bgtCd.charAt(divFg-1));
		    // �ش� ��ġ�� multiNum�� ���ڿ��� 1�� �� ��
		    int multiNum = num - 1;
		System.out.println("Position " + divFg + " multiNum: " + multiNum);  // �ش� ��ġ�� multiNum ���
	   
	}
}