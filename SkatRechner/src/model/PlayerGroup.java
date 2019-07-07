package model;

import java.util.ArrayList;
import java.util.List;

public class PlayerGroup {
	public List<Player> players = new ArrayList<Player>();
	public int numberOfPLayers = 0;

	public void addPLayer(Player p) {
		players.add(p);
		numberOfPLayers++;
	}

public void caculateDebts(int centsPerPoint) {
	for(int i=0; i<=numberOfPLayers-1; i++) {
		int debt=0;
		for(int j=0; j<=numberOfPLayers; j++) {
			debt += (players.get(i).points - players.get(j).points)*centsPerPoint; 
		}
	}
}

public void caculateDebts() {
	for(int i=0; i<=numberOfPLayers-1; i++) {
		int debt=0;
		for(int j=0; j<=numberOfPLayers; j++) {
			debt += (players.get(i).points - players.get(j).points)*1; 
		}
	}
}

}
