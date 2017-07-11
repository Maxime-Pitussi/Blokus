package view.pageMode8J;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : Tutoriel8J.java
 * Date : 06/06/2016
 * Derniere mise a jour : 06/06/2016
 *
 *   Classe qui organise les elements graphiques de la page Tutoriel8J.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class Tutoriel8J extends JPanel{
	
	JLabel name = new JLabel("BLOKUS");
	JButton accueil = new JButton("RETOUR ACCUEIL");

//................................................................................................... I : CONSTRUCTEUR
	
	/**
  	 * Positionne les elements sur le panel
  	 *
  	 * @param l  l'ecouteur qui permet de declencher une action en fonction de l'action de l'utilisateur
  	 */

	public Tutoriel8J(BlokusListener l) {

		this.setLayout(null);

		name.setBounds(100,300,100,100);
		this.add(name);

		accueil.setBounds(800,300,200,100);
		accueil.setActionCommand("pageAccueil");
		accueil.addActionListener(l);
		this.add(accueil);
	}
}