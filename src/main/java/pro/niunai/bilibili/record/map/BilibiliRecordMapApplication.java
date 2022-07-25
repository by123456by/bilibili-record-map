package pro.niunai.bilibili.record.map;

import cn.hutool.setting.yaml.YamlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.niunai.bilibili.record.map.conf.ConfigProperties;
import pro.niunai.bilibili.record.map.conf.YmalUtil;
import pro.niunai.bilibili.record.map.service.MakeClientService;

import java.awt.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class BilibiliRecordMapApplication {

	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
//		System.out.println(getPath());
		log.info("加载数据库：{}", YmalUtil.getUrl());
		SpringApplication.run(BilibiliRecordMapApplication.class, args);
		LocalDateTime.now();
		String url = "http://localhost:8080/";//填写你项目路由
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
		} catch (IOException e) {
			e.printStackTrace();
		}

//		Scanner scanner = new Scanner(System.in);
//		System.out.println("当前房间号为：" + ConfigProperties.getProperty("roomId"));
//		System.out.println("请输入直播间房间号输入0跳过设置：");
//		String line = scanner.nextLine();
//		if (!("0".equals(line) || "".equals(line))) {
//			ConfigProperties.writePropertie("roomId", line);
//		}
//		new MakeClientService().start();
	}

	public static String getPath() {
		String path = BilibiliRecordMapApplication.class.getProtectionDomain().getCodeSource().getLocation().getPath();
		if (path.indexOf('/') == 0) {
			path=path.substring(1);
		} else {
			path = path.substring(6, path.indexOf("bilibili-record-map-0.0.1-SNAPSHOT.jar"));
		}
		return path;
	}
	public static String getPath(String path) {
		return getPath() + path;
	}
}
