package little.tennis;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
//import java.awt.
import java.awt.event.ActionListener;

public class StartWin extends JPanel {
	
	public StartWin() {
		
		
	}


	public static void main(String args[]) {
		
	
		
		JFrame StartFrame = new JFrame("Little Tennis");
		JPanel CanvaStart = new JPanel();
		JButton Buttm = new JButton();
		CanvaStart.setLocation(0, 0);
		CanvaStart.add(Buttm);
		Buttm.setSize(20, 13);
		Buttm.setLocation(143, 200);
		Buttm.setText("Iniciar Juego");
		
		StartFrame.setSize(300,300);
		StartFrame.add(CanvaStart);
		StartFrame.setVisible(true);
		
		Buttm.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				System.out.println("nueva");
				Main NewGame = new Main();
				NewGame.setVisible(true);
			}	
		});
	}
	
}
