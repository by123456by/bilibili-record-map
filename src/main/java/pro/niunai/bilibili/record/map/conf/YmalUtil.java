package pro.niunai.bilibili.record.map.conf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.Yaml;
import pro.niunai.bilibili.record.map.BilibiliRecordMapApplication;

import java.io.*;
import java.net.URISyntaxException;
import java.util.Map;

/**
 * @date: 2022/7/22 15:06
 */
@Slf4j
public class YmalUtil {
	private static Map<String,Object> obj;

	public static String getUrl() {
		Map<String,Object> spring =(Map)obj.get("spring");
		Map<String,Object> datasource =(Map)spring.get("datasource");
		String url = (String) datasource.get("url");
		return url;
	}
	static{
		Yaml yml =null;
		String filePath = BilibiliRecordMapApplication.getPath("application.yaml");
		File file = new File(filePath);
		try (FileInputStream in = new FileInputStream(file)){
			yml = new Yaml();
			obj = yml.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Map<String,Object> spring =(Map)obj.get("spring");
		Map<String,Object> datasource =(Map)spring.get("datasource");
		String url = (String) datasource.get("url");
		String dbPath = BilibiliRecordMapApplication.getPath("map.sqlite");
//		try {
//			dbPath = YmalUtil.class.getClassLoader().getResource("./map.sqlite").toURI().toString().substring(6);
//		} catch (URISyntaxException e) {
//			e.printStackTrace();
//		}
		datasource.put("url", "jdbc:sqlite:"+dbPath);

		try (FileWriter writer = new FileWriter(file)) {
			writer.write(yml.dumpAsMap(obj));
			//writer.write(yml.dumpAs(obj, Tag.MAP, DumperOptions.FlowStyle.BLOCK));
			//可以自定义写入格式
			//writer.write(yml.dumpAs(obj, Tag.MAP, DumperOptions.FlowStyle.FLOW));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
