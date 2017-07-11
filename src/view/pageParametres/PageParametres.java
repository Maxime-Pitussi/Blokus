package view.pageParametres;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : PageParametres.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les elements graphiques de la page parametres.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageParametres extends JPanel{

//................................................................................................... I : EN-TÊTE

	/** Bouton d'accès aux paramètres audio */

	private JButton son = new JButton();

	/** Bouton d'accès à la page de mentions légales */

	private JButton mentionLegales = new JButton();

	/** Bouton de réglages de l'affichage */

	private JButton affichage = new JButton();

	/** Bouton d'accès aux paramètres de jeu */

	private JButton param = new JButton();

	/** Bouton de retour vers l'accueil */

	private JButton accueil = new JButton();

	/** Image utilisée pour le fond de l'application */

	private Image img;

//................................................................................................... I : CONSTRUCTEUR
	
	/**
  	 * Positionne les éléments sur le panel
  	 *
  	 * @param l L'écouteur qui permet de déclencher une action en fonction de l'action de l'utilisateur
  	 */

	public PageParametres(BlokusListener l) {

		this.setLayout(null);

		img = new ImageIcon("../data/images/backgrounds/BackgroundParametres.png").getImage();

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		son.setBounds((int)(width*0.095),(int)(height*0.245),(int)(width*0.19),(int)(height*0.41));
		son.setActionCommand("son");
		son.addActionListener(l);
		son.setBorderPainted(false);
		son.setContentAreaFilled(false);
		this.add(son);

		mentionLegales.setBounds((int)(width*0.308),(int)(height*0.245),(int)(width*0.19),(int)(height*0.41));
		mentionLegales.setActionCommand("pageMentionsLegales");
		mentionLegales.addActionListener(l);
		mentionLegales.setBorderPainted(false);
		mentionLegales.setContentAreaFilled(false);
		this.add(mentionLegales);

		affichage.setBounds((int)(width*0.515),(int)(height*0.245),(int)(width*0.19),(int)(height*0.41));
		affichage.setActionCommand("affichage");
		affichage.addActionListener(l);
		affichage.setBorderPainted(false);
		affichage.setContentAreaFilled(false);
		affichage.setEnabled(false);
		this.add(affichage);

		param.setBounds((int)(width*0.725),(int)(height*0.245),(int)(width*0.19),(int)(height*0.41));
		param.setActionCommand("pageParamDeJeu");
		param.addActionListener(l);
		param.setBorderPainted(false);
		param.setContentAreaFilled(false);
		this.add(param);

		accueil.setBounds((int)(width*0.475),(int)(height*0.122),(int)(width*0.062),(int)(height*0.09));
		accueil.setActionCommand("pageAccueil");
		accueil.addActionListener(l);
		accueil.setBorderPainted(false);
		accueil.setContentAreaFilled(false);
		this.add(accueil);
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