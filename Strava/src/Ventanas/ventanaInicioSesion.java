package Ventanas;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class ventanaInicioSesion extends JFrame{
		private JPanel pCentro, p1, p2, p3, p4;
		private JLabel lblLog;
		private JButton btnLog, btnLog2, btnLog3;
		
		public ventanaInicioSesion() {
			
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
			
			btnLog = new JButton("LOG IN STRAVA");
			btnLog.setBounds(127, 152, 117, 29);
			p2.add(btnLog);
			
			pCentro.add(p3);
			
			btnLog2 = new JButton("LOG IN GOOGLE");
			btnLog2.setBounds(127, 152, 117, 29);
			p3.add(btnLog2);
			
			pCentro.add(p4);
			
			btnLog3 = new JButton("LOG IN FACEBOOK");
			btnLog3.setBounds(127, 152, 117, 29);
			p4.add(btnLog3);
			
			setVisible(true);
		}

}
