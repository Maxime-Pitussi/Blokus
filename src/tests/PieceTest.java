import model.Piece;
import org.junit.*;
import static org.junit.Assert.*;

public class PieceTest{

	@Test()
	public void testConstructeur() throws Exception {
		int[][] forme = new int[5][5];
		forme[2][2] = 1;
		Piece piece = new Piece(forme);

		assertEquals("test du constructeur", 1, piece.getCase(2,2));
	}

	// @Test()
	// public void testConstructeurAlternatif() throws Exception {


	// 	assertEquals("test du constructeur alternatif", , );
	// }

	@Test()
	public void testSetCouleur() throws Exception {
		int[][] tab = new int[5][5];

		tab[0][0] = 1;
		tab[0][4] = 1;
		tab[4][0] = 1;
		tab[4][4] = 1;

		Piece p1 = new Piece(tab);
		p1.setCouleur(2);

		int[][] test = new int[5][5];

		test[0][0] = 2;
		test[0][4] = 2;
		test[4][0] = 2;
		test[4][4] = 2;

		assertEquals("Test setCouleur premiere case premiere ligne egale a 2",test[0][0],p1.getCase(0,0));
		assertEquals("Test setCouleur derniere case premiere ligne egale a 2",test[0][4],p1.getCase(0,4));
		assertEquals("Test setCouleur premiere case derniere ligne egale a 2",test[4][0],p1.getCase(4,0));
		assertEquals("Test setCouleur derniere case derniere ligne egale a 2",test[4][4],p1.getCase(4,4));

		assertEquals("Test setCouleur case avec un 0",tab[3][4],p1.getCase(3,4));
	}

	@Test()
	public void testGetForme() throws Exception {
		int[][] tab = new int[5][5];
		Piece p1 = new Piece(tab);

		assertEquals("Test getForme",tab,p1.getForme());
	}

	@Test()
	public void testGetCase() throws Exception {
		int[][] tab = new int[5][5];

		tab[0][0] = 1;

		Piece p1 = new Piece(tab);

		assertEquals("Test getCase case avec un 1",tab[0][0],p1.getCase(0,0));

		p1.setCouleur(3);

		int[][] test = new int[5][5];

		test[0][0] = 3;

		assertEquals("Test getCase case avec un 3",test[0][0],p1.getCase(0,0));

		assertEquals("Test getCase case avec un 0",test[3][4],p1.getCase(3,4));
	}

	@Test()
	public void testSetCase() throws Exception {
		int[][] forme = new int[5][5];
		Piece p1 = new Piece(forme);
		p1.setCase(0,0,1);
		assertEquals("Test setCase", 1, p1.getCase(0,0));
	}
}