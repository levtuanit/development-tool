package com.mitrais.development.tool.view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;

public class InstallationTab {
	static StringBuilder installationProgress = new StringBuilder();
	public static JPanel create() {
		JPanel InstallPanel = new JPanel();
		InstallPanel.setLayout(null);

		JLabel lblPatchFolder = new JLabel("Patch file");
		lblPatchFolder.setBounds(10, 9, 79, 14);
		InstallPanel.add(lblPatchFolder);

		final JTextField txtPatchFolder = new JTextField();
		txtPatchFolder.setBounds(10, 26, 213, 20);
		txtPatchFolder.setColumns(10);
		InstallPanel.add(txtPatchFolder);

		JButton btnPathFolderSelection = new JButton("Select");
		btnPathFolderSelection.setBounds(233, 25, 79, 21);
		InstallPanel.add(btnPathFolderSelection);

		final JButton btnInstall = new JButton("Install");
		btnInstall.setEnabled(false);
		btnInstall.setBounds(10, 278, 89, 23);
		InstallPanel.add(btnInstall);

		final JButton btnRollBack = new JButton("Rollback");
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

		final JTextArea textArea = new JTextArea();
		textArea.setTabSize(-1);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);
		textArea.setLineWrap(true);

		btnPathFolderSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				jfc.setDialogTitle("Select a patch");
				jfc.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("zip", "zip");
				jfc.addChoosableFileFilter(filter);

				int returnValue = jfc.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					System.out.println(jfc.getSelectedFile().getPath());
					txtPatchFolder.setText(jfc.getSelectedFile().getPath());
					btnInstall.setEnabled(true);
				}

			}
		});

		btnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				installationProgress = new StringBuilder();
				installationProgress.append("- Stop tomcat for app\n");
				installationProgress.append("- Extract mms_20190607_130134_webapp.zip in common\\install \n");
				installationProgress.append("- Copy mms to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\mms \n");
				installationProgress.append("- Extract mms_20190607_130134_version_control.zip in common\\install \n");
				installationProgress.append("- Copy mms to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\mms \n");
				installationProgress.append("- Stop tomcat for jasper\n");
				installationProgress.append("- Extract mms_20190607_130134_report.zip in common\\install \n");
				installationProgress.append(
						"- Copy file jaspers to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\mms\\WEB-INF\\lib\\mms-ppbsb-poly-report-template.jar \n");
				installationProgress.append("Run precompile command\n");
				installationProgress
						.append("- Extract mms_20190607_130134_configuration_files_prod.zip in prodcution\\install \n");
				installationProgress.append(
						"- Copy file applicationContext-hibernate.xml to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\mms\\WEB-INF\\classes \n");
				installationProgress.append("- Extract mms_20190607_130134_sql_script.zip in common\\install \n");
				installationProgress.append("- Execute 01_ddl_changes.sql \n");
				installationProgress.append("- Execute 02_ddl_changes_function.sql \n\n");
				installationProgress.append("- PATCH INSTALLED SUCCESSFULLY!!! \n");
				textArea.setText(installationProgress.toString());
				int input = JOptionPane.showConfirmDialog(null, "Do you want to restart app and jasper tomcat?", "",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				btnRollBack.setEnabled(true);
				// 0=ok, 2=cancel
				if (input == 0) {
					installationProgress.append("- App and jasper tomcat are restarted!!!\n");
					textArea.setText(installationProgress.toString());
				}
			}
		});

		btnRollBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to rollback to patch_20190607_130134?",
						"", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				// 0=ok, 2=cancel
				if (input == 0) {
					installationProgress.append("- Stop app and jasper tomcat service");
					installationProgress
							.append("- Rename mms of D:\\Tools\\apache-tomcat-6.0.26\\webapps\\ to mss_old");
					installationProgress.append(
							"- Cut mss_old of D:\\Tools\\apache-tomcat-6.0.26\\webapps\\ to D:\\Backup\\20190607_130134");
					installationProgress.append(
							"- Extract mss.zip of D:\\Backup\\20190607_130134 to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\");
					installationProgress
							.append("- Delete D:\\Tools\\apache-tomcat-6.0.26\\work\\Catalina\\localhost\\mms");
					installationProgress.append("- Execute 97_ddl_rollback.sql \n");
					installationProgress.append("- Execute 98_ddl_rollback_function.sql \n");
					textArea.setText(installationProgress.toString());
					int restartTomcatInput = JOptionPane.showConfirmDialog(null,
							"Do you want to restart app and jasper tomcat?", "", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null);
					// 0=ok, 2=cancel
					if (restartTomcatInput == 0) {
						installationProgress.append("- App and jasper tomcat are restarted!!!\n");
						textArea.setText(installationProgress.toString());
					}
				}
			}
		});

		return InstallPanel;
	}
}
