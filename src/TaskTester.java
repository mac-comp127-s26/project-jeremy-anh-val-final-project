import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

public class TaskTester {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private CanvasWindow canvas;
    private Task task;
    private Button button;

    public TaskTester() {
        canvas = new CanvasWindow("Task Manager tester", CANVAS_WIDTH, CANVAS_HEIGHT);
        task = new Task();
        button = new Button("delete");
        canvas.add(task.getTaskBox());
        canvas.add(task.createButton());
    }

    public static void main(String[] args) {
        new TaskTester();
    }

}
