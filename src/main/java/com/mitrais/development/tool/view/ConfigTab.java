package com.mitrais.development.tool.view;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ConfigTab {

	private JLabel lblEnvironment;
	private JLabel lblNewLabel;
	private JLabel lblPort;
	private JLabel lblTomcatPath;
	private JLabel lblBackupFolder;
	private JLabel lblSchema;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblHostname;
	
	private JRadioButton rdbtnProduction;
	private JRadioButton rdbtnTesting;
	
	private JTextField txtTomcatPath;
	private JTextField txtUsername;
	private JTextField txtPassword;
	private JTextField txtHostname;
	private JTextField txtPort;
	private JTextField txtSchema;
	private JTextField txtBackupPath;
	
	private JButton btnTomcatPathSelection;
	private JButton btnBackupPathSelection;
	private JButton btnSave;
	
	private ButtonGroup enviromentGroup; 
	
	public ConfigTab() {

	}

	public JPanel create() {
		JPanel configPanel = new JPanel();
		configPanel.setLayout(null);
		
		
		//Select the environment 
		lblEnvironment = new JLabel("Environment");
		lblEnvironment.setBounds(10, 28, 72, 14);
		configPanel.add(lblEnvironment);

		rdbtnProduction = new JRadioButton("Production");
		rdbtnProduction.setSelected(true);
		rdbtnProduction.setActionCommand("Production");
		rdbtnProduction.setBounds(10, 49, 89, 23);
		configPanel.add(rdbtnProduction);

		rdbtnTesting = new JRadioButton("Testing");
		rdbtnTesting.setActionCommand("Testing");
		rdbtnTesting.setBounds(104, 49, 109, 23);
		configPanel.add(rdbtnTesting);
		enviromentGroup = new ButtonGroup();
		enviromentGroup.add(rdbtnProduction);
		enviromentGroup.add(rdbtnTesting);
		
		//Select Tomcat location
		txtTomcatPath = new JTextField();
		txtTomcatPath.setBounds(10, 100, 572, 20);
		configPanel.add(txtTomcatPath);
		txtTomcatPath.setColumns(10);
		
		btnTomcatPathSelection = new JButton("Select");
		btnTomcatPathSelection.setBounds(592, 100, 89, 20);
		configPanel.add(btnTomcatPathSelection);
		lblTomcatPath = new JLabel("Tomcat Path");
		lblTomcatPath.setBounds(10, 80, 109, 14);
		configPanel.add(lblTomcatPath);

		//Select the backup folder
		lblBackupFolder = new JLabel("Backup Folder");
		lblBackupFolder.setBounds(10, 130, 72, 23);
		configPanel.add(lblBackupFolder);
		txtBackupPath = new JTextField();
		txtBackupPath.setBounds(10, 150, 572, 20);
		configPanel.add(txtBackupPath);
		txtBackupPath.setColumns(10);

		btnBackupPathSelection = new JButton("Select");
		btnBackupPathSelection.setBounds(592, 151, 89, 20);
		configPanel.add(btnBackupPathSelection);
		
		//Fill the Database Connection
		lblNewLabel = new JLabel("Database Connection");
		lblNewLabel.setBounds(10, 185, 139, 15);
		configPanel.add(lblNewLabel);

		lblHostname = new JLabel("Hostname");
		lblHostname.setBounds(10, 215, 65, 15);
		configPanel.add(lblHostname);
		txtHostname = new JTextField();
		txtHostname.setBounds(10, 230, 250, 20);
		configPanel.add(txtHostname);
		txtHostname.setColumns(10);
		
		lblPort = new JLabel("Port");
		lblPort.setBounds(325, 215, 64, 15);
		configPanel.add(lblPort);
		txtPort = new JTextField();
		txtPort.setBounds(325, 230, 250, 20);
		configPanel.add(txtPort);
		txtPort.setColumns(10);

		lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 275, 65, 15);
		configPanel.add(lblUsername);
		txtUsername = new JTextField();
		txtUsername.setBounds(10, 290, 250, 20);
		configPanel.add(txtUsername);
		txtUsername.setColumns(10);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(325, 275, 65, 14);
		configPanel.add(lblPassword);
		txtPassword = new JTextField();
		txtPassword.setBounds(325, 290, 250, 20);
		configPanel.add(txtPassword);
		txtPassword.setColumns(10);

		lblSchema = new JLabel("Database name");
		lblSchema.setBounds(10, 330, 100, 14);
		configPanel.add(lblSchema);
		txtSchema = new JTextField();
		txtSchema.setColumns(10);
		txtSchema.setBounds(10, 345, 250, 20);
		configPanel.add(txtSchema);
		
		btnSave = new JButton("Save");
		btnSave.setBounds(590, 440, 80, 25);
		configPanel.add(btnSave);
		
		return configPanel;
	}
	
	
	

	public JTextField getTxtTomcatPath() {
		return txtTomcatPath;
	}

	public void setTxtTomcatPath(JTextField txtTomcatPath) {
		this.txtTomcatPath = txtTomcatPath;
	}

	public JTextField getTxtBackupPath() {
		return txtBackupPath;
	}

	public void setTxtBackupPath(JTextField txtBackupPath) {
		this.txtBackupPath = txtBackupPath;
	}
	
	

	public JTextField getTxtUsername() {
		return txtUsername;
	}

	public void setTxtUsername(JTextField txtUsername) {
		this.txtUsername = txtUsername;
	}

	public JTextField getTxtPassword() {
		return txtPassword;
	}

	public void setTxtPassword(JTextField txtPassword) {
		this.txtPassword = txtPassword;
	}

	public JTextField getTxtHostname() {
		return txtHostname;
	}

	public void setTxtHostname(JTextField txtHostname) {
		this.txtHostname = txtHostname;
	}

	public JTextField getTxtPort() {
		return txtPort;
	}

	public void setTxtPort(JTextField txtPort) {
		this.txtPort = txtPort;
	}

	public JTextField getTxtSchema() {
		return txtSchema;
	}

	public void setTxtSchema(JTextField txtSchema) {
		this.txtSchema = txtSchema;
	}

	public JButton getBtnTomcatPathSelection() {
		return btnTomcatPathSelection;
	}

	public void setBtnTomcatPathSelection(JButton btnTomcatPathSelection) {
		this.btnTomcatPathSelection = btnTomcatPathSelection;
	}

	public JButton getBtnBackupPathSelection() {
		return btnBackupPathSelection;
	}

	public void setBtnBackupPathSelection(JButton btnBackupPathSelection) {
		this.btnBackupPathSelection = btnBackupPathSelection;
	}

	public JButton getBtnSave() {
		return btnSave;
	}

	public void setBtnSave(JButton btnSave) {
		this.btnSave = btnSave;
	}

	public JRadioButton getRdbtnProduction() {
		return rdbtnProduction;
	}

	public void setRdbtnProduction(JRadioButton rdbtnProduction) {
		this.rdbtnProduction = rdbtnProduction;
	}

	public JRadioButton getRdbtnTesting() {
		return rdbtnTesting;
	}

	public void setRdbtnTesting(JRadioButton rdbtnTesting) {
		this.rdbtnTesting = rdbtnTesting;
	}

	public ButtonGroup getEnviromentGroup() {
		return enviromentGroup;
	}

	public void setEnviromentGroup(ButtonGroup enviromentGroup) {
		this.enviromentGroup = enviromentGroup;
	}
	
}
