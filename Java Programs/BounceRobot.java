package legoSim;

import ch.aplu.robotsim.*;

public class BounceRobot {
	LegoRobot lightRobo = new LegoRobot();
	Gear lightSpeed = new Gear();
	LightSensor sense = new LightSensor(SensorPort.S1);
	int colorValue;

	public BounceRobot() {
		lightRobo.addPart(lightSpeed);
		lightRobo.addPart(sense);
		sense.activate(true);
		lightSpeed.setSpeed(100);
		
		

		while (true) {
			colorValue = sense.getValue();
			if (colorValue > 300) {
				lightSpeed.forward();
			} else
				lightSpeed.right(540);
		}
	}

	public static void main(String args[]) {
		new BounceRobot();
	}

	// ------------------ Environment --------------------------
	static {
		NxtContext.setStartPosition(250, 200);
		NxtContext.setStartDirection(0); //start pos of the robot 
		NxtContext.useBackground("sprites/blackPanels.gif");
	}
}
