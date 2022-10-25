package Controller;

import Listeners.ModelListener;
import Listeners.ViewListener;
import Model.ModelManger;
import OlympicGamesProject.OlympicProject;
import View.ViewOlympic;

public class Controller implements ModelListener , ViewListener {
	private ModelManger SystemModelManger;
	private ViewOlympic SystemViewListener;
	
	public Controller(ModelManger model, ViewOlympic view) throws Exception {
		this.SystemModelManger = model;
		this.SystemViewListener = view;

		SystemModelManger.registerListener(this);
		SystemViewListener.registerListener(this);
		
		SystemModelManger.readJudgeFromFile(OlympicProject.JudgesFile);
		SystemModelManger.readStadiumFromFile(OlympicProject.StadiumFile);
		
		
	}
	
	public int getNumberOfJudge () { 
		return SystemModelManger.getNumberJudge() ; 
	}
	
	public int getNumberOfStadium () { 
		return SystemModelManger.getNumberStadium() ;  
	}
	
	public int getNumberOfTeams () { 
		return SystemModelManger.getNumberTeams() ;  
	}
	
	public int getNumberAllAthlete () {
		return SystemModelManger.getNumberAllAthlete();
	}
	
	public String showAllJudges (){ 
		return SystemModelManger.printAllJudges();
	}
	
	public String showAllStadium ()  { 
		return SystemModelManger.printAllStdium();
	}

	public String showAllTeams (){ 
		return SystemModelManger.printAllTeam();
	}
	
	public String printAllAthe (){
		return SystemModelManger.printAllAthe();
	}
	
	public void createJudge (String judgeName,String  judgeState,String JudgeArea) {
		SystemModelManger.addNewJudge(judgeName, judgeState, JudgeArea);
	}
	
	public void createStadium (String nameStadium, String State, int size){ 
		SystemModelManger.addNewStadium(nameStadium, State, size);
	}
	
	public void createTeam(String State) {
			SystemModelManger.CreateTeam(State);
	}
	
	public void deleteJudge (Integer indexJudge) { 
		SystemModelManger.deleteAJudge(indexJudge);
	}
	
	public void deleteStadium (Integer indexStadium) { 
		SystemModelManger.deleteAStadium(indexStadium);			
	}
	
	public void deleteTeam (Integer indexTeam){ 
			SystemModelManger.deleteATeamAndAllTheAthlete(indexTeam) ;
	}
	
	public void deeteAthelte (int indexTeam , int indexAthlete){ 
		SystemModelManger.deleteAthleteFromATeam(indexTeam, indexAthlete);
	}
	
	public void addNewAtheToTeam (String State, String athleteName, String athleteSport , String athleteState ) { 
		SystemModelManger.addNewAtheToTeam(State, athleteName, athleteSport, athleteState);
	}
	
	public String deleteAthleteFromATeam(int indexTeam, int indexAthlete){
		return SystemModelManger.deleteAthleteFromATeam(indexTeam, indexAthlete);
	}
	
	public void winerInPersonalComp (Integer stadiumIndex , Integer JudgeIndex , String Sport , Integer win1 , Integer win2 ,Integer win3 ) {
		SystemModelManger.winerInPersonalComp(stadiumIndex, JudgeIndex, Sport, win1, win2, win3);
	}

	public void winerInTeamlComp (Integer stadiumIndex , Integer JudgeIndex , String Sport , Integer Twin1 , Integer Twin2 ,Integer Twin3 ){
		SystemModelManger.winerInTeamlComp(stadiumIndex, JudgeIndex, Sport, Twin1, Twin2, Twin3);
	}
	
	public String winnersOplympicGame () { 
		return SystemModelManger.winnersOplympicGame();
	}
	
}
