package com.mitrais.development.tool;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.mitrais.development.tool.controller.Controller;
import com.mitrais.development.tool.controller.InstallController;
import com.mitrais.development.tool.service.InstallService;
import com.mitrais.development.tool.service.InstallServiceImpl;
import com.mitrais.development.tool.view.AppUI;

public class Application {
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		UIManager.setLookAndFeel(
	            UIManager.getSystemLookAndFeelClassName());
		AppUI appUI = new AppUI();
		Controller controller = new Controller(appUI);
		controller.initController();

		InstallService installService = new InstallServiceImpl();
		InstallController installController = new InstallController(appUI, installService);
		installController.init();
	}
}
