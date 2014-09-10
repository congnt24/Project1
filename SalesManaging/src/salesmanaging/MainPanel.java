package salesmanaging;

import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JLabel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class MainPanel extends JPanel {
	public CardLayout cardLayout=new CardLayout(0, 0);
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		setLayout(cardLayout);
		
		JPanel nhapPanel = new JPanel();
		add(nhapPanel, "1");
		GridBagLayout gbl_nhapPanel = new GridBagLayout();
		gbl_nhapPanel.columnWidths = new int[]{162, 0, 125, 0};
		gbl_nhapPanel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_nhapPanel.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_nhapPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		nhapPanel.setLayout(gbl_nhapPanel);
		
		JLabel lblMaHangHoa = new JLabel("Ma Hang Hoa");
		GridBagConstraints gbc_lblMaHangHoa = new GridBagConstraints();
		gbc_lblMaHangHoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaHangHoa.gridx = 0;
		gbc_lblMaHangHoa.gridy = 1;
		nhapPanel.add(lblMaHangHoa, gbc_lblMaHangHoa);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		nhapPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JLabel lblTenHangHoa = new JLabel("Ten Hang Hoa");
		GridBagConstraints gbc_lblTenHangHoa = new GridBagConstraints();
		gbc_lblTenHangHoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenHangHoa.gridx = 0;
		gbc_lblTenHangHoa.gridy = 2;
		nhapPanel.add(lblTenHangHoa, gbc_lblTenHangHoa);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		nhapPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblGia = new JLabel("Gia");
		GridBagConstraints gbc_lblGia = new GridBagConstraints();
		gbc_lblGia.insets = new Insets(0, 0, 5, 5);
		gbc_lblGia.gridx = 0;
		gbc_lblGia.gridy = 3;
		nhapPanel.add(lblGia, gbc_lblGia);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 3;
		nhapPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JLabel lblSoLuong = new JLabel("So Luong");
		GridBagConstraints gbc_lblSoLuong = new GridBagConstraints();
		gbc_lblSoLuong.insets = new Insets(0, 0, 5, 5);
		gbc_lblSoLuong.gridx = 0;
		gbc_lblSoLuong.gridy = 4;
		nhapPanel.add(lblSoLuong, gbc_lblSoLuong);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 0);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		nhapPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNhaSanXuat = new JLabel("Nha San Xuat");
		GridBagConstraints gbc_lblNhaSanXuat = new GridBagConstraints();
		gbc_lblNhaSanXuat.insets = new Insets(0, 0, 5, 5);
		gbc_lblNhaSanXuat.gridx = 0;
		gbc_lblNhaSanXuat.gridy = 5;
		nhapPanel.add(lblNhaSanXuat, gbc_lblNhaSanXuat);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 0);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 5;
		nhapPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 7;
		nhapPanel.add(btnSubmit, gbc_btnSubmit);
		
		JPanel quanlihanghoaPanel = new JPanel();
		add(quanlihanghoaPanel, "2");
		quanlihanghoaPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		quanlihanghoaPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"1000000", "123", "FPT", "Iphone 6", "123"},
				{"20000", "123", "FPT", "Iphone 7", "124"},
			},
			new String[] {
				"Cost", "SoLuong", "NhaSanXuat", "Name", "ID"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel quanlikhachhangPanel = new JPanel();
		add(quanlikhachhangPanel, "3");
		quanlikhachhangPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		quanlikhachhangPanel.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(
				new Object[][] {
					{"1000000", "123", "FPT", "Iphone 6", "123"},
					{"20000", "123", "FPT", "Iphone 7", "124"},
				},
				new String[] {
					"Cost", "SoLuong", "NhaSanXuat", "Name", "ID"
				}
			));
		
		JPanel quanlinhacungcapPanel = new JPanel();
		add(quanlinhacungcapPanel, "4");
		quanlinhacungcapPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		quanlinhacungcapPanel.add(scrollPane_2, BorderLayout.CENTER);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(
				new Object[][] {
					{"1000000", "123", "FPT", "Iphone 6", "123"},
					{"20000", "123", "FPT", "Iphone 7", "124"},
				},
				new String[] {
					"Cost", "SoLuong", "NhaSanXuat", "Name", "ID"
				}
			));
		
		JPanel quanlikhoPanel = new JPanel();
		add(quanlikhoPanel, "5");
		quanlikhoPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		quanlikhoPanel.add(scrollPane_3, BorderLayout.CENTER);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(
				new Object[][] {
					{"1000000", "123", "FPT", "Iphone 6", "123"},
					{"20000", "123", "FPT", "Iphone 7", "124"},
				},
				new String[] {
					"Cost", "SoLuong", "NhaSanXuat", "Name", "ID"
				}
			));
		
		JPanel aboutPanel = new JPanel();
		add(aboutPanel, "6");
		
		JLabel lblAbout = new JLabel("About lshgnjksdhags\\nsdfsdf\\n sdfhgjgsd");
		aboutPanel.add(lblAbout);
	}

}
