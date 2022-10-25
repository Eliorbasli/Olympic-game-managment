//Last Project in object oriented java
//Lecturer : Keren Kalif

//Elior Basli ID : 313325987

package OlympicGamesProject;

import Controller.Controller;
import Model.ModelManger;
import View.ViewOlympic;
import javafx.application.Application;
import javafx.stage.Stage;

public class OlympicProject extends Application {
	
	public static String StadiumFile=  "Stadiums.txt"; 
	public static String JudgesFile=  "Judges.txt";
	//public static String TeamsFile = "Teams.txt" ; 
	
	public static void main(String[] args) {
		launch(args);

	}
	public void start (Stage primaryStage) throws Exception { 
		ModelManger modelManger = new ModelManger() ; 
		ViewOlympic ViewOlympic = new ViewOlympic(new Stage()) ; 
		Controller controller = new Controller(modelManger, ViewOlympic) ; 
			
	}

}
