package gameproject;

import java.util.ArrayList;

public class StopWatch {

    private long startTime = 0;
    private long stopTime = 0;
    private long beforePauseTime;
    private boolean running = false;
    private final ArrayList<Long> pauseTimes;

    /**
     * Constructor for StopWatch
     */
    public StopWatch() {
        this.pauseTimes = new ArrayList<>();
    }

    /**
     * Start timer (also use this if stopwatch was stopped)
     */
    public void start() {
        if (this.startTime != 0) {
            pauseTimes.add((stopTime - startTime));
//            System.out.println("pauseTimes: " + pauseTimes.toString());
            this.startTime = System.currentTimeMillis();
        } else {
            this.startTime = System.currentTimeMillis();
        }
        this.running = true;
//        System.out.println("Started!");
    }

    /**
     * Restart timer no matter if it is running or not
     */
    public void restart() {
        reset();
        // start timer again
        this.startTime = System.currentTimeMillis();
        this.running = true;
//        System.out.println("Restarted!");
    }

    /**
     * Reset timer
     */
    public void reset() {
        // reset everything
        this.running = false;
        this.startTime = 0;
        this.stopTime = 0;
        this.beforePauseTime = 0;
        this.pauseTimes.clear();
    }

    /**
     * Stop stopwatch
     */
    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
//        System.out.println("Stopped!");
    }

    /**
     * Getter for elapsedTime in milliseconds
     *
     * @return elapsed milliseconds
     */
    public long getElapsedTime() {
        long elapsed;
        beforePauseTime = checkPauseTime();
        if (running) {
            elapsed = (System.currentTimeMillis() - startTime);
        } else {
            elapsed = (stopTime - startTime);
        }
        return elapsed;
    }

    /**
     * Getter for elapsedTime in seconds
     *
     * @return elapsed seconds
     */
    public long getElapsedTimeSecs() {
        long elapsed;
        beforePauseTime = checkPauseTime() / 1000;
        if (running) {
            elapsed = ((System.currentTimeMillis() - startTime) / 1000);
        } else {
            elapsed = ((stopTime - startTime) / 1000);
        }

        return elapsed + beforePauseTime;
    }

    /**
     * Checking how much time was spent in the pause screen
     *
     * @return 0 if no pause time else total pauseTime
     */
    private long checkPauseTime() {
        if (!pauseTimes.isEmpty()) {
            for (Long time : pauseTimes) {
                beforePauseTime += time;
            }
//            System.out.println("Checked!");
            return beforePauseTime;
        } else {
            return 0;
        }
    }

}
