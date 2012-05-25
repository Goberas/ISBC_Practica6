import teams.ucmTeam.Behaviour;
import teams.ucmTeam.RobotAPI;


public class Defender extends Behaviour {

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
			Functions.irCentroCampo(myRobotAPI);
			myRobotAPI.setDisplayString("Esquivando");
		}

		// Por defecto nos vamos hacia la portería (si estamos muy lejos)
		if (myRobotAPI.getOurGoal().r > 1.5)
			Functions.goToOurGoal(myRobotAPI);
		else
			// Si tenemos la pelota cerca despejamos
			if (myRobotAPI.getBall().r < 0.3){
				myRobotAPI.setBehindBall(myRobotAPI.getOpponentsGoal());
				myRobotAPI.setDisplayString("Despejando");
				if (myRobotAPI.canKick())
					myRobotAPI.kick();
			}
			// Sino no bloqueamos a alguien
			else{
				Functions.patrulla(myRobotAPI);
			}
		
		return myRobotAPI.ROBOT_OK;
	}

}
