import java.io.File;
import javax.sound.sampled.*;

import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.ui.Button;

public class VolumeButton {
    private Button button;
    private Clip sound;
    private float volume; 

    public VolumeButton(String label, float volume, Clip sound, double x, double y, GraphicsGroup gr) {
            this.sound = sound;
            this.volume = volume;
            button = new Button(label);
            button.setPosition(x, y);
            gr.add(button);

            button.onClick(() -> setVolume());
        }
    
    private void setVolume(){
        if (sound.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                // Get the FloatControl for the MASTER_GAIN
                FloatControl volumeControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);

                // Set the volume (e.g., reduce by 10 decibels)
                //float volume = -10.0f; // A value in decibels

                volumeControl.setValue(volume);
            }
    }
}