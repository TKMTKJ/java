package charcter;

import java.util.Scanner;

public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner (System.in);
		Character character = null;
		PlayGame pg= null;
		System.out.println("원하는 캐릭터를 선택하십시요. \n 1.피카츄 2.꼬북이 3.이상해씨 4.파이리");
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
		System.out.println("energy  0 이하가 되면 게임이 종료됩니다");
		System.out.println("현제 캐릭터의 정보출력");
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
		System.out.println("피카츄가 생성되었습니다.");
		System.out.println("피카츄의 특성");
		System.out.println("밥먹이기 energy 5증가 \n잠재우기 energy 10 증가 \n놀아주기 exp 5 증가 energy10 감소\n운동시키키 exp 10증가 energy20감소\nexp가 40이되면 levelUp 합니다\nlevelUp hp10증가" );
		printInfo();
	}
	public void eat()
	{
		energy = energy +10;
		System.out.println("피카츄가 밥을 먹었습니다");
		System.out.println("energy가 10 상승합니다");
		System.out.println("");
	}
	public void sleep()
	{
		energy = energy +5;
		System.out.println("피카츄가 잠에 듭니다");
		System.out.println("energy가  5 상승합니다");
		System.out.println("");
	}
	public boolean play()
	{
		energy=energy-10;
		exp=exp+5;
		System.out.println("피카츄가 신나합니다");
		System.out.println("energy 10감소합니다");
		System.out.println("exp가 5 증가합니다");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -20;
		exp=exp+10;
		System.out.println("피카츄가 운동을 합니다");
		System.out.println("energy 20 감소합니다");
		System.out.println("exp가 10 증가합니다");

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
			System.out.println("레벨업!!");
			System.out.println("hp 10 증가합니다!!");

		}
	}
}
class Gobook extends Characte
{
	Gobook()
	{
		hp = 40;
		energy = 50;
		System.out.println("꼬북이가 생성되었습니다.");
		System.out.println("꼬북이의 특성");
		System.out.println("밥먹이기 energy 15증가 \n잠재우기 energy 10 증가 \n놀아주기 exp 15 증가 energy30 감소\n운동시키키 exp 30증가 energy20감소\nexp가 50이되면 levelUp 합니다 \nlevelUp hp20증가" );
		printInfo();
	}
	public void eat()
	{
		energy = energy +15;
		System.out.println("꼬북이가 밥을 먹었습니다");
		System.out.println("energy 15 상승합니다");
		System.out.println("");
	}
	public void sleep()
	{
		energy = energy +10;
		System.out.println("꼬북이가 잠에 듭니다");
		System.out.println("energy  10 상승합니다");
		System.out.println("");
	}
	public boolean play()
	{
		energy=energy-30;
		exp=exp+15;
		System.out.println("꼬북이가 신나합니다");
		System.out.println("energy 30감소합니다");
		System.out.println("exp가 15 증가합니다");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -20;
		exp=exp+30;
		System.out.println("꼬북이가 운동을 합니다");
		System.out.println("energy 20 감소합니다");
		System.out.println("exp 30 증가합니다");
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
			System.out.println("레벨업!!");
			System.out.println("hp 20 증가합니다!!");
		}
	}
}
class Lee extends Characte
{
	Lee()
	{
		hp = 20;
		energy = 30;
		System.out.println("이상해씨가 생성되었습니다.");
		System.out.println("이상해씨의 특성");
		System.out.println("밥먹이기 energy 5 증가 \n잠재우기 energy 20 증가 \n놀아주기 exp 15 증가 energy10 감소\n운동시키키 exp 20증가 energy10감소\nexp가 35이되면 levelUp 합니다 \nlevelUp hp10증가" );
		printInfo();
	}
	public void eat()
	{
		energy = energy +5;
		System.out.println("이상해씨가 밥을 먹었습니다");
		System.out.println("energy 5 상승합니다");
		System.out.println("");
	}
	public void sleep()
	{
		energy = energy +20;
		System.out.println("이상해씨가 잠에 듭니다");
		System.out.println("energy  20 상승합니다");
		System.out.println("");
	}
	public boolean play()
	{
		energy=energy-10;
		exp=exp+15;
		System.out.println("이상해씨가 신나합니다");
		System.out.println("energy 10 감소합니다");
		System.out.println("exp 15 증가합니다");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -10;
		exp=exp+20;
		System.out.println("이상해씨가 운동을 합니다");
		System.out.println("energy 10 감소합니다");
		System.out.println("exp 20 증가합니다");
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
			System.out.println("레벨업!!");
			System.out.println("hp 10 증가합니다");
		}
	}
}
class  Pel extends Characte
{
	Pel()
	{
		hp = 40;
		energy = 60;
		System.out.println("파이리가 생성되었습니다.");
		System.out.println("피이리의 특성");
		System.out.println("밥먹이기 energy 20증가 \n잠재우기 energy 5 증가 \n놀아주기 exp 20 증가 energy40 감소\n운동시키키 exp 5증가 energy20감소\nexp가 50이되면 levelUp 합니다\nlevelUp hp10증가" );
		printInfo();
	}
	public void eat()
	{
		energy = energy +20;
		System.out.println("파이리가 밥을 먹었습니다");
		System.out.println("energy가 20 상승합니다");
		System.out.println("");
	}
	public void sleep()
	{
		energy = energy +5;
		System.out.println("파이리가 잠에 듭니다");
		System.out.println("energy가  5 상승합니다");
		System.out.println("");
	}
	public boolean play()
	{
		energy=energy-40;
		exp=exp+20;
		System.out.println("파이리가 신나합니다");
		System.out.println("energy 40감소합니다");
		System.out.println("exp가 20 증가합니다");
		System.out.println("");
		levelUp();
		return chekEnergy();
	}
	public boolean train() {
		energy=energy -20;
		exp=exp+5;
		System.out.println("피이리가 운동을 합니다");
		System.out.println("energy 20 감소합니다");
		System.out.println("exp가 5 증가합니다");

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
			System.out.println("레벨업!!");
			System.out.println("hp 10 증가합니다!!");

		}
	}
}