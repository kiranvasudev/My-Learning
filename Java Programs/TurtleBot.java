package legoSim;

import ch.aplu.robotsim.*;

public class TurtleBot {
	
		LegoRobot turtle = new LegoRobot();
		Motor turtleLeft = new Motor(MotorPort.A);
		Motor turtleRight = new Motor(MotorPort.B);
		
		TurtleBot(){
		turtle.addPart(turtleLeft);
		turtle.addPart(turtleRight);
		}
		
	public void moveForward(){
		//front
		turtleLeft.forward();
		turtleRight.forward();
		Tools.delay(2000);
		turtleLeft.stop();
		turtleRight.stop();
	}
	public void rotate180(){
		turtleLeft.forward();
		Tools.delay(2150);
		turtleLeft.stop();
	}
	
	public void rotateleft90(){
		turtleLeft.forward();
		Tools.delay(1100);
		turtleLeft.stop();
	}
		
	public void rotateright90(){
		turtleRight.forward();
		Tools.delay(1100);
		turtleRight.stop();
	}
		
		
		
	
	public static void main(String args[]){
		TurtleBot turtleOne = new TurtleBot();
		
		turtleOne.moveForward();
		turtleOne.rotate180();
		turtleOne.moveForward(); //top and comes back
		
		turtleOne.rotateleft90();
		turtleOne.moveForward();
		turtleOne.rotate180();
		turtleOne.moveForward(); //right and comes back
		
		turtleOne.moveForward();
		turtleOne.rotate180();
		turtleOne.moveForward(); //goes to the left and comes back
		
		turtleOne.rotateright90();
		turtleOne.moveForward();
		turtleOne.rotate180();
		turtleOne.moveForward(); //down and comes back
	}
	 
	
}
