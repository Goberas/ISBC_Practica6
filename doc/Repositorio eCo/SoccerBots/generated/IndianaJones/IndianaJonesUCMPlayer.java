//Template for RoleBaseTeam file
//This file is used by code generator
package IndianaJones;

//IMPORT SECTION 
import teams.ucmTeam.TeamManager;
import teams.ucmTeam.UCMPlayer;

public class IndianaJonesUCMPlayer extends UCMPlayer {
	TeamManager _tm = null;
	/**
	 * Get the Team Manager for the team
	 */
	@Override
	protected TeamManager getTeamManager() {
		if (_tm == null)
			_tm = new IndianaJonesTeamManager(); //Name of TeamManager class generated by code generator
		return _tm;
	}
}