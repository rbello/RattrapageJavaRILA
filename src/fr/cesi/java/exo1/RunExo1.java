package fr.cesi.java.exo1;

import javax.swing.JFrame;

public class RunExo1 implements Runnable {

	@Override
	public void run() {
		WindowExo1 frame = new WindowExo1();
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setVisible(true);
		
		new UpdateJob(frame).start();
	}

}
