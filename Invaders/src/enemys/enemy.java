package enemys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import controller.gameManager;

public class enemy {
	
	
	public int x, a, b;
	public int y = 10;
	private int move = 10;
	public int health = 1;
	public int ID;
	public boolean cond = false;
	
	public enemy (int x, int a, int b, int ID) {
		this.x = x;
		this.a = a;
		this.b = b;
		this.ID = ID;
	}
	
	public void tick() {
		if (x + move < 180 + a) {
				move = 10;
				y += 10;
		}
		if (x + move > 180 + b) {
				move = -10;
				y += 10;
		}
		x += move;
	}
	/**
	 * 
	 * @param g
	 */
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 30, 30);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 30);
	}
	
	public void mori() {
		health --;
		if(health == 0) {
			if(randomClass.enemys.getLarge() != 0) {
				randomClass.enemys.delete(this);
			}
			if(randomClass.enemys1.getLarge() != 0) {
				randomClass.enemys1.delete(this);
			}
		}
	}
}
