package game;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;

public class Player {

  private double xPos, yPos, stepSize = 2.0;
  private int d = 12, cameraWidth = 1920, cameraHeight = 1080;

  public Ellipse2D.Double dot;
  public Color myColor;
  public BufferedImage map;

  public Player(double _x, double _y) {
    xPos = _x;
    yPos = _y;
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
    
    return (retValue == 0) ? true : false;
  }
  
  public BufferedImage getCamera(){
    int cornerX, cornerY;
    
    if(xPos < cameraWidth / 2){
      cornerX = 0;
      dot = new Ellipse2D.Double(xPos, yPos, d, d);
    } else if (xPos > (map.getWidth() - cameraWidth / 2)) {
      cornerX = map.getWidth() - cameraWidth;
      dot = new Ellipse2D.Double(cameraWidth - (map.getWidth() - xPos), dot.getY(), d, d);
    } else {
      cornerX = (int) (xPos - cameraWidth / 2);
      dot  = new Ellipse2D.Double(cameraWidth / 2, dot.getY(), d, d);
    }
    
    if(yPos < cameraHeight / 2){
      cornerY = 0;
      dot = new Ellipse2D.Double(dot.getX(), yPos, d, d);
    } else if (yPos > (map.getHeight() - cameraHeight / 2)) {
      cornerY = map.getHeight() - cameraHeight;
    } else {
      cornerY = (int) (yPos - cameraHeight / 2);
    }
    
    return map.getSubimage(cornerX, cornerY, cameraWidth, cameraHeight);
  }

  public void setMapImg(BufferedImage mapImage) {
    map = mapImage;
  }

  public void up() {
    if (checkCollision(xPos, yPos - stepSize)) {
      this.setyPos(yPos - stepSize);
    }
  }

  public void down() {
    if (checkCollision(xPos, yPos + stepSize)) {
      this.setyPos(yPos + stepSize);
    }
  }

  public void left() {
    if (checkCollision(xPos - stepSize, yPos)) {
      this.setxPos(xPos - stepSize);
    }
  }

  public void right() {
    if (checkCollision(xPos + stepSize, yPos)) {
      this.setxPos(xPos + stepSize);
    }
  }

  public double getxPos() {
    return xPos;
  }

  public void setxPos(double xPos) {
    this.xPos = xPos;
//    dot = new Ellipse2D.Double(xPos, yPos, d, d);
  }

  public double getyPos() {
    return yPos;
  }

  public void setyPos(double yPos) {
    this.yPos = yPos;
//    dot = new Ellipse2D.Double(xPos, yPos, d, d);
  }
}
