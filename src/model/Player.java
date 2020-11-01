package model;

public class Player {
	
	private String nickName;
	private int score;
	
	public Player(String n, int s) {
		nickName = n;
		score = s;
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
	
	
}
