package Model;

public class Athlete {
	private String athleteName;
	private String athleteState;
	private String athleteSport;
	private int athleteIndex;
	private static int indexCounter = 1;
	public int numOfMedals ; 
	
	public Athlete (String athleteName, String athleteSport , String athleteState){
		
		setAthleteName(athleteName);
		setAthleteSort(athleteSport);
		setAthleteState(athleteState);
		this.numOfMedals = 0 ; 
		
		this.athleteIndex = indexCounter++;
		
	}
		public String getAthleteName() {
			return athleteName;
		}
		public String getAthleteState() {
			return athleteState;
		}
		public String getAthleteSport() {
			return athleteSport;
		}
		public int getMedal () { 
			return numOfMedals ; 
		}
		
		public void addMedal () {
			this.numOfMedals ++ ; 
		}

		public void setAthleteName(String athleteName1) {
			this.athleteName = athleteName1;
		}
		public int getAthleteIndex() {
			return athleteIndex;
		}
		public void setAthleteSort(String athleteSport) {
			this.athleteSport = athleteSport;
		}
		
		public void setAthleteState(String athleteState) {
			this.athleteState = athleteState;
		}
		public void setAthleteSport(String newSport) {
			this.athleteState = newSport ; 
			
		}
		@Override
		public String toString() {
			return "athlete Name: " + athleteName + ", State :  " + athleteState + ", Sport "
					+ athleteSport ;
		}
		
		
		
	}

