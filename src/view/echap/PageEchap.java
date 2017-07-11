package view.echap;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import control.BlokusListener;
import model.Audio;

/**
 * Fichier : PageEchap.java
 * Date : 22/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les éléments audio de la Page Echap.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageEchap extends JPanel{

//................................................................................................... I : EN-TÊTE

	/** Bouton permettant d'accéder à la page d'accueil */

	private JButton accueil = new JButton();

	/** Bouton permettant d'accéder à la page des parametres */

	private JButton parametres = new JButton();

	/** Bouton permettant d'accéder à la page du tutoriel */

	private JButton raccourcis = new JButton();

	/** Bouton permettant de quitter l'application */

	private JButton quitter = new JButton();

	/** L'ecouteur du jeu, qui recupere tous les interractions de l'utilisateur avec le jeu */

	private BlokusListener l;

	/** Image servant de fond au menu */

	private Image img;

//................................................................................................... II : CONSTRUCTEUR
	
	/**
  	 * Positionne les éléments sur le panel
  	 *
  	 * @param l L'écouteur qui permet de déclencher une action en fonction de l'action de l'utilisateur
  	 */

	public PageEchap(BlokusListener l) {

		this.setLayout(null);

		this.l = l;

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		this.setOpaque(false);

		img = new ImageIcon("../data/images/backgrounds/BackgroundEchap.png").getImage();

		accueil.setBounds((int)(width*0.395),(int)(height*0.51),(int)(width*0.21),(int)(height*0.135));
		accueil.setActionCommand("pageAccueil");
		accueil.addActionListener(l);
		accueil.setBorderPainted(false);
		accueil.setContentAreaFilled(false);
		this.add(accueil);

		parametres.setBounds((int)(width*0.395),(int)(height*0.22),(int)(width*0.21),(int)(height*0.135));
		parametres.setActionCommand("pageParametres");
        parametres.addActionListener(l);
        parametres.setBorderPainted(false);
		parametres.setContentAreaFilled(false);
		this.add(parametres);

		raccourcis.setBounds((int)(width*0.395),(int)(height*0.37),(int)(width*0.21),(int)(height*0.135));
		raccourcis.setActionCommand("tutoriel4J");
        raccourcis.addActionListener(l);
        raccourcis.setBorderPainted(false);
		raccourcis.setContentAreaFilled(false);
		this.add(raccourcis);
		
		quitter.setBounds((int)(width*0.395),(int)(height*0.655),(int)(width*0.21),(int)(height*0.135));
		quitter.setActionCommand("quitter");
        quitter.addActionListener(l);
        quitter.setBorderPainted(false);
		quitter.setContentAreaFilled(false);
		this.add(quitter);
	}

//................................................................................................... III : METHODES

	/**
	 * Cette méthode permet de gérer l'affichage du fond
	 *
	 * @param g Le composant graphique de la fenêtre
	 */
	
	public void paintComponent(Graphics g) {
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		g.drawImage(img, 0, 0, width, height, null);
	}
}