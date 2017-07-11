package model;

import java.util.ArrayList;

/**
 * Fichier : Partie.java
 * Date : 06/06/2016
 * Derniere mise a jour : 20/06/2016
 *
 * Cette classe est utilisée pour démarrer la partie.
 * Dans son constructeur, elle crée un tableau type pour pouvoir créer les joueurs ensuite.
 * Dans lanceur, elle crée le module qui va faire se dérouler la partie
 *
 * @author Stevan Leber
 * @version 1.0.0
 */

public class Partie {

    /** Le module qu'on utilise pour gérer la partie */
	private Module module;

    /** La liste de joueurs qui participent à la partie */
	private ArrayList<Joueur> joueurs;

    /** Le jeu de pièces que l'on attribue à chaque joueur */
	private ArrayList<Piece> jeuModele;

    /**
     * Le constructeur de cette classe
     */

	public Partie() {
		jeuModele = initialiserPieces();
	}

    /**
     * Cette méthode est appelée au lancement de la partie (bouton start)
     * Elle va créer un module en fonction du nombre de joueurs
     *
     * @param joueurs Une ArrayList des joueurs
     */

	public void lancer(ArrayList<Joueur> joueurs) {
		this.joueurs = joueurs;
		int nbJoueurs = joueurs.size();
		module = new Module(20, nbJoueurs);
	}

    /**
     * Cette méthode crée un jeu neutre (pièces formées de 1 ou de 0)
     * Ce jeu est destiné à être utilisé par chaque joueur (chacun va le modifier).
     *
     * @return Le jeu neutre en question
     */

	public ArrayList<Piece> initialiserPieces() {
		int[][] forme = new int[5][5];
		forme[2][2] = 1;
 		Piece piece1 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[2][2] = 1;
 		Piece piece2 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[2][3] = 1;
 		Piece piece3 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[3][2] = 1;
 		Piece piece4 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[1][3] = 1;
		forme[2][3] = 1;
 		Piece piece5 = new Piece(forme);

 		forme = new int[5][5];
		forme[2][2] = 1;
		forme[1][2] = 1;
		forme[3][2] = 1;
		forme[2][1] = 1;
 		Piece piece6 = new Piece(forme);

 		forme = new int[5][5];
		forme[0][2] = 1;
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[3][2] = 1;
 		Piece piece7 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[3][2] = 1;
		forme[3][1] = 1;
 		Piece piece8 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[2][1] = 1;
		forme[3][1] = 1;
 		Piece piece9 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][1] = 1;
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[3][2] = 1;
		forme[4][2] = 1;
 		Piece piece10 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][3] = 1;
		forme[2][3] = 1;
		forme[3][3] = 1;
		forme[2][2] = 1;
		forme[2][1] = 1;
 		Piece piece11 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][1] = 1;
		forme[1][2] = 1;
		forme[1][3] = 1;
		forme[2][3] = 1;
		forme[3][3] = 1;
 		Piece piece12 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][3] = 1;
		forme[2][3] = 1;
		forme[2][2] = 1;
		forme[3][2] = 1;
		forme[4][2] = 1;
 		Piece piece13 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][3] = 1;
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[3][2] = 1;
		forme[3][1] = 1;
 		Piece piece14 = new Piece(forme);

 		forme = new int[5][5];
		forme[2][0] = 1;
		forme[2][1] = 1;
		forme[2][2] = 1;
		forme[2][3] = 1;
		forme[2][4] = 1;
 		Piece piece15 = new Piece(forme);

 		forme = new int[5][5];
		forme[2][1] = 1;
		forme[2][2] = 1;
		forme[2][3] = 1;
		forme[3][2] = 1;
		forme[3][3] = 1;
 		Piece piece16 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[1][3] = 1;
		forme[2][1] = 1;
		forme[2][2] = 1;
		forme[3][1] = 1;
 		Piece piece17 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][1] = 1;
		forme[1][2] = 1;
		forme[1][3] = 1;
		forme[2][1] = 1;
		forme[2][3] = 1;
 		Piece piece18 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[2][1] = 1;
		forme[2][2] = 1;
		forme[2][3] = 1;
		forme[3][1] = 1;
 		Piece piece19 = new Piece(forme);

 		forme = new int[5][5];
		forme[2][2] = 1;
		forme[1][2] = 1;
		forme[3][2] = 1;
		forme[2][1] = 1;
		forme[2][3] = 1;
 		Piece piece20 = new Piece(forme);

 		forme = new int[5][5];
		forme[1][2] = 1;
		forme[2][2] = 1;
		forme[3][2] = 1;
		forme[4][2] = 1;
		forme[2][1] = 1;
 		Piece piece21 = new Piece(forme);

 		ArrayList<Piece> ret = new ArrayList<Piece>();
 		ret.add(piece1);
 		ret.add(piece2);
 		ret.add(piece3);
 		ret.add(piece4);
 		ret.add(piece5);
 		ret.add(piece6);
 		ret.add(piece7);
 		ret.add(piece8);
 		ret.add(piece9);
 		ret.add(piece10);
 		ret.add(piece11);
 		ret.add(piece12);
 		ret.add(piece13);
 		ret.add(piece14);
 		ret.add(piece15);
 		ret.add(piece16);
 		ret.add(piece17);
 		ret.add(piece18);
 		ret.add(piece19);
 		ret.add(piece20);
 		ret.add(piece21);

 		return ret;
	}

	/**
	 * Cette méthode renvoie une liste de pièces, qui est la liste 
	 * de pièces que tous les joueurs auront avec une couleur différente
	 *
	 * @return La liste de pièces exemple
	 */

	public ArrayList<Piece> getJeuModele() {
		return jeuModele;
	}

	/**
	 * Cette méthode renvoie le module de la partie
	 *
	 * @return Le module de la partie
	 */

	public Module getModule() {
		return module;
	}

	/**
	 * Cette méthode renvoie la liste des joueurs
	 *
	 * @return La liste des joueurs
	 */
	
	public ArrayList<Joueur> getJoueurs() {
		return joueurs;
	}

	/**
	 * Cette méthode renvoie le nombre de joueurs
	 *
	 * @return Le nombre de joueurs dans la partie
	 */

	public int getNbJoueurs(){
		return joueurs.size();
	}
}