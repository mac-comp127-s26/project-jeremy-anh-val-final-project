import javax.sound.sampled.*;

import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.ui.Button;

public class VolumeButton {
    private Button button;
    private Clip sound;
    private float volume;

    // constructor creates a volume control button
    public VolumeButton(String label, float volume, Clip sound, double x, double y, GraphicsGroup gr) {
            this.sound = sound;
            this.volume = volume;

            // create and position the button
            button = new Button(label);
            button.setPosition(x, y);
            gr.add(button);

            // adjust volume when button is clicked
            button.onClick(() -> setVolume());
        }
    
    private void setVolume(){
        if (sound.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
                // Get the FloatControl for the MASTER_GAIN
                FloatControl volumeControl = (FloatControl) sound.getControl(FloatControl.Type.MASTER_GAIN);

                // Set the volume (e.g., reduce by 10 decibels)
                volumeControl.setValue(volume);
                
            }
    }
}