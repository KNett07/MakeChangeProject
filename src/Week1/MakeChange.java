package Week1;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {
		
		Scanner kb = new Scanner(System.in);
		
		
		double price;
		double cash;
		
		System.out.print("Please enter the total of the item/s you want to purchase: ");
		price = kb.nextDouble();
		System.out.print("Please enter the payment amount: ");
		cash = kb.nextDouble();
		
		int penny = (int) (cash - price) * 100;
		
		int dollar = penny / 100;
		penny = penny % 100;
		
		int five = dollar / 5;
		int ten = dollar / 10;
		int twenty = dollar / 20;
		
		int quarter = penny / 25;
		penny = penny % 25;
		
		int dime = penny / 10;
		penny = penny % 10;
		
		int nickel = penny / 5;
		penny = penny % 5;
		
		
		System.out.print("Your change today is: ");
		
		
		
		
		 if (penny % penny == 0) {
			System.out.println(penny + " pennies");
		}  
		 else if (nickel % penny == 0) {
			System.out.println(nickel + " nickels");
		}  
		 else if (dime % penny == 0) {
			System.out.println(dime + " dimes");
		}  
		 else if(quarter % penny == 0) {
			System.out.println(quarter + " quarters");
		} 
		 else if (dollar % penny == 0) {
				System.out.println(dollar + " dollars");
		} 
		 else if (five % penny == 0) {
			System.out.println(five + " five dollar bills");
		} 
		 else if (ten % penny == 0) {
			System.out.println(ten + " ten dollar bills");
		} 
		 else if (twenty % penny == 0) {
			System.out.println(twenty + " twenty dollar bills");
		} 
		 else if (price == cash) {
			System.out.println("You provided the exact amount, thanks have a great day!");
		} 
		 else {
			System.out.println("Not a valid choice, please try again.");
		}
		
	
		 kb.close();
		
	}
	}

