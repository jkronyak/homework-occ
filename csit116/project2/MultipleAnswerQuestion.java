//Jared Kronyak
import java.util.ArrayList;

public class MultipleAnswerQuestion extends SurveyQuestion
{
	private ArrayList<String> answers;
	private ArrayList<String> choices;
		
	public MultipleAnswerQuestion()
	{
		super();
		answers = new ArrayList<String>();
		choices = new ArrayList<String>();
	}
	
	public MultipleAnswerQuestion(String inQuestion)
	{
		super(inQuestion);
		answers = new ArrayList<String>();
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
		String allAnswers = "";
		for(String cur : answers)
		{
			allAnswers += cur + " ";
		}
		return allAnswers;
	}

	@Override
	public void setAnswer(String answer)
	{
		answers.add(answer);
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
		
		result += "\n Answers: ";
		for(int i = 0; i < answers.size(); i++)
		{
			result += "\n\t " + answers.get(i);
		}
		
		return result;
	}
	
}
