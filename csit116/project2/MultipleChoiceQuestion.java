//Jared Kronyak
import java.util.ArrayList;

public class MultipleChoiceQuestion extends SurveyQuestion
{
	private String answer;
	private ArrayList<String> choices;
	
	public MultipleChoiceQuestion()
	{
		super();
		answer = "";
		choices = new ArrayList<String>();
	}
	
	public MultipleChoiceQuestion(String inQuestion)
	{
		super(inQuestion);
		answer = "";
		choices = new ArrayList<String>();
	}
	
	@Override
	public String getChoice(int index)
	{
		if(index >= choices.size())
		{
			return null;
		}
		return choices.get(index);
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
	
	public void addChoice(String inChoice)
	{
		choices.add(inChoice);
	}
	
	public String getFullQuestion()
	{
		String result = super.getFullQuestion();
		
		for(int i = 0; i < choices.size(); i++)
		{
			result += "\n " + (i + 1) + ". " + choices.get(i);
		}
		result += "\n Answer: " + getAnswer();
		return result;
	}
	
}
