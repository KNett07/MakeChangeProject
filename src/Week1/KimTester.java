package Week1;

import java.util.Scanner;

public class KimTester {


	public static void main(String [] args) {

			//Gathering inputs
			Scanner kb = new Scanner(System.in);
			
			System.out.println("Please enter the item total");
			Double price = kb.nextDouble();

			System.out.println("Please enter the amount tendered");
			Double amountTendered = kb.nextDouble();


			if (isAmountTenderedMoreThanPrice(price, amountTendered)) {	
				
			if (isAmountSameAsPrice(price, amountTendered)) {	
					System.out.println("This is the exact amount.  Thanks and have a great day!");
				} else {
					System.out.println("You gave me more than enough!");
				}

				Double change = amountTendered - price;	
				change = cutToTwoDecimalPlaces(change);		
				int dollarAmount = (int) change.doubleValue();	
				Double dollarAmountD = Double.valueOf(dollarAmount); 

				Double coinChangeAmount = change - dollarAmountD;
				coinChangeAmount = cutToTwoDecimalPlaces(coinChangeAmount);

				int numQuarters = determineHowManyQuarters(coinChangeAmount);
				Double coinsWithoutQuarters = updatePriceRemoveQuarters(numQuarters, coinChangeAmount);	//<-- amended change less quarters
				coinsWithoutQuarters = cutToTwoDecimalPlaces(coinsWithoutQuarters);

				int numDimes = determineHowManyDimes(coinsWithoutQuarters); 
				Double coinsWithoutDimes = updatePriceRemoveDimes(numDimes, coinsWithoutQuarters);	//<-- less dimes
				coinsWithoutDimes = cutToTwoDecimalPlaces(coinsWithoutDimes);

				int numNickels = determineHowManyNickels(coinsWithoutDimes);
				Double coinsWithoutNickels = 0.0D;
				coinsWithoutNickels = updatePriceRemoveNickels(numNickels, coinsWithoutDimes);	//<-- less nickels

				Double penniesDouble = coinsWithoutNickels * 100.0;
				int numPennies = (int) penniesDouble.doubleValue();

				printFinalResults(dollarAmount, numQuarters, numDimes, numNickels, numPennies);	//<-- finish line

			} else {	//<-- Haven't provided enough money to cover price
				System.out.println("You did not give me enough");
			}
		}

	private static double updatePriceRemoveNickels(int numN, Double beforePrice) {
			
			Double pennies = 0.0d;

			if (beforePrice >= .05) {
				pennies = beforePrice - .05;
			} else {
				pennies = beforePrice;
			}

			return pennies;
		}

	private static double updatePriceRemoveDimes(int numD, Double beforePrice) {
			Double dimeValue = Double.valueOf(numD);
			dimeValue = dimeValue / 10.0;
			Double r = beforePrice - dimeValue;

			return r;
		}

	private static double updatePriceRemoveQuarters(int numQ, Double beforePrice) {
			Double quarterValue = 0.0D;

			switch(numQ) {
				case (1):
					quarterValue = .25D;
					break;
				case(2): 
					quarterValue = .5D;
					break;
				case (3):
					quarterValue = .75D;
					break;
				case (0):
					return beforePrice;
				default:
					System.out.println("WHAT THE FUCK ");
					System.exit(0);
			}
			
			return beforePrice - quarterValue;
		}

	private static int determineHowManyQuarters(Double coinChangeAmount) {
			
			if (coinChangeAmount > .75) {
				return 3;
			} else if (coinChangeAmount >= .5 && coinChangeAmount < .75) {
				return 2;
			} else if (coinChangeAmount >= .25 && coinChangeAmount < .5) {
				return 1;
			} else {
				return 0;
			}
		}

	private static int determineHowManyDimes(Double coinChangeAmount) {

			if (coinChangeAmount < .1) {
				return 0;
			} else if (coinChangeAmount >= .1 && coinChangeAmount < .2) {
				return 1;
			} else if (coinChangeAmount >= .2 && coinChangeAmount < .25) {
				return 2;
			} else {
				System.out.println("Error determing dimes: " + coinChangeAmount);
			}

			return 9999;
		}

	private static int determineHowManyNickels(Double coinChangeAmount) {

			if (coinChangeAmount < .05) {
				return 0;
			} else if (coinChangeAmount >= .05 && coinChangeAmount < .1) {
				return 1;
			} else {
				System.out.println("Error determining nickels: " + coinChangeAmount);
				return 999;
			}
		}

	private static int determineHowManyPennies(Double coinChangeAmount) {
			System.out.println("Pennies: " + coinChangeAmount);
			if (coinChangeAmount == 0.0) {
				return 0;
			} else if (coinChangeAmount > 0 && coinChangeAmount <= .04) {
				coinChangeAmount = coinChangeAmount * 10.0;

				int pennies = (int) coinChangeAmount.doubleValue();

				return pennies;
			}

			return 9999;
		}

	private static boolean isAmountTenderedMoreThanPrice(Double p, Double a) {
			System.out.println("\nIn That boolean function with the long name\n");
			if (a >= p) {
				return true;
			} else {
				return false;
			}
		}

	private static boolean isAmountSameAsPrice(Double price, Double amount) {
			if (amount.equals(price)) {
				return true;
			} else {
				return false;
			}
		}

	private static double cutToTwoDecimalPlaces(Double d) {
			String sValue = (String) String.format("%.2f", d);
	 		Double newValue = Double.parseDouble(sValue);

	 		return newValue;
		}

	private static void printFinalResults(int numBills, int numQuarters, int numDimes, int numNickels, int numPennies) {
			System.out.println(numBills + " " + numQuarters + " " + numDimes + " " + numNickels + " " + numPennies);	//Pelham
			
	}

}
