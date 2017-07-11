package view.pageMode4J;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import control.*;
import java.awt.image.BufferedImage;
import java.awt.event.*;

/**
 * Fichier : PageJeu4J.java
 * Date : 09/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les elements graphiques de la page de jeu a 4 joueurs.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageJeu4J extends JPanel{

//................................................................................................... I : EN-TÊTE
	
	/** Panel contenant un grid layout et représentant le plateau */

	private JPanel plateau = new JPanel();

	/** Tableau de boutons intégrés dans le plateau */

	private JButton[][] boutons = new JButton[20][20];

	/** Tableau de boutons servant à afficher les pièces de tous les joueurs, il est de 4 (nbjoueurs) sur 21 (nbpieces) */

	private JButton[][] piece = new JButton[4][21];

	/** Bouton permettant de tourner la pièce à droite */

	private JButton rotaG = new JButton();

	/** Bouton permettant de tourner la pièce à droite */

	private JButton rotaD = new JButton();
	
	/** Bouton permettant de tourner la pièce selon l'axe horizontal */

	private JButton miroirH = new JButton();
	
	/** Bouton permettant d'accéder à la page selon l'axe vertical */

	private JButton miroirV = new JButton();
	
	/** Bouton permettant de lancer un tour de bot */

	private JButton debut = new JButton();
	
	/** Label affichant le score du joueur 1 */

	private JLabel scorej1 = new JLabel("0");
	
	/** Label affichant le score du joueur 2 */

	private JLabel scorej2 = new JLabel("0");
	
	/** Label affichant le score du joueur 3 */

	private JLabel scorej3 = new JLabel("0");
	
	/** Label affichant le score du joueur 4 */

	private JLabel scorej4 = new JLabel("0");

	/** Entier contenant le score de l'equipe 1 */

	private int scoreEq1 = 0;
	
	/** Entier contenant le score de l'equipe 2 */

	private int scoreEq2 = 0;
	
	/** Entier contenant le score de l'equipe 3 */

	private int scoreEq3 = 0;
	
	/** Entier contenant le score de l'equipe 4 */

	private int scoreEq4 = 0;
	
	/** Label affichant le score de l'equipe 1 */

	private JLabel scoreE1 = new JLabel("0");
	
	/** Label affichant le score de l'equipe 2 */

	private JLabel scoreE2 = new JLabel("0");
	
	/** Label affichant le score de l'equipe 3 */

	private JLabel scoreE3 = new JLabel("0");
	
	/** Label affichant le score de l'equipe 4 */

	private JLabel scoreE4 = new JLabel("0");
	
	/** Bouton permettant d'acceder au glass panel et affichant la piece qui se tourne */

	private JButton module = new JButton();
	
	/** Label contenant l'image de la piece courante */

	private JLabel imageAPlacer = new JLabel();
	
	/** Glass panel du drag n drop */

	private JPanel dragNDrop;
	
	/** L'ecouteur du jeu, qui recupere tous les interractions de l'utilisateur avec le jeu */

	private BlokusListener l;
	
	/** Bouton permettant de sortir du glass panel après la selection d'une piece */

	private JButton poubelle = new JButton("jeter");

	/** Image servant de fond au jeu */
	
	private Image img;

//................................................................................................... II : CONSTRUCTEUR
	
	/**
  	 * Positionne les elements sur le panel
  	 *
  	 * @param l  l'ecouteur qui permet de declencher une action en fonction de l'action de l'utilisateur
  	 * @param dragNDrop  panel appartenant au glass panel et servant a afficher la piece au dessus du plateau de boutons
  	 */

	public PageJeu4J(BlokusListener l, JPanel dragNDrop) {

		this.setLayout(null);

		img = new ImageIcon("../data/images/backgrounds/Background1.png").getImage();

		this.dragNDrop = dragNDrop;
		this.l = l;

		dragNDrop.addMouseListener(l);
		dragNDrop.addMouseMotionListener(l);

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		plateau.setLayout(new GridLayout(20,20));
		plateau.setBounds((int)(width*0.3),0,(int)(width*0.4),(int)(height*0.7));

		debut.setBounds((int)(width*0.6),(int)(height*0.705),(int)(width*0.09),(int)(height*0.055));
		debut.setActionCommand("tourDeBot");
	    debut.addActionListener(l);
	    debut.setBorderPainted(false);
		debut.setContentAreaFilled(false);
	    debut.setFocusable(false);
		this.add(debut);

		ImageIcon icon = new ImageIcon("../data/images/icones/poubelle.png");
		Image image = icon.getImage();
		image = changerTailleImage(image,(int)(width*0.05),(int)(height*0.12));
		icon = new ImageIcon(image);

		poubelle.setBounds((int)(width*0.51),(int)(height*0.77),(int)(width*0.05),(int)(height*0.12));
		poubelle.setActionCommand("poubelle");
	    poubelle.addActionListener(l);
	    poubelle.setIcon(icon);
	    poubelle.setBorderPainted(false);
		poubelle.setContentAreaFilled(false);
	    poubelle.setFocusable(false);
	    poubelle.setVisible(false);
		this.add(poubelle);

		scorej1.setBounds((int)(width*0.258),(int)(height*0.062),(int)(width*0.05),(int)(height*0.05));
		scorej1.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.02)));
		this.add(scorej1);

		scorej2.setBounds((int)(width*0.258),(int)(height*0.515),(int)(width*0.05),(int)(height*0.05));
		scorej2.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.02)));
		this.add(scorej2);

		scorej3.setBounds((int)(width*0.96),(int)(height*0.062),(int)(width*0.05),(int)(height*0.05));
		scorej3.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.02)));
		this.add(scorej3);

		scorej4.setBounds((int)(width*0.96),(int)(height*0.515),(int)(width*0.05),(int)(height*0.05));
		scorej4.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.02)));
		this.add(scorej4);

		scoreE1.setBounds((int)(width*0.66),(int)(height*0.705),(int)(width*0.15),(int)(height*0.15));
		scoreE1.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.01)));
		this.add(scoreE1);

		scoreE2.setBounds((int)(width*0.66),(int)(height*0.735),(int)(width*0.15),(int)(height*0.15));
		scoreE2.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.01)));
		this.add(scoreE2);

		scoreE3.setBounds((int)(width*0.66),(int)(height*0.77),(int)(width*0.15),(int)(height*0.15));
		scoreE3.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.01)));
		this.add(scoreE3);

		scoreE4.setBounds((int)(width*0.66),(int)(height*0.805),(int)(width*0.15),(int)(height*0.15));
		scoreE4.setFont(new Font("Berlin", Font.BOLD, (int)(width*0.01)));
		this.add(scoreE4);

		for(int i=0; i < 20; i++) {
	      	for(int j=0; j < 20; j++) {
	        	this.boutons[i][j] = new JButton();
	        	this.boutons[i][j].setBackground(new Color(255,255,255));
	        	this.boutons[i][j].setBorder(new LineBorder(Color.BLACK));
	        	//this.boutons[i][j].setBounds((int)(width*0.05),(int)(height*0.05),(int)(width*0.05),(int)(height*0.01)); //It's the dimension of the button
	        	this.boutons[i][j].setFocusable(false);
	        	this.boutons[i][j].setActionCommand("bouton ["+i+"]["+j+"]");
	        	this.boutons[i][j].addActionListener(l);
	        	this.boutons[i][j].setOpaque(true);
	        	this.plateau.add(this.boutons[i][j]);
	      	}
	    }

	    plateau.setOpaque(false);
	    this.add(plateau);
	    double posHaut = 0.052;

	    rotaG.setBounds((int)(width*0.45),(int)(height*0.71),(int)(width*0.045),(int)(height*0.07));
	    rotaG.setActionCommand("rotaG");
	    rotaG.addActionListener(l);
	    rotaG.setBorderPainted(false);
		rotaG.setContentAreaFilled(false);
	    rotaG.setFocusable(false);
	    this.add(rotaG);

	    rotaD.setBounds((int)(width*0.31),(int)(height*0.71),(int)(width*0.045),(int)(height*0.07));
	    rotaD.setActionCommand("rotaD");
	    rotaD.setBorderPainted(false);
		rotaD.setContentAreaFilled(false);
	    rotaD.setFocusable(false);
	    rotaD.addActionListener(l);
	    this.add(rotaD);

	    miroirH.setBounds((int)(width*0.46),(int)(height*0.82),(int)(width*0.03),(int)(height*0.07));
	    miroirH.setActionCommand("miroirH");
	    miroirH.setBorderPainted(false);
		miroirH.setContentAreaFilled(false);
	    miroirH.addActionListener(l);
	    miroirH.setFocusable(false);
	    this.add(miroirH);

	    miroirV.setBounds((int)(width*0.31),(int)(height*0.82),(int)(width*0.05),(int)(height*0.06));
	    miroirV.setActionCommand("miroirV");
	    miroirV.addActionListener(l);
	    miroirV.setBorderPainted(false);
		miroirV.setContentAreaFilled(false);
	    miroirV.setFocusable(false);
	    this.add(miroirV);

	    for (int j=0; j<4 ; j++ ) {
	    
	    	double posGauche = 0;

	    	if (j==1 || j==3) {
	    		posHaut = 0.505;

	    	}

	    	if (j==2) {
	    		posHaut = 0.052;
	    		posGauche = 0.7;
	    	}

	    	if (j==3) {
	    		posGauche = 0.7;
	    	}

		    for (int i=0; i<4 ; i++ ) {
		    	icon = new ImageIcon("../data/images/pieces/joueur"+(j+1)+"/piece"+i+"/joueur"+(j+1)+"piece"+i+"NB.png");
				image = icon.getImage();
				image = changerTailleImage(image,(int)(width*0.045),(int)(height*0.075));
				icon = new ImageIcon(image);
		    	piece[j][i] = new JButton(""+i+"");
		 	    piece[j][i].setBounds((int)(width*posGauche),(int)(height*posHaut),(int)(width*0.05),(int)(height*0.08));
		 	    piece[j][i].setActionCommand("selectionner piece "+i+" joueur "+j);
	        	piece[j][i].addActionListener(l);
	        	piece[j][i].setFocusable(false);
		   		this.add(piece[j][i]);
		   		posGauche = posGauche+0.05;
		   		piece[j][i].setIcon(icon);
				piece[j][i].setBorderPainted(false);
				piece[j][i].setContentAreaFilled(false);
				piece[j][i].setHorizontalAlignment(SwingConstants.CENTER);
				piece[j][i].setVerticalAlignment(SwingConstants.CENTER);
				piece[j][i].setMargin(new Insets((int)(height*0.01),(int)(width*0.017),(int)(height*0.01),0));
		    }

		    posHaut = 0.1+posHaut;

		    if (j<2) {
		    	posGauche = 0;
		    }
		    else{
		    	posGauche = 0.7;
		    }

		    for (int i=4; i<9 ; i++ ) {
		    	icon = new ImageIcon("../data/images/pieces/joueur"+(j+1)+"/piece"+i+"/joueur"+(j+1)+"piece"+i+"NB.png");
				image = icon.getImage();
				image = changerTailleImage(image,(int)(width*0.045),(int)(height*0.075));
				icon = new ImageIcon(image);
		    	piece[j][i] = new JButton(""+i+"");
		 	    piece[j][i].setBounds((int)(width*posGauche),(int)(height*posHaut),(int)(width*0.05),(int)(height*0.08));
		 	    piece[j][i].setActionCommand("selectionner piece "+i+" joueur "+j);
	        	piece[j][i].addActionListener(l);
	        	piece[j][i].setFocusable(false);
		   		this.add(piece[j][i]);
		   		posGauche = posGauche+0.05;
		   		piece[j][i].setIcon(icon);
				piece[j][i].setBorderPainted(false);
				piece[j][i].setContentAreaFilled(false);
				piece[j][i].setHorizontalAlignment(SwingConstants.CENTER);
				piece[j][i].setVerticalAlignment(SwingConstants.CENTER);
				piece[j][i].setMargin(new Insets((int)(height*0.01),(int)(width*0.017),(int)(height*0.01),0));
		    }

		    posHaut = 0.1+posHaut;
		    
		    if (j<2) {
		    	posGauche = 0;
		    }
		    else{
		    	posGauche = 0.7;
		    }

		    for (int i=9; i<15 ; i++ ) {
		    	icon = new ImageIcon("../data/images/pieces/joueur"+(j+1)+"/piece"+i+"/joueur"+(j+1)+"piece"+i+"NB.png");
				image = icon.getImage();
				image = changerTailleImage(image,(int)(width*0.045),(int)(height*0.075));
				icon = new ImageIcon(image);
		    	piece[j][i] = new JButton(""+i+"");
		 	    piece[j][i].setBounds((int)(width*posGauche),(int)(height*posHaut),(int)(width*0.05),(int)(height*0.08));
		 	    piece[j][i].setActionCommand("selectionner piece "+i+" joueur "+j);
	        	piece[j][i].addActionListener(l);
	        	piece[j][i].setFocusable(false);
		   		this.add(piece[j][i]);
		   		posGauche = posGauche+0.05;
		   		piece[j][i].setIcon(icon);
				piece[j][i].setBorderPainted(false);
				piece[j][i].setContentAreaFilled(false);
				piece[j][i].setHorizontalAlignment(SwingConstants.CENTER);
				piece[j][i].setVerticalAlignment(SwingConstants.CENTER);
				piece[j][i].setMargin(new Insets((int)(height*0.01),(int)(width*0.017),(int)(height*0.01),0));
		    }

		    posHaut = 0.1+posHaut;
		    
		    if (j<2) {
		    	posGauche = 0;
		    }
		    else{
		    	posGauche = 0.7;
		    }

		    for (int i=15; i<21 ; i++ ) {
		    	icon = new ImageIcon("../data/images/pieces/joueur"+(j+1)+"/piece"+i+"/joueur"+(j+1)+"piece"+i+"NB.png");
				image = icon.getImage();
				image = changerTailleImage(image,(int)(width*0.045),(int)(height*0.075));
				icon = new ImageIcon(image);
		    	piece[j][i] = new JButton(""+i+"");
		 	    piece[j][i].setBounds((int)(width*posGauche),(int)(height*posHaut),(int)(width*0.05),(int)(height*0.08));
		 	    piece[j][i].setActionCommand("selectionner piece "+i+" joueur "+j);
	        	piece[j][i].addActionListener(l);
	        	piece[j][i].setFocusable(false);
		   		this.add(piece[j][i]);
		   		posGauche = posGauche+0.05;
		   		piece[j][i].setIcon(icon);
				piece[j][i].setBorderPainted(false);
				piece[j][i].setContentAreaFilled(false);
				piece[j][i].setHorizontalAlignment(SwingConstants.CENTER);
				piece[j][i].setVerticalAlignment(SwingConstants.CENTER);
				piece[j][i].setMargin(new Insets((int)(height*0.01),(int)(width*0.017),(int)(height*0.01),0));
		    }
	    }

		module.setBounds((int)(width*0.358),(int)(height*0.72),(int)(width*0.1),(int)(height*0.16));
		module.setBorderPainted(false);
		module.setContentAreaFilled(false);
		module.setActionCommand("dragNDrop");
		module.addActionListener(l);
		module.setFocusable(false);
		this.add(module);

		imageAPlacer.setBounds((int)(width*0.355),(int)(height*0.72),(int)(width*0.1),(int)(height*0.16));
		dragNDrop.add(imageAPlacer);
	}

//................................................................................................... III : METHODES

	/**
	* Methode qui modifie le plateau de boutons en fonctions de la grille courante et de la grille précédente en 
	* les comparant
	*
	* @param grille  grille courante
	* @param ancienneGrille  ancienne grille
	*/

	public void creerGrille(int [][] grille, int [][] ancienneGrille){

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		for(int i=0; i < 20; i++) {
	      	for(int j=0; j < 20; j++) {
	        	if (grille [i][j] != ancienneGrille[i][j]) {
	        		if (grille[i][j] == 1) {
						ImageIcon imageIcon = new ImageIcon("../data/images/pieces/PNG/CarreRouge.png");
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance((int)(width*0.02),(int)(height*0.035),  java.awt.Image.SCALE_SMOOTH); 
						imageIcon = new ImageIcon(newimg);
		        		this.boutons[i][j].setIcon(imageIcon);
		        	}
		        	else if (grille[i][j] == 2) {
		        		ImageIcon imageIcon = new ImageIcon("../data/images/pieces/PNG/CarreBleu.png");
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance((int)(width*0.02),(int)(height*0.035),  java.awt.Image.SCALE_SMOOTH); 
						imageIcon = new ImageIcon(newimg);
		        		this.boutons[i][j].setIcon(imageIcon);
		        	}
		        	else if (grille[i][j] == 3) {
		        		ImageIcon imageIcon = new ImageIcon("../data/images/pieces/PNG/CarreJaune.png");
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance((int)(width*0.02),(int)(height*0.035),  java.awt.Image.SCALE_SMOOTH); 
						imageIcon = new ImageIcon(newimg);
		        		this.boutons[i][j].setIcon(imageIcon);
		        	}
		        	else if (grille[i][j] == 4) {
		        		ImageIcon imageIcon = new ImageIcon("../data/images/pieces/PNG/CarreVert.png");
						Image image = imageIcon.getImage();
						Image newimg = image.getScaledInstance((int)(width*0.02),(int)(height*0.035),  java.awt.Image.SCALE_SMOOTH); 
						imageIcon = new ImageIcon(newimg);
		        		this.boutons[i][j].setIcon(imageIcon);
		        	}
		        	else{
		        		this.boutons[i][j].setBackground(new Color(255,255,255));
		        	}	
	        	}
	        	this.boutons[i][j].setBorder(new LineBorder(Color.BLACK));
	      	}
	    }
	}

	/**
	* Interdit le clic sur une piece grace au numéro du joueur et au numéro de la piece
	*
	* @param joueur  numéro du joueur
	* @param piece  numéro de la piece
	*/

	public void pieceUtilisee(int joueur, int piece){
		this.piece[joueur][piece].setEnabled(false);
	}

	/**
	* Interdit le clic sur toutes les pieces du joueur
	*
	* @param joueur  le numéro du joueur
	*/

	public void fin(int joueur){
		for (int i=0; i<21 ; i++) {
			this.piece[joueur][i].setEnabled(false);
		}
	}

	/**
	 * Modifie le score du joueur 1
	 *
	 * @param string  texte a afficher
	 */

	public void setScoreJ1(String string){
		scorej1.setText(string);
	}

	/**
	 * Modifie le score du joueur 2
	 *
	 * @param string  texte a afficher
	 */

	public void setScoreJ2(String string){
		scorej2.setText(string);
	}

	/**
	 * Modifie le score du joueur 3
	 *
	 * @param string  texte a afficher
	 */

	public void setScoreJ3(String string){
		scorej3.setText(string);
	}

	/**
	 * Modifie le score du joueur 4
	 *
	 * @param string  texte a afficher
	 */

	public void setScoreJ4(String string){
		scorej4.setText(string);
	}

	/**
	 * Augmente le score de l'equipe 1 et l'affiche
	 *
	 * @param score  texte a afficher
	 */

	public void incScoreE1(int score){
		scoreEq1 = scoreEq1 + score;
		scoreE1.setText(""+scoreEq1);
	}

	/**
	 * Augmente le score de l'equipe 2 et l'affiche
	 *
	 * @param score  texte a afficher
	 */

	public void incScoreE2(int score){
		scoreEq2 = scoreEq2 + score;
		scoreE2.setText(""+scoreEq2);
	}

	/**
	 * Augmente le score de l'equipe 3 et l'affiche
	 *
	 * @param score  texte a afficher
	 */

	public void incScoreE3(int score){
		scoreEq3 = scoreEq3 + score;
		scoreE3.setText(""+scoreEq3);
	}

	/**
	 * Augmente le score de l'equipe 4 et l'affiche
	 *
	 * @param score  texte a afficher
	 */

	public void incScoreE4(int score){
		scoreEq4 = scoreEq4 + score;
		scoreE4.setText(""+scoreEq4);
	}

	/**
	 * Permet de modifier la taille d'une image passée en paramètre
	 *
	 * @param source  Image à modifier
	 * @param width  La largeur voulue
	 * @param height  La hauteur voulue
	 *
	 * @return  L'image à la taille voulue
	 */

	public static Image changerTailleImage(Image source, int width, int height) {
	    BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g = (Graphics2D) img.getGraphics();
	    g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g.drawImage(source, 0, 0, width, height, null);
	    g.dispose();
	    return img;
	}

	/**
	 * Permet de modifier l'image du module et de modifier sa taille
	 *
	 * @param string  chemin de l'image
	 */

	public void modifierImageModule(String string){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		ImageIcon icon = new ImageIcon(string);
		Image image = icon.getImage();
		image = changerTailleImage(image,(int)(width*0.07),(int)(height*0.112));
		icon = new ImageIcon(image);
		module.setIcon(icon);

		if (string != null) {
			ImageIcon icon2 = new ImageIcon(string);
			Image image2 = icon2.getImage();
			image2 = changerTailleImage(image2,(int)(width*0.095),(int)(height*0.17));
			icon2 = new ImageIcon(image2);
			imageAPlacer.setIcon(icon2);
		}
	}

	/**
	 * Cette méthode permet de gérer l'affichage du fond
	 *
	 * @param g Le composant graphique de la fenêtre
	 */

	public void paintComponent(Graphics g) {
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		g.drawImage(img, 0, 0, width,height, null);
	}

	/**
	 * Cette méthode permet modifier l'image de fond
	 *
	 * @param string  Le chemin d'acces a l'image
	 */

	public void setImg(String string){
		this.img = new ImageIcon(string).getImage();
		repaint();
	}

	/**
	 * Cette méthode permet de récupérer le label contenant l'image a placer
	 *
	 * @return  renvoie le label courant
	 */

	public JLabel getImageAPlacer(){
		return imageAPlacer;
	}

	/**
	 * Cette méthode permet d'afficher la poubelle
	 */

	public void afficherPoubelle(){
		poubelle.setVisible(true);
	}

	/**
	 * Cette méthode permet d'effacer la poubelle
	 */

	public void effacerPoubelle(){
		poubelle.setVisible(false);
	}

	/**
	 * Cette méthode permet de replacer l'image a placer au centre du module
	 */

	public void reinitialisationImageAPlacer(){
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280
		imageAPlacer.setBounds((int)(width*0.355),(int)(height*0.72),(int)(width*0.1),(int)(height*0.16));
	}
}