package view.pageMode8J;

import javax.swing.*;
import java.awt.*;
import control.BlokusListener;

/**
 * Fichier : PageMode8J.java
 * Date : 06/06/2016
 * Derniere mise a jour : 06/06/2016
 *
 *   Classe qui organise les elements graphiques de la page Mode8J.
 *
 * @author Maxime Pitussi
 * @version 1.0.0
 */

public class PageMode8J extends JPanel{
	
	JLabel name = new JLabel("BLOKUS");
	JButton tutoriel = new JButton("TUTORIEL");
	JButton parametres = new JButton("PARAMETRES");
	JButton accueil = new JButton("RETOUR ACCUEIL");
	JButton lancer = new JButton("LANCER LA PARTIE");

	JLabel j1 = new JLabel("JOUEUR 1");
	JLabel j2 = new JLabel("JOUEUR 2");
	JLabel j3 = new JLabel("JOUEUR 3");
	JLabel j4 = new JLabel("JOUEUR 4");
	JLabel j5 = new JLabel("JOUEUR 5");
	JLabel j6 = new JLabel("JOUEUR 6");
	JLabel j7 = new JLabel("JOUEUR 7");
	JLabel j8 = new JLabel("JOUEUR 8");

	JCheckBox bot1 = new JCheckBox("BOT");
	JCheckBox bot2 = new JCheckBox("BOT");
	JCheckBox bot3 = new JCheckBox("BOT");
	JCheckBox bot4 = new JCheckBox("BOT");
	JCheckBox bot5 = new JCheckBox("BOT");
	JCheckBox bot6 = new JCheckBox("BOT");
	JCheckBox bot7 = new JCheckBox("BOT");
	JCheckBox bot8 = new JCheckBox("BOT");

	JButton couleur1 = new JButton();
	JButton couleur2 = new JButton();
	JButton couleur3 = new JButton();
	JButton couleur4 = new JButton();
	JButton couleur5 = new JButton();
	JButton couleur6 = new JButton();
	JButton couleur7 = new JButton();
	JButton couleur8 = new JButton();

	String[] list = {"","EQUIPE 1", "EQUIPE 2", "EQUIPE 3", "EQUIPE 4", "EQUIPE 5", "EQUIPE 6", "EQUIPE 7", "EQUIPE 8"};
	JComboBox cb1 = new JComboBox(list);
	JComboBox cb2 = new JComboBox(list);
	JComboBox cb3 = new JComboBox(list);
	JComboBox cb4 = new JComboBox(list);
	JComboBox cb5 = new JComboBox(list);
	JComboBox cb6 = new JComboBox(list);
	JComboBox cb7 = new JComboBox(list);
	JComboBox cb8 = new JComboBox(list);

//................................................................................................... I : CONSTRUCTEUR
	
	/**
  	 * Positionne les elements sur le panel
  	 *
  	 * @param l  l'ecouteur qui permet de declencher une action en fonction de l'action de l'utilisateur
  	 */

	public PageMode8J(BlokusListener l) {

		this.setLayout(null);

		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
		int height = (int)dimension.getHeight(); //800
		int width  = (int)dimension.getWidth(); //1280

		name.setBounds((int)(width*0.48),(int)(height*0.05),80,100);
		this.add(name);

		tutoriel.setBounds((int)(width*0.86),(int)(height*0.75),(int)(width*0.12),(int)(height*0.13));
		tutoriel.setActionCommand("tutoriel8J");
		tutoriel.addActionListener(l);
		this.add(tutoriel);

		parametres.setBounds((int)(width*0.02),(int)(height*0.75),(int)(width*0.12),(int)(height*0.13));
		parametres.setActionCommand("pageParametres");
		parametres.addActionListener(l);
		this.add(parametres);

		accueil.setBounds((int)(width*0.08),(int)(height*0.0625),(int)(width*0.08),(int)(height*0.09));
		accueil.setActionCommand("pageAccueil");
		accueil.addActionListener(l);
		this.add(accueil);

		j1.setBounds((int)(width*0.20),(int)(height*0.20),(int)(width*0.1),(int)(height*0.1));
		this.add(j1);

		bot1.setBounds((int)(width*0.35),(int)(height*0.20),(int)(width*0.1),(int)(height*0.1));
		//bot1.setActionCommand("");
		//bot1.addActionListener(l);
		bot1.setFocusable(false);
		this.add(bot1);

		couleur1.setBounds((int)(width*0.50),(int)(height*0.225),(int)(width*0.1),(int)(height*0.05));
		couleur1.setBackground(Color.RED);
		couleur1.setOpaque(true);
		couleur1.setBorderPainted(false);
		//couleur1.setActionCommand("");
		//couleur1.addActionListener(l);
		this.add(couleur1);

		cb1.setBounds((int)(width*0.70),(int)(height*0.225),(int)(width*0.1),(int)(height*0.05));
		//cb1.setActionCommand("");
		//cb1.addActionListener(l);
		cb1.setFocusable(false);
		this.add(cb1);

		j2.setBounds((int)(width*0.20),(int)(height*0.25),(int)(width*0.1),(int)(height*0.1));
		this.add(j2);

		bot2.setBounds((int)(width*0.35),(int)(height*0.25),(int)(width*0.1),(int)(height*0.1));
		//bot2.setActionCommand("");
		//bot2.addActionListener(l);
		bot2.setFocusable(false);
		this.add(bot2);

		couleur2.setBounds((int)(width*0.50),(int)(height*0.275),(int)(width*0.1),(int)(height*0.05));
		couleur2.setBackground(Color.BLUE);
		couleur2.setOpaque(true);
		couleur2.setBorderPainted(false);
		//couleur2.setActionCommand("");
		//couleur2.addActionListener(l);
		this.add(couleur2);

		cb2.setBounds((int)(width*0.70),(int)(height*0.275),(int)(width*0.1),(int)(height*0.05));
		//cb2.setActionCommand("");
		//cb2.addActionListener(l);
		cb2.setFocusable(false);
		this.add(cb2);

		j3.setBounds((int)(width*0.20),(int)(height*0.30),(int)(width*0.1),(int)(height*0.1));
		this.add(j3);

		bot3.setBounds((int)(width*0.35),(int)(height*0.30),(int)(width*0.1),(int)(height*0.1));
		//bot3.setActionCommand("");
		//bot3.addActionListener(l);
		bot3.setFocusable(false);
		this.add(bot3);

		couleur3.setBounds((int)(width*0.50),(int)(height*0.325),(int)(width*0.1),(int)(height*0.05));
		couleur3.setBackground(Color.GREEN);
		couleur3.setOpaque(true);
		couleur3.setBorderPainted(false);
		//couleur3.setActionCommand("");
		//couleur3.addActionListener(l);
		this.add(couleur3);

		cb3.setBounds((int)(width*0.70),(int)(height*0.325),(int)(width*0.1),(int)(height*0.05));
		//cb3.setActionCommand("");
		//cb3.addActionListener(l);
		cb3.setFocusable(false);
		this.add(cb3);

		j4.setBounds((int)(width*0.20),(int)(height*0.35),(int)(width*0.1),(int)(height*0.1));
		this.add(j4);

		bot4.setBounds((int)(width*0.35),(int)(height*0.35),(int)(width*0.1),(int)(height*0.1));
		//bot4.setActionCommand("");
		//bot4.addActionListener(l);
		bot4.setFocusable(false);
		this.add(bot4);

		couleur4.setBounds((int)(width*0.50),(int)(height*0.375),(int)(width*0.1),(int)(height*0.05));
		couleur4.setBackground(Color.YELLOW);
		couleur4.setOpaque(true);
		couleur4.setBorderPainted(false);
		//couleur4.setActionCommand("");
		//couleur4.addActionListener(l);
		this.add(couleur4);

		cb4.setBounds((int)(width*0.70),(int)(height*0.375),(int)(width*0.1),(int)(height*0.05));
		//cb4.setActionCommand("");
		//cb4.addActionListener(l);
		cb4.setFocusable(false);
		this.add(cb4);

		j5.setBounds((int)(width*0.20),(int)(height*0.40),(int)(width*0.1),(int)(height*0.1));
		this.add(j5);

		bot5.setBounds((int)(width*0.35),(int)(height*0.40),(int)(width*0.1),(int)(height*0.1));
		//bot5.setActionCommand("");
		//bot5.addActionListener(l);
		bot5.setFocusable(false);
		this.add(bot5);

		couleur5.setBounds((int)(width*0.50),(int)(height*0.425),(int)(width*0.1),(int)(height*0.05));
		couleur5.setBackground(Color.MAGENTA);
		couleur5.setOpaque(true);
		couleur5.setBorderPainted(false);
		//couleur5.setActionCommand("");
		//couleur5.addActionListener(l);
		this.add(couleur5);

		cb5.setBounds((int)(width*0.70),(int)(height*0.425),(int)(width*0.1),(int)(height*0.05));
		//cb5.setActionCommand("");
		//cb5.addActionListener(l);
		cb5.setFocusable(false);
		this.add(cb5);

		j6.setBounds((int)(width*0.20),(int)(height*0.45),(int)(width*0.1),(int)(height*0.1));
		this.add(j6);

		bot6.setBounds((int)(width*0.35),(int)(height*0.45),(int)(width*0.1),(int)(height*0.1));
		//bot6.setActionCommand("");
		//bot6.addActionListener(l);
		bot6.setFocusable(false);
		this.add(bot6);

		couleur6.setBounds((int)(width*0.50),(int)(height*0.475),(int)(width*0.1),(int)(height*0.05));
		couleur6.setBackground(Color.CYAN);
		couleur6.setOpaque(true);
		couleur6.setBorderPainted(false);
		//couleur6.setActionCommand("");
		//couleur6.addActionListener(l);
		this.add(couleur6);

		cb6.setBounds((int)(width*0.70),(int)(height*0.475),(int)(width*0.1),(int)(height*0.05));
		//cb6.setActionCommand("");
		//cb6.addActionListener(l);
		cb6.setFocusable(false);
		this.add(cb6);

		j7.setBounds((int)(width*0.20),(int)(height*0.50),(int)(width*0.1),(int)(height*0.1));
		this.add(j7);

		bot7.setBounds((int)(width*0.35),(int)(height*0.50),(int)(width*0.1),(int)(height*0.1));
		//bot7.setActionCommand("");
		//bot7.addActionListener(l);
		bot7.setFocusable(false);
		this.add(bot7);

		couleur7.setBounds((int)(width*0.50),(int)(height*0.525),(int)(width*0.1),(int)(height*0.05));
		couleur7.setBackground(Color.ORANGE);
		couleur7.setOpaque(true);
		couleur7.setBorderPainted(false);
		//couleur7.setActionCommand("");
		//couleur7.addActionListener(l);
		this.add(couleur7);

		cb7.setBounds((int)(width*0.70),(int)(height*0.525),(int)(width*0.1),(int)(height*0.05));
		//cb7.setActionCommand("");
		//cb7.addActionListener(l);
		cb7.setFocusable(false);
		this.add(cb7);

		j8.setBounds((int)(width*0.20),(int)(height*0.55),(int)(width*0.1),(int)(height*0.1));
		this.add(j8);

		bot8.setBounds((int)(width*0.35),(int)(height*0.55),(int)(width*0.1),(int)(height*0.1));
		//bot8.setActionCommand("");
		//bot8.addActionListener(l);
		bot8.setFocusable(false);
		this.add(bot8);

		couleur8.setBounds((int)(width*0.50),(int)(height*0.575),(int)(width*0.1),(int)(height*0.05));
		couleur8.setBackground(Color.PINK);
		couleur8.setOpaque(true);
		couleur8.setBorderPainted(false);
		//couleur8.setActionCommand("");
		//couleur8.addActionListener(l);
		this.add(couleur8);

		cb8.setBounds((int)(width*0.70),(int)(height*0.575),(int)(width*0.1),(int)(height*0.05));
		//cb8.setActionCommand("");
		//cb8.addActionListener(l);
		cb8.setFocusable(false);
		this.add(cb8);

		lancer.setBounds((int)(width*0.40),(int)(height*0.75),(int)(width*0.2),(int)(height*0.13));
		lancer.setActionCommand("lancer8J");
		lancer.addActionListener(l);
		this.add(lancer);
	}

	public boolean bot1(){
		return bot1.isSelected();
	}

	public boolean bot2(){
		return bot2.isSelected();
	}

	public boolean bot3(){
		return bot3.isSelected();
	}

	public boolean bot4(){
		return bot4.isSelected();
	}

	public boolean bot5(){
		return bot5.isSelected();
	}

	public boolean bot6(){
		return bot6.isSelected();
	}

	public boolean bot7(){
		return bot7.isSelected();
	}

	public boolean bot8(){
		return bot8.isSelected();
	}

	public int equipeJ1(){
		int ret = 0;
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 5")) {
			ret = 5;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 6")) {
			ret = 6;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 7")) {
			ret = 7;
		}
		if (((String)cb1.getSelectedItem()).equals("EQUIPE 8")) {
			ret = 8;
		}
		return ret;
	}

	public int equipeJ2(){
		int ret = 0;
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 5")) {
			ret = 5;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 6")) {
			ret = 6;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 7")) {
			ret = 7;
		}
		if (((String)cb2.getSelectedItem()).equals("EQUIPE 8")) {
			ret = 8;
		}
		return ret;
	}

	public int equipeJ3(){
		int ret = 0;
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 5")) {
			ret = 5;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 6")) {
			ret = 6;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 7")) {
			ret = 7;
		}
		if (((String)cb3.getSelectedItem()).equals("EQUIPE 8")) {
			ret = 8;
		}
		return ret;
	}

	public int equipeJ4(){
		int ret = 0;
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 5")) {
			ret = 5;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 6")) {
			ret = 6;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 7")) {
			ret = 7;
		}
		if (((String)cb4.getSelectedItem()).equals("EQUIPE 8")) {
			ret = 8;
		}
		return ret;
	}

	public int equipeJ5(){
		int ret = 0;
		if (((String)cb5.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb5.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb5.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb5.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		if (((String)cb5.getSelectedItem()).equals("EQUIPE 5")) {
			ret = 5;
		}
		if (((String)cb5.getSelectedItem()).equals("EQUIPE 6")) {
			ret = 6;
		}
		if (((String)cb5.getSelectedItem()).equals("EQUIPE 7")) {
			ret = 7;
		}
		if (((String)cb5.getSelectedItem()).equals("EQUIPE 8")) {
			ret = 8;
		}
		return ret;
	}

	public int equipeJ6(){
		int ret = 0;
		if (((String)cb6.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb6.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb6.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb6.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		if (((String)cb6.getSelectedItem()).equals("EQUIPE 5")) {
			ret = 5;
		}
		if (((String)cb6.getSelectedItem()).equals("EQUIPE 6")) {
			ret = 6;
		}
		if (((String)cb6.getSelectedItem()).equals("EQUIPE 7")) {
			ret = 7;
		}
		if (((String)cb6.getSelectedItem()).equals("EQUIPE 8")) {
			ret = 8;
		}
		return ret;
	}

	public int equipeJ7(){
		int ret = 0;
		if (((String)cb7.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb7.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb7.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb7.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		if (((String)cb7.getSelectedItem()).equals("EQUIPE 5")) {
			ret = 5;
		}
		if (((String)cb7.getSelectedItem()).equals("EQUIPE 6")) {
			ret = 6;
		}
		if (((String)cb7.getSelectedItem()).equals("EQUIPE 7")) {
			ret = 7;
		}
		if (((String)cb7.getSelectedItem()).equals("EQUIPE 8")) {
			ret = 8;
		}
		return ret;
	}

	public int equipeJ8(){
		int ret = 0;
		if (((String)cb8.getSelectedItem()).equals("EQUIPE 1")) {
			ret = 1;
		}
		if (((String)cb8.getSelectedItem()).equals("EQUIPE 2")) {
			ret = 2;
		}
		if (((String)cb8.getSelectedItem()).equals("EQUIPE 3")) {
			ret = 3;
		}
		if (((String)cb8.getSelectedItem()).equals("EQUIPE 4")) {
			ret = 4;
		}
		if (((String)cb8.getSelectedItem()).equals("EQUIPE 5")) {
			ret = 5;
		}
		if (((String)cb8.getSelectedItem()).equals("EQUIPE 6")) {
			ret = 6;
		}
		if (((String)cb8.getSelectedItem()).equals("EQUIPE 7")) {
			ret = 7;
		}
		if (((String)cb8.getSelectedItem()).equals("EQUIPE 8")) {
			ret = 8;
		}
		return ret;
	}
}