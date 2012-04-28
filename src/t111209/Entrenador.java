package t111209;

import teams.ucmTeam.Behaviour;
import teams.ucmTeam.RobotAPI;
import teams.ucmTeam.TeamManager;

public class Entrenador extends TeamManager {
	
	@Override
	public int onConfigure() {
		return RobotAPI.ROBOT_OK;
	}
	
	@Override
	public void onTakeStep() {
		// No hacemos nada
	}
	
	@Override
	public Behaviour getDefaultBehaviour(int id) {
		return _behaviours[0];
	}
	
	@Override
	public Behaviour[] createBehaviours() {
		Behaviour[] behav =new Behaviour[1];
		behav[0]=new GoToBall();
		return behav;
	}
}
