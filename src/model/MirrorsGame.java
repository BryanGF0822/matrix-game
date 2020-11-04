package model;

public class MirrorsGame {
	
	private Matrix game;
	private Player root;
	private String gamblers;
	
	//Constructor method
	
	public MirrorsGame() {
		root = null;
		gamblers = "";
	}
	
	public void initialize(String name, int a, int b, int mirror ) {
		game = new Matrix(name, a, b, mirror);
	}
	
	public void addPlayer(Player temp, Player root) {
		if(getRoot() == null) {
			setRoot(temp);
		}else {
			if(temp.getScore() <= root.getScore()) {
				if(root.getSonLeft() == null) {
					root.setSonLeft(temp);
				}else {
					addPlayer(temp, root.getSonLeft());
				}
			}else {
				if(root.getSonRight()==null) {
					root.setSonRight(temp);
				}else {
					addPlayer(temp, root.getSonRight());
				}
			}
		}
	}
	
	public void addPlayer(Player temp) {
		addPlayer(temp, getRoot());
	}
	
	
	public void inOrden(Player r) {
		
			if (r != null) {
				inOrden(r.getSonLeft());
				gamblers += r.getNickName() + ":" + r.getScore() + " ";
				inOrden(r.getSonRight());
			}
		}
	public String getGamblers() {
		return gamblers;
	}

	public void setGamblers(String gamblers) {
		this.gamblers = gamblers;
	}

	public Matrix getGame() {
		return game;
	}

	public void setGame(Matrix game) {
		this.game = game;
	}
	

	public Player getRoot() {
		return root;
	}

	public void setRoot(Player root) {
		this.root = root;
	}
	
	public void receiveData() {
		Player temp = game.sendData();
		addPlayer(temp);
	}
}
