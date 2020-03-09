package model;

import common.Utils;
import java.util.*;


/**
 * QuestionBank class gets question banks from input txt file
 */
public class QuestionBank extends Observable{
    private static Map<String, List<Question>> topicQuestionMap = new HashMap<String, List<Question>>();
    private String currentTopic = null;
    private Question currentQuestion = null;

    /**
     * The constructor method, loading all the questions into QuestionBank
     */
    public QuestionBank() {
        loadQuestions(Utils.QUESTIONS_FILE);
    }

    /**
     * Choose an unanswered question in a specified topic and notify observers
     * @param topic topic of the question
     */
    public void publish(String topic){
        currentTopic = topic;
        chooseQuestion(topic);

        setChanged();
        notifyObservers(currentQuestion);
    }

    public void reset() {
        topicQuestionMap.clear();
        loadQuestions(Utils.QUESTIONS_FILE);
        currentTopic = null;
        currentQuestion = null;
        setChanged();
        notifyObservers(currentQuestion);
    }

    private static void loadQuestions(String inputQuestionsPath){
        String questionsContent = Utils.readFile(inputQuestionsPath);
        String[] questions = questionsContent.split("<%>");
        for (int i = 0; i < questions.length; i++) {
            String question = questions[i];
            String questionContent = "";
            String topic = "";
            String questionType = "";
            List<String> choices = new ArrayList<>();
            List<String> answers = new ArrayList<>();
            int points = -1;
            String pictureName = "";
            String audioName = "";
            if (question.length() > 0) {
                String[] content = question.split("<#>");
                questionContent = content[0];
                topic = content[1];
                questionType = content[2];
                String[] choicesString = content[3].split("<c>");
                for (int c = 0; c < choicesString.length; c++) {
                    choices.add(choicesString[c]);
                }
                String[] answersString = content[4].split("<c>");
                for (int c = 0; c < answersString.length; c++) {
                    answers.add(answersString[c]);
                }
                points = Integer.valueOf(content[5]);
                pictureName = content[6];
                audioName = content[7];
                Question questionObj = new Question(questionContent, topic, questionType, choices, answers, points, pictureName, audioName);
                addQuestion(questionObj);
            }
        }
    }

    private static void addQuestion(Question question){
        String topic = question.getTopic();
        if(!topicQuestionMap.containsKey(topic)){
            List<Question> questions = new ArrayList<>();
            topicQuestionMap.put(topic, questions);
        }

        List<Question> questions = topicQuestionMap.get(topic);
        questions.add(question);
    }

    private void chooseQuestion(String topic){
        boolean allAnswered = true;
        List<Question> topicQuestions = topicQuestionMap.get(topic);
        if(topicQuestions == null)
            return;
        // check if all questions have been answered to avoid infinite loop in the random selection
        for(Question question : topicQuestions){
            if(!question.isAnswered())
                allAnswered = false;
        }

        if(allAnswered){
            currentQuestion = null;
            return;
        }

        int totalQuestions = topicQuestions.size();
        Random rand = new Random();

        while(true){
            int questionIndex = rand.nextInt(totalQuestions);
            Question question = topicQuestions.get(questionIndex);
            if(!question.isAnswered()){
                currentQuestion = question;
                break;
            }
        }
    }

    /**
     * Get the topic of question that the user is answering
     * @return the topic of question which is being answered
     */
    public String getCurrentTopic() {
        return currentTopic;
    }

    /**
     * Get the current question that the user is answering
     * @return the question which is being answered
     */
    public Question getCurrentQuestion(){
        return currentQuestion;
    }

    /**
     * Get all the topics in question bank
     * @return a list of question topics
     */
    public List<String> getAllTopics(){
        List<String> allTopics = new ArrayList<>();
        for(String key : topicQuestionMap.keySet())
            allTopics.add(key);
        return allTopics;
    }
}
