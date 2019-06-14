package com.mitrais.development.tool.controller;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

import com.mitrais.development.tool.utils.ZipFileHandler;
import com.mitrais.development.tool.view.AppUI;
import com.mitrais.development.tool.view.InstallationTab;

public class InstallController {

	private InstallationTab installationTab;

	public InstallController(AppUI appUI) {
		this.installationTab = appUI.getInstallationTab();
	}

	public void init() {
		this.installationTab.getBtnPathFolderSelection().addActionListener(e -> selectFileZip());
		this.installationTab.getTxtPatchFolder().addFocusListener(new FocusAdapter() {

			@Override
			public void focusLost(FocusEvent e) {
				String path = installationTab.getTxtPatchFolder().getText();
				if (path.isEmpty()) {
					return;
				}
				JButton btnInstall = installationTab.getBtnInstall();
				JLabel lblValidFile = installationTab.getLblValidFile();
				try {
					handleValidFile(path, btnInstall, lblValidFile);
				} catch (IOException e1) {
					btnInstall.setEnabled(false);
					lblValidFile.setText("File selected is not valid");
					e1.printStackTrace();
				}
			}
		});
	}

	private void handleValidFile(String path, JButton btnInstall, JLabel lblValidFile) throws IOException {
		boolean isValid = ZipFileHandler.checkValid(path);
		if (isValid) {
			btnInstall.setEnabled(true);
			lblValidFile.setText("");
		} else {
			btnInstall.setEnabled(false);
			lblValidFile.setText("File selected is not valid");
		}
	}

	private void selectFileZip() {
		JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
		fileChooser.setDialogTitle("Select a patch");
		fileChooser.setAcceptAllFileFilterUsed(false);
		FileNameExtensionFilter filter = new FileNameExtensionFilter("patch_yyyymmdd_.zip", "zip");
		fileChooser.addChoosableFileFilter(filter);

		int returnValue = fileChooser.showOpenDialog(null);
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			String path = fileChooser.getSelectedFile().getPath();
			installationTab.getTxtPatchFolder().setText(path);
			JButton btnInstall = installationTab.getBtnInstall();
			JLabel lblValidFile = installationTab.getLblValidFile();
			try {
				handleValidFile(path, btnInstall, lblValidFile);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
