package Ventanas;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class ventanaRegGoogle extends JFrame{
	private JTextField textField;
	private JTextField textField_1;
	public ventanaRegGoogle() {
		
		setBounds(425, 150, 800, 408);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JTextArea txtrRegistroGoogle = new JTextArea();
		txtrRegistroGoogle.setText("REGISTRO GOOGLE");
		panel.add(txtrRegistroGoogle);
		
		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 2, 0, 0));
		
		JTextArea txtrEmail = new JTextArea();
		txtrEmail.setText("E-mail");
		panel_1.add(txtrEmail);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JTextArea txtrContrasenia = new JTextArea();
		txtrContrasenia.setText("Contrasenia");
		panel_1.add(txtrContrasenia);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Registrar");
		panel_2.add(btnNewButton);
	
		setVisible(true);

	}
}
