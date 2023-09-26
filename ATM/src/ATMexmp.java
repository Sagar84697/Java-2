import java.util.Scanner;

class InvalidAccnoException extends Exception
{
	public String getMessage()
	{
		return "wrong accno has been entered";
	}
}
class InvalidPasswordException extends Exception
{
	public String getMessage()
	{
		return "wrong password has been entered";
	}
}
class ATM
{
	int accno = 1234, password=1111;
	int accNumber,pass;
	Scanner sc=new Scanner(System.in);
	void input() {
		System.out.println("enter account no");
		accNumber=sc.nextInt();
		System.out.println("enter password");
		pass=sc.nextInt();
	}
	void verify() throws InvalidAccnoException,InvalidPasswordException{
		if(accno==accNumber) {
			if(pass==password) {
				collectMoney();
			}
			else {
				InvalidPasswordException ipe= new InvalidPasswordException();
				System.out.println(ipe.getMessage());
				throw ipe;
			}
		}
		else {
			InvalidAccnoException iae= new InvalidAccnoException();
			System.out.println(iae.getMessage());
			throw iae;
		}
	}
	void collectMoney()
	{
		System.out.println("collect your money");
	}
}
class Bank
{
	static ATM atm = new ATM();
	static void permit()
	{
		try {
			atm.input();
			atm.verify();
		}
		catch(Exception e)
		{
			System.out.println("1 chance is over");

			try {
				atm.input();
				atm.verify();
			}
			catch(Exception e1)
			{
				System.out.println("2 chance is over");

				try {
					atm.input();
					atm.verify();
				}
				catch(Exception e2)
				{
					System.out.println("3 chance is over");
					System.out.println("card is blocked");
					System.exit(0);
				}
			}
		}
	}
}
public class ATMexmp {

	public static void main(String[] args) {
		Bank.permit();

	}

}
