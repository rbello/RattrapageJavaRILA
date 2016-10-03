package fr.cesi.java.exo1;

import java.awt.EventQueue;
import java.util.Calendar;

public class UpdateJob implements Runnable {

	private WindowExo1 frame;

	public UpdateJob(WindowExo1 frame) {
		this.frame = frame;
	}
	
	public void start() {
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (true) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					Calendar now = Calendar.getInstance();
					frame.getTimeLabel().setText(String.format("%02d:%02d:%02d", now.get(Calendar.HOUR_OF_DAY),
							now.get(Calendar.MINUTE), now.get(Calendar.SECOND)));
				}
			});
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				return;
			}
		}
	}

}
