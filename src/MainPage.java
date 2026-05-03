import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.ui.Button;

public class MainPage {

    public static void main(String[] args) throws Exception {
        CanvasWindow canvas = new CanvasWindow("Po", 800, 600);
        new SoundBar(20, 300, canvas);

        TaskManager manager = new TaskManager(canvas);

        Button createButton = new Button("Add New Task");
        createButton.setPosition(canvas.getWidth() - 150, 20);

        createButton.onClick(() -> {
            manager.addTask("New Task");
        });

        canvas.add(createButton);

        new tomatoCreator(canvas);


        
    }

    
}
 