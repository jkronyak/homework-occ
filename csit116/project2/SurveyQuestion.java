//Jared Kronyak
/**
 * An abstract class for constructing a survey question with choices and an answer.
 * @author Gerald Cohen, Ph.D.
 */
public abstract class SurveyQuestion {

    private String question;

    /**
     * Constructs a question with empty question text.
     */
    public SurveyQuestion() {
        question = "";
    }

    /**
     * Constructs a question with given question.
     * @param question
     */
    public SurveyQuestion(String question) {
        this.question = question;
    }

    /**
     * Sets the text for this question.
     *
     * @param questionText the question of this survey question
     */
    public void setQuestionText(String questionText) {
        question = questionText;
    }

    /**
     * Returns this question text.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * For multiple choice type questions, return that choice
     * @param index
     * @return choice text or null if index is out of bounds
     */
    public abstract String getChoice(int index);
    
    /**
     * Return the user's answer
     * @return 
     */
    public abstract String getAnswer();
    
    /**
     * Establish the user's answer
     * @param answer
     */
    public abstract void setAnswer(String answer);
    
    /**
     * Returns this question plus any choices presented to the user.
     * @return 
     */
    public String getFullQuestion() {
        return toString();
    }
    
    public String toString() {
        return question + '?';
    }
}
