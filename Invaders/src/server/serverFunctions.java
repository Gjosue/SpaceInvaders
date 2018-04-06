package server;

import User.player;

public class serverFunctions{
	
	private player user = player.getPlayer();
	
	/**
	 * metodo para controlar el movimiento del jugador mediante las señales llegadas al servidor por parte del cliente android
	 * @param pos
	 * @param fire
	 */
	public void movement(int pos, int fire){
		if(pos == 49 | fire == -1 ) {
			user.sensorL();
		}else if(pos == 50 | fire == -1){
			user.sensorR();
		}else{
			user.stabilizer();
		}
	}
	/**
	 * metodo para controlar las balas del jugador mediante las señales llegadas al servidor por parte del cliente android
	 * @param fire
	 */
	public void fire(int fire) {
		if (fire == -1) {
			user.fire();
		}else {
			user.nonFire();
		}
	}

}
