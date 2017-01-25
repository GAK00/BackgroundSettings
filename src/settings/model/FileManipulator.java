package settings.model;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileManipulator
{
	File mainDirectory;

	public FileManipulator()
	{
		try
		{
			mainDirectory = new File(getParentDirectory());
		} catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void setOption(int OptionNumber, String Option)
	{
		List<String> options;
		String option = "";
		try
		{
			options = Files.readAllLines(Paths.get(getParentDirectory() + "/BackgroundData.txt"));
			options.set(OptionNumber, Option);
			String toWrite = "";
			for (int index = 0; index < options.size(); index++)
			{
				toWrite += options.get(index);
				if (index != options.size() - 1)
				{
					toWrite += "\n";
				}
			}
			this.writeData("BackgroundData", toWrite);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getOption(int optionNumber)
	{
		String option = "";
		try
		{
			option = Files.readAllLines(Paths.get(getParentDirectory() + "/BackgroundData.txt")).get(optionNumber);

			option = option.substring(option.indexOf(" ") + 1);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return option;
	}

	public String getVersion()
	{
		List<String> options;
		String option = "";
		try
		{
			options = Files.readAllLines(Paths.get(getParentDirectory() + "/BackgroundData.txt"));

			option = options.get(options.size() - 1).substring(options.get(options.size() - 1).indexOf(" ") + 1);
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return option;
	}

	private String getParentDirectory() throws UnsupportedEncodingException
	{
		String parentPath = "";
		URL childPath = FileManipulator.class.getProtectionDomain().getCodeSource().getLocation();
		String childFilePath = URLDecoder.decode(childPath.getFile(), "UTF-8");
		parentPath = new File(childFilePath).getParentFile().getPath();
		return parentPath;
	}

	public void writeData(String fileName, String stringData)
	{
		byte data[] = stringData.getBytes();
		String fileType = ".txt";
		Path path = Paths.get(mainDirectory.getPath() + "/" + fileName + fileType);
		try
		{
			Files.write(path, data, StandardOpenOption.CREATE);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void writeData(String fileName, String stringData, String fileType)
	{
		byte data[] = stringData.getBytes();
		fileType = "." + fileType;
		Path path = Paths.get(mainDirectory.getPath() + "/" + fileName + fileType);
		try
		{
			Files.write(path, data, StandardOpenOption.CREATE);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void writeData(String fileName, String stringData, String fileType, String savePath)
	{
		byte data[] = stringData.getBytes();
		fileType = "." + fileType;
		Path path = Paths.get(savePath + "/" + fileName + fileType);
		try
		{
			Files.write(path, data, StandardOpenOption.CREATE);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public String readData(String fileName)
	{
		String Data = "";
		Path path = Paths.get(mainDirectory.getPath() + "/" + fileName + ".txt");
		try
		{
			Data = new String(Files.readAllBytes(path), "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			Data = null;
		}
		return Data;
	}

	public String readDataTruePath(String fileName)
	{
		String Data = "";
		Path path = Paths.get(fileName);
		try
		{
			Data = new String(Files.readAllBytes(path), "UTF-8");
		} catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			Data = null;
		}
		return Data;
	}

	public void copyData(String fileName,String FilePath, String fileType)
	{
		fileType = "." + fileType;
		Path path;
		if (this.getOption(3).equals("true"))
		{
			path = Paths.get(mainDirectory.getPath() + "/Pictures/" + fileName + fileType);
		} else
		{
			path = Paths.get(mainDirectory.getPath() + "/" + fileName + fileType);
		}
		try
		{
			Path truePath = Paths.get(FilePath);
			Files.copy(truePath, path, StandardCopyOption.REPLACE_EXISTING);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
