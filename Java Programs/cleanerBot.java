import ch.aplu.robotsim.*;

public class cleanerBot
{
  public cleanerBot()
  {
    LegoRobot robot = new LegoRobot();
    Gear drive = new Gear();
    TouchSensor ts = new TouchSensor(SensorPort.S3);
    robot.addPart(drive);
    robot.addPart(ts);
    drive.setSpeed(30);
    drive.forward();
    boolean rightTurn = false;
    while (true)
    {
      if ((ts.isPressed()) && (rightTurn == false))
      {
        drive.backward(500);
        drive.left(900);
        drive.forward(250);
        drive.left(900);
        drive.forward();
        rightTurn = true;
      }
      else if((ts.isPressed()) && (rightTurn == true)){
    	  drive.backward(500);
          drive.right(900);
          drive.forward(250);
          drive.right(900);
          drive.forward();
          rightTurn = false;  
      }
    }
  }

  public static void main(String[] args)
  {
    new cleanerBot();
  }

  // ------------------ Environment --------------------------
  static
  {
    RobotContext.setStartPosition(300, 150);
    RobotContext.setStartDirection(180);
    RobotContext.useObstacle("sprites/bar0.gif", 250, 100);
    RobotContext.useObstacle("sprites/bar1.gif", 400, 250);
    RobotContext.useObstacle("sprites/bar2.gif", 250, 400);
    RobotContext.useObstacle("sprites/bar3.gif", 100, 250);
  }

}
