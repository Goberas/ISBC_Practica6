package hispanicos;

import teams.ucmTeam.Behaviour;
import teams.ucmTeam.RobotAPI;


public class Blocker extends Behaviour{

	public void configure() {
		// No hacemos nada
	}
	
	public int takeStep() {
		if (!Functions.balonEnMiCampo(myRobotAPI)){
			Functions.bloquearPortero(myRobotAPI);
		}
		else{
			Functions.irCentroCampo(myRobotAPI);
		}
		return RobotAPI.ROBOT_OK;
	}
	
	public void onInit(RobotAPI r) {
		r.setDisplayString("Blocker");
	}
	
	
	public void end() {
		// No hacemos nada
	}
	
	
	public void onRelease(RobotAPI r) {
		// No hacemos nada
	}
}
