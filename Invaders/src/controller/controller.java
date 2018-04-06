package controller;

import server.Server;

public class controller {
	
	public static void main(String[] args) {
		
		/**
		 * inicializacion del servidor y los procesos del juego
		 */
		SetUp game = new SetUp("Invaders", 700, 1360);
		Thread server = new Server("proceso 1");
		game.start();
		server.start();
		
	}
}