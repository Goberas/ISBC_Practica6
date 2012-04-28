package t111209.behaviours;

import java.util.Queue;

import EDU.gatech.cc.is.util.Vec2;

import t111209.MensajePosicion;
import teams.ucmTeam.Behaviour;
import teams.ucmTeam.Message;
import teams.ucmTeam.RobotAPI;

public class GoToPosition extends Behaviour {
	
	@Override
	public int takeStep() {
		Queue<Message> pendingMessages = this.getPendingMessages();
		if (!pendingMessages.isEmpty()) {
			for (Message m:pendingMessages) {
				if (m instanceof MensajePosicion){
					Vec2 pos = (((MensajePosicion)m).getPosicion());
					myRobotAPI.setSteerHeading(pos.t);
					myRobotAPI.setSpeed(1.0);
					// Miro cómo de lejos estoy
					Vec2 dist = pos;
					dist.sub(myRobotAPI.getPosition());
					if (dist.r<0.2){
						myRobotAPI.setSpeed(0.0);
						myRobotAPI.setDisplayString("Arrive");
					}
				}
			}
		}
		return 0;
	}
	
	@Override
	public void onInit(RobotAPI r) {
		r.setDisplayString("ToGoal");
	}

	@Override
	public void configure() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onRelease(RobotAPI arg0) {
		// TODO Auto-generated method stub
		
	}
}
