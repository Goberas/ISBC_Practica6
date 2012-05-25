import teams.ucmTeam.Behaviour;
import teams.ucmTeam.RobotAPI;


public class Delantero extends Behaviour {

	@Override
	public void configure() {
		// TODO Auto-generated method stub

	}

	@Override
	public void end() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onInit(RobotAPI arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onRelease(RobotAPI arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public int takeStep() {
		myRobotAPI.avoidCollisions();
		if (myRobotAPI.blocked()){
			myRobotAPI.avoidCollisions();
		}
		
		// Si estamos muy lejos de su portería nos acercamos
		if (myRobotAPI.getOpponentsGoal().r > 1.5)
			Functions.irASuPorteria(myRobotAPI);
		// Vamos a scorear
		else {
			Functions.goToBall(myRobotAPI);
			if (myRobotAPI.canKick())
				myRobotAPI.kick();
		}

		
		return 0;
	}

}
