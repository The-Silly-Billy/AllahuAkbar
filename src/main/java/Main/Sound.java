package Main;

import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sound {

    Clip clip;
    URL[] soundURL = new URL[10];

    public Sound() {
        soundURL[0] = getClass().getResource("/Sound/theme_song.wav");
        soundURL[1] = getClass().getResource("/Sound/bounce.wav");
        soundURL[2] = getClass().getResource("/Sound/power_up.wav");
        soundURL[3] = getClass().getResource("/Sound/button.wav");
        soundURL[4] = getClass().getResource("/Sound/collideBrick.wav");
    }

    public void setFile(int i) {

        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(soundURL[i]);
            clip = AudioSystem.getClip();
            clip.open(audio);
        } catch (Exception e) {}
    }

    public void play() {
        clip.start();
    }

    public void loop() {
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void stop() {
        clip.stop();
    }
}
