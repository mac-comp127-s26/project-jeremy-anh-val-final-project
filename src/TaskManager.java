import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.ui.Button;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private CanvasWindow canvas;
    private List<Task> tasks;
    private double nextTaskY = 10;
    private final double START_Y = 60; // Starting position for the first task
    private final double SPACING = 10; // Gap between tasks
    private final double TASK_HEIGHT = 50;
    private Button addTaskButton;

    public TaskManager(CanvasWindow canvas) {
        this.canvas = canvas;
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds a new task to the list and the canvas.
     */
    public void addTask(String description) {
        Task newTask = new Task(20, nextTaskY, 300, 75);
        
        // Setup the delete logic
        newTask.getDeleteButton().onClick(() -> {
            removeTask(newTask);
        });

        // // Setup the checkbox logic
        newTask.getCheckButton().onClick(() -> {
            newTask.getCheckBox().setFillColor(Color.GREEN);
            newTask.getCheckBox().setStrokeColor(Color.GREEN);
        });

        tasks.add(newTask);
        canvas.add(newTask);
        
        // nextTaskY += 60; // Move the position for the next task
        repositionTasks();
    }

    /**
     * Removes the task from the list and the canvas.
     */
    private void removeTask(Task task) {
        canvas.remove(task);
        tasks.remove(task);
        repositionTasks();
    }

    public Button getAddTaskButton() {
        return addTaskButton;
    }

    /**
     * Loops through the list and moves each task to its new "correct" height.
     */
    private void repositionTasks() {
        double currentY = START_Y;

        for (Task task : tasks) {
            task.setPosition(20, currentY);
            currentY += TASK_HEIGHT + SPACING;
        }
    }
}