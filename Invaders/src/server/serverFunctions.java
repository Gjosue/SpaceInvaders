package server;

import User.player;

public class serverFunctions{
	
	private player user = player.getPlayer();
	
	/**
	 * metodo para controlar el movimiento del jugador mediante las señales llegadas al servidor por parte del cliente android
	 * @param pos
	 * @param fire
	 */
	public void movement(String pos){
		if(pos.equals("left")) {
			user.sensorL();
		}else if(pos.equals("right")){
			user.sensorR();
		}else{
			user.stabilizer();
		}
	}
	/**
	 * metodo para controlar las balas del jugador mediante las señales llegadas al servidor por parte del cliente android
	 * @param fire
	 */
	public void fire(String fire) {
		if (fire.equals("fire")) {
			user.fire();
		}else {
			user.nonFire();
		}
	}

}
