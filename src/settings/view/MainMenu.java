package settings.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class MainMenu extends JPanel
{

	private JButton update;
	private JButton settings;
	private JButton updateInfo;
	private JButton fix;
	private JButton setBackground;
	private SpringLayout layout;

	public MainMenu()
	{
		super();
		update = new JButton("Check for Updates");
		settings = new JButton("Settings");
		updateInfo = new JButton("Update UserName/Password");
		fix = new JButton("Attempt a Fix");
		setBackground = new JButton("Set Background/Add to SlideShow");
		layout = new SpringLayout();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupPanel()
	{
		this.setLayout(layout);
		this.add(update);
		this.add(settings);
		this.add(updateInfo);
		this.add(fix);
		this.add(setBackground);
	}

	private void setupLayout()
	{

		layout.putConstraint(SpringLayout.NORTH, updateInfo, 0, SpringLayout.NORTH, settings);
		layout.putConstraint(SpringLayout.EAST, updateInfo, -25, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, fix, 10, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, settings, 0, SpringLayout.WEST, fix);
		layout.putConstraint(SpringLayout.SOUTH, settings, -27, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, fix, 0, SpringLayout.NORTH, update);
		layout.putConstraint(SpringLayout.NORTH, update, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, update, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.NORTH, setBackground, 90, SpringLayout.SOUTH, fix);
		layout.putConstraint(SpringLayout.WEST, setBackground, 0, SpringLayout.WEST, this);
	}

	private void setupListeners()
	{
		update.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				updatePressed();
			}

		});
		settings.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				settingsPressed();
			}

		});
		updateInfo.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				updateInfoPressed();
			}

		});
		fix.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				fixPressed();
			}

		});
		setBackground.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				setBackroundPressed();
			}

		});
		update.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				updatePressed();
			}

		});
	}

	private void updatePressed()
	{
	}

	private void settingsPressed()
	{
	}

	private void updateInfoPressed()
	{
	}

	private void fixPressed()
	{
	}

	private void setBackroundPressed()
	{
	}
}
