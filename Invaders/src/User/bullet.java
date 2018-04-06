package User;

import java.awt.Color;
import java.awt.Graphics;

public class bullet {
	
	private int x, y, speed;
	
	public bullet(int x, int y) {
		this.x = x;
		this.y = y;
		speed = 10;
	}
	/**
	 * controla la distancia entre las balas 
	 */
	public void tick() {
		y -= speed;
	}
	/**
	 * define las dimensiones de las balas
	 * @param g
	 */
	public void render(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(x, y, 5, 10);
	}
	
	public int getY() {
		return y;
	}
}
