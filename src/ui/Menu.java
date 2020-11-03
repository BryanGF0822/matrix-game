package ui;

import java.util.Scanner;

import model.MirrorsGame;

public class Menu {
	
	private MirrorsGame control;
	private Scanner sc;
	
	
	public Menu() {
		sc = new Scanner(System.in);
		this.control = new MirrorsGame();
	}
	
	public void startMenu() {
		
		System.out.println("Welcome to the MatrixGame ");
		System.out.println("¿What operation would you like to do?");
		System.out.println("1. Play game");
		System.out.println("2. Score´s top");
		System.out.println("3. Exit the game");
		
		int option = Integer.parseInt(sc.nextLine());
		
		option(option);
	}
	
	public void option(int option) {
			if(option == 1) {
				option1();
			}else if(option == 2) {
				option2();
			}else if(option == 3) {
				option3();
			}else {
				System.out.println("Incorrect Entry");
				startMenu();
			}
		}


	public void option1() {
		System.out.println("- Please write his nickname, the dimension mxn of the matrix and k mirrors. Please: All information is separate with [,]");
		String answer1 = sc.nextLine();
		String[] answer2 = answer1.split(",");
		control.initialize(answer2[0], Integer.parseInt(answer2[1]), Integer.parseInt(answer2[2]), Integer.parseInt(answer2[3]));
		System.out.println(control.getGame());
		lectura();
		
	}
	
	public void lectura() {
		if(control.getGame().getConMirror() == 0) {
			System.out.println(control.getGame().getPlayer().getNickName() + " " + control.getGame().getPlayer().getScore());
			System.out.println("Ganaste");
			control.getGame().calculateScore();
			control.receiveData();
			startMenu();
		}else {
			System.out.println(control.getGame().toString(true));
			System.out.println("CODE: ");
			System.out.println("Espejos restantes: " + control.getGame().getConMirror());
			control.getGame().calculateScore();
			System.out.println(control.getGame().getPlayer().getNickName() + " " + control.getGame().getPlayer().getScore());
			String comms = sc.nextLine();
			control.getGame().identificarComms(comms);
			System.out.println(control.getGame());
			lectura();
		}
	}
	
	public void option2() {
		control.inOrden(control.getRoot());
		System.out.println(control.getGamblers());
		startMenu();
		
	}
	
	public void option3() {
		System.exit(0);
		
	}
}
