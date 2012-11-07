package com.sectorcontrol;

public class GameSpace {
	
	// Fields
	private int gameSpaceID;
	
	public GameSpace() {
		this.gameSpaceID = 0;
	}
	
	public GameSpace(int gameSpaceID) {
		this.gameSpaceID = gameSpaceID;
	}
	
	public void setGameSpaceID(int gameSpaceID) {
		this.gameSpaceID = gameSpaceID;
	}
	
	public int getGameSpaceID() {
		return this.gameSpaceID;
	}
}
