package View;

import Listeners.ViewListener;

public interface AbstractOlympicView {
	public void registerListener(ViewListener listener) ; 
	public void successfullyMessage();
	
	public void failedMessage() ; 
	
	//public void deleteJudge (int indexJudge) ; 
	
	
	/*
	 * 	void registerListener(BusUIEventsListener listener);
	void addPassengerToUI(int id, String name);
	void removePassengerFromUI(int id);
	void busIsFullMessage(String msg);
	void updateNumberOfPassengers(int size);
	 * 
	 * 
	 */
}
