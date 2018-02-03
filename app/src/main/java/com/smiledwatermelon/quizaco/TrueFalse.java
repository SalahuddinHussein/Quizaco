package com.smiledwatermelon.quizaco;

/**
 * Created by salahuddin on 2/3/18.
 */

public class TrueFalse {

    int mQuistionResourceID;
    boolean mAnswer;

    public TrueFalse(int question,boolean truefalse){
        mQuistionResourceID=question;
        mAnswer=truefalse;

    }

    public int getQuistionResourceID() {
        return mQuistionResourceID;
    }

    public void setQuistionResourceID(int quistionResourceID) {
        mQuistionResourceID = quistionResourceID;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }
}
