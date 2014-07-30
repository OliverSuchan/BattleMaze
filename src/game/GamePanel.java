package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class GamePanel extends JPanel{
	public Player me;
	public Image map;
	public GameWindow gameWin;
	public BufferedImage buffImg;
	public final byte SCALE = 2;
	
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
		
		me = gameWin.gameCon.me;
	
		
		Graphics2D g = buffImg.createGraphics();
		g.drawImage(map, 0, 0, gameWin);
		g.dispose();
		me.setMapImg(buffImg);
		me.bufferedImg_maxWidth = mapWidth;
		me.bufferedImg_maxHeight = mapHeight;
	}
	
	protected void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		BufferedImage buffer = buffImg.getSubimage(me.bufferedImg_xPos, me.bufferedImg_yPos, 960, 540);
		
		AffineTransform tx = new AffineTransform();
	    tx.scale(SCALE, SCALE);
	    buffer = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR).filter(buffer, null);

		g2d.drawImage(buffer, 0, 0, gameWin);
		g2d.setColor(me.myColor);
		g2d.fill(me.dot);
		g2d.dispose();
		g.dispose();
	}

}
