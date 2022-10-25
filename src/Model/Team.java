package Model;

import java.util.ArrayList;
import Model.Athlete;

public class Team implements Comparable<Object> {
	private String teamState;
	ArrayList <Athlete> allAthletes = new ArrayList <Athlete>();
	private ArrayList <Athlete> teams ; 
	public int grade = 0 ; 
	
	public Team(String teamState , ArrayList <Athlete> athletes) {
		this.teamState = teamState ; 
		this.grade = 0 ; 
		allAthletes = new ArrayList<Athlete>() ; 
	}
	
	public Team(String teamState) {
		this.grade = 0 ; 
		this.teamState = teamState;
		teams = new ArrayList<Athlete>() ; 
		}
	
	
	public ArrayList<Athlete> getTeams() {
		return teams;
	}

	public void setTeams(ArrayList<Athlete> teams) {
		this.teams = teams;
	}

	public String getTeamStae() {
		return teamState;
	}

	public void setTeamState(String teamState) {
		this.teamState = teamState;
	}
	

	
	public void addMedal () {
		this.grade ++ ; 
	}

	public int getNumOfAthletesInATeam() {

		return this.allAthletes.size();
	}
	public int getGrade() {

		return this.grade;
	}
	
	public void addAthleteToTeam(String athleteName, String athleteSport , String teamState) {

		Athlete temp = new Athlete(athleteName, athleteSport, teamState);

		allAthletes.add(temp);

	}
	
	public boolean checkIfAthleteExist(int numOfAthlete) {
		if (allAthletes.get(numOfAthlete - 1) != null) {
			return true;
		} else {
			return false;
		}

	}
	public void updtaeAthleteSport(int numOfAthlete, String newSport) {
		allAthletes.get(numOfAthlete - 1).setAthleteSport(newSport);

	}
	public void deltetAthleteInATeam(int numOfAthlete) {
		allAthletes.remove(numOfAthlete - 1);
	}
	
    public int compareTo(Object compareteam) {
        int compareMedals = ((Team)compareteam).getGrade();

        return (compareMedals - grade);
    }


	@Override
	public String toString() {
		return "Team [teamState=" + teamState + ", allAthletes=" + allAthletes + ", teams=" + teams + ", grade=" + grade
				+ "]";
	}
	

}
