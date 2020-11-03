package model;

public class Player {
	
	private String nickName;
	private int score;
	
	private Player father;
	private Player sonLeft;
	private Player sonRight;
	
	public Player(String nickName, int score) {
		this.nickName = nickName;
		this.score = score;
		
		this.father = null;
		this.sonLeft = null;
		this.sonRight = null; 
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Player getFather() {
		return father;
	}

	public void setFather(Player father) {
		this.father = father;
	}

	public Player getSonLeft() {
		return sonLeft;
	}

	public void setSonLeft(Player sonLeft) {
		this.sonLeft = sonLeft;
	}

	public Player getSonRight() {
		return sonRight;
	}

	public void setSonRight(Player sonRight) {
		this.sonRight = sonRight;
	}
	
	
}
