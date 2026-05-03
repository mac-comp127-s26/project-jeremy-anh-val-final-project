import edu.macalester.graphics.CanvasWindow;
import edu.macalester.graphics.Ellipse;
import edu.macalester.graphics.FontStyle;
import edu.macalester.graphics.GraphicsGroup;
import edu.macalester.graphics.GraphicsText;
import edu.macalester.graphics.Rectangle;
import edu.macalester.graphics.ui.Button;
import java.awt.Color;

// group.animate(dt -> {
//            if (Pomodoro.running == true) {
//                 elapsedTime += dt;
//                if (elapsedTime >= 1.0) {
//                    Pomodoro.tick();
//                    elapsedTime = 0;
//                 }
//                 timerTextChange();
//            }
//         }
//  );
public class TomatoCreator {
    private GraphicsGroup group;    
    private final Color tomatoShellColor = new Color(224, 90, 90);
    private final Color tomatoStemColor = new Color(48,130,31);
    private GraphicsText timeText = new GraphicsText("mm:ss", 240,270);
    private PomoTimer Pomodoro = new PomoTimer();
   // private double elapsedTime = 0;
    //all buttons as variables
    Button stopTimerButton = new Button("Stop");
    Button startTimerButton = new Button ("Start");
    Button resetTimerButton = new Button ("Reset");
    Button workSetButton = new Button ("Work");
    Button shortBreakButton = new Button ("Short Break");
    Button longBreakButton = new Button ("Long Break");

    public TomatoCreator(CanvasWindow canvas) {
        group = new GraphicsGroup();

        //all graphical elements to create tomato shape
        Ellipse tomato1 = new Ellipse (150,200,150,150);
        tomato1.setFillColor(tomatoShellColor);
        tomato1.setStroked(false);
        Ellipse tomatoshell = new Ellipse(212, 200, 150, 150);
        tomatoshell.setFillColor(tomatoShellColor);
        tomatoshell.setStroked(false);
        Rectangle stem = new Rectangle (250, 175, 12, 32);
        stem.setFillColor(tomatoStemColor);
        timeText.setFontSize(18);
        timeText.setFont("Times New Roman", FontStyle.BOLD, 30); // classic
        //canvas adds all graphical elements
        group.add(tomatoshell);
        group.add(tomato1);
        group.add(stem);
        group.add(timeText);

       //stop timer
        stopTimerButton.setPosition(145, 380);
        stopTimerButton.onClick(() -> {
            Pomodoro.Stop();
        }); 
        group.add(stopTimerButton);

        //start timer
          startTimerButton.setPosition(213, 380);
        startTimerButton.onClick(() -> {
            Pomodoro.Start();
        });
        group.add(startTimerButton);

        resetTimerButton.setPosition(278, 380);
        resetTimerButton.onClick(() -> {
            Pomodoro.Reset();
        });
        group.add(resetTimerButton);
        
        workSetButton.setPosition(105, 420);
        workSetButton.onClick(() -> {
            Pomodoro.setCurrentSessiontoWork();
        });
        group.add(workSetButton);

        shortBreakButton.setPosition(178, 420);
        shortBreakButton.onClick(() -> {
            Pomodoro.setCurrentSessiontoBreak1();
        });
        group.add(shortBreakButton);
       
        longBreakButton.setPosition(285, 420);
        longBreakButton.onClick(() -> {
            Pomodoro.setCurrentSessiontoBreak2();
        });
        group.add(longBreakButton);
        canvas.add(group);
        group.setPosition(300, -100);
        
    
}
    public void timerTextChange () {
        int minutes = (int) Pomodoro.getTimer () /60;
        int seconds = (int) Pomodoro.getTimer () % 60;
        timeText.setText(String.format("%02d:%02d", minutes, seconds));
    }
}
