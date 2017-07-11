package view.pageAccueil;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : PageAccueil.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les elements graphiques de la page accueil.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageAccueil extends JPanel{

//................................................................................................... I : EN-TÊTE
	
	/** Bouton conduisant au mode de jeu 8 joueurs (inaccessible) */

	private JButton mode8j = new JButton();
	
	/** Bouton conduisant au mode de jeu 4 joueurs (partie normale) */

	private JButton mode4j = new JButton();
	
	/** Bouton conduisant au mode de jeu trigon (inaccessible) */

	private JButton modeT = new JButton();
	
	/** Bouton conduisant au menu des paramètres */

	private JButton parametres = new JButton();
	
	/** Bouton permettant de quitter l'application */

	private JButton quitter = new JButton();
	
	/** Image de fond de la page d'accueil */

	private Image img;

//................................................................................................... I : CONSTRUCTEUR
	
	/**
  	 * Positionne les elements sur le panel
  	 *
  	 * @param l L'ecouteur qui permet de declencher une action en fonction de l'action de l'utilisateur
  	 */

	public PageAccueil(BlokusListener l) {

		this.setLayout(null);

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		parametres.setBounds((int)(width*0.01),(int)(height*0.775),(int)(width*0.105),(int)(height*0.115));
		parametres.setActionCommand("pageParametres");
		parametres.addActionListener(l);
		parametres.setBorderPainted(false);
		parametres.setContentAreaFilled(false);
		this.add(parametres);

		quitter.setBounds((int)(width*0.883),(int)(height*0.775),(int)(width*0.105),(int)(height*0.115));
		quitter.setActionCommand("quitter");
		quitter.addActionListener(l);
		quitter.setBorderPainted(false);
		quitter.setContentAreaFilled(false);
		this.add(quitter);

		mode4j.setBounds((int)(width*0.09),(int)(height*0.225),(int)(width*0.25),(int)(height*0.465));
		mode4j.setActionCommand("mode4j");
		mode4j.addActionListener(l);
		mode4j.setBorderPainted(false);
		mode4j.setContentAreaFilled(false);
		this.add(mode4j);

		mode8j.setBounds((int)(width*0.375),(int)(height*0.225),(int)(width*0.25),(int)(height*0.465));
		mode8j.setActionCommand("mode8j");
		mode8j.addActionListener(l);
		mode8j.setEnabled(false);
		mode8j.setBorderPainted(false);
		mode8j.setContentAreaFilled(false);
		this.add(mode8j);

		modeT.setBounds((int)(width*0.655),(int)(height*0.225),(int)(width*0.25),(int)(height*0.465));
		modeT.setActionCommand("modeT");
		modeT.addActionListener(l);
		modeT.setEnabled(false);
		modeT.setBorderPainted(false);
		modeT.setContentAreaFilled(false);
		this.add(modeT);

		img = new ImageIcon("../data/images/backgrounds/BackgroundAccueil.png").getImage();
	}

//................................................................................................... III : METHODES

	/**
	 * Cette méthode permet d'afficher un fond
	 *
	 * @param g L'objet graphique de la fenêtre
	 */
	
	public void paintComponent(Graphics g) {
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		g.drawImage(img, 0, 0, width, height, null);
	}
}