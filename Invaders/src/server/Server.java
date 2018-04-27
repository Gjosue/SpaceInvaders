package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import enemys.enemy;

public class Server extends Thread{
	
	private static ServerSocket server;
	private static Socket cliente;
    private static BufferedReader entrada;
    public static String command;
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
    		server = new ServerSocket(9000);
    		while(true) {
    			cliente = server.accept();
    			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
    			//salida = new PrintWriter(new OutputStreamWriter(cliente.getOutputStream()));
    			command = entrada.readLine();
    			function.actions(command);
    			//salida.print(position);
    			cliente.close();
    		}
    	}catch(IOException e){
    		e.printStackTrace();
		}
    }
}
