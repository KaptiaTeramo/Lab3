package pkgPokerBLL;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class Table {

	private UUID TableID;
	
	//	Change this from ArrayList to HashMap.
	private ArrayList<Player> TablePlayers = new ArrayList<Player>();
	private HashMap Players = new HashMap();
	
	public Table() {
		super();
		TableID = UUID.randomUUID();
	}
	
	public Table AddPlayerToTable(Player p)
	{
		Players.put(UUID.randomUUID(), p);		
		return this;
	}
	
	public Table RemovePlayerFromTable(Player p)
	{
		Players.remove(p);
		return this;
	}
}
