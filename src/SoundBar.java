import edu.macalester.graphics.*;
import java.awt.Color;
import javax.sound.sampled.*;
import edu.macalester.graphics.ui.Button;

import java.io.File;
import edu.macalester.graphics.events.*;
import edu.macalester.graphics.ui.Button;

public class SoundBar {

    private GraphicsGroup group;

    private GraphicsText label;
    private Clip sound1, sound2, sound3, currentSound;

    public SoundBar(String name, double x, double y, CanvasWindow canvas) throws Exception {
        group = new GraphicsGroup();

        label = new GraphicsText(name, x, y - 10);

        // 3 buttons for sounds
        Button buttonS1 = new Button("Rain");
        Button buttonS2 = new Button("Nature");
        Button buttonS3 = new Button("Coffee Shop");
        buttonS1.setPosition(50, 100);
        buttonS2.setPosition(200, 100);
        buttonS3.setPosition(350, 100);
        canvas.add(buttonS1);
        canvas.add(buttonS2);
        canvas.add(buttonS3);

        buttonS1.onClick(() -> {
            selectSound(sound1);
        });

        buttonS2.onClick(() -> {
            selectSound(sound2);
        });

        buttonS3.onClick(() -> {
            selectSound(sound3);
        });

        //3 options for volume
        Button buttonV1 = new Button("50%");
        Button buttonV2 = new Button("100%");
        Button buttonV3 = new Button("150%");
        buttonV1.setPosition(50, 150);
        buttonV2.setPosition(200, 150);
        buttonV3.setPosition(350, 150);
        canvas.add(buttonV1);
        canvas.add(buttonV2);
        canvas.add(buttonV3);

        buttonV1.onClick(() -> {
            setVolume(0.5);
        });

        buttonV2.onClick(() -> {
            setVolume(1);
        });

        buttonV3.onClick(() -> {
            setVolume(1.5);
        });

        sound1 = loadSound("rain.wav");
        sound2 = loadSound("nature.wav");
        sound3 = loadSound("coffeeshop.wav");

        
    }

    private Clip loadSound(String path) throws Exception{
        Clip sound = AudioSystem.getClip();
        sound.open(AudioSystem.getAudioInputStream(new File(path)));
        sound.loop(Clip.LOOP_CONTINUOUSLY);
        sound.stop();
        return sound;
    }

    private void selectSound(Clip sound) {
        if (currentSound != null) currentSound.stop();
        currentSound = sound;
        if (currentSound != null) currentSound.start();
    }

    private void setVolume(double volume){}
    
    public GraphicsGroup getGraphics() {
        return group;
    }
}