package com.mitrais.development.tool.view;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class ConfigTab {
	public static JPanel create() {
		JPanel configPanel = new JPanel();
		configPanel.setLayout(null);

		JLabel lblEnvironment = new JLabel("Environment");
		lblEnvironment.setBounds(10, 11, 72, 14);
		configPanel.add(lblEnvironment);

		JRadioButton rdbtnProduction = new JRadioButton("Production");
		rdbtnProduction.setBounds(97, 7, 89, 23);
		configPanel.add(rdbtnProduction);

		JRadioButton rdbtnTesting = new JRadioButton("Testing");
		rdbtnTesting.setBounds(191, 7, 109, 23);
		configPanel.add(rdbtnTesting);
		ButtonGroup enviromentGroup = new ButtonGroup();
		enviromentGroup.add(rdbtnProduction);
		enviromentGroup.add(rdbtnTesting);

		JTextField txtTomcatPath = new JTextField();
		txtTomcatPath.setBounds(10, 57, 260, 20);
		configPanel.add(txtTomcatPath);
		txtTomcatPath.setColumns(10);

		JButton btnTomcatPathSelection = new JButton("Select");
		btnTomcatPathSelection.setBounds(280, 56, 89, 23);
		configPanel.add(btnTomcatPathSelection);

		JLabel lblTomcatPath = new JLabel("Tomcat Path");
		lblTomcatPath.setBounds(10, 36, 72, 23);
		configPanel.add(lblTomcatPath);

		JLabel lblBackupFolder = new JLabel("Backup Folder");
		lblBackupFolder.setBounds(10, 88, 109, 14);
		configPanel.add(lblBackupFolder);

		JTextField txtBackupPath = new JTextField();
		txtBackupPath.setBounds(10, 106, 260, 20);
		configPanel.add(txtBackupPath);
		txtBackupPath.setColumns(10);

		JButton btnBackupPathSelection = new JButton("Select");
		btnBackupPathSelection.setBounds(280, 105, 89, 23);
		configPanel.add(btnBackupPathSelection);

		JLabel lblNewLabel = new JLabel("Database Connection");
		lblNewLabel.setBounds(10, 137, 139, 14);
		configPanel.add(lblNewLabel);

		JLabel lblPort = new JLabel("Port");
		lblPort.setBounds(20, 188, 64, 14);
		configPanel.add(lblPort);

		JTextField txtUsername = new JTextField();
		txtUsername.setBounds(94, 216, 251, 20);
		configPanel.add(txtUsername);
		txtUsername.setColumns(10);

		JTextField textPassword = new JTextField();
		textPassword.setBounds(94, 244, 251, 20);
		configPanel.add(textPassword);
		textPassword.setColumns(10);

		JTextField txtHostname = new JTextField();
		txtHostname.setBounds(94, 154, 251, 20);
		configPanel.add(txtHostname);
		txtHostname.setColumns(10);

		JTextField txtPort = new JTextField();
		txtPort.setBounds(94, 185, 251, 20);
		configPanel.add(txtPort);
		txtPort.setColumns(10);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(20, 221, 64, 14);
		configPanel.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(20, 247, 64, 14);
		configPanel.add(lblPassword);

		JLabel lblHostname = new JLabel("Hostname");
		lblHostname.setBounds(20, 157, 62, 14);
		configPanel.add(lblHostname);

		JButton btnSave = new JButton("Save");
		btnSave.setBounds(20, 327, 89, 23);
		configPanel.add(btnSave);

		JLabel lblSchema = new JLabel("Schema");
		lblSchema.setBounds(20, 281, 64, 14);
		configPanel.add(lblSchema);

		JTextField txtSchema = new JTextField();
		txtSchema.setColumns(10);
		txtSchema.setBounds(94, 278, 251, 20);
		configPanel.add(txtSchema);

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(10, 151, 358, 265);
		configPanel.add(editorPane);

		return configPanel;
	}
}
