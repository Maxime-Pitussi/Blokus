package model;

import java.util.ArrayList;

/**
 * Fichier : Joueur.java
 * Date : 06/06/2016
 * Derniere mise a jour : 20/06/2016
 *
 * Cette classe crée un joueur avec un numéro, un score, une équipe et un tableau de pièces.
 * Elle permet de gérer les pièces que l'on joue (sélection pour le module et suppression)
 * et le score du joueur. Il est indiqué si un joueur doit être géré par l'IA.
 *
 * @author Stevan Leber
 * @version 1.0.0
 */

public class Joueur {

	/** L'equipe du joueur */
	private int equipe;

	/** Le numéro du joueur */
	private int num;

	/** Le score du joueur */
	private int score;

	/** Le jeu du joueur (perdant ses pièces au fur et à mesure) */
	private ArrayList<Piece> jeuActif = new ArrayList();

	/** Le jeu de départ du joueur */
	private ArrayList<Piece> jeuPassif = new ArrayList();

	/** Vrai si le joueur est géré par l'IA */
	private boolean bot;

	/** La pièce actuellement sélectionnée et placée dans le module */
	private Piece selection;

	/**
	 * Le constructeur de la classe, fait démarrer avec un score de 0.
	 * @param equipe    L'équipe du joueur
	 * @param num		Le numéro du joueur
	 * @param jeu		Le jeu de départ du joueur
	 * @param bot		Vrai si le joueur est géré par l'IA
	 */

	public Joueur(int equipe, int num, ArrayList<Piece> jeu, boolean bot) {
		this.equipe = equipe;
		this.score = 0;

		for (Piece p : jeu){
			this.jeuActif.add(new Piece(p));
		}

		for (Piece q : jeu){
			this.jeuPassif.add(new Piece(q));
		}

		this.num = num;
		this.bot = bot;
	}

	/**
	* Retourne l'équipe du joueur
	*
	* @return Le numéro de son équipe
	*/

	public int getEquipe(){
		return equipe;
	}

	/**
	* Retourne le numéro du joueur
	*
	* @return Le numéro du joueur
	*/

	public int getNum(){
		return num;
	}

	/**
	* Retourne le score actuel du joueur
	*
	* @return Le score actuel du joueur
	*/

	public int getScore(){
		return score;
	}

	/**
	* Retourne le tableau de pièces du joueur
	*
	* @return Le tableau de pièces du joueur
	*/

	public ArrayList<Piece> getTableauActif(){
		return jeuActif;	
	}

	/**
	* Retourne le tableau de pièces du joueur
	*
	* @return Le tableau de pièces du joueur
	*/

	public ArrayList<Piece> getTableauPassif(){
		return jeuPassif;	
	}

	/**
	* Retourne vrai si le joueur est un bot
	*
	* @return Vrai si le joueur est un bot, faux sinon
	*/

	public boolean getBot(){
		return bot;
	}

    /**
     * Cette methode change le score d'un joueur en fonction de la pièce posée.
     * Elle met à jour le score affiché
     *
     * @param pose  La pièce posée qui va rapporter des points selon sa taille
     */
     
	public void incScore(Piece pose) {
		score = score + pose.getNbCarreaux();
	}

	/**
	 * Cette méthode permet de modifier la couleur de toutes les pièces du joueur
	 *
	 * @param couleur  Le chiffre de la couleur attribuée
	 */

	public void setCouleur(int couleur) {
		for(Piece q : jeuActif) {
			q.setCouleur(couleur);
		}
		for(Piece p : jeuPassif) {
			p.setCouleur(couleur);
		}
	}

	/**
	 * Cette méthode renvoie une pièce correspondant à l'index en paramètre.
	 *
	 * @param index  Le numéro d'index
	 *
	 * @return La pièce du jeu correspondant au numéro d'index
	 */

	public Piece getPieceJeuActif(int index){
		Piece ret = jeuActif.get(index);
		return ret;
	}

	/**
	 * Cette méthode renvoie une pièce correspondant à l'index en paramètre.
	 *
	 * @param index  Le numéro d'index
	 *
	 * @return La pièce du jeu correspondant au numéro d'index
	 */
	
	public Piece getPieceJeuPassif(int index){
		Piece ret = jeuPassif.get(index);
		return ret;
	}


 	/**
     * Cette méthode sert à retirer la pièce sélectionnée du jeu
     *
     * @param piece  La piece que l'on veut retirer du tableau actif
     */

	public void retirerPieceJeuActif(int piece) {
		jeuActif.remove(piece);
	}
}