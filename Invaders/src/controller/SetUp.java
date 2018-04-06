package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import GUI.Window;

public class SetUp implements Runnable {
	
	private String title;
	private int width, height;
	private Thread thread;
	private boolean run;
	private Window Window;
	private BufferStrategy b;
	private Graphics g;
	private gameManager manager;
	public static final int gameWidth = 665, gameHeight = 660;
	
	public SetUp(String title, int width, int height) {
		this.title = title;
		this.width = width;
		this.height = height;
	}
	/**
	 * creacion de la ventana y llama el metodo manager para iniciar procesos
	 */
	public void init() {
		Window = new Window(title, width, height);
		manager = new gameManager();
		manager.init();
	}
	 /**
	  * metodo para inicializar el programa y llamar el thread
	  */
	public synchronized void start() {
		if(run)
			return;
			run = true;
		if(thread == null) {
			thread = new Thread (this);
			thread.start();
		}
	}
	
	public synchronized void stop() {
		if(!(run))
			return;
			run = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	/**
	 * se llama otro metodo de procesos
	 */
	public void tick() {
		manager.tick();
	}
	/**
	 * obtencion de un canvas para la pantalla del juego(no es de toda la ventana)
	 */
	public void render() {
		b = Window.getCanvas().getBufferStrategy();
		if(b == null) {
			Window.getCanvas().createBufferStrategy(3);
			return;
		}
		g = b.getDrawGraphics();
		g.clearRect(0, 0, width, height);
		//draw
		
		g.setColor(Color.BLACK);
		g.fillRect(180, 8, 1000, 688);
		manager.render(g);
		
		//end of draw
		b.show();
		g.dispose();
	}
	/**
	 * metodo para iniciar el thread y llamar algunos metodos para el funcionamiento del juego
	 */
	@Override
	public void run() {
		init();
		
		int fps = 50;
		double timePertick = 1000000000/fps;
		double delta = 0;
		long current = System.nanoTime();
		while(run) {
			delta += (System.nanoTime()-current)/timePertick;
			current = System.nanoTime();
			if(delta >= 1) {
				tick();
				render();
				delta --;
			}
		}
	}
}
