package little.tennis;

import java.applet.Applet;
import java.applet.AudioClip;
public class Music {
	
	public static final AudioClip SoundTrack = Applet.newAudioClip(Music.class.getResource("track.wav"));
	public static final AudioClip Over = Applet.newAudioClip(Music.class.getResource("GameOver.wav"));
	public static final AudioClip Poing = Applet.newAudioClip(Music.class.getResource("poing.wav"));
}
