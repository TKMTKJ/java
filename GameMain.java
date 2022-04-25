package charcter;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		Character character = null;
		PlayGame pg= null;
		System.out.println("���ϴ� ĳ���͸� �����Ͻʽÿ�. \n 1.��ī�� 2.������ 3.�̻��ؾ�");
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
abstract class Character
{
	protected int hp;
	protected int energy;
	protected int level;
	
	
	
	public abstract void eat();
	public abstract void sleep();
	public abstract boolean play();
	public abstract boolean train();
	public abstract void levelUp();
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
		System.out.println("���� ĳ������ �������");
		System.out.println("hp ="+hp);
		System.out.println("energy = "+energy);
		System.out.println("level ="+level);
	}
}
class Picachu extends Character
{
	Picachu()
	{
		hp = 30;
		energy = 50;
		System.out.println("��ī�� �����Ǿ����ϴ�.");
		
		printInfo();
	}
	public void eat()
	{
		energy = energy +10;
		System.out.println("��ī�� ���� �Ծ����ϴ�");
		System.out.println("�������� ����մϴ�");
	}
	public void sleep()
	{
		energy = energy +5;
		System.out.println("��ī�� �ῡ ��ϴ�");
		System.out.println("�������� ����մϴ�");
	}
	public boolean play()
	{
		energy=energy-20;
		hp=hp+5;
		System.out.println("��ī�� �ų��մϴ�");
		System.out.println("�������� �����մϴ�");
		System.out.println("�������� 0�̵Ǹ� ������ ����˴ϴ�");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -15;
		hp=hp+5;
		System.out.println("��ī�� ��� �մϴ�");
		System.out.println("�������� �����մϴ�");
		System.out.println("�������� 0�̵Ǹ� ������ ����˴ϴ�");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (hp>= 40)
		{
			
			level++;
			hp=hp-40;
			System.out.println("������!!");
		}
	}
}
class Gobook extends Character
{
	Gobook()
	{
		hp = 40;
		energy = 50;
		System.out.println("�����̰� �����Ǿ����ϴ�.");
		printInfo();
	}
	public void eat()
	{
		energy = energy +15;
		System.out.println("�����̰� ���� �Ծ����ϴ�");
		System.out.println("�������� ����մϴ�");
	}
	public void sleep()
	{
		energy = energy +10;
		System.out.println("�����̰� �ῡ ��ϴ�");
		System.out.println("�������� ����մϴ�");
	}
	public boolean play()
	{
		energy=energy-30;
		hp=hp+15;
		System.out.println("�����̰� �ų��մϴ�");
		System.out.println("�������� �����մϴ�");
		System.out.println("�������� 0�̵Ǹ� ������ ����˴ϴ�");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -20;
		hp=hp+30;
		System.out.println("�����̰� ��� �մϴ�");
		System.out.println("�������� �����մϴ�");
		System.out.println("�������� 0�̵Ǹ� ������ ����˴ϴ�");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (hp>= 50)
		{
			level++;
			hp=hp-50;
			System.out.println("������!!");
		}
	}
}
class Lee extends Character
{
	Lee()
	{
		hp = 20;
		energy = 30;
		System.out.println("�̻��ؾ��� �����Ǿ����ϴ�.");
		printInfo();
	}
	public void eat()
	{
		energy = energy +5;
		System.out.println("�̻��ؾ��� ���� �Ծ����ϴ�");
		System.out.println("�������� ����մϴ�");
	}
	public void sleep()
	{
		energy = energy +20;
		System.out.println("�̻��ؾ��� �ῡ ��ϴ�");
	}
	public boolean play()
	{
		energy=energy-10;
		hp=hp+15;
		System.out.println("�̻��ؾ��� �ų��մϴ�");
		System.out.println("�������� �����մϴ�");
		System.out.println("�������� 0�̵Ǹ� ������ ����˴ϴ�");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -10;
		hp=hp+20;
		System.out.println("�̻��ؾ��� ��� �մϴ�");
		System.out.println("�������� �����մϴ�");
		System.out.println("�������� 0�̵Ǹ� ������ ����˴ϴ�");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (hp>= 35)
		{
			
			level++;
			hp=hp-35;
			System.out.println("������!!");
		}
	}
}


