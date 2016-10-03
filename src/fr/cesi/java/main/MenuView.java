package fr.cesi.java.main;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import fr.cesi.java.exo1.RunExo1;
import fr.cesi.java.exo2.RunExo2;
import fr.cesi.java.exo3.RunExo3;
import fr.cesi.java.exo4.RunExo4;

public class MenuView extends JFrame {

	private static final long serialVersionUID = 6890407912708570463L;
	
	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public MenuView() {
		setTitle("Exercice de rattrapage Java");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("Exercice de rattrapage Java");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_1 = new JLabel(Main.NOM_DE_ETUDIANT);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		JButton btnExercice_1 = new JButton("Exercice 1");
		btnExercice_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RunExo1().run();
			}
		});
		JButton btnExercice_2 = new JButton("Exercice 2");
		btnExercice_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RunExo2().run();
			}
		});
		JButton btnExercice_3 = new JButton("Exercice 3");
		btnExercice_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RunExo3().run();
			}
		});
		JButton btnExercice_4 = new JButton("Exercice 4");
		btnExercice_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new RunExo4().run();
			}
		});
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 503, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(10)
					.addComponent(lblNewLabel_1, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(19)
					.addComponent(btnExercice_1, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExercice_2, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExercice_3, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnExercice_4, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNewLabel_1)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnExercice_1)
						.addComponent(btnExercice_2)
						.addComponent(btnExercice_3)
						.addComponent(btnExercice_4))
					.addContainerGap(249, Short.MAX_VALUE))
		);
		contentPane.setLayout(gl_contentPane);
	}
}
