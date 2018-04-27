package server;

import User.player;

public class serverFunctions{
	
	private player user = player.getPlayer();
	
	public void actions(String command) {
		if (command.equals("left")){
			user.left = true;
			user.right = false;
		}else if(command.equals("right")) {
			user.right = true;
			user.left = false;
		}else if(command.equals("fire")) {
			user.fire = true;
			user.shoot = true;
		}else {
			user.left = false;
			user.right = false;
		}
	}
}
