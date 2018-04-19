package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class IzvrsiZamenuGUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel lblKupovniKurs;
	private JLabel lblValuta;
	private JLabel lblProdajniKurs;
	private JTextField txtKupovniKurs;
	private JComboBox comboBoxValuta;
	private JTextField txtProdajniKurs;
	private JPanel panel_1;
	private JLabel lblIznos;
	private JLabel lblVrstaTransakcije;
	private JTextField txtIznos;
	private JRadioButton rdbtnKupovni;
	private JRadioButton rdbtnProdaja;
	private JLabel label;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JSlider slider;
	private JButton btnIzvrsiZamenu;
	private JButton btnOdustani;

	private MenjacnicaGUI mg;

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuGUI(MenjacnicaGUI mg) {
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(IzvrsiZamenuGUI.class.getResource("/menjacnica/gui/exchange.png")));
		setTitle("Izvrsi zamenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 355);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getPanel_1());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvrsiZamenu());
		contentPane.add(getBtnOdustani());

		this.mg = mg;
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBounds(12, 10, 408, 54);
			panel.setLayout(new GridLayout(2, 3, 10, 10));
			panel.add(getLblKupovniKurs());
			panel.add(getLblValuta());
			panel.add(getLblProdajniKurs());
			panel.add(getTxtKupovniKurs());
			panel.add(getComboBoxValuta());
			panel.add(getTxtProdajniKurs());
		}
		return panel;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
		}
		return lblKupovniKurs;
	}

	private JLabel getLblValuta() {
		if (lblValuta == null) {
			lblValuta = new JLabel("Valuta");
		}
		return lblValuta;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
		}
		return lblProdajniKurs;
	}

	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setEditable(false);
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}

	private JComboBox getComboBoxValuta() {
		if (comboBoxValuta == null) {
			comboBoxValuta = new JComboBox();
		}

		comboBoxValuta.addItem("EUR");
		comboBoxValuta.addItem("USD");
		comboBoxValuta.addItem("CHF");

		return comboBoxValuta;
	}

	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setEditable(false);
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}

	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBounds(12, 84, 408, 95);
			panel_1.setLayout(new GridLayout(3, 2, 10, 10));
			panel_1.add(getLblIznos());
			panel_1.add(getLblVrstaTransakcije());
			panel_1.add(getTxtIznos());
			panel_1.add(getRdbtnKupovni());
			panel_1.add(getLabel());
			panel_1.add(getRdbtnProdaja());
		}
		return panel_1;
	}

	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
		}
		return lblIznos;
	}

	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
		}
		return lblVrstaTransakcije;
	}

	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setColumns(10);
		}
		return txtIznos;
	}

	private JRadioButton getRdbtnKupovni() {
		if (rdbtnKupovni == null) {
			rdbtnKupovni = new JRadioButton("Kupovina");
			buttonGroup.add(rdbtnKupovni);
		}
		return rdbtnKupovni;
	}

	private JRadioButton getRdbtnProdaja() {
		if (rdbtnProdaja == null) {
			rdbtnProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdbtnProdaja);
		}
		return rdbtnProdaja;
	}

	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel("");
		}
		return label;
	}

	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					txtIznos.setText(String.valueOf(slider.getValue()));
				}
			});

			slider.addAncestorListener(new AncestorListener() {
				public void ancestorAdded(AncestorEvent arg0) {
					txtIznos.setText(String.valueOf(slider.getValue()));
				}

				@Override
				public void ancestorMoved(AncestorEvent event) {

				}

				@Override
				public void ancestorRemoved(AncestorEvent event) {

				}
			});

			slider.setPaintLabels(true);
			slider.setPaintTicks(true);
			slider.setMinorTickSpacing(5);
			slider.setMajorTickSpacing(10);
			slider.setBounds(12, 192, 408, 46);
		}
		return slider;
	}

	private JButton getBtnIzvrsiZamenu() {
		if (btnIzvrsiZamenu == null) {
			btnIzvrsiZamenu = new JButton("Izvrsi zamenu");
			btnIzvrsiZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String rezultat = "";
					
					if (rdbtnKupovni.isSelected()) {
						rezultat += "Kupljeno je ";
					}
					if (rdbtnProdaja.isSelected()) {
						rezultat += "Prodato je ";
					}
					
					rezultat += txtIznos.getText() + (String)comboBoxValuta.getSelectedItem();
					
					mg.dodajTekst(rezultat);
					dispose();
				}
			});
			btnIzvrsiZamenu.setBounds(12, 270, 196, 25);
		}
		return btnIzvrsiZamenu;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			btnOdustani.setBounds(224, 270, 196, 25);
		}
		return btnOdustani;
	}
}
