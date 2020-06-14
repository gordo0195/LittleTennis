package little.tennis;

import java.awt.Graphics;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Cursor;


/**
 * Clase Main
 * Clase principal del mini juego. Es la que se ejecuta y llama a las demás clases.
 * @autor: Marco
 * @version: 0.8 : 06/06/2020
 */ 
@SuppressWarnings("serial")
public class Main extends JPanel implements Runnable{
	
	//declaration of variables:
	Ball ball = new Ball(this);
	Racquet raquet = new Racquet(this);
	int speed = 1;//iniciada en uno y en cada rebote de la pelota aumenta la velocidad con la curiosidad de que al ir sumando, cuando el resultado se convierte en negativo le da orientacion izquierda a la raqueta conservando la velocidad que se requiere.
	
	/**Metodo getScore
	 *  este sirve para saber la puntuación del jugador mediante la aceleración del la pelota menos uno.
	 * @param nulo
	 * @return retorna la puntuación del ussuario en entero
	 * @exception nulo
	*/
	private int getScore() {
		return speed-1;
	}
	/**
	 * Constructor Main: 
	 * inicia con un listener que mediente sus métodos abstractos nos hace quedar a la espera para detectar los eventos de 
	 * movimiento además de iniciar el soundtrack.
	 * @param nulo.
	 * @return el listener y el sonido del juego.
	 * @exception no detecta otras teclas que no sean las flechas.
	 * */
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
	/**Metodo move(), invoca a los métodos de movimiento de la clase raqueta y bola, de manera que este solo llama a los dos.
	 * @param no recibe parámetros aunque si es capaz de llamar metodos de las otras clases por herencia.
	 * @return retorna el movimiento de la pelota y la raqueta.
	 * @exception en el caso de la raqueta olo funciona con las teclas de dirección
	 * */
private void move() {
		ball.move();
		raquet.move();
	}
/**Método paint(), método que dibuja los componentes del juego en la ventana principal.
 * @param Gráfico g.
 * @return el grafico con los métodos de movimiento de cada clase.
 * @exception nulo
 * */
@Override
public void paint(Graphics g) {
		super.paint(g);
		Graphics2D graphics =(Graphics2D) g;
		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		graphics.setColor(Color.green);
		ball.paint(graphics);
		raquet.paint(graphics);
		
		graphics.setFont(new Font("Arial", Font.BOLD, 30));
		graphics.drawString(String.valueOf(getScore()),  10, 30);
	}
/** Metodo End(): es el que define lo que se debe hacer al perder el juego.
 * @param ninguno
 * @return detiene la música, reproduce la de derrota, muestra el mensaje de finalización y termina la ejecución.
 * @exception nulo.
 * */
public void End() {
	Music.SoundTrack.stop();
	Music.Over.play();
	JOptionPane.showMessageDialog(this, "Mini Juego Finalizado", "GAME OVER", JOptionPane.YES_NO_OPTION);
	System.exit(ABORT);
}

/**método main de inicialización
 * @param puede usar atributos de todas las clases
 * @return un ciclo infinito con la inicialización del juego
 * @exception nula
 *  */
//@SuppressWarnings("deprecation")
//public static void main(String[] args) throws InterruptedException{
public void run() {
	 
	try {
		JFrame WinGame = new JFrame("Little Tennis!");
		//	JPanel Wall = new JPanel();
		//WinGame.setCursor(Cursor.HAND_CURSOR);
	
		Main Game = new Main();
		WinGame.add(new ImagenWall());
		WinGame.add(Game);
		WinGame.setSize(700,450);
		WinGame.setVisible(true);
		WinGame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	
		while(true) {
			Game.move();
			Game.repaint();
			Thread.sleep(10);
			}
	}
	catch(Exception e) {
		}
	}
}
