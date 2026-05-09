import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.ui.Button;

public class MainPage {

    public static void main(String[] args) throws Exception {
        // create the main application window 
        CanvasWindow canvas = new CanvasWindow("PomoTask", 800, 600);

        // initialize the sound bar component
        new SoundBar(380, 280, canvas);

        // create the task manager to handle task operations
        TaskManager manager = new TaskManager(canvas);

        // create and position the "Add New Task" button
        Button createButton = new Button("Add New Task");
        createButton.setPosition(107, 20);

        // create a new task when button is clicked
        createButton.onClick(() -> {
            manager.addTask("New Task");
        });

        // add the button to the canvas
        canvas.add(createButton);

        // initialize the pomodoro timer 
        new TomatoCreator(canvas);
    }


}
 