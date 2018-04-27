package enemys;

import java.awt.Graphics;
import java.util.Random;

import Lists.Nodo;

public class classB {
	
	public int positionEnemy;
	public int positionBoss;
	public int position;
	
	public void init() {
		randomClass.tipos.add(1, 5, "d");
		randomClass.tipos.add(2, 5, "f");
		randomClass.tipos.add(3, 5, "FD");
		randomClass.tipos.add(4, 4, "FD");
		int x = 180;
		int n = 0;
		int m = 530;
		int id = 1;
		int random = (int) (Math.random() * 5 + 1);
		while(randomClass.enemys1.getLarge() < 5) {
			if(randomClass.enemys1.getLarge() + 1 != random) {
				randomClass.enemys1.add(new enemy(x, n, m, "/misc/enemy.png", id), id, "/miscimages/enemy.png");
				x += 100;
				n += 100;
				m += 100;
				id ++;
			}else {
				randomClass.enemys1.add(new Boss(x, n, m, true, "/misc/boss.png", 0), 0, "/misc/boss.png");
				x += 100;
				n += 100;
				m += 100;
			}
		}
	}
	
//	public void search(int boss) {
//		position = 0;
//		while(position < randomClass.enemys1.getLarge()){
//			enemy en = (enemy) randomClass.enemys1.getNodo(position).getDato();
//			if(en.ID == boss){
//				break;
//			}else {
//				position ++;
//			}
//		}
//	}
//	
//	public void change(int boss, int ene) {
//		search(boss);
//		positionBoss = position;
//		search(ene);
//		positionEnemy = position;
//		enemy Boss = (enemy) randomClass.enemys1.getNodo(positionBoss).getDato();
//		randomClass.enemys1.setNodo(positionEnemy, Boss);
//		enemy enem = (enemy) randomClass.enemys1.getNodo(positionEnemy).getDato();
//		randomClass.enemys1.setNodo(positionBoss, enem);
//	}
}
