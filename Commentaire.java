import java.util.concurrent.atomic.AtomicInteger;

public class Commentaire {
	private static final AtomicInteger count = new AtomicInteger(0); //to avoid problem with thread
	private int id;
	public String description;
	public Utilisateur util;
	public Annonce annonce;
	
	public Commentaire(String description, Utilisateur util, Annonce annonce) {
		this.id = count.incrementAndGet(); 
		this.description = description;
		this.util = util;
		this.annonce = annonce;
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

	/**
	 * @return the util
	 */
	public Utilisateur getUtil() {
		return util;
	}

	/**
	 * @param util the util to set
	 */
	public void setUtil(Utilisateur util) {
		this.util = util;
	}
	
	
	
}
