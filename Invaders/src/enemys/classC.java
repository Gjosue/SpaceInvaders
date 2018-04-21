package enemys;

import controller.gameManager;

public class classC {
	
	public void init() {
		int x = 180;
		int n = 0;
		int m = 570;
		int id = 1;
		int random = (int) (Math.random() * 5 + 1);
		while(randomClass.enemys.getLarge() < 5) {
			if(randomClass.enemys.getLarge() + 1 != random) {
				randomClass.enemys.add(new enemy(x, n, m, id));
				x += 100;
				n += 100;
				m += 100;
				id ++;
			}else {
				randomClass.enemys.add(new Boss(x, n, m, id, true));
				x += 100;
				n += 100;
				m += 100;
				id ++;
			}
		}
	}
}
