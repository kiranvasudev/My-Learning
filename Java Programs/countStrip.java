package legoSim;

import ch.aplu.robotsim.*;

public class countStrip implements LightListener {
	LegoRobot light2 = new LegoRobot();
	Gear gearLight2 = new Gear();
	LightSensor senseLight2 = new LightSensor(SensorPort.S1);
	int triggerLevel = 1000, count = 0;

	public countStrip() {
		light2.addPart(gearLight2);
		light2.addPart(senseLight2);

		gearLight2.forward();

		senseLight2.addLightListener(this, triggerLevel);

	}

	public void dark(SensorPort port, int value) { // when light is darker than trigger value
		if (count != 5) {
			count++;
			System.out.println("Count:" + count);
		} 

	}

	public void bright(SensorPort port, int value) { // when light is brighter
														// than trigger value

	}

	public static void main(String args[]) {
		new countStrip();
	}

	// --- ENVIRONMENT ---
	static {
		NxtContext.setStartPosition(0, 200);
		NxtContext.setStartDirection(0); // start pos of the robot
		NxtContext.useBackground("sprites/panel.gif");
	}
}
