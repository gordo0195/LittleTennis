package little.tennis;

import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

@SuppressWarnings("serial")
public class Move extends JPanel {
	
	public Move() {
		
		KeyListener Listener = new KeyListener(){
			
			@Override
			public void keyTyped(KeyEvent e) {
				}
			
			@Override
			public void keyPressed(KeyEvent e) {
				System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
			}
			
		};
		addKeyListener(Listener);
		setFocusable(true);
	}

}
