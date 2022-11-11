package Ventanas;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ventanaLog extends JFrame{
	private JPanel pCentro, p1, p2, p3, p4;
	private JLabel lblLog, lblEmail,lblContrasenia;
	private JTextField txtEmail, txtContrasenia;
	private JButton btnLog;
	
	public ventanaLog() {
		
		setBounds(425, 150, 800, 408);
		setTitle("Log In");
		setResizable(false);
		
		pCentro = new JPanel(new GridLayout(4,1));
		
		p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p3 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		p4 = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		pCentro.add(p1);
		
		lblLog = new JLabel("LOG IN");
		lblLog.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblLog.setBounds(128, 40, 154, 16);
		p1.add(lblLog);
		
		pCentro.add(p2);
		
		lblEmail = new JLabel("Email :");
		lblEmail.setBounds(69, 53, 61, 16);
		p2.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(127, 48, 195, 26);
		p2.add(txtEmail);
		txtEmail.setColumns(10);
		
		pCentro.add(p3);
		
		lblContrasenia = new JLabel("Contraseña :");
		lblContrasenia.setBounds(69, 98, 85, 16);
		p3.add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(162, 93, 160, 26);
		p3.add(txtContrasenia);
		txtContrasenia.setColumns(10);
		
		pCentro.add(p4);
		
		btnLog = new JButton("Iniciar sesion");
		btnLog.setBounds(127, 152, 117, 29);
		p4.add(btnLog);
		
		setVisible(true);
	}

}
