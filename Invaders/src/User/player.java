package User;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.Window;
import controller.SetUp;
import controller.gameManager;

public class player implements KeyListener {
	
	private int x, y;
	public boolean left, right, fire;
	private static player instance = null;
	public boolean shoot = true;
	public static int score = 0;
	
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
			instance = new player(SetUp.gameWidth, SetUp.gameHeight - 30);
		}
		return instance;
	}
	/**
	 * se añaden variables que se necesitan para otros procesos
	 */
	public void init() {
		Window.frame.addKeyListener(this);
	}
	/**
	 * maneja la posicion y movimiento del jugador y los disparos
	 */
	public void tick() {
		if (x > 190) {
			if (left) {
				x -= 20;
			}
		}
		if (x < 1110) {
			if (right){
				x += 20;
			}
		}
		if (fire) {
			if (shoot) {
				gameManager.bullet.add(new bullet(x + 27, y));
				shoot = false;
			}
		}
		
	}
	/**
	 * definicion de las dimensiones del cuadro jugador
	 * @param g
	 */
	public void render(Graphics g) {
		try {
			BufferedImage image =  ImageIO.read(this.getClass().getResource("/misc/ship.png"));
			g.drawImage(image, x, y, 60, 60, Window.frame);
//			g.setColor(Color.GREEN);
//			g.fillRect(x, y, 30, 30);
			}catch(IOException e) {
			}
		
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
			shoot = true;
		}
	}
	
	public void keyTyped(KeyEvent e) {
		
	}
}
