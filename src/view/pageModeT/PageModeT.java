package view.pageModeT;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : PageModeT.java
 * Date : 06/06/2016
 * Derniere mise a jour : 06/06/2016
 *
 *   Classe qui organise les elements graphiques de la page ModeT.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageModeT extends JPanel{
	
	JLabel name = new JLabel("BLOKUS");
	JButton tutoriel = new JButton("TUTORIEL");
	JButton parametres = new JButton("PARAMETRES");
	JButton accueil = new JButton("RETOUR ACCUEIL");

//................................................................................................... I : CONSTRUCTEUR
	
	/**
  	 * Positionne les elements sur le panel
  	 *
  	 * @param l  l'ecouteur qui permet de declencher une action en fonction de l'action de l'utilisateur
  	 */

	public PageModeT(BlokusListener l) {

		this.setLayout(null);

		name.setBounds(100,300,100,100);
		this.add(name);

		tutoriel.setBounds(400,300,200,100);
		tutoriel.setActionCommand("tutorielT");
		tutoriel.addActionListener(l);
		this.add(tutoriel);

		parametres.setBounds(600,300,200,100);
		parametres.setActionCommand("pageParametres");
		parametres.addActionListener(l);
		this.add(parametres);

		accueil.setBounds(800,300,200,100);
		accueil.setActionCommand("pageAccueil");
		accueil.addActionListener(l);
		this.add(accueil);
	}
}