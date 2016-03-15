import ch.aplu.robotsim.Gear;
import ch.aplu.robotsim.LegoRobot;
import ch.aplu.robotsim.RobotContext;
import ch.aplu.robotsim.SensorPort;
import ch.aplu.robotsim.TouchSensor;

public class touchCourse {
	static{
		RobotContext.setStartPosition(300, 50);
	    RobotContext.setStartDirection(90);
	    RobotContext.useObstacle("sprites/bg.gif", 250, 250);  
	}
	public touchCourse(){
		LegoRobot robot = new LegoRobot();
	    Gear drive = new Gear();
	    TouchSensor sense = new TouchSensor(SensorPort.S3);
	    robot.addPart(drive);
	    robot.addPart(sense);
	    drive.setSpeed(30);
	    drive.forward();
	    int countTurns = 0;
	    boolean tookLeft = false, tookRight = true;
	    
	    while(true){
	    	if(sense.isPressed() == true){
	    		//r-l-l-r
	    			
	    	}
	    	}
	    }
	    
	
	
	public static void main(String args[]){
		new touchCourse();
	}
}
