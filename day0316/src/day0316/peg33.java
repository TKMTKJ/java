package day0316;

import java.util.Scanner;

public class peg33 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc =new Scanner(System.in);
			System.out.println("점수를 입력 하세요");
			int a = sc.nextInt();
			
			
			if (a>=90)
			{
				System.out.println("A");
			}
			else if (a>=80)
			{
				System.out.println("B");
			}
			else if (a>=70)
			{
				System.out.println("C");
			}
			else if (a>=60)
			{
				System.out.println("D");
			}
			else
			{
				System.out.println("F");
			}
	}

}
