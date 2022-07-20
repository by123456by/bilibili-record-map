package pro.niunai.bilibili.record.map.conf;

import java.io.*;
import java.util.Properties;

/**
 * @author 本間Saki
 * @create 2020-07-14
 */
public class ConfigProperties {
	private static final String profileName = "config.properties";
	private static Properties properties;

	static {
		properties = new Properties();
		InputStream configInputStream = ConfigProperties.class
				.getClassLoader().getResourceAsStream(profileName);

		try {
			properties.load(configInputStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProperty(String key) {
		return properties.getProperty(key);
	}

	public static boolean writePropertie(String key, String value) {
		try {
			File f = new File(ConfigProperties.class.getResource("/" + profileName).getPath());
			OutputStream fos = new FileOutputStream(f);
			properties.setProperty(key, value);
			properties.store(fos,"配置项");
			fos.close();
		} catch (IOException e) {
			System.err.println("属性文件更新错误");
			return false;
		}
		return true;

	}

}
