package day0316;

import java.util.Scanner;
 

public class peg21 {

	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("소문자를 입력 하시요");
		char a = sc.next().charAt(0);
		
		System.out.println((char)(a - 32));
	}

}
