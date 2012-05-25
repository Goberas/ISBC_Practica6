import java.util.Queue;

import EDU.gatech.cc.is.util.Vec2;

import teams.ucmTeam.Behaviour;
import teams.ucmTeam.Message;
import teams.ucmTeam.RobotAPI;


public class GoToPosition extends Behaviour{
	public int takeStep() {
		Queue<Message> pendingMessages = this.getPendingMessages();
		if (!pendingMessages.isEmpty()) {
			for (Message m:pendingMessages) {
				if (m instanceof PositionMessage){
					Vec2 pos = (((PositionMessage)m).getPosicion());
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
	
	public void onInit(RobotAPI r) {
		r.setDisplayString("ToGoal");
		}

	public void configure() {
		// Auto-generated method stub
		
	}

	public void end() {
		//  Auto-generated method stub
		
	}

	public void onRelease(RobotAPI arg0) {
		// Auto-generated method stub
		
	}

}
