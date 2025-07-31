package SwingDialog;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Swing.LocationPage;
import Swing.Login;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class InserisciRecensione extends JDialog {

    private final JPanel contentPanel = new JPanel();
    private Controller controller;
    private JTextField textTitolo;
    private JTextArea textRecensione;

    private int voto=5;
    boolean controlloTitolo=false;
    boolean controlloTesto=true;

    private JLabel lblCountTitolo;
    private JLabel lblCountTesto;

    private JButton stella1;
    private JButton stella2;
    private JButton stella3;
    private JButton stella4;
    private JButton stella5;

    public InserisciRecensione(Controller ctrl) {
	setName("Insert");
	controller=ctrl;
	setUndecorated(true);
	setBounds(100, 100, 450, 300);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));
	panel.setBounds(0, 0, 450, 300);
	contentPanel.add(panel);
	panel.setLayout(null);

	JButton btnAnnulla = new JButton("");
	btnAnnulla.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAnnulla.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		controller.openVediRecensioni();
		setVisible(false);
		controller.resetCampiInsertModify(textRecensione, textTitolo, lblCountTitolo, lblCountTesto, controlloTitolo, controlloTitolo);

	    }
	});
	btnAnnulla.setBorder(null);
	btnAnnulla.setContentAreaFilled(false);
	btnAnnulla.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/ButtonIcon/AnnullaICON1.png")));
	btnAnnulla.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnAnnulla.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/AnnullaICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnAnnulla.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/AnnullaICON1.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnAnnulla.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/AnnullaICON1.png")));
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnAnnulla.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/AnnullaICON2.png")));
	    }
	});

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(10, 125, 430, 82);
	panel.add(scrollPane);

	textRecensione = new JTextArea();
	scrollPane.setViewportView(textRecensione);
	textRecensione.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		controlloTesto = controller.controlloTestoRecensione(textRecensione.getText());
		int countTesto = controller.conteggioChar(textRecensione.getText());

		if(controlloTesto) {
		    lblCountTesto.setForeground(Color.BLACK);
		    lblCountTesto.setText("Testo: "+countTesto+"/250");
		}else {
		    lblCountTesto.setForeground(Color.RED);
		    lblCountTesto.setText("Hai superato i 250 caratteri.");
		}
	    }
	});
	textRecensione.setRows(3);
	textRecensione.setLineWrap(true);
	btnAnnulla.setBounds(351, 266, 89, 23);
	panel.add(btnAnnulla);

	JButton btnConferma = new JButton("");
	btnConferma.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnConferma.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(controlloTesto && controlloTitolo) {
		    int n = JOptionPane.showConfirmDialog(
			    null,
			    "Sei sicuro di voler inserire la recensione?",
			    "Conferma inserimento",
			    JOptionPane.YES_NO_OPTION);

		    if(n==0) {
			controller.inserisciRecensione(textTitolo, textRecensione, voto);
			controller.updateSistema();
			setVisible(false);
			controller.resetCampiInsertModify(textRecensione, textTitolo, lblCountTitolo, lblCountTesto, controlloTitolo, controlloTitolo);
			controller.openVediRecensioni();

		    }
		}else {
		    JOptionPane.showMessageDialog(null, "Compila i campi", "Errore", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});
	btnConferma.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/ButtonIcon/ConfermaICON1.png")));
	btnConferma.setBorder(null);
	btnConferma.setContentAreaFilled(false);
	btnConferma.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnConferma.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/ConfermaICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnConferma.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/ConfermaICON1.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnConferma.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/ConfermaICON1.png")));
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnConferma.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/ConfermaICON2.png")));
	    }
	});
	btnConferma.setBounds(252, 266, 89, 23);
	panel.add(btnConferma);

	textTitolo = new JTextField();
	textTitolo.addKeyListener(new KeyAdapter() {
	    @Override
	    public void keyReleased(KeyEvent e) {
		controlloTitolo = controller.controlloTitoloRecensione(textTitolo.getText());
		int countTitolo = controller.conteggioChar(textTitolo.getText());

		if(controlloTitolo) {
		    lblCountTitolo.setForeground(Color.BLACK);
		    lblCountTitolo.setText("Titolo: "+countTitolo+"/25");
		}else {
		    lblCountTitolo.setForeground(Color.RED);
		    lblCountTitolo.setText("Hai superato i 25 caratteri o testo corto.");
		}

	    }
	});
	textTitolo.setBounds(10, 66, 430, 20);
	panel.add(textTitolo);
	textTitolo.setColumns(10);

	stella1 = new JButton("");
	stella1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	stella1.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		voto=1;
		stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
		stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
		stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
		stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));

	    }
	});
	stella1.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/ButtonIcon/Stella1.png")));
	stella1.setContentAreaFilled(false);
	stella1.setBorder(null);
	stella1.setBounds(311, 218, 21, 21);
	panel.add(stella1);

	stella2 = new JButton("");
	stella2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	stella2.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		voto=2;
		stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
		stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
		stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    }
	});
	stella2.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/ButtonIcon/Stella1.png")));
	stella2.setContentAreaFilled(false);
	stella2.setBorder(null);
	stella2.setBounds(338, 218, 21, 21);
	panel.add(stella2);

	stella3 = new JButton("");
	stella3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	stella3.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		voto=3;
		stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
		stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    }
	});
	stella3.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/ButtonIcon/Stella1.png")));
	stella3.setContentAreaFilled(false);
	stella3.setBorder(null);
	stella3.setBounds(365, 218, 21, 21);
	panel.add(stella3);

	stella4 = new JButton("");
	stella4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	stella4.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		voto=4;
		stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    }
	});
	stella4.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/ButtonIcon/Stella1.png")));
	stella4.setContentAreaFilled(false);
	stella4.setBorder(null);
	stella4.setBounds(392, 218, 21, 21);
	panel.add(stella4);

	stella5 = new JButton("");
	stella5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	stella5.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		voto=5;
		stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
		stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    }
	});
	stella5.setIcon(new ImageIcon(InserisciRecensione.class.getResource("/ButtonIcon/Stella1.png")));
	stella5.setContentAreaFilled(false);
	stella5.setBorder(null);
	stella5.setBounds(419, 218, 21, 21);
	panel.add(stella5);

	JLabel lblDescrizione = new JLabel("Descrizione");
	lblDescrizione.setHorizontalAlignment(SwingConstants.CENTER);
	lblDescrizione.setFont(new Font("Arial", Font.BOLD, 15));
	lblDescrizione.setBounds(142, 100, 146, 14);
	panel.add(lblDescrizione);

	JLabel lblTitoloRecensione = new JLabel("Titolo Recensione");
	lblTitoloRecensione.setHorizontalAlignment(SwingConstants.CENTER);
	lblTitoloRecensione.setFont(new Font("Arial", Font.BOLD, 15));
	lblTitoloRecensione.setBounds(142, 41, 146, 14);
	panel.add(lblTitoloRecensione);

	JPanel panelTitle = new JPanel();
	panelTitle.setBackground(Color.RED);
	panelTitle.setBounds(0, 0, 450, 30);
	panel.add(panelTitle);

	JLabel label = new JLabel("Inserisci Recensione");
	label.setForeground(Color.WHITE);
	label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
	panelTitle.add(label);

	lblCountTitolo = new JLabel("Titolo: 0/25");
	lblCountTitolo.setFont(new Font("Arial", Font.PLAIN, 15));
	lblCountTitolo.setBounds(10, 218, 298, 14);
	panel.add(lblCountTitolo);

	lblCountTesto = new JLabel("Testo: 0/250");
	lblCountTesto.setFont(new Font("Arial", Font.PLAIN, 15));
	lblCountTesto.setBounds(10, 243, 298, 14);
	panel.add(lblCountTesto);
    }

    public JLabel getLblCountTitolo() {
	return lblCountTitolo;
    }

    public void setLblCountTitolo(JLabel lblCountTitolo) {
	this.lblCountTitolo = lblCountTitolo;
    }

    public JLabel getLblCountTesto() {
	return lblCountTesto;
    }

    public void setLblCountTesto(JLabel lblCountTesto) {
	this.lblCountTesto = lblCountTesto;
    }
}
