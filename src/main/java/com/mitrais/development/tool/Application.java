package com.mitrais.development.tool;

import com.mitrais.development.tool.controller.Controller;
import com.mitrais.development.tool.controller.InstallController;
import com.mitrais.development.tool.view.AppUI;

public class Application {
	public static void main(String[] args) {
		AppUI appUI = new AppUI();
		Controller controller = new Controller(appUI);
		controller.initController();

		InstallController installController = new InstallController(appUI);
		installController.init();
	}
}
