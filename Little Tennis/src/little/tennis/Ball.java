package little.tennis;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
/**Clase bola: es la que define las cracterísticas y el comportamiento de la pelota.
 * @author Gordo_0195
 * */
public class Ball {
	//declaración de variables:
	private static final int DIAMETRO = 30;
	int x = 0;
	int y = 0;
	
	int xB = 1;
	int yB = 1;
	private Main game;// objeto de la clase juego sobre el que va a trabajar 
	
	/** método constructor
	 * @param un Main llamado game
	 * @return la instancia a Main
	 * @exception solo opera sobre elementos de timpo interaz gráfica
	 */
	public Ball(Main game) {
		this.game = game;
	}
	/** método move() es el que se encarga de gestionar el movimiento de la pelota 
	 * @param nulo
	 * @return game.end(), aumenta la velocidad del juego, un booleanos que nos sirve para controlar el sonido de rebote y la modificación de la trayectoria de la pelota.
	 * @exception nula
	 */
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
	/** método colision() : es el que detecta el choque de la pelota con los bordes o la raqueta.
	 * @param ninguno
	 * @return retorna la intersección del perímetro de la pelota con el de la raqueta.
	 * @exception solo opera con valores tipo entero
	 */
	private boolean colision() {
		return game.raquet.getBounds().intersects(getBounds());
	}
	/** método paint() : es el que dibuja la pelota pero no en la ventana principal, de eso se encarga el método move de la clase Main.
	 * @param  Graphics2D g
	 * @return la pelota dibujada
	 * @exception solo opera con valores tipo entero
	 */
	public void paint(Graphics2D g) {
		g.fillOval(x,  y,  DIAMETRO, DIAMETRO);
		//g.setColor(Color.GREEN);
	}
	/** método getBouns() : detecta las dimensiones de la pelota
	 * @param ninguno
	 * @return las dimensiones y coordenadas de la raqueta
	 * @exception solo opera con valores tipo entero
	 */
	public Rectangle getBounds() {
		return new Rectangle(x, y, DIAMETRO, DIAMETRO);
	}
	

}
