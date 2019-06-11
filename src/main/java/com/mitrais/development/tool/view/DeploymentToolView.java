package com.mitrais.development.tool.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class DeploymentToolView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame mainFrame;
	private JPanel configPanel;
	private JPanel installPanel;
	private JTextField tomcatLocationTxt;
	private JButton tomcatLocationBtn;
	private JTabbedPane jTabbedPane;

	
	public JButton getTomcatLocationBtn() {
		return tomcatLocationBtn;
	}

	public void setTomcatLocationBtn(JButton tomcatLocationBtn) {
		this.tomcatLocationBtn = tomcatLocationBtn;
	}

	public DeploymentToolView() {
		createView();
		showConfigLayout();
	}

	public void createView() {
		mainFrame = new JFrame("Deployment Tool Automatically");
		mainFrame.setSize(600, 600);

		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		
		jTabbedPane= new  JTabbedPane();
	
		
		//Tab 1: Configuration
		configPanel = new JPanel();
		jTabbedPane.add(configPanel,"Configuration");
		
		
		
		//Tab 2: Installation
		installPanel = new JPanel();
		jTabbedPane.add(installPanel,"Installation");
		
		mainFrame.add(jTabbedPane);
		mainFrame.setVisible(true);
	}
	
	 public void showConfigLayout(){
		  tomcatLocationTxt = new JTextField(15);
		  tomcatLocationBtn = new JButton("Select");
	      JPanel panel = new JPanel();
	      panel.setSize(500,500);
	      GridBagLayout layout = new GridBagLayout();

	      panel.setLayout(layout);        
	      GridBagConstraints gbc = new GridBagConstraints();

	      gbc.fill = GridBagConstraints.HORIZONTAL;
	      gbc.gridx = 0;
	      gbc.gridy = 0;
	      panel.add(tomcatLocationTxt,gbc);

	      gbc.gridx = 1;
	      gbc.gridy = 0;
	      panel.add(tomcatLocationBtn,gbc); 

	      configPanel.add(panel);
	      mainFrame.setVisible(true);  
	   }

//	public static void main(String[] args) {
//			DeploymentToolView deploymentToolView = new DeploymentToolView();
//			deploymentToolView.showConfigLayout();
//	}

}
