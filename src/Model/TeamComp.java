package Model;

import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;

public class TeamComp extends Compition {
	
	private ArrayList<Team> participants = new ArrayList<Team>() ;
	
	public TeamComp(Judge judge , Stadium stadium , ArrayList<Team>  participants) {
		super(judge , stadium);
		this.judge = judge ; 
		this.stadium = stadium ; 
		
	}
	
	public ArrayList<Team> getParticipants () { 
		return participants ; 
	}
	
	public void setparticpants (ArrayList<Team> participants) {
	this.participants = participants ; 
	}
}
