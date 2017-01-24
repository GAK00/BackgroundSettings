package settings.view;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;

import settings.control.Controller;

public class SettingsFrame extends JFrame
{
	private Controller controller;
	private MainMenu panel;

	public SettingsFrame(Controller controller)
	{
		super();
		this.controller = controller;
		this.panel = new MainMenu();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setup();
	}

	private void setup()
	{
		this.setTitle("Desktop Settings");
		GraphicsDevice Screen = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		int screenWidth = Screen.getDisplayMode().getWidth();
		int screenHeight = Screen.getDisplayMode().getHeight();
		int windowWidth = ((screenWidth) - ((screenWidth) / 4));
		int windowHeight = ((screenHeight) - ((screenHeight) / 4));
		this.setSize(windowWidth, windowHeight);
		int posX = (screenWidth - windowWidth) / 2;
		int posY = (screenHeight - windowHeight) / 2;
		this.setLocation(posX, posY);
		this.setContentPane(panel);
		this.setVisible(true);
	}

}
