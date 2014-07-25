package game;

import java.awt.geom.Ellipse2D;

public class Player {
	
	private double xPos, yPos;
	private int d = 6, stepSize = 3;
	
	
	public Ellipse2D.Double dot;

	public Player(double _x, double _y) {
		xPos = _x;
		yPos = _y;
		dot = new Ellipse2D.Double(xPos, yPos, d, d);
	}
	
	public void up(){
		this.setyPos(yPos - stepSize);
	}

	public void down(){
		this.setyPos(yPos + stepSize);
	}
	
	public void left(){
		this.setxPos(xPos - stepSize);
	}
	
	public void right(){
		this.setxPos(xPos + stepSize);
	}

	public double getxPos() {
		return xPos;
	}

	public void setxPos(double xPos) {
		this.xPos = xPos;
		dot = new Ellipse2D.Double(xPos, yPos, d, d);
	}

	public double getyPos() {
		return yPos;
	}

	public void setyPos(double yPos) {
		this.yPos = yPos;
		dot = new Ellipse2D.Double(xPos, yPos, d, d);
	}
}
