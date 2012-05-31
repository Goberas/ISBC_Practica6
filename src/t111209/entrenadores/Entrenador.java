package t111209.entrenadores;

import t111209.behaviours.Blocker;
import t111209.behaviours.Buscador2Behaviour;
import t111209.behaviours.CompiBehaviour;
import t111209.behaviours.Defensa2Behaviour;
import t111209.behaviours.DefensaBehaviour;
import t111209.behaviours.IndianaJonesBehaviour;
import t111209.behaviours.NehuenMaradonaBehaviour;
import t111209.behaviours.Portero2Behaviour;
import t111209.behaviours.PorteroBehaviour;
import teams.ucmTeam.Behaviour;
import teams.ucmTeam.RobotAPI;
import teams.ucmTeam.TeamManager;

public class Entrenador extends TeamManager {
	private boolean[] ocupados = new boolean[5];
	private Behaviour[] lastBehaviours = new Behaviour[5];
	
	@Override
	public int onConfigure() {
		ocupados[0] = true;	//Portero
		ocupados[1] = false;
		ocupados[2] = false;
		ocupados[3] = false;
		ocupados[4] = true;	//Delantero
		return RobotAPI.ROBOT_OK;
	}
	
	@Override
	public void onTakeStep() {
		

		// Cuando el delantero coge la pelota, todos los jugadores no ocupados se ponen como blocker
		// se guarda el estado anterior para despues restaurarlo
/*		RobotAPI delantero = _players[4].getRobotAPI();
		if(delantero.closestToBall()){
			for(int i=0;i<5;i++)
				if(!ocupados[i]){
					lastBehaviours[i] = _players[i].getBehaviour();
					_players[i].setBehaviour(_behaviours[5]);
				}
		}
		else
			for(int i=0;i<5;i++){
				if(!ocupados[i] && _players[i].getBehaviour() == _behaviours[5])
					_players[i].setBehaviour(lastBehaviours[i]);
			}
*/		
		// Si el portero esta bloqueado mete un portero nuevo
		RobotAPI portero1 = _players[0].getRobotAPI();
		RobotAPI portero2 = _players[2].getRobotAPI();
		
		if((_players[0].getBehaviour().equals(_behaviours[2])) && portero1.blocked()){	// Si el jugador 0 es portero y esta bloqueado
			_players[0].setBehaviour(_behaviours[1]);	// jugador 0 es defensa
			_players[2].setBehaviour(_behaviours[2]);	// jugador 2 es portero
			ocupados[0] = false;
			ocupados[2] = true;
		}
		else if((_players[2].getBehaviour().equals(_behaviours[2])) && portero2.blocked()){	// Si el jugador 3 es portero y esta bloqueado
			_players[2].setBehaviour(_behaviours[1]);	// jugador 2 es defensa
			_players[0].setBehaviour(_behaviours[2]);	// jugador 0 es portero
			ocupados[2] = false;
			ocupados[0] = true;
		}
		
		
		RobotAPI delantero1 = _players[4].getRobotAPI();
		if(delantero1.isBlocking(delantero1.getClosestOpponent()))	// Si bloquean al delantero
			_players[3].setBehaviour(_behaviours[4]);	// Jugador 3 -> Delantero
			//_players[delantero1.getPlayerNumber()].setBehaviour(_behaviours[0]);
		else
			_players[3].setBehaviour(_behaviours[3]);	// Jugador 3 -> Compi

	}
	
	@Override
	public Behaviour getDefaultBehaviour(int id) {
		switch (id) {
		case 0:
			return _behaviours[2];	// Portero
		case 1:
			//return _behaviours[3];	// Buscador
		case 2:
			return _behaviours[1];	// Defensa
		case 3:
			return _behaviours[3];	// Buscador
		case 4:
			return _behaviours[4];	// Delantero
			
		default:
			return _behaviours[0];
		}
		
		
	}
	
	@Override
	public Behaviour[] createBehaviours() {
		return new Behaviour[] {new CompiBehaviour(), 		//0
								new Defensa2Behaviour(), 	//1
								new Portero2Behaviour(),		//2
								new IndianaJonesBehaviour(),	//3
								new NehuenMaradonaBehaviour(),	//4
								new Blocker()};	//5
		
	}
}
