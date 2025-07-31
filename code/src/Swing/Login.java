package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connessione.DatabaseConnection;
import Controller.Controller;

import javax.swing.GroupLayout;
import javax.swing.Icon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Login extends JFrame {

    private JPanel contentPane;
    private JTextField textUsername;
    private JPasswordField textPassword;
    private Controller controller;

    public Login(Controller ctrl) {
	setName("Login");
	setTitle("Login");
	controller= ctrl;

	setMinimumSize(new Dimension(400, 320));
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
	setBounds(100, 100, 400, 320);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JLabel lblUsername = new JLabel("Username");
	lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 13));

	JLabel lblPassword = new JLabel("Password");
	lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));

	textUsername = new JTextField();
	textUsername.setColumns(10);

	textPassword = new JPasswordField();
	textPassword.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
		    String pass = new String(textPassword.getPassword());
		    controller.loginTry(textUsername.getText(),pass);
		}
	    }
	});

	JButton btnLogin = new JButton("");
	btnLogin.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnLogin.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/LoginICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/LoginICON1.png")));
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/LoginICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnLogin.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/LoginICON1.png")));
	    }
	});
	btnLogin.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/LoginICON1.png")));
	btnLogin.setBorder(null);
	btnLogin.setContentAreaFilled(false);
	btnLogin.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent arg0) {
		String pass = new String(textPassword.getPassword());
		controller.loginTry(textUsername.getText(),pass);
	    }
	});

	JLabel lblNonSeiRegistrato = new JLabel("Non sei registrato?");

	JButton btnRegistrati = new JButton("");
	btnRegistrati.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnRegistrati.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnRegistrati.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/RegisterICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnRegistrati.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/RegisterICON1.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnRegistrati.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/RegisterICON1.png")));
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnRegistrati.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/RegisterICON2.png")));
	    }
	});
	btnRegistrati.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/RegisterICON1.png")));
	btnRegistrati.setBorder(null);
	btnRegistrati.setContentAreaFilled(false);
	btnRegistrati.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);
		controller.openRegister();
	    }
	});

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));

	JLabel lblUserICON = new JLabel("");
	lblUserICON.setIcon(new ImageIcon(Login.class.getResource("/Icons/UserICON.png")));

	JLabel labelPassICON = new JLabel("");
	labelPassICON.setIcon(new ImageIcon(Login.class.getResource("/Icons/PassICON.png")));
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUsername)
						.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblUserICON)
						.addComponent(labelPassICON))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(textPassword, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
						.addComponent(textUsername, GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(btnRegistrati, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 171, Short.MAX_VALUE)
					.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)))
			.addContainerGap())
		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 374, Short.MAX_VALUE)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addComponent(lblNonSeiRegistrato)
			.addContainerGap(274, Short.MAX_VALUE))
		);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
			.addGap(31)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE, false)
				.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE)
				.addComponent(textUsername, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
				.addComponent(lblUserICON))
			.addGap(32)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
				.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
				.addComponent(labelPassICON, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
				.addComponent(textPassword))
			.addPreferredGap(ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
			.addComponent(lblNonSeiRegistrato)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(btnLogin)
				.addComponent(btnRegistrati))
			.addContainerGap())
		);

	JLabel lblLogin = new JLabel("LOGIN");
	lblLogin.setForeground(new Color(255, 255, 255));
	lblLogin.setFont(new Font("Arial", Font.BOLD, 18));

	JLabel label = new JLabel("");
	label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	label.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		JOptionPane.showMessageDialog(null, "<html>Editor:<br/>Federico Gargiulo<br/>Antonio Garofalo</html>", "Informazioni", JOptionPane.WARNING_MESSAGE);		    
	    }
	});
	label.setIcon(new ImageIcon(Login.class.getResource("/Icons/InfoICON.png")));

	JLabel label_1 = new JLabel("");
	label_1.setIcon(new ImageIcon(Login.class.getResource("/Icons/MeBell.png")));
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addContainerGap()
			.addComponent(lblLogin)
			.addGap(27)
			.addComponent(label_1)
			.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
			.addComponent(label)
			.addContainerGap())
		);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.TRAILING)
		.addGroup(gl_panel.createSequentialGroup()
			.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(label))
				.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
					.addComponent(lblLogin, Alignment.LEADING)
					.addGroup(gl_panel.createSequentialGroup()
						.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(label_1))))
			.addContainerGap())
		);
	panel.setLayout(gl_panel);
	contentPane.setLayout(gl_contentPane);
    }
}
