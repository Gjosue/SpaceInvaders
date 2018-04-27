package enemys;

import controller.gameManager;

public class classC {
	
	public void init() {
		int x = 180;
		int n = 0;
		int m = 530;
		int random = (int) (Math.random() * 5 + 1);
		while(randomClass.enemys2.getLarge() < 5) {
			if(randomClass.enemys2.getLarge() + 1 != random) {
				randomClass.enemys2.add(new enemy(x, n, m, "/misc/enemy.png", 4));
				x += 100;
				n += 100;
				m += 100;
			}else {
				randomClass.enemys2.add(new Boss(x, n, m, false, "/misc/boss.png", 9));
				x += 100;
				n += 100;
				m += 100;
			}
		}
	}
}
