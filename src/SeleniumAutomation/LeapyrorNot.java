package SeleniumAutomation;

import java.util.Scanner;

public class LeapyrorNot {

	public static void main(String[] args) {
		
		long year;
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("enter the year");
				year= in.nextLong();
		if(year%4==0)
		{
			System.out.println("entered number is"+year+" " +"is a Leap year");
			
		}
		else
		{
			System.out.println("entered number is"+year+" " +"is not a Leap year");
		}
			
				

	}

}
