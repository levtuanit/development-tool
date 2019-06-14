package com.mitrais.development.tool.controller;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.mitrais.development.tool.service.InstallService;
import com.mitrais.development.tool.view.AppUI;
import com.mitrais.development.tool.view.InstallationTab;

public class InstallController {

	private InstallationTab installationTab;
	private InstallService installService;

	public InstallController(AppUI appUI, InstallService installService) {
		this.installationTab = appUI.getInstallationTab();
		this.installService = installService;
	}

	public void init() {
		this.installationTab.getBtnPathFolderSelection().addActionListener(e -> selectFileZip());
		this.installationTab.getBtnInstall().addActionListener(e -> installPatch());
	}

	private void selectFileZip() {
		JFileChooser fileChooser = openDialogToSelectZipFile();

		int whichChoose = fileChooser.showOpenDialog(null);
		if (whichChoose == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getPath();
			installationTab.getTxtPatchFolder().setText(path);
			handleValidFile(path);
		}
	}

	private JFileChooser openDialogToSelectZipFile() {
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Select a patch");
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("patch_yyyymmdd_.zip", "zip");
		fileChooser.addChoosableFileFilter(filter);
		return fileChooser;
	}

	private void handleValidFile(String path) {
		boolean isValid = this.installService.checkValidFile(path);
		JLabel lblValidFile = installationTab.getLblValidFile();
		JButton btnInstall = installationTab.getBtnInstall();
		if (isValid) {
			btnInstall.setEnabled(true);
			lblValidFile.setText("");
		} else {
			btnInstall.setEnabled(false);
			lblValidFile.setText("File selected is not valid");
		}
	}

	private void installPatch() {

	}
}
