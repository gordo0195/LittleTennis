package little.tennis;

import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;

public class SoundTrack {
	
	public static void main (String[] args) throws Exception {
		
		URL Id = SoundTrack.class.getResource("track.wav");//AUTOR: Spring. Extraída de: https://opengameart.org/content/the-lobster-game-table-tennis-kinda.
		URL Id2 = SoundTrack.class.getResource("GameOver.wav");//AUTOR: Spring. Extraída de: https://opengameart.org/content/the-lobster-game-table-tennis-kinda.
		URL Id3 = SoundTrack.class.getResource("poing.wav");//AUTOR: Blender Foundation. Extraída de: https://opengameart.org/content/collision-nutfall-yo-frankie
		AudioClip Track = Applet.newAudioClip(Id);
		Track.loop();
		Thread.sleep(1000);
		
		AudioClip over = Applet.newAudioClip(Id2);
		over.play();
		Thread.sleep(1000);
		
		AudioClip ball = Applet.newAudioClip(Id3);
		ball.play();
		Thread.sleep(4000);
		
	}

}
