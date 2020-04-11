package com.onmobile.training;

public class Player {
	private int playerId;
	private String playerName;
	private String sportsCode;
	private String countryCode;
	public Player(int playerId, String playerName, String sportsCode,String countryCode) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.sportsCode = sportsCode;
		this.countryCode = countryCode;
	}
	public Player() {
		super();
	}
	public int getPlayerId() {
		return playerId;
	}
	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getSportsCode() {
		return sportsCode;
	}
	public void setSportsCode(String sportsCode) {
		this.sportsCode = sportsCode;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	
}
