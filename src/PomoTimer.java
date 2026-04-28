public class PomoTimer implements PomoInterface {
    private final double work = 1500;
    private final double short_break = 300;
    private final double long_break = 900;
    public boolean running = true;
    public double timer = 0;
    private int workSessions = 0;
    public SessionType currentSession;

    public enum SessionType {
    WORK,
    SHORT_BREAK,
    LONG_BREAK
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
        running = false;
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
        timer -= work;
        return getTimer();
    }
    else if (currentSession == SessionType.SHORT_BREAK) {
        timer -= short_break;
        return getTimer();
    }
    else {
        timer -= long_break;
        return getTimer();
    }
   }

}