package control;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import view.BlokusFrame;
import view.pageMode4J.PageMode4J;
import view.pageMode8J.PageMode8J;
import model.*;
import javax.sound.sampled.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Fichier : BlokusListener.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui fait le lien entre la partie visuelle et la partie model du jeu. Cette classe recupere les interractions
 * de l'utilisateur avec la partie visuelle pour lancer les bonnes operations dans le model et retourner
 * ces dernieres dans la partie visuelle.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class BlokusListener extends MouseAdapter implements ActionListener, KeyListener, ChangeListener{

//................................................................................................... I : EN TETE

	/** La fenetre courante utilisee */

	private BlokusFrame frame;

	/** Joueur 1 */

	private Joueur j1;

	/** Joueur 2 */

	private Joueur j2;

	/** Joueur 3 */

	private Joueur j3;

	/** Joueur 4 */

	private Joueur j4;

	/** Joueur 5 */

	private Joueur j5;

	/** Joueur 6 */

	private Joueur j6;

	/** Joueur 7 */

	private Joueur j7;

	/** Joueur 8 */

	private Joueur j8;

	/** Arraylist contenant les joueurs prenant part a la partie */

	private ArrayList<Joueur> joueurs = new ArrayList<Joueur>();

	/** La partie courante */

	private Partie partie;

	/** Boolean indiquant si la musique est active */

	private boolean musiqueActive = true;

	/** Objet gérant la musique */

	private Audio son;

	/** Entier indiquant le numéro de la pièce courante dans le jeu actif */

	private int piece;

	/** Entier indiquant le numéro de la pièce courante dans le jeu passif */

	private int pieceaRetirer;

	/** Entier indiquant le numéro du joueur courant */

	private int joueur;

	/** Chaine indiquant l'orientation de la piece dans le module */

	private String orientation = "N";

	/** Chaine indiquant si la piece est en miroir ou non */

	private String miroir = "B";

	/** Chaine contenant le chemin de la piece affichee dans le module */

	private String pieceSelectionee = "";

	/** Grille de 20 par 20. Version précédente de la grille courante */

	private int [][] ancienneGrille = new int[20][20];

	/** Label contenant l'image a placer */

	private JLabel imageAPlacer;

	/** Tableau de 5 par 5 contenant la forme d'une piece pour une courte duree */

	private int[][] formeTampon = new int[5][5];

	/** booleen indiquant si le joueur 1 peut jouer */

	private boolean j1PeuxJouer = true;

	/** booleen indiquant si le joueur 2 peut jouer */

	private boolean j2PeuxJouer = true;

	/** booleen indiquant si le joueur 3 peut jouer */

	private boolean j3PeuxJouer = true;

	/** booleen indiquant si le joueur 4 peut jouer */

	private boolean j4PeuxJouer = true;

//................................................................................................... II : CONSTRUCTEUR

	/**
  	 * Recupere la fenetre courante et la passe a l'attribut
  	 *
  	 * @param frame  la fenetre courante
  	 * @param audio  L'objet gérant la musique
  	 */
	
	public BlokusListener(BlokusFrame frame, Audio audio){
		this.frame = frame;
		this.son = audio;
	}

//................................................................................................... III : METHODES

//................................................................................. 1 : actionPerformed

	/**
  	 * Permet de gerer les evenements qui arrivent suite aux interractions de l'utilisateur avec des boutons
  	 *
  	 * @param ae  l'évenement à gérer
  	 */
	
	public void actionPerformed(ActionEvent ae){

//........................................................................ Poser une piece

		for(int i=0; i < 20; i++) {
	      	for(int j=0; j < 20; j++) {
	      		if (ae.getActionCommand().equals("bouton ["+i+"]["+j+"]")) {
	      			if (partie.getModule().getCouleur() == 1 && !j1.getBot()) {
	      				if (partie.getModule().valider(i,j)) {

		      				frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
		      				frame.getPageJeu4J().modifierImageModule(null);

		      				for(int k=0; k < 20; k++) {
		      					for(int l=0; l < 20; l++) {
		      						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
		      					}
		      				}

		      				j1.retirerPieceJeuActif(piece);
		      				frame.getPageJeu4J().pieceUtilisee(joueur, pieceaRetirer);
	      					j1.incScore(j1.getTableauPassif().get(pieceaRetirer));
	      					frame.getPageJeu4J().setScoreJ1(""+j1.getScore());

	      					if (j1.getEquipe()==1) {
	      						frame.getPageJeu4J().incScoreE1(j1.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j1.getEquipe()==2) {
	      						frame.getPageJeu4J().incScoreE2(j1.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j1.getEquipe()==3) {
	      						frame.getPageJeu4J().incScoreE3(j1.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j1.getEquipe()==4) {
	      						frame.getPageJeu4J().incScoreE4(j1.getTableauPassif().get(piece).getNbCarreaux());
	      					}

	      					partie.getModule().decTour();

	      					if (!partie.getModule().verifTourPossible(j1.getTableauActif())) {
	      						frame.getPageJeu4J().fin(0);
	      						j1PeuxJouer = false;
	      					}

	      					partie.getModule().incTour();

	      					if (!partie.getModule().verifTourPossible(j2.getTableauActif())) {
	      						frame.getPageJeu4J().fin(1);
	      						j2PeuxJouer = false;
	      					}

	      					partie.getModule().incTour();

	      					if (!partie.getModule().verifTourPossible(j3.getTableauActif())) {
	      						frame.getPageJeu4J().fin(2);
	      						j3PeuxJouer = false;
	      					}

	      					partie.getModule().incTour();

	      					if (!partie.getModule().verifTourPossible(j4.getTableauActif())) {
	      						frame.getPageJeu4J().fin(3);
	      						j4PeuxJouer = false;
	      					}

	      					partie.getModule().decTour();
	      					partie.getModule().decTour();

      						if (!j2PeuxJouer) {
	      						partie.getModule().incTour();
	      						if (!j3PeuxJouer) {
	      							partie.getModule().incTour();
	      							if (!j4PeuxJouer) {
	      								partie.getModule().incTour();
	      							}
	      						}
	      					}
	      				}
	      			}
	      			else if (partie.getModule().getCouleur() == 2 && !j2.getBot()) {
	      				if (partie.getModule().valider(i,j)) {
		      				frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
		      				frame.getPageJeu4J().modifierImageModule(null);

		      				for(int k=0; k < 20; k++) {
		      					for(int l=0; l < 20; l++) {
		      						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
		      					}
		      				}

		      				j2.retirerPieceJeuActif(piece);
		      				frame.getPageJeu4J().pieceUtilisee(joueur, pieceaRetirer);
	      					j2.incScore(j2.getTableauPassif().get(pieceaRetirer));
	      					frame.getPageJeu4J().setScoreJ2(""+j2.getScore());

	      					if (j2.getEquipe()==1) {
	      						frame.getPageJeu4J().incScoreE1(j2.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j2.getEquipe()==2) {
	      						frame.getPageJeu4J().incScoreE2(j2.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j2.getEquipe()==3) {
	      						frame.getPageJeu4J().incScoreE3(j2.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j2.getEquipe()==4) {
	      						frame.getPageJeu4J().incScoreE4(j2.getTableauPassif().get(piece).getNbCarreaux());
	      					}

	      					partie.getModule().decTour();

	      					if (!partie.getModule().verifTourPossible(j2.getTableauActif())) {
	      						frame.getPageJeu4J().fin(1);
	      						j2PeuxJouer = false;
	      					}

	      					partie.getModule().incTour();

	      					if (!partie.getModule().verifTourPossible(j3.getTableauActif())) {
	      						frame.getPageJeu4J().fin(2);
	      						j3PeuxJouer = false;
	      					}

	      					partie.getModule().incTour();

	      					if (!partie.getModule().verifTourPossible(j4.getTableauActif())) {
	      						frame.getPageJeu4J().fin(3);
	      						j4PeuxJouer = false;
	      					}

	      					partie.getModule().incTour();

	      					if (!partie.getModule().verifTourPossible(j1.getTableauActif())) {
	      						frame.getPageJeu4J().fin(0);
	      						j1PeuxJouer = false;
	      					}

	      					partie.getModule().decTour();
	      					partie.getModule().decTour();

	      					if (!j3PeuxJouer) {
	      						partie.getModule().incTour();
	      						if (!j4PeuxJouer) {
	      							partie.getModule().incTour();
	      							if (!j1PeuxJouer) {
	      								partie.getModule().incTour();
	      							}
	      						}
	      					}
	      				}
	      			}
	      			else if (partie.getModule().getCouleur() == 3 && !j3.getBot()) {
	      				if (partie.getModule().valider(i,j)) {
		      				frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
		      				frame.getPageJeu4J().modifierImageModule(null);

		      				for(int k=0; k < 20; k++) {
		      					for(int l=0; l < 20; l++) {
		      						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
		      					}
		      				}

		      				j3.retirerPieceJeuActif(piece);
		      				frame.getPageJeu4J().pieceUtilisee(joueur, pieceaRetirer);
	      					j3.incScore(j3.getTableauPassif().get(pieceaRetirer));
	      					frame.getPageJeu4J().setScoreJ3(""+j3.getScore());

	      					if (j3.getEquipe()==1) {
	      						frame.getPageJeu4J().incScoreE1(j3.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j3.getEquipe()==2) {
	      						frame.getPageJeu4J().incScoreE2(j3.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j3.getEquipe()==3) {
	      						frame.getPageJeu4J().incScoreE3(j3.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j3.getEquipe()==4) {
	      						frame.getPageJeu4J().incScoreE4(j3.getTableauPassif().get(piece).getNbCarreaux());
	      					}

	      					partie.getModule().decTour();
	      					
							if (!partie.getModule().verifTourPossible(j3.getTableauActif())) {
								frame.getPageJeu4J().fin(2);
								j3PeuxJouer = false;
							}

							partie.getModule().incTour();

							if (!partie.getModule().verifTourPossible(j4.getTableauActif())) {
								frame.getPageJeu4J().fin(3);
								j4PeuxJouer = false;
							}

							partie.getModule().incTour();

							if (!partie.getModule().verifTourPossible(j1.getTableauActif())) {
								frame.getPageJeu4J().fin(0);
								j1PeuxJouer = false;
							}

							partie.getModule().incTour();

							if (!partie.getModule().verifTourPossible(j2.getTableauActif())) {
								frame.getPageJeu4J().fin(1);
								j2PeuxJouer = false;
							}

	      					partie.getModule().decTour();
	      					partie.getModule().decTour();

	      					if (!j4PeuxJouer) {
	      						partie.getModule().incTour();
	      						if (!j1PeuxJouer) {
	      							partie.getModule().incTour();
	      							if (!j2PeuxJouer) {
	      								partie.getModule().incTour();
	      							}
	      						}
	      					}
	      				}
	      			}
	      			else if (partie.getModule().getCouleur() == 4 && !j4.getBot()) {
	      				if (partie.getModule().valider(i,j)) {
		      				frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
		      				frame.getPageJeu4J().modifierImageModule(null);

		      				for(int k=0; k < 20; k++) {
		      					for(int l=0; l < 20; l++) {
		      						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
		      					}
		      				}

		      				j4.retirerPieceJeuActif(piece);

		      				frame.getPageJeu4J().pieceUtilisee(joueur, pieceaRetirer);
	      					j4.incScore(j4.getTableauPassif().get(pieceaRetirer));
	      					frame.getPageJeu4J().setScoreJ4(""+j4.getScore());

	      					if (j4.getEquipe()==1) {
	      						frame.getPageJeu4J().incScoreE1(j4.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j4.getEquipe()==2) {
	      						frame.getPageJeu4J().incScoreE2(j4.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j4.getEquipe()==3) {
	      						frame.getPageJeu4J().incScoreE3(j4.getTableauPassif().get(piece).getNbCarreaux());
	      					}
	      					else if (j4.getEquipe()==4) {
	      						frame.getPageJeu4J().incScoreE4(j4.getTableauPassif().get(piece).getNbCarreaux());
	      					}

	      					partie.getModule().decTour();

	      					if (!partie.getModule().verifTourPossible(j4.getTableauActif())) {
								frame.getPageJeu4J().fin(3);
								j4PeuxJouer = false;
							}

							partie.getModule().incTour();

							if (!partie.getModule().verifTourPossible(j1.getTableauActif())) {
								frame.getPageJeu4J().fin(0);
								j1PeuxJouer = false;
							}

							partie.getModule().incTour();

							if (!partie.getModule().verifTourPossible(j2.getTableauActif())) {
								frame.getPageJeu4J().fin(1);
								j2PeuxJouer = false;
							}

							partie.getModule().incTour();

							if (!partie.getModule().verifTourPossible(j3.getTableauActif())) {
								frame.getPageJeu4J().fin(2);
								j3PeuxJouer = false;
							}

	      					partie.getModule().decTour();
	      					partie.getModule().decTour();

	      					if (!j1PeuxJouer) {
	      						partie.getModule().incTour();
	      						if (!j2PeuxJouer) {
	      							partie.getModule().incTour();
	      							if (!j3PeuxJouer) {
	      								partie.getModule().incTour();
	      							}
	      						}
	      					}
	      				}
	      			}

	      			frame.getPageJeu4J().setImg("../data/images/backgrounds/Background"+partie.getModule().getCouleur()+".png");
				}
			}
		}

//........................................................................ Selectionner une piece

		for(int i=0; i < 4; i++) {
	      	for(int j=0; j < 21; j++) {

				if (ae.getActionCommand().equals("selectionner piece "+j+" joueur "+i)) {
					if (i == 0) {
						partie.getModule().selectionner(j1.getTableauPassif().get(j));
						boolean trouve = false;
						int a = 0;
						while(!trouve){
							trouve = true;
							for(int e=0; e < 5; e++) {
		      					for(int f=0; f < 5; f++) {
									if (j1.getTableauActif().get(a).getCase(e,f) != j1.getTableauPassif().get(j).getCase(e,f)) {
										trouve = false;
									}
								}
							}
							if (!trouve) {
								a++;
							}
						}
						piece = a;
						frame.getPageJeu4J().modifierImageModule("../data/images/pieces/joueur"+(i+1)+"/piece"+j+"/joueur"+(i+1)+"piece"+j+"NB.png");
						pieceSelectionee = "../data/images/pieces/joueur"+(i+1)+"/piece"+j+"/joueur"+(i+1)+"piece"+j;
					}
					else if (i == 1) {
						partie.getModule().selectionner(j2.getTableauPassif().get(j));
						boolean trouve = false;
						int a = 0;
						while(!trouve){
							trouve = true;
							for(int e=0; e < 5; e++) {
		      					for(int f=0; f < 5; f++) {
									if (j2.getTableauActif().get(a).getCase(e,f) != j2.getTableauPassif().get(j).getCase(e,f)) {
										trouve = false;
									}
								}
							}
							if (!trouve) {
								a++;
							}
						}
						piece = a;
						frame.getPageJeu4J().modifierImageModule("../data/images/pieces/joueur"+(i+1)+"/piece"+j+"/joueur"+(i+1)+"piece"+j+"NB.png");
						pieceSelectionee = "../data/images/pieces/joueur"+(i+1)+"/piece"+j+"/joueur"+(i+1)+"piece"+j;
					}
					else if (i == 2) {
						partie.getModule().selectionner(j3.getTableauPassif().get(j));
						boolean trouve = false;
						int a = 0;
						while(!trouve){
							trouve = true;
							for(int e=0; e < 5; e++) {
		      					for(int f=0; f < 5; f++) {
									if (j3.getTableauActif().get(a).getCase(e,f) != j3.getTableauPassif().get(j).getCase(e,f)) {
										trouve = false;
									}
								}
							}
							if (!trouve) {
								a++;
							}
						}
						piece = a;
						frame.getPageJeu4J().modifierImageModule("../data/images/pieces/joueur"+(i+1)+"/piece"+j+"/joueur"+(i+1)+"piece"+j+"NB.png");
						pieceSelectionee = "../data/images/pieces/joueur"+(i+1)+"/piece"+j+"/joueur"+(i+1)+"piece"+j;
					}
					else if (i == 3) {
						partie.getModule().selectionner(j4.getTableauPassif().get(j));
						boolean trouve = false;
						int a = 0;
						while(!trouve){
							trouve = true;
							for(int e=0; e < 5; e++) {
		      					for(int f=0; f < 5; f++) {
									if (j4.getTableauActif().get(a).getCase(e,f) != j4.getTableauPassif().get(j).getCase(e,f)) {
										trouve = false;
									}
								}
							}
							if (!trouve) {
								a++;
							}
						}
						piece = a;
						frame.getPageJeu4J().modifierImageModule("../data/images/pieces/joueur"+(i+1)+"/piece"+j+"/joueur"+(i+1)+"piece"+j+"NB.png");
						pieceSelectionee = "../data/images/pieces/joueur"+(i+1)+"/piece"+j+"/joueur"+(i+1)+"piece"+j;
					}
					pieceaRetirer = j;
					joueur = i;
					orientation = "N";
					miroir = "B";
				}

			}
		}

//........................................................................ Tour D'IA

		if (ae.getActionCommand().equals("tourDeBot")) {
			if (partie.getModule().getCouleur() == 1) {
				System.out.println("tour j1");
				if (j1.getBot()) {
					if (partie.getModule().tourDeBot(j1.getTableauActif())) {
						boolean trouve = false;
						int a = 0;
						while(!trouve){
							trouve = true;
							for(int e=0; e < 5; e++) {
		      					for(int f=0; f < 5; f++) {
									if (j1.getTableauActif().get(partie.getModule().getNumPiece()).getCase(e,f) != j1.getTableauPassif().get(a).getCase(e,f)) {
										trouve = false;
									}
								}
							}
							if (!trouve) {
								a++;
							}
						}

						frame.getPageJeu4J().pieceUtilisee(0, a);
						j1.retirerPieceJeuActif(partie.getModule().getNumPiece());
						j1.incScore(j1.getTableauPassif().get(partie.getModule().getNumPiece()));
	      				frame.getPageJeu4J().setScoreJ1(""+j1.getScore());

	      				if (j1.getEquipe()==1) {
      						frame.getPageJeu4J().incScoreE1(j1.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j1.getEquipe()==2) {
      						frame.getPageJeu4J().incScoreE2(j1.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j1.getEquipe()==3) {
      						frame.getPageJeu4J().incScoreE3(j1.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j1.getEquipe()==4) {
      						frame.getPageJeu4J().incScoreE4(j1.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
					}
					else{
						frame.getPageJeu4J().fin(0);
	      				partie.getModule().incTour();
					}
					frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);

					for(int k=0; k < 20; k++) {
      					for(int l=0; l < 20; l++) {
      						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
      					}
      				}
				}
			}
			if (partie.getModule().getCouleur() == 2) {
				System.out.println("tour j2");
				if (j2.getBot()) {
					if (partie.getModule().tourDeBot(j2.getTableauActif())) {
						boolean trouve = false;
						int a = 0;
						while(!trouve){
							trouve = true;
							for(int e=0; e < 5; e++) {
		      					for(int f=0; f < 5; f++) {
									if (j2.getTableauActif().get(partie.getModule().getNumPiece()).getCase(e,f) != j2.getTableauPassif().get(a).getCase(e,f)) {
										trouve = false;
									}
								}
							}
							if (!trouve) {
								a++;
							}
						}

						frame.getPageJeu4J().pieceUtilisee(1, a);
					    j2.retirerPieceJeuActif(partie.getModule().getNumPiece());
						j2.incScore(j2.getTableauPassif().get(partie.getModule().getNumPiece()));
	      				frame.getPageJeu4J().setScoreJ2(""+j2.getScore());

	      				if (j2.getEquipe()==1) {
      						frame.getPageJeu4J().incScoreE1(j2.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j2.getEquipe()==2) {
      						frame.getPageJeu4J().incScoreE2(j2.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j2.getEquipe()==3) {
      						frame.getPageJeu4J().incScoreE3(j2.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j2.getEquipe()==4) {
      						frame.getPageJeu4J().incScoreE4(j2.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
					}
					else{
						frame.getPageJeu4J().fin(1);
	      				partie.getModule().incTour();
					}
					frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
					for(int k=0; k < 20; k++) {
      					for(int l=0; l < 20; l++) {
      						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
      					}
      				}
				}
			}
			if (partie.getModule().getCouleur() == 3) {
				System.out.println("tour j3");
				if (j3.getBot()) {
					if (partie.getModule().tourDeBot(j3.getTableauActif())) {
						boolean trouve = false;
						int a = 0;
						while(!trouve){
							trouve = true;
							for(int e=0; e < 5; e++) {
		      					for(int f=0; f < 5; f++) {
									if (j3.getTableauActif().get(partie.getModule().getNumPiece()).getCase(e,f) != j3.getTableauPassif().get(a).getCase(e,f)) {
										trouve = false;
									}
								}
							}
							if (!trouve) {
								a++;
							}
						}

						frame.getPageJeu4J().pieceUtilisee(2, a);
						j3.retirerPieceJeuActif(partie.getModule().getNumPiece());
						j3.incScore(j3.getTableauPassif().get(partie.getModule().getNumPiece()));
	      				frame.getPageJeu4J().setScoreJ3(""+j3.getScore());

	      				if (j3.getEquipe()==1) {
      						frame.getPageJeu4J().incScoreE1(j3.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j3.getEquipe()==2) {
      						frame.getPageJeu4J().incScoreE2(j3.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j3.getEquipe()==3) {
      						frame.getPageJeu4J().incScoreE3(j3.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j3.getEquipe()==4) {
      						frame.getPageJeu4J().incScoreE4(j3.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
					}
					else{
						frame.getPageJeu4J().fin(2);
	      				partie.getModule().incTour();
					}
					frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
					for(int k=0; k < 20; k++) {
      					for(int l=0; l < 20; l++) {
      						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
      					}
      				}
				}
			}

			if (partie.getModule().getCouleur() == 4) {
				System.out.println("tour j4");
				if (j4.getBot()) {
					if (partie.getModule().tourDeBot(j4.getTableauActif())) {
						boolean trouve = false;
						int a = 0;
						while(!trouve){
							trouve = true;
							for(int e=0; e < 5; e++) {
		      					for(int f=0; f < 5; f++) {
									if (j4.getTableauActif().get(partie.getModule().getNumPiece()).getCase(e,f) != j4.getTableauPassif().get(a).getCase(e,f)) {
										trouve = false;
									}
								}
							}
							if (!trouve) {
								a++;
							}
						}

						frame.getPageJeu4J().pieceUtilisee(3, a);
						j4.retirerPieceJeuActif(partie.getModule().getNumPiece());
						j4.incScore(j4.getTableauPassif().get(partie.getModule().getNumPiece()));
	      				frame.getPageJeu4J().setScoreJ4(""+j4.getScore());

	      				if (j4.getEquipe()==1) {
      						frame.getPageJeu4J().incScoreE1(j4.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j4.getEquipe()==2) {
      						frame.getPageJeu4J().incScoreE2(j4.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j4.getEquipe()==3) {
      						frame.getPageJeu4J().incScoreE3(j4.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
      					else if (j4.getEquipe()==4) {
      						frame.getPageJeu4J().incScoreE4(j4.getTableauPassif().get(partie.getModule().getNumPiece()).getNbCarreaux());
      					}
					}
					else{
						frame.getPageJeu4J().fin(3);
	      				partie.getModule().incTour();
					}
					frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
					for(int k=0; k < 20; k++) {
      					for(int l=0; l < 20; l++) {
      						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
      					}
      				}
				}
			}
			frame.getPageJeu4J().setImg("../data/images/backgrounds/Background"+partie.getModule().getCouleur()+".png");
		}

//........................................................................ Page Parametres

		if (ae.getActionCommand().equals("pageParametres")) {
			if (this.frame.getCourant().equals("echap")) {
				frame.setGlassInvisible();
			}
			frame.changerPage("pageParametres");
		}

//........................................................................ DragNDrop

		if (ae.getActionCommand().equals("dragNDrop")) {

			frame.getPageJeu4J().modifierImageModule(null);

			if (frame.getCourantGlass().equals("menuEchap")) {
				frame.changerGlassPage("dragNDrop");
			}

			frame.getPageJeu4J().afficherPoubelle();
			frame.setGlassVisible();
		}

//........................................................................ Page d'accueil

		if (ae.getActionCommand().equals("pageAccueil")) {
			if (this.frame.getCourant().equals("echap")) {
				frame.setGlassInvisible();
			}
			frame.changerPage("pageAccueil");
		}

//........................................................................ Mode 4 joueurs

		if (ae.getActionCommand().equals("mode4j")) {
			if (partie == null) {
				partie = new Partie();
			}
			else{
				partie = new Partie();
				joueurs.clear();
				frame.setPageJeu4J();
			}
			frame.changerPage("pageMode4J");
		}

//........................................................................ Retour a la page de choix depuis tuto

		if (ae.getActionCommand().equals("venantTuto")) {
			frame.changerPage("pageMode4J");
		}

//........................................................................ Mode 8 joueurs

		if (ae.getActionCommand().equals("mode8j")) {
			frame.changerPage("pageMode8J");
			partie = new Partie();
		}

//........................................................................ Mode Trigon

		if (ae.getActionCommand().equals("modeT")) {
			frame.changerPage("pageModeT");
			partie = new Partie();
		}

//........................................................................ Tutoriel 4 joueurs

		if (ae.getActionCommand().equals("tutoriel4J")) {
			if (this.frame.getCourant().equals("echap")) {
				frame.setGlassInvisible();
			}
			frame.changerPage("tutoriel4J");
		}

//........................................................................ Tutoriel 8 joueurs

		if (ae.getActionCommand().equals("tutoriel8J")) {
			frame.changerPage("tutoriel8J");
		}

//........................................................................ Tutoriel Trigon

		if (ae.getActionCommand().equals("tutorielT")) {
			frame.changerPage("tutorielT");
		}

//........................................................................ Tutoriel 4 joueurs

		if (ae.getActionCommand().equals("poubelle")) {
			imageAPlacer = null;
			frame.setGlassInvisible();
			frame.getPageJeu4J().reinitialisationImageAPlacer();
			frame.getPageJeu4J().effacerPoubelle();
		}

//........................................................................ Poubelle

		if (ae.getActionCommand().equals("son")) {
			if (this.frame.getCourant().equals("echap")) {
				frame.setGlassInvisible();
			}
			frame.changerPage("pageSon");
		}

//........................................................................ Reglages

		if (ae.getActionCommand().equals("pageParamDeJeu")) {
			frame.changerPage("pageParamDeJeu");
		}

//........................................................................ Regles du jeu

		if (ae.getActionCommand().equals("pageControles")) {
			frame.changerPage("pageControles");
		}

//........................................................................ Mentions Legales

		if (ae.getActionCommand().equals("pageMentionsLegales")) {
			frame.changerPage("pageMentionsLegales");
		}

//........................................................................ Quitter le jeu

		if (ae.getActionCommand().equals("quitter")) {
			if (this.frame.getCourant().equals("echap")) {
				frame.setGlassInvisible();
			}
			System.exit(0);
		}

//........................................................................ Bouton musique active

		if (ae.getActionCommand().equals("musique")) {
			if (musiqueActive) {
				frame.stopperLaMusique();
				frame.getPageSon().setBoutonMusique("../data/images/icones/VolumeActif.png");
				musiqueActive = false;
			}
			else{
				frame.activerLaMusique();
				frame.getPageSon().setBoutonMusique("../data/images/icones/VolumeInactif.png");
				musiqueActive = true;
			}
		}

//........................................................................ Lancer le jeu à 4 joueurs

		if (ae.getActionCommand().equals("lancer4J")) {

			j1 = new Joueur(this.frame.getPageMode4J().equipeJ1(),1,partie.getJeuModele(),this.frame.getPageMode4J().bot1());
			j1.setCouleur(1);

			j2 = new Joueur(this.frame.getPageMode4J().equipeJ2(),2,partie.getJeuModele(),this.frame.getPageMode4J().bot2());
			j2.setCouleur(2);
			
			j3 = new Joueur(this.frame.getPageMode4J().equipeJ3(),3,partie.getJeuModele(),this.frame.getPageMode4J().bot3());
			j3.setCouleur(3);
			
			j4 = new Joueur(this.frame.getPageMode4J().equipeJ4(),4,partie.getJeuModele(),this.frame.getPageMode4J().bot4());
			j4.setCouleur(4);

			joueurs.add(0, j1);
			joueurs.add(1, j2);
			joueurs.add(2, j3);
			joueurs.add(3, j4);

			partie.lancer(joueurs);
			for(int k=0; k < 20; k++) {
      			for(int l=0; l < 20; l++) {
      				ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
     			}
     		}
			frame.changerPage("pageJeu4J");
		}

//........................................................................ Lancer le jeu à 8 joueurs
/*
		if (ae.getActionCommand().equals("lancer8J")) {
			j1 = new Joueur();
			j2 = new Joueur();
			j3 = new Joueur();
			j4 = new Joueur();
			j5 = new Joueur();
			j6 = new Joueur();
			j7 = new Joueur();
			j8 = new Joueur();

			joueurs.add(j1);
			joueurs.add(j2);
			joueurs.add(j3);
			joueurs.add(j4);
			joueurs.add(j5);
			joueurs.add(j6);
			joueurs.add(j7);
			joueurs.add(j8);

			partie.lancer(joueurs);
		}

//........................................................................ Lancer le jeu Trigon		

		if (ae.getActionCommand().equals("lancerT")) {
			j1 = new Joueur();
			j2 = new Joueur();
			j3 = new Joueur();
			j4 = new Joueur();
			j5 = new Joueur();
			j6 = new Joueur();

			joueurs.add(j1);
			joueurs.add(j2);
			joueurs.add(j3);
			joueurs.add(j4);
			joueurs.add(j5);
			joueurs.add(j6);

			partie.lancer(joueurs);
		}
		*/

//........................................................................ Tourner la piece a droite

		if (ae.getActionCommand().equals("rotaD")) {
			partie.getModule().pivotD();

			if (miroir.equals("B")) {
				if (orientation.equals("N")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"O"+miroir+".png");
					orientation = "O";
				}
				else if (orientation.equals("E")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"N"+miroir+".png");
					orientation = "N";
				}
				else if (orientation.equals("S")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"E"+miroir+".png");
					orientation = "E";
				}
				else if (orientation.equals("O")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"S"+miroir+".png");
					orientation = "S";
				}	
			}
			else if(miroir.equals("M")){
				if (orientation.equals("N")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"E"+miroir+".png");
					orientation = "E";
				}
				else if (orientation.equals("O")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"N"+miroir+".png");
					orientation = "N";
				}
				else if (orientation.equals("S")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"O"+miroir+".png");
					orientation = "O";
				}
				else if (orientation.equals("E")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"S"+miroir+".png");
					orientation = "S";
				}
			}
		}

//........................................................................ Tourner la piece a gauche

		if (ae.getActionCommand().equals("rotaG")) {
			partie.getModule().pivotG();
			if (miroir.equals("B")) {
				if (orientation.equals("N")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"E"+miroir+".png");
					orientation = "E";
				}
				else if (orientation.equals("E")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"S"+miroir+".png");
					orientation = "S";
				}
				else if (orientation.equals("S")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"O"+miroir+".png");
					orientation = "O";
				}
				else if (orientation.equals("O")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"N"+miroir+".png");
					orientation = "N";
				}
			}
			else if(miroir.equals("M")){
				if (orientation.equals("N")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"O"+miroir+".png");
					orientation = "O";
				}
				else if (orientation.equals("O")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"S"+miroir+".png");
					orientation = "S";
				}
				else if (orientation.equals("S")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"E"+miroir+".png");
					orientation = "E";
				}
				else if (orientation.equals("E")) {
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"N"+miroir+".png");
					orientation = "N";
				}
			}
		}

//........................................................................ Tourner la piece en miroir horizontal

		if (ae.getActionCommand().equals("miroirH")) {
			partie.getModule().rotaH();
			if (miroir.equals("B")) {
				miroir = "M";
				if (orientation.equals("N")) {
					orientation = "S";
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
				}
				else if (orientation.equals("E")) {
					orientation = "O";
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
				}
				else if (orientation.equals("S")) {
					orientation = "N";
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
				}
				else if (orientation.equals("O")) {
					orientation = "E";
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
				}
			}
			else if(miroir.equals("M")){
				miroir = "B";
				if (orientation.equals("N")) {
					orientation = "S";
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
				}
				else if (orientation.equals("E")) {
					orientation = "O";
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
				}
				else if (orientation.equals("S")) {
					orientation = "N";
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
				}
				else if (orientation.equals("O")) {
					orientation = "E";
					frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
				}
			}
		}

//........................................................................ Tourner la piece en miroir vertical

		if (ae.getActionCommand().equals("miroirV")) {
			partie.getModule().rotaV();
			if (miroir.equals("B")) {
				miroir = "M";
				frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
			}
			else if(miroir.equals("M")){
				miroir = "B";
				frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
			}
		}
	}

	/**
  	 * Permet de gerer les evenements qui arrivent suite aux interractions de l'utilisateur avec des touches du clavier
  	 *
  	 * @param evt  l'évenement à gérer
  	 */

	public void keyPressed(KeyEvent evt){

//........................................................................ Echap

		if (evt.getKeyCode() == KeyEvent.VK_ESCAPE) {

			if (frame.getCourantGlass().equals("dragNDrop")) {
				frame.changerGlassPage("menuEchap");
			}

			if (this.frame.getCourant().equals("echap")) {
				frame.setGlassInvisible();
				frame.setCourant(frame.getPrecedent());
			}
			else{
				frame.setGlassVisible();
				frame.setCourant("echap");
			}
		}

//........................................................................ Raccourcis clavier

		if (partie != null) {
			if (partie.getModule() != null) {

				if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
					partie.getModule().pivotG();
					if (miroir.equals("B")) {
						if (orientation.equals("N")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"E"+miroir+".png");
							orientation = "E";
						}
						else if (orientation.equals("E")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"S"+miroir+".png");
							orientation = "S";
						}
						else if (orientation.equals("S")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"O"+miroir+".png");
							orientation = "O";
						}
						else if (orientation.equals("O")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"N"+miroir+".png");
							orientation = "N";
						}
					}
					else if(miroir.equals("M")){
						if (orientation.equals("N")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"O"+miroir+".png");
							orientation = "O";
						}
						else if (orientation.equals("O")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"S"+miroir+".png");
							orientation = "S";
						}
						else if (orientation.equals("S")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"E"+miroir+".png");
							orientation = "E";
						}
						else if (orientation.equals("E")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"N"+miroir+".png");
							orientation = "N";
						}
					}
				}
				if (evt.getKeyCode() == KeyEvent.VK_LEFT) {
					partie.getModule().pivotD();

					if (miroir.equals("B")) {
						if (orientation.equals("N")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"O"+miroir+".png");
							orientation = "O";
						}
						else if (orientation.equals("E")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"N"+miroir+".png");
							orientation = "N";
						}
						else if (orientation.equals("S")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"E"+miroir+".png");
							orientation = "E";
						}
						else if (orientation.equals("O")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"S"+miroir+".png");
							orientation = "S";
						}	
					}
					else if(miroir.equals("M")){
						if (orientation.equals("N")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"E"+miroir+".png");
							orientation = "E";
						}
						else if (orientation.equals("O")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"N"+miroir+".png");
							orientation = "N";
						}
						else if (orientation.equals("S")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"O"+miroir+".png");
							orientation = "O";
						}
						else if (orientation.equals("E")) {
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+"S"+miroir+".png");
							orientation = "S";
						}
					}
				}
				if (evt.getKeyCode() == KeyEvent.VK_RIGHT) {
					partie.getModule().rotaV();
					if (miroir.equals("B")) {
						miroir = "M";
						frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
					}
					else if(miroir.equals("M")){
						miroir = "B";
						frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
					}
				}
				if (evt.getKeyCode() == KeyEvent.VK_UP) {
					partie.getModule().rotaH();
					if (miroir.equals("B")) {
						miroir = "M";
						if (orientation.equals("N")) {
							orientation = "S";
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
						}
						else if (orientation.equals("E")) {
							orientation = "O";
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
						}
						else if (orientation.equals("S")) {
							orientation = "N";
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
						}
						else if (orientation.equals("O")) {
							orientation = "E";
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
						}
					}
					else if(miroir.equals("M")){
						miroir = "B";
						if (orientation.equals("N")) {
							orientation = "S";
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
						}
						else if (orientation.equals("E")) {
							orientation = "O";
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
						}
						else if (orientation.equals("S")) {
							orientation = "N";
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
						}
						else if (orientation.equals("O")) {
							orientation = "E";
							frame.getPageJeu4J().modifierImageModule(pieceSelectionee+orientation+miroir+".png");
						}
					}
				}
			}
		}
	}

	/**
  	 * Permet de gerer les evenements qui arrivent suite aux interractions de l'utilisateur avec des touches du clavier
  	 *
  	 * @param evt  l'évenement à gérer
  	 */

	public void keyTyped(KeyEvent evt){
	}

	/**
  	 * Permet de gerer les evenements qui arrivent suite aux interractions de l'utilisateur avec des touches du clavier
  	 *
  	 * @param evt  l'évenement à gérer
  	 */

	public void keyReleased(KeyEvent evt){
	}

	/**
  	 * Permet de gerer les evenements qui arrivent suite aux interractions de l'utilisateur avec des sliders
  	 *
  	 * @param arg0  l'évenement à gérer
  	 */

	public void stateChanged(ChangeEvent arg0) {
        float gain = frame.getPageSon().getGainSliderValue();
        int volume = (int)gain+80;
        int volume2 = (int)(Math.floor(((double)volume/86)*100));
        son.getGainControl().setValue(gain);
        frame.getPageSon().setValeur(""+volume2+"");
    }

    /**
  	 * Permet de gerer les evenements qui arrivent suite aux interractions de l'utilisateur avec la souris
  	 *
  	 * @param e  l'évenement à gérer
  	 */

    public void mousePressed(MouseEvent e){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		int x = e.getX()-(int)(width*0.3);
		x = x/((int)(width*0.4)/20);
		int y = e.getY()/((int)(height*0.7)/20);

//........................................................................ Poser une piece

		if (partie != null) {
			if (partie.getModule() != null) {
				if (x >= 10 && x <= 12 && y >= 22 && y <= 24) {
					imageAPlacer = null;
					frame.setGlassInvisible();
					frame.getPageJeu4J().reinitialisationImageAPlacer();
					frame.getPageJeu4J().effacerPoubelle();
				}

				if (partie.getModule().getCouleur() == 1 && !j1.getBot()) {
					if (partie.getModule().valider(y,x)) {

		  				frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
		  				frame.getPageJeu4J().modifierImageModule(null);

		 				for(int k=0; k < 20; k++) {
		 					for(int l=0; l < 20; l++) {
		  						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
		  					}
		  				}

		  				j1.retirerPieceJeuActif(piece);
			  			frame.getPageJeu4J().pieceUtilisee(joueur, pieceaRetirer);
						j1.incScore(j1.getTableauPassif().get(pieceaRetirer));
						frame.getPageJeu4J().setScoreJ1(""+j1.getScore());

						if (j1.getEquipe()==1) {
							frame.getPageJeu4J().incScoreE1(j1.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j1.getEquipe()==2) {
							frame.getPageJeu4J().incScoreE2(j1.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j1.getEquipe()==3) {
							frame.getPageJeu4J().incScoreE3(j1.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j1.getEquipe()==4) {
							frame.getPageJeu4J().incScoreE4(j1.getTableauPassif().get(piece).getNbCarreaux());
						}

						partie.getModule().decTour();

						if (!partie.getModule().verifTourPossible(j1.getTableauActif())) {
							frame.getPageJeu4J().fin(0);
							j1PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j2.getTableauActif())) {
							frame.getPageJeu4J().fin(1);
							j2PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j3.getTableauActif())) {
							frame.getPageJeu4J().fin(2);
							j3PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j4.getTableauActif())) {
							frame.getPageJeu4J().fin(3);
							j4PeuxJouer = false;
						}

						partie.getModule().decTour();
						partie.getModule().decTour();

						if (!j2PeuxJouer) {
      						partie.getModule().incTour();
      						if (!j3PeuxJouer) {
      							partie.getModule().incTour();
      							if (!j4PeuxJouer) {
      								partie.getModule().incTour();
      							}
      						}
      					}

						imageAPlacer = null;
						frame.setGlassInvisible();
						frame.getPageJeu4J().reinitialisationImageAPlacer();
						frame.getPageJeu4J().effacerPoubelle();
					}
				}
				else if (partie.getModule().getCouleur() == 2 && !j2.getBot()) {
					if (partie.getModule().valider(y,x)) {

		  				frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
		  				frame.getPageJeu4J().modifierImageModule(null);

		  				for(int k=0; k < 20; k++) {
		  					for(int l=0; l < 20; l++) {
		  						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
		  					}
		  				}

		  				j2.retirerPieceJeuActif(piece);

		  				frame.getPageJeu4J().pieceUtilisee(joueur, pieceaRetirer);
						j2.incScore(j2.getTableauPassif().get(pieceaRetirer));
						frame.getPageJeu4J().setScoreJ2(""+j2.getScore());

						if (j2.getEquipe()==1) {
							frame.getPageJeu4J().incScoreE1(j2.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j2.getEquipe()==2) {
							frame.getPageJeu4J().incScoreE2(j2.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j2.getEquipe()==3) {
							frame.getPageJeu4J().incScoreE3(j2.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j2.getEquipe()==4) {
							frame.getPageJeu4J().incScoreE4(j2.getTableauPassif().get(piece).getNbCarreaux());
						}

						partie.getModule().decTour();

						if (!partie.getModule().verifTourPossible(j2.getTableauActif())) {
      						frame.getPageJeu4J().fin(1);
      						j2PeuxJouer = false;
      					}

      					partie.getModule().incTour();

      					if (!partie.getModule().verifTourPossible(j3.getTableauActif())) {
      						frame.getPageJeu4J().fin(2);
      						j3PeuxJouer = false;
      					}

      					partie.getModule().incTour();

      					if (!partie.getModule().verifTourPossible(j4.getTableauActif())) {
      						frame.getPageJeu4J().fin(3);
      						j4PeuxJouer = false;
      					}

      					partie.getModule().incTour();

      					if (!partie.getModule().verifTourPossible(j1.getTableauActif())) {
      						frame.getPageJeu4J().fin(0);
      						j1PeuxJouer = false;
      					}

						partie.getModule().decTour();
						partie.getModule().decTour();

						if (!j3PeuxJouer) {
      						partie.getModule().incTour();
      						if (!j4PeuxJouer) {
      							partie.getModule().incTour();
      							if (!j1PeuxJouer) {
      								partie.getModule().incTour();
      							}
      						}
      					}

						imageAPlacer = null;
						frame.setGlassInvisible();
						frame.getPageJeu4J().reinitialisationImageAPlacer();
						frame.getPageJeu4J().effacerPoubelle();
					}
				}
				else if (partie.getModule().getCouleur() == 3 && !j3.getBot()) {
					if (partie.getModule().valider(y,x)) {

		  				frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
		  				frame.getPageJeu4J().modifierImageModule(null);

		  				for(int k=0; k < 20; k++) {
		  					for(int l=0; l < 20; l++) {
		  						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
		  					}
		  				}

		  				j3.retirerPieceJeuActif(piece);

		  				frame.getPageJeu4J().pieceUtilisee(joueur, pieceaRetirer);
						j3.incScore(j3.getTableauPassif().get(pieceaRetirer));
						frame.getPageJeu4J().setScoreJ3(""+j3.getScore());

						if (j3.getEquipe()==1) {
							frame.getPageJeu4J().incScoreE1(j3.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j3.getEquipe()==2) {
							frame.getPageJeu4J().incScoreE2(j3.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j3.getEquipe()==3) {
							frame.getPageJeu4J().incScoreE3(j3.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j3.getEquipe()==4) {
							frame.getPageJeu4J().incScoreE4(j3.getTableauPassif().get(piece).getNbCarreaux());
						}

						partie.getModule().decTour();

						if (!partie.getModule().verifTourPossible(j3.getTableauActif())) {
							frame.getPageJeu4J().fin(2);
							j3PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j4.getTableauActif())) {
							frame.getPageJeu4J().fin(3);
							j4PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j1.getTableauActif())) {
							frame.getPageJeu4J().fin(0);
							j1PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j2.getTableauActif())) {
							frame.getPageJeu4J().fin(1);
							j2PeuxJouer = false;
						}
						
						partie.getModule().decTour();
						partie.getModule().decTour();

						if (!j4PeuxJouer) {
      						partie.getModule().incTour();
      						if (!j1PeuxJouer) {
      							partie.getModule().incTour();
      							if (!j2PeuxJouer) {
      								partie.getModule().incTour();
      							}
      						}
      					}

						imageAPlacer = null;
						frame.setGlassInvisible();
						frame.getPageJeu4J().reinitialisationImageAPlacer();
						frame.getPageJeu4J().effacerPoubelle();
					}
				}
				else if (partie.getModule().getCouleur() == 4 && !j4.getBot()) {
					if (partie.getModule().valider(y,x)) {
		  				frame.getPageJeu4J().creerGrille(partie.getModule().getGrille(), ancienneGrille);
		  				frame.getPageJeu4J().modifierImageModule(null);

		  				for(int k=0; k < 20; k++) {
		  					for(int l=0; l < 20; l++) {
		  						ancienneGrille [k][l] = partie.getModule().getGrille()[k][l];
		  					}
		  				}

		  				j4.retirerPieceJeuActif(piece);

		  				frame.getPageJeu4J().pieceUtilisee(joueur, pieceaRetirer);
						j4.incScore(j4.getTableauPassif().get(pieceaRetirer));
						frame.getPageJeu4J().setScoreJ4(""+j4.getScore());

						if (j4.getEquipe()==1) {
							frame.getPageJeu4J().incScoreE1(j4.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j4.getEquipe()==2) {
							frame.getPageJeu4J().incScoreE2(j4.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j4.getEquipe()==3) {
							frame.getPageJeu4J().incScoreE3(j4.getTableauPassif().get(piece).getNbCarreaux());
						}
						else if (j4.getEquipe()==4) {
							frame.getPageJeu4J().incScoreE4(j4.getTableauPassif().get(piece).getNbCarreaux());
						}

						partie.getModule().decTour();

						if (!partie.getModule().verifTourPossible(j4.getTableauActif())) {
							frame.getPageJeu4J().fin(3);
							j4PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j1.getTableauActif())) {
							frame.getPageJeu4J().fin(0);
							j1PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j2.getTableauActif())) {
							frame.getPageJeu4J().fin(1);
							j2PeuxJouer = false;
						}

						partie.getModule().incTour();

						if (!partie.getModule().verifTourPossible(j3.getTableauActif())) {
							frame.getPageJeu4J().fin(2);
							j3PeuxJouer = false;
						}

						partie.getModule().decTour();
						partie.getModule().decTour();

						if (!j1PeuxJouer) {
      						partie.getModule().incTour();
      						if (!j2PeuxJouer) {
      							partie.getModule().incTour();
      							if (!j3PeuxJouer) {
      								partie.getModule().incTour();
      							}
      						}
      					}

						imageAPlacer = null;
						frame.setGlassInvisible();
						frame.getPageJeu4J().reinitialisationImageAPlacer();
						frame.getPageJeu4J().effacerPoubelle();
					}
				}
			}
		}		
		frame.getPageJeu4J().setImg("../data/images/backgrounds/Background"+partie.getModule().getCouleur()+".png");
	}

	/**
  	 * Permet de gerer les evenements qui arrivent suite aux interractions de l'utilisateur avec le mouvement de la souris
  	 *
  	 * @param e  l'évenement à gérer
  	 */

	public void mouseMoved(MouseEvent e){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		imageAPlacer = frame.getPageJeu4J().getImageAPlacer();

		if (imageAPlacer != null) {
			imageAPlacer.setLocation(e.getX()-(int)(width*0.045),e.getY()-(int)(height*0.08));
		}
	}
}