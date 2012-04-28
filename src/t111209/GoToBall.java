package t111209;

import teams.ucmTeam.Behaviour;
import teams.ucmTeam.RobotAPI;

public class GoToBall extends Behaviour{
	
	@Override
	public void configure() {
		// No hacemos nada
	}
	
	@Override
	public int takeStep() {
		// Se situa detrás de la pelota y la empuja hasta la porteria oponente
		myRobotAPI.setBehindBall(myRobotAPI.getOpponentsGoal());
		// Si puede golpear golpea
		if (myRobotAPI.canKick())
			myRobotAPI.kick();
		return myRobotAPI.ROBOT_OK;
	}
	
	@Override
	public void onInit(RobotAPI r) {
		r.setDisplayString("goToBallBehaviour");
	}
	
	@Override
	public void end() {
		// No hacemos nada
	}
	
	@Override
	public void onRelease(RobotAPI r) {
		// No hacemos nada
	}
}
