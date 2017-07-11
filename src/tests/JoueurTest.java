import model.*;
import java.util.ArrayList;
import org.junit.*;
import java.util.Arrays;
import static org.junit.Assert.*;

public class JoueurTest{

	int equipe = 2;
	int num = 1;
	ArrayList<Piece> jeu = new ArrayList<Piece>();
	int[][] tab = new int[5][5];

	// @Test()
	// public void testConstructeur() throws Exception {

	// 	assertEquals("test du constructeur", , );
	// }

	@Test()
	public void testGetEquipe() throws Exception {

		tab[3][0] = 1;
		tab[3][1] = 1;
		tab[3][2] = 1;
		tab[3][3] = 1;
		tab[3][4] = 1;

		Piece p1 = new Piece(tab);
		jeu.add(p1);
		Joueur j = new Joueur(equipe,num,jeu,false);

		assertEquals("Test getEquipe, normalement egal a 2",equipe,j.getEquipe());
	}

	@Test()
	public void testGetNum() throws Exception {
		tab[3][0] = 1;
		tab[3][1] = 1;
		tab[3][2] = 1;
		tab[3][3] = 1;
		tab[3][4] = 1;

		Piece p1 = new Piece(tab);
		jeu.add(p1);
		Joueur j = new Joueur(equipe,num,jeu,false);

		assertEquals("Test getNum, normalement egal a 1",num,j.getNum());
	}

	@Test()
	public void testIncScoreEtGetScore() throws Exception {
		tab[2][0] = 1;
		tab[2][1] = 1;
		tab[2][2] = 1;
		tab[2][3] = 1;
		tab[2][4] = 1;

		Piece p1 = new Piece(tab);
		jeu.add(p1);
		Joueur j = new Joueur(equipe,num,jeu,false);
		j.incScore(p1);

		assertEquals("Test incScore, on incremente avec une piece de 5 carreaux",5,j.getScore());

		int[][] test = new int[5][5];
		test[2][2] = 1;

		p1 = new Piece(test);
		jeu.add(p1);
		j = new Joueur(equipe,num,jeu,false);
		j.incScore(p1);

		assertEquals("Test incScore, on incremente avec une piece de 1 carreau",1,j.getScore());
	}

	@Test()
	public void testGetTableauActif() throws Exception {
		tab[2][0] = 1;
		tab[2][1] = 1;
		tab[2][2] = 1;
		tab[2][3] = 1;
		tab[2][4] = 1;

		Piece p1 = new Piece(tab);
		jeu.add(p1);
		Joueur j = new Joueur(equipe,num,jeu,false);

		assertEquals("Test getTableauActif, on vérifie que les listes sont égales pour la case (2,2) de la premiere piece",jeu.get(0).getCase(2,2),j.getTableauActif().get(0).getCase(2,2));
	}

	@Test()
	public void testGetBot() throws Exception {
		tab[2][0] = 1;
		tab[2][1] = 1;
		tab[2][2] = 1;
		tab[2][3] = 1;
		tab[2][4] = 1;

		Piece p1 = new Piece(tab);
		jeu.add(p1);

		boolean bot = false;
		Joueur j = new Joueur(equipe,num,jeu,bot);

		assertEquals("Test getBot, ici ce n'est pas un bot",bot,j.getBot());

		bot = true;
		j = new Joueur(equipe,num,jeu,bot);

		assertEquals("Test getBot, ici c'est un bot",bot,j.getBot());
	}

	@Test()
	public void testSetCouleur() throws Exception {
		tab[2][0] = 1;
		tab[2][1] = 1;
		tab[2][2] = 1;
		tab[2][3] = 1;
		tab[2][4] = 1;

		Piece p1 = new Piece(tab);
		Piece p2 = new Piece(tab);
		Piece p5 = new Piece(tab);
		jeu.add(p1);
		jeu.add(p2);
		jeu.add(p5);
		Joueur j = new Joueur(equipe,num,jeu,false);
		j.setCouleur(3);

		int[][] test = new int[5][5];

		test[2][0] = 3;
		test[2][1] = 3;
		test[2][2] = 3;
		test[2][3] = 3;
		test[2][4] = 3;

		Piece p3 = new Piece(test);
		Piece p4 = new Piece(test);

		assertEquals("Test setCouleur pour la première pièce",p3.getForme(),j.getPieceJeuActif(0).getForme());
		assertEquals("Test setCouleur pour la deuxième pièce",p4.getForme(),j.getPieceJeuActif(1).getForme());
	}

	@Test
	public void testRetirerPieceJeuActif() throws Exception {

		tab[2][2] = 1;
		Piece piece = new Piece(tab);
		jeu.add(piece);
		Joueur j = new Joueur(equipe,num,jeu,false);

		int verif = j.getTableauActif().size();
		j.retirerPieceJeuActif(0);
		int test = j.getTableauActif().size();

		assertEquals("Test de retirerPieceJeuActif", verif-1, test);
	}
}