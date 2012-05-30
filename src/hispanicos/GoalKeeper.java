package hispanicos;

import java.util.Random;

import teams.ucmTeam.Behaviour;
import teams.ucmTeam.RobotAPI;


public class GoalKeeper extends Behaviour {

	@Override
	public void configure() {
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onInit(RobotAPI arg0) {

	}

	@Override
	public void onRelease(RobotAPI arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int takeStep() {
		// Si estamos bloqueados evitamos colisionar
		if (myRobotAPI.blocked())
			myRobotAPI.avoidCollisions();
		// Por defecto nos vamos hacia la portería
		Functions.goToOurGoal(myRobotAPI);
		
		// Si ya estamos en la portería patrullamos
		if (myRobotAPI.getOurGoal().r < 0.2)
			Functions.patrulla(myRobotAPI);
			
		// Si tenemos la pelota cerca despejamos
		if (myRobotAPI.getBall().r < 0.7 && myRobotAPI.getOurGoal().r < 0.5){
			// Nos ponemos detras
			myRobotAPI.setBehindBall(myRobotAPI.getOpponentsGoal());
			myRobotAPI.setDisplayString("A balon");
			// Intentamos despejar
			if (myRobotAPI.canKick()){
				myRobotAPI.setDisplayString("Tiraaaaaaaaa");
				//myRobotAPI.setSteerHeading(myRobotAPI.getOpponentsGoal().t);
				myRobotAPI.kick();
			}
		}
		return myRobotAPI.ROBOT_OK;
	}

}
