package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server extends Thread{
	
	private static ServerSocket server;
	private static Socket cliente;
    private static BufferedReader entrada;
    public static int position;
    public static int fire;
    private static PrintWriter salida;
    private static serverFunctions function = new serverFunctions();
    
    public Server(String msg) {
    	super(msg);
    }
    /**
     * creacion de un servidor
     */
    public void run() {	
    	try {
    		server = new ServerSocket(8000);
    		while(true) {
    			cliente = server.accept();
    			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
    			salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));
    			position = entrada.read();
    			fire = entrada.read();
    			//System.out.println(fire);
    			function.movement(position, fire);
    			function.fire(fire);
    			//salida.print(position);
    			cliente.close();
    		}
    	}catch(IOException e){
    		e.printStackTrace();
		}
    }
}
