package enemys;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import GUI.Window;
import Lists.CircularList;
import Lists.DoublyLinked;
import Lists.LinkedList;
import User.player;

public class randomClass {
	
	public static LinkedList<enemy> enemies = new LinkedList<enemy>();
	public static DoublyLinked<enemy> enemies1 = new DoublyLinked<enemy>();
	public static CircularList<enemy> enemies2 = new CircularList<enemy>();
	public static Basic basic = new Basic();
	private classA A = new classA();
	private classB B = new classB();
	private classC C = new classC();
	private classD D = new classD();
	public static String clase = "";
	public static String nextclass = "";
	public static int cont = 0;
	public static int level = 1;
	private int counter = 1;
	BufferedImage image;
	public static DoublyLinked<Integer> tipos = new DoublyLinked<Integer>();
	public static DoublyLinked<Integer> tipos2 = new DoublyLinked<Integer>();
	
	
	public void init() {
		if(clase.equals("basic")){
			basic.init();
		}else if(clase.equals("A")) {
			A.init();
		}else if(clase.equals("B")) {
			B.init();
		}else if(clase.equals("C")) {
			C.init();
		}else {
			D.init();
	}
		
	}
	
	public void tick() {
		lose();
		if(clase.equals("basic") | clase.equals("A") ){
			for (int i = 0; i < enemies.getLarge(); i ++) {
				enemies.getNodo(i).getDato().tick();
			}
		}else if(clase.equals("B")) {
			for (int i = 0; i < enemies1.getLarge(); i ++) {
				enemy ene = (enemy) enemies1.getNodo(i).getDato();
				ene.tick();
			}
		}else if(clase.equals("C")) {
			for (int i = 0; i < enemies2.getLarge(); i ++) {
				enemy ene = (enemy) enemies2.getNodo(i).getDato();
				ene.tick();
			}
		}else {
		}
			
	}
	
	public void render(Graphics g) {
		counter ++;
		if(clase.equals("basic") | clase.equals("A")){
			for(int i = 0; i < enemies.getLarge(); i++) {
				enemies.getNodo(i).getDato().render(g);
			}
		}else if(clase.equals("B")) {
			for(int i = 0; i < enemies1.getLarge(); i++) {
				enemy ene = (enemy) enemies1.getNodo(i).getDato();
				ene.render(g);
			}
			if(counter % 30 == 0) {
				Random random = new Random();
				int select = random.nextInt(tipos.getLarge() + 1);
				int rnd = tipos.getNodo(select - 1).getDato();
				enemies1.change(0, rnd);
			}
		}else if(clase.equals("C")) {
			for(int i = 0; i < enemies2.getLarge(); i++) {
				enemy ene = (enemy) enemies2.getNodo(i).getDato();
				ene.render(g);
			}
		}else{
			
		}
			
		
	}
	
	public static void change() {
		Random random = new Random();
		int select = random.nextInt(tipos2.getLarge() + 1);
		int rnd = tipos2.getNodo(select - 1).getDato();
		enemies2.change(0, rnd);
	}
	
	public static void put() {
		int i = 0;
		int n = 0;
		int m = limits();
		if(enemies.getLarge() != 0) {
			int xa = enemies.getNodo(0).getDato().x;
			while(i < enemies.getLarge()) {
				enemies.getNodo(i).getDato().x = xa;
				enemies.getNodo(i).getDato().a = n;
				enemies.getNodo(i).getDato().b = m;
				xa += 100;
				n += 100;
				m += 100;
				i ++;
			}
		}
		if(enemies1.getLarge() != 0) {
			int xb = enemies1.getNodo(0).getDato().x;
			while(i < enemies1.getLarge()) {
				enemies1.getNodo(i).getDato().x = xb;
				enemies1.getNodo(i).getDato().a = n;
				enemies1.getNodo(i).getDato().b = m;
				xb += 100;
				n += 100;
				m += 100;
				i ++;
			}
		}
		if(enemies2.getLarge() != 0) {
			int xc = enemies2.getNodo(0).getDato().x;
			while(i < enemies2.getLarge()) {
				enemies2.getNodo(i).getDato().x = xc;
				enemies2.getNodo(i).getDato().a = n;
				enemies2.getNodo(i).getDato().b = m;
				xc += 100;
				n += 100;
				m += 100;
				i ++;
			}
		}
	}
	
	public static int limits() {
		if(enemies.getLarge() == 4 | enemies1.getLarge() == 4 | enemies2.getLarge() == 4) {
			return 630;
		}else if(enemies.getLarge() == 3 | enemies1.getLarge() == 3 | enemies2.getLarge() == 3) {
			return 730;
		}else if(enemies.getLarge() == 2 | enemies1.getLarge() == 2 | enemies2.getLarge() == 2) {
			return 830;
		}else {
			return 930;
		}
	}
	
	public void generateLevels() {
		String [] tipos = {"C"};
		Random random = new Random();
		int select = random.nextInt(tipos.length);
		if(level == 1) {
			clase = tipos[select];
			init();
			int select2 = random.nextInt(tipos.length);
			nextclass = tipos[select2];
		}else if(level == 2) {
				clase = nextclass;
				enemy.more = 15;
				init();
				nextclass = tipos[select];
		}else if(level == 3) {
				clase = nextclass;
				enemy.more = 20;
				init();
				nextclass = tipos[select];
		}else if(level == 4) {
				clase = nextclass;
				enemy.more = 25;
				init();
				nextclass = tipos[select];
		}else if(level == 5) {
				clase = nextclass;
				enemy.more = 30;
				init();
				nextclass = tipos[select];
		}
	}
	
	public void lose() {
		if(enemies.getLarge() != 0) {
			if(enemies.getHead().getDato().y > 550){
				enemies.deleteAll();
				restart();
			}
		}
		if(enemies1.getLarge() != 0) {
			if(enemies1.getHead().getDato().y > 550){
				enemies1.deleteAll();
				restart();
			}
		}
		if(enemies2.getLarge() != 0) {
			if(enemies2.getHead().getDato().y > 550){
				enemies2.deleteAll();
				restart();
			}
		}
	}
	
	public void restart() {
		level = 1;
		player.getPlayer().score = 0;
		cont = 0;
		enemy.more = 10;
		JOptionPane.showMessageDialog(null,"HAS PERDIDO, COMIENZA DE NUEVO!!");
		generateLevels();
	}
	
	
}
