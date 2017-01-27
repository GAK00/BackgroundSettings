package settings.control;

import javax.swing.JPanel;

import settings.model.*;
import settings.view.SettingsFrame;

public class Controller
{
	private SettingsFrame frame;
	private Updater updater;
	private FileManipulator files;
	public Controller()
	{

		updater = new Updater();
		files = new FileManipulator();
		frame = new SettingsFrame(this);
	}
	public void start(){}
	public boolean checkForUpdates()
	{
		return updater.checkForUpdates();
	}
	public void update()
	{
		updater.update();
	}
	public void setOption(int option,String Option)
	{
		files.setOption(option, Option);
	}
	public String grab(int i)
	{
		// TODO Auto-generated method stub
		return files.getOption(i);
	}
	public void MovePicture(String string)
	{
		String[] data = string.split("/");
		String name = data[data.length-1].substring(0, data[data.length-1].indexOf("."));
		String extension = data[data.length-1].substring(data[data.length-1].indexOf(".")+1);
		files.copyData(name, string, extension);
	}
	public String getOption(int Option)
	{
		return files.getOption(Option);
		}
	public void setPanel(String pan)
	{
		frame.setPanel(pan);
	}
}
