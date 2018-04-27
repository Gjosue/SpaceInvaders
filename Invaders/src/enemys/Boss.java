package enemys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.Window;
import User.player;


public class Boss extends enemy {
	
	public static String name;
	private player user = player.getPlayer();
	public int ID;

	public Boss(int x, int a, int b, boolean cond, String name, int ID) {
		super(x, a, b, name, ID);
		this.health = 5;
		this.cond = cond;
		this.name = name;
		this.ID = ID;
	}
	
	@Override
	public void render(Graphics g) {
		try {
			BufferedImage image =  ImageIO.read(this.getClass().getResource(name));
			g.drawImage(image, x, y, 70, 70, Window.frame);
//			g.setColor(Color.RED);
//			g.fillRect(x, y, 30, 30);
			}catch(IOException e) {
			}
		
	}

	@Override
	public void mori() {
		health --;
		if(health == 0) {
			if(randomClass.enemys.getLarge() != 0) {
				user.score += (5 * (randomClass.enemys.getLarge() - 1));
				user.score += 10;
				randomClass.enemys.deleteAll();
							}
			if(randomClass.enemys1.getLarge() != 0) {
				user.score += (5 * (randomClass.enemys1.getLarge() - 1));
				user.score += 10;
				randomClass.tipos.deleteAll();
				randomClass.enemys1.deleteAll();
				
			}
			if(randomClass.enemys2.getLarge() != 0) {
				user.score += 10;
				randomClass.enemys2.delete(this);
				randomClass.put();
				
			}
		
		}
	}
	
	
	
}
