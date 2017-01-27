package settings.view;

import java.awt.CardLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

import javax.swing.JFrame;
import javax.swing.JPanel;

import settings.control.Controller;

public class SettingsFrame extends JFrame
{
	private Controller controller;
	private JPanel panel;
	private CardLayout layout;

	public SettingsFrame(Controller controller)
	{
		super();
		this.controller = controller;
		layout = new CardLayout();
		this.panel = new JPanel(layout);
		panel.add(new MainMenu(controller),"Main");
		panel.add(new Settings(controller),"Settings");
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
	
	public void setPanel(String pan)
	{
		layout.show(panel, pan);
	}

}
