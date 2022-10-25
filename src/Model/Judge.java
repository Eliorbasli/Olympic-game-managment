package Model;

public class Judge {
	private String judgeName;
	private String judgeState;
	private String JudgeArea;
	
	public Judge (String judgeName, String judgeState, String JudgeArea ){
		this.judgeName = judgeName;
		this.judgeState = judgeState;
		this.JudgeArea = JudgeArea;
	}
	
	public String getJudgeName() {
		return judgeName;
	}
	
	public String getJudgeState() {
		return judgeState;
	}
	
	public String getJudgeArea() {
		return JudgeArea;
	}
	
	public void setJudgeArea(String JudgeArea) {
		try {
			this.JudgeArea = JudgeArea;
			
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	public void setJudgeState(String judgeState) {
		try {
			this.judgeState = judgeState;
			
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	public void setJudgeName (String judgeName) {
		try {
			this.judgeName = judgeName ; 
			
		} catch (Exception e) {
			System.out.println("error");
		}
	}
	public String toString () { 
		return (judgeName + " " + judgeState + " " + JudgeArea)  ; 
	}
	

}
