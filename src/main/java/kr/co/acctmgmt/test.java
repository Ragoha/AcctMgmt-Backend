package kr.co.acctmgmt;

public class test {
	public static void main(String[] args) {
		String temp = "��,�� ,�� ,�� ";
		String[] list= temp.split(",");
		 System.out.println(list[0]);
		 
		
		for(int i =0 ; i<list.length;i++) {
			list[i]=list[i].replace(" " , ".");
			System.out.println("����:" + list[i]+"|");
		}
	}
}