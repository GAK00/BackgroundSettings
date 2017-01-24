package settings.model;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class Updater
{
	
	FileManipulator file;
	public Updater()
	{
		file = new FileManipulator();
	}
	//Jar//https://github.com/GAK00/Realase/blob/master/Update.jar?raw=true
	//Version//https://raw.githubusercontent.com/GAK00/Realase/master/Version.txt
	public boolean checkForUpdates()
	{
		boolean needsUpdate = false;
		try
		{
			URL Version = new URL("https://raw.githubusercontent.com/GAK00/Realase/master/Version.txt");
			Path toCopy = new File("/Users/"+file.getOption(0)+"/Documents/Backgrounds/CurrentVersion.txt").toPath();
			InputStream download = Version.openStream();
			Files.copy(download, toCopy, StandardCopyOption.REPLACE_EXISTING);
			download.close();
			if(!file.readDataTruePath("/Users/"+file.getOption(0)+"/Documents/Backgrounds/CurrentVersion.txt").substring(file.readDataTruePath("/Users/"+file.getOption(0)+"/Documents/Backgrounds/CurrentVersion.txt").indexOf(" ")+1).equals(file.getVersion()))
			{
				
				needsUpdate = true;
			}
			System.out.println("Update: " + file.readDataTruePath("/Users/"+file.getOption(0)+"/Documents/Backgrounds/CurrentVersion.txt").substring(file.readDataTruePath("/Users/"+file.getOption(0)+"/Documents/Backgrounds/CurrentVersion.txt").indexOf(" ")+1));
			System.out.println("Current: " + file.getVersion());
			new File("/Users/"+file.getOption(0)+"/Documents/Backgrounds/CurrentVersion.txt").delete();
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return needsUpdate;
	}
	
	
	public void update()
	{
		try
		{
			URL JAR = new URL("https://github.com/GAK00/Realase/raw/master/Update.jar");
			Path toCopy = new File("/Users/"+file.getOption(0)+"/Documents/Backgrounds/Update.jar").toPath();
			InputStream download = JAR.openStream();
			Files.copy(download, toCopy, StandardCopyOption.REPLACE_EXISTING);
			download.close();
			Runtime.getRuntime().exec(new String[]{"java","-jar","/Users/"+file.getOption(0)+"/Documents/Backgrounds/Update.jar"});
			System.exit(0);
		} catch (MalformedURLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		Updater update = new Updater();
		if(update.checkForUpdates())
		{
			update.update();
		}
	}

}
