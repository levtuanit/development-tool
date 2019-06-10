package com.mitrais.development.tool.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class DeploymentToolView extends JFrame {

	private static final long serialVersionUID = 1L;

	private JFrame mainFrame;
	private JPanel configPanel;
	private JPanel installPanel;
	private JTabbedPane jTabbedPane;

	public DeploymentToolView() {
		createView();
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
	      JPanel panel = new JPanel();
	      panel.setSize(500,500);
	      GridBagLayout layout = new GridBagLayout();

	      panel.setLayout(layout);        
	      GridBagConstraints gbc = new GridBagConstraints();

	      gbc.fill = GridBagConstraints.HORIZONTAL;
	      gbc.gridx = 0;
	      gbc.gridy = 0;
	      panel.add(new JButton("Button 1"),gbc);

	      gbc.gridx = 1;
	      gbc.gridy = 0;
	      panel.add(new JButton("Button 2"),gbc); 

	      gbc.fill = GridBagConstraints.HORIZONTAL;
//	      gbc.ipady = 20;   
	      gbc.gridx = 0;
	      gbc.gridy = 1;
	      panel.add(new JButton("Button 3"),gbc); 

	      gbc.gridx = 1;
	      gbc.gridy = 1;       
	      panel.add(new JButton("Button 4"),gbc);  

	      gbc.gridx = 0;
	      gbc.gridy = 2;      
	      gbc.fill = GridBagConstraints.HORIZONTAL;
	      gbc.gridwidth = 2;
	      panel.add(new JButton("Button 5"),gbc); 
	      configPanel.add(panel);
	      mainFrame.setVisible(true);  
	   }

	public static void main(String[] args) {
			DeploymentToolView deploymentToolView = new DeploymentToolView();
			deploymentToolView.showConfigLayout();
	}

}
