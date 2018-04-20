package enemys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

import controller.gameManager;

public class enemy {
	
	
	public int x, a, b;
	private int y = 10;
	private int move = 10;
	
	public enemy (int x, int a, int b) {
		this.x = x;
		this.a = a;
		this.b = b;
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
	
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 30, 30);
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 30, 30);
	}
	
	public void mori() {
		gameManager.enemys.delete(this);
	}
}
