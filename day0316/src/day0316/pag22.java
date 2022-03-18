package day0316;

public class pag22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int num = 5;
//		if(num%2==0)
//		{
//			System.out.println("Â¦¼ö");
//		}
//		else
//		{
//			System.out.println("È¦¼ö");
//		}
		int num =5;
		String c = "a´Â Â¦¼ö´Ù";
		String d = "a´Â  È¦¼ö´Ù";
		
		String e = (num%2==0)?c:d;
		System.out.println(e);
	}

}
