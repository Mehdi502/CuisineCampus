import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		//Setup
		Lobby hub = new Lobby();
		List<Annonce> annoncefiltre = new ArrayList<Annonce>();
		PlatStore platStore = new PlatStore(hub);
		
		//Premier utilisateur
		Utilisateur user1 = new Utilisateur("Murtin","Thibaud","Polytech","test@test.com","password",platStore);
		hub.registerObserver(user1);
		user1.deposerAnnonce("Americain","Annecy", "Burger" , "Burger Delicieux");
		
		//Deuxieme utilisateur
		Utilisateur user2 = new Utilisateur("Zecchinon","Sébastien","Polytech","test2@test.com","password2",platStore);
		hub.registerObserver(user1);
		user2.deposerAnnonce("Italien","Annecy", "Pizza" , "Plat Formidable");
	  
		//Action sur une annonce
		System.out.println("Actions annonces:");
		Annonce lastAnnonce =user2.annonces.get(user2.annonces.size()-1);
		Plat platLastAnnonce = lastAnnonce.getPlatAnnonce();
		platLastAnnonce = new WithoutGluten(platLastAnnonce);
		platLastAnnonce = new WithTomatoe(platLastAnnonce);
		platLastAnnonce.getIngredients();
		user1.createCommentaire("Pas terrible",lastAnnonce);
		lastAnnonce.getInformationFromCommentaire();
		System.out.println("\n");
		
		//Recherche avec filtre sur titre ou description
		System.out.println("Recherche filtre:");
		annoncefiltre = user1.rechercherAnnonce("Plat Formidable");
		user1.consulterAnnonce();
		System.out.println("\n");
		
		//Test avis
		System.out.println("Test avis:");
		user1.creerAvis("Pas très bon cuisinier", user2);
		user2.consulterAvis();
		System.out.println("\n");
		
		//Suppression
		System.out.println("Test suppression:");
		user1.supprimerAnnonce(user1.annonces.get(user1.annonces.size()-1));
		user1.consulterAnnonce();
		System.out.println("\n");
		
		//Desactivation Annonce
		System.out.println("Annonces:");
		user2.annonces.get(user2.annonces.size()-1).setEtat(false);
		user1.consulterAnnonce();
		System.out.println("\n");
		
		//Annonce disponibles
		System.out.println("Annonces Disponibles:");
		user1.getAnnonceDisponible();
		System.out.println("\n");
	}

}
