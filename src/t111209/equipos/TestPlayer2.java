package t111209.equipos;

import t111209.entrenadores.EntrenadorMensajero;
import teams.ucmTeam.TeamManager;
import teams.ucmTeam.UCMPlayer;

public class TestPlayer2 extends UCMPlayer {
	
	@Override
	protected TeamManager getTeamManager() {
		return new EntrenadorMensajero();
	}
}
