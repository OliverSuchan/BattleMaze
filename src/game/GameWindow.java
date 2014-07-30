package game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class GameWindow extends JFrame{
  
  public GameController gameCon;
  public GamePanel gamePanel; 
  public Container cp;
  
  
  public GameWindow(String title, GameController _gameCon) {
    super(title);
    this.setLayout(null);
    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent w) {
        closeMethode();
      }
    });   
    Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    int frameWidth = d.width;
    int frameHeight = d.height;
    this.setSize(frameWidth, frameHeight);
    this.setLocation(0, 0);
    this.setResizable(false);
    this.setUndecorated(true);
    cp = getContentPane();
    cp.setLayout(null);   
    
    gameCon = _gameCon;
    
    
    gamePanel =  new GamePanel(this);
    gamePanel.setBounds(this.getX(), this.getY(), frameWidth, frameHeight); 
    cp.add(gamePanel);
    
    
    
    this.addKeyListener(new KeyListener() {
      
      @Override
      public void keyTyped(KeyEvent e) {
                
      }
      
      @Override
      public void keyReleased(KeyEvent e) {
        gameCon.keyReleasedMethode(e);    
      }
      
      @Override
      public void keyPressed(KeyEvent e) {
        gameCon.keyPressedMethode(e);
      }
    });
    
    
    this.setVisible(true);
  }
  
  public void closeMethode(){
    gameCon.painterTimer.stop();
    gameCon.upDateTimer.stop();
    this.dispose();
  }
  
  
}
