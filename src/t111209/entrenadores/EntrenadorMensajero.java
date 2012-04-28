package t111209.entrenadores;

import t111209.MensajePosicion;
import t111209.behaviours.Blocker;
import t111209.behaviours.GoToBall;
import t111209.behaviours.GoToPosition;
import teams.ucmTeam.Behaviour;
import teams.ucmTeam.Message.Type;
import teams.ucmTeam.RobotAPI;
import teams.ucmTeam.TeamManager;

public class EntrenadorMensajero extends TeamManager {
	
	@Override
	public int onConfigure() {
		return RobotAPI.ROBOT_OK;
	}
	
	public void onTakeStep() {
		// Manda al jugador 0 a la portería contraria
		RobotAPI robot0 = _players[0].getRobotAPI();
		MensajePosicion message = new MensajePosicion();
		message.setReceiver(0);
		message.setType(Type.unicast);
		message.setPosicion(robot0.toFieldCoordinates(robot0.getOpponentsGoal()));
		sendMessage(message);
	}
	
	public Behaviour getDefaultBehaviour(int id) {
		if (id==0)
			return _behaviours[2];
		else
			return _behaviours[0];
	}
	
	public Behaviour[] createBehaviours() {
		return new Behaviour[] {new GoToBall(),
								new Blocker(),
								new GoToPosition()};
	}
	
}
