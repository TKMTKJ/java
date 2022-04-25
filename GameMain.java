package charcter;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		Character character = null;
		PlayGame pg= null;
		System.out.println("원하는 캐릭터를 선택하십시요. \n 1.피카츄 2.꼬북이 3.이상해씨");
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
			System.out.println("잘못선택하셨습니다");
		}
	
		if (character == null)
		{
			System.out.println("게임을 종료합니다");
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
				System.out.println("게임을 종료합니다");
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
		System.out.println("1.밥먹이기 2.잠재우기 3.놀아주기 4.운동시키키 5.종료");
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
	public boolean chekEnergy()//에너지 체크
	{
		boolean ret = false;//에너지가 0이 되어 게임 종료할수 있도록 flag 변수를 듬.		if (energy <=0)
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
	public void printInfo()//정보 출력
	{
		System.out.println("현제 캐릭터의 정보출력");
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
		System.out.println("피카츄가 생성되었습니다.");
		
		printInfo();
	}
	public void eat()
	{
		energy = energy +10;
		System.out.println("피카츄가 밥을 먹었습니다");
		System.out.println("에너지가 상승합니다");
	}
	public void sleep()
	{
		energy = energy +5;
		System.out.println("피카츄가 잠에 듭니다");
		System.out.println("에너지가 상승합니다");
	}
	public boolean play()
	{
		energy=energy-20;
		hp=hp+5;
		System.out.println("피카츄가 신나합니다");
		System.out.println("에너지가 감소합니다");
		System.out.println("에너지가 0이되면 게임이 종료됩니다");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -15;
		hp=hp+5;
		System.out.println("피카츄가 운동을 합니다");
		System.out.println("에너지가 감소합니다");
		System.out.println("에너지가 0이되면 게임이 종료됩니다");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (hp>= 40)
		{
			
			level++;
			hp=hp-40;
			System.out.println("레벨업!!");
		}
	}
}
class Gobook extends Character
{
	Gobook()
	{
		hp = 40;
		energy = 50;
		System.out.println("꼬북이가 생성되었습니다.");
		printInfo();
	}
	public void eat()
	{
		energy = energy +15;
		System.out.println("꼬북이가 밥을 먹었습니다");
		System.out.println("에너지가 상승합니다");
	}
	public void sleep()
	{
		energy = energy +10;
		System.out.println("꼬북이가 잠에 듭니다");
		System.out.println("에너지가 상승합니다");
	}
	public boolean play()
	{
		energy=energy-30;
		hp=hp+15;
		System.out.println("꼬북이가 신나합니다");
		System.out.println("에너지가 감소합니다");
		System.out.println("에너지가 0이되면 게임이 종료됩니다");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -20;
		hp=hp+30;
		System.out.println("꼬북이가 운동을 합니다");
		System.out.println("에너지가 감소합니다");
		System.out.println("에너지가 0이되면 게임이 종료됩니다");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (hp>= 50)
		{
			level++;
			hp=hp-50;
			System.out.println("레벨업!!");
		}
	}
}
class Lee extends Character
{
	Lee()
	{
		hp = 20;
		energy = 30;
		System.out.println("이상해씨가 생성되었습니다.");
		printInfo();
	}
	public void eat()
	{
		energy = energy +5;
		System.out.println("이상해씨가 밥을 먹었습니다");
		System.out.println("에너지가 상승합니다");
	}
	public void sleep()
	{
		energy = energy +20;
		System.out.println("이상해씨가 잠에 듭니다");
	}
	public boolean play()
	{
		energy=energy-10;
		hp=hp+15;
		System.out.println("이상해씨가 신나합니다");
		System.out.println("에너지가 감소합니다");
		System.out.println("에너지가 0이되면 게임이 종료됩니다");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -10;
		hp=hp+20;
		System.out.println("이상해씨가 운동을 합니다");
		System.out.println("에너지가 감소합니다");
		System.out.println("에너지가 0이되면 게임이 종료됩니다");
		levelUp();
		return chekEnergy();
	}
	public void levelUp()
	{
		if (hp>= 35)
		{
			
			level++;
			hp=hp-35;
			System.out.println("레벨업!!");
		}
	}
}


