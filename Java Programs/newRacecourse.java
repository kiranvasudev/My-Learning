package legoSim;

import ch.aplu.robotsim.*;

public class newRacecourse implements LightListener {
	static {
		NxtContext.setStartPosition(425, 260);
		NxtContext.useBackground("sprites/yellowpath.gif");
		NxtContext.setStartDirection(90);
		// black-0 yellow-1000 green-600 blue-686
	}

	LegoRobot robot = new LegoRobot();
	Gear drive = new Gear();
	LightSensor sense = new LightSensor(SensorPort.S3);

	int lap = 0, trigger = 3;

	public newRacecourse() {
		robot.addPart(drive);
		robot.addPart(sense);
		drive.setSpeed(150);
	}

	public void start() {
		while (true) {
			System.out.println("Val: " + sense.getValue());

			if ((sense.getValue() <= 1000) && (sense.getValue() > 800)) // yellow
				drive.forward();
			else if ((sense.getValue() < 800) && (sense.getValue() >= 650)) // blue
				drive.rightArc(0.1);
			else if ((sense.getValue() < 650) && (sense.getValue() >= 600)) // green
				drive.leftArc(0.1);
			else if (sense.getValue() < 100) { // black
				if (lap < 3)
					sense.addLightListener(this, trigger);
				else
					drive.stop();
			}
		}
	}

	public void dark(SensorPort port, int value) { // when the light is darker
													// than value

	}

	public void bright(SensorPort port, int value) { // when the light is/
														// brighter than value

		System.out.println("\t\t\tLap: " + (++lap));
	}

	public static void main(String args[]) {
		newRacecourse race = new newRacecourse();
		race.start();
	}

}
