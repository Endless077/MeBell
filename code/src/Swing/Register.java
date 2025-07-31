package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connessione.DatabaseConnection;
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
	setName("Register");
	setTitle("Register");
	controller = ctrl;

	setMinimumSize(new Dimension(650, 430));
	setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	this.addWindowListener(new java.awt.event.WindowAdapter() {
	    @Override
	    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		if (JOptionPane.showConfirmDialog(null, 
			"Sei sicuro di chiudere il programma?", "Chiusura del programma", 
			JOptionPane.YES_NO_OPTION,
			JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION){
		    DatabaseConnection.Disconnessione();
		    System.exit(0);
		}
	    }
	});

	ImageIcon Icona = new ImageIcon(getClass().getResource("/Icons/LOGO.png"));
	this.setIconImage(Icona.getImage());
	setBounds(100, 100, 650, 430);
	contentPane = new JPanel();
	contentPane.setMinimumSize(new Dimension(533, 430));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblFirstName = new JLabel("First name");
	lblFirstName.setFont(new Font("Arial", Font.BOLD, 13));

	JLabel lblLastName = new JLabel("Last name");
	lblLastName.setFont(new Font("Arial", Font.BOLD, 13));

	JLabel lblUsername = new JLabel("Username");
	lblUsername.setFont(new Font("Arial", Font.BOLD, 13));

	JLabel lblPassword = new JLabel("Password");
	lblPassword.setFont(new Font("Arial", Font.BOLD, 13));

	JLabel lblReinsertPassword = new JLabel("Repat password");
	lblReinsertPassword.setFont(new Font("Arial", Font.BOLD, 13));

	JLabel lblControlloUsername = new JLabel("Il campo conterrà una lunghezza da 3 a 15 char alfanumerici.");
	lblControlloUsername.setForeground(Color.BLACK);
	JLabel lblControlloPassword = new JLabel("Il campo conterrà A-Z, a-z, 0-9 e almeno un @#$%.");
	lblControlloPassword.setForeground(Color.BLACK);

	textFirstN = new JTextField();
	textFirstN.setColumns(10);

	textLastN = new JTextField();
	textLastN.setColumns(10);

	textUserN = new JTextField();
	textUserN.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {

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
	    public void keyReleased(KeyEvent e) {

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
			    controller.aggiungiUtente(textUserN.getText(),textFirstN.getText(),textLastN.getText(),pass);

			    setVisible(false);
			    controller.resetCampiReg(textFirstN,textLastN,textUserN,passwordField,passwordFieldR);
			    controller.resetControlliReg(controlloUsername, controlloPassword, lblControlloUsername, lblControlloPassword);
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
		controller.resetCampiReg(textFirstN,textLastN,textUserN,passwordField,passwordFieldR);
		controller.resetControlliReg(controlloUsername, controlloPassword, lblControlloUsername, lblControlloPassword);
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

	JLabel labelFirstNameICON = new JLabel("");
	labelFirstNameICON.setIcon(new ImageIcon(Register.class.getResource("/Icons/FirstSecondNameICON.png")));

	JLabel labelSecondNameICON = new JLabel("");
	labelSecondNameICON.setIcon(new ImageIcon(Register.class.getResource("/Icons/FirstSecondNameICON.png")));
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addComponent(btnAnnulla)
			.addPreferredGap(ComponentPlacement.RELATED, 384, Short.MAX_VALUE)
			.addComponent(btnIscriviti)
			.addContainerGap())
		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(lblLastName)
				.addComponent(lblUsername)
				.addComponent(lblPassword)
				.addComponent(lblReinsertPassword)
				.addComponent(lblFirstName))
			.addGap(97)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelFirstNameICON)
						.addComponent(labelUsernameICON)
						.addComponent(labelSecondNameICON))
					.addGap(23))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(labelPassRepatICON, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassICON))
					.addGap(18)))
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(passwordFieldR, GroupLayout.DEFAULT_SIZE, 252, Short.MAX_VALUE))
						.addComponent(passwordField)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(lblControlloPassword, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
					.addGap(44))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(4)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textFirstN, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(lblControlloUsername, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(textUserN, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
						.addComponent(textLastN, GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE))))
			.addGap(19))
		);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 83, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
					.addComponent(textFirstN, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
					.addComponent(lblFirstName))
				.addComponent(labelFirstNameICON))
			.addGap(14)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(labelSecondNameICON)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLastName)
						.addComponent(textLastN, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addComponent(lblControlloUsername)))
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(labelUsernameICON)
				.addComponent(lblUsername)
				.addComponent(textUserN, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
			.addGap(39)
			.addComponent(lblControlloPassword)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(lblPassword)
					.addGap(4))
				.addComponent(lblPassICON, Alignment.TRAILING)
				.addComponent(passwordField, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(labelPassRepatICON, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(7)
						.addComponent(passwordFieldR, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
						.addGap(0, 0, Short.MAX_VALUE))
					.addGroup(gl_contentPane.createSequentialGroup()
						.addGap(8)
						.addComponent(lblReinsertPassword))))
			.addGap(11)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(btnAnnulla)
				.addComponent(btnIscriviti))
			.addContainerGap())
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