package com.mitrais.development.tool.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AppUI {

	private JFrame frame;

	public AppUI() {
		initialize();
	}

	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Patch Deployment Automation");
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, 0, 696, 505);
		frame.getContentPane().add(tabbedPane);

		JPanel configPanel = ConfigTab.create();
		tabbedPane.addTab("Configuration", configPanel);
		
		JPanel installPanel = InstallationTab.create();
		tabbedPane.addTab("Installation", installPanel);
		
		tabbedPane.setSelectedComponent(installPanel);
	}
}
