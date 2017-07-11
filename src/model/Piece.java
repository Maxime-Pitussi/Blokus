package model;

/**
 * Fichier : Piece.java
 * Date : 06/06/2016
 * Derniere mise a jour : 20/06/2016
 *
 * Cette classe permet de créer un objet Piece avec une forme
 * définie par un tableau d'entiers à double entrée.
 * Toutes les cases seront soit à 0 pour les espaces vides, soit
 * à n, n étant le numéro du joueur. Ce numéro définira la couleur
 * de chaque case.
 *
 * @author Stevan Leber
 * @version 1.0.0
 */

public class Piece {

    /** La forme de la pièce représentée par un tableau d'entiers de 0 ou de n (n étant la couleur de la pièce) */
	private int[][] forme;

    /**
     * Cette méthode est le constructeur de la classe. La classe Partie passera en 
     * paramètre un tableau avec des cases de 0 ou de 1.
     *
     * @param forme Le tableau a double entrée pré-rempli avec la forme de la piece
     */

	public Piece(int[][] forme) {

		this.forme = new int[5][5];

		for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                this.forme[i][j] = forme[i][j];
            }
        }
	}

	/**
	 * Surcharge du constructeur servant à dupliquer une pièce
	 *
	 * @param p La piece que l'on duplique
	 */

	public Piece(Piece p){
		this(p.forme);
	}

	/**
	 * La pièce est "colorée" grâce à cette méthode, qui multiplie toutes les cases
	 * par le numéro du joueur possédant la pièce. Ainsi, les 0 resteront des 0 et
	 * les 1 deviendront des entiers égaux au numéro du joueur.
	 *
	 * @param couleur La couleur qu'on lui affecte
	 */

	public void setCouleur(int couleur) {
        for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                forme[i][j] = couleur*forme[i][j];
            }
        }
	}

	/**
	 * Cette méthode change la valeur d'une case de la pièce
	 *
	 * @param x La position selon l'axe horizontal de la pièce
	 * @param y	La position selon l'axe vertical de la pièce
	 * @param valeur La valeur qu'on veut mettre dans la case (et donc la couleur)
	 */

	public void setCase(int x, int y, int valeur){
		forme[x][y] = valeur;
	}

	/**
	 * Cette méthode renvoie la forme de la pièce
	 *
	 * @return Le tableau à double entrée
	 */

	public int[][] getForme() {
		return forme;
	}

	/**
	* Cette méthode renvoie la case en (x,y) du tableau forme
	*
	* @param x  La colonne voulue
	* @param y  La ligne voulue
	*
	* @return La valeur de la case
	*/

	public int getCase(int x, int y){
		return forme[x][y];
	}

	/**
	* Cette méthode renvoie le nombre de cases pleines de la pièce
	*
	* @return ret Le "volume" de la pièce (nombre de cases pleines)
	*/

	public int getNbCarreaux(){
		int ret = 0;

		for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                if (forme[i][j]>0) {
                	ret++;
                }
            }
        }

        return ret;
	}
}