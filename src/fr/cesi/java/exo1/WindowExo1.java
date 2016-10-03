package fr.cesi.java.exo1;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class WindowExo1 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JLabel timeLabel;

	/**
	 * Create the frame.
	 */
	public WindowExo1() {
		setTitle("Clock");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 261, 167);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		timeLabel = new JLabel("--:--:--");
		timeLabel.setFont(new Font("OCR A Extended", Font.PLAIN, 28));
		timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(timeLabel, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE)
		);
		contentPane.setLayout(gl_contentPane);
	}
	
	public JLabel getTimeLabel() {
		return timeLabel;
	}
	
}
