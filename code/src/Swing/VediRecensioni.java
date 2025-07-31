package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connessione.DatabaseConnection;
import Controller.Controller;
import Utility.ModelloTabella;

import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;

public class VediRecensioni extends JFrame {

    private JPanel contentPane;
    private Controller controller;

    private JTable table;
    ModelloTabella model= new ModelloTabella();

    private JTextArea textAreaRecensione;

    private int filtro_media_voto=0;
    private JComboBox comboBoxTimeFilter;

    public VediRecensioni(Controller ctrl) {
    	setName("Vedi_Review");
	setTitle("Vedi Recensioni");
	setMinimumSize(new Dimension(522, 360));
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
	setBounds(100, 100, 585, 387);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));

	JScrollPane scrollPaneTabellaRecensioni = new JScrollPane();
	scrollPaneTabellaRecensioni.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

	JButton btnInserisciNuovaRecensione = new JButton("");
	btnInserisciNuovaRecensione.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnInserisciNuovaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/InserisciNuovaRecICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnInserisciNuovaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/InserisciNuovaRecICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnInserisciNuovaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/InserisciNuovaRecICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnInserisciNuovaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/InserisciNuovaRecICON1.png")));
	    }
	});
	btnInserisciNuovaRecensione.setBorder(null);
	btnInserisciNuovaRecensione.setContentAreaFilled(false);
	btnInserisciNuovaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/InserisciNuovaRecICON1.png")));
	btnInserisciNuovaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnInserisciNuovaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(!controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.openInserisciDialog();
		    textAreaRecensione.setText("");
		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato ha già recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JButton btnModificaRecensione = new JButton("");
	btnModificaRecensione.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnModificaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/ModificaRecensioneICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnModificaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/ModificaRecensioneICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnModificaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/ModificaRecensioneICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnModificaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/ModificaRecensioneICON1.png")));
	    }
	});
	btnModificaRecensione.setBorder(null);
	btnModificaRecensione.setContentAreaFilled(false);
	btnModificaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/ModificaRecensioneICON1.png")));
	btnModificaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnModificaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.visualizzaOldRecensioneInDialog();
		    controller.openModificaDialog();
		    textAreaRecensione.setText("");
		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato non ha recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JButton btnEliminaRecensione = new JButton("");
	btnEliminaRecensione.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnEliminaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/EliminaRecensioneICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnEliminaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/EliminaRecensioneICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnEliminaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/EliminaRecensioneICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnEliminaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/EliminaRecensioneICON1.png")));
	    }
	});
	btnEliminaRecensione.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/EliminaRecensioneICON1.png")));
	btnEliminaRecensione.setBorder(null);
	btnEliminaRecensione.setContentAreaFilled(false);
	btnEliminaRecensione.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnEliminaRecensione.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		if(controller.controlloSeHaRecensioni()) {
		    setVisible(false);
		    controller.openEliminaDialog();
		    textAreaRecensione.setText("");

		}else {
		    JOptionPane.showMessageDialog(null, "L'utente loggato non ha recensioni su questa location", "Errore sulle recensioni", JOptionPane.ERROR_MESSAGE);
		}
	    }
	});

	JScrollPane scrollPaneTestoRecensione = new JScrollPane();

	JButton btnStella1 = new JButton("");
	btnStella1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JButton btnStella2 = new JButton("");
	btnStella2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JButton btnStella3 = new JButton("");
	btnStella3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JButton btnStella4 = new JButton("");
	btnStella4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	JButton btnStella5 = new JButton("");
	btnStella5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

	JLabel lblFiltri = new JLabel("Filtro");
	lblFiltri.setHorizontalAlignment(SwingConstants.CENTER);
	lblFiltri.setFont(new Font("Arial", Font.BOLD, 15));

	JButton btnTornaAllaLocation = new JButton("");
	btnTornaAllaLocation.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnTornaAllaLocation.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnTornaAllaLocation.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/TornaAllaLocICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnTornaAllaLocation.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/TornaAllaLocICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnTornaAllaLocation.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/TornaAllaLocICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnTornaAllaLocation.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/TornaAllaLocICON1.png")));
	    }
	});
	btnTornaAllaLocation.setBorder(null);
	btnTornaAllaLocation.setContentAreaFilled(false);
	btnTornaAllaLocation.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/TornaAllaLocICON1.png")));
	btnTornaAllaLocation.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		setVisible(false);
		controller.resettaCampiVediRecensioni(filtro_media_voto, textAreaRecensione, comboBoxTimeFilter);
		controller.resetFiltroRec(btnStella1, btnStella2, btnStella3, btnStella4, btnStella5);
		controller.openLocationPage();
		textAreaRecensione.setText("");
	    }
	});



	btnStella1.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella1.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		setFiltro_media_voto(1);

	    }
	});

	btnStella2.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella1.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		setFiltro_media_voto(2);

	    }
	});

	btnStella3.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella1.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		setFiltro_media_voto(3);

	    }
	});


	btnStella4.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella1.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		setFiltro_media_voto(4);

	    }
	});

	btnStella5.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella1.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));

		setFiltro_media_voto(5);

	    }
	});

	btnStella1.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella0.png")));
	btnStella1.setContentAreaFilled(false);
	btnStella1.setBorder(null);

	btnStella2.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella0.png")));
	btnStella2.setContentAreaFilled(false);
	btnStella2.setBorder(null);

	btnStella3.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella0.png")));
	btnStella3.setContentAreaFilled(false);
	btnStella3.setBorder(null);

	btnStella4.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella0.png")));
	btnStella4.setContentAreaFilled(false);
	btnStella4.setBorder(null);

	btnStella5.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/Stella0.png")));
	btnStella5.setContentAreaFilled(false);
	btnStella5.setBorder(null);

	comboBoxTimeFilter = new JComboBox();
	comboBoxTimeFilter.setModel(new DefaultComboBoxModel(new String[] {"Dalla pi\u00F9 recente", "Dalla meno recente"}));

	JButton buttonFiltra = new JButton("");
	buttonFiltra.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	buttonFiltra.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		controller.filtraRecensioni(model, filtro_media_voto, comboBoxTimeFilter.getSelectedItem().toString());
		textAreaRecensione.setText("");
	    }
	});
	buttonFiltra.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		buttonFiltra.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/CercaICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		buttonFiltra.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/CercaICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		buttonFiltra.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/CercaICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		buttonFiltra.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/CercaICON1.png")));
	    }
	});
	buttonFiltra.setContentAreaFilled(false);
	buttonFiltra.setBorder(null);
	buttonFiltra.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/CercaICON1.png")));

	JButton btnAzzera = new JButton("");
	btnAzzera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAzzera.setContentAreaFilled(false);
	btnAzzera.setBorder(null);
	btnAzzera.setIcon(new ImageIcon(VediRecensioni.class.getResource("/ButtonIcon/AzzeraICON1.png")));
	btnAzzera.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		controller.resettaCampiVediRecensioni(filtro_media_voto, textAreaRecensione, comboBoxTimeFilter);
		controller.resetFiltroRec(btnStella1, btnStella2, btnStella3, btnStella4, btnStella5);
		controller.riempiTabellaRecensioni();
	    }
	});
	btnAzzera.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnAzzera.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/AzzeraICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnAzzera.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/AzzeraICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnAzzera.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/AzzeraICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnAzzera.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/AzzeraICON1.png")));
	    }
	});

	textAreaRecensione = new JTextArea();
	textAreaRecensione.setEditable(false);
	textAreaRecensione.setLineWrap(true);
	textAreaRecensione.setRows(5);
	textAreaRecensione.setFont(new Font("Arial", Font.PLAIN, 16));
	scrollPaneTestoRecensione.setViewportView(textAreaRecensione);

	table = new JTable();
	table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	table.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		controller.setCellNotEditable(table, model);
		controller.getTestoRecensioneDaTable(table);
	    }
	});
	model.addColumn("Username");
	model.addColumn("Data");
	model.addColumn("Titolo");
	model.addColumn("Voto");

	table.setModel(model);
	table.setRowHeight(25);
	table.getTableHeader().setReorderingAllowed(false);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	scrollPaneTabellaRecensioni.setViewportView(table);

	JLabel lblRecensioni = new JLabel("Recensioni");
	lblRecensioni.setForeground(new Color(255, 255, 255));
	lblRecensioni.setFont(new Font("Arial", Font.BOLD, 18));
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addContainerGap()
			.addComponent(lblRecensioni)
			.addContainerGap(440, Short.MAX_VALUE))
		);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addComponent(lblRecensioni)
			.addContainerGap(37, Short.MAX_VALUE))
		);
	panel.setLayout(gl_panel);
	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(scrollPaneTabellaRecensioni, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
			.addGap(26)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addComponent(btnEliminaRecensione))
				.addComponent(btnModificaRecensione, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(3)
					.addComponent(btnInserisciNuovaRecensione))
				.addComponent(btnTornaAllaLocation, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE))
			.addGap(10))
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(scrollPaneTestoRecensione, GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
			.addGap(10)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(12)
					.addComponent(btnStella1)
					.addGap(10)
					.addComponent(btnStella2)
					.addGap(10)
					.addComponent(btnStella3)
					.addGap(10)
					.addComponent(btnStella4)
					.addGap(10)
					.addComponent(btnStella5))
				.addComponent(lblFiltri, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
				.addComponent(comboBoxTimeFilter, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(buttonFiltra)
					.addGap(6)
					.addComponent(btnAzzera)))
			.addGap(10))
		);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 51, GroupLayout.PREFERRED_SIZE)
			.addGap(11)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneTabellaRecensioni, GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(btnEliminaRecensione)
					.addGap(7)
					.addComponent(btnModificaRecensione)
					.addGap(7)
					.addComponent(btnInserisciNuovaRecensione)
					.addGap(10)
					.addComponent(btnTornaAllaLocation)))
			.addGap(19)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addComponent(scrollPaneTestoRecensione, GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(btnStella1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(btnStella2))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(btnStella3))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(btnStella4))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addComponent(btnStella5))
						.addComponent(lblFiltri))
					.addGap(6)
					.addComponent(comboBoxTimeFilter, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(buttonFiltra)
						.addComponent(btnAzzera))))
			.addGap(6))
		);
	contentPane.setLayout(gl_contentPane);
    }

    public JTextArea getTextAreaRecensione() {
	return textAreaRecensione;
    }

    public void setTextAreaRecensione(String recensione) {

	if(recensione==null || recensione.equals("")) {
	    this.textAreaRecensione.setText("Non esiste testo");
	}else {
	    this.textAreaRecensione.setText(recensione);
	}

    }

    public ModelloTabella getModel() {
	return model;
    }

    public void setModel(ModelloTabella model) {
	table.setModel(model);
    }

    public int getFiltro_media_voto() {
	return filtro_media_voto;
    }

    public void setFiltro_media_voto(int filtro_media_voto) {
	this.filtro_media_voto = filtro_media_voto;
    }

    public JComboBox getComboBoxTimeFilter() {
	return comboBoxTimeFilter;
    }

    public void setComboBoxTimeFilter(JComboBox comboBoxTimeFilter) {
	this.comboBoxTimeFilter = comboBoxTimeFilter;
    }
}
