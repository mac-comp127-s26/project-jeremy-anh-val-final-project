import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import edu.macalester.graphics.ui.TextField;

public class TaskTester {

    public TaskTester() {
    }

    public static void main(String[] args) {
        CanvasWindow canvas = new CanvasWindow("Task Manager", 700, 600);
        TaskManager manager = new TaskManager(canvas);

        Button createButton = new Button("Add New Task");
        createButton.setPosition(canvas.getWidth() - 150, 20);

        createButton.onClick(() -> {
            manager.addTask("New Task");
        });

        canvas.add(createButton);
    }
}
