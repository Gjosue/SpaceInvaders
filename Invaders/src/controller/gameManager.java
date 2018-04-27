package controller;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

import Lists.DoublyLinked;
import Lists.LinkedList;
import User.bullet;
import User.player;
import enemys.enemy;
import enemys.randomClass;

public class gameManager {
	
	public player Player = player.getPlayer();
	public static ArrayList<bullet> bullet;
	public static randomClass generateEnemy = new randomClass();
	private int cont = 0;
	
	
	public gameManager() {
		
	}
	/**
	 * se inicializa el jugador y se crean las balas
	 */
	public void init() {
		Player.init();
		bullet = new ArrayList<bullet>();
		generateEnemy.generateLevels();
	}
	/**
	 * llama el metodo que maneja el movimiento del jugador y controla la creacion de la balas
	 */
	public void tick() {
		
			if(randomClass.enemys.getLarge() == 0 && randomClass.enemys1.getLarge() == 0 && randomClass.enemys2.getLarge() == 0 && randomClass.level <= 5) {
				controller.game.cont = 1;
				generateEnemy.cont ++;
				if(generateEnemy.cont == 1 | generateEnemy.cont == 3 | generateEnemy.cont == 6 | generateEnemy.cont == 10 | 
						generateEnemy.cont == 15) {
					JOptionPane.showMessageDialog(null,"NIVEL " + randomClass.level + " COMPLETADO");
					generateEnemy.level ++;
				}
				controller.game.cont = 0;
				generateEnemy.generateLevels();
			}
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
