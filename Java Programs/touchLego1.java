package legoSim;

import ch.aplu.robotsim.*;

public class touchLego1 {
	NxtRobot robot = new NxtRobot();
	Gear g = new Gear();
	TouchSensor t = new TouchSensor(SensorPort.S1);
	
	public touchLego1(){
		robot.addPart(t);
		robot.addPart(g);
		
		g.forward();
		
		while(true){
			if(t.isPressed() == true){
				g.stop();
				g.backward();
				Tools.delay(200);
				g.stop();
				g.right(1250);//should turn 90
				g.forward();
			}
		}
	}
	public static void main(String args[]){
		new touchLego1();
	}
	
	// --- ENVIRONMENT ---
		static {
			NxtContext.setStartPosition(350, 0);
			NxtContext.setStartDirection(90); // start pos of the robot
			NxtContext.useBackground("sprites/channel.gif");
		}
}
