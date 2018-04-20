package User;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import Lists.Nodo;
import controller.gameManager;
import enemys.enemy;

public class bullet {
	
	private int x, y, speed;
	
	public bullet(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 30;
	}
	/**
	 * controla la distancia entre las balas 
	 */
	public void tick() {
		y -= speed;
		if (hit()) {
			gameManager.bullet.remove(this);
		}
	}
	/**
	 * define las dimensiones de las balas
	 * @param g
	 */
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 5, 15);
		if (y < 40) {
			gameManager.bullet.remove(this);
		}
	}
	
	public int getY() {
		return y;
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 5, 15);
	}
	
	public boolean hit() {
		for (int i = 0; i < gameManager.enemys.getLarge(); i ++) {
			enemy temp = gameManager.enemys.get(i);
			if (temp.getBounds().intersects(getBounds())) {
				temp.mori();
				return true;
			}
			
		}
		return false;
	}
}
