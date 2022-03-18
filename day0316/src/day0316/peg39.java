package day0316;

import java.util.Scanner;

public class peg39 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("밑변은?");
		int a = sc.nextInt();
		System.out.println("높이는?");
		int b = sc.nextInt();
		double f=a*b/2;
		System.out.println("삼각형의 넒이는"+f+"입니다");
	}

}
