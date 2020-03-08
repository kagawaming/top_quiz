package model;
import common.Utils;

import java.util.*;
import java.io.File;


/**
 * Question class contains question data
 */
public class Question {
    private String questionContent;
    private String topic;
    private String questionType;
    private List<String> choices;
    private List<String> answers;
    private int points;
    private String pictureName;
    private String audioName;
    private boolean isAnswered = false;

    public Question(String questionContent, String topic, String questionType, List<String> choices, List<String> answers, int points, String pictureName, String audioName) {
        this.questionContent = questionContent;
        this.topic = topic;
        this.questionType = questionType;
        this.choices = choices;
        this.answers = answers;
        this.points = points;
        this.pictureName = pictureName;
        this.audioName = audioName;
    }

    /**
     * isAnsweredRight method checks if answer is right
     * @param userAnswer user's answer
     * @return boolean value true if answer is right and false if answer is wrong
     */
    public boolean isAnsweredRight(List<String> userAnswer) {
        if (userAnswer == null) {
            return false;
        }
        if (userAnswer.size() != this.answers.size()) {
            return false;
        }
        for (String answer : this.answers) {
            if (!userAnswer.contains(answer)) {
                return false;
            }
        }
        return true;
    }


    public boolean isAnswered(){
        return this.isAnswered;
    }


    public void questionAnswered(){
        this.isAnswered = true;
    }

    //getters
    public String getQuestionContent() {
        return this.questionContent;
    }

    public String getTopic() {
        return this.topic;
    }

    public String getQuestionType() {
        return this.questionType;
    }

    public List<String> getChoices() {
        return this.choices;
    }

    public List<String> getAnswers() {
        return this.answers;
    }

    public int getPoints() {
        return this.points;
    }

    public String getPictureFilePath(){
        return new File(Utils.PICTURE_DIR, String.format("%s.jpeg", pictureName)).getPath();

    }

    public String getAudioFilePath(){
        return new File(Utils.PICTURE_DIR, String.format("%s.jpeg", audioName)).getPath();
    }

}
