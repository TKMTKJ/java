package day0316;

import java.util.Scanner;

public class peg40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("����������?");
		int no1 = sc.nextInt();
		int b1 = no1;
		System.out.println("����������?");
		int no2 = sc.nextInt();
		int b2= no2;
		System.out.println("����������?");
		int no3 = sc.nextInt();
		int b3=no3;
		System.out.println("����������?");
		int no4 = sc.nextInt();
		int b4=no4;
		System.out.println("����������?");
		int no5 = sc.nextInt();
		int b5=no5;
		
		int res = no1+no2+no3+no4+no5;
		double res2=res/5.0;
		System.out.printf("�հ��:%d �����:%.1f�Դϴ�", res,res2);
	}

}
