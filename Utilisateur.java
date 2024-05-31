import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Utilisateur implements Observer {
	private static final AtomicInteger count = new AtomicInteger(0); //to avoid problem with thread
	private final int id;
	public String nom;
	public String prenom;
	public String ecole;
	public String mail;
	public String password;
	public List<Annonce> annonces;
	public List<Avis> liste_avis_emis;
	public List<Avis> liste_avis_recu;
	public List<Commentaire> liste_commentaire;
	public PlatStore store;
	
	
	public Utilisateur(String nom, String prenom, String ecole, String mail, String password, PlatStore store) {
		this.id = count.incrementAndGet(); 
		this.nom = nom;
		this.prenom = prenom;
		this.ecole = ecole;
		this.mail = mail;
		this.password = password;
		this.liste_avis_emis = new ArrayList<Avis>();
		this.liste_avis_recu = new ArrayList<Avis>();
		this.annonces = new ArrayList<Annonce>();
		this.liste_commentaire = new ArrayList<Commentaire>();
		this.store = store;
	}

	//Deposer une annonce
	public void deposerAnnonce(String type, String adresse, String description, String titre) {
		Annonce an= new Annonce(type, adresse,description,titre,this);
		store.registerAnnonce(an);
		annonces.add(an);
	}
	
	//Supprimer une annonce
	public void supprimerAnnonce(Annonce an){
		store.removeAnnonce(an);
		annonces.remove(an);
	}
	
	public void consulterAnnonce() {
		store.getInformationFromAnnonces();
	}
	
	public void getAnnonceDisponible() {
		store.getInformationFromAnnoncesDisponibles();
	}
	
	public List<Annonce> rechercherAnnonce(String filtre) {
		return store.rechercheFiltre(filtre);	
	}
	
	
	public void ajouterAvis(Avis av) {
		liste_avis_emis.add(av);
	}
	
	public void supprimerAvis(Avis av){
		liste_avis_emis.remove(av);
	}
	
	public void ajouterAvisRecu(Avis av) {
		liste_avis_recu.add(av);
	}
	
	public void supprimerAvisRecu(Avis av){
		liste_avis_recu.remove(av);
	}
	
	//Creer un commentaire sur une annonce
	public void createCommentaire(String description,Annonce an) {
		Commentaire newComment = new Commentaire(description,this,an);
		liste_commentaire.add(newComment);
		an.addCommentaire(newComment);
	}
	
	public void getCommentaireFromAnnonce(int id) {
		Annonce an = store.getInformationFromSpecificAnnonce(id);
		an.getInformationFromCommentaire();	
	}
	
	public void removeCommentaire(Commentaire com, Annonce an) {
		liste_commentaire.remove(com);
		an.removeCommentaire(com);
	}
	
	//Creer un avis sur un utilisateur
	public void creerAvis(String description, Utilisateur util) {
		Avis newAvis = new Avis(description,this,util);
		this.ajouterAvis(newAvis);
		util.ajouterAvisRecu(newAvis);
	}
	
	//Consulter les avis reçus
	public void consulterAvis() {
		for (Avis av: liste_avis_recu){
			Logger.getInstance().info("Avis recu: "+ av.getDescription() + " from "+ av.util_emetteur.getNom() + " " + av.util_emetteur.getPrenom());		
		}
	}
	
	//This method comes from Observer interface
	public void updateFromLobby(String message){
		Logger.getInstance().info("Nouvelle information: " + message);
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the ecole
	 */
	public String getEcole() {
		return ecole;
	}

	/**
	 * @param ecole the ecole to set
	 */
	public void setEcole(String ecole) {
		this.ecole = ecole;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
