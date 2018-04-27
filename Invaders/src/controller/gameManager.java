package controller;

import java.awt.Color;
import java.awt.Font;
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
			if(randomClass.enemies.getLarge() == 0 && randomClass.enemies1.getLarge() == 0 && randomClass.enemies2.getLarge() == 0 && randomClass.level <= 5) {
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
		g.setColor(Color.DARK_GRAY);
		g.fillRect(15, 25, 135, 300);
		g.fillRect(1210, 25, 150, 300);
		g.setColor(Color.white);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		g.drawString("Level: " + randomClass.level, 20, 50);getClass();
		g.drawString("Score: " + player.getPlayer().score, 20, 100);
		g.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		g.drawString("Enemy type",  1220, 50);
		g.drawString("Actual: " + randomClass.clase, 1220, 100);
		g.drawString("Next: " + randomClass.nextclass, 1220 , 150);
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
	
	public void sendServer() {
		
	}
}
