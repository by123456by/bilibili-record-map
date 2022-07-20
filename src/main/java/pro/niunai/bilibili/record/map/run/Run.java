package pro.niunai.bilibili.record.map.run;



import pro.niunai.bilibili.record.map.conf.ConfigProperties;
import pro.niunai.bilibili.record.map.service.MakeClientService;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Scanner;

/**
 * @author 本間Saki
 */
public class Run {
	//0123456789BCDFGHJKLMNPQRSTVWXY-
	//https://tgrcode.com/mm2/level_info/NBR49DCMF
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

}
