package fr.cesi.java.exo4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

public class RunExo4 implements Runnable, ActionListener {

	private WindowExo4 frame;

	@Override
	public void run() {
		frame = new WindowExo4();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// Quand on appuie sur Entrée dans le champ de saisie
		frame.inputField.addActionListener(this);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			Operation grp = new Operation(frame.inputField.getText());
			frame.outputField.setText(String.format("%.4f", grp.solve()));
		}
		catch (Throwable t) {
			frame.outputField.setText("ERR");
		}
		frame.inputField.setText("");
	}

}