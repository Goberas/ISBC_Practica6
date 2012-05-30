package hispanicos;

import teams.ucmTeam.Behaviour;
import teams.ucmTeam.RobotAPI;


public class GoToBall extends Behaviour{

	public void configure() {
		// No hacemos nada
		
	}

	public void end() {
		// No hacemos nada
		
	}

	public void onInit(RobotAPI r) {
		r.setDisplayString("goToBallBehaviour");
		
	}

	public void onRelease(RobotAPI r) {
		// No hacemos nada
		
	}

	public int takeStep() {
		myRobotAPI.setBehindBall(myRobotAPI.getOpponentsGoal());
		if (myRobotAPI.canKick())
		myRobotAPI.kick();
		return myRobotAPI.ROBOT_OK;
	}

}
