import edu.macalester.graphics.*;
import java.awt.Color;
import javax.sound.sampled.*;
import edu.macalester.graphics.ui.Button;

import java.io.File;
import edu.macalester.graphics.events.*;


public class SoundBar {

    private GraphicsGroup group;

    private Clip sound1, sound2, sound3;

    public SoundBar(double x, double y, CanvasWindow canvas) throws Exception {
        group = new GraphicsGroup();
        
        // 3 buttons for sounds
        Button buttonS1 = new Button("Rain");
        Button buttonS2 = new Button("Nature");
        Button buttonS3 = new Button("Coffee Shop");
        buttonS1.setPosition(50, 100);
        buttonS2.setPosition(200, 100);
        buttonS3.setPosition(350, 100);
        group.add(buttonS1);
        group.add(buttonS2);
        group.add(buttonS3);

        buttonS1.onClick(() -> {
            selectSound(sound1);
        });

        buttonS2.onClick(() -> {
            selectSound(sound2);
        });

        buttonS3.onClick(() -> {
            selectSound(sound3);
        });

        
        sound1 = loadSound("rain.wav");
        sound2 = loadSound("nature.wav");
        sound3 = loadSound("coffeeshop.wav");


        new VolumeButton("50%", -10f, sound1, 50, 150, group);
        new VolumeButton("100%", +2f, sound1, 50, 200, group);
        new VolumeButton("150%", 6f, sound1, 50, 250, group);

        new VolumeButton("50%", -10f, sound2, 200, 150, group);
        new VolumeButton("100%", +2f, sound2, 200, 200, group);
        new VolumeButton("150%", 6f, sound2, 200, 250, group);

        new VolumeButton("50%", -10f, sound3, 350, 150, group);
        new VolumeButton("100%", +2f, sound3, 350, 200, group);
        new VolumeButton("150%", 6f, sound3, 350, 250, group);

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