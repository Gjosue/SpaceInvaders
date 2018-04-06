package User;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GUI.Window;
import controller.SetUp;
import controller.gameManager;

public class player implements KeyListener {
	
	private int x, y;
	private boolean left, right, fire;
	private long current, delay;
	private static player instance = null;
	
	private player(int x, int y) {
		this.x = x;
		this.y = y;
	}
	/**
	 * singleton de la clase player
	 * @return
	 */
	public static player getPlayer() {
		if(instance == null) {
			instance = new player(SetUp.gameWidth, SetUp.gameHeight);
		}
		return instance;
	}
	/**
	 * se añaden variables que se necesitan para otros procesos
	 */
	public void init() {
		Window.frame.addKeyListener(this);
		current = System.nanoTime();
		delay = 100;
	}
	/**
	 * maneja la posicion y movimiento del jugador y los disparos
	 */
	public void tick() {
		if (x > 180) {
			if (left) {
				x -= 5;
			}
		}
		if (x < 1150) {
			if (right) {
				x += 5;
			}
		}
		if (fire) {
			long breaks = (System.nanoTime() - current)/1000000;
			if (breaks > delay) {
				gameManager.bullet.add(new bullet(x + 12, y));
			}
			current = System.nanoTime();
		}
		
	}
	/**
	 * definicion de las dimensiones del cuadro jugador
	 * @param g
	 */
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, 30, 30);
	}
	/**
	 * metodo que analiza las teclas presionadas en el teclado para que el jugador dispare o se mueva
	 */
	public void keyPressed(KeyEvent e) {
		int source = e.getKeyCode();
		if(source == KeyEvent.VK_A) {
			left = true;
		}
		if (source == KeyEvent.VK_D){
			right = true;
		}
		if (source == KeyEvent.VK_L) {
			fire = true;
		}
	}
	/**
	 * metodo que analiza las teclas que se sueltan en el teclado para que el jugador se detenga de disparar o moverse
	 */
	public void keyReleased(KeyEvent e) {
		int source = e.getKeyCode();
		if (source == KeyEvent.VK_A) {
			left = false;
		}
		if (source == KeyEvent.VK_D) {
			right = false;
		}
		if (source == KeyEvent.VK_L) {
			fire = false;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
	/**
	 * permite el movimiento del jugador hacia la izquierda
	 */
	public void sensorL() {
		right = false;
		left = true;
	}
	/**
	 * permite el movimiento del jugador hacia la derecha
	 */
	public void sensorR() {
		right = true;
		left = false;
	}
	/**
	 * detiene el movimiento del jugador
	 */
	public void stabilizer() {
		right = false;
		left = false;
	}
	/**
	 * permite que el jugador dispare
	 */
	public void fire() {
		fire = true;
	}
	/**
	 * detiene los disparos del juagdor
	 */
	public void nonFire() {
		fire = false;
	}
}
