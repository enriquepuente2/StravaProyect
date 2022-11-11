package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class ventanaLog extends JFrame{
	private JTextField txtEmail;
	private JTextField txtContrasenia;
	
	public ventanaLog() {
		
		setBounds(425, 150, 800, 408);
		
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(2, 2, 0, 0));
		
		txtEmail = new JTextField();
		txtEmail.setText("E-mail");
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		panel.add(textArea);
		
		txtContrasenia = new JTextField();
		txtContrasenia.setText("Contrasenia");
		panel.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		JTextArea textArea_1 = new JTextArea();
		panel.add(textArea_1);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.NORTH);
		
		JTextArea txtrLogin = new JTextArea();
		txtrLogin.setText("LOG IN");
		panel_1.add(txtrLogin);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Log in");
		panel_2.add(btnNewButton);
		
		setVisible(true);
	}

}
