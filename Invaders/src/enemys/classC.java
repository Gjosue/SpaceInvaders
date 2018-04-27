package enemys;

import controller.gameManager;

public class classC {
	
	public void init() {
		int x = 180;
		int n = 0;
		int m = 530;
		int id = 1;
		randomClass.tipos2.add(1, 5);
		randomClass.tipos2.add(2, 5);
		randomClass.tipos2.add(3, 5);
		randomClass.tipos2.add(4, 4);
		int random = (int) (Math.random() * 5 + 1);
		while(randomClass.enemies2.getLarge() < 5) {
			if(randomClass.enemies2.getLarge() + 1 != random) {
				randomClass.enemies2.add(new enemy(x, n, m, id), id);
				x += 100;
				n += 100;
				m += 100;
				id ++;
			}else {
				randomClass.enemies2.add(new Boss(x, n, m, false, 0), 0);
				x += 100;
				n += 100;
				m += 100;
			}
		}
	}
}
