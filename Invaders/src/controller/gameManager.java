package controller;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import Lists.DoublyLinked;
import Lists.LinkedList;
import User.bullet;
import User.player;
import enemys.enemy;
import enemys.randomClass;

public class gameManager {
	
	public player Player = player.getPlayer();
	public static ArrayList<bullet> bullet;
	private randomClass generateEnemy = new randomClass();
	
	public gameManager() {
		
	}
	/**
	 * se inicializa el jugador y se crean las balas
	 */
	public void init() {
		Player.init();
		bullet = new ArrayList<bullet>();
		generateEnemy.init();
	}
	/**
	 * llama el metodo que maneja el movimiento del jugador y controla la creacion de la balas
	 */
	public void tick() {
		Player.tick();
		generateEnemy.tick();
		for (int i = 0; i < bullet.size(); i ++) {
			bullet.get(i).tick();
		}
	}
	/**
	 * se dibuja un cuadro que es el jugador y se maneja el uso de las balas
	 * @param g
	 */
	public void render(Graphics g) {
		Player.render(g);
		generateEnemy.render(g);
		for (int i = 0; i < bullet.size(); i ++) {
			bullet.get(i).render(g);
		}
		for (int i = 0; i < bullet.size(); i ++) {
			if (bullet.get(i).getY() <= 15){
				bullet.remove(i);
				i --;
			}
		}
	}
}
