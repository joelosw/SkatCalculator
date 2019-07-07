package model;
/**
 * @author Joel Oswald
 * @ersion: 2019.07.07
 * 
 **/

import java.util.ArrayList;
import java.util.List;

public class PlayerGroup {
	public List<Player> players = new ArrayList<Player>();
	public int numberOfPLayers = 0;

	public void addPLayer(Player p) {
		players.add(p);
		numberOfPLayers++;
		System.out.println("Player " + p + " added" );
	}

public void caculateDebts(int centsPerPoint) {
	for(int i=0; i<=numberOfPLayers-1; i++) {
		int debt=0;
		for(int j=0; j<=numberOfPLayers; j++) {
			debt += (players.get(i).points - players.get(j).points)*centsPerPoint; 
		}
		players.get(i).debt = debt;
	}
}

public void caculateDebts() {
	for(int i=0; i<numberOfPLayers; i++) {
		int debti=0;
		for(int j=0; j<numberOfPLayers; j++) {
			debti += (players.get(i).points - players.get(j).points)*1; 
		}
		players.get(i).debt = debti;
	}
}

}
