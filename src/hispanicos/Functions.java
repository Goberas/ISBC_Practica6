package hispanicos;

import java.util.Random;

import teams.ucmTeam.RobotAPI;


public class Functions {
	
	public static Random random = new Random();
	
	public static boolean balonEnMiCampo(RobotAPI r){
		return (((-r.getFieldSide() * r.toFieldCoordinates(r.getBall()).x < 0) && 
				(r.getFieldSide() == -1)) || 
				((-r.getFieldSide() * r.toFieldCoordinates(r.getBall()).x > 0) && 
				(r.getFieldSide() == 1)));
	}
	
	public static void bloquearPortero(RobotAPI r){
		// Esquivamos a los compañeros
		if (r.teammateBlocking()){
			r.avoidCollisions();
			r.setDisplayString("AVOID");
		}
		else if (r.getOpponentsGoal().r < 0.3){
			// Bloqueamos al portero
			r.blockClosest();
			r.setDisplayString("A BLOKEAR");
			// Si podemos tiramos
			if (r.closestToBall() && r.canKick()){
				r.kick();
				r.setDisplayString("OLIVER");
			}
		}
		else{
			irASuPorteria(r);
			r.setDisplayString("Vamos A porteria");
		}
	}
	
	public static void irASuPorteria(RobotAPI r){
		// Vamos hacia el portero
		r.setSteerHeading(r.getOpponentsGoal().t);
		r.setSpeed(1.0);
	}
	
	public static void irCentroCampo(RobotAPI r){
		// Bloqueamos al mas cercano si estamos cerca del centro del campo
		if (r.getPosition().r < 0.3){
			r.setDisplayString("Dando vueltas");
			r.blockClosest();
		}
		else{
			// Vamos al centro del campo
			irAlCentro(r);
			r.setDisplayString("AL CENTRO");
		}
	}
	
	public static void irAlCentro(RobotAPI r){
		// Dependiendo del lado en el que este me coloco
		if (r.getPosition().x > 0) r.setSteerHeading(Math.PI);
		else r.setSteerHeading(0);
		r.setSpeed(1);
	}
	
	public static void goToOurGoal(RobotAPI r){
		double angle = r.getOurGoal().t;
		r.setSteerHeading(angle);
		r.setSpeed(1.0);
		r.setDisplayString("A porteria");	
	}

	public static void goToBall(RobotAPI r) {
		double angle = r.getBall().t;
		r.setSteerHeading(angle);
		r.setSpeed(1.0);
		r.setDisplayString("A balon");
	}
	
	public static void patrulla(RobotAPI myRobotAPI){
		double ang = random.nextDouble()*2*Math.PI;
		myRobotAPI.setSteerHeading(ang);
		myRobotAPI.setSpeed(0.7);
		myRobotAPI.setDisplayString("patrulla");
	}

}
