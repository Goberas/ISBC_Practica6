package t111209.entrenadores;

import EDU.gatech.cc.is.util.Vec2;
import t111209.behaviours.Blocker;
import t111209.behaviours.Buscador2Behaviour;
import t111209.behaviours.BuscadorBehaviour;
import t111209.behaviours.CompiBehaviour;
import t111209.behaviours.DefensaBehaviour;
import t111209.behaviours.Delantero2Behaviour;
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
		if (_players[4].getBehaviour() != _behaviours[4]) 
			_players[4].setBehaviour(_behaviours[4]);
		
		// Si el jugador no va ganando --> Compi
		RobotAPI robot = _players[2].getRobotAPI();
		if (robot.getMyScore() >= robot.getOpponentScore()){
			for(int i=2; i<4;i++)
				_players[i].setBehaviour(_behaviours[0]);
		}
		else
			// E.o.c. --> Defensa
			for(int i=2; i<4;i++)
				_players[i].setBehaviour(_behaviours[1]);

	}
	
	@Override
	public Behaviour getDefaultBehaviour(int id) {
		switch (id) {
		case 0:
			return _behaviours[2];	// Portero
			
		case 1:
			return _behaviours[3];	// Buscador
			
		case 2:
			return _behaviours[1];	// Defensa
			
		case 3:
			return _behaviours[0];	// Compi
			
		case 4:
			return _behaviours[4];	// Delantero
			
		default:
			return _behaviours[0];
		}
		
		
	}
	
	@Override
	public Behaviour[] createBehaviours() {
		return new Behaviour[] {new CompiBehaviour(), 		//0
								new DefensaBehaviour(), 	//1
								new PorteroBehaviour(),		//2
								new Buscador2Behaviour(),	//3
								new Delantero2Behaviour()};	//4
		
	}
}
