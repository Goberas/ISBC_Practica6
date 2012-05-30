package hispanicos;

import teams.ucmTeam.TeamManager;
import teams.ucmTeam.UCMPlayer;


public class TestPlayer extends UCMPlayer{

	protected TeamManager getTeamManager() {
		return new Coach();
	}

}
