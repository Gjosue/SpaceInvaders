package GUI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.PopupMenu;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;


public class Window {
	private String title;
	private int height, width;
	
	public static JFrame frame;
	public static Canvas canvas;
	public static Label text;
	
	public Window (String title, int height, int width) {
		this.title = title;
		this.height = height;
		this.width = width;
		createWindow();
	}
	/**
	 * creacion de la ventana del juego
	 */
	public void createWindow() {
		frame = new JFrame(title);
		frame.setBackground(Color.BLACK);
		frame.setSize(width, height);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(width, height));
		canvas.setBackground(Color.DARK_GRAY);
		canvas.setFocusable(false);
		frame.add(canvas);
		frame.pack();
		text = new Label("Server");
		frame.setLayout(new FlowLayout());
		frame.add(text);
		
		
	}
	
	public Canvas getCanvas() {
		return canvas;
	}
	
	public void createLabel() {
		
	}
}
