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

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class MainPanel extends JPanel {
	public CardLayout cardLayout=new CardLayout(0, 0);
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	JLabel lblTongSoTien_1;
	
	JComboBox comboBox_1, comboBox_2;
	private String[] labelHangHoa=new String[]{"Ma Hang Hoa", "Ten Hang Hoa", "Gia", "Nha Cung Cap"};
	private String[] labelKhachHang=new String[]{"ID", "Ten", "Address"};
	private String[] labelNhaCungCap=new String[]{"ID", "Ten"};
	private String[] labelKho=new String[]{"Ma Xuat Nhap", "So Luong", "Gia","Ngay Cap Nhat", "Ten Hang Hoa", "Ten Nha Cung Cap"};
	MySQL mysql=new MySQL();
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	/**
	 * Create the panel.
	 */
	public MainPanel() {
		mysql.connect();
		setLayout(cardLayout);
		
		JPanel nhapPanel = new JPanel();
		add(nhapPanel, "1");
		GridBagLayout gbl_nhapPanel = new GridBagLayout();
		gbl_nhapPanel.columnWidths = new int[] {162, 30, 125, 0, 30};
		gbl_nhapPanel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_nhapPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_nhapPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		nhapPanel.setLayout(gbl_nhapPanel);
		
		JLabel lblMaHangHoa = new JLabel("Ma Hang Hoa");
		GridBagConstraints gbc_lblMaHangHoa = new GridBagConstraints();
		gbc_lblMaHangHoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblMaHangHoa.gridx = 0;
		gbc_lblMaHangHoa.gridy = 1;
		nhapPanel.add(lblMaHangHoa, gbc_lblMaHangHoa);
		
		JLabel lblTenHangHoa = new JLabel("Ten Hang Hoa");
		GridBagConstraints gbc_lblTenHangHoa = new GridBagConstraints();
		gbc_lblTenHangHoa.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenHangHoa.gridx = 0;
		gbc_lblTenHangHoa.gridy = 2;
		nhapPanel.add(lblTenHangHoa, gbc_lblTenHangHoa);
		textField_1 = new JTextField();
		textField_1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				int key=arg0.getKeyCode();
				if ((key>=65 & key <=90) | key==32) {
					ArrayList<String> list=mysql.getTenHangHoa();
					String line=textField_1.getText();
					String[] model=new String[100];
					int i=0;
					for (String string : list) {
						if (string.toLowerCase().contains(line.toLowerCase())) {
							model[i]=string;
								comboBox_1.setModel(new DefaultComboBoxModel(model));
							
							i++;
						}
					}
				}
				if (key==KeyEvent.VK_ENTER) {
					textField_1.setText(comboBox_1.getSelectedItem().toString());
					try {
						Statement st=mysql.conn.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM hang_hoa WHERE tenhanghoa= \""+comboBox_1.getSelectedItem().toString()+"\";");
						rs.next();
						textField_2.setText(Integer.toString(rs.getInt("gia")));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 2;
		nhapPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		comboBox_1 = new JComboBox();
		comboBox_1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				textField_1.setText(comboBox_1.getSelectedItem().toString());
				try {
					Statement st=mysql.conn.createStatement();
					ResultSet rs=st.executeQuery("SELECT * FROM hang_hoa WHERE tenhanghoa= \""+comboBox_1.getSelectedItem().toString()+"\";");
					rs.next();
					textField_2.setText(Integer.toString(rs.getInt("gia")));
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		});
		GridBagConstraints gbc_comboBox_1 = new GridBagConstraints();
		gbc_comboBox_1.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_1.gridx = 3;
		gbc_comboBox_1.gridy = 2;
		nhapPanel.add(comboBox_1, gbc_comboBox_1);
		
		JLabel lblGia = new JLabel("Gia");
		GridBagConstraints gbc_lblGia = new GridBagConstraints();
		gbc_lblGia.insets = new Insets(0, 0, 5, 5);
		gbc_lblGia.gridx = 0;
		gbc_lblGia.gridy = 3;
		nhapPanel.add(lblGia, gbc_lblGia);
		
		textField_2 = new JTextField();
		textField_2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					long sum=Integer.parseInt(textField_3.getText())*Integer.parseInt(textField_2.getText());
					lblTongSoTien_1.setText(""+sum);
				} catch (Exception e) {
					System.out.println("Nhap so tien!!");
				}
			}
		});
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
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
		textField_3.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				try {
					long sum=Integer.parseInt(textField_3.getText())*Integer.parseInt(textField_2.getText());
					lblTongSoTien_1.setText(""+sum);
				} catch (Exception e) {
					System.out.println("Nhap so tien!!");
				}
			}
		});
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 4;
		nhapPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JLabel lblTongSoTien = new JLabel("Tong So Tien");
		GridBagConstraints gbc_lblTongSoTien = new GridBagConstraints();
		gbc_lblTongSoTien.insets = new Insets(0, 0, 5, 5);
		gbc_lblTongSoTien.gridx = 0;
		gbc_lblTongSoTien.gridy = 5;
		nhapPanel.add(lblTongSoTien, gbc_lblTongSoTien);
		
		lblTongSoTien_1 = new JLabel("Tong So Tien");
		GridBagConstraints gbc_lblTongSoTien_1 = new GridBagConstraints();
		gbc_lblTongSoTien_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblTongSoTien_1.gridx = 2;
		gbc_lblTongSoTien_1.gridy = 5;
		nhapPanel.add(lblTongSoTien_1, gbc_lblTongSoTien_1);
		
		JLabel lblDaTra = new JLabel("Da Tra");
		GridBagConstraints gbc_lblDaTra = new GridBagConstraints();
		gbc_lblDaTra.insets = new Insets(0, 0, 5, 5);
		gbc_lblDaTra.gridx = 0;
		gbc_lblDaTra.gridy = 6;
		nhapPanel.add(lblDaTra, gbc_lblDaTra);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 6;
		nhapPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JLabel lblNhaSanXuat = new JLabel("Nha San Xuat");
		GridBagConstraints gbc_lblNhaSanXuat = new GridBagConstraints();
		gbc_lblNhaSanXuat.insets = new Insets(0, 0, 5, 5);
		gbc_lblNhaSanXuat.gridx = 0;
		gbc_lblNhaSanXuat.gridy = 7;
		nhapPanel.add(lblNhaSanXuat, gbc_lblNhaSanXuat);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(mysql.getComboboxNhaCungCap()));
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.gridx = 2;
		gbc_comboBox.gridy = 7;
		nhapPanel.add(comboBox, gbc_comboBox);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mysql.insertHangHoa(textField_1.getText(), textField_2.getText(), textField_3.getText(), comboBox.getSelectedItem().toString(), textField_4.getText());
			}
		});
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 2;
		gbc_btnSubmit.gridy = 9;
		nhapPanel.add(btnSubmit, gbc_btnSubmit);
		
		JPanel xuatpanel = new JPanel();
		add(xuatpanel, "8");
		GridBagLayout gbl_xuatpanel = new GridBagLayout();
		gbl_xuatpanel.columnWidths = new int[]{162, 30, 125, 0, 0};
		gbl_xuatpanel.rowHeights = new int[]{14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_xuatpanel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_xuatpanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		xuatpanel.setLayout(gbl_xuatpanel);
		
		JLabel lblTenKhachHang = new JLabel("Ten Khach Hang");
		GridBagConstraints gbc_lblTenKhachHang = new GridBagConstraints();
		gbc_lblTenKhachHang.insets = new Insets(0, 0, 5, 5);
		gbc_lblTenKhachHang.gridx = 0;
		gbc_lblTenKhachHang.gridy = 1;
		xuatpanel.add(lblTenKhachHang, gbc_lblTenKhachHang);
		
		textField_8 = new JTextField();
		textField_8.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent arg0) {
				textField_9.setText(textField_8.getText());
			}
		});
		GridBagConstraints gbc_textField_8 = new GridBagConstraints();
		gbc_textField_8.insets = new Insets(0, 0, 5, 5);
		gbc_textField_8.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_8.gridx = 2;
		gbc_textField_8.gridy = 1;
		xuatpanel.add(textField_8, gbc_textField_8);
		textField_8.setColumns(10);
		
		textField_9 = new JTextField();
		GridBagConstraints gbc_textField_9 = new GridBagConstraints();
		gbc_textField_9.insets = new Insets(0, 0, 5, 0);
		gbc_textField_9.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_9.gridx = 3;
		gbc_textField_9.gridy = 1;
		xuatpanel.add(textField_9, gbc_textField_9);
		textField_9.setColumns(10);
		
		JLabel label_1 = new JLabel("Ten Hang Hoa");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 2;
		xuatpanel.add(label_1, gbc_label_1);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				int key=arg0.getKeyCode();
				if ((key>=65 & key <=90) | key==32) {
					ArrayList<String> list=mysql.getTenHangHoa();
					String line=textField.getText();
					String[] model=new String[100];
					int i=0;
					for (String string : list) {
						if (string.toLowerCase().contains(line.toLowerCase())) {
							model[i]=string;
								comboBox_2.setModel(new DefaultComboBoxModel(model));
							
							i++;
						}
					}
				}
				if (key==KeyEvent.VK_ENTER) {
					textField.setText(comboBox_2.getSelectedItem().toString());
					try {
						Statement st=mysql.conn.createStatement();
						ResultSet rs=st.executeQuery("SELECT * FROM hang_hoa WHERE tenhanghoa= \""+comboBox_2.getSelectedItem().toString()+"\";");
						rs.next();
						textField_5.setText(Integer.toString(rs.getInt("gia")));
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		});
		textField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		xuatpanel.add(textField, gbc_textField);
		
		comboBox_2 = new JComboBox();
		GridBagConstraints gbc_comboBox_2 = new GridBagConstraints();
		gbc_comboBox_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_2.insets = new Insets(0, 0, 5, 0);
		gbc_comboBox_2.gridx = 3;
		gbc_comboBox_2.gridy = 2;
		xuatpanel.add(comboBox_2, gbc_comboBox_2);
		
		JLabel label_2 = new JLabel("Gia");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 5, 5);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		xuatpanel.add(label_2, gbc_label_2);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		GridBagConstraints gbc_textField_5 = new GridBagConstraints();
		gbc_textField_5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_5.insets = new Insets(0, 0, 5, 5);
		gbc_textField_5.gridx = 2;
		gbc_textField_5.gridy = 3;
		xuatpanel.add(textField_5, gbc_textField_5);
		
		JLabel label_3 = new JLabel("So Luong");
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 5, 5);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 4;
		xuatpanel.add(label_3, gbc_label_3);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		GridBagConstraints gbc_textField_6 = new GridBagConstraints();
		gbc_textField_6.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_6.insets = new Insets(0, 0, 5, 5);
		gbc_textField_6.gridx = 2;
		gbc_textField_6.gridy = 4;
		xuatpanel.add(textField_6, gbc_textField_6);
		
		JLabel label_4 = new JLabel("Tong So Tien");
		GridBagConstraints gbc_label_4 = new GridBagConstraints();
		gbc_label_4.insets = new Insets(0, 0, 5, 5);
		gbc_label_4.gridx = 0;
		gbc_label_4.gridy = 5;
		xuatpanel.add(label_4, gbc_label_4);
		
		JLabel label_5 = new JLabel("Tong So Tien");
		GridBagConstraints gbc_label_5 = new GridBagConstraints();
		gbc_label_5.insets = new Insets(0, 0, 5, 5);
		gbc_label_5.gridx = 2;
		gbc_label_5.gridy = 5;
		xuatpanel.add(label_5, gbc_label_5);
		
		JLabel label_6 = new JLabel("Da Tra");
		GridBagConstraints gbc_label_6 = new GridBagConstraints();
		gbc_label_6.insets = new Insets(0, 0, 5, 5);
		gbc_label_6.gridx = 0;
		gbc_label_6.gridy = 6;
		xuatpanel.add(label_6, gbc_label_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		GridBagConstraints gbc_textField_7 = new GridBagConstraints();
		gbc_textField_7.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_7.insets = new Insets(0, 0, 5, 5);
		gbc_textField_7.gridx = 2;
		gbc_textField_7.gridy = 6;
		xuatpanel.add(textField_7, gbc_textField_7);
		
		JLabel label_7 = new JLabel("Nha San Xuat");
		GridBagConstraints gbc_label_7 = new GridBagConstraints();
		gbc_label_7.insets = new Insets(0, 0, 5, 5);
		gbc_label_7.gridx = 0;
		gbc_label_7.gridy = 7;
		xuatpanel.add(label_7, gbc_label_7);
		
		JComboBox comboBox_3 = new JComboBox();
		GridBagConstraints gbc_comboBox_3 = new GridBagConstraints();
		gbc_comboBox_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_3.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox_3.gridx = 2;
		gbc_comboBox_3.gridy = 7;
		xuatpanel.add(comboBox_3, gbc_comboBox_3);
		
		JButton button = new JButton("Submit");
		GridBagConstraints gbc_button = new GridBagConstraints();
		gbc_button.insets = new Insets(0, 0, 0, 5);
		gbc_button.gridx = 2;
		gbc_button.gridy = 9;
		xuatpanel.add(button, gbc_button);
		
		JPanel quanlihanghoaPanel = new JPanel();
		add(quanlihanghoaPanel, "2");
		quanlihanghoaPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		quanlihanghoaPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(mysql.getHangHoa(),labelHangHoa));
		scrollPane.setViewportView(table);
		
		JPanel quanlikhachhangPanel = new JPanel();
		add(quanlikhachhangPanel, "3");
		quanlikhachhangPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		quanlikhachhangPanel.add(scrollPane_1, BorderLayout.CENTER);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		table_1.setModel(new DefaultTableModel(mysql.getKhachHang(), labelKhachHang));
		
		JPanel quanlinhacungcapPanel = new JPanel();
		add(quanlinhacungcapPanel, "4");
		quanlinhacungcapPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_2 = new JScrollPane();
		quanlinhacungcapPanel.add(scrollPane_2, BorderLayout.CENTER);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		table_2.setModel(new DefaultTableModel(mysql.getNhaCungCap(),labelNhaCungCap));
		
		JPanel quanlikhoPanel = new JPanel();
		add(quanlikhoPanel, "5");
		quanlikhoPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane_3 = new JScrollPane();
		quanlikhoPanel.add(scrollPane_3, BorderLayout.CENTER);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		table_3.setModel(new DefaultTableModel(mysql.getKho(),labelKho));
		
		JPanel aboutPanel = new JPanel();
		add(aboutPanel, "6");
		
		JLabel lblAbout = new JLabel("About lshgnjksdhags\\nsdfsdf\\n sdfhgjgsd");
		aboutPanel.add(lblAbout);
	}

}
