import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import org.apache.commons.io.FileUtils;

public class Convert
{
	/**
	 * 将制定目录下的所有Java源文件的编码格式从GBK修改为UTF-8
	 */
	public static final String[] javastr = { "java" };

	public static void GBKtoUTF8(String GBKsrc, String toUTF8src) throws IOException
	{
		// GBK编码格式源码路径
		String srcDirPath = GBKsrc;
		// 转为UTF-8编码格式源码路径
		String utf8DirPath = toUTF8src;

		// 获取所有java文件
		Collection<File> javaGbkFileCol = FileUtils.listFiles(new File(srcDirPath), javastr, true);

		for (Iterator<File> iterator = javaGbkFileCol.iterator(); iterator.hasNext();)
		{
			File javaGbkFile = iterator.next();
			// UTF8格式文件路径
			String utf8FilePath = utf8DirPath
					+ javaGbkFile.getAbsolutePath().substring(srcDirPath.length());

			// 使用GBK读取数据，然后用UTF-8写入数据
			FileUtils.writeLines(new File(utf8FilePath), "UTF-8",
					FileUtils.readLines(javaGbkFile, "GBK"));
			System.out.println("转换完成！");
		}
	}

	/**
	 * 将制定目录下的所有Java源文件的编码格式从UTF-8修改为GBK
	 */
	public static void UTF8toGBK(String UTF8src, String toGBKsrc) throws IOException
	{
		// UTF-8编码格式源码路径
		String srcDirPath = UTF8src;
		// 转为GBK编码格式源码路径
		String gbkDirPath = toGBKsrc;

		// 获取所有java文件
		Collection<File> javaUtf8FileCol = FileUtils.listFiles(new File(srcDirPath), javastr, true);

		for (Iterator<File> iterator = javaUtf8FileCol.iterator(); iterator.hasNext();)
		{
			File javaUtf8File = iterator.next();
			// UTF8格式文件路径
			String GBK8FilePath = gbkDirPath
					+ javaUtf8File.getAbsolutePath().substring(srcDirPath.length());

			// 使用GBK读取数据，然后用UTF-8写入数据
			FileUtils.writeLines(new File(GBK8FilePath), "GBK",
					FileUtils.readLines(javaUtf8File, "UTF-8"));
			System.out.println("转换完成！");
		}
	}
}
