package com.mitrais.development.tool.controller;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import com.mitrais.development.tool.view.AppUI;

public class Controller {
	private AppUI appUI;
	private JFileChooser chooser;

	private final static String SAVE_SUCCESS = "Save configuration succesfully !!!.";
	private final static String SELECT_TITLE = "Choose the Folder";
	private final static String MISSING_FIELD = "Fill data to all of the fields, please !!!";

	public Controller() {
		appUI = new AppUI();
		chooser = new JFileChooser();
	}

	public void initController() {
		appUI.getConfigTab().getBtnTomcatPathSelection().addActionListener(e -> selectPath("tomcatPath"));
		appUI.getConfigTab().getBtnBackupPathSelection().addActionListener(e -> selectPath("backupPath"));
		appUI.getConfigTab().getBtnSave().addActionListener(e -> saveConfiguration());
	}

	private void selectPath(String type) {
		chooser = new JFileChooser();
		chooser.setCurrentDirectory(new java.io.File("."));
		chooser.setDialogTitle(SELECT_TITLE);
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
		String textUsername = appUI.getConfigTab().getTxtUsername().getText();
		String textPassword = appUI.getConfigTab().getTxtPassword().getText();
		String textHostname = appUI.getConfigTab().getTxtHostname().getText();
		String textPort = appUI.getConfigTab().getTxtPort().getText();
		String textSchema = appUI.getConfigTab().getTxtSchema().getText();
		String textBackupPath = appUI.getConfigTab().getTxtBackupPath().getText();
//		 System.out.println(appUI.getConfigTab().getEnviromentGroup().getSelection().getActionCommand());
		if (!textTomcatPath.isEmpty() && !textBackupPath.isEmpty() && !textUsername.isEmpty() && !textPassword.isEmpty()
				&& !textHostname.isEmpty() && !textPort.isEmpty() && !textSchema.isEmpty()
				&& !textBackupPath.isEmpty()) {

			JOptionPane.showMessageDialog(appUI, SAVE_SUCCESS);
		} else {
//			if (textTomcatPath.isEmpty()) {
			JOptionPane.showMessageDialog(appUI, MISSING_FIELD, "WARNING", JOptionPane.WARNING_MESSAGE);
//			}
		}

	}
}
