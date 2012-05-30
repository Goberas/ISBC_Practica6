package t111209.entrenadores;

import t111209.behaviours.Buscador2Behaviour;
import t111209.behaviours.CompiBehaviour;
import t111209.behaviours.DefensaBehaviour;
import t111209.behaviours.NehuenMaradonaBehaviour;
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
		
		
		// Si el jugador no va ganando --> Compi
		RobotAPI robot = _players[2].getRobotAPI();
		if (robot.getMyScore() >= robot.getOpponentScore()){
			for(int i=2; i<3;i++)
				_players[i].setBehaviour(_behaviours[0]);
		}
		else
			// E.o.c. --> Defensa
			for(int i=2; i<3;i++)
				_players[i].setBehaviour(_behaviours[1]);
		
		// Si el portero esta bloqueado mete un portero nuevo
		RobotAPI portero1 = _players[0].getRobotAPI();
		RobotAPI portero2 = _players[3].getRobotAPI();
		
		if((_players[0].getBehaviour()==_behaviours[2]) && portero1.blocked()){	// Si el jugador 0 es portero y esta bloqueado
			_players[0].setBehaviour(_behaviours[1]);	// jugador 0 es defensa
			_players[3].setBehaviour(_behaviours[2]);	// jugador 3 es portero
		}
		else if((_players[3].getBehaviour()==_behaviours[2]) && portero2.blocked()){	// Si el jugador 3 es portero y esta bloqueado
			_players[3].setBehaviour(_behaviours[1]);	// jugador 3 es defensa
			_players[0].setBehaviour(_behaviours[2]);	// jugador 0 es portero
		}
		
		
		RobotAPI delantero1 = _players[4].getRobotAPI();
		if(delantero1.isBlocking(delantero1.getClosestOpponent()))	// Si bloquean al delantero
			_players[3].setBehaviour(_behaviours[4]);
			//_players[delantero1.getPlayerNumber()].setBehaviour(_behaviours[0]);
		else
			_players[3].setBehaviour(_behaviours[1]);

	}
	
	@Override
	public Behaviour getDefaultBehaviour(int id) {
		switch (id) {
		case 0:
			return _behaviours[2];	// Portero
		case 1:
			return _behaviours[3];	// Buscador
		case 2:
			return _behaviours[0];	// Compi
		case 3:
			return _behaviours[1];	// Defensa
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
								new NehuenMaradonaBehaviour()};	//4
		
	}
}
