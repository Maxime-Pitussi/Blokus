import model.Joueur;
import model.Piece;
import model.Partie;
import java.util.ArrayList;
import org.junit.*;
import java.util.Arrays;
import static org.junit.Assert.*;

public class PartieTest{

	Partie partie;
	Joueur j1;
	Joueur j2;
	Joueur j3;
	Joueur j4;
	ArrayList<Piece> pieces;
	ArrayList<Joueur> joueurs;

	// @Test()
	// public void testConstructeur() throws Exception {


	// 	assertEquals("test du constructeur", , );
	// }

	@Test()
	public void testLancer() {
		partie = new Partie();
		pieces = partie.getJeuModele();

		j1 = new Joueur(1, 1, pieces, false);
		j2 = new Joueur(2, 2, pieces, true);
		j3 = new Joueur(3, 3, pieces, false);
		j4 = new Joueur(3, 4, pieces, true);

		joueurs = new ArrayList<Joueur>();

		joueurs.add(j1);
		joueurs.add(j2);
		joueurs.add(j3);
		joueurs.add(j4);

		partie.lancer(joueurs);

		assertEquals("Test de la création du modèle de pièces", 21, partie.getJeuModele().size());
		assertEquals("Test de la gestion des joueurs", 4, partie.getNbJoueurs());
	}

	// @Test()
	// public void testInitialiserPieces() {
	// 	assertEquals("test de la méthode initialiserPieces", , )
	// }

	// @Test()
	// public void testGetJeuModele() {
	// 	assertEquals("Test de la méthode getJeuModele", , );
	// }

	// @Test()
	// public void testGetModule(){
	// 	assertEquals("Test de la méthode getModule", , );
	// }

	// @Test()
	// public void testGetJoueurs(){
	// 	assertEquals("Test de la méthode getJoueurs", , );
	// }
}