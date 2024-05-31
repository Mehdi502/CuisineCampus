import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Annonce {
	private static final AtomicInteger count = new AtomicInteger(0); //to avoid problem with thread
	private final int id;
	public String adresse;
	public String description;
	public String titre;
	public Utilisateur util;
	public boolean etat;
	public PlatFactory platFactory;
	public Plat platAnnonce;
	public List<Commentaire> liste_commentaire;
	
	public Annonce(String type, String adresse, String description, String titre, Utilisateur util) {
		this.id = count.incrementAndGet(); 
		this.adresse = adresse;
		this.description = description;
		this.titre = titre;
		this.util = util;
		this.etat = true;
		this.platFactory = new PlatFactory();
		this.platAnnonce = platFactory.createPlat(type);
		this.liste_commentaire = new ArrayList<Commentaire>();
	}
	
	//Ajout d'un commentaire pour l'annonce
	public void addCommentaire(Commentaire com) {
		liste_commentaire.add(com);
	}
	
	//Suppression d'un commentaire pour l'annonce
	public void removeCommentaire(Commentaire com) {
		liste_commentaire.remove(com);
	}
	
	public List<Commentaire> getListeCommentaire(){
		return liste_commentaire;
	}
	
	
	//Detail du commentaire en utilisant le Logger
	public void getInformationFromCommentaire() {
		for (Commentaire com: liste_commentaire){
			Logger.getInstance().info("Comment from "+ com.getUtil().getNom() + " "+ com.getUtil().getPrenom() + com.getUtil().getMail() + " about " + com.getDescription());			
		}
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	
	
	/**
	 * @return the util
	 */
	public Utilisateur getUtil() {
		return util;
	}

	/**
	 * @return the titre
	 */
	public String getTitre() {
		return titre;
	}

	/**
	 * @param titre the titre to set
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
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
	 * @return the etat
	 */
	public boolean isEtat() {
		return etat;
	}

	/**
	 * @param etat the etat to set
	 */
	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	/**
	 * @return the platAnnonce
	 */
	public Plat getPlatAnnonce() {
		return platAnnonce;
	}

	/**
	 * @param platAnnonce the platAnnonce to set
	 */
	public void setPlatAnnonce(Plat platAnnonce) {
		this.platAnnonce = platAnnonce;
	}
	
	
	
}
