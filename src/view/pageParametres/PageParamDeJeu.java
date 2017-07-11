package view.pageParametres;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : PageParamDeJeu.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les elements graphiques de la page PageParamDeJeu.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageParamDeJeu extends JPanel{

//................................................................................................... I : EN-TÊTE
	
	/** Image servant de fond au menu */

	private Image img;

	/** Bouton permettant d'accéder au choix de la langue */

	private JButton language = new JButton();

	/** Bouton permettant d'accéder aux paramêtres de gestion du temps */

	private JButton gestionTemps = new JButton();

	/** Bouton permettant d'accéder aux réglages du score */

	private JButton score = new JButton();

	/** Bouton d'accès aux paramètres des contrôles */

	private JButton controles = new JButton();

	/** Bouton pour retourner dans les paramètres généraux */
	
	private JButton param = new JButton();

//................................................................................................... II : CONSTRUCTEUR
	
	/**
  	 * Positionne les éléments sur le panel
  	 *
  	 * @param l L'écouteur qui permet de déclencher une action en fonction de l'action de l'utilisateur
  	 */

	public PageParamDeJeu(BlokusListener l) {

		this.setLayout(null);

		img = new ImageIcon("../data/images/backgrounds/BackgroundReglages.png").getImage();

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		language.setBounds((int)(width*0.095),(int)(height*0.245),(int)(width*0.19),(int)(height*0.41));
		language.setActionCommand("language");
		language.addActionListener(l);
		language.setBorderPainted(false);
		language.setContentAreaFilled(false);
		language.setEnabled(false);
		this.add(language);

		gestionTemps.setBounds((int)(width*0.308),(int)(height*0.245),(int)(width*0.19),(int)(height*0.41));
		gestionTemps.setActionCommand("gestionTemps");
		gestionTemps.addActionListener(l);
		gestionTemps.setBorderPainted(false);
		gestionTemps.setContentAreaFilled(false);
		gestionTemps.setEnabled(false);
		this.add(gestionTemps);

		score.setBounds((int)(width*0.515),(int)(height*0.245),(int)(width*0.19),(int)(height*0.41));
		score.setActionCommand("score");
		score.addActionListener(l);
		score.setBorderPainted(false);
		score.setContentAreaFilled(false);
		score.setEnabled(false);
		this.add(score);

		controles.setBounds((int)(width*0.725),(int)(height*0.245),(int)(width*0.19),(int)(height*0.41));
		controles.setActionCommand("pageControles");
		controles.addActionListener(l);
		controles.setBorderPainted(false);
		controles.setContentAreaFilled(false);
		this.add(controles);

		param.setBounds((int)(width*0.475),(int)(height*0.122),(int)(width*0.062),(int)(height*0.09));
		param.setActionCommand("pageParametres");
		param.addActionListener(l);
		param.setBorderPainted(false);
		param.setContentAreaFilled(false);
		this.add(param);
	}

//................................................................................................... III : METHODES

	/**
	 * Cette méthode est utilisée pour afficher un fond dans la fenêtres
	 * @param g Composant graphique de la fenêtre
	 */
			
	public void paintComponent(Graphics g) {
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		g.drawImage(img, 0, 0, width, height, null);
	}
}
