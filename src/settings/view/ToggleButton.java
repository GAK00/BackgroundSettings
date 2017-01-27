package settings.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import settings.control.Controller;

public class ToggleButton extends JButton
{
	private String state = "false";
	private Controller controller;
	private int option; 
	private String OptionName;
	public ToggleButton(int linkedOption,Controller controller,String OptionName)
	{
		super();
		this.controller = controller;
		this.OptionName = OptionName;
		this.option = linkedOption;
		state = controller.getOption(linkedOption);
		System.out.println(state);
		this.setText(state);
		setupLink();
	}
	
	
	private void setupLink()
	{
		this.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				pressed();
			}
		});
	}
	
	private void pressed()
	{
		if(state.equals("false"))
		{
			state = "true";
		}
		else
		{
			state="false";
		}
		controller.setOption(option, OptionName+state);
		this.setText(state);

		this.getRootPane().revalidate();
		this.getRootPane().repaint();
	}
	

}
