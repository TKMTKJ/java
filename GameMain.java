package charcter;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		Character character = null;
		PlayGame pg= null;
		System.out.println("���ϴ� ĳ���͸� �����Ͻʽÿ�. \n 1.��ī�� 2.������ 3.�̻��ؾ� 4.���̸�");
		int x = sc.nextInt();

		switch (x)
		{
		case 1:
			character = new Picachu();
			break;
		case 2:
			character = new Gobook();
			break;
		case 3:
			character = new Lee();
			break;
		case 4:
			character = new Pel();
			break;
		default:
			System.out.println("�߸������ϼ̽��ϴ�");
		}

		if (character == null)
		{
			System.out.println("������ �����մϴ�");
			return;
		}
		else
		{
			pg = new PlayGame(character);
		}
		while(true)
		{
			pg.printMenu(sc);
			if(pg.isExit())
			{
				System.out.println("������ �����մϴ�");
				break;

			}
		}
	}
}
class PlayGame
	{
	private Character character;
	private int menu;
	private boolean exit;

	public PlayGame(Character character)
	{
		this.character=character;
	}
	public void printMenu(Scanner sc)
	{
		System.out.println("1.����̱� 2.������ 3.����ֱ� 4.���ŰŰ 5.����");
		menu=sc.nextInt();
		play();
	}
	public void play()
	{

		switch(menu)
		{
		case 1:
			character.eat();
			break;
		case 2: 
			character.sleep();
			break;
		case 3:
			exit = character.play();
			break;
		case 4:
			exit = character.train();
			break;
		case 5:
			exit = true;
			break;
		}
		character.printInfo();
	}
	public Character getCharacter()
	{
		return character;
	}
	public void setCharacter(Character character)
	{
		this.character=character;
	}
	public int getMenu()
	{
		return menu;
	}
	public void setMenu(int menu)
	{
		this.menu = menu;
	}
	public boolean isExit()
	{
		return exit;
	}
	public void setExit(boolean exit)
	{
		this.exit=exit;
	}

}
abstract class Characte implements Character
{
	
	protected int hp;
	protected int exp;
	protected int energy;
	protected int level;
	Characte()
	{
		level=1;
		exp=0;
	}
	public boolean chekEnergy()//������ üũ
	{
		boolean ret = false;//�������� 0�� �Ǿ� ���� �����Ҽ� �ֵ��� flag ������ ��.		if (energy <=0)
		if(energy <=0)
		{
			ret = true;
		}
		else 
		{
			ret=false;
		}
		return ret;
	}
	public void printInfo()//���� ���
	{
		System.out.println("energy  0 ���ϰ� �Ǹ� ������ ����˴ϴ�");
		System.out.println("���� ĳ������ �������");
		System.out.println("hp ="+hp);
		System.out.println("exp="+exp);
		System.out.println("energy = "+energy);
		System.out.println("level ="+level);
	}
}
interface Character 
{
	public abstract void eat();
	public abstract void sleep();
	public abstract boolean play();
	public abstract boolean train();
	public abstract void levelUp();
	public abstract void printInfo();

}
class Picachu extends Characte 
{
	Picachu()
	{
		hp = 30;
		energy = 50;
		System.out.println("��ī�� �����Ǿ����ϴ�.");
		System.out.println("��ī���� Ư��");
		System.out.println("����̱� energy 5���� \n������ energy 10 ���� \n����ֱ� exp 5 ���� energy10 ����\n���ŰŰ exp 10���� energy20����\nexp�� 40�̵Ǹ� levelUp �մϴ�\nlevelUp hp10����" );
		printInfo();
	}
	public void eat()
	{
		energy = energy +10;
		System.out.println("��ī�� ���� �Ծ����ϴ�");
		System.out.println("energy�� 10 ����մϴ�");
		System.out.println("");
	}
	public void sleep()
	{
		energy = energy +5;
		System.out.println("��ī�� �ῡ ��ϴ�");
		System.out.println("energy��  5 ����մϴ�");
		System.out.println("");
	}
	public boolean play()
	{
		energy=energy-10;
		exp=exp+5;
		System.out.println("��ī�� �ų��մϴ�");
		System.out.println("energy 10�����մϴ�");
		System.out.println("exp�� 5 �����մϴ�");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -20;
		exp=exp+10;
		System.out.println("��ī�� ��� �մϴ�");
		System.out.println("energy 20 �����մϴ�");
		System.out.println("exp�� 10 �����մϴ�");

		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (exp>= 40)
		{

			level++;
			exp=exp-40;
			hp=hp+10;
			System.out.println("������!!");
			System.out.println("hp 10 �����մϴ�!!");

		}
	}
}
class Gobook extends Characte
{
	Gobook()
	{
		hp = 40;
		energy = 50;
		System.out.println("�����̰� �����Ǿ����ϴ�.");
		System.out.println("�������� Ư��");
		System.out.println("����̱� energy 15���� \n������ energy 10 ���� \n����ֱ� exp 15 ���� energy30 ����\n���ŰŰ exp 30���� energy20����\nexp�� 50�̵Ǹ� levelUp �մϴ� \nlevelUp hp20����" );
		printInfo();
	}
	public void eat()
	{
		energy = energy +15;
		System.out.println("�����̰� ���� �Ծ����ϴ�");
		System.out.println("energy 15 ����մϴ�");
		System.out.println("");
	}
	public void sleep()
	{
		energy = energy +10;
		System.out.println("�����̰� �ῡ ��ϴ�");
		System.out.println("energy  10 ����մϴ�");
		System.out.println("");
	}
	public boolean play()
	{
		energy=energy-30;
		exp=exp+15;
		System.out.println("�����̰� �ų��մϴ�");
		System.out.println("energy 30�����մϴ�");
		System.out.println("exp�� 15 �����մϴ�");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -20;
		exp=exp+30;
		System.out.println("�����̰� ��� �մϴ�");
		System.out.println("energy 20 �����մϴ�");
		System.out.println("exp 30 �����մϴ�");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (exp>= 50)
		{
			level++;
			exp=exp-50;
			hp=hp+20;
			System.out.println("������!!");
			System.out.println("hp 20 �����մϴ�!!");
		}
	}
}
class Lee extends Characte
{
	Lee()
	{
		hp = 20;
		energy = 30;
		System.out.println("�̻��ؾ��� �����Ǿ����ϴ�.");
		System.out.println("�̻��ؾ��� Ư��");
		System.out.println("����̱� energy 5 ���� \n������ energy 20 ���� \n����ֱ� exp 15 ���� energy10 ����\n���ŰŰ exp 20���� energy10����\nexp�� 35�̵Ǹ� levelUp �մϴ� \nlevelUp hp10����" );
		printInfo();
	}
	public void eat()
	{
		energy = energy +5;
		System.out.println("�̻��ؾ��� ���� �Ծ����ϴ�");
		System.out.println("energy 5 ����մϴ�");
		System.out.println("");
	}
	public void sleep()
	{
		energy = energy +20;
		System.out.println("�̻��ؾ��� �ῡ ��ϴ�");
		System.out.println("energy  20 ����մϴ�");
		System.out.println("");
	}
	public boolean play()
	{
		energy=energy-10;
		exp=exp+15;
		System.out.println("�̻��ؾ��� �ų��մϴ�");
		System.out.println("energy 10 �����մϴ�");
		System.out.println("exp 15 �����մϴ�");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -10;
		exp=exp+20;
		System.out.println("�̻��ؾ��� ��� �մϴ�");
		System.out.println("energy 10 �����մϴ�");
		System.out.println("exp 20 �����մϴ�");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (exp>= 35)
		{

			level++;
			exp=exp-35;
			hp=hp+10;
			System.out.println("������!!");
			System.out.println("hp 10 �����մϴ�");
		}
	}
}
class  Pel extends Characte
{
	Pel()
	{
		hp = 40;
		energy = 60;
		System.out.println("���̸��� �����Ǿ����ϴ�.");
		System.out.println("���̸��� Ư��");
		System.out.println("����̱� energy 20���� \n������ energy 5 ���� \n����ֱ� exp 20 ���� energy40 ����\n���ŰŰ exp 5���� energy20����\nexp�� 50�̵Ǹ� levelUp �մϴ�\nlevelUp hp10����" );
		printInfo();
	}
	public void eat()
	{
		energy = energy +20;
		System.out.println("���̸��� ���� �Ծ����ϴ�");
		System.out.println("energy�� 20 ����մϴ�");
		System.out.println("");
	}
	public void sleep()
	{
		energy = energy +5;
		System.out.println("���̸��� �ῡ ��ϴ�");
		System.out.println("energy��  5 ����մϴ�");
		System.out.println("");
	}
	public boolean play()
	{
		energy=energy-40;
		exp=exp+20;
		System.out.println("���̸��� �ų��մϴ�");
		System.out.println("energy 40�����մϴ�");
		System.out.println("exp�� 20 �����մϴ�");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -20;
		exp=exp+5;
		System.out.println("���̸��� ��� �մϴ�");
		System.out.println("energy 20 �����մϴ�");
		System.out.println("exp�� 5 �����մϴ�");

		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (exp>= 50)
		{

			level++;
			exp=exp-50;
			hp=hp+10;
			System.out.println("������!!");
			System.out.println("hp 10 �����մϴ�!!");

		}
	}
}