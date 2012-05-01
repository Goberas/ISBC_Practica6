package t111209.entrenadores;

import EDU.gatech.cc.is.util.Vec2;
import t111209.behaviours.Blocker;
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
		// Si la pelota está en campo contrario ==> GoToBall
		RobotAPI robot0 = _players[0].getRobotAPI();
		// Convertimos las coordenadas de la pelota (egocéntricas)
		// en coordenadas del campo, para saber en qué campo está
		Vec2 ballPosition = robot0.toFieldCoordinates(robot0.getBall());
		if (ballPosition.x * robot0.getFieldSide() > 0) {
			if (_players[0].getBehaviour() != _behaviours[0]) {
				_players[0].setBehaviour(_behaviours[0]);
			}
		} else {
			// E.o.c. ==> Portero
			if (_players[0].getBehaviour() != _behaviours[2]) {
				_players[0].setBehaviour(_behaviours[2]);
			}
		}
		// Si el jugador esta en su campo --> GoToBall
		RobotAPI robot = _players[2].getRobotAPI();
		if (robot.getPosition().x * robot.getFieldSide()>=0)
			_players[2].setBehaviour(_behaviours[0]);
		else
			// E.o.c. --> Blocker
			_players[2].setBehaviour(_behaviours[1]);

	}
	
	@Override
	public Behaviour getDefaultBehaviour(int id) {
		return _behaviours[0];
	}
	
	@Override
	public Behaviour[] createBehaviours() {
		return new Behaviour[] {new GoToBall(), new Blocker(), new PorteroBehaviour()};
		
	}
}
