package kr.co.acctmgmt;

public class test {
	public static void main(String[] args) {
		String temp = "장,관 ,항 ,목 ";
		String[] list= temp.split(",");
		 System.out.println(list[0]);
		 
		
		for(int i =0 ; i<list.length;i++) {
			list[i]=list[i].replace(" " , ".");
			System.out.println("시작:" + list[i]+"|");
		}
	}
}