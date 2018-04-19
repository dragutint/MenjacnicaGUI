package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ObrisiKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblSifra;
	private JLabel lblNaziv;
	private JTextField txtSifra;
	private JTextField txtNaziv;
	private JLabel lblProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtProdajniKurs;
	private JTextField txtKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JLabel lblSkraceniNaziv;
	private JTextField txtSrednjiKurs;
	private JTextField txtSkraceniNaziv;
	private JCheckBox chckbxZaistaObrisiKurs;
	private JButton btnObrisi;
	private JButton btnOdustani;
	private JLabel prazanLejbel;

	private MenjacnicaGUI mg;
	
	/**
	 * Create the frame.
	 */
	public ObrisiKursGUI(MenjacnicaGUI mg) {
		setIconImage(
				Toolkit.getDefaultToolkit().getImage(ObrisiKursGUI.class.getResource("/menjacnica/gui/exchange.png")));
		setResizable(false);
		setTitle("Obrisi kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(8, 2, 10, 10));
		contentPane.add(getLblSifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTxtSifra());
		contentPane.add(getTxtNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTxtProdajniKurs());
		contentPane.add(getTxtKupovniKurs());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblSkraceniNaziv());
		contentPane.add(getTxtSrednjiKurs());
		contentPane.add(getTxtSkraceniNaziv());
		contentPane.add(getChckbxZaistaObrisiKurs());
		contentPane.add(getPrazanLejbel());
		contentPane.add(getBtnObrisi());
		contentPane.add(getBtnOdustani());
		
		this.mg = mg;
	}

	private JLabel getLblSifra() {
		if (lblSifra == null) {
			lblSifra = new JLabel("Sifra");
		}
		return lblSifra;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
		}
		return lblNaziv;
	}

	private JTextField getTxtSifra() {
		if (txtSifra == null) {
			txtSifra = new JTextField();
			txtSifra.setEditable(false);
			txtSifra.setColumns(10);
		}
		return txtSifra;
	}

	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setEditable(false);
			txtNaziv.setColumns(10);
		}
		return txtNaziv;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
		}
		return lblProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
		}
		return lblKupovniKurs;
	}

	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setEditable(false);
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}

	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setEditable(false);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}

	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
		}
		return lblSrednjiKurs;
	}

	private JLabel getLblSkraceniNaziv() {
		if (lblSkraceniNaziv == null) {
			lblSkraceniNaziv = new JLabel("Skraceni naziv");
		}
		return lblSkraceniNaziv;
	}

	private JTextField getTxtSrednjiKurs() {
		if (txtSrednjiKurs == null) {
			txtSrednjiKurs = new JTextField();
			txtSrednjiKurs.setEditable(false);
			txtSrednjiKurs.setColumns(10);
		}
		return txtSrednjiKurs;
	}

	private JTextField getTxtSkraceniNaziv() {
		if (txtSkraceniNaziv == null) {
			txtSkraceniNaziv = new JTextField();
			txtSkraceniNaziv.setEditable(false);
			txtSkraceniNaziv.setColumns(10);
		}
		return txtSkraceniNaziv;
	}

	private JCheckBox getChckbxZaistaObrisiKurs() {
		if (chckbxZaistaObrisiKurs == null) {
			chckbxZaistaObrisiKurs = new JCheckBox("Zaista obrisi kurs");
			chckbxZaistaObrisiKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					if(chckbxZaistaObrisiKurs.isSelected()) {
						btnObrisi.setEnabled(true);
					} else {
						btnObrisi.setEnabled(false);
					}
				}
			});
		}
		return chckbxZaistaObrisiKurs;
	}

	private JButton getBtnObrisi() {
		if (btnObrisi == null) {
			btnObrisi = new JButton("Obrisi");
			btnObrisi.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String rezultat = "Kurs sa sledecim podacima: " + txtNaziv.getText() + " (" + txtSkraceniNaziv.getText() + "), sifra: " + txtSifra.getText() + 
							", prodajni: " + txtProdajniKurs.getText() + ", srednji: " + txtSrednjiKurs.getText() + ", kupovni: " + 
							txtKupovniKurs.getText() + ", je obrisan.";
					
					mg.dodajTekst(rezultat);
					dispose();
				}
			});
			btnObrisi.setEnabled(false);
		}
		return btnObrisi;
	}
	
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
		}
		return btnOdustani;
	}
	private JLabel getPrazanLejbel() {
		if (prazanLejbel == null) {
			prazanLejbel = new JLabel("");
		}
		return prazanLejbel;
	}
}
