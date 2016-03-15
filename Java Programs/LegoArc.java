package legoSim;

import ch.aplu.robotsim.*;

public class LegoArc {
	LegoRobot arcRobot = new LegoRobot();
	Gear arcGear = new Gear();
	
	public LegoArc(){
		arcRobot.addPart(arcGear);
	}
	
	public void rightArc(double radius, int time){
		arcGear.setSpeed(150);
		arcGear.rightArc(radius,time);
	}
	
	public static void main (String args[]){
		LegoArc arcBot = new LegoArc();
		
		int NUMBER_OF_TIMES = 2;
		double arcRadius = 0.25;
		
		while(NUMBER_OF_TIMES > 0){
			arcBot.rightArc(arcRadius,2250);
			arcBot.arcGear.right(360);
			NUMBER_OF_TIMES--;
		}
		
	}
}
