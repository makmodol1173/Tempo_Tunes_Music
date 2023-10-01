import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class AudioPlayer {
    private Clip clip;

    public void play() {
        if (clip != null && !clip.isRunning()) {
            clip.start();
            System.out.println("Audio playback started.");
        }
    }

    public void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            System.out.println("Audio playback paused.");
        }
    }

    public void stop() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.setFramePosition(0); // Rewind to the beginning
            System.out.println("Audio playback stopped.");
        }
    }

    public void loadAudio(String filePath) {
        try {
            File audioFile = new File(filePath);

            if (!audioFile.exists()) {
                System.out.println("Audio file not found: " + filePath);
                return;
            }

            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(audioFile);

            clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            System.out.println("Audio file loaded: " + filePath);

        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
    }

    public void seekForward(int milliseconds) {
        if (clip != null) {
            long position = clip.getMicrosecondPosition() + (milliseconds * 1000);
            clip.setMicrosecondPosition(position);
            System.out.println("Seeked forward by " + milliseconds + " milliseconds.");
        }
    }

    public void seekBackward(int milliseconds) {
        if (clip != null) {
            long position = clip.getMicrosecondPosition() - (milliseconds * 1000);
            if (position < 0) {
                position = 0;
            }
            clip.setMicrosecondPosition(position);
            System.out.println("Seeked backward by " + milliseconds + " milliseconds.");
        }
    }

}
