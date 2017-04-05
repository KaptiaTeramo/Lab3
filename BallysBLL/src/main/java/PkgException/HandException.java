package PkgException;

public class HandException extends Throwable{
	private int cardsInHand;
	
	public HandException(int cardsInHand){
		this.cardsInHand = cardsInHand;
	}
	
	public int getCardsInHand(){
		return cardsInHand;
	}
}
