package fr.cesi.java.main;

import java.awt.EventQueue;

public class Main {

	public static final String NOM_DE_ETUDIANT = "Correction";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MenuView frame = new MenuView();
				frame.setVisible(true);
			}
		});
	}

}
