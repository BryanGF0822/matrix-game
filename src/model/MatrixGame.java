package model;

public class MatrixGame {
	
	private Node first;
	private Player player;
	
	private int numRows;
	private int numCols;
	private int contador1;
	private int contador2;
	private int conMirror;
	private int shoots;
	private int mirror;
	
	
	
	public MatrixGame(String name, int numRows, int numCols, int mirror) {
		this.numRows = numRows;
		this.numCols = numCols;
		this.contador1 = 0;
		this.contador2 = 0;
		this.conMirror = 0;
		this.shoots = 0;
		this.mirror = mirror;
		player = new Player(name, 0);
		
		createMatrix();
	}
	
	public Node getFirst() {
		return first;
	}
	
	public void setFirst(Node first) {
		this.first = first;
	}

	public int getNumRows() {
		return numRows;
	}

	public void setNumRows(int numRows) {
		this.numRows = numRows;
	}

	public int getNumCols() {
		return numCols;
	}

	public void setNumCols(int numCols) {
		this.numCols = numCols;
	}

	public int getContador1() {
		return contador1;
	}

	public void setContador1(int contador1) {
		this.contador1 = contador1;
	}

	public int getContador2() {
		return contador2;
	}

	public int getConMirror() {
		return conMirror;
	}

	public void setConMirror(int conMirror) {
		this.conMirror = conMirror;
	}

	public int getShoots() {
		return shoots;
	}

	public void setShoots(int shoots) {
		this.shoots = shoots;
	}

	public int getMirror() {
		return mirror;
	}

	public void setMirror(int mirror) {
		this.mirror = mirror;
	}

	public void setContador2(int contador2) {
		this.contador2 = contador2;
	}
	
	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void calculateScore() {
		int c = mirror - conMirror;
		
		int a = c*100;
		int b = getShoots()*4;
		
		int d = a-b;
		
		player.setScore(d);
	}
	
	public Player sendDates() {
		return player;
	}
	
	private void createMatrix() {
		first = new Node(0,0);
		createRow(0,0,first);
	}

	private void createRow(int i, int j, Node currentFirstRow) {
		createCol(i,j,currentFirstRow,currentFirstRow.getUp());
		if(i+1<numRows) {
			Node downFirstRow = new Node(i+1,j);
			downFirstRow.setUp(currentFirstRow);
			currentFirstRow.setDown(downFirstRow);
			createRow(i+1,j,downFirstRow);
		}
	}

	
	private void createCol(int i, int j, Node prev, Node rowPrev) {
		if(j+1<numCols) {
			Node current = new Node(i, j+1);
			current.setPrev(prev);
			prev.setNext(current);
			
			if(rowPrev!=null) {
				rowPrev = rowPrev.getNext();
				current.setUp(rowPrev);
				rowPrev.setDown(current);
			}
			
			createCol(i,j+1,current,rowPrev);
		}
	}
	
	public String toString() {
		String msg;
		msg = toStringRow(first);
		return msg;
	}

	private String toStringRow(Node firstRow) {
		String msg = "";
		if(firstRow!=null) {
			msg = toStringCol(firstRow) + "\n";
			msg += toStringRow(firstRow.getDown());
		}
		return msg;
	}

	private String toStringCol(Node current) {
		String msg = "";
		if(current!=null) {
			msg = current.toString();
			msg += toStringCol(current.getNext());
		}
		return msg;
	}
	
	public String toString2() {
		String msg = "";
		
		return msg;
	}
	
	public void showMirror(Node temp, String inclination) {
		if(temp.checkMirror() == true) {
			if(temp.getMirror().equals(inclination)) {
				temp.setB(true);
				setConMirror(conMirror-1);
			}else {
				temp.setB(true);
			}
		}else {
			temp.setB(true);
		}
			
	}
	
	public void reStartMirror(int mirror, int f, int c) {
		
		setConMirror(mirror);
		setMirror(mirror);
		setContador1(mirror);
		generateMirror(f,c,mirror);
	}
	
	public Node walkAroundMatrix(int f, int c, Node tempo) {
		
		if (f == tempo.getFil()) {
			if (c == tempo.getCol()) {
				return tempo;
			}else {
				tempo = tempo.getNext();
				return walkAroundMatrix(f, c, tempo);
			}
		}else {
			tempo = tempo.getDown();
			return walkAroundMatrix(f, c, tempo);
		}
	}
	
	public String createRandomMirror() {
		
		String m = "";
		double b = Math.random() *10;
		int c = (int)b;
		
		if (c % 2 == 0) {
			m =  "/"; //derecha

		}else {
			m =  "\\";//izquierda
		}
		return m;
	}
	
	public void generateMirror(int f, int c, int k) { // a = 3; b = 3; mirror = 4; mirror > 9
		String mg = "";
		System.out.println(k);
		if(contador1 <= f * c) {     
			if(contador1 <= 0) {
			}else {
				Node temp = generateRandomPosition(f,c);  //1A ; 1A
				
				System.out.println(temp);
				System.out.println(temp.getMirror());
				
 				if(temp.getMirror() == "") {    //1A = ""; 1A = "/" O 1A = "\\";  
 					System.out.println("true");
					temp.setMirror(createRandomMirror());
					System.out.println(temp.getMirror());
				}else {
					System.out.println("Hay una position que ya tiene");
					generateMirror(f,c,contador1);
				}
				System.out.println("Siguiente espejo");
				contador1  = contador1 - 1;
				generateMirror(f,c,contador1);
			}
		}else {
			mg = "No se puede generar los espejos porque la cantidad supera las dimensiones de la matriz";
		}
		
	}
	
	public Node generateRandomPosition(int f, int c) {
		
		double a1 = Math.random() * f+1;
		double b1 = Math.random() * c;
		
		int fil = (int)a1;
		int col = (int)b1;
		//char col = (char)('A'+ c1);
		
		return walkAroundMatrix(fil, col, getFirst());
	}
	
	public String identificarComms(String comms) {
		String msg = "";
		if((comms.length() == 4) && (comms.charAt(0) == 'L')) {
			
			String a = comms.charAt(1) + "";
			int b = Integer.parseInt(a);
			char c = comms.charAt(2);
			String incli = comms.charAt(3)+""; 
			if(walkAroundMatrix(b,c,getFirst()) != null ) {
				Node temp1 = walkAroundMatrix(b,c,getFirst());
				if(incli.equals("R")) {
					//Llame metodo de validar espejo
					showMirror(temp1,"/");
					
				}else if(incli.equals("L")) {
					showMirror(temp1, "\\");
				}else {
					msg = "No se reconoce si es R o L en el comando";
				}
			}else {
				msg = "La position de la celda no existe";
			}
		}else if(comms.length() == 3){ //1AH
			char col = comms.charAt(1);
			String ab = comms.charAt(0)+"";
			
			int row = Integer.parseInt(ab);
			String orien = comms.charAt(2) + "";
			
			if(walkAroundMatrix(row,col, getFirst()) != null ) {
				if((comms.charAt(comms.length()-1) == 'H')) {
					Node temp = walkAroundMatrix(row,col,getFirst());
					if(isItA_Corner(temp).equals("SI")) {
						temp.setStart(true);
						contador2 = contador2 + 1;
						shootLaserRay(row,col, "HD");
						shoots = shoots +1;
					}else if(isItA_Corner(temp).equals("SD")){
						temp.setStart(true);
						contador2 = contador2 + 1;
						shootLaserRay(row,col, "HI");
						shoots = shoots +1;
					}else if(isItA_Corner(temp).equals("II")) {
						temp.setStart(true);
						contador2 = contador2 + 1;
						shootLaserRay(row,col, "HD");
						shoots = shoots +1;
					}else if(isItA_Corner(temp).equals("ID")) {
						temp.setStart(true);
						contador2 = contador2 + 1;
						shootLaserRay(row,col, "HI");
						shoots = shoots +1;
					}
				}else if((comms.charAt(comms.length()-1) == 'V')){
					Node temp = walkAroundMatrix(row,col,getFirst());
					if(isItA_Corner(temp).equals("SI")) {
						temp.setStart(true);
						contador2 = contador2 + 1;
						shootLaserRay(row,col, "VD");
						shoots = shoots +1;
					}else if(isItA_Corner(temp).equals("SD")){
						temp.setStart(true);
						contador2 = contador2 + 1;
						shootLaserRay(row,col, "VD");
						shoots = shoots +1;
					}else if(isItA_Corner(temp).equals("II")) {
						temp.setStart(true);
						contador2 = contador2 + 1;
						shootLaserRay(row,col, "VU");
						shoots = shoots +1;
					}else if(isItA_Corner(temp).equals("ID"))
						temp.setStart(true);
						contador2 = contador2 + 1;
						shootLaserRay(row,col, "VU");
						shoots = shoots +1;
				}else {
					msg = "No se reconoce si es H o V en el comando";
				}
			}else {
				msg = "La position de la celda no existe";
			}
		}else {
			String a = comms.charAt(0) + "";
			int b = Integer.parseInt(a);
			char c = comms.charAt(1);
			
			if(walkAroundMatrix(b,c, getFirst()) != null ) {
				//Llame método de lanzar rayo
				toString();
				shoots = shoots +1;
				Node temp = walkAroundMatrix(b,c,getFirst());
				if(isItA_Corner1(temp) == true){
					toString();
				}else {
					shootLaserRay(b,c, "");
				}
				
			}
			
		}
		return msg;
	}
	
	public void shootLaserRay(int row, char col, String orientation) {
		Node temp = walkAroundMatrix(row, col,getFirst());
				// Orientation null
			if(contador2 == 0) { // Para prevenir que estemos en el inicio sea borde
				if(temp.getFil() == 1) { // Borde Superior
					if(temp.checkMirror() == true) {
						if(temp.getMirror().equals("/")) {
							if(walkAroundMatrix(temp.getFil(), (char)(temp.getCol()-1), getFirst()) != null) {
								contador2 = contador2 + 1;
								shootLaserRay(temp.getFil(), (char)(temp.getCol()-1), "HI");
								temp.setStart(true);
							}
						}else {
							if(walkAroundMatrix(temp.getFil(), (char)(temp.getCol()+1), getFirst()) != null) {
								contador2 = contador2 + 1;
								shootLaserRay(temp.getFil(), (char)(temp.getCol()+1), "HD");
								temp.setStart(true);
							}
						}
					}else {
						//Borde superior
						contador2 = contador2 + 1;
						if(walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) != null) {
							shootLaserRay(temp.getFil()+1, temp.getCol(), "VD");
							temp.setStart(true);
						}
					}
					
				}else if (temp.getFil() == getNumRows()){   // borde inferior 
					if(temp.checkMirror() == true) {
						if(temp.getMirror().equals("/")) {
							if(walkAroundMatrix(temp.getFil(), (char)(temp.getCol()+1), getFirst()) != null) {
								contador2 = contador2 + 1;
								shootLaserRay(temp.getFil(), (char)(temp.getCol()+1), "HD");
								temp.setStart(true);
							}
						}else {
							if(walkAroundMatrix(temp.getFil(), (char)(temp.getCol()-1), getFirst()) != null) {
								contador2 = contador2 + 1;
								shootLaserRay(temp.getFil(), (char)(temp.getCol()-1), "HI");
								temp.setStart(true);
							}
						}
					}else {
						//Borde inferior
						contador2 = contador2 + 1;
						if(walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) != null) {
							shootLaserRay(temp.getFil()-1, temp.getCol(), "VU");
							temp.setStart(true);
						}
					}
				}else if (temp.getCol() == 'A') { //Borde izquierdo
					if(temp.checkMirror() == true) {
						if(temp.getMirror().equals("/")) {
							if(walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) != null) {
								contador2 = contador2 + 1;
								shootLaserRay(temp.getFil()-1, temp.getCol(), "VU");
								temp.setStart(true);
							}
						}else {
							if(walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) != null) {
								contador2 = contador2 + 1;
								shootLaserRay(temp.getFil()+1, temp.getCol(), "VD");
								temp.setStart(true);
							}
						}
					}else {
						//Borde izquierdo
						contador2 = contador2 + 1;
						if(walkAroundMatrix(temp.getFil(), (char) (temp.getCol()+1), getFirst()) != null) {
							shootLaserRay(temp.getFil(), (char) (temp.getCol()+1), "HD");
							temp.setStart(true);
						}
					}
					
				}else if (temp.getCol() == 'A' + (getNumCols()-1)) { //Borde derecho
					if(temp.checkMirror() == true) {
						if(temp.getMirror().equals("/")) {
							if(walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) != null) {
								contador2 = contador2 + 1;
								shootLaserRay(temp.getFil()+1, temp.getCol(), "VD");
								temp.setStart(true);
							}
						}else {
							if(walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) != null) {
								contador2 = contador2 + 1;
								shootLaserRay(temp.getFil()-1, temp.getCol(), "VU");
								temp.setStart(true);
							}
						}
					}else {
						//Borde derecho
						contador2 = contador2 + 1;
						if(walkAroundMatrix(temp.getFil(), (char)(temp.getCol()-1), getFirst()) != null) {
							shootLaserRay(temp.getFil(), (char)(temp.getCol()-1), "HI");
							temp.setStart(true);
						}
					}
				}
			}else { //contadora == 1
				if(orientation == "HD") {
					if(temp.checkMirror() == true) {
						if(temp.getMirror().equals("/")) {
							if(walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) != null) {
								Node temp1 = walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst());
								shootLaserRay(temp1.getFil(), temp1.getCol(), "VU");
							}else {
								temp.setEnd(true);
								setContador2(0);
								
							}
						}else {
							if(walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) != null) {
								Node temp1 = walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst());
								shootLaserRay(temp1.getFil(), temp1.getCol(), "VD");
							}else {

								temp.setEnd(true);
								setContador2(0);
								
								
							}
						}
					}else {
						if(walkAroundMatrix(temp.getFil(), (char) (temp.getCol()+1), getFirst()) != null) {
							Node temp1 = walkAroundMatrix(temp.getFil(), (char)(temp.getCol()+1), getFirst());
							shootLaserRay(temp1.getFil(), temp1.getCol(), "HD");
						}else {

							temp.setEnd(true);
							setContador2(0);
							
							
						}	
					}
				}else if(orientation == "HI") {
					if(temp.checkMirror() == true) {
						if(temp.getMirror().equals("/")) {
							if(walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) != null) {
								Node temp1 = walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst());
								shootLaserRay(temp1.getFil(), temp1.getCol(), "VD");
							}else {

								temp.setEnd(true);
								setContador2(0);
								
								
							}
						}else {
							if(walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) != null) {
								Node temp1 = walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst());
								shootLaserRay(temp1.getFil(), temp1.getCol(), "VU");
							}else {
								temp.setEnd(true);
								setContador2(0);
								
								
							}
						}
					}else {
						if(walkAroundMatrix(temp.getFil(), (char) (temp.getCol()-1), getFirst()) != null) {
							Node temp1 = walkAroundMatrix(temp.getFil(), (char) (temp.getCol()-1), getFirst());
							shootLaserRay(temp1.getFil(), temp1.getCol(), "HI");
						}else {

							temp.setEnd(true);
							setContador2(0);
							
							
						}	
					}
				}else if(orientation == "VU") {
					if(temp.checkMirror() == true) {
						if(temp.getMirror().equals("/")) {
							if(walkAroundMatrix(temp.getFil(), (char) (temp.getCol()+1), getFirst()) != null) {
								Node temp1 = walkAroundMatrix(temp.getFil(), (char) (temp.getCol()+1), getFirst());
								shootLaserRay(temp1.getFil(), temp1.getCol(), "HD");
							}else {

								temp.setEnd(true);
								setContador2(0);
								
								
							}
						}else {
							if(walkAroundMatrix(temp.getFil(), (char) (temp.getCol()-1), getFirst()) != null) {
								Node temp1 = walkAroundMatrix(temp.getFil(), (char) (temp.getCol()-1), getFirst());
								shootLaserRay(temp1.getFil(), temp1.getCol(), "HI");
							}else {

								temp.setEnd(true);
								setContador2(0);
								
								
							}
						}
					}else {
						if(walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) != null) {
							Node temp1 = walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst());
							shootLaserRay(temp1.getFil(), temp1.getCol(), "VU");
						}else {
							temp.setEnd(true);
							setContador2(0);
							
							
						}	
					}
				}else if(orientation == "VD") {
					if(temp.checkMirror() == true) {
						if(temp.getMirror().equals("/")) {
							if(walkAroundMatrix(temp.getFil(), (char) (temp.getCol()-1), getFirst()) != null) {
								Node temp1 = walkAroundMatrix(temp.getFil(), (char) (temp.getCol()-1), getFirst());
								shootLaserRay(temp1.getFil(), temp1.getCol(), "HI");
							}else {
								temp.setEnd(true);
								setContador2(0);
								
								
							}
						}else {
							if(walkAroundMatrix(temp.getFil(), (char) (temp.getCol()+1), getFirst()) != null) {
								Node temp1 = walkAroundMatrix(temp.getFil(), (char) (temp.getCol()+1), getFirst());
								shootLaserRay(temp1.getFil(), temp1.getCol(), "HD");
							}else {
								setContador2(0);
								temp.setEnd(true);
								
								
							}
						}
					}else {
						if(walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) != null) {
							Node temp1 = walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst());
							shootLaserRay(temp1.getFil(), temp1.getCol(), "VD");
						}else {
							setContador2(0);
							temp.setEnd(true);
							
							
						}	
					}
				}
			} //contadora 
					
	}
	
	public String isItA_Corner(Node temp) {
		if((walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) == null) && (walkAroundMatrix(temp.getFil(), (char)(temp.getCol()-1), getFirst()) ==null)) { //Get up == null, get prev == null
			return "SI";
			//Esquina superior izquierda
		}else if((walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) == null) && (walkAroundMatrix(temp.getFil(), (char)(temp.getCol()+1), getFirst()) ==null)){
			return "SD";
			//Esquina superior derecha
		}else if((walkAroundMatrix(temp.getFil(), (char) (temp.getCol()-1), getFirst()) == null) && (walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) ==null)) {
			System.out.println((walkAroundMatrix(temp.getFil(), (char) (temp.getCol()-1), getFirst())));
			System.out.println((walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst())));
			return "II";
			//Esquina inferior izquierda
		}else if((walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) == null) && (walkAroundMatrix(temp.getFil(), (char)(temp.getCol()+1), getFirst()) ==null)) {
			System.out.println((walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst())));
			System.out.println((walkAroundMatrix(temp.getFil()+1, (char) (temp.getCol()+1), getFirst())));
			return "ID";
			//Esquina inferior derecha4
			
		}else {
			return "No se identifica la esquina";
		}
	
	}
	
	public boolean isItA_Corner1(Node temp) {
		if((walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) == null) && (walkAroundMatrix(temp.getFil(), (char)(temp.getCol()-1), getFirst()) ==null)) { //Get up == null, get prev == null
			return true;
			//Esquina superior izquierda
		}else if((walkAroundMatrix(temp.getFil()-1, temp.getCol(), getFirst()) == null) && (walkAroundMatrix(temp.getFil(), (char)(temp.getCol()+1), getFirst()) ==null)){
			return true;
			//Esquina superior derecha
		}else if((walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) == null) && (walkAroundMatrix(temp.getFil(), (char)(temp.getCol()-1), getFirst()) ==null)) {
			return true;
			//Esquina inferior izquierda
		}else if((walkAroundMatrix(temp.getFil()+1, temp.getCol(), getFirst()) == null) && (walkAroundMatrix(temp.getFil(), (char)(temp.getCol()+1), getFirst()) ==null)) {
			return true;
			//Esquina inferior derecha4
			
		}else {
			return false;
		}
	
	}
	
}
