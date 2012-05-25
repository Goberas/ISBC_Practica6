import teams.ucmTeam.Behaviour;
import teams.ucmTeam.Message.Type;
import teams.ucmTeam.RobotAPI;
import teams.ucmTeam.TeamManager;


public class Coach extends TeamManager{

	/*
	public Behaviour[] createBehaviours() {
		return new Behaviour[] {new GoToBall(), new Blocker()};
	}
	*/
/*
	public Behaviour getDefaultBehaviour(int arg0) {
		return _behaviours[0];
	}
	*/

	public int onConfigure() {
		return RobotAPI.ROBOT_OK;
	}

	/*protected void onTakeStep() {
		// Si el jugador esta en su campo --> GoToBall
		RobotAPI robot = _players[2].getRobotAPI();
		if (robot.getPosition().x * robot.getFieldSide()>=0)
			_players[2].setBehaviour(_behaviours[0]);
		else
		// E.o.c. --> Blocker
			_players[2].setBehaviour(_behaviours[1]);
		
	}*/
	
	 // Para que el entrenador envie mensajes a los jugadores
	public void onTakeStep() {
		// Manda al jugador 0 a la portería contraria
		RobotAPI robot0 = _players[0].getRobotAPI();
		PositionMessage message = new PositionMessage();
		message.setReceiver(0);
		message.setType(Type.unicast);
		message.setPosicion(robot0.toFieldCoordinates(robot0.getOpponentsGoal()));
		sendMessage(message);
	
	}
	
	public Behaviour getDefaultBehaviour(int id) {
		if (id==0)
			return _behaviours[1];
		else if (id==1)
			return _behaviours[1];
		else if (id==2)
			return _behaviours[2];
		else if (id==3)
			return _behaviours[3];
		else
			return _behaviours[0];
	}
	
	public Behaviour[] createBehaviours() {
		//return new Behaviour[] {new GoToBall(),new Blocker(), new GoToPosition()};
		return new Behaviour[] {new GoalKeeper(), new Defender(), new Blocker(), new Delantero()};
	}
	

}
