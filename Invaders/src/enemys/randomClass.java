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
	
	public static LinkedList<enemy> enemys = new LinkedList<enemy>();
	public static DoublyLinked<enemy> enemys1 = new DoublyLinked<enemy>();
	public static CircularList<enemy> enemys2 = new CircularList<enemy>();
	public static Basic basic = new Basic();
	private classA A = new classA();
	private classB B = new classB();
	private classC C = new classC();
	private classD D = new classD();
	private String clase = "";
	private String nextclass = "";
	public static int cont = 0;
	public static int level = 1;
	private int counter = 1;
	BufferedImage image;
	public static DoublyLinked<Integer> tipos = new DoublyLinked<Integer>();
	
	
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
			for (int i = 0; i < enemys.getLarge(); i ++) {
				enemys.getNodo(i).getDato().tick();
			}
		}else if(clase.equals("B")) {
			for (int i = 0; i < enemys1.getLarge(); i ++) {
				enemy ene = (enemy) enemys1.getNodo(i).getDato();
				ene.tick();
			}
		}else if(clase.equals("C")) {
			for (int i = 0; i < enemys2.getLarge(); i ++) {
				enemy ene = (enemy) enemys2.getNodo(i).getDato();
				ene.tick();
			}
		}else {
		}
			
	}
	
	public void render(Graphics g) {
//		try {
//			image =  ImageIO.read(this.getClass().getResource("/fondo.png"));
//		}catch(IOException e) {
//		}
//		g.drawImage(image, 150, 8, 1060, 688, Window.frame);
		counter ++;
		if(clase.equals("basic") | clase.equals("A")){
			for(int i = 0; i < enemys.getLarge(); i++) {
				enemys.getNodo(i).getDato().render(g);
			}
		}else if(clase.equals("B")) {
			for(int i = 0; i < enemys1.getLarge(); i++) {
				enemy ene = (enemy) enemys1.getNodo(i).getDato();
				ene.render(g);
			}
			if(counter % 10 == 0) {
				Random random = new Random();
				int select = random.nextInt(tipos.getLarge() + 1);
				int rnd = tipos.getNodo(select - 1).getDato();
				enemys1.change(0, rnd);
			}
		}else if(clase.equals("C")) {
			for(int i = 0; i < enemys2.getLarge(); i++) {
				enemy ene = (enemy) enemys2.getNodo(i).getDato();
				ene.render(g);
			}
		}else{
			
		}
			
		
	}
	
	public static void put() {
		int i = 0;
		int n = 0;
		int m = limits();
		if(enemys.getLarge() != 0) {
			int xa = enemys.getNodo(0).getDato().x;
			while(i < enemys.getLarge()) {
				enemys.getNodo(i).getDato().x = xa;
				enemys.getNodo(i).getDato().a = n;
				enemys.getNodo(i).getDato().b = m;
				xa += 100;
				n += 100;
				m += 100;
				i ++;
			}
		}
		if(enemys1.getLarge() != 0) {
			int xb = enemys1.getNodo(0).getDato().x;
			while(i < enemys1.getLarge()) {
				enemys1.getNodo(i).getDato().x = xb;
				enemys1.getNodo(i).getDato().a = n;
				enemys1.getNodo(i).getDato().b = m;
				xb += 100;
				n += 100;
				m += 100;
				i ++;
			}
		}
		if(enemys2.getLarge() != 0) {
			int xc = enemys2.getNodo(0).getDato().x;
			while(i < enemys2.getLarge()) {
				enemys2.getNodo(i).getDato().x = xc;
				enemys2.getNodo(i).getDato().a = n;
				enemys2.getNodo(i).getDato().b = m;
				xc += 100;
				n += 100;
				m += 100;
				i ++;
			}
		}
	}
	
	public static int limits() {
		if(enemys.getLarge() == 4 | enemys1.getLarge() == 4 | enemys2.getLarge() == 4) {
			return 630;
		}else if(enemys.getLarge() == 3 | enemys1.getLarge() == 3 | enemys2.getLarge() == 3) {
			return 730;
		}else if(enemys.getLarge() == 2 | enemys1.getLarge() == 2 | enemys2.getLarge() == 2) {
			return 830;
		}else {
			return 930;
		}
	}
	
	public void generateLevels() {
		String [] tipos = {"B"};
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
		System.out.println(player.getPlayer().score);
	}
	
	public void lose() {
		if(enemys.getLarge() != 0) {
			if(enemys.getHead().getDato().y > 550){
				enemys.deleteAll();
				restart();
			}
		}
		if(enemys1.getLarge() != 0) {
			if(enemys1.getHead().getDato().y > 550){
				enemys1.deleteAll();
				restart();
			}
		}
		if(enemys2.getLarge() != 0) {
			if(enemys2.getHead().getDato().y > 550){
				enemys2.deleteAll();
				restart();
			}
		}
	}
	
	public void restart() {
		level = 1;
		player.getPlayer().score = 0;
		cont = 0;
		JOptionPane.showMessageDialog(null,"HAS PERDIDO, COMIENZA DE NUEVO!!");
		generateLevels();
	}

}
