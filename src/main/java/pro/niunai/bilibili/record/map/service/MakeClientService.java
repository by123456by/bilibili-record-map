package pro.niunai.bilibili.record.map.service;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import pro.niunai.bilibili.record.map.conf.ConfigProperties;
import pro.niunai.bilibili.record.map.conf.WebSocket;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author 本間Saki
 */
@Slf4j
@Component
public class MakeClientService {
	@Autowired
	WebSocket client;

	private final String url;

	private final String clientHead;

	private final String clientBody;

	private final String heartByte;

	public MakeClientService() {
		url = ConfigProperties.getProperty("url");
		log.trace("url = " + url);
		heartByte = ConfigProperties.getProperty("heartByte");
		log.trace("heartByte = " + heartByte);
		clientBody = ConfigProperties.getProperty("clientBody")
				.replace("{roomId}", ConfigProperties.getProperty("roomId"));
		log.trace("clientBody = " + clientBody);
		clientHead = ConfigProperties.getProperty("clientHead")
				.replace("{replce}", Integer
						.toHexString(clientBody.getBytes().length + 16));
		log.trace("clientHead = " + clientHead);
	}

	public void start() throws URISyntaxException, InterruptedException, UnsupportedEncodingException {
		// 建立连接
//		WebSocket client = new WebSocket(url);
		client.connectBlocking();

//		DefaultSingletonBeanRegistry registry = (DefaultSingletonBeanRegistry) context.getBeanFactory();
//		registry.destroySingleton({yourbean}) //destroys the bean object
//		registry.registerSingleton({yourbeanname}, {newbeanobject}) //add to singleton beans cache

		// 发送连接参数
		byte[] head = hexToByteArray(clientHead);
		byte[] body = clientBody.getBytes(StandardCharsets.UTF_8);
		byte[] requestCode = byteMerger(head, body);
		client.send(requestCode);

		// 定时发送心跳包
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				client.send(hexToByteArray(heartByte));
				log.info("运行正常");
				//System.out.println("心跳发送成功");
			}
		}, 0L, 30000L);
	}

	/**
	 * @param hexStr Hex 字符串
	 * @return byte[]
	 */
	private byte[] hexToByteArray(String hexStr) {
		if (hexStr.length() % 2 == 1) {
			hexStr = "0" + hexStr;
		}

		int hexlen = hexStr.length();
		byte[] result = new byte[(hexlen / 2)];

		for (int i = 0, j = 0; i < hexlen; i += 2, j++) {
			result[j] = (byte) Integer.parseInt(hexStr.substring(i, i + 2), 16);
		}
		return result;
	}

	/**
	 * @param byteL left
	 * @param byteR right
	 * @return left + right
	 */
	private byte[] byteMerger(byte[] byteL, byte[] byteR) {
		byte[] byteArr = new byte[byteL.length + byteR.length];
		System.arraycopy(byteL, 0, byteArr, 0, byteL.length);
		System.arraycopy(byteR, 0, byteArr, byteL.length, byteR.length);
		return byteArr;
	}

}
