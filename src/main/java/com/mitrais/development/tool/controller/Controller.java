package com.mitrais.development.tool.controller;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.google.gson.Gson;
import com.mitrais.development.tool.model.Configuration;
import com.mitrais.development.tool.service.ServiceImpl;
import com.mitrais.development.tool.view.AppUI;

public class Controller {
	
	private final static String CONFIG_FILE = "src/config/config.txt";
	private AppUI appUI;
	private ServiceImpl serviceImpl;

	public Controller( AppUI appUI) {
		this.appUI = appUI;
		serviceImpl = new ServiceImpl();
		showConfiguration();
	}

	public void initController() {
		appUI.getConfigTab().getBtnTomcatPathSelection().addActionListener(e -> selectPath("tomcatPath"));
		appUI.getConfigTab().getBtnBackupPathSelection().addActionListener(e -> selectPath("backupPath"));
		appUI.getConfigTab().getBtnSave().addActionListener(e -> saveConfiguration());
	}

	private void selectPath(String type) {
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		chooser.setAcceptAllFileFilterUsed(false);
		if (chooser.showOpenDialog(appUI) == JFileChooser.APPROVE_OPTION) {
			if ("tomcatPath".equals(type)) {
				appUI.getConfigTab().getTxtTomcatPath().setText(chooser.getSelectedFile().toString());
			}

			else if ("backupPath".equals(type)) {
				appUI.getConfigTab().getTxtBackupPath().setText(chooser.getSelectedFile().toString());
			}

		} else {
		}
	}

	private void saveConfiguration() {
		String textTomcatPath = appUI.getConfigTab().getTxtTomcatPath().getText();
		String textBackupPath = appUI.getConfigTab().getTxtBackupPath().getText();
		String textUsername = appUI.getConfigTab().getTxtUsername().getText();
		String textPassword = appUI.getConfigTab().getTxtPassword().getText();
		String textHostname = appUI.getConfigTab().getTxtHostname().getText();
		String textPort = appUI.getConfigTab().getTxtPort().getText();
		String textSchema = appUI.getConfigTab().getTxtSchema().getText();
		String environment = appUI.getConfigTab().getEnviromentGroup().getSelection().getActionCommand();
		Gson gson;
		Configuration configuration;
		if (!textTomcatPath.isEmpty() && !textBackupPath.isEmpty() && !textUsername.isEmpty() && !textPassword.isEmpty()
				&& !textHostname.isEmpty() && !textPort.isEmpty() && !textSchema.isEmpty()) {
			configuration = new Configuration(environment, textBackupPath, textTomcatPath, textHostname, textPort,
					textUsername, textPassword, textSchema);
			gson = new Gson();
			String jsonConfiguration = gson.toJson(configuration);
			serviceImpl.writeToFile(CONFIG_FILE, jsonConfiguration);
			JOptionPane.showMessageDialog(appUI, serviceImpl.getMessage("message-save-succes"));
		} else {
			JOptionPane.showMessageDialog(appUI, serviceImpl.getMessage("message-fill-data-pls"), "WARNING",
					JOptionPane.WARNING_MESSAGE);
		}

	}

	private void showConfiguration() {
		Configuration configuration = readConfigFile();
		String environment;
		if (configuration != null) {
			appUI.getConfigTab().getTxtTomcatPath().setText(configuration.getTomcatPath());
			appUI.getConfigTab().getTxtUsername().setText(configuration.getUsername());
			appUI.getConfigTab().getTxtPassword().setText(configuration.getPassword());
			appUI.getConfigTab().getTxtHostname().setText(configuration.getHostname());
			appUI.getConfigTab().getTxtPort().setText(configuration.getPort());
			appUI.getConfigTab().getTxtSchema().setText(configuration.getSchema());
			appUI.getConfigTab().getTxtBackupPath().setText(configuration.getBackupPath());
			environment = configuration.getEnvironment();
			if ("Production".equalsIgnoreCase(environment)) {
				appUI.getConfigTab().getRdbtnProduction().setSelected(true);
			} else {
				appUI.getConfigTab().getRdbtnTesting().setSelected(true);
			}
		}

	}

	private Configuration readConfigFile() {
		Configuration configuration = null;
		String jsonCofigration = serviceImpl.readFile(CONFIG_FILE);
		Gson gson;
		if (jsonCofigration != null) {
			gson = new Gson();
			configuration = gson.fromJson(jsonCofigration, Configuration.class);
			return configuration;
		}
		return configuration;

	}

}
