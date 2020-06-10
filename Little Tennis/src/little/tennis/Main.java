package little.tennis;

import java.awt.Graphics;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Cursor;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Main extends JPanel{
	
	Ball ball = new Ball(this);
	Racquet raquet = new Racquet(this);
	int speed = 1;
	
	private int getScore() {
		return speed-1;
	}
	public Main() {
		
		addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				
			}
			@Override
			public void keyReleased(KeyEvent e) {
				raquet.keyReleased(e);
			}
			@Override
			public void keyPressed(KeyEvent e) {
				raquet.KeyPressed(e);
			}
		});
		setFocusable(true);
		Music.SoundTrack.loop();
	}
private void move() {
		ball.move();
		raquet.move();
	}
@Override
public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics =(Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setColor(Color.green);
		ball.paint(graphics);
		raquet.paint(graphics);
		
		graphics.setFont(new Font("Verdana", Font.BOLD, 30));
		graphics.drawString(String.valueOf(getScore()),  10, 30);
	}

public void End() {
	Music.SoundTrack.stop();
	Music.Over.play();
	JOptionPane.showMessageDialog(this, "Mini Juego Finalizado", "GAME OVER", JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
}
@SuppressWarnings("deprecation")
public static void main(String[] args) throws InterruptedException{
	JFrame WinGame = new JFrame("Little Tennis!");
	WinGame.setCursor(Cursor.HAND_CURSOR);
	Main game = new Main();
	
	WinGame.add(game);
	WinGame.setSize(800,450);
	WinGame.setVisible(true);
	WinGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
	while(true) {
		game.move();
		game.repaint();
		Thread.sleep(10);
		}
	}
}
