import teams.ucmTeam.TeamManager;
import teams.ucmTeam.UCMPlayer;


public class HispaniaTeam extends UCMPlayer{

	protected TeamManager getTeamManager() {
		return new Coach();
	}

}
