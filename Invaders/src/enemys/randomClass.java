package enemys;

import java.awt.Graphics;
import java.util.Random;
import Lists.DoublyLinked;
import Lists.LinkedList;

public class randomClass {
	
	public static LinkedList<enemy> enemys = new LinkedList<enemy>();
	public static DoublyLinked<enemy> enemys1 = new DoublyLinked<enemy>();
	private Basic basic = new Basic();
	private classA A = new classA();
	private classB B = new classB();
	private classC C = new classC();
	private classD D = new classD();
	private classE E = new classE();
	private String clase = "";
	
	
	public void init() {
		String [] tipos = {"basic", "A"};
		Random random = new Random();
		int select = random.nextInt(tipos.length);
		clase = tipos[select];
		
		if(clase.equals("basic")){
			basic.init();
		}else if(clase.equals("A")) {
			A.init();
		}else if(clase.equals("B")) {
			B.init();
		}else if(clase.equals("C")) {
			C.init();
		}else if(clase.equals("D")) {
			D.init();
		}else {
			E.init();
		}
	}
	
	public void tick() {
		if(clase.equals("basic") | clase.equals("A") ){
			for (int i = 0; i < enemys.getLarge(); i ++) {
				enemys.getNodo(i).tick();
			}
		}else if(clase.equals("B")) {
			for (int i = 0; i < enemys1.getLarge(); i ++) {
				enemys1.getNodo(i).tick();
			}
		}else if(clase.equals("C")) {
			
		}else if(clase.equals("D")) {
			
		}else {
			
		}
	}
	
	public void render(Graphics g) {
		if(clase.equals("basic") | clase.equals("A")){
			for(int i = 0; i < enemys.getLarge(); i++) {
				enemys.getNodo(i).render(g);
			}
		}else if(clase.equals("B")) {
			for(int i = 0; i < enemys1.getLarge(); i++) {
				enemys1.getNodo(i).render(g);
			}
				/**int h = 0;
				while(h < 20) {
					B.change(g);
					h ++;
				}**/
			
		}else if(clase.equals("C")) {
			
		}else if(clase.equals("D")) {
			
		}else {
			
		}
	}

}
