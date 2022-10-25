package Listeners;

public interface ViewListener {
	
	public int getNumberOfJudge ()  ; 

	public int getNumberOfStadium ()  ; 
	
	public int getNumberOfTeams () ; 
	
	public int getNumberAllAthlete(); 
	
	public String showAllJudges () ; 
	
	public String showAllStadium () ; 
	
	public String showAllTeams () ; 
	
	public String printAllAthe (); 
	
	public void createJudge (String judgeName,String  judgeState,String JudgeArea) ; 
	
	public void createStadium (String nameStadium, String State, int size) ; 
	
	public void createTeam(String State)  ; 
	
	public void deleteJudge (Integer indexJudge) ; 
	
	public void deleteStadium (Integer indexStadium) ; 
	
	public void deleteTeam (Integer indexTeam)  ; 
	
	public void deeteAthelte (int indexTeam , int indexAthlete)  ; 
	
	public void addNewAtheToTeam (String State, String athleteName, String athleteSport , String athleteState );

	public void winerInPersonalComp (Integer stadiumIndex , Integer JudgeIndex , String Sport , Integer win1 , Integer win2 ,Integer win3 ) ;
	
	public void winerInTeamlComp (Integer stadiumIndex , Integer JudgeIndex , String Sport , Integer Twin1 , Integer Twin2 ,Integer Twin3 );
	
	public String winnersOplympicGame () ; 
	
	public String deleteAthleteFromATeam(int indexTeam, int indexAthlete); 

}
