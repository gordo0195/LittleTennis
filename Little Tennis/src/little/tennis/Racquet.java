package little.tennis;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.Color;
/**Clase Racquet: 
 * es la clase que define todas las caracteristicas de la pelota.
 * @author Gordo_0195
 * 
 * */
public class Racquet {
	//declaración de variables:
	private static final int Y = 330;
	private static final int WIdTH = 120;
	private static final int HEIgTH = 20;
	int x = 0;
	int xb = 0;
	private Main game;
	
	/**Racquet: es el contructor de la clase que lleva su nombre
	 * @param un objeto de la clase Main() sobre el cual va a trabajar
	 * @return la instancia a ese objeto
	 * @exception solo funciona con esa clase de objeto. */
	public Racquet(Main game) {
		this.game = game; 
	}
	/**método move(): es el que se encarga de mover la raqueta.
	 * @param no recibe parámetros originalmente pero trabaja las coordenadas x y xb
	 * @return la alteración de esas cordenadas a nuestro antojo para mover la raqueta
	 * @exception solo trabaja numeros enteros.
	 * */
	public void move() {
		if(x + xb > 0 && x + xb < game.getWidth() - WIdTH) {
			x = x + xb;
		}
	}
	/**Método paint(): es el que dibuja la pelota.
	 * @param Gráfico 2D g
	 * @return retorna la pelota dibujada según las especificaciones.
	 * @exception solo recibe gráficos
	 * */
	public void paint(Graphics2D g) {
		g.fillRect(x, Y, WIdTH, HEIgTH);
		//g.setColor(Color.WHITE);
	}
	/**Método keyReleased(): es el que define el comportamiento al estar las teclas sin presionar.
	 * @param un objeto de la clase KeyEvent e
	 * @return 0
	 * @exception solo recibe eventos del teclado
	 * */
	public void keyReleased(KeyEvent e) { 
		xb = 0;
	}
	/**Método KeyPressed: es el que detecta la dirección del la raqueta.
	 * @param KeyEvent e
	 * @return retorna la velocidad y dirección de la pelota tras cada iteración, siendo negativo a la izquierda y positivo a la derecha.
	 * @exception solo recibe eventos del teclado
	 * */
	public void KeyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT) {
			xb = -game.speed;
		}else if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			xb = game.speed;
		}
	}
	/**Método getBounds: es el que se encarga de obtener las dimansiones y coordenadasde la racqueta.
	 * @param nulo
	 * @return retorna un nuevo rectángulo con las dimensiones de la pelota y sus coordenadas.
	 * @exception solo aplicable a rectángulos.
	 * */
	public Rectangle getBounds() {
		return new Rectangle(x, Y, WIdTH, HEIgTH);
	}
	
	/**Método getTopY(): es el que marca la linea donde se pierde.
	 * @param nulo
	 * @return el alto de la ventana de juego menos el alto de la raqueta.
	 * @exception solo retorna numeros enteros.
	 * */
	public int getTopY() {
		return Y - HEIgTH;
	}
	

}
