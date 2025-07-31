package Swing;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Connessione.DatabaseConnection;
import Controller.Controller;
import Utility.ModelloTabella;
import Utility.myTableCellRenderer;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JRadioButton;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class HomePage extends JFrame {

    private JPanel contentPane;
    private Controller controller;    
    private JTextField textNomeLocale;
    private JLabel lblLoggatoCome;

    int filtro_media_voto=0;
    private ModelloTabella model= new ModelloTabella();

    public HomePage(Controller ctrl) {
	setName("Homepage");
	setMinimumSize(new Dimension(780, 413));
	setTitle("HomePage");
	controller = ctrl;

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
	setBounds(100, 100, 1100, 413);
	contentPane = new JPanel();
	contentPane.setMinimumSize(new Dimension(651, 413));
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	setContentPane(contentPane);

	JTable table = new JTable();
	table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	table.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	table.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		controller.setCellNotEditable(table, model);
	    }
	}); 

	JPanel panel = new JPanel();
	panel.setBackground(new Color(255, 102, 0));

	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));

	JLabel lblFiltri = new JLabel("Filtri:");
	lblFiltri.setFont(new Font("Arial Black", Font.BOLD, 18));

	JComboBox<String> comboBox_FiltroComune = new JComboBox<String>();
	comboBox_FiltroComune.setModel(new DefaultComboBoxModel(new String[] {"Tutti"}));
	int i=1;
	for(String c: controller.getComuni()) {
	    comboBox_FiltroComune.insertItemAt(c, i);
	    i++;
	}

	JComboBox<String> comboBox_FiltroTipologia = new JComboBox<String>();
	comboBox_FiltroTipologia.setModel(new DefaultComboBoxModel(new String[] {"Tutti", "Alloggio", "Attrazione", "Ristorante"}));

	textNomeLocale = new JTextField();
	textNomeLocale.setColumns(10);

	JLabel lblComune = new JLabel("Comune");

	JLabel lblTipologia = new JLabel("Tipologia");

	JLabel lblNomeLocale = new JLabel("Nome Locale");

	JButton btnCerca = new JButton("");
	btnCerca.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnCerca.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/CercaICON1.png")));
	btnCerca.setBorder(null);
	btnCerca.setContentAreaFilled(false);
	btnCerca.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		String filtro_tipologia=comboBox_FiltroTipologia.getSelectedItem().toString();
		String filtro_comune=comboBox_FiltroComune.getSelectedItem().toString();
		String filtro_nome=textNomeLocale.getText();

		controller.getFilterLocation(filtro_tipologia, filtro_comune, filtro_nome, filtro_media_voto);
		controller.aggiornaTable(model);
	    }
	});
	btnCerca.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnCerca.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/CercaICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnCerca.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/CercaICON1.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnCerca.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/CercaICON1.png")));
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnCerca.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/CercaICON2.png")));
	    }
	});

	JLabel lblMediaVoti = new JLabel("Media voti");

	JButton btnVAI = new JButton("");
	btnVAI.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		boolean controllo = controller.getLocationFromTable(table);
		if(controllo) {
		    controller.getLocationInformation();
		    controller.aggiornaLocationPage();
		    controller.setImgLocation();
		}
	    }
	});
	btnVAI.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnVAI.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/VaiICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnVAI.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/VaiICON1.png")));
	    }
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnVAI.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/VaiICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnVAI.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/VaiICON1.png")));
	    }
	});
	btnVAI.setBorder(null);
	btnVAI.setContentAreaFilled(false);
	btnVAI.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/VaiICON1.png")));
	btnVAI.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnCerca.setBorder(null);
	btnCerca.setContentAreaFilled(false);

	JButton btnStella1 = new JButton("");
	JButton btnStella2 = new JButton("");
	JButton btnStella3 = new JButton("");
	JButton btnStella4 = new JButton("");
	JButton btnStella5 = new JButton("");

	btnStella1.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		btnStella1.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella1.png")));
		btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));
		btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

		filtro_media_voto=1;

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

		filtro_media_voto=2;

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

		filtro_media_voto=3;

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

		filtro_media_voto=4;

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

		filtro_media_voto=5;

	    }
	});
	btnStella1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnStella1.setBorder(null);
	btnStella1.setContentAreaFilled(false);
	btnStella1.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

	btnStella2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnStella2.setBorder(null);
	btnStella2.setContentAreaFilled(false);
	btnStella2.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

	btnStella3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnStella3.setBorder(null);
	btnStella3.setContentAreaFilled(false);
	btnStella3.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

	btnStella4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnStella4.setBorder(null);
	btnStella4.setContentAreaFilled(false);
	btnStella4.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

	btnStella5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnStella5.setBorder(null);
	btnStella5.setContentAreaFilled(false);
	btnStella5.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/Stella0.png")));

	lblLoggatoCome = new JLabel("Loggato come: ");
	lblLoggatoCome.setFont(new Font("Arial", Font.BOLD, 16));

	JButton btnAzzera = new JButton("");
	btnAzzera.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	btnAzzera.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/AzzeraICON1.png")));
	btnAzzera.setBorder(null);
	btnAzzera.setContentAreaFilled(false);
	btnAzzera.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {

		controller.resetFiltroHomepage(comboBox_FiltroTipologia, comboBox_FiltroComune, textNomeLocale);
		controller.resetFiltroRec(btnStella1, btnStella2, btnStella3, btnStella4, btnStella5);
		controller.getFilterLocation("Tutti", "Tutti", "", filtro_media_voto);
		controller.aggiornaTable(model);

	    }
	});
	btnAzzera.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mousePressed(MouseEvent e) {
		btnAzzera.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/AzzeraICON3.png")));
	    }
	    @Override
	    public void mouseReleased(MouseEvent e) {
		btnAzzera.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/AzzeraICON1.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		btnAzzera.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/AzzeraICON1.png")));
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		btnAzzera.setIcon(new ImageIcon(Login.class.getResource("/ButtonIcon/AzzeraICON2.png")));
	    }
	});

	GroupLayout gl_contentPane = new GroupLayout(contentPane);
	gl_contentPane.setHorizontalGroup(
		gl_contentPane.createParallelGroup(Alignment.TRAILING)
		.addComponent(panel, GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addGap(10)
			.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
			.addGap(18)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addComponent(lblComune)
						.addComponent(lblFiltri)
						.addComponent(lblTipologia)
						.addComponent(lblNomeLocale, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addGap(19)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(comboBox_FiltroTipologia, 0, 214, Short.MAX_VALUE)
						.addComponent(comboBox_FiltroComune, Alignment.TRAILING, 0, 214, Short.MAX_VALUE)
						.addComponent(textNomeLocale, GroupLayout.DEFAULT_SIZE, 214, Short.MAX_VALUE)))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblMediaVoti, GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStella1)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStella2)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStella3)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStella4)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnStella5)))
					.addGap(12)
					.addComponent(btnAzzera, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)))
			.addContainerGap())
		.addGroup(gl_contentPane.createSequentialGroup()
			.addContainerGap()
			.addComponent(lblLoggatoCome)
			.addPreferredGap(ComponentPlacement.RELATED, 412, Short.MAX_VALUE)
			.addComponent(btnVAI)
			.addGap(35)
			.addComponent(btnCerca)
			.addContainerGap())
		);
	gl_contentPane.setVerticalGroup(
		gl_contentPane.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_contentPane.createSequentialGroup()
			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
			.addPreferredGap(ComponentPlacement.UNRELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 254, Short.MAX_VALUE)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblFiltri)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(52)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblTipologia)
								.addComponent(comboBox_FiltroTipologia, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addGap(18)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblNomeLocale)
								.addComponent(textNomeLocale, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(16)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
								.addComponent(lblComune)
								.addComponent(comboBox_FiltroComune, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))))
					.addGap(11)
					.addComponent(lblMediaVoti)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(btnStella2)
							.addComponent(btnStella3)
							.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(btnStella1)
								.addPreferredGap(ComponentPlacement.RELATED)))
						.addComponent(btnStella4)
						.addComponent(btnStella5)
						.addComponent(btnAzzera))
					.addPreferredGap(ComponentPlacement.RELATED, 64, Short.MAX_VALUE)))
			.addPreferredGap(ComponentPlacement.RELATED)
			.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addComponent(btnCerca)
				.addComponent(btnVAI)
				.addComponent(lblLoggatoCome))
			.addGap(5))
		);


	model.addColumn("Location");
	model.addColumn("ID");
	model.addColumn("Nome");
	model.addColumn("Via");
	model.addColumn("Comune");
	model.addColumn("Media Voti");

	table.setModel(model);
	table.setRowHeight(25);
	table.getTableHeader().setReorderingAllowed(false);
	table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	table.getColumn("Location").setCellRenderer(new myTableCellRenderer());
	scrollPane.setViewportView(table);


	JLabel lblHomepage = new JLabel("HomePage");
	lblHomepage.setForeground(new Color(255, 255, 255));
	lblHomepage.setFont(new Font("Arial", Font.BOLD, 18));

	JLabel labelLogOut = new JLabel("");
	labelLogOut.addMouseListener(new MouseAdapter() {
	    @Override
	    public void mouseClicked(MouseEvent e) {
		int n = JOptionPane.showConfirmDialog(
			null,
			"Sei sicuro di uscire?",
			"Conferma logout",
			JOptionPane.YES_NO_OPTION);

		if(n==0) {
		    setVisible(false);
		    controller.resetFiltroHomepage(comboBox_FiltroTipologia, comboBox_FiltroComune, textNomeLocale);
		    controller.resetFiltroRec(btnStella1, btnStella2, btnStella3, btnStella4, btnStella5);
		    controller.logOut();
		}
	    }
	    @Override
	    public void mouseEntered(MouseEvent e) {
		labelLogOut.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/LogOutICON2.png")));
	    }
	    @Override
	    public void mouseExited(MouseEvent e) {
		labelLogOut.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/LogOutICON1.png")));
	    }
	});
	labelLogOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	labelLogOut.setIcon(new ImageIcon(HomePage.class.getResource("/ButtonIcon/LogOutICON1.png")));



	JLabel Logo = new JLabel("");
	Logo.setIcon(new ImageIcon(HomePage.class.getResource("/Icons/MeBell.png")));
	GroupLayout gl_panel = new GroupLayout(panel);
	gl_panel.setHorizontalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addContainerGap()
			.addComponent(lblHomepage)
			.addPreferredGap(ComponentPlacement.RELATED, 359, Short.MAX_VALUE)
			.addComponent(Logo)
			.addGap(55)
			.addComponent(labelLogOut))
		);
	gl_panel.setVerticalGroup(
		gl_panel.createParallelGroup(Alignment.LEADING)
		.addGroup(gl_panel.createSequentialGroup()
			.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
				.addComponent(lblHomepage)
				.addComponent(labelLogOut)
				.addComponent(Logo, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE))
			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
	panel.setLayout(gl_panel);
	contentPane.setLayout(gl_contentPane);
    }



    public JLabel getLblLoggatoCome() {
	return lblLoggatoCome;
    }
    public void setLblLoggatoCome(String utente) {
	this.lblLoggatoCome.setText("Loggato come: "+utente);
    }
    public int getFiltro_media_voto() {
	return filtro_media_voto;
    }
    public void setFiltro_media_voto(int filtro_media_voto) {
	this.filtro_media_voto = filtro_media_voto;
    }
    public ModelloTabella getModel() {
	return model;
    }
    public void setModel(ModelloTabella model) {
	this.model = model;
    }

}
