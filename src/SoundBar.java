import edu.macalester.graphics.*;
import javax.sound.sampled.*;
import edu.macalester.graphics.ui.Button;

import java.io.File;


public class SoundBar {

    private GraphicsGroup group;
    private Clip sound1, sound2, sound3; // 3 different sound clips

    // constructor initializes the sound bar with three sound options and volume controls
    public SoundBar(double x, double y, CanvasWindow canvas) throws Exception {
        group = new GraphicsGroup();

        // create buttons for selecting different sounds
        Button buttonS1 = new Button("Rain");
        Button buttonS2 = new Button("Nature");
        Button buttonS3 = new Button("Coffee Shop");
        buttonS1.setPosition(50, 100);
        buttonS2.setPosition(150, 100);
        buttonS3.setPosition(250, 100);
        group.add(buttonS1);
        group.add(buttonS2);
        group.add(buttonS3);

        // play/stop sounds when the button is clicked
        buttonS1.onClick(() -> {
            selectSound(sound1);
        });

        buttonS2.onClick(() -> {
            selectSound(sound2);
        });

        buttonS3.onClick(() -> {
            selectSound(sound3);
        });

        // load all 3 sound files
        sound1 = loadSound("rain.wav");
        sound2 = loadSound("nature.wav");
        sound3 = loadSound("coffeeshop.wav");

        // create volume control buttons for each sound (50%, 100%, 150%)
        new VolumeButton("50%", -10f, sound1, 50, 150, group);
        new VolumeButton("100%", 0f, sound1, 50, 200, group);
        new VolumeButton("150%", 6f, sound1, 50, 250, group);

        new VolumeButton("50%", -10f, sound2, 150, 150, group);
        new VolumeButton("100%", 0f, sound2, 150, 200, group);
        new VolumeButton("150%", 6f, sound2, 150, 250, group);

        new VolumeButton("50%", -10f, sound3, 250, 150, group);
        new VolumeButton("100%", 0f, sound3, 250, 200, group);
        new VolumeButton("150%", 6f, sound3, 250, 250, group);

        // add the sound bar to the canvas
        canvas.add(group);
        group.setPosition(x, y);
    }

    private Clip loadSound(String path) throws Exception{
        Clip sound = AudioSystem.getClip();
        sound.open(AudioSystem.getAudioInputStream(new File(path)));
        sound.loop(Clip.LOOP_CONTINUOUSLY);
        sound.stop();
        return sound;
    }

    // if the sound is playing, stop it and vice versa
    private void selectSound(Clip sound) {
        if (sound.isRunning()) {
        sound.stop();
        } 
        else {
        sound.start();
        sound.loop(Clip.LOOP_CONTINUOUSLY); 
        }
    }
    
    public GraphicsGroup getGraphics() {
        return group;
    }
}