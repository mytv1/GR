package giddyhero.soccersystem.shared;

public class Card {
	
	public static int convertCardTypeToInteger(String cardType){
		if (cardType.equalsIgnoreCase("Yellow"))
			return 1;
		else
			return 2;
	}
	
	public static String convertIntegerToCardType(int i){
		if (i == 1)
			return "Yellow";
		else
			return "Red";
	}
	
}
