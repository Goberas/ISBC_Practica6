package t111209;

import teams.ucmTeam.TeamManager;
import teams.ucmTeam.UCMPlayer;

public class TestPlayer extends UCMPlayer {
	
	@Override
	protected TeamManager getTeamManager() {
		return new Entrenador();
	}
}
