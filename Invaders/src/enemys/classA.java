package enemys;

public class classA {
	
	public void init() {
		int x = 180;
		int n = 0;
		int m = 530;
		int random = (int) (Math.random() * 5 + 1);
		while(randomClass.enemys.getLarge() < 5) {
			if(randomClass.enemys.getLarge() + 1 != random) {
				randomClass.enemys.add(new enemy(x, n, m, "/misc/enemy.png", 8));
				x += 100;
				n += 100;
				m += 100;
			}else {
				randomClass.enemys.add(new Boss(x, n, m, true, "/misc/boss.png", 6));
				x += 100;
				n += 100;
				m += 100;
			}
		}
	}
	
}
