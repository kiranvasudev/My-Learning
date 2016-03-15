import ch.aplu.robotsim.*;

public class antPath {
	// 2 flags(false) - one in left one in right. if continuous left right and
	// in bright region.
	// if flagLeft and flagRight are true then lap+1 change flag to false

	static {
		NxtContext.useBackground("sprites/antPath.gif");
		NxtContext.setStartPosition(50, 70);
		NxtContext.setStartDirection(0);

	}

	public antPath() {
		LegoRobot robot = new LegoRobot();
		Gear drive = new Gear();
		LightSensor right = new LightSensor(SensorPort.S1);
		LightSensor left = new LightSensor(SensorPort.S2);
		boolean rightFlag = true;
		// when black rotate like a circle

		robot.addPart(right);
		robot.addPart(left);
		robot.addPart(drive);
		while (true) {
			drive.setSpeed(150);
			if ((left.getValue() > 300) && (right.getValue() > 300)) // white
				drive.forward();
			else if ((left.getValue() > 300) && (right.getValue() < 300)) {
				drive.leftArc(.03);
			} else if ((left.getValue() < 300) && (right.getValue() > 300)) {
				drive.rightArc(.03);
			} else
				drive.rightArc(.15);
		}
	}

	public static void main(String args[]) {
		new antPath();
	}

}
