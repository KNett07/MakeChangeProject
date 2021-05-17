package Week1;

import java.util.Scanner;

public class MakeChange {

	public static void main(String[] args) {

		Scanner kb = new Scanner(System.in);

		double price = 0.0;
		double cash = 0.0;
		double penny = 0.0;
		double nickel = 0.0;
		double dime = 0.0;
		double quarter = 0.0;
		double dollar = 0.0;
		double five = 0.0;
		double ten = 0.0;
		double twenty = 0.0;

		System.out.print("Please enter the total of the item/s you want to purchase: ");
		price = kb.nextDouble();
		System.out.print("Please enter the payment amount: ");
		cash = kb.nextDouble();
		System.out.print("Your change today is: ");

		double change = (cash - price);
		penny = change * 100;
		nickel = penny / 5;
		dime = penny / 10;
		quarter = penny / 25;
		dollar = penny / 100;
		five = dollar / 5;
		ten = dollar / 10;
		twenty = dollar / 20;

		if (cash == price) {
			System.out.println("This is the exact amount, thanks have a nice day!");
		}
		if (change < 0) {
			System.out.println("This is not enough money to purchase this item, try again.");
		} else if (twenty >= 20) {
			System.out.println(twenty + " twenty dollar bills");
		} else if (ten >= 10) {
			System.out.println(ten + " ten dollar bills");
		} else if (five >= 5) {
			System.out.println(five + " five dollar bills");
		} else if (dollar >= 1) {
			System.out.println(dollar + " dollars");
		} else if (quarter >= .25) {
			System.out.println(quarter + " quarters");
		} else if (dime >= .10) {
			System.out.println(dime + " dimes");
		} else if (nickel >= .05) {
			System.out.println(nickel + " nickels");
		} else if (penny >= .01) {
			System.out.println(penny + " pennies");
		} else {
			System.out.println("Invalid selection please try again.");
		}
		kb.close();
	}
}
