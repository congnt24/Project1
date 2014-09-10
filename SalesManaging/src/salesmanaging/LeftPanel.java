package salesmanaging;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JButton;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LeftPanel extends JPanel {
	public JButton btnNhpHngHa,btnQuanLHng,btnQunLKhch,btnQunLNh,btnQunLKho,btnAbout, btnExit;  
	/**
	 * Create the panel.
	 */
	public LeftPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		btnNhpHngHa = new JButton("Nh\u1EADp H\u00E0ng H\u00F3a");
		GridBagConstraints gbc_btnNhpHngHa = new GridBagConstraints();
		gbc_btnNhpHngHa.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNhpHngHa.insets = new Insets(0, 0, 5, 0);
		gbc_btnNhpHngHa.gridx = 1;
		gbc_btnNhpHngHa.gridy = 2;
		add(btnNhpHngHa, gbc_btnNhpHngHa);
		
		btnQuanLHng = new JButton("Quan L\u00ED H\u00E0ng H\u00F3a");
		GridBagConstraints gbc_btnQuanLHng = new GridBagConstraints();
		gbc_btnQuanLHng.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQuanLHng.insets = new Insets(0, 0, 5, 0);
		gbc_btnQuanLHng.gridx = 1;
		gbc_btnQuanLHng.gridy = 3;
		add(btnQuanLHng, gbc_btnQuanLHng);
		
		btnQunLKhch = new JButton("Qu\u1EA3n L\u00ED Kh\u00E1ch H\u00E0ng");
		GridBagConstraints gbc_btnQunLKhch = new GridBagConstraints();
		gbc_btnQunLKhch.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQunLKhch.insets = new Insets(0, 0, 5, 0);
		gbc_btnQunLKhch.gridx = 1;
		gbc_btnQunLKhch.gridy = 4;
		add(btnQunLKhch, gbc_btnQunLKhch);
		
		 btnQunLNh = new JButton("Qu\u1EA3n L\u00ED Nh\u00E0 Cung C\u1EA5p");
		GridBagConstraints gbc_btnQunLNh = new GridBagConstraints();
		gbc_btnQunLNh.insets = new Insets(0, 0, 5, 0);
		gbc_btnQunLNh.gridx = 1;
		gbc_btnQunLNh.gridy = 5;
		add(btnQunLNh, gbc_btnQunLNh);
		
		 btnQunLKho = new JButton("Qu\u1EA3n L\u00ED Kho");
		GridBagConstraints gbc_btnQunLKho = new GridBagConstraints();
		gbc_btnQunLKho.insets = new Insets(0, 0, 5, 0);
		gbc_btnQunLKho.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnQunLKho.gridx = 1;
		gbc_btnQunLKho.gridy = 6;
		add(btnQunLKho, gbc_btnQunLKho);
		
		btnAbout = new JButton("About");
		GridBagConstraints gbc_btnAbout = new GridBagConstraints();
		gbc_btnAbout.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbout.insets = new Insets(0, 0, 5, 0);
		gbc_btnAbout.gridx = 1;
		gbc_btnAbout.gridy = 7;
		add(btnAbout, gbc_btnAbout);
		
		btnExit = new JButton("Exit");
		GridBagConstraints gbc_btnExit = new GridBagConstraints();
		gbc_btnExit.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnExit.gridx = 1;
		gbc_btnExit.gridy = 8;
		add(btnExit, gbc_btnExit);

	}

}
