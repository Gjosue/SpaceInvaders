package enemys;

public class Basic {

	public void init() {
		int x = 180;
		int n = 0;
		int m = 530;
		while(randomClass.enemys.getLarge() < 5) {
			randomClass.enemys.add(new enemy(x, n, m, "/misc/enemy.png", 5));
			x += 100;
			n += 100;
			m += 100;
		}
	}
	
}

