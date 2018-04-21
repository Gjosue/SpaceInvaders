package enemys;

import java.awt.Color;
import java.awt.Graphics;


public class Boss extends enemy {

	public Boss(int x, int a, int b, int ID, boolean cond) {
		super(x, a, b, ID);
		this.health = 5;
		this.cond = cond;
		this.ID = ID;
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, 30, 30);
	}

	@Override
	public void mori() {
		health --;
		if(health == 0 && cond) {
			if(randomClass.enemys.getLarge() != 0) {
				randomClass.enemys.deleteAll();
			}
			if(randomClass.enemys1.getLarge() != 0) {
				randomClass.enemys1.deleteAll();
			}
		}
		if(health == 0 && !cond) {
			if(randomClass.enemys.getLarge() != 0) {
				randomClass.enemys.delete(this);
			}
			if(randomClass.enemys1.getLarge() != 0) {
				randomClass.enemys1.delete(this);
			}
		}
	}
	
	
	
}
