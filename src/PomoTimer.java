import javax.sound.sampled.*;
import java.io.File;

public class PomoTimer implements PomoInterface {
    private final double work = 1500;
    private final double short_break = 300;
    private final double long_break = 900;
    public boolean running = false;
    public double timer = 0;
    private int workSessions = 0;
    public SessionType currentSession;

    public enum SessionType {
    WORK,
    SHORT_BREAK,
    LONG_BREAK
    }

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

    public void Start() {
        if (!running) {
            running = true;
            if (currentSession == null) {
                currentSession = SessionType.WORK;
                timer = work;
            }
        }
    }

    public void Stop() {
       running = false;
    }

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

    public double tick() {
        if (running) {
            timer -= 1.0;
            if (timer <= 0) {
                playSound("/Users/valromano/Documents/GitHub/project-jeremy-anh-val-final-project/res/timerbeep.wav");
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
        else {
            currentSession = SessionType.WORK;
            timer = work;
        }
    }
   }
    return timer;
   }

   public SessionType getCurrentSession() {
    return currentSession;
   }

   public double getTimer() {
    return timer;
   }

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

   public double setCurrentSessiontoWork () {
        currentSession = SessionType.WORK;
        timer = work;
        return getTimer();
   }
   public double setCurrentSessiontoBreak1 () {
        currentSession = SessionType.SHORT_BREAK;
        timer = short_break;
        return getTimer();
   }
   public double setCurrentSessiontoBreak2 () {
        currentSession = SessionType.LONG_BREAK;
        timer = long_break;
        return getTimer();
   }

}