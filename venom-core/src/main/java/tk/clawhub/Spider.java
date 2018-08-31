package tk.clawhub;

import java.util.concurrent.atomic.AtomicInteger;

public class Spider implements Runnable {

    private AtomicInteger stat = new AtomicInteger(STAT_INIT);
    protected final static int STAT_INIT = 0;

    protected final static int STAT_RUNNING = 1;

    protected final static int STAT_STOPPED = 2;

    @Override
    public void run() {
        checkRunningStat();
    }

    private void checkRunningStat() {
        while (true) {
            int statNow = stat.get();
            if (statNow == STAT_RUNNING) {
                throw new IllegalStateException("Spider is already running!");
            }
            if (stat.compareAndSet(statNow, STAT_RUNNING)) {
                break;
            }
        }
    }
}
