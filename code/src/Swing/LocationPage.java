package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connessione.DatabaseConnection;
import Controller.Controller;
import Utility.ModelloTabella;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import javax.swing.JScrollPane;
import java.awt.Cursor;
import javax.swing.ScrollPaneConstants;

public class LocationPage extends JFrame {

    private JPanel contentPane;
    private Controller controller;

    private JLabel labelImmagineLocation;
    private JLabel lblNomeLoc;
    private JLabel lblCategoria;
    private JLabel lblIndirizzo;
    private JLabel lblPiva;
    private JTextArea txtrDescrizione;
    private JTextArea txtrInfoServizi;
    private JLabel stella1;
    private JLabel stella2;
    private JLabel stella3;
    private JLabel stella4;
    private JLabel stella5;

    public LocationPage(Controller ctrl) {
	setName("Location_Page");
	setTitle("Location Page");
	setMinimumSize(new Dimension(820, 482));
	controller=ctrl;
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
	setBounds(100, 100, 855, 572);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));

	JPanel panelIMG = new JPanel();
	panelIMG.setBackground(new Color(0, 0, 0));

	JButton btnBack = new JButton("");
	btnBack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnBack.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON1.png")));
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON1.png")));
	    }
	});
	btnBack.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/IndietroICON1.png")));
	btnBack.setBorder(null);
	btnBack.setContentAreaFilled(false);
	btnBack.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);
		controller.openHomePage();
	    }
	});

	lblNomeLoc = new JLabel("Location Name");
	lblNomeLoc.setForeground(Color.RED);
	lblNomeLoc.setFont(new Font("Arial", Font.BOLD, 20));

	JButton btnVediRecensioni = new JButton("");
	btnVediRecensioni.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);
		controller.riempiTabellaRecensioni();
		controller.openVediRecensioni();
	    }
	});
	btnVediRecensioni.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnVediRecensioni.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON1.png")));
	    }
	});
	btnVediRecensioni.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/VediRecensioniICON1.png")));
	btnVediRecensioni.setBorder(null);
	btnVediRecensioni.setContentAreaFilled(false);

	lblIndirizzo = new JLabel("Via, Civico, CAP, Comune");
	lblIndirizzo.setFont(new Font("Arial", Font.PLAIN, 16));

	stella1 = new JLabel("");
	stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));

	stella2 = new JLabel("");
	stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));

	stella3 = new JLabel("");
	stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));

	stella4 = new JLabel("");
	stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));

	stella5 = new JLabel("");
	stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));

	lblCategoria = new JLabel("Categoria:");
	lblCategoria.setFont(new Font("Arial", Font.BOLD, 14));

	lblPiva = new JLabel("P.IVA");

	JScrollPane scrollPaneInfo = new JScrollPane();
	scrollPaneInfo.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	JScrollPane scrollPaneDescrizione = new JScrollPane();

	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 794, Short.MAX_VALUE)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(panelIMG, GroupLayout.PREFERRED_SIZE, 196, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
					.addComponent(lblPiva, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createSequentialGroup()
						.addComponent(stella1, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(stella2, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(stella3, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(stella4, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(stella5, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addGap(18)
						.addComponent(lblCategoria)))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblIndirizzo, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
						.addComponent(lblNomeLoc, GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE))
					.addGap(175)))
			.addGap(46))
		.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneDescrizione, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnBack, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 565, Short.MAX_VALUE)
					.addComponent(btnVediRecensioni, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)))
			.addContainerGap())
		.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addComponent(scrollPaneInfo, GroupLayout.DEFAULT_SIZE, 774, Short.MAX_VALUE)
			.addContainerGap())
		);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(panelIMG, GroupLayout.PREFERRED_SIZE, 180, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblNomeLoc, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblIndirizzo, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
							.addComponent(stella5, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(stella4, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(stella3, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(stella2, GroupLayout.PREFERRED_SIZE, 20, GroupLayout.PREFERRED_SIZE)
							.addComponent(stella1))
						.addComponent(lblCategoria))
					.addGap(23)
					.addComponent(lblPiva)))
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addComponent(scrollPaneInfo, GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addComponent(scrollPaneDescrizione, GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnBack)
				.addComponent(btnVediRecensioni))
			.addGap(14))
		);

	txtrDescrizione = new JTextArea();
	scrollPaneDescrizione.setViewportView(txtrDescrizione);
	txtrDescrizione.setEditable(false);
	txtrDescrizione.setRows(5);
	txtrDescrizione.setBackground(Color.WHITE);
	txtrDescrizione.setLineWrap(true);
	txtrDescrizione.setFont(new Font("Arial", Font.PLAIN, 16));
	txtrDescrizione.setText("Descrizione...");

	txtrInfoServizi = new JTextArea();
	txtrInfoServizi.setTabSize(1);
	scrollPaneInfo.setViewportView(txtrInfoServizi);
	txtrInfoServizi.setLineWrap(true);
	txtrInfoServizi.setRows(10);
	txtrInfoServizi.setEditable(false);
	txtrInfoServizi.setFont(new Font("Arial", Font.PLAIN, 16));
	txtrInfoServizi.setText("Informazioni e servizi...");
	panelIMG.setLayout(null);

	labelImmagineLocation = new JLabel("");
	labelImmagineLocation.setBounds(10, 11, 176, 161);
	panelIMG.add(labelImmagineLocation);

	JLabel lblLocationPage = new JLabel("Location Page");
	lblLocationPage.setForeground(new Color(255, 255, 255));
	lblLocationPage.setFont(new Font("Arial", Font.BOLD, 18));

	JLabel label = new JLabel("");
	label.setIcon(new ImageIcon(LocationPage.class.getResource("/Icons/MeBell.png")));
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addContainerGap()
			.addComponent(lblLocationPage)
			.addPreferredGap(ComponentPlacement.RELATED, 365, Short.MAX_VALUE)
			.addComponent(label, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
			.addGap(95))
		);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblLocationPage)
				.addComponent(label))
			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	panel.setLayout(gl_panel);
	contentPane.setLayout(gl_contentPane);
    }

    public void setLocationPage(String nome,String categoria,String indirizzo,String piva,float voto,String descrizione,String informazioni,String servizi) {
	lblNomeLoc.setText(nome);
	lblCategoria.setText("Categoria: "+categoria);
	lblIndirizzo.setText(indirizzo);
	lblPiva.setText("P.IVA: "+piva);
	txtrDescrizione.setText(descrizione);
	txtrInfoServizi.setText(informazioni+"\n\n"+servizi);

	if(voto<1) {
	    stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto<2) {
	    stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto<3) {
	    stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto<4) {
	    stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto<5) {
	    stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto==5) {
	    stella1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    stella5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	}

    }

    public JLabel getLabelImmagineLocation() {
	return labelImmagineLocation;
    }

    public void setLabelImmagineLocation(Icon icon) {
	this.labelImmagineLocation.setIcon(icon);;
    }
}
