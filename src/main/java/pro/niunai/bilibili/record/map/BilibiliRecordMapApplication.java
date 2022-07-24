package pro.niunai.bilibili.record.map;

import cn.hutool.setting.yaml.YamlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pro.niunai.bilibili.record.map.conf.ConfigProperties;
import pro.niunai.bilibili.record.map.conf.YmalUtil;
import pro.niunai.bilibili.record.map.service.MakeClientService;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class BilibiliRecordMapApplication {

	public static void main(String[] args) throws UnsupportedEncodingException, URISyntaxException, InterruptedException {
		log.info("加载配置：{}", YmalUtil.getUrl());
		SpringApplication.run(BilibiliRecordMapApplication.class, args);
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("当前房间号为：" + ConfigProperties.getProperty("roomId"));
//		System.out.println("请输入直播间房间号输入0跳过设置：");
//		String line = scanner.nextLine();
//		if (!("0".equals(line) || "".equals(line))) {
//			ConfigProperties.writePropertie("roomId", line);
//		}
//		new MakeClientService().start();
	}

}
