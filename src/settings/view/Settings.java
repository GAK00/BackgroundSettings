package settings.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import settings.control.Controller;
import javax.swing.SwingConstants;

public class Settings extends JPanel
{
	private ToggleButton fixMode;
	private ToggleButton slideShow;
	private ToggleButton automaticUpdates;
	private JTextField minutes;
	private JTextField seconds;
	private JTextField miliSeconds;
	private JButton back;
	private JLabel fixLabel;
	private JLabel slideLabel;
	private JLabel UpdateLabel;
	private JLabel minLabel;
	private JLabel secLabel;
	private JLabel miliLabel;
	private Controller controller;
	private SpringLayout layout;
	public Settings(Controller controller)
	{
		super();
		this.controller = controller;
		fixMode = new ToggleButton(2,controller,"RunFixMode: ");
		slideShow = new ToggleButton(3,controller,"RunSlideShow: ");
		automaticUpdates = new ToggleButton(5,controller,"autoUpdate: ");
		String timerOption = controller.getOption(4);
		int time = Integer.parseInt(timerOption.substring(timerOption.indexOf("M")+2,timerOption.indexOf(",",timerOption.indexOf("M")+2)));
		int time2 =Integer.parseInt(timerOption.substring(timerOption.indexOf("S")+2,timerOption.indexOf(",",timerOption.indexOf("S")+2)));
		int time3 = Integer.parseInt(timerOption.substring(timerOption.indexOf("MS")+3));
		minutes = new JTextField(Integer.toString(time));
		seconds = new JTextField(Integer.toString(time2));
		miliSeconds = new JTextField(Integer.toString(time3));
		back = new JButton("Back");
		fixLabel = new JLabel("fix mode:");
		slideLabel = new JLabel("run slide show:");
		UpdateLabel = new JLabel("auto update:");
		minLabel = new JLabel("min");
		secLabel = new JLabel("sec");
		miliLabel = new JLabel("mili");
		this.layout = new SpringLayout();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	
	private void setupPanel()
	{
		this.setLayout(layout);
		this.add(fixMode);
		this.add(slideShow);
		this.add(automaticUpdates);
		this.add(minutes);
		this.add(seconds);
		this.add(miliSeconds);
		this.add(back);
		this.add(fixLabel);
		this.add(slideLabel);
		this.add(UpdateLabel);
		this.add(minLabel);
		this.add(secLabel);
		this.add(miliLabel);
		
	}
	private void setupLayout()
	{
		miliSeconds.setHorizontalAlignment(SwingConstants.LEFT);
		layout.putConstraint(SpringLayout.NORTH, miliLabel, 6, SpringLayout.SOUTH, miliSeconds);
		layout.putConstraint(SpringLayout.EAST, miliLabel, 0, SpringLayout.EAST, miliSeconds);
		layout.putConstraint(SpringLayout.NORTH, secLabel, 6, SpringLayout.SOUTH, seconds);
		layout.putConstraint(SpringLayout.NORTH, minLabel, 0, SpringLayout.NORTH, secLabel);
		layout.putConstraint(SpringLayout.WEST, minLabel, 0, SpringLayout.WEST, minutes);
		layout.putConstraint(SpringLayout.WEST, secLabel, 0, SpringLayout.WEST, fixMode);
		layout.putConstraint(SpringLayout.NORTH, miliSeconds, 20, SpringLayout.SOUTH, automaticUpdates);
		layout.putConstraint(SpringLayout.NORTH, seconds, 20, SpringLayout.SOUTH, automaticUpdates);
		layout.putConstraint(SpringLayout.EAST, minutes, 38, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, miliSeconds, 27, SpringLayout.EAST, seconds);
		layout.putConstraint(SpringLayout.EAST, seconds, -6, SpringLayout.EAST, slideLabel);
		layout.putConstraint(SpringLayout.WEST, seconds, 0, SpringLayout.WEST, fixMode);
		layout.putConstraint(SpringLayout.WEST, minutes, 14, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, UpdateLabel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.WEST, fixLabel, 0, SpringLayout.WEST, this);
		layout.putConstraint(SpringLayout.NORTH, minutes, 20, SpringLayout.SOUTH, UpdateLabel);
		layout.putConstraint(SpringLayout.NORTH, slideShow, 0, SpringLayout.NORTH, slideLabel);
		layout.putConstraint(SpringLayout.WEST, slideShow, 6, SpringLayout.EAST, slideLabel);
		layout.putConstraint(SpringLayout.SOUTH, fixLabel, -120, SpringLayout.SOUTH, this);
		layout.putConstraint(SpringLayout.NORTH, UpdateLabel, 208, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.SOUTH, slideLabel, -23, SpringLayout.NORTH, fixMode);
		layout.putConstraint(SpringLayout.NORTH, fixMode, 0, SpringLayout.NORTH, fixLabel);
		layout.putConstraint(SpringLayout.WEST, fixMode, 6, SpringLayout.EAST, fixLabel);
		layout.putConstraint(SpringLayout.NORTH, automaticUpdates, 0, SpringLayout.NORTH, UpdateLabel);
		layout.putConstraint(SpringLayout.WEST, automaticUpdates, 6, SpringLayout.EAST, UpdateLabel);
		layout.putConstraint(SpringLayout.NORTH, back, 10, SpringLayout.NORTH, this);
		layout.putConstraint(SpringLayout.EAST, back, -10, SpringLayout.EAST, this);
		layout.putConstraint(SpringLayout.WEST, slideLabel, 0, SpringLayout.WEST, this);
	}
	
	private void setupListeners()
	{
		back.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int minute;
				int second;
				int mili;
				try{
				minute = Integer.parseInt(minutes.getText());
				second = Integer.parseInt(seconds.getText());
				mili = Integer.parseInt(miliSeconds.getText());}
				catch(Exception exception)
				{
					minute = 5;
					second = 0;
					mili = 0;
				}
				controller.setOption(4, "slideShowTimer: M:"+minute+",S:"+second+",MS:"+mili);
				controller.setPanel("Main");
				controller.setOption(6, "Update: true");
			
			}
	
		});
	}

}
