package com.mitrais.development.tool.controller;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.mitrais.development.tool.service.InstallService;
import com.mitrais.development.tool.utils.CommonConstant;
import com.mitrais.development.tool.utils.Message;
import com.mitrais.development.tool.view.AppUI;
import com.mitrais.development.tool.view.InstallationTab;

public class InstallController {

	private static final String PATCH_NAME_CONVENTION = "patch_yyyymmdd_.zip";
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
		JFileChooser fileChooser = this.openDialogToSelectZipFile();
		int whichChoose = fileChooser.showOpenDialog(null);
		if (whichChoose == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getPath();
			installationTab.getTxtPatchFolder().setText(path);
			handleValidFile(path);
		}
	}

	private JFileChooser openDialogToSelectZipFile() {
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle(Message.get("patch-file-selection"));
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter(PATCH_NAME_CONVENTION,
				CommonConstant.ZIP_EXTENSION);
		fileChooser.addChoosableFileFilter(filter);
		return fileChooser;
	}

	private void handleValidFile(String path) {
		JLabel lblValidFile = installationTab.getLblValidFile();
		JButton btnInstall = installationTab.getBtnInstall();
		boolean isValid = this.installService.checkValidFile(path);
		if (isValid) {
			btnInstall.setEnabled(true);
			lblValidFile.setText("");
		} else {
			btnInstall.setEnabled(false);
			lblValidFile.setText(Message.get("invalid-file"));
		}
	}

	private void installPatch() {
		this.installService.install(installationTab.getTxtPatchFolder().getText());
	}
}
