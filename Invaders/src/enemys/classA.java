package enemys;

public class classA {
	
	public void init() {
		int x = 180;
		int n = 0;
		int m = 530;
		int random = (int) (Math.random() * 5 + 1);
		while(randomClass.enemies.getLarge() < 5) {
			if(randomClass.enemies.getLarge() + 1 != random) {
				randomClass.enemies.add(new enemy(x, n, m, 8));
				x += 100;
				n += 100;
				m += 100;
			}else {
				randomClass.enemies.add(new Boss(x, n, m, true, 6));
				x += 100;
				n += 100;
				m += 100;
			}
		}
	}
	
}
