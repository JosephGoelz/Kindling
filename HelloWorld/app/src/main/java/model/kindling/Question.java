package model.kindling;

import java.util.ArrayList;

/**
 * Created by Jay on 4/26/2015.
 */
public abstract class Question {
    public String questionText;
    public String correctAnswer;
    public int correctAnswerIndex;
    public String aAnswer, bAnswer, cAnswer, dAnswer;
    //indexed as 0, 1, 2, 3


    public abstract void populateAnswers(); //will  set all answers to random

    public abstract void generateQuestionText();

    public void correctAnswer(){
        //increments intelligence rating by one
        Application.getUser().incrementIntel();
        //runs animation thread
    }

    public void incorrectAnswer(){
        //decrements intelligence rating by one
        Application.getUser().decrementIntel();
        //runs animation thread
    }

    public abstract void setCorrectAnswer(String correctAnswer);
    //chooses a correctAnswer index and overrides
    //the option text with the correctanswer
}
