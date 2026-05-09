import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;

public class PomoTest {
   private PomoTimer timer;

   @BeforeEach 
   void SetUp() {
    timer = new PomoTimer(); //new timer created before each test
   }

   @Test
    void startSetsWorkSession() {
    timer.Start();
    assertEquals(PomoTimer.SessionType.WORK, timer.getCurrentSession());
    assertEquals(25.0, timer.getTimer()); //sets timer to work mode when started 
}
    @Test 
    void stopSetsTimerOff () {
        timer.Stop();
        assertEquals(0, timer.getTimer()); //sets timer off ;)
    }
    @Test
    void stopStopsDecrement () {
        timer.Start();
        timer.Stop(); 
        timer.tick(); //ticks after stop which shouldn't happen so 25 does not go to 24
        assertEquals(25, timer.getTimer());
    }
    @Test
    void workSessionTransitionsToShortBreak() {
        timer.Start(); //starts timer
        for (int i = 0; i < 25; i++) {
            timer.tick();
        } //ticks 25 times
        assertEquals(PomoTimer.SessionType.SHORT_BREAK, timer.getCurrentSession()); //checks session is Short Break
    } 
    @Test
    void resetSetsWorkSession () {
        timer.Start();
        timer.Stop();
        timer.Reset();
        assertEquals(PomoTimer.SessionType.WORK, timer.getCurrentSession());
        assertEquals(25, timer.getTimer()); 
    }

} 