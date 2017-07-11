package view.pageParametres;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : PageMentionsLegales.java
 * Date : 06/06/2016
 * Derniere mise a jour : 22/06/2016
 *
 *   Classe qui organise les elements graphiques de la page PageMentionsLegales.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageMentionsLegales extends JPanel{

//................................................................................................... I : EN-TÊTE

	/** Image utilisée pour donner un fond au menu */

	private Image img;

	/** Bouton permettant d'accéder aux paramètres */

	private JButton param = new JButton();

//................................................................................................... II : CONSTRUCTEUR
	
	/**
  	 * Positionne les éléments sur le panel
  	 *
  	 * @param l L'écouteur qui permet de déclencher une action en fonction de l'action de l'utilisateur
  	 */

	public PageMentionsLegales(BlokusListener l) {

		this.setLayout(null);

		img = new ImageIcon("../data/images/backgrounds/BackgroundMentions.png").getImage();

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		param.setBounds((int)(width*0.475),(int)(height*0.122),(int)(width*0.062),(int)(height*0.09));
		param.setActionCommand("pageParametres");
		param.addActionListener(l);
		param.setBorderPainted(false);
		param.setContentAreaFilled(false);
		this.add(param);
	}

//................................................................................................... III : METHODES
	
	/**
	 * Cette méthode permet de dessiner un fond dans la fenêtre
	 * @param g Le composant graphique de la fenêtre
	 */
		
	public void paintComponent(Graphics g) {
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		g.drawImage(img, 0, 0, width, height, null);
	}
}
