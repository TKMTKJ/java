package day0316;

import java.util.Scanner;

public class peg40 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("국어점수는?");
		int no1 = sc.nextInt();
		int b1 = no1;
		System.out.println("영어점수는?");
		int no2 = sc.nextInt();
		int b2= no2;
		System.out.println("수학점수는?");
		int no3 = sc.nextInt();
		int b3=no3;
		System.out.println("과학점수는?");
		int no4 = sc.nextInt();
		int b4=no4;
		System.out.println("음악점수는?");
		int no5 = sc.nextInt();
		int b5=no5;
		
		int res = no1+no2+no3+no4+no5;
		double res2=res/5.0;
		System.out.printf("합계는:%d 평균은:%.1f입니다", res,res2);
	}

}
