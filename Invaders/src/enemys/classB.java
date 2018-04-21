package enemys;

import java.awt.Graphics;
import java.util.Random;

public class classB {
	
	private enemy primero;
	private enemy segundo;
	private enemy tercero;
	private enemy cuarto;
	private enemy quinto;
	
	public void init() {
		int x = 180;
		int n = 0;
		int m = 570;
		int id = 1;
		int random = (int) (Math.random() * 5 + 1);
		while(randomClass.enemys1.getLarge() < 5) {
			if(randomClass.enemys1.getLarge() + 1 != random) {
				randomClass.enemys1.add(new enemy(x, n, m, id));
				x += 100;
				n += 100;
				m += 100;
				id ++;
			}else {
				randomClass.enemys1.add(new Boss(x, n, m, id, true));
				x += 100;
				n += 100;
				m += 100;
				id ++;
			}
		}
	}
	
	public void getEnemys() {
		int i = 0;
		while(i < randomClass.enemys1.getLarge()) {
			if(i == 0) {
				primero = randomClass.enemys1.getNodo(i);
			}else if(i == 1) {
				segundo = randomClass.enemys1.getNodo(i);
			}else if(i == 2) {
				tercero = randomClass.enemys1.getNodo(i);
			}else if(i == 3) {
				cuarto = randomClass.enemys1.getNodo(i);
			}else {
				quinto = randomClass.enemys1.getNodo(i);
			}
			i ++;
		}
	}
	
	/**public void change(Graphics g) {
		if(randomClass.enemys1.getLarge() == 1) {	
			
		}else{
			if(randomClass.enemys1.getLarge() == 2) {
				getEnemys();
				randomClass.enemys1.deleteAll();
				int x = 180;
				int n = 0;
				int m = 570;
				int id = 1;
				int j = 1;
				while(j < 3) {
					if(j == 1) {
						segundo.x = x;
						segundo.a = n;
						segundo.b = m;
						randomClass.enemys1.add(segundo);
					}else {
						primero.x = x;
						primero.a = n;
						primero.b = m;
						randomClass.enemys1.add(primero);
					}
					j ++;
					x += 100;
					n += 100;
					m += 100;
					id ++;	
				}
				for (int i = 0; i < randomClass.enemys1.getLarge(); i ++) {
					randomClass.enemys1.getNodo(i).tick();
				}
				for(int i = 0; i < randomClass.enemys1.getLarge(); i++) {
					randomClass.enemys1.getNodo(i).render(g);
				}
			}else if(randomClass.enemys1.getLarge() == 3) {
				getEnemys();
				randomClass.enemys1.deleteAll();
				int x = 180;
				int n = 0;
				int m = 570;
				int id = 1;
				int j = 1;
				while(j < 4) {
					if(j == 1){
						tercero.x = x;
						tercero.a = n;
						tercero.b = m;
						randomClass.enemys1.add(tercero);
					}else if(j == 2) {
						primero.x = x;
						primero.a = n;
						primero.b = m;
						randomClass.enemys1.add(primero);
					}else {
						tercero.x = x;
						segundo.a = n;
						segundo.b = m;
						randomClass.enemys1.add(segundo);
					}
					j ++;
					x += 100;
					n += 100;
					m += 100;
					id ++;	
				}
				for (int i = 0; i < randomClass.enemys1.getLarge(); i ++) {
					randomClass.enemys1.getNodo(i).tick();
				}
				for(int i = 0; i < randomClass.enemys1.getLarge(); i++) {
					randomClass.enemys1.getNodo(i).render(g);
				}
			}else if(randomClass.enemys1.getLarge() == 4) {
				getEnemys();
				randomClass.enemys1.deleteAll();
				int x = 180;
				int n = 0;
				int m = 570;
				int id = 1;
				int j = 1;
				while(j < 5) {
					if(j == 1){
						cuarto.x = x;
						cuarto.a = n;
						cuarto.b = m;
						randomClass.enemys1.add(cuarto);
					}else if(j == 2) {
						primero.x = x;
						primero.a = n;
						primero.b = m;
						randomClass.enemys1.add(primero);
					}else if(j == 3) {
						tercero.x = x;
						segundo.a = n;
						segundo.b = m;
						randomClass.enemys1.add(segundo);
					}else {
						tercero.x = x;
						tercero.a = n;
						tercero.b = m;
						randomClass.enemys1.add(tercero);
					}
					j ++;
					x += 100;
					n += 100;
					m += 100;
					id ++;	
				}
				for (int i = 0; i < randomClass.enemys1.getLarge(); i ++) {
					randomClass.enemys1.getNodo(i).tick();
				}
				for(int i = 0; i < randomClass.enemys1.getLarge(); i++) {
					randomClass.enemys1.getNodo(i).render(g);
				}
			}else {
				getEnemys();
				randomClass.enemys1.deleteAll();
				int x = 180;
				int n = 0;
				int m = 570;
				int id = 1;
				int j = 1;
				while(j < 6) {
					if(j == 1){
						quinto.x = x;
						quinto.a = n;
						quinto.b = m;
						randomClass.enemys1.add(quinto);
					}else if(j == 2) {
						primero.x = x;
						primero.a = n;
						primero.b = m;
						randomClass.enemys1.add(primero);
					}else if(j == 3) {
						tercero.x = x;
						segundo.a = n;
						segundo.b = m;
						randomClass.enemys1.add(segundo);
					}else if(j == 4)  {
						tercero.x = x;
						tercero.a = n;
						tercero.b = m;
						randomClass.enemys1.add(tercero);
					}else {
						cuarto.x = x;
						cuarto.a = n;
						cuarto.b = m;
						randomClass.enemys1.add(cuarto);
					}
					j ++;
					x += 100;
					n += 100;
					m += 100;
					id ++;	
				}
				for (int i = 0; i < randomClass.enemys1.getLarge(); i ++) {
					randomClass.enemys1.getNodo(i).tick();
				}
				for(int i = 0; i < randomClass.enemys1.getLarge(); i++) {
					randomClass.enemys1.getNodo(i).render(g);
				}
			}
		}
	}**/
	
}
