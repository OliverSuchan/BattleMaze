package game;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class GameWindow extends JFrame{
	
	public GamePanel gamePanel;
	
	public Container cp;
	public BufferedImage buffImg; 
	public GraphicsConfiguration gfxConf = GraphicsEnvironment.getLocalGraphicsEnvironment()
			.getDefaultScreenDevice().getDefaultConfiguration();
	
	public GameWindow(String title) {
		super(title);
		this.setLayout(null);
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		int frameWidth = d.width;
		int frameHeight = d.height;
		this.setSize(frameWidth, frameHeight);
		this.setLocation(0, 0);
		this.setResizable(false);
		this.setUndecorated(true);
		cp = getContentPane();
		cp.setLayout(null);
		
		buffImg = gfxConf.createCompatibleImage(frameWidth, frameHeight);
		
		gamePanel =  new GamePanel(this);
		gamePanel.setBounds(this.getX(), this.getY(), frameWidth, frameHeight);	
		cp.add(gamePanel);
		
		
		this.setVisible(true);
	}

}
