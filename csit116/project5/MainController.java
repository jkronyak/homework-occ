//Jared Kronyak

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;

public class MainController
{
	private WordFinder wordFinder;
	
	@FXML
	private Label status;
	
	@FXML
	private TextField wordsToSearch;
	
	@FXML
	private Button searchButton;
	
	@FXML
	private Label wordsFound;
	
	public MainController()
	{
		
	}
	
	@FXML
	public void handleLoadDictionary(ActionEvent event)
	{
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Dictionary File");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("Text Files", "*.txt"));
		
		File selectedFile= fileChooser.showOpenDialog(stage);
		if(selectedFile != null)
		{
			try
			{
				wordFinder = new WordFinder(selectedFile.toString());
				status.setText("Dictionary Loaded!");
				searchButton.setDisable(false);
			}
			catch(IOException exception)
			{
				System.out.println("Error: " + exception);
			}
		}
	}
	
	public void handleSearchButton(ActionEvent event)
	{
		
		if(wordsToSearch.getText() == null || wordsToSearch.getText().trim().equals(""))
		{
			status.setText("Search field is empty");
		}
		else
		{
			status.setText("SEARCHING");
			String[] words = wordsToSearch.getText().split("\\s+");
			List<String> found = wordFinder.search(words);
			
			String results = "";
			for(String cur : found)
			{
				results += cur +"\n";
			}
			status.setText("DONE - " + found.size() + " results.");
			wordsFound.setText(results);
		}

	}

}
