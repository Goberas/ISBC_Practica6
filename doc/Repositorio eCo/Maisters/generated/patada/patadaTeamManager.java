//Template for TeamManager file
//This file is used by code generator
package patada;

//IMPORT SECTION 
import java.util.Queue;

import EDU.gatech.cc.is.util.Vec2;

import teams.ucmTeam.Behaviour;
import teams.ucmTeam.Message;
import teams.ucmTeam.Message.Type;
import teams.ucmTeam.RobotAPI;
import teams.ucmTeam.TeamManager;

public class patadaTeamManager extends TeamManager {
	/**
	 * Numbers of behaviours managed
	 */
	public static int numOfBehaviours = 1; 
	
	@Override
	public int onConfigure() { return 0; }

	@Override
	public void onTakeStep() { }

	/**
	 * This method get Behavior that corresponds to each one player of the team
	 */
	@Override
	public Behaviour getDefaultBehaviour(int id) {
		//TODO: En esta primera implementación solo existe un comportamiento a ser asignado
		Behaviour c = null;
		if (_behaviours!=null && _behaviours.length>0) {
			c = _behaviours[0];
		} 
		return c;
	}

	/**
	 * This method creates all behaviours to be used by team manager
	 */
	@Override
	public Behaviour[] createBehaviours() {
		_behaviours =new Behaviour[numOfBehaviours];
        for (int i=0; i<numOfBehaviours; i++)
        	_behaviours[i] = new patadaBehaviour();
        
        return _behaviours;
	}
	
}