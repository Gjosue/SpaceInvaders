package enemys;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.Window;
import User.player;


public class Boss extends enemy {
	
	private player user = player.getPlayer();
	public int ID;

	public Boss(int x, int a, int b, boolean cond, int ID) {
		super(x, a, b,ID);
		this.health = 5;
		this.cond = cond;
		this.ID = ID;
	}
	
	@Override
	public void render(Graphics g) {
		try {
			BufferedImage image =  ImageIO.read(this.getClass().getResource("/misc/boss.png"));
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
			if(randomClass.enemies.getLarge() != 0) {
				user.score += (5 * (randomClass.enemies.getLarge() - 1));
				user.score += 10;
				randomClass.enemies.deleteAll();
							}
			if(randomClass.enemies1.getLarge() != 0) {
				user.score += (5 * (randomClass.enemies1.getLarge() - 1));
				user.score += 10;
				randomClass.tipos.deleteAll();
				randomClass.enemies1.deleteAll();
				
			}
			if(randomClass.enemies2.getLarge() != 0) {
				user.score += 10;
				randomClass.tipos2.delete(this.ID);
				randomClass.enemies2.delete(this);
				randomClass.change();
				randomClass.put();
				
			}
		
		}
	}
	
	
	
}
