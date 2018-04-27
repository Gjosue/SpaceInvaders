package enemys;

import java.awt.Graphics;
import java.util.Random;

import Lists.Nodo;

public class classB {
	
	public void init() {
		randomClass.tipos.add(1, 5);
		randomClass.tipos.add(2, 5);
		randomClass.tipos.add(3, 5);
		randomClass.tipos.add(4, 4);
		int x = 180;
		int n = 0;
		int m = 530;
		int id = 1;
		int random = (int) (Math.random() * 5 + 1);
		while(randomClass.enemies1.getLarge() < 5) {
			if(randomClass.enemies1.getLarge() + 1 != random) {
				randomClass.enemies1.add(new enemy(x, n, m, id), id);
				x += 100;
				n += 100;
				m += 100;
				id ++;
			}else {
				randomClass.enemies1.add(new Boss(x, n, m, true, 0), 0);
				x += 100;
				n += 100;
				m += 100;
			}
		}
	}
}
