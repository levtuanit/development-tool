package com.mitrais.development.tool.view;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AppUI extends JFrame{ 

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private ConfigTab configTab;
	public AppUI() {
		configTab = new ConfigTab();
		initialize();
		getFrame().setVisible(true);
	}

	public JFrame getFrame() {
		return this.frame;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Patch Deployment Automation");
		frame.setBounds(100, 100, 400, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 400, 450);
		frame.getContentPane().add(tabbedPane);

		JPanel configPanel = configTab.create();
		tabbedPane.addTab("Configuration", configPanel);
		
		JPanel installPanel = InstallationTab.create();
		tabbedPane.addTab("Installation", installPanel);
		
		tabbedPane.setSelectedComponent(installPanel);
	}

	public ConfigTab getConfigTab() {
		return configTab;
	}

	public void setConfigTab(ConfigTab configTab) {
		this.configTab = configTab;
	}
	
}
