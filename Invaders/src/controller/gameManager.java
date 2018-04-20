package controller;

import java.awt.Graphics;
import java.util.ArrayList;

import Lists.LinkedList;
import Lists.Nodo;
import User.bullet;
import User.player;
import enemys.enemy;

public class gameManager {
	
	public player Player = player.getPlayer();
	public static LinkedList<enemy> enemys = new LinkedList();
	
	public static ArrayList<bullet> bullet;
	
	public gameManager() {
		
	}
	/**
	 * se inicializa el jugador y se crean las balas
	 */
	public void init() {
		Player.init();
		bullet = new ArrayList<bullet>();
		int x = 180;
		int n = 0;
		int m = 570;
		while(enemys.getLarge() < 5) {
			enemys.add(new enemy(x, n, m));
			x += 100;
			n += 100;
			m += 100;
		}
	}
	/**
	 * llama el metodo que maneja el movimiento del jugador y controla la creacion de la balas
	 */
	public void tick() {
		Player.tick();
		for (int i = 0; i < enemys.getLarge(); i ++) {
			enemys.get(i).tick();
		}
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
		for(int i = 0; i < enemys.getLarge(); i++) {
			enemys.get(i).render(g);
		}
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
