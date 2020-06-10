package little.tennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Color;

public class Racquet {
	private static final int Y = 330;
	private static final int WIdTH = 120;
	private static final int HEIgTH = 20;
	int x = 0;
	int xb = 0;
	private Main game;
	
	public Racquet(Main game) {
		this.game = game; 
	}
	
	public void move() {
		if(x + xb > 0 && x + xb < game.getWidth() - WIdTH) {
			x = x + xb;
		}
	}
	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIdTH, HEIgTH);
		//g.setColor(Color.WHITE);
	}
	public void keyReleased(KeyEvent e) { 
		xb = 0;
	}
	public void KeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xb = -game.speed;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xb = game.speed;
		}
	}
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIdTH, HEIgTH);
	}
	public int getTopY() {
		return Y - HEIgTH;
	}
	

}
