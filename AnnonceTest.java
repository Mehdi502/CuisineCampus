import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AnnonceTest {
	protected Annonce annonce;
	
	@BeforeEach
	void setUp() throws Exception {
		annonce=new Annonce(null,null,null,null,null);
	}
	
	@Test
	void testRemoveCommentaire() {
		//Test vrai en ajoutant puis supprimant un commentaire
		Commentaire com=new Commentaire("coucou",new Utilisateur(null, null, null, null, null, null),annonce);
		boolean test=true;
		annonce.addCommentaire(com);
		annonce.removeCommentaire(com);
		for(Commentaire i:annonce.getListeCommentaire()) {
			if(i.equals(com)) {
				test=false;
			}
		}
		assertTrue("Le commentaire a bien ete retire de la liste", test);
			
		//Test faux on ne retire pas le commentaire de la liste
		test=true;
		annonce.addCommentaire(com);
		for(Commentaire i:annonce.getListeCommentaire()) {
			if(i.equals(com)) {
				test=false;
			}
		}
		assertFalse("Le commentaire a bien ete retire de la liste", test);
	}
	
	@Test
	void testAddCommentaire() {
		Commentaire com=new Commentaire("coucou",new Utilisateur(null, null, null, null, null, null),annonce);
		//Test faux avec un autre commentaire ajouté
		boolean test=false;
		annonce.addCommentaire(new Commentaire("coucou",new Utilisateur(null, null, null, null, null, null),annonce));
		for(Commentaire i:annonce.getListeCommentaire()) {
			if(i.equals(com)) {
				test=true;
			}
		}
		assertFalse("Le commentaire a bien ete rajoute a la liste", test);	
		//Test Vrai
		test=false;
		annonce.addCommentaire(com);
		for(Commentaire i:annonce.getListeCommentaire()) {
			if(i.equals(com)) {
				test=true;
			}
		}
		assertTrue("Le commentaire a bien ete rajoute a la liste", test);
	}
}
