import java.util.*;
import model.*;
import org.junit.*;
import static org.junit.Assert.*;

public class ModuleTest{

	private int[][] forme;
	private int[][] formeG;
	private int[][] formeD;
	private int[][] formeB;
	private int[][] formeC;
	private Module module;
	private Piece test;
	private Piece testTemoin;

	// @Test()
	// public void testConstructeur() throws Exception {


	// 	assertEquals("test du constructeur", , );
	// }

	@Test()
	public void testSelectionner() throws Exception {
		module = new Module(20,1);	

		int[][] formeTemoin  = new int[5][5];

		formeTemoin[0][0] = 1;
		formeTemoin[0][1] = 1;
		formeTemoin[1][1] = 1;

		testTemoin = new Piece(formeTemoin);

		module.selectionner(testTemoin);

		int[][] forme  = new int[5][5];

		forme[0][0] = 1;
		forme[0][1] = 1;
		forme[1][1] = 1;

		test = new Piece(forme);

		assertEquals("Test du fonctionnement de la sélection pour la pièce selection", test.getCase(0,1), module.getSelection().getCase(0,1));
		assertEquals("Test du fonctionnement de la sélection pour la pièce active" , test.getCase(0,1), module.getActive().getCase(0,1));
	}

	@Test()
	public void testPivotG() throws Exception {
		forme  = new int[5][5];
		formeG = new int[5][5];
		module = new Module(20,1);

		forme[1][1] = 1;
		formeG[1][3] = 1;

		test = new Piece(forme);

		module.selectionner(test);
		module.pivotG();

		assertEquals("Test de la rotation de la pièce à gauche", formeG, module.getActive().getForme());
	}

	@Test()
	public void testPivotD() throws Exception {
		forme  = new int[5][5];
		formeD = new int[5][5];
		module = new Module(20,1);

		forme[1][1] = 1;
		formeD[3][1] = 1;

		test = new Piece(forme);

		module.selectionner(test);
		module.pivotD();

		assertEquals("Test de la rotation de la pièce à droite", formeD, module.getActive().getForme());
	}

	@Test()
	public void testRotaV() throws Exception {
		forme  = new int[5][5];
		formeG = new int[5][5];

		module = new Module(20,1);

		forme[1][1] = 1;
		formeG[1][3] = 1;

		test = new Piece(forme);

		module.selectionner(test);
		module.rotaV();

		assertEquals("Test de l'inversement en miroir vertical", formeG, module.getActive().getForme());
	}

	@Test()
	public void testRotaH() throws Exception {
		forme  = new int[5][5];
		formeD = new int[5][5];

		module = new Module(20,1);

		forme[1][1] = 1;
		formeD[3][1] = 1;

		test = new Piece(forme);

		module.selectionner(test);
		module.rotaH();

		assertEquals("Test de l'inversement en miroir horizontal", formeD, module.getActive().getForme());
	}

	@Test()
	public void testValiderVerifier() throws Exception {
		forme  = new int[5][5];
		test   = new Piece(forme);
		module = new Module(20,1);

		int[][] grilleTemoin = new int[20][20];

// -------------------------------------------------------------------------------------------------------------------

		module.selectionner(test);
		module.valider(0,0);
		assertEquals("Avec pièce vide", grilleTemoin, module.getGrille());

// -------------------------------------------------------------------------------------------------------------------

		grilleTemoin[0][0] = 1;

		forme[2][2] = 1;
		test = new Piece(forme);
		module.selectionner(test);
		assertEquals("Pièce au coin valide pour le 1er tour", true, module.valider(0,0));
		assertEquals("Avec pièce au coin pour le 1er tour", grilleTemoin, module.getGrille());

// -------------------------------------------------------------------------------------------------------------------

		forme[0][0] = 1;
		forme[1][0] = 1;
		forme[1][1] = 1;
		forme[1][2] = 1;
		test = new Piece(forme);

		module.selectionner(test);
		module.valider(2,2);

		module.selectionner(test);
		module.valider(19,19);

		module.selectionner(test);
		module.valider(3,2);

		assertEquals("Superposée à une autre pièce, posée dans un coin, ou collée à une pièce de la même couleur", grilleTemoin, module.getGrille());

// -------------------------------------------------------------------------------------------------------------------

		grilleTemoin[1][1] = 1;
		grilleTemoin[2][1] = 1;
		grilleTemoin[2][2] = 1;
		grilleTemoin[2][3] = 1;
		grilleTemoin[3][3] = 1;

		// grilleTemoin[17][17] = 1;
		// grilleTemoin[18][17] = 1;
		// grilleTemoin[18][18] = 1;
		// grilleTemoin[18][19] = 1;
		// grilleTemoin[19][19] = 1;

		module.selectionner(test);
		module.valider(3,3);

		assertEquals("Collée au coin d'une pièce de la même couleur", grilleTemoin, module.getGrille());

// -------------------------------------------------------------------------------------------------------------------

		module.selectionner(test);
		module.valider(0,20);
		
		assertEquals("En dehors de la grille", grilleTemoin, module.getGrille());
	}

	@Test
	public void testTourDeBot(){
		// Partie laPartie = new Partie();										// Création partie

		// ArrayList<Joueur> joueurs = new ArrayList<Joueur>();					// Création joueurs
		// Joueur robot1 = new Joueur(1, 1, laPartie.getJeuModele(), true);
		// Joueur robot2 = new Joueur(2, 2, laPartie.getJeuModele(), true);
		// Joueur humain = new Joueur(3, 3, laPartie.getJeuModele(), false);
		// joueurs.add(robot1);
		// joueurs.add(robot2);
		// joueurs.add(humain);

		// laPartie.lancer(joueurs);											// Initialisation partie

		// laPartie.getModule().selectionner(humain.getTableau().get(4));
		// humain.selectionner(humain.getTableau().get(4));
		// laPartie.getModule().valider();

		module = new Module(20,1);												// Création module

		ArrayList<Piece> lesPieces = new ArrayList<Piece>();

		int[][] forme = new int[5][5];											// Création tableau de pièces
		int[][] forme1 = new int[5][5];
		int[][] forme2 = new int[5][5];

		forme[2][2] = 1;
		forme[1][2] = 1;
		forme[3][2] = 1;
		forme[2][1] = 1;
		forme[2][3] = 1;

		forme1[1][2] = 1;
		forme1[2][2] = 1;
		forme1[3][2] = 1;
		forme1[4][2] = 1;
		forme1[2][1] = 1;

		forme2[2][2] = 1;
					
		Piece p1 = new Piece(forme);																		//
		Piece p2 = new Piece(forme1);
		Piece p3 = new Piece(forme2);
		
		lesPieces.add(p1);
		lesPieces.add(p2);
		lesPieces.add(p3);


		assertEquals("Le tour 1 du bot", true, module.tourDeBot(lesPieces));
		assertEquals("Grille bien remplie ? 1", 1, module.getCaseGrille(0,0));
		lesPieces.remove(2);


		assertEquals("Le tour 2 du bot", true, module.tourDeBot(lesPieces));										// 2e tour du bot
		assertEquals("Grille bien remplie ? 2", 1, module.getCaseGrille(1,1));
		assertEquals("Grille bien remplie ? 2", 1, module.getCaseGrille(1,2));
		assertEquals("Grille bien remplie ? 2", 1, module.getCaseGrille(1,3));
		assertEquals("Grille bien remplie ? 2", 1, module.getCaseGrille(1,4));
		assertEquals("Grille bien remplie ? 2", 1, module.getCaseGrille(2,2));
		lesPieces.remove(1);

		module = new Module(20,1);
		assertEquals("Test d'un début avec une croix (impossible)", false, module.tourDeBot(lesPieces));

	}

	@Test()
	public void testVerifTourPossible() throws Exception {

		module = new Module(20,1);
		forme = new int[5][5];
		test = new Piece(forme);
		test.setCase(2,2,1);

		ArrayList<Piece> pieces = new ArrayList<Piece>();
		pieces.add(test);

		assertEquals("Test de verifTourPossible", true, module.verifTourPossible(pieces));
	}

	// @Test()
	// public void testIncTour() throws Exception {

	// 	assertEquals("Test de incTour", , );
	// }

	// @Test()
	// public void testDecTour() throws Exception {

	// 	assertEquals("Test de decTour", , );
	// }
}