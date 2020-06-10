package little.tennis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball {
	
	private static final int DIAMETRO = 30;
	int x = 0;
	int y = 0;
	
	int xB = 1;
	int yB = 1;
	private Main game;
	
	public Ball(Main game) {
		this.game = game;
	}
	
	void move() {
		boolean DirectionChanged = true;
		
		if (x+xB < 0 ) {
			xB = game.speed;
		}else if(x+xB > game.getWidth() - DIAMETRO) {
			xB = -game.speed;
		}else if(y+yB < 0 ) {
			yB = game.speed;
		}else if(y+yB > game.getHeight() - DIAMETRO){
			game.End();
		}
		else if(colision()) {
			yB = -game.speed;
			y = game.raquet.getTopY() - DIAMETRO;
			game.speed++;
		}else {
			DirectionChanged = false;
		}
		if(DirectionChanged) {
			Music.Poing.play();
		}
		 x = x + xB;
		 y = y + yB;
	}
	
	private boolean colision() {
		return game.raquet.getBounds().intersects(getBounds());
	}
	public void paint(Graphics2D g) {
		g.fillOval(x,  y,  DIAMETRO, DIAMETRO);
		//g.setColor(Color.GREEN);
	}
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
	

}
