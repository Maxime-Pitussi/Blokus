package model;

import java.lang.IndexOutOfBoundsException;
import java.util.ArrayList;

/**
 * Fichier : Module.java
 * Date : 06/06/2016
 * Derniere mise a jour : 20/06/2016
 *
 * Cette classe va assurer le bon déroulement d'une partie :
 * Elle permet de sélectionner une pièce, de la tourner dans
 * tous les sens, d'essayer de la poser sur le plateau de jeu.
 * Elle s'occupe aussi des tours gérés par l'IA
 *
 * @author Stevan Leber
 * @version 1.0.0
 */

public class Module {

    /** La pièce qu'on tourne */
    private Piece active;

    /** La pièce active dans sa position d'origine (utilisée pour la correspondance avec la pièce du Joueur) */
    private Piece selection;

    /** Le plateau de jeu, ou grille de jeu */
    private int[][] grille;

    /** La taille du plateau */
    private final int TAILLE_GRILLE;

    /** La progression de la partie, chaque pièce posée augmente le tour de 1 */
    private int tour;

    /** Le nombre de joueurs */
    private int nbJoueurs;

    /** La place de la pièce dans le jeu d'un joueur */
    private int numPiece;

    /**
     * Cette méthode est le constructeur de la classe
     *
     * @param tailleGrille La taille de la grille de jeu
     * @param nbJoueurs Le nombre de joueurs dans la partie
     */

	public Module(int tailleGrille, int nbJoueurs) {
        tour = 1;
        this.nbJoueurs = nbJoueurs;
        TAILLE_GRILLE = tailleGrille;
        grille = new int[TAILLE_GRILLE][TAILLE_GRILLE];
        selectionner(new Piece(new int[5][5]));
	}

	/**
     * Cette méthode tourne la pièce active dans le sens inverse des aiguilles d'une montre.
     */

	public void pivotG() {
        int[][] temp = active.getForme();
        int[][] nouveau = new int[5][5];
        for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                nouveau[j][4-i] = temp[i][j];
            }
        }
        active = new Piece(nouveau);
	}

    /**
     * Cette méthode tourne la pièce active dans le sens des aiguilles d'une montre.
     */

	public void pivotD() {
        int[][] temp = active.getForme();
        int[][] nouveau = new int[5][5];
        for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                nouveau[4-j][i] = temp[i][j];
            }
        }
        active = new Piece(nouveau);
	}

    /**
     * Cette méthode retourne la pièce suivant l'axe horizontal.
     */

	public void rotaH() {
        int[][] temp = active.getForme();
        int[][] nouveau = new int[5][5];
        for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                nouveau[4-i][j] = temp[i][j];
            }
        }
        active = new Piece(nouveau);
	}

    /**
     * Cette méthode retourne la pièce suivant l'axe vertical.
     */

	public void rotaV() {
        int[][] temp = active.getForme();
        int[][] nouveau = new int[5][5];
        for (int i=0 ; i<5 ; i++) {
            for (int j=0 ; j<5 ; j++) {
                nouveau[i][4-j] = temp[i][j];
            }
        }
        active = new Piece(nouveau);
	}

    /**
     * Cette méthode valide la pose de la pièce active sur le plateau.
     * Si la pose est possible, elle renvoie vrai et ajoute la pièce à la grille.
     * Après avoir posé la pièce, on remplace la pièce active par une pièce vide.
     * Cette méthode est déclenchée par un clic sur la grille.
     *
     * @param x La colonne sélectionnée.
     * @param y La ligne sélectionnée.
     *
     * @return Vrai si la pose est validée, faux sinon.
     */

	public boolean valider(int x, int y) {
        int[][] temp = active.getForme();
		boolean test = verifier(temp, x, y);
		if(test){
			for (int i=0 ; i<5 ; i++) {
            	for (int j=0 ; j<5 ; j++) {
            		if(temp[i][j] > 0){
	            		grille[x+i-2][y+j-2] = temp[i][j];
	            	}
            	}
            }
      		selectionner(new Piece(new int[5][5]));
      		tour++;
		}
		return test;
	}

    /**
     * Reçoit la pièce sélectionnée par le joueur en paramètre.
     * Passe cette pièce en attribut "active" et "selection.
     * active est destinée à être tournée et selection doit rester la même.
     *
     * @param nouvelle La pièce sélectionnée qui va aller dans le module.
     */

	public void selectionner(Piece nouvelle) {
        
        int couleur = 0;
		
        if (tour%nbJoueurs == 0) {
            couleur = nbJoueurs;
        }
        else{
            couleur = (tour % nbJoueurs);
        }

		if(nouvelle.getCase(2,2) == couleur || nouvelle.getCase(1,1) == couleur) {
            
    		for (int i=0 ; i<5 ; i++) {
                for (int j=0 ; j<5 ; j++) {
                    this.active.setCase(i,j,nouvelle.getCase(i,j));
                    this.selection.setCase(i,j,nouvelle.getCase(i,j));
                }
            }
        }
        else {
            int [][] forme = new int[5][5];
            this.active = new Piece(forme);
            this.selection = new Piece(forme);
        }
	}

    /**
     * Cette méthode permet de vérifier si la pièce peut bien être posée
     * sur la grille à la position indiquée.
     *
     * @param test La forme de la pièce qu'on veut essayer de poser.
     * @param x La colonne dans laquelle on veut la poser.
     * @param y La ligne dans laquelle on veut la poser.
     *
     * @return Renvoie vrai si on peut placer la pièce.
     */

    public boolean verifier(int[][] test, int x, int y) {
        boolean ret  = true;												// Parcours de toutes les cases de la pièce
        boolean coin = false;												// Tests des positions numérotées comme suit:
        boolean vide = true;												// 1 | 2 | 3
        																	// 4 | 5 | 6		5 = la case vérifiée
        for (int i=0 ; i<5 ; i++) {											// 7 | 8 | 9
            for (int j=0 ; j<5 ; j++) {

                if (test[i][j] > 0) {										// Verif case
                    vide = false;

                    try{
	                    if (grille[x+i-2][y+j-2] > 0) {						// Verif 5
	                        ret = false;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece qui dépasse de la grille");
	                	ret = false;
	                }

	                try{
	                    if (grille[x+i-2][y+j-3] == test[i][j]) {			// Verif 2
	                        ret = false;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece en bordure HAUT");
	                }

	                try{                   
	                    if (grille[x+i-2][y+j-1] == test[i][j]) {			// Verif 8
	                        ret = false;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece en bordure BAS");
	                }

	                try {
	                    if (grille[x+i-3][y+j-2] == test[i][j]) {			// Verif 4
	                        ret = false;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece en bordure GAUCHE");
	                }

	                try {
	                    if (grille[x+i-1][y+j-2] == test[i][j]) {			// Verif 6
	                        ret = false;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece en bordure DROITE");
	                }													//------------

	                try {
	                    if (grille[x+i-3][y+j-3] == test[i][j]) {			// Verif 1
	                        coin = true;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece en bordure HAUT/GAUCHE");
	                }

	                try {
	                    if (grille[x+i-3][y+j-1] == test[i][j]) {			// Verif 3
	                        coin = true;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece en bordure HAUT/DROITE");
	                }

	                try {
	                    if (grille[x+i-1][y+j-3] == test[i][j]) {			// Verif 7
	                        coin = true;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece en bordure BAS/GAUCHE");
	                }

	                try {
	                    if (grille[x+i-1][y+j-1] == test[i][j]) {			// Verif 9
	                        coin = true;
	                    }
	                }catch(IndexOutOfBoundsException e){
	                	// System.out.println("Piece en bordure BAS/DROITE");
	                }

	                if ((x+i-2 == 0 || x+i-2 == TAILLE_GRILLE-1)
	                &&  (y+j-2 == 0 || y+j-2 == TAILLE_GRILLE-1)
	                &&  (tour <= nbJoueurs)						){			//Verif positions de départ
	                    coin = true;
	                }
                }
            }
        }
        if (!coin || vide) ret = false;
        return ret;
    }

    /**
     * Renvoie la pièce sélectionnée du module.
     * 
     * @return La pièce sélectionnée dans la classe.
     */
    
    public Piece getSelection(){
        return this.selection;
    }

    /**
     * Renvoie la pièce modifiée par le module.
     * 
     * @return La pièce active dans le module.
     */
    
    public Piece getActive(){
        return this.active;
    }

    /**
     * Cette méthode renvoie un entier correspondant
     * au joueur et à sa couleur.
     *
     * @return L'entier du joueur
     */

    public int getCouleur(){
        int couleur = 0;

        if (tour%nbJoueurs == 0) {
            couleur = nbJoueurs;
        }
        else{
            couleur = (tour % nbJoueurs);
        }
        return couleur;
    }

    /**
     * Renvoie la grille du module.
     * 
     * @return La grille de la partie.
     */

    public int[][] getGrille() {
        return this.grille;
    }

    /**
     * Renvoie une case de la grille du module.
     * 
     * @param x La colonne de la case choisie
     * @param y La ligne de la case choisie
     *
     * @return Le numéro dans la case.
     */

    public int getCaseGrille(int x, int y) {
    	return this.grille[x][y];
    }

    /**
     * Cette méthode renvoie un entier qui correspond
     * à la position de la pièce dans le jeu d'un joueur.
     * numPiece est utilisé par les méthodes tourDeBot et
     * verifTourPossible.
     *
     * @return La position dans le jeu du joueur de la pièce posée
     */
    public int getNumPiece(){
        return numPiece;
    }

    /**
     * Cette méthode procède à l'exécution d'un tour par l'ordinateur.
     * Renvoie vrai si le bot peut jouer, faux si il est bloqué.
     *
     * @param jeu La liste de pièces du joueur géré par l'ordinateur.
     *
     * @return Vrai si une pièce a été jouée, faux si ça a été impossible.
     */
/*
    public boolean tourDeBot(ArrayList<Piece> jeu){
    	boolean test = false;
		int i = jeu.size()-1;
		Piece p;

    	while (i >= 0 && test == false) {							// Parcours pièces du jeu du joueur qui doit jouer
    		p = jeu.get(i);
        	selectionner(p);

        	int j = 0;
            while (j<8 && test == false) {								// Tourne dans tous les sens
            	pivotD();

            	if (j == 4) {
            		rotaH();
            	}

            	int m = 0;
                while (m < 20 && test == false) {						// Test de chaque point de la grille
 
                	int n = 0;
			        while(n < 20 && test == false) {
				        test = valider(m, n);
                        if (test) {
                          numPiece = i;
                        }
                        n++;
			        }
                  m++;
                }
                j++;
            }
            i--;
        }

        return test;
    }
*/
    public boolean tourDeBot(ArrayList<Piece> jeu){
        boolean test = false;
        Piece p;

        ArrayList<Piece> piece5C = new ArrayList<Piece>();
        ArrayList<Piece> piece4C = new ArrayList<Piece>();
        ArrayList<Piece> piece123C = new ArrayList<Piece>();

        for (Piece q : jeu){
            if (q.getNbCarreaux()==5) {
                piece5C.add(q);
            }
            else if (q.getNbCarreaux()==4) {
                piece4C.add(q);
            }
            else if (q.getNbCarreaux()<4) {
                piece123C.add(q);
            }
        }

        while (test == false && piece5C.size() != 0) {                           // Parcours pièces du jeu du joueur qui doit jouer
            int alea = (int)(Math.floor(Math.random()*(piece5C.size()-1)));
            p = piece5C.get(alea);
            selectionner(p);

            int j = 0;
            while (j<8 && test == false) {                              // Tourne dans tous les sens
                pivotD();

                if (j == 4) {
                    rotaH();
                }
                int constante = 1;
                int m = 10;
                while (m < 20 && m > -1 && test == false) {                       // Test de chaque point de la grille
                    int constante2 = 1;
                    int n = 10;
                    while(n < 20 && n > -1 && test == false) {
                        test = valider(m, n);
                        if (test) {
                          numPiece = jeu.indexOf(p);
                        }
                        if (constante2  == 1 || constante2 == 3 || constante2  == 5 || constante2 == 7 || constante2  == 9 || constante2 == 11 || constante2  == 13 || constante2 == 15 || constante2  == 17 || constante2 == 19 || constante2 == 21) {
                            n = n + constante2;
                        }
                        if (constante2  == 2 || constante2 == 4 || constante2  == 6 || constante2 == 8 || constante2  == 10 || constante2 == 12 || constante2  == 14 || constante2 == 16 || constante2  == 18 || constante2 == 20) {
                            n = n - constante2;
                        }
                        constante2++;
                    }
                    if (constante  == 1 || constante == 3 || constante  == 5 || constante == 7 || constante  == 9 || constante == 11 || constante  == 13 || constante == 15 || constante  == 17 || constante == 19 || constante == 21) {
                        m = m + constante;
                    }
                    if (constante  == 2 || constante == 4 || constante  == 6 || constante == 8 || constante  == 10 || constante == 12 || constante  == 14 || constante == 16 || constante  == 18 || constante == 20) {
                        m = m - constante;
                    }
                    constante++;
                }
                j++;
            }
            piece5C.remove(alea);
        }

        while (test == false && piece4C.size() != 0) {                           // Parcours pièces du jeu du joueur qui doit jouer
            int alea = (int)(Math.floor(Math.random()*(piece4C.size()-1)));
            p = piece4C.get(alea);
            selectionner(p);

            int j = 0;
            while (j<8 && test == false) {                              // Tourne dans tous les sens
                pivotD();

                if (j == 4) {
                    rotaH();
                }
                int constante = 1;
                int m = 10;
                while (m < 20 && m > -1 && test == false) {                       // Test de chaque point de la grille
                    int constante2 = 1;
                    int n = 10;
                    while(n < 20 && n > -1 && test == false) {
                        test = valider(m, n);
                        if (test) {
                          numPiece = jeu.indexOf(p);
                        }
                        if (constante2  == 1 || constante2 == 3 || constante2  == 5 || constante2 == 7 || constante2  == 9 || constante2 == 11 || constante2  == 13 || constante2 == 15 || constante2  == 17 || constante2 == 19 || constante2 == 21) {
                            n = n + constante2;
                        }
                        if (constante2  == 2 || constante2 == 4 || constante2  == 6 || constante2 == 8 || constante2  == 10 || constante2 == 12 || constante2  == 14 || constante2 == 16 || constante2  == 18 || constante2 == 20) {
                            n = n - constante2;
                        }
                        constante2++;
                    }
                    if (constante  == 1 || constante == 3 || constante  == 5 || constante == 7 || constante  == 9 || constante == 11 || constante  == 13 || constante == 15 || constante  == 17 || constante == 19 || constante == 21) {
                        m = m + constante;
                    }
                    if (constante  == 2 || constante == 4 || constante  == 6 || constante == 8 || constante  == 10 || constante == 12 || constante  == 14 || constante == 16 || constante  == 18 || constante == 20) {
                        m = m - constante;
                    }
                    constante++;
                }
                j++;
            }
            piece4C.remove(alea);
        }

        while (test == false && piece123C.size() != 0) {                           // Parcours pièces du jeu du joueur qui doit jouer
            int alea = (int)(Math.floor(Math.random()*(piece123C.size()-1)));
            p = piece123C.get(alea);
            selectionner(p);

            int j = 0;
           while (j<8 && test == false) {                              // Tourne dans tous les sens
                pivotD();

                if (j == 4) {
                    rotaH();
                }
                int constante = 1;
                int m = 10;
                while (m < 20 && m > -1 && test == false) {                       // Test de chaque point de la grille
                    int constante2 = 1;
                    int n = 10;
                    while(n < 20 && n > -1 && test == false) {
                        test = valider(m, n);
                        if (test) {
                          numPiece = jeu.indexOf(p);
                        }
                        if (constante2  == 1 || constante2 == 3 || constante2  == 5 || constante2 == 7 || constante2  == 9 || constante2 == 11 || constante2  == 13 || constante2 == 15 || constante2  == 17 || constante2 == 19 || constante2 == 21) {
                            n = n + constante2;
                        }
                        if (constante2  == 2 || constante2 == 4 || constante2  == 6 || constante2 == 8 || constante2  == 10 || constante2 == 12 || constante2  == 14 || constante2 == 16 || constante2  == 18 || constante2 == 20) {
                            n = n - constante2;
                        }
                        constante2++;
                    }
                    if (constante  == 1 || constante == 3 || constante  == 5 || constante == 7 || constante  == 9 || constante == 11 || constante  == 13 || constante == 15 || constante  == 17 || constante == 19 || constante == 21) {
                        m = m + constante;
                    }
                    if (constante  == 2 || constante == 4 || constante  == 6 || constante == 8 || constante  == 10 || constante == 12 || constante  == 14 || constante == 16 || constante  == 18 || constante == 20) {
                        m = m - constante;
                    }
                    constante++;
                }
                j++;
            }
            piece123C.remove(alea);
        }

        return test;
    }

    /**
     * Cette méthode permet de vérifier si le joueur peut encore jouer
     *
     * @param jeu La liste de pièces qu'il reste au joueur
     *
     * @return Vrai si le joueur peut continuer de jouer, faux sinon
     */
    public boolean verifTourPossible(ArrayList<Piece> jeu){
        boolean test = false;
        int i = 0;
        Piece p;

        while (i < jeu.size() && test == false) {                           // Parcours pièces du jeu du joueur qui doit jouer
            p = jeu.get(i);
            selectionner(p);

            int j = 0;
            while (j<8 && test == false) {                              // Tourne dans tous les sens
                pivotD();

                if (j == 4) {
                    rotaH();
                }

                int m = 0;
                while (m < 20 && test == false) {                       // Test de chaque point de la grille
 
                    int n = 0;
                    while(n < 20 && test == false) {
                        test = verifier(getActive().getForme(),m, n);
                        if (test) {
                           numPiece = i; 
                        }
                        n++;
                    }
                    m++;
                }
                j++;
            }
            i++;
        }

        return test;
    }

    /**
     * Cette méthode sert à faire évoluer la partie d'un tour
     */

    public void incTour(){
        this.tour++;
    }

    /**
     * Cette méthode sert à faire revenir la partie en arrière d'un tour
     */

    public void decTour(){
        this.tour--;
    }
}