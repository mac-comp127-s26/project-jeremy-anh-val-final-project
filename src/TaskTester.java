import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.GraphicsObject;
import edu.macalester.graphics.Rectangle;

public class TaskTester {
    private static final int CANVAS_WIDTH = 600;
    private static final int CANVAS_HEIGHT = 800;
    private CanvasWindow canvas;
    private Task task;

    public TaskTester() {
        canvas = new CanvasWindow("Task Manager tester", CANVAS_WIDTH, CANVAS_HEIGHT);
        task = new Task();
        canvas.add(task.getTaskBox());
    }

    public static void main(String[] args) {
        new TaskTester();
    }

}
