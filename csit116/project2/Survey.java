//Jared Kronyak
import java.util.ArrayList;
/*
 * 	Prototype for the Survey class
 *  @author
 */
public class Survey 
{
	private ArrayList<SurveyQuestion> survey;
	
	public Survey()
	{
		survey = new ArrayList<SurveyQuestion>();
	}
	
	public void addQuestion(SurveyQuestion question)
	{
		survey.add(question);
	}
	
	public void printQuestions()
	{
		for(SurveyQuestion cur : survey)
		{
			System.out.println(cur.getFullQuestion());
		}
	}
	
}
