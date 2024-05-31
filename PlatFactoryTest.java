import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlatFactoryTest {
	protected PlatFactory platFactory;

	@BeforeEach
	void setUp() throws Exception {
		platFactory = new PlatFactory();
	}

	@Test
	void testCreatePlat() {
		String type = "";//Test avec chaine vide
		assertFalse("Erreur pas de type sp�cifi�", platFactory.createPlat(type) instanceof Plat);
		type = "Francais";//Test avec type non existant
		assertFalse("Mauvais type sp�cifi�", platFactory.createPlat(type) instanceof Plat);
		type = "Americain";//Test type Am�ricain
		assertTrue("Plat Americain", platFactory.createPlat(type) instanceof Americain);
		type = "Italien";//Test type Italien
		assertTrue("Plat Italien", platFactory.createPlat(type) instanceof Italien);
		type = "Vietnamien";//Test type Vietnamien
		assertTrue("Plat Vietnamien", platFactory.createPlat(type) instanceof Vietnamien);
	}
}
