package t111209.equipos;

import t111209.entrenadores.Entrenador;
import teams.ucmTeam.TeamManager;
import teams.ucmTeam.UCMPlayer;

public class TestPlayer extends UCMPlayer {
	
	@Override
	protected TeamManager getTeamManager() {
		return new Entrenador();
	}
}
