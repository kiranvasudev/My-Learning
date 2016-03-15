package legoSim;

import ch.aplu.robotsim.*;

public class Racecourse implements LightListener {

	static {
		NxtContext.useBackground("sprites/yellowpath.gif");
		NxtContext.setStartPosition(400, 250);
		NxtContext.setStartDirection(90);
		// black-0 yellow-1000 green-600 blue-686
	}
	
	LegoRobot robot = new LegoRobot();
	Gear drive = new Gear();
	LightSensor one = new LightSensor(SensorPort.S1);
	int TRIGGER = 1000;

	public Racecourse() {
		one.activate(true);
		robot.addPart(drive);
		robot.addPart(one);
		one.addLightListener(this, TRIGGER);
		while (true) {
			System.out.println("Value: " + one.getValue());
		}
	}

	public void dark(SensorPort port, int value) {
		int count = 0;
		do{
			count++;
			drive.forward();
			System.out.println("Count: "+count);
		}while(count<3);
	}

	public void bright(SensorPort port, int value) {
		if(one.getValue() == 1000)
			drive.forward();
	}

	public static void main(String args[]) {
		new Racecourse();
	}
}
