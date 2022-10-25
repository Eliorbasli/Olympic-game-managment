package Model;

public class Compition {
	protected Judge judge ; 
	protected Stadium stadium ; 
	
	public Compition (Judge judge , Stadium stadium ) {
		this.judge = judge ; 
		this.stadium = stadium ; 
	}
	
	public boolean setJudge (Judge judge) { 
		try {
			this.judge = judge ; 
			return true; 
			
		}catch (Exception e) {
			
			return false ; 
		}
	}
		
		public boolean setStadium (Stadium stadium) { 
			try {
				this.stadium = stadium ; 
				return true; 
				
			}catch (Exception e) {
				
				return false ; 
				
			}

		}
		
		public String getJudge () {
			return "dd" ; 
		

}

}