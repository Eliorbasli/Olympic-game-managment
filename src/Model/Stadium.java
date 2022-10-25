package Model;

public class Stadium {
	private int numOfSeats;
	private String location;
	private String nameStadium;
	
	public Stadium (int numOfSeats , String location , String nameStadium) {
		this.numOfSeats = numOfSeats ; 
		this.location = location ; 
		this.nameStadium = nameStadium ; 
		
	}
	
	public String getNameStadium() {
		return nameStadium;
	}
	public int getNumofSeat () {
		return numOfSeats ; 
	}
	
	public String getLocation () {
		return location ; 
	}
	
	public String toString () { 
		return (nameStadium + " in " + location + " with "+ numOfSeats + " seats") ; 
	}
		
}
