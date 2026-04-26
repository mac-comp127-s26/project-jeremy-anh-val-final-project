import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;

public class TaskTester {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private CanvasWindow canvas;
    private Task task;
    private Rectangle taskbox;
    private Button button;

    public TaskTester() {
        canvas = new CanvasWindow("Task Manager tester", CANVAS_WIDTH, CANVAS_HEIGHT);
        task = new Task();
        taskbox = task.getTaskBox();
        button = new Button("delete");
        task.setButtonPosition(button, taskbox);
        canvas.add(taskbox);
        canvas.add(button);
        button.onClick(() -> {
            canvas.remove(button);
            canvas.remove(taskbox);
        });
    }

    public static void main(String[] args) {
        new TaskTester();
    }
}
