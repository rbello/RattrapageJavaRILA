package fr.cesi.java.exo2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import fr.cesi.java.main.MessageConsole;

public class RunExo2 implements Runnable, ActionListener {

	private WindowExo2 frame;

	@Override
	public void run() {
		
		frame = new WindowExo2();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		// Redirection de System.out vers la console de la fenêtre
		MessageConsole mc = new MessageConsole(frame.outputField);
		mc.redirectOut();
		mc.redirectErr(Color.RED, null);
		
		// Quand on appuie sur Entrée dans le champ de saisie
		frame.inputField.addActionListener(this);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("TODO");
		frame.inputField.setText("");
	}

}