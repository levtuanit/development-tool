package com.mitrais.development.tool.controller;

import java.io.File;

import javax.swing.JFileChooser;

import com.mitrais.development.tool.service.ServiceImpl;
import com.mitrais.development.tool.view.DeploymentToolView;

public class Controller {
	private DeploymentToolView toolView;
	private ServiceImpl serviceImpl;
	private JFileChooser fc;

	public Controller() {
		toolView = new DeploymentToolView();
		serviceImpl = new ServiceImpl();
		fc = new JFileChooser();
		
	}

	public void initController() {
		toolView.getTomcatLocationBtn().addActionListener(e -> selectFile());
	}
	
	private String selectFile() {
		System.out.println("OK");
		int returnVal = fc.showOpenDialog(toolView);
		 if (returnVal == JFileChooser.APPROVE_OPTION) {
                File file = fc.getSelectedFile();
                //This is where a real application would open the file.
                System.out.println("Opening: " + file.getName() + ".");
            } else {
            	 System.out.println("Open command cancelled by user.");
            }
		return "Done";
	}

}
