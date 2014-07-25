package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	
	public Image map;
	public GameWindow gameWin;
	public BufferedImage buffImg;
	
	public GamePanel(GameWindow _gameWin) {
		super();
		try {
			map = new ImageIcon(getClass().getResource("maze-map.png")).getImage();
		} catch (Exception e) {
			e.printStackTrace();
		}
		gameWin = _gameWin;
		int mapWidth = map.getWidth(gameWin);
		int mapHeight = map.getHeight(gameWin);
		buffImg = new BufferedImage(mapWidth, mapHeight, BufferedImage.TYPE_INT_RGB);
		
	
		
		Graphics2D g = buffImg.createGraphics();
		g.drawImage(map, 0, 0, gameWin);
		g.dispose();
	
	}
	
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawImage(buffImg.getSubimage(0, 0, 100, 200),	0, 0, gameWin);
		g2d.dispose();
		g.dispose();
	}

}
