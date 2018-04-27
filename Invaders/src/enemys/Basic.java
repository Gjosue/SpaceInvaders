package enemys;

public class Basic {

	public void init() {
		int x = 180;
		int n = 0;
		int m = 530;
		while(randomClass.enemies.getLarge() < 5) {
			randomClass.enemies.add(new enemy(x, n, m, 5));
			x += 100;
			n += 100;
			m += 100;
		}
	}
	
}

