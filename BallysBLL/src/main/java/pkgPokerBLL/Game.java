package pkgPokerBLL;

import java.util.ArrayList;
import java.util.UUID;

public class Game {
	private UUID GameID;

	private ArrayList<Player> GamePlayers = new ArrayList<Player>();
	
	public Game() {
		super();
		GameID = UUID.randomUUID();
	}
	
	public Game AddPlayerToGame(Player p)
	{
		
		return this;
	}

	public UUID getGameID() {
		return GameID;
	}

	public void setGameID(UUID gameID) {
		GameID = gameID;
	}

	public ArrayList<Player> getGamePlayers() {
		return GamePlayers;
	}

	public void setGamePlayers(ArrayList<Player> gamePlayers) {
		GamePlayers = gamePlayers;
	}
	
	

}
