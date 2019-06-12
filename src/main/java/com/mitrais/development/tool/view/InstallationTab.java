package com.mitrais.development.tool.view;

import java.awt.Color;
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
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.filechooser.FileSystemView;
import javax.swing.text.AttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;

public class InstallationTab {
	static StringBuilder installationProgress = new StringBuilder();

	public static JPanel create() {
		JPanel InstallPanel = new JPanel();
		InstallPanel.setBorder(null);
		InstallPanel.setLayout(null);

		JLabel lblPatchFolder = new JLabel("Patch file");
		lblPatchFolder.setBounds(10, 9, 79, 14);
		InstallPanel.add(lblPatchFolder);

		final JTextField txtPatchFolder = new JTextField();
		txtPatchFolder.setBounds(10, 26, 582, 20);
		txtPatchFolder.setColumns(10);
		InstallPanel.add(txtPatchFolder);

		JButton btnPathFolderSelection = new JButton("Select");
		btnPathFolderSelection.setBounds(602, 26, 79, 21);
		InstallPanel.add(btnPathFolderSelection);

		final JButton btnInstall = new JButton("Install");
		btnInstall.setEnabled(false);
		btnInstall.setBounds(592, 443, 89, 23);
		InstallPanel.add(btnInstall);

		final JButton btnRollBack = new JButton("Rollback");
		btnRollBack.setEnabled(false);
		btnRollBack.setBounds(493, 443, 89, 23);
		InstallPanel.add(btnRollBack);

		JLabel lblLog = new JLabel("Log");
		lblLog.setBounds(10, 57, 46, 14);
		InstallPanel.add(lblLog);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 82, 681, 350);
		InstallPanel.add(scrollPane);

		final JTextPane txtLog = new JTextPane();
		txtLog.setEditable(true);
		scrollPane.setViewportView(txtLog);

		btnPathFolderSelection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				fileChooser.setDialogTitle("Select a patch");
				fileChooser.setAcceptAllFileFilterUsed(false);
				FileNameExtensionFilter filter = new FileNameExtensionFilter("patch_yyyymmdd_.zip", "zip");
				fileChooser.addChoosableFileFilter(filter);

				int returnValue = fileChooser.showOpenDialog(null);
				if (returnValue == JFileChooser.APPROVE_OPTION) {
					txtPatchFolder.setText(fileChooser.getSelectedFile().getPath());
					btnInstall.setEnabled(true);
				}

			}
		});

		btnInstall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				appendToPane(txtLog, "\n ------------------------------------- ", Color.BLACK);
				appendToPane(txtLog, "\n  BACKUP Process", Color.BLACK);
				appendToPane(txtLog, "\n ------------------------------------- ", Color.BLACK);
				appendToPane(txtLog, "\n\n ------------------------------------- ", Color.BLACK);
				appendToPane(txtLog, "\n  INSTALLATION Process", Color.BLACK);
				appendToPane(txtLog, "\n ------------------------------------- ", Color.BLACK);
				appendToPane(txtLog, "\n- Stop tomcat for app", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Extract mms_20190607_130134_webapp.zip in common\\install", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Copy mms to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\mms", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Extract mms_20190607_130134_version_control.zip in common\\install",
						Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Copy mms to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\mms", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Stop tomcat for jasper ... OK ", Color.BLACK);
				appendToPane(txtLog, "\n- Extract mms_20190607_130134_report.zip in common\\install", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog,
						"\n- Copy file jaspers to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\mms\\WEB-INF\\lib\\mms-ppbsb-poly-report-template.jar",
						Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Run precompile command", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog,
						"\n- Extract mms_20190607_130134_configuration_files_prod.zip in prodcution\\install",
						Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog,
						"\n- Copy file applicationContext-hibernate.xml to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\mms\\WEB-INF\\classes",
						Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Extract mms_20190607_130134_sql_script.zip in common\\install", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Execute 01_ddl_changes.sql", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n- Execute 02_ddl_changes_function.sql", Color.BLACK);
				appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
				appendToPane(txtLog, "\n --------------------------------------------------------- ", Color.BLACK);
				appendToPane(txtLog, "\n  PATCH INSTALLED SUCCESSFULLY! ", new Color(38, 153, 0));
				appendToPane(txtLog, "\n --------------------------------------------------------- ", Color.BLACK);
				int input = JOptionPane.showConfirmDialog(null, "Do you want to restart app and jasper tomcat?", "",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				btnRollBack.setEnabled(true);
				// 0=ok, 2=cancel
				if (input == 0) {
					appendToPane(txtLog, "\n- App and jasper tomcat are restarted ... Failed", Color.RED);
				}
			}
		});

		btnRollBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int input = JOptionPane.showConfirmDialog(null, "Are you sure to rollback to patch_20190607_130134?",
						"", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null);
				// 0=ok, 2=cancel
				if (input == 0) {
					appendToPane(txtLog, "\n\n --------------------------------------------------------- ",
							Color.BLACK);
					appendToPane(txtLog, "\n  ROLLBACK to patch_20190607_130134 ", new Color(38, 153, 0));
					appendToPane(txtLog, "\n --------------------------------------------------------- ", Color.BLACK);
					appendToPane(txtLog, "\n- Stop app and jasper tomcat service", Color.BLACK);
					appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
					appendToPane(txtLog, "\n- Rename mms of D:\\Tools\\apache-tomcat-6.0.26\\webapps\\ to mss_old",
							Color.BLACK);
					appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
					appendToPane(txtLog,
							"\n- Cut mss_old of D:\\Tools\\apache-tomcat-6.0.26\\webapps\\ to D:\\Backup\\20190607_130134",
							Color.BLACK);
					appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
					appendToPane(txtLog,
							"\n- Extract mss.zip of D:\\Backup\\20190607_130134 to D:\\Tools\\apache-tomcat-6.0.26\\webapps\\",
							Color.BLACK);
					appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
					appendToPane(txtLog, "\n- Delete D:\\Tools\\apache-tomcat-6.0.26\\work\\Catalina\\localhost\\mms",
							Color.BLACK);
					appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
					appendToPane(txtLog, "\n- Execute 97_ddl_rollback.sql ", Color.BLACK);
					appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
					appendToPane(txtLog, "\n- Execute 98_ddl_rollback_function.sql ", Color.BLACK);
					appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
					int restartTomcatInput = JOptionPane.showConfirmDialog(null,
							"Do you want to restart app and jasper tomcat?", "", JOptionPane.OK_CANCEL_OPTION,
							JOptionPane.INFORMATION_MESSAGE, null);
					appendToPane(txtLog, "\n --------------------------------------------------------- ", Color.BLACK);
					appendToPane(txtLog, "\n-  Rollbacked to patch_20190607_130134 successfully! ", Color.BLACK);
					appendToPane(txtLog, "\n --------------------------------------------------------- ", Color.BLACK);
					// 0=ok, 2=cancel
					if (restartTomcatInput == 0) {
						appendToPane(txtLog, "\n- App and jasper tomcat are restarted!!!", Color.BLACK);
						appendToPane(txtLog, " ... OK", new Color(38, 153, 0));
					}
				}
			}
		});

		return InstallPanel;
	}

	private static void appendToPane(JTextPane tp, String msg, Color c) {
		StyleContext sc = StyleContext.getDefaultStyleContext();
		AttributeSet aset = sc.addAttribute(SimpleAttributeSet.EMPTY, StyleConstants.Foreground, c);

		aset = sc.addAttribute(aset, StyleConstants.FontFamily, "Lucida Console");
		aset = sc.addAttribute(aset, StyleConstants.Alignment, StyleConstants.ALIGN_JUSTIFIED);
		tp.setCharacterAttributes(aset, false);
		tp.replaceSelection(msg);
	}
}
