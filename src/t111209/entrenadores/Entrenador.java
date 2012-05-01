package t111209.entrenadores;

import EDU.gatech.cc.is.util.Vec2;
import t111209.behaviours.Blocker;
import t111209.behaviours.BuscadorBehaviour;
import t111209.behaviours.GoToBall;
import t111209.behaviours.PorteroBehaviour;
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
		
		if (_players[0].getBehaviour() != _behaviours[2]) 
			_players[0].setBehaviour(_behaviours[2]);
		if (_players[1].getBehaviour() != _behaviours[3]) 
			_players[1].setBehaviour(_behaviours[3]);
		
		// Si el jugador esta en su campo y no va ganando --> GoToBall
		RobotAPI robot = _players[2].getRobotAPI();
		if ((robot.getPosition().x * robot.getFieldSide()>=0) &&
			(robot.getMyScore() <= robot.getOpponentScore())){
			for(int i=2; i<5;i++)
				_players[i].setBehaviour(_behaviours[0]);
		}
		else
			// E.o.c. --> Blocker
			for(int i=1; i<5;i++)
				_players[i].setBehaviour(_behaviours[0]);

	}
	
	@Override
	public Behaviour getDefaultBehaviour(int id) {
		switch (id) {
		case 0:
			return _behaviours[2];
			
		case 1:
			return _behaviours[3];
			
		default:
			return _behaviours[0];
		}
		
		
	}
	
	@Override
	public Behaviour[] createBehaviours() {
		return new Behaviour[] {new GoToBall(), 
								new Blocker(), 
								new PorteroBehaviour(),
								new BuscadorBehaviour()};
		
	}
}
