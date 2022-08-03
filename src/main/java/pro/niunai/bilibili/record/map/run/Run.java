package pro.niunai.bilibili.record.map.run;



import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import pro.niunai.bilibili.record.map.conf.ConfigProperties;
import pro.niunai.bilibili.record.map.service.MakeClientService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * @author 本間Saki
 */
@Component
@Slf4j
public class Run implements ApplicationRunner {
	@Autowired
	MakeClientService makeClientService;
	//0123456789BCDFGHJKLMNPQRSTVWXY-
	//https://tgrcode.com/mm2/level_info/NBR49DCMF
	//https://tgrcode.com/mm2/level_thumbnail/NBR49DCMF
	//https://tgrcode.com/mm2/level_entire_thumbnail/NBR49DCMF
	public static void main(String[] args) throws IOException, URISyntaxException, InterruptedException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("当前房间号为：" + ConfigProperties.getProperty("roomId"));
		System.out.println("请输入直播间房间号输入0跳过设置：");
		String line = scanner.nextLine();
		if (!("0".equals(line) || "".equals(line))) {
			ConfigProperties.writePropertie("roomId", line);
		}
		new MakeClientService().start();
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		log.info("开始建立链接");
		makeClientService.start();
	}
}
