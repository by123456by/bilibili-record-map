package pro.niunai.bilibili.record.map.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.niunai.bilibili.record.map.pojo.Msg;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

/**
 * @author 本間Saki
 */
@Slf4j
@Component
public class MessageHandleService {
	private MapHandleService mapHandleService = new MapHandleService();
	public void messageHandle(ByteBuffer message) throws DataFormatException {
		List<String> s = messageToJson(message);
		for (String s1 : s) {
//            System.out.println(s1);
//			log.debug("消息为：{}", s1);
			if (s1.contains("cmd")) {
				JSONObject json = JSON.parseObject(s1);
				if ("DANMU_MSG".equals(json.getString("cmd"))) {
					JSONArray info = json.getJSONArray("info");
					String msg = info.getString(1);
					JSONArray userJson = info.getJSONArray(2);
					String name = userJson.getString(1);
					log.debug("收到用户:【{}】发送到弹幕:【{}】", name, msg);
					Msg m = new Msg();
					m.setName(name);
					m.setMsg(msg);
					mapHandleService.msg(m);
				}
			}

		}
	}

	/**
	 * @param message 如果是 message 是弹幕类型，则需要解压拆分
	 * @return List<message>
	 * @throws DataFormatException DataFormatException
	 */
	private List<String> messageToJson(ByteBuffer message) throws DataFormatException {
		byte[] messageBytes = message.array();
		byte[] mainMessageBytes = Arrays
				.copyOfRange(messageBytes, 16, messageBytes.length);

		if (messageBytes[16] != 120) {
			return Arrays.asList(new String(mainMessageBytes, StandardCharsets.UTF_8));
		}

		// 解压缩弹幕信息
		byte[] newByte = new byte[1024 * 5];
		Inflater inflater = new Inflater();
		inflater.setInput(mainMessageBytes);
		newByte = Arrays.copyOfRange(newByte, 16, inflater.inflate(newByte));
		return splitStringToJson(new String(newByte, StandardCharsets.UTF_8));
	}

	/**
	 * @param str 包含多条 message 的字符串
	 * @return List<message>
	 */
	private static List<String> splitStringToJson(String str) {
		List<String> result = new ArrayList<>();
		for (int i = 1, count = 1; i < str.length(); i++) {

			if (str.charAt(i) == '{') {
				count++;
			} else if (str.charAt(i) == '}') {
				count--;
			}

			if (count == 0) {
				result.add(str.substring(0, i + 1));
				int nextIndex = str.indexOf("{", i + 1);
				if (nextIndex != -1) {
					result.addAll(splitStringToJson(str.substring(nextIndex)));
				}
				return result;
			}
		}
		return result;
	}

}
