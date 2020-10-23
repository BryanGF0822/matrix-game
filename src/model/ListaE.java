package model;

public class ListaE {
	
	private ListaE next;
	private ListaE prev;
	private ListaE up;
	private ListaE down;
	
	private String espejo;

	public ListaE(String espejo) {
		this.espejo = espejo;
		next = null;
		prev = null;
		up = null;
		down = null;
	}

	public ListaE getNext() {
		return next;
	}

	public void setNext(ListaE next) {
		this.next = next;
	}

	public ListaE getPrev() {
		return prev;
	}

	public void setPrev(ListaE prev) {
		this.prev = prev;
	}

	public ListaE getUp() {
		return up;
	}

	public void setUp(ListaE up) {
		this.up = up;
	}

	public ListaE getDown() {
		return down;
	}

	public void setDown(ListaE down) {
		this.down = down;
	}

	public String getEspejo() {
		return espejo;
	}

	public void setEspejo(String espejo) {
		this.espejo = espejo;
	}
	
	
}
