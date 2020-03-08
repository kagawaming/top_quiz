package model;

import java.util.Observable;

/**
 * QuestionTime class contains question timer functions
 */
public class QuestionTime extends Observable {
    // answer time for each question is 30s
    public static final int TOTAL_TIME = 30;
    // decrease by 1s each time
    public static final int DELAY_TIME = 1;

    private int leftTime = TOTAL_TIME;

    //set change and notify observers
    public void publish(){
        leftTime -= DELAY_TIME;

        setChanged();
        notifyObservers();
    }

    public int getLeftTime(){
        return leftTime;
    }

    public boolean isTimeRunOut(){
        if(leftTime <= 0)
            return true;
        return false;
    }

    //change time digit to red when 1/3 time left
    public boolean isRedAlert() {
        if(leftTime < (TOTAL_TIME/3))
            return true;
        return false;
    }

    public void resetLeftTime(){
        leftTime = TOTAL_TIME;
        setChanged();
        notifyObservers();
    }
}
