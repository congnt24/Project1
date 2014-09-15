package salesmanaging;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.Border;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener{

	private JFrame frame;

	public static LeftPanel leftPanel=new LeftPanel();
	MainPanel mainPanel=new MainPanel();
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
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 400);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.add(leftPanel, BorderLayout.WEST);
		frame.add(mainPanel, BorderLayout.CENTER);
		leftPanel.btnAbout.addActionListener(this);
		leftPanel.btnNhpHngHa.addActionListener(this);
		leftPanel.btnXutHngHa.addActionListener(this);
		leftPanel.btnQuanLHng.addActionListener(this);
		leftPanel.btnQunLKhch.addActionListener(this);
		leftPanel.btnQunLKho.addActionListener(this);
		leftPanel.btnQunLNh.addActionListener(this);
		leftPanel.btnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if (obj==leftPanel.btnNhpHngHa) {
			mainPanel.cardLayout.show(mainPanel, "1");
		}else if (obj==leftPanel.btnXutHngHa) {
			mainPanel.cardLayout.show(mainPanel, "8");
		}else if(obj==leftPanel.btnQuanLHng){
			mainPanel.cardLayout.show(mainPanel, "2");
		}else if (obj==leftPanel.btnQunLKhch) {
			mainPanel.cardLayout.show(mainPanel, "3");
		}else if (obj==leftPanel.btnQunLNh) {
			mainPanel.cardLayout.show(mainPanel, "4");
		}else if (obj==leftPanel.btnQunLKho) {
			mainPanel.cardLayout.show(mainPanel, "5");
		}else if (obj==leftPanel.btnAbout) {
			mainPanel.cardLayout.show(mainPanel, "6");
		}else if (obj==leftPanel.btnExit) {
			System.exit(0);
		}
	}

}
