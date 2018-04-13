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
StopWatch time = new StopWatch();
    private long FastestTime;
    private long Score;

    public long getFastestTime() {
        return FastestTime;
    }

    public void setFastestTime(int FastestTime) {
        this.FastestTime = FastestTime;
    }

    public long getScore() {
        Score = time.getElapsedTimeSecs();
        return Score;
    }

    public void setScore(int Score) {
        this.Score = Score;
    }

    
}
