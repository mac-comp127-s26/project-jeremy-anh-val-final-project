import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.ui.Button;
import java.awt.Color;

public class MainPage {

    public static void main(String[] args) throws Exception {
        CanvasWindow canvas = new CanvasWindow("PomoTask", 800, 600);
        new SoundBar(380, 280, canvas);

        TaskManager manager = new TaskManager(canvas);

        Button createButton = new Button("Add New Task");
        createButton.setPosition(107, 20);

        createButton.onClick(() -> {
            manager.addTask("New Task");
        });

        canvas.add(createButton);

        new TomatoCreator(canvas);


        
    }

    
}
 