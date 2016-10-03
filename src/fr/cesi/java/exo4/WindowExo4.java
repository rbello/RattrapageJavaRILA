package fr.cesi.java.exo4;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class WindowExo4 extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	public JTextField inputField;
	public JLabel outputField;

	/**
	 * Create the frame.
	 */
	public WindowExo4() {
		setTitle("Calcultatrice II");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 128);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		inputField = new JTextField();
		inputField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		inputField.setColumns(10);
		
		outputField = new JLabel("-");
		outputField.setFont(new Font("Tahoma", Font.PLAIN, 19));
		outputField.setHorizontalAlignment(SwingConstants.RIGHT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(outputField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
				.addComponent(inputField, GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(outputField, GroupLayout.DEFAULT_SIZE, 31, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(inputField, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		contentPane.setLayout(gl_contentPane);
	}

}
