package little.tennis;

import java.applet.Applet;
import java.applet.AudioClip;

/**clase Music
 * define las canciones colectadas en la clase SoundTrack como audioclips usables en la máquina java
 * @author Gordo_0195
 * */
public class Music {
	/**
	 * se definen las canciones como variables estáticas dada su naturaleza
	 * */
	public static final AudioClip SoundTrack = Applet.newAudioClip(Music.class.getResource("track.wav"));
	public static final AudioClip Over = Applet.newAudioClip(Music.class.getResource("GameOver.wav"));
	public static final AudioClip Poing = Applet.newAudioClip(Music.class.getResource("poing.wav"));
}
