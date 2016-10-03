package fr.cesi.java.exo2;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFrame;

import fr.cesi.java.main.MessageConsole;

public class RunExo2 implements Runnable, ActionListener {

	private WindowExo2 frame;
	private File cd;

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
		frame.inputField.requestFocus();
		
		cd = new File(System.getProperty("user.home"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String[] tokens = frame.inputField.getText().split("\\s+", 2);
		frame.inputField.setText("");
		switch (tokens[0].toLowerCase()) {
		case "cd":
			if (tokens.length < 2) System.err.println("Erreur: il manque un paramètre");
			else function_cd(tokens[1]);
			break;
		case "pwd" :
			function_pwd();
			break;
		case "ls" : case "ll" :
			function_list();
			break;
			default:
				System.out.println("Commande inconnue: " + tokens[0]);
		}
	}

	private void function_pwd() {
		System.out.println(cd);
	}

	private void function_list() {
		System.out.println("List: " + cd);
		for (File sub : cd.listFiles()) {
			String type = sub.isDirectory() ? "Dir " : "File";
			System.out.print(String.format("%1$-30s", sub.getName()));
			System.out.println(String.format("%s %d", type, size(sub)));
		}
	}

	private void function_cd(String dir) {
		if (".".equals(dir)) {
			File f = cd;
			while (f.getParentFile() != null && f.getParentFile().isDirectory()) f = f.getParentFile();
			System.out.println("Nouveau chemin: " + f);
			cd = f;
		}
		else if ("..".equals(dir)) {
			File f = cd.getParentFile();
			if (f == null || !f.exists()) System.out.println("Erreur: pas de dossier parent");
			else {
				System.out.println("Nouveau chemin: " + f);
				cd = f;
			}
		}
		else {
			File f = new File(cd, dir);
			if (f.exists() && f.isDirectory()) {
				System.out.println("Nouveau chemin: " + f);
				cd = f;
			}
			else {
				System.out.println("Erreur: chemin non trouvé");
				System.out.println("  " + f);
			}
		}
	}

	public static long size(File f) {
		if (f == null) return 0;
		if (f.isFile()) return f.length();
		long length = 0;
		try {
			for (File sub : f.listFiles()) {
				if (sub == null) continue;
				length += size(sub);
			}
		}
		catch (Throwable t) {
		}
		return length;
	}

}