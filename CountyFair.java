package countyFair;
import java.util.Scanner;
import java.util.Random;

public class CountyFair {

	public static void main(String[] args) 
	{
		String game1Result="", game2Result="", game3Result="", game4Result="";
		double game1Value=0.0, game2Value=0.0, game3Value=0.0, game4Value=0.0;
		boolean game1BP=false, game2BP=false, game3BP=false, game4BP=false;
		String game1Desc="", game2Desc="", game3Desc="", game4Desc="";
		int bpCount=0;
		
		// generate 0 or 1 for the coin toss
		// Game 1: Flip a coin
		int coinFlip;
		coinFlip=(int)(Math.random()*2)+1; // generates 1 or 2
		if (coinFlip==1)
		{
			game1Result="flipped heads";
			game1Value=9.99;
			game1BP=false;
			game1Desc="Smartphone Charger";
		}
		else
		{
			game1Result="flipped tails";
			game1Value=.49;
			game1BP=true;
			game1Desc="Battery and Wire";
			++bpCount;  //add one to booby price counter if this is the booby prize for this game
		}
		
		// Game 2: Roll a six-sided die
		int dieToss;
		dieToss=(int)(Math.random()*6)+1; // generates between 1 and 6
		
		switch(dieToss)
		{
		case 1: game2Result="threw 1";
				game2Value=1.49;
				game2BP=false;
				game2Desc="Refrig Magnet";
				break;
		case 2: game2Result="threw 2";
				game2Value=.59;
				game2BP=true;
				game2Desc="Grocery Bag";
				break;
		case 3: game2Result="threw 3";
				game2Value=4.00;
				game2BP=false;
				game2Desc="Half-Price Ticket";
				break;
		case 4: game2Result="threw 4";
				game2Value=12.00;
				game2BP=false;
				game2Desc="CD of Hits";
				break;
		case 5: game2Result="threw 5";
				game2Value=5.00;
				game2BP=false;
				game2Desc="Concession Coupon";
				break;
		case 6: game2Result="threw 6";
				game2Value=8.00;
				game2BP=false;
				game2Desc="Stuffed Penguin";
				break;
		}
		
		// Game 3: Spin a roulette wheel
		int rouletteSpin, rouletteColorVal;
		String color;
		rouletteSpin=(int)(Math.random()*100)+1; // generates between 1 and 100
		rouletteColorVal=(int)(Math.random()*2)+1; // generates between 1 (red) and 2 (black)
		color=((rouletteColorVal==1)?"Red":"Black");  // conditional operator ?: (the only ternary operator - takes 3 operands)
		/*
		if (rouletteColorVal==1)
		  color="Red";
		else
		  color="Black";
		 */
		int multiplier = ((rouletteColorVal==1)?2:3);
		if (rouletteSpin>=1 && rouletteSpin <=20)
		{
			game3Result="Spun "+rouletteSpin+ " " + color;
			game3Value=.01 * multiplier;
			game3BP=true;
			game3Desc="Earn "  + game3Value;
		}
		else if (rouletteSpin>=21 && rouletteSpin <=40)
		{
			game3Result="Spun "+rouletteSpin+ " " + color;
			game3Value=4.0 * multiplier;
			game3BP=false;
			game3Desc="Earn " + game3Value;
		}
		else if (rouletteSpin>=41 && rouletteSpin <=60)
		{
			game3Result="Spun "+rouletteSpin+ " " + color;
			game3Value=1.0 * multiplier;
			game3BP=false;
			game3Desc="Earn " + game3Value;
		}
		else if (rouletteSpin>=61 && rouletteSpin <=80)
		{
			game3Result="Spun "+rouletteSpin+ " " + color;
			game3Value=2.0 * multiplier;
			game3BP=false;
			game3Desc="Earn " + game3Value;
		}
		else
		{
			game3Result="Spun "+rouletteSpin+ " " + color;
			game3Value=3.0 * multiplier;
			game3BP=false;
			game3Desc="Earn " + game3Value;
		}
		
		// Game 4: Draw a card
		int cardDraw=(int)(Math.random()*13)+2;
		int cardSuit=(int)(Math.random()*4)+1;
		String suitName="";
		switch(cardSuit)
		{
		case 1: suitName="Clubs";
			     break;
		case 2: suitName="Diamonds";
	     		break;
		case 3: suitName="Hearts";
	     		break;
		case 4: suitName="Spades";
	     		break;
		}
		
		if (cardDraw>=2 && cardDraw<=10) 
		{
			game4Result="Drew "+cardDraw+ " of " + suitName;
			game4Value=1.0 * cardSuit;
			game4BP=false;
			game4Desc="Card Deck";
		}
		else if(cardDraw==11)
		{
			game4Result="Drew Jack of " + suitName;
			game4Value=.50 * cardSuit;
			game4BP=true;
			game4Desc="Game of Jacks";
			++bpCount;
		}
		else if (cardDraw==12)
		{
			game4Result="Drew Queen of " + suitName;
			game4Value=2.00 * cardSuit;
			game4BP=false;
			game4Desc="Fair Queen Photo";
		}
		else if (cardDraw==12)
		{
			game4Result="Drew King of " + suitName;
			game4Value=2.00 * cardSuit;
			game4BP=false;
			game4Desc="Fair King Photo";
		}
		else
		{
			game4Result="Drew Ace of " + suitName;
			game4Value=10.00 * cardSuit;
			game4BP=false;
			game4Desc="$10 Cash";
		}
		
		// heading
		System.out.printf("%-10s%-20s%5s%15s%20s%n", "Game #", "Result", "Value", "Prize", "Desc");
		
		System.out.printf("%-10d%-20s%5.2f%15s%20s%n", 1, game1Result, game1Value, game1BP, game1Desc);
		System.out.printf("%-10d%-20s%5.2f%15s%20s%n", 2, game2Result, game2Value, game2BP, game2Desc);
		System.out.printf("%-10d%-20s%5.2f%15s%20s%n", 3, game3Result, game3Value, game3BP, game3Desc);
		System.out.printf("%-10d%-20s%5.2f%15s%20s%n", 4, game4Result, game4Value, game4BP, game4Desc);
		
		// Total value of prizes
		double totalValue=game1Value+game2Value+game3Value+game4Value;
		
		// print the # booby prizes (bpCount) as a message per the assignment sheet
				double consolationPrize = bpCount * 1.00;
				totalValue += consolationPrize;
				
		// print the total
		System.out.printf("Total Value: $%.2f (Includes $%.2f Consolation Prize for %d Booby Prizes)%n", totalValue, consolationPrize, bpCount);
		
	}
}
