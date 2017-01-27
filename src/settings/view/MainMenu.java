package settings.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

import javax.swing.*;

import settings.control.Controller;

public class MainMenu extends JPanel
{

	private JButton update;
	private JButton settings;
	private JButton updateInfo;
	private JButton fix;
	private JButton setBackground;
	private SpringLayout layout;
	private Controller controller;
	private JFileChooser fileChooser;

	public MainMenu(Controller controller)
	{
		super();
		fileChooser = new JFileChooser();
		this.controller = controller;
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
//		update.addActionListener(new ActionListener()
//		{
//
//			@Override
//			public void actionPerformed(ActionEvent e)
//			{
//				updatePressed();
//			}
//
//		});
	}

	

	private void updatePressed()
	{
		if(this.controller.checkForUpdates())
		{
			if(JOptionPane.showConfirmDialog(this, "An update was detected would you like to update now")==0)
			{
				controller.update();
			}
			//System.out.println(JOptionPane.showConfirmDialog(this, "An update was detected would you like to update now"));
		}
		else{JOptionPane.showMessageDialog(this, "There are no updates currently");}
	}

	private void settingsPressed()
	{

		controller.setPanel("Settings");
	}

	private void updateInfoPressed()
	{
		controller.setOption(0,"UserName: " +JOptionPane.showInputDialog(this,"Please enter your username"));
		controller.setOption(1,"Password: "+ JOptionPane.showInputDialog(this,"Please enter your password"));
	}

	private void fixPressed()
	{
		Process process;
		Writer toSudo;
		String password = controller.grab(1);
		try
		{
			process = Runtime.getRuntime().exec("/usr/bin/sudo -S sudo chmod 755 /System/Library/CoreServices/DefaultDesktop.jpg");
			toSudo = new OutputStreamWriter(process.getOutputStream());
			toSudo.write(password);
			toSudo.write('\n'); // sudo's docs demand a newline after the
			                    // password
			toSudo.close(); // but closing the stream might be sufficient
			JOptionPane.showMessageDialog(this, "fix was a succses");
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, "fix failed");
		}
	}

	private void setBackroundPressed()
	{
		String Path;
		fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION)
		{
			File selected = fileChooser.getSelectedFile();
			Path = selected.getPath();
			System.out.println(Path);
			controller.MovePicture(Path);
		}
	
	}
}
