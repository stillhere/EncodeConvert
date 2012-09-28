import java.io.IOException;

public class Main
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (args[2].equals("u2g"))
		{
			try
			{
				Convert.UTF8toGBK(args[0], args[1]);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		} else if (args[2].equals("g2u"))
		{
			try
			{
				Convert.GBKtoUTF8(args[0], args[1]);
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}
