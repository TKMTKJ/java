
public class personMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		person hong = new person();
		hong.input("ȫ�浿", 20, "����");
		person.countperson++;
		
		person lee = new person();
		lee.input("�̸���", 30, "��õ");
		person.countperson++;
		
		person sung = new person();
		sung.input("������", 40, "��õ");
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