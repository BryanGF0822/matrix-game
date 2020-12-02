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
	/**
	 * It allows to initialize the values of the matrix each time the program is executed.
	 * @param name [name of the user that is playing.]
	 * @param a [number of rows in the array.]
	 * @param b [number of columns in the matrix.]
	 * @param mirror [number of mirrors.]
	 */
	public void initialize(String name, int a, int b, int mirror ) {
		game = new Matrix(name, a, b, mirror);
	}
	/**
	 * Allows you to add a player to the binary search tree.
	 * @param temp [player that is going to be added at that time.]
	 * @param root [Root of the binary tree from which you must organize whether you will go to your left or your right.]
	 */
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
	/**
	 * Allows you to add a player to the binary search tree.
	 * @param temp [player that is going to be added at that time.]
	 */
	public void addPlayer(Player temp) {
		addPlayer(temp, getRoot());
	}
	
	/**
	 * Allows you to browse the inOrder binary tree.
	 * @param r [root of the binary tree where it starts to go]
	 */
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
	/**
	 * 
	 */
	public void receiveData() {
		Player temp = game.sendData();
		addPlayer(temp);
	}
}
