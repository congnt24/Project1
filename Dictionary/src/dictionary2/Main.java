package dictionary2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.Map;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JList;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Main {
	public ReadData readData=new ReadData();
	private JFrame frame;
	private JPanel mainPanel;
	JList<String> list ;

	DefaultListModel<String> listModel=new DefaultListModel<String>();
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("static-access")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(200, 500));
		frame.getContentPane().add(panel, BorderLayout.WEST);
		mainPanel = new JPanel();
		frame.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		JTextPane textPane = new JTextPane();
		mainPanel.add(textPane);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				list.setSelectedIndex(100);
				textPane.setText(readData.hashTable.get(textField.getText()));
			}
		});
		panel.add(textField);
		textField.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(200, 500));
		panel.add(scrollPane);
		
		list = new JList<String>();
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent item) {
				if (item.getValueIsAdjusting()) {
					String str=list.getSelectedValue();
					textPane.setText(readData.hashTable.get(str));
				}
			}
		});
		scrollPane.setViewportView(list);
		list.setBorder(new LineBorder(new Color(0, 0, 0)));
		list.setModel(listModel);
		
		
		for (Map.Entry<String, String> c : readData.hashTable.entrySet()) {
			listModel.addElement(c.getKey());
		}
		list.setModel(listModel);
		list.setSelectedIndex(1);
	}

}
