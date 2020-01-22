package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField textFirstN;
	private JTextField textLastN;
	private JTextField textUserN;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldR;
	private Controller controller;
	
	private boolean controlloUsername=false;
	private boolean controlloPassword=false;

	public Register(Controller ctrl) {
		setTitle("Register");
	    	controller = ctrl;

		setMinimumSize(new Dimension(550, 430));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 430);
		contentPane = new JPanel();
		contentPane.setMinimumSize(new Dimension(533, 430));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JLabel lblFirstName = new JLabel("First name");

		JLabel lblLastName = new JLabel("Last name");

		JLabel lblUsername = new JLabel("Username");

		JLabel lblPassword = new JLabel("Password");

		JLabel lblReinsertPassword = new JLabel("Repat password");
		
		JLabel lblControlloUsername = new JLabel("Il campo conterr\u00E0 una lunghezza da 3 a 15 char alfanumerici.");
		
		JLabel lblControlloPassword = new JLabel("Il campo conterr� A-Z, a-z, 0-9 e almeno un @#$%.");

		textFirstN = new JTextField();
		textFirstN.setColumns(10);

		textLastN = new JTextField();
		textLastN.setColumns(10);

		textUserN = new JTextField();
		textUserN.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
			  	 if(!controller.controlloUsername(textUserN)) {
    			  	     lblControlloUsername.setForeground(Color.RED); 
    			  	     lblControlloUsername.setText("Errore, l'username non rispetta gli standard.");
    			  	     controlloUsername=false;
			  	 }else {
			  	     lblControlloUsername.setForeground(Color.GREEN); 
			  	     lblControlloUsername.setText("L'username rispetta gli standard.");
			  	     controlloUsername=true;
			  	 }
			  
			}
		});
		textUserN.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			    
			    if(!controller.controlloPass(passwordField)) {
				lblControlloPassword.setForeground(Color.RED); 
				lblControlloPassword.setText("Errore, la password non rispetta gli standard.");
				controlloPassword=false;
			    }else {
				lblControlloPassword.setForeground(Color.GREEN); 
				lblControlloPassword.setText("La password rispetta gli standard.");
				controlloPassword=true;
			    }
			}
		});
		passwordField.setToolTipText("");

		passwordFieldR = new JPasswordField();
		passwordFieldR.setToolTipText("");

		JButton btnIscriviti = new JButton("");
		btnIscriviti.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnIscriviti.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			    btnIscriviti.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/IscrivitiICON2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			    btnIscriviti.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/IscrivitiICON1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
			    btnIscriviti.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/IscrivitiICON3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			    btnIscriviti.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/IscrivitiICON1.png")));
			}
		});
		btnIscriviti.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/IscrivitiICON1.png")));
		btnIscriviti.setBorder(null);
		btnIscriviti.setContentAreaFilled(false);
		btnIscriviti.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			if(!textFirstN.getText().isEmpty() && !textLastN.getText().isEmpty()) {
			    if(controlloUsername && controlloPassword) {
				if(controller.isPassEqual(passwordField.getPassword(),passwordFieldR.getPassword())){
				    String pass = new String(passwordField.getPassword());
				    controller.aggiungiUtente(textFirstN.getText(),textLastN.getText(),textUserN.getText(),pass);
				    setVisible(false);
				    controller.openLogin();
				}else {
				    JOptionPane.showMessageDialog(null, "Le password non corrispondono", "Errore corrispondenza password", JOptionPane.ERROR_MESSAGE);
				}
			    }else {
				JOptionPane.showMessageDialog(null, "Campi username o password non rispettano gli standard.", "Errore Username o Password", JOptionPane.ERROR_MESSAGE);
			    }
			}else {

			    JOptionPane.showMessageDialog(null, "Campi nome e cognome non possono essere vuoti.", "Errore Anagrafico", JOptionPane.ERROR_MESSAGE);
			}
		    }

		});

		JButton btnAnnulla = new JButton("");
		btnAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAnnulla.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
			    btnAnnulla.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/AnnullaICON2.png")));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			    btnAnnulla.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/AnnullaICON1.png")));
			}
			@Override
			public void mousePressed(MouseEvent e) {
			    btnAnnulla.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/AnnullaICON3.png")));
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			    btnAnnulla.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/AnnullaICON1.png")));
			}
		});
		btnAnnulla.setIcon(new ImageIcon(Register.class.getResource("/ButtonIcon/AnnullaICON1.png")));
		btnAnnulla.setBorder(null);
		btnAnnulla.setContentAreaFilled(false);
		btnAnnulla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				controller.openLogin();
			}
		});
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 102, 0));
		
		JLabel labelUsernameICON = new JLabel("");
		labelUsernameICON.setIcon(new ImageIcon(Register.class.getResource("/Icons/UserICON.png")));
		
		JLabel lblPassICON = new JLabel("");
		lblPassICON.setIcon(new ImageIcon(Register.class.getResource("/Icons/PassICON.png")));
		
		JLabel labelPassRepatICON = new JLabel("");
		labelPassRepatICON.setIcon(new ImageIcon(Register.class.getResource("/Icons/PassICON.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnAnnulla)
					.addPreferredGap(ComponentPlacement.RELATED, 217, Short.MAX_VALUE)
					.addComponent(btnIscriviti)
					.addContainerGap())
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 403, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblFirstName)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblPassword)
									.addComponent(lblReinsertPassword))
								.addGap(27)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
									.addComponent(lblPassICON)
									.addComponent(labelPassRepatICON, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)))
							.addGroup(gl_contentPane.createSequentialGroup()
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
									.addComponent(lblLastName)
									.addComponent(lblUsername))
								.addGap(56)
								.addComponent(labelUsernameICON))))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textLastN, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
								.addComponent(textFirstN, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
								.addComponent(lblControlloUsername)
								.addComponent(textUserN, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(passwordFieldR, GroupLayout.DEFAULT_SIZE, 248, Short.MAX_VALUE)
								.addComponent(lblControlloPassword))))
					.addContainerGap())
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(textFirstN, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblFirstName))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(textLastN, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(lblControlloUsername)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(labelUsernameICON)
						.addComponent(textUserN, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addComponent(lblPassICON)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addComponent(lblPassword)
									.addGap(6))
								.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(10)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblReinsertPassword)
										.addComponent(passwordFieldR, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE))
									.addGap(11)
									.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(btnAnnulla)
										.addComponent(btnIscriviti)))
								.addComponent(labelPassRepatICON, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
							.addContainerGap())
						.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
							.addComponent(lblControlloPassword)
							.addGap(104))))
		);
		
		JLabel lblRegister = new JLabel("REGISTER");
		lblRegister.setForeground(new Color(255, 255, 255));
		lblRegister.setFont(new Font("Arial", Font.BOLD, 18));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblRegister)
					.addContainerGap(290, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addComponent(lblRegister)
					.addContainerGap(61, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);

	}
}