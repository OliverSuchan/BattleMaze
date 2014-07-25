package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.Timer;

public class GameController {

	public GameWindow gameWin;
	public Timer upDateTimer;
	public Timer painterTimer;
	public Player me;

	public boolean wFlag = false, aFlag = false, sFlag = false, dFlag = false;
	public boolean upDateFlage = false;
	public boolean painterFlag = false;
	
	public GameController() {
		me = new Player(10, 10);
		gameWin = new GameWindow("Battle Maze", this);		
		
		upDateTimer = new Timer(20, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				upDateAction(e);
			}
		});
		
		painterTimer = new Timer(10, new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				painterAction(e);				
			}
		});
		
		upDateTimer.start();
		upDateFlage = true;
	}
	
	public void painterAction(ActionEvent evnt){
		gameWin.repaint();
	}

	public void upDateAction(ActionEvent evnt) {
		if (aFlag) {
			me.left();
		}else if (dFlag) {
			me.right();
		}else if (wFlag) {
			me.up();
		}else if (sFlag) {
			me.down();
		}
	}

	public void keyReleasedMethode(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_W) {
			wFlag = false;
		} else if (key.getKeyCode() == KeyEvent.VK_A) {
			aFlag = false;
		} else if (key.getKeyCode() == KeyEvent.VK_S) {
			sFlag = false;
		} else if (key.getKeyCode() == KeyEvent.VK_D) {
			dFlag = false;
		}
	}

	public void keyPressedMethode(KeyEvent key) {
		if (key.getKeyCode() == KeyEvent.VK_W) {
			wFlag = true;
		} else if (key.getKeyCode() == KeyEvent.VK_A) {
			aFlag = true;
		} else if (key.getKeyCode() == KeyEvent.VK_S) {
			sFlag = true;
		} else if (key.getKeyCode() == KeyEvent.VK_D) {
			dFlag = true;
		}
	}

}
