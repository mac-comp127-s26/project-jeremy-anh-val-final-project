import javax.sound.sampled.*;
import java.io.File;

public class PomoTimer implements PomoInterface {
    // timer durations in seconds (25 min work, 5 min short break, 15 min long break)
    private final double work = 1500;   //25*60 = this number
    private final double short_break = 300;
    private final double long_break = 900;

    // timer state variables
    public boolean running = false;
    public double timer = 0;
    private int workSessions = 0;
    public SessionType currentSession;

    // session type enum
    public enum SessionType {
    WORK,
    SHORT_BREAK,
    LONG_BREAK
    }

    // play a sound effect when timer completes
    private void  playSound (String filePath) {
        try {
            File soundFile = new File(filePath);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (Exception e) {
            System.out.println("Could not play sound: " + filePath);
            e.printStackTrace();
        }
    }

    // start the timer
    public void Start() {
        if (!running) {
            running = true;
            if (currentSession == null) {
                currentSession = SessionType.WORK;
                timer = work;
            }
        }
    }

    // stop the timer
    public void Stop() {
       running = false;
    }

    // reset timer to the duration of the current session
    public void Reset() {
        if (currentSession == SessionType.WORK) {
            timer = work;
        }
        else if (currentSession == SessionType.SHORT_BREAK) {
            timer = short_break;
        }
        else {
        timer = long_break;
        }
    }

    // decrement timer by 1 second and handle session transitions
    public double tick() {
        if (running) {
            timer -= 1.0;
            if (timer <= 0) {
                playSound("/Users/valromano/Documents/GitHub/project-jeremy-anh-val-final-project/res/timerbeep.wav");
                // after work session, alternate between short and long breaks
                if (currentSession == SessionType.WORK) {
                    workSessions++;
                if (workSessions % 4 == 0) {
                    currentSession = SessionType.LONG_BREAK;
                    timer = long_break;
                }
                else {
                    currentSession = SessionType.SHORT_BREAK;
                    timer = short_break;
                }
        }
        // after break, return to work session
        else {
            currentSession = SessionType.WORK;
            timer = work;
        }
    }
   }
    return timer;
   }

   // get the current session type
   public SessionType getCurrentSession() {
    return currentSession;
   }

   // get remaining time on current timer
   public double getTimer() {
    return timer;
   }

   // get the total duration of the current session type
   public double getDuration () {
    if (currentSession == SessionType.WORK) {
        return work;
    }
    else if (currentSession == SessionType.SHORT_BREAK) {
        return short_break;
    }
    else {
        return long_break;
    }
   }

   // set session to work and reset timer
   public double setCurrentSessiontoWork () {
        currentSession = SessionType.WORK;
        timer = work;
        return getTimer();
   }

   // set session to short break and reset timer
   public double setCurrentSessiontoBreak1 () {
        currentSession = SessionType.SHORT_BREAK;
        timer = short_break;
        return getTimer();
   }

   // set session to long break and reset timer
   public double setCurrentSessiontoBreak2 () {
        currentSession = SessionType.LONG_BREAK;
        timer = long_break;
        return getTimer();
   }

}