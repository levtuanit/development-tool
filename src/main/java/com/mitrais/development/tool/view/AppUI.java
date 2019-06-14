package com.mitrais.development.tool.view;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class AppUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private ConfigTab configTab;
	private InstallationTab installationTab;
	private ImageIcon img;
	private static final String IMG_PATH = "src/images/KMS_Logo.png";

	public AppUI() {
		configTab = new ConfigTab();
		installationTab = new InstallationTab();
		img = new ImageIcon(IMG_PATH);
		initialize();
		getFrame().setIconImage(img.getImage());
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
		frame.setResizable(false);
		frame.setBounds(100, 100, 700, 530);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBorder(null);
		tabbedPane.setBounds(0, 0, 696, 505);
		frame.getContentPane().add(tabbedPane);

		JPanel configPanel = configTab.create();
		tabbedPane.addTab("Configuration", configPanel);

		JPanel installPanel = installationTab.create();
		tabbedPane.addTab("Installation", installPanel);

		tabbedPane.setSelectedComponent(installPanel);
	}

	public ConfigTab getConfigTab() {
		return configTab;
	}

	public void setConfigTab(ConfigTab configTab) {
		this.configTab = configTab;
	}

	public InstallationTab getInstallationTab() {
		return installationTab;
	}

}
