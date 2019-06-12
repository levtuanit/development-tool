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
	
//	private JEditorPane editorPane;

	public ConfigTab() {

	}

	public JPanel create() {
		JPanel configPanel = new JPanel();
		configPanel.setLayout(null);

		lblEnvironment = new JLabel("Environment");
		lblEnvironment.setBounds(10, 11, 72, 14);
		configPanel.add(lblEnvironment);

		rdbtnProduction = new JRadioButton("Production");
		rdbtnProduction.setSelected(true);
		rdbtnProduction.setActionCommand("Production");
		rdbtnProduction.setBounds(97, 7, 89, 23);
		configPanel.add(rdbtnProduction);

		rdbtnTesting = new JRadioButton("Testing");
		rdbtnTesting.setActionCommand("Testing");
		rdbtnTesting.setBounds(191, 7, 109, 23);
		configPanel.add(rdbtnTesting);
		enviromentGroup = new ButtonGroup();
		enviromentGroup.add(rdbtnProduction);
		enviromentGroup.add(rdbtnTesting);

		txtTomcatPath = new JTextField();
		txtTomcatPath.setBounds(10, 57, 260, 20);
		configPanel.add(txtTomcatPath);
		txtTomcatPath.setColumns(10);
		btnTomcatPathSelection = new JButton("Select");
		btnTomcatPathSelection.setBounds(280, 56, 89, 23);
		configPanel.add(btnTomcatPathSelection);

		lblTomcatPath = new JLabel("Tomcat Path");
		lblTomcatPath.setBounds(10, 36, 72, 23);
		configPanel.add(lblTomcatPath);

		lblBackupFolder = new JLabel("Backup Folder");
		lblBackupFolder.setBounds(10, 88, 109, 14);
		configPanel.add(lblBackupFolder);

		txtBackupPath = new JTextField();
		txtBackupPath.setBounds(10, 106, 260, 20);
		configPanel.add(txtBackupPath);
		txtBackupPath.setColumns(10);

		btnBackupPathSelection = new JButton("Select");
		btnBackupPathSelection.setBounds(280, 105, 89, 23);
		configPanel.add(btnBackupPathSelection);

		lblNewLabel = new JLabel("Database Connection");
		lblNewLabel.setBounds(10, 137, 139, 14);
		configPanel.add(lblNewLabel);

		lblPort = new JLabel("Port");
		lblPort.setBounds(20, 188, 64, 14);
		configPanel.add(lblPort);
		txtUsername = new JTextField();
		txtUsername.setBounds(94, 216, 251, 20);
		configPanel.add(txtUsername);
		txtUsername.setColumns(10);

		txtPassword = new JTextField();
		txtPassword.setBounds(94, 244, 251, 20);
		configPanel.add(txtPassword);
		txtPassword.setColumns(10);

		txtHostname = new JTextField();
		txtHostname.setBounds(94, 154, 251, 20);
		configPanel.add(txtHostname);
		txtHostname.setColumns(10);

		txtPort = new JTextField();
		txtPort.setBounds(94, 185, 251, 20);
		configPanel.add(txtPort);
		txtPort.setColumns(10);

		lblUsername = new JLabel("Username");
		lblUsername.setBounds(20, 221, 64, 14);
		configPanel.add(lblUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 247, 64, 14);
		configPanel.add(lblPassword);

		lblHostname = new JLabel("Hostname");
		lblHostname.setBounds(20, 157, 62, 14);
		configPanel.add(lblHostname);

		btnSave = new JButton("Save");
		btnSave.setBounds(150, 327, 89, 23);
		configPanel.add(btnSave);

		lblSchema = new JLabel("Schema");
		lblSchema.setBounds(20, 281, 64, 14);
		configPanel.add(lblSchema);

		txtSchema = new JTextField();
		txtSchema.setColumns(10);
		txtSchema.setBounds(94, 278, 251, 20);
		configPanel.add(txtSchema);

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
