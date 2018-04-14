package gameproject;

import java.util.ArrayList;

public class StopWatch {

    private long startTime = 0;
    private long stopTime = 0;
    private long beforePauseTime;
    private boolean running = false;
    private ArrayList<Long> pauseTimes;

    public StopWatch() {
        this.pauseTimes = new ArrayList<>();
    }

    public void start() {
        if (this.startTime != 0) {
            pauseTimes.add((System.currentTimeMillis() - startTime));
            this.startTime = System.currentTimeMillis();
        } else {
            this.startTime = System.currentTimeMillis();
        }
        this.running = true;
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
        this.running = false;
    }

    //elaspsed time in milliseconds
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

    //elaspsed time in seconds
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

    private long checkPauseTime() {
        if (!pauseTimes.isEmpty()) {
            for (Long time : pauseTimes) {
                beforePauseTime += time;
            }
            return beforePauseTime;
        } else {
            return 0;
        }
    }

}
