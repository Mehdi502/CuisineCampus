import java.util.concurrent.atomic.AtomicInteger;

public class Avis {
	private static final AtomicInteger count = new AtomicInteger(0); //to avoid problem with thread
	private int id;
	public String description;
	public Utilisateur util_emetteur;
	public Utilisateur util_destinataire;
	
	public Avis(String description, Utilisateur util_emetteur,Utilisateur util_destinataire) {
		this.id = count.incrementAndGet(); 
		this.description = description;
		this.util_emetteur = util_emetteur;
		this.util_destinataire=util_destinataire;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
}
