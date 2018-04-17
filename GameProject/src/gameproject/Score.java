/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameproject;

/**
 *
 * @author baswo
 */
public class Score {

    private long FastestTime;
    private long Score;

    /**
     * Getter for FastestTime
     *
     * @return FastestTime
     */
    public long getFastestTime() {
        return FastestTime;
    }

    /**
     * Setter for FastestTime
     *
     * @param FastestTime time to set
     */
    public void setFastestTime(int FastestTime) {
        this.FastestTime = FastestTime;
    }

    /**
     * Getter for Score
     *
     * @param time
     * @return
     */
    public long getScore(StopWatch time) {
        Score = time.getElapsedTimeSecs();
        return Score;
    }
}
