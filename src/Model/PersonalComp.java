package Model;

import java.util.ArrayList;

public class PersonalComp extends Compition {
	
	private ArrayList<Athlete> particpants = new ArrayList<>() ;
	private ArrayList<Athlete> winners = new ArrayList<>(); 
	
	Athlete firstPlace ; 
	Athlete secPlace ; 
	Athlete ThiPlace ; 

	public PersonalComp(Judge judge, Stadium stadium , ArrayList<Athlete> particpants , ArrayList<Athlete> winners) {
		super(judge, stadium);
		this.particpants = particpants; 
		this.winners = winners ; 
		
	}

	@Override
	public String toString() {
		return "PersonalComp : \n "
				+ "Stadium" + stadium + " judge" + judge 
				+ "\nparticpants=" + particpants + ",\n winners=" + winners + " ]";
	}
	
	
	
	
	
	
	
	


}
