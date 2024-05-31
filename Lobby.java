import java.util.ArrayList;
import java.util.List;

public class Lobby {
	private String lastNews; // This is the information that is notified to all observers whenever it changes
	
	private List<Observer> observers; // This is the list of characters that will receive notification

	public Lobby() {
		observers = new ArrayList<Observer>(); // Initialize the list of observers ( empty at the begining)
	}

	// Add observer to the list
	public void registerObserver(Observer ob){
		observers.add(ob);
	}
	
	// Remove observer from the list
	public void removeObserver(Observer ob){
		observers.remove(ob);
	}
	
	// Notify observers of the list 
	public void notifyObservers(String info){
		for (Observer ob: observers){
			ob.updateFromLobby(info);
		}
	}
	
	// Notify observers of the list 
	public void notifyObservers(){
		if (this.lastNews != null)
			for (Observer ob: observers){
				ob.updateFromLobby(lastNews);
			}
	}
	
	void setLastNews(String lastNews){
		this.lastNews = lastNews; 
		notifyObservers(); // All registered characters are notified
	}
}
