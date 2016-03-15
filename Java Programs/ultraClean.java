import ch.aplu.robotsim.*;

public class ultraClean {
	static{
		RobotContext.useObstacle("sprites/squaretarget.gif", 100, 100);
	    RobotContext.setStartPosition(300, 150);
	    RobotContext.setStartDirection(90);
		RobotContext.useObstacle("sprites/squaretarget.gif", 200, 200);
		RobotContext.useObstacle("sprites/squaretarget.gif", 300, 400);
	}
	
	public ultraClean(){
		LegoRobot robot = new LegoRobot();
		UltrasonicSensor sense = new UltrasonicSensor(SensorPort.S3);
		Gear drive = new Gear();
		
		robot.addPart(sense);
		robot.addPart(drive);
		
		while(true){
			drive.forward();
			System.out.println(sense.getDistance());
		}	
	}
	
	public static void main(String args[]){
		new ultraClean();
	}
}
