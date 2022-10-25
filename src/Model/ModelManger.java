package Model;

import java.io.File;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JOptionPane;
import java.time.LocalDate ;
import java.time.format.DateTimeFormatter;

import Listeners.ModelListener;
import Model.Team;
public class ModelManger {
	
	private Vector<ModelListener> listeners ; 
	
	static ArrayList<Judge> allJudges ; 
	
	static ArrayList<Stadium> allStadiums ; 
	
	private ArrayList<Team> allTeams ;
	
	private ArrayList<Athlete> allAthlete ; 
	
	public ModelManger() {
		
		allJudges = new ArrayList<Judge>();
		allStadiums = new ArrayList<Stadium>();
		listeners = new Vector<ModelListener>() ; 
		allTeams = new ArrayList<Team>(); 
		allAthlete = new ArrayList<Athlete>();
		
	}
	
	public void registerListener(ModelListener listener) {
		listeners.add(listener);
	}
	
	public void readJudgeFromFile (String filename) throws Exception {
		try {
			File f = new File(filename) ;
			Scanner s = new Scanner(f) ; 
			
			int numberOfJudges = s.nextInt() ; 
			s.nextLine();
			for(int i = 0 ; i < numberOfJudges  ; i++) {
				String name = s.nextLine(); 
				String state = s.nextLine();
				String judgeArea = s.nextLine();
				
				allJudges.add(new Judge(name, state, judgeArea));
			}
			s.close();			
		} catch (InputMismatchException e ) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}
	}
	
	public void readStadiumFromFile (String filename) throws Exception {
		try {
			File f = new File(filename) ;
			Scanner s = new Scanner(f) ; 
			
			int numberOfStadium = s.nextInt() ; 
			for(int i = 0 ; i <= numberOfStadium -1 ; i++) {
				s.nextLine();
				String name = s.nextLine(); 
				String location = s.nextLine(); 
				int numOfSeats = s.nextInt() ;
				allStadiums.add(new Stadium(numOfSeats, location, name));
			}
			s.close();
		} catch (InputMismatchException e ) {
			System.out.println("somthing wrong with" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}catch (Exception e) {
			System.out.println("somthing wrong with read from Stadium File" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}
	
	}
		

	public void addNewStadium(String nameStadium ,String State , int size ){
		try {
			if(checkIfStadiumExist(nameStadium)) {
				System.out.println(" The Stadium exsit");
			}
			else if (nameStadium.isEmpty() || State.isEmpty()) {
				JOptionPane.showMessageDialog(null, "You must enter name , State and Size ");
			}
			else {
				allStadiums.add(new Stadium(size, State, nameStadium));				
			}
		}catch (Exception e) {
			System.out.println("error " + e.getMessage());
			JOptionPane.showMessageDialog(null, "You must enter name , State and Size " );
		}
		
	}
	
	public void addNewJudge(String judgeName,String judgeState,String JudgeArea)  {
		try {
			if (checkIfJudgeExist(judgeName) ) {
				System.out.println("The judge is exsit");
				JOptionPane.showMessageDialog(null, "The jusge is exsit");
			}
			else if (judgeName.isEmpty() || judgeState.isEmpty() || JudgeArea.isEmpty()) {
				JOptionPane.showMessageDialog(null, "You must enter name , State and Sport ");
				
			}
			else {
				allJudges.add(new Judge(judgeName, judgeState, JudgeArea)) ; 
				
			}
		}catch (NullPointerException e) {
			System.out.println("error " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}catch (Exception e) {
			System.out.println("somthing Wrong with create judge");
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}
		
	}

	public void addNewAtheToTeam (String State, String athleteName, String athleteSport , String athleteState){
		try {
			if (checkIfTeamExist(State) && !athleteName.isEmpty() && !athleteSport.isEmpty()) {
				
				System.err.println(athleteSport);
				for (int i = 0; i < allTeams.size(); i++) {
					if(allTeams.get(i).getTeamStae() == State ) {
				
						allTeams.get(i).addAthleteToTeam(athleteName, athleteSport, State);
						
					}
				}
				allAthlete.add(new Athlete(athleteName, athleteSport, State));
				
				JOptionPane.showMessageDialog(null, "athel added!");
				System.out.println("athel added");
			}
			else if (athleteName.isEmpty() || State.isEmpty() || athleteSport.isEmpty() || athleteState.isEmpty()) {
				JOptionPane.showMessageDialog(null, "You must enter name , State, Sport and  ");
			}
			else {
				
				System.out.println("The team " + State + " is not exsit");
				JOptionPane.showMessageDialog(null, "The team is not exsit!");
			}
			
		}catch (InputMismatchException e) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}
	}
	
	public void CreateTeam (String State ){
		try {
			if (checkIfTeamExist(State) || State.isEmpty()) {
				
				JOptionPane.showMessageDialog(null, "have team with this name"); 
			}
			else {
				allTeams.add(new Team(State));
				JOptionPane.showMessageDialog(null, "Team created"); 
				System.out.println("Team created");
			
			}
			
		} catch (InputMismatchException e ) {
			System.out.println( "input must be String" + e.getMessage());
			JOptionPane.showMessageDialog(null, "input must be String!" + e.getMessage());
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}
	}
	
	public boolean checkIfTeamExist(String name){
		try {

			for (int i =0; i< allTeams.size (); i++) {		
				if (allTeams.get(i).getTeamStae() == name) 
					return true;
				}
			return false;
		
		} catch (InputMismatchException e) {
		System.out.println( "input must be String" + e.getMessage());
		JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		return false ; 
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return false; 
		
		}
		
	}

	public boolean checkIfStadiumExist(String name) throws Exception{
		
		try {
			for (int i = 0; i < allStadiums.size(); i++) {
				if (allStadiums.get(i).getNameStadium().equals(name)) { 
					return true ; 
				}
			
			}
			return false ; 
		} catch (InputMismatchException e) {
			System.out.println( "input must be String" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return false ;
		}
		}

	public String getStadiumNameByIndex(int index) throws Exception{
		
		try {
			return allStadiums.get(index -1 ).getNameStadium() ; 
			//return false ; 
		} catch (InputMismatchException e) {
			System.out.println( "input must be String" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return "" ;
			}
		}
	
	public boolean checkIfJudgeExist(String name) throws Exception{
		try {

			for (int i = 0; i < allJudges.size(); i++) {
				if (allJudges.get(i).getJudgeName().equals(name)) { 
					return true ; 
				}
			
			}
			return false ; 
		
		} catch (InputMismatchException e ) {
			System.out.println( "input must be String" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return false ;
			
		}
	}
	
	public boolean checkIfAtleteExsit (String name) throws Exception {
		try {
			for (int i = 0; i < allTeams.size(); i++) {
				for (int j = 0; j < allTeams.get(i).getTeams().size(); j++) {
					if(allTeams.get(i).getTeams().get(j).getAthleteName().equals(name) ) {
						return false;
					}
					
					
				}
				
			}
			return true ;
		} catch (InputMismatchException e) {
			System.out.println( "input must be String" + e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return false;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return false;
		}
		
	}
		
	public String deleteATeamAndAllTheAthlete(Integer indexTeam){
		try {
				allTeams.remove(indexTeam - 1);
				return "Succsess!";

		} catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "This team does not exist!" );
			return "This team does not exist";
			
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null,"Failed" );
			return e.getMessage();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null,  "Failed");
			return e.getMessage();
		}
	}
	
	public String deleteAthleteFromATeam(Integer indexTeam, Integer indexAthlete ) {
		
			try {
				
				if (indexTeam > 0 && indexAthlete -1< allTeams.get(indexTeam -1 ).getNumOfAthletesInATeam()) {
					
					allTeams.get(indexTeam -1 ).allAthletes.remove(indexAthlete -1 );
					System.out.println("Athlete remove");
					JOptionPane.showMessageDialog(null, "Athlete remove");
					return "Succsess!";
				}else if (indexAthlete -1 > allTeams.get(indexTeam -1 ).getNumOfAthletesInATeam()) {
					JOptionPane.showMessageDialog(null, "The Athlete is not exsit!");
				}else if (indexTeam -1  > allTeams.size() ) {
					JOptionPane.showMessageDialog(null, "The Team is not exsit!");
				}
				else {
					JOptionPane.showMessageDialog(null, "Somthing Wrong!");
				}
			
				return "Failed";
			} catch (IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
				return e.getMessage();
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
				return e.getMessage();
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Somthing Wrong!");
				return e.getMessage();
			}
	} 

	public String deleteAStadium(Integer indexStadium) {
		try {
			if (indexStadium != null && indexStadium > 0 ) {
				allStadiums.remove(indexStadium - 1);
				JOptionPane.showMessageDialog(null, "Deleted!");
				return "Succsess!";	
			}
			else { 
				JOptionPane.showMessageDialog(null, "you must select a stadium!");
				return "you must select a stadium!";
			}
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return e.getMessage();
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return e.getMessage();
		}
	}
	
	public String deleteAJudge(Integer indexJudge){
			try {
				allJudges.remove(indexJudge - 1);
				return "Succsess!";
			} catch (IndexOutOfBoundsException e) {
				JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
				return "This team does not exist";
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
				return e.getMessage();
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
				return e.getMessage();
			}
		}
		
	public String printAllStdium () {
		
		StringBuilder allStdium = new StringBuilder() ; 
		
		allStdium.append("\nStadium : \n");
		
		for (int i = 0 ; i < allStadiums.size() ; i ++ ) {
			
			allStdium.append((i + 1 )+ ") " + allStadiums.get(i).toString() + "\n" );

			
		}
		
		return allStdium.toString();
	}
	
	public String printAllJudges (){
		
		try {
			
			StringBuilder allJudgeinfo = new StringBuilder() ; 
			
			allJudgeinfo.append("\nJudges : \n");
			for (int i = 0 ; i < allJudges.size() ; i ++ ) {
				
				allJudgeinfo.append(i +1 +") " + allJudges.get(i).toString() + "\n");
				
			}
			return allJudgeinfo.toString();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		
			return "Failed";
		}
		
	}
	
	public String printAllTeam ()  { 
		StringBuilder allTeaminfo = new StringBuilder() ; 
		
		allTeaminfo.append("\nall Teams : \n");
		
		if (allTeams.size() != 0 ) {
			for (int i = 0; i < allTeams.size() ; i++) {
				
				allTeaminfo.append(i + 1 + ") " + allTeams.get(i).getTeamStae() + " grade : "+allTeams.get(i).getGrade() +   "\n " + allTeams.get(i).getNumOfAthletesInATeam() + " \n");
				
				for (int j = 0; j < allTeams.get(i).getNumOfAthletesInATeam() ; j++) {
					
					allTeaminfo.append( (j +1) +") "+ allTeams.get(i).allAthletes.get(j).toString() +"\n");
				}
				
			}
		}
		return allTeaminfo.toString() ;
		
	}
	
	public String printAllAthe (){ 
		 
		try {
			StringBuilder allAthelinfo = new StringBuilder() ; 
			
			allAthelinfo.append("\nall Atheltes : \n" + allAthlete.size() +"\n");
			
			for (int i = 0 ; i < allAthlete.size() ; i ++ ) {
				
				allAthelinfo.append(i +1 +")" + allAthlete.get(i).toString() +  "\n");
				
			}
			return allAthelinfo.toString();
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
			return "Failed!";
		}
		
	}
	
	public int getNumberJudge () { 
		return allJudges.size();
	}
	
	public int getNumberStadium () { 
		return allStadiums.size();
	}
	
	public int getNumberTeams () { 
		return allTeams.size();
	}
	
	public int getNumberAllAthlete () {
		return allAthlete.size();
	};

	public void winerInPersonalComp (Integer stadiumIndex , Integer JudgeIndex , String Sport , Integer win1 , Integer win2 ,Integer win3 ){
		try {
			
			System.out.println("sport " + Sport);
			
			String JudgeSport = allJudges.get(JudgeIndex-1).getJudgeArea();
			System.out.println("judg " + JudgeSport );
			
			String Win1Sport = allAthlete.get(win1 -1).getAthleteSport();
			System.out.println("win1 " + Win1Sport );
			
			String Win2Sport = allAthlete.get(win2 -1 ).getAthleteSport();
			System.out.println("win2" + Win2Sport );
			
			String Win3Sport = allAthlete.get(win3 -1 ).getAthleteSport();
			System.out.println("win3 " + Win3Sport );
			
			System.out.println("!!" + JudgeSport.equals(Sport));
			
			if ( (JudgeSport.equals(Sport) || JudgeSport.equals("Both")) &&
					(Win1Sport.equals(Sport) || Win1Sport.equals("Both"))  &&
					(Win2Sport.equals(Sport) || Win2Sport.equals("Both")) && 
					(Win3Sport.equals(Sport)||Win3Sport.equals("Both") )) {

				if (Sport.equals("Running")) {
					System.out.println("sport: Running");
					
					for (int i = 0; i <= allTeams.size(); i++) {
						
						if (allTeams.get(i).getTeamStae().equals(allAthlete.get(win1-1).getAthleteState())) {
							
							allTeams.get(i).addMedal();
							allTeams.get(i).addMedal();
							allTeams.get(i).addMedal();
							System.out.println("added 3 points to " +allAthlete.get(win1-1).getAthleteState() );
							
						}
						else if (allTeams.get(i).getTeamStae().equals(allAthlete.get(win2-1).getAthleteState())) {
							allTeams.get(i).addMedal();
							allTeams.get(i).addMedal();							
							System.out.println("added 2 points to " +allAthlete.get(win2-1).getAthleteState() );
						}
						else if (allTeams.get(i).getTeamStae().equals(allAthlete.get(win3-1).getAthleteState())) {
							System.out.println("added 1 point to " +allAthlete.get(win3-1).getAthleteState() );
							allTeams.get(i).addMedal();
						}
					}	
				}
				
				else if (Sport.equals("HighJump")) {
					
					for (int i = 0; i <= allTeams.size(); i++) {
						
						if (allTeams.get(i).getTeamStae().equals(allAthlete.get(win1-1).getAthleteState())) {
							allTeams.get(i).addMedal();
							allTeams.get(i).addMedal();
							allTeams.get(i).addMedal();
							System.out.println("added 3 points to " +allAthlete.get(win1-1).getAthleteState() );
							
						}
						else if (allTeams.get(i).getTeamStae().equals(allAthlete.get(win2-1).getAthleteState())) {
							allTeams.get(i).addMedal();
							allTeams.get(i).addMedal();							
							System.out.println("added 2 points to " +allAthlete.get(win2-1).getAthleteState() );
						}
						else if (allTeams.get(i).getTeamStae().equals(allAthlete.get(win3-1).getAthleteState())) {
							System.out.println("added 1 point to " +allAthlete.get(win3-1).getAthleteState() );
							allTeams.get(i).addMedal();
						}
					}

				}
				
			}
			
			else {
				JOptionPane.showMessageDialog(null, "Someone can't to participate in this Compitions,\n Select again !");
				System.out.println("Someone can not to participate in this Compitions, Select again ");
			}
	
		}catch (InputMismatchException e ) {
		//	JOptionPane.showMessageDialog(null, "some of input is incorrect, try again!");
			System.out.println("some of input is incorrect, try again");
		}catch (Exception e) {
			System.out.println("must select Stadium , judge and 3 winners ,   " + e.getMessage());
			//JOptionPane.showMessageDialog(null, "must select Stadium , judge and 3 winners! ");
			//JOptionPane.showMessageDialog(null, "Failed!" + e.getMessage());
		}
		
		
	}
	
	public void winerInTeamlComp (Integer stadiumIndex , Integer JudgeIndex , String Sport , Integer Twin1 , Integer Twin2 ,Integer Twin3 ){
		
		try {
			String JudgeSport = allJudges.get(JudgeIndex-1).getJudgeArea();
			System.out.println("judg!!! " + JudgeSport );
			
			String Win1State = allTeams.get(Twin1 -1).getTeamStae(); 
			System.out.println("win1!!!! " + Win1State );
			
			String Win2State = allTeams.get(Twin2 -1 ).getTeamStae();
			System.out.println("win2!!!!" + Win2State );
			
			String Win3State = allTeams.get(Twin3 -1 ).getTeamStae();
			System.out.println("win3 !!!" + Win3State );
		
			if (Sport.equals("Running") &&JudgeSport.equals(Sport) || JudgeSport.equals("Both")) {
				//if(compTeamRunning.contains(Win1State) && compTeamRunning.contains(Win2State) && compTeamRunning.contains(Win3State)) {
					
					System.out.println("sport: Running");
					
					allTeams.get(Twin1-1).addMedal();
					allTeams.get(Twin1-1).addMedal();
					allTeams.get(Twin1-1).addMedal();
					
					allTeams.get(Twin2-1).addMedal();
					allTeams.get(Twin2-1).addMedal();
					
					allTeams.get(Twin3-1).addMedal();
					
					//sport == HighJump
			}else if ( Sport.equals("HighJump") &&(JudgeSport.equals(Sport) || JudgeSport.equals("Both"))) {
				
				//if(compTeamRunning.contains(Win1State) && compTeamRunning.contains(Win2State) && compTeamRunning.contains(Win3State)) {
				
				System.out.println("sport: HighJump");
				
				allTeams.get(Twin1-1).addMedal();
				allTeams.get(Twin1-1).addMedal();
				allTeams.get(Twin1-1).addMedal();
				
				allTeams.get(Twin2-1).addMedal();
				allTeams.get(Twin2-1).addMedal();
				
				allTeams.get(Twin3-1).addMedal();
			}
			
			
			else
			{ 
				JOptionPane.showMessageDialog(null, "Someone can not to participate in this Compitions,\n Select again !");
				System.out.println("Someone can not to participate in this Compitions, Select again ");
				
			}
			
			
		}catch (InputMismatchException e ) {
				JOptionPane.showMessageDialog(null, "some of input is incorrect, try again!" );
				System.out.println("some of input is incorrect, try again");
				
		}catch (Exception e) {
				System.out.println("some input is null  - " + e.getMessage());
				JOptionPane.showMessageDialog(null, "must select Stadium , judge and 3 winners!");
			}
		
	}
		
	public String winnersOplympicGame () {
		
		StringBuilder allTeamsWinner = new StringBuilder() ;
		
		Collections.sort(allTeams);
		
		LocalDate date = LocalDate.now();
		
		String formattedDate = date.format(DateTimeFormatter.ofPattern("dd-MMM-yy"));
		
		
		allTeamsWinner.append(" Olympic Game Winners" + formattedDate + " \n\n") ; 
		if (allTeams.size() > 2 ) {
			
			allTeamsWinner.append("First Place: " + allTeams.get(0).getTeamStae()  + " with" + allTeams.get(0).getGrade() + " points\n" +
					"Second Place: " + allTeams.get(1).getTeamStae()   + " with" + allTeams.get(1).getGrade() + " points\n" + 
					"Third Place: " + allTeams.get(2).getTeamStae()  + " with" + allTeams.get(2).getGrade() + " points\n" );
						
		}else {
			allTeamsWinner.append("You must have 3 Teams") ; 
		}
		
		
	return allTeamsWinner.toString();
	}

}
