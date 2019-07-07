package model;

public class Player {
	public static int NumberOfPLayers = 0;
	public String name;
	public int points;
	public int debt;

	public Player(String name) {
		this.name = name;
		++NumberOfPLayers;
		this.points = 0;
	}

	public int AddPoints(int points) {
		this.points += points;
		System.out.println(this.name +" got added Points: " + points);
		return this.points;
	}

	public void setDebt(int debt) {
		this.debt = debt;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.name;
	}
}
