package enemys;

import controller.gameManager;

public class Basic {

	public void init() {
		int x = 180;
		int n = 0;
		int m = 570;
		int id = 1; 
		while(randomClass.enemys.getLarge() < 5) {
			randomClass.enemys.add(new enemy(x, n, m, id));
			x += 100;
			n += 100;
			m += 100;
			id ++;
		}
	}
}

