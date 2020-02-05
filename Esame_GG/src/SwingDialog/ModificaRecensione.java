package SwingDialog;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Controller.Controller;
import Swing.LocationPage;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ModificaRecensione extends JDialog {

    private JPanel contentPanel = new JPanel();
    private Controller controller;
    private JTextField textTitoloOLD;
    private JTextField txtTitoloNEW;
    private JTextArea textAreaRecensioneNEW;
    private JTextArea textAreaRecensioneOLD;

    private int votoDaModificare = 1;
    private JLabel lblVotoOLD1;
    private JLabel lblVotoOLD2;
    private JLabel lblVotoOLD3;
    private JLabel lblVotoOLD4;
    private JLabel lblVotoOLD5;
    private JLabel lblVotoNEW1;
    private JLabel lblVotoNEW2;
    private JLabel lblVotoNEW3;
    private JLabel lblVotoNEW4;
    private JLabel lblVotoNEW5;

    public ModificaRecensione(Controller ctrl) {
	controller=ctrl;
	setUndecorated(true);
	setBounds(100, 100, 450, 300);
	getContentPane().setLayout(new BorderLayout());
	contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
	getContentPane().add(contentPanel, BorderLayout.CENTER);
	contentPanel.setLayout(null);
	{
	    JPanel panel = new JPanel();
	    panel.setBackground(new Color(255, 102, 0));
	    panel.setBounds(0, 0, 450, 300);
	    contentPanel.add(panel);
	    panel.setLayout(null);
	    {
		JButton btnAnnulla = new JButton("Annulla");
		btnAnnulla.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
			setVisible(false);
			controller.openVediRecensioni();
		    }
		});
		btnAnnulla.setBounds(351, 266, 89, 23);
		panel.add(btnAnnulla);
	    }
	    {
		JButton btnConferma = new JButton("Conferma");
		btnConferma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    controller.modificaRecensione(txtTitoloNEW, textAreaRecensioneNEW, votoDaModificare);
			}
		});
		btnConferma.setBounds(252, 266, 89, 23);
		panel.add(btnConferma);
	    }
	    {
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(Color.RED);
		panelTitle.setBounds(0, 0, 450, 32);
		panel.add(panelTitle);
		{
		    JLabel label = new JLabel("Modifica la recensione");
		    label.setForeground(Color.WHITE);
		    label.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 18));
		    panelTitle.add(label);
		}
	    }
	    {
		JLabel lblLaTuaRecensione = new JLabel("La tua recensione:");
		lblLaTuaRecensione.setFont(new Font("Arial", Font.BOLD, 15));
		lblLaTuaRecensione.setBounds(10, 43, 143, 14);
		panel.add(lblLaTuaRecensione);
	    }

	    textTitoloOLD = new JTextField();
	    textTitoloOLD.setText("Titolo OLD...");
	    textTitoloOLD.setEditable(false);
	    textTitoloOLD.setBounds(10, 58, 217, 20);
	    panel.add(textTitoloOLD);
	    textTitoloOLD.setColumns(10);

	    JScrollPane scrollPaneOLD = new JScrollPane();
	    scrollPaneOLD.setBounds(10, 90, 430, 39);
	    panel.add(scrollPaneOLD);

	    textAreaRecensioneOLD = new JTextArea();
	    textAreaRecensioneOLD.setLineWrap(true);
	    textAreaRecensioneOLD.setEditable(false);
	    textAreaRecensioneOLD.setText("Recensione OLD...");
	    textAreaRecensioneOLD.setRows(3);
	    scrollPaneOLD.setViewportView(textAreaRecensioneOLD);
	    {
		lblVotoOLD1 = new JLabel("");
		lblVotoOLD1.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella1.png")));
		lblVotoOLD1.setBounds(237, 58, 21, 20);
		panel.add(lblVotoOLD1);
	    }
	    {
		lblVotoOLD2 = new JLabel("");
		lblVotoOLD2.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella1.png")));
		lblVotoOLD2.setBounds(268, 58, 21, 20);
		panel.add(lblVotoOLD2);
	    }
	    {
		lblVotoOLD3 = new JLabel("");
		lblVotoOLD3.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella1.png")));
		lblVotoOLD3.setBounds(299, 58, 21, 20);
		panel.add(lblVotoOLD3);
	    }
	    {
		lblVotoOLD4 = new JLabel("");
		lblVotoOLD4.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella1.png")));
		lblVotoOLD4.setBounds(330, 58, 21, 20);
		panel.add(lblVotoOLD4);
	    }
	    {
		lblVotoOLD5 = new JLabel("");
		lblVotoOLD5.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella1.png")));
		lblVotoOLD5.setBounds(361, 58, 21, 20);
		panel.add(lblVotoOLD5);
	    }
	    {
		JLabel lblModifica = new JLabel("Modifica:");
		lblModifica.setFont(new Font("Arial", Font.BOLD, 15));
		lblModifica.setBounds(10, 140, 143, 14);
		panel.add(lblModifica);
	    }
	    {
		txtTitoloNEW = new JTextField();
		txtTitoloNEW.setText("Titolo NEW...");
		txtTitoloNEW.setColumns(10);
		txtTitoloNEW.setBounds(10, 154, 217, 20);
		panel.add(txtTitoloNEW);
	    }
	    {
		JScrollPane scrollPaneNEW = new JScrollPane();
		scrollPaneNEW.setBounds(10, 185, 430, 70);
		panel.add(scrollPaneNEW);
		textAreaRecensioneNEW.setLineWrap(true);
		scrollPaneNEW.setViewportView(textAreaRecensioneNEW);

		textAreaRecensioneNEW = new JTextArea();
		scrollPaneNEW.setViewportView(textAreaRecensioneNEW);
		textAreaRecensioneNEW.setText("Recensione NEW...");
		textAreaRecensioneNEW.setRows(3);
	    }
	    {
		lblVotoNEW1 = new JLabel("");
		lblVotoNEW1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {

			votoDaModificare=1;
			lblVotoNEW1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
			lblVotoNEW3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
			lblVotoNEW4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
			lblVotoNEW5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));

		    }
		});
		lblVotoNEW1.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella1.png")));
		lblVotoNEW1.setBounds(237, 154, 21, 20);
		panel.add(lblVotoNEW1);
	    }
	    {
		lblVotoNEW2 = new JLabel("");
		lblVotoNEW2.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {

			votoDaModificare=2;
			lblVotoNEW1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
			lblVotoNEW4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
			lblVotoNEW5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));

		    }
		});
		lblVotoNEW2.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella0.png")));
		lblVotoNEW2.setBounds(268, 154, 21, 20);
		panel.add(lblVotoNEW2);
	    }
	    {
		lblVotoNEW3 = new JLabel("");
		lblVotoNEW3.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {

			votoDaModificare=3;
			lblVotoNEW1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
			lblVotoNEW5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));

		    }
		});
		lblVotoNEW3.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella0.png")));
		lblVotoNEW3.setBounds(299, 154, 21, 20);
		panel.add(lblVotoNEW3);
	    }
	    {
		lblVotoNEW4 = new JLabel("");
		lblVotoNEW4.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {

			votoDaModificare=4;
			lblVotoNEW1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));

		    }
		});
		lblVotoNEW4.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella0.png")));
		lblVotoNEW4.setBounds(330, 154, 21, 20);
		panel.add(lblVotoNEW4);
	    }
	    {
		lblVotoNEW5 = new JLabel("");
		lblVotoNEW5.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {

			votoDaModificare=5;
			lblVotoNEW1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
			lblVotoNEW5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));

		    }
		});
		lblVotoNEW5.setIcon(new ImageIcon(ModificaRecensione.class.getResource("/ButtonIcon/Stella0.png")));
		lblVotoNEW5.setBounds(361, 154, 21, 20);
		panel.add(lblVotoNEW5);
	    }
	}
    }



    public JTextField getTextTitoloOLD() {
	return textTitoloOLD;
    }



    public void setTextTitoloOLD(JTextField textTitoloOLD) {
	this.textTitoloOLD = textTitoloOLD;
    }



    public JTextArea getTextAreaRecensioneOLD() {
	return textAreaRecensioneOLD;
    }



    public void setTextAreaRecensioneOLD(JTextArea textAreaRecensioneOLD) {
	this.textAreaRecensioneOLD = textAreaRecensioneOLD;
    }



    public void setOldReview(String titolo, String testo, float voto) {

	this.textTitoloOLD.setText(titolo);
	this.textAreaRecensioneOLD.setText(testo);


	if(voto<1) {
	    lblVotoOLD1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto<2) {
	    lblVotoOLD1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto<3) {
	    lblVotoOLD1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto<4) {
	    lblVotoOLD1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	    lblVotoOLD5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto<5) {
	    lblVotoOLD1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella0.png")));
	}else if(voto==5) {
	    lblVotoOLD1.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD2.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD3.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD4.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	    lblVotoOLD5.setIcon(new ImageIcon(LocationPage.class.getResource("/ButtonIcon/Stella1.png")));
	}

    }
}
