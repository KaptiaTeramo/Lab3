package PkgException;

public class DeckException extends Throwable{
	private int numOfCards;

	public DeckException() {
		super();
		this.numOfCards = 0;
	}
	public int getNumofCards(){
		return numOfCards;
	}
	
}
