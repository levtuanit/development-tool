package com.mitrais.development.tool.view;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class InstallationTab {
	public static JPanel create() {
		JPanel InstallPanel = new JPanel();
		InstallPanel.setLayout(null);

		JLabel lblPatchFolder = new JLabel("Patch file");
		lblPatchFolder.setBounds(10, 9, 79, 14);
		InstallPanel.add(lblPatchFolder);

		JTextField txtPatchFolder = new JTextField();
		txtPatchFolder.setBounds(10, 26, 213, 20);
		txtPatchFolder.setColumns(10);
		InstallPanel.add(txtPatchFolder);

		JButton btnPathFolderSelection = new JButton("Select");
		btnPathFolderSelection.setBounds(233, 25, 79, 21);
		InstallPanel.add(btnPathFolderSelection);

		JButton btnInstall = new JButton("Install");
		btnInstall.setBounds(10, 278, 89, 23);
		InstallPanel.add(btnInstall);

		JButton btnRollBack = new JButton("Rollback");
		btnRollBack.setEnabled(false);
		btnRollBack.setBounds(122, 278, 89, 23);
		InstallPanel.add(btnRollBack);

		JLabel lblLog = new JLabel("Log");
		lblLog.setBounds(10, 57, 46, 14);
		InstallPanel.add(lblLog);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 82, 352, 185);
		InstallPanel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);

		return InstallPanel;
	}
}
