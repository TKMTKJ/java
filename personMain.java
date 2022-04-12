
public class personMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		person hong = new person();
		hong.input("È«±æµ¿", 20, "¼­¿ï");
		person.countperson++;
		
		person lee = new person();
		lee.input("ÀÌ¸ù·æ", 30, "Á¦Ãµ");
		person.countperson++;
		
		person sung = new person();
		sung.input("¼ºÃáÇâ", 40, "ÀÎÃµ");
		person.countperson++;
		
		hong.printInstance();
		
		person.print();
		hong.print();
	}

}
class person
{
	static int countperson;
	String name;
	int age;
	String address;
	
	void input(String _name, int _age, String _address)
	{
		name = _name;
		age = _age;
		address = _address;
	}
	static void print()
	{
		System.out.println(countperson);
		System.out.println(name);
		System.out.println(age);
		System.out.println(address);
		printInstance();
	}
	static void printInstance()
	{
		System.out.println(name);
	}
}