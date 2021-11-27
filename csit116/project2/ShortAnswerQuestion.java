//Jared Kronyak

public class ShortAnswerQuestion extends SurveyQuestion
{
	private String answer;
	
	public ShortAnswerQuestion()
	{
		super();
		answer = "";
	}
	
	public ShortAnswerQuestion(String inQuestion)
	{
		super(inQuestion);
		answer = "";
	}

	@Override
	public String getChoice(int index)
	{
		return null;
	}

	@Override
	public String getAnswer() 
	{
		return answer;
	}

	@Override
	public void setAnswer(String answer) 
	{
		this.answer = answer;
	}
	
	public String getFullQuestion()
	{
		return (super.getFullQuestion() + "\n Answer: " + answer);
	}
	
	
}
