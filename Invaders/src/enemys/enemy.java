package enemys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import GUI.Window;
import User.player;
import controller.gameManager;

public class enemy {
	
	private player user = player.getPlayer();
	
	
	public int x, a, b;
	public int y = 10;
	private int limit = 10;
	private int move = more;
	public static int more = 10;
	public int health = 1;
	public boolean cond = false;
	public static String name;
	public int ID;
	
	public enemy (int x, int a, int b, String name, int ID) {
		this.x = x;
		this.a = a;
		this.b = b;
		this.name = name;
		this.ID = ID;
	}
	
	public void tick() {
		if (x + limit < 180 + a) {
				move = more;
				y += 30;
		}
		if (x + limit > 180 + b) {
				move = -more;
				y += 30;
		}
		x += move;
	}
	/**
	 * 
	 * @param g
	 * @throws IOException 
	 */
	public void render(Graphics g){
		try {
		BufferedImage image =  ImageIO.read(this.getClass().getResource(name));
		g.drawImage(image, x, y, 70, 70, Window.frame);
		//g.setColor(Color.GREEN);
		//g.fillRect(x, y, 30, 30);
		}catch(IOException e) {
		}
	}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 60, 60);
	}
	
	public void mori() {
		health --;
		if(health == 0) {
			if(randomClass.enemys.getLarge() != 0) {
				user.score += 5;
				randomClass.enemys.delete(this);
				//randomClass.put();
			}
			if(randomClass.enemys1.getLarge() != 0) {
				user.score += 5;
				randomClass.tipos.delete(this.ID);
				randomClass.enemys1.delete(this);
				//randomClass.put();
			}
			if(randomClass.enemys2.getLarge() != 0) {
				user.score += 5;
				randomClass.enemys2.delete(this);
				//randomClass.put();
			}
			randomClass.put();
		}
		System.out.println(user.score);
	}
}
