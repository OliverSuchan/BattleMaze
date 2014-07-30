package game;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Player {

	private double xPos, yPos, stepSize = 2.0;
	private int d = 12;
	public final int SCALE = 1;

	public Ellipse2D.Double dot;
	public Color myColor;
	public BufferedImage map;
	public int bufferedImg_xPos = 20, bufferedImg_yPos = 20, bufferedImg_maxWidth, bufferedImg_maxHeight;

	public Player() {
		xPos = Toolkit.getDefaultToolkit().getScreenSize().getWidth() / 2;
		yPos = Toolkit.getDefaultToolkit().getScreenSize().getHeight() / 2;
		myColor = Color.GREEN;
		dot = new Ellipse2D.Double(xPos, yPos, d, d);
	}

	public boolean checkCollision(double newX, double newY) {
		int retValue = 0;
		Color checkPoint;
		double x = newX + d / 2.0;
		double y = newY + d / 2.0;

		for (int i = 0; i < 8; i++) {
			try {
				checkPoint = new Color(map.getRGB(
						(int) (x + Math.cos(Math.toRadians(i * 45) * (d / 2))),
						(int) (y + Math.sin(Math.toRadians(i * 45) * (d / 2)))));
				retValue += checkPoint.getRed() + checkPoint.getGreen() + checkPoint.getBlue();
			} catch (Exception e) {
				retValue += 1;
			}
		}
		
		//System.out.println(retValue);
		
		return (retValue == 0) ? true : false;
	}

	public void setMapImg(BufferedImage mapImage) {
		map = mapImage;
	}

	public void up() {
		if (checkCollision(xPos, yPos - stepSize)) {
			if(bufferedImg_yPos - stepSize < 0)
				bufferedImg_yPos += 0 - bufferedImg_yPos;
			else
				bufferedImg_yPos -= stepSize;
		}
	}

	public void down() {

		if (checkCollision(xPos, yPos + stepSize)) {
			if(bufferedImg_yPos + stepSize > bufferedImg_maxHeight - 540)
				bufferedImg_yPos += bufferedImg_maxHeight - 540 - bufferedImg_yPos;
			else
				bufferedImg_yPos += stepSize;
		}
	}

	public void left() {
		
		if (checkCollision(xPos - stepSize, yPos)) {
			if(bufferedImg_xPos - stepSize < 0)
				bufferedImg_xPos += 0 - bufferedImg_xPos;
			else
				bufferedImg_xPos -= stepSize;
		}
	}

	public void right() {
		if (checkCollision(xPos + stepSize, yPos)) {
			if(bufferedImg_xPos + stepSize > bufferedImg_maxWidth - 960)
				bufferedImg_xPos += bufferedImg_maxWidth - 960 - bufferedImg_xPos;
			else
				bufferedImg_xPos += stepSize;
		}
	}

	public double getxPos() {
		return xPos;
	}


	public double getyPos() {
		return yPos;
	}
}
