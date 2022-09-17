package pro.niunai.bilibili.record.map.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;

/**
 * 后台查看投图
 * @date: 2022/7/25 10:00
 */
@ServerEndpoint("/adminWs")
@Component
@Log
public class AdminWsServerEndpoint {
	public static HashMap<String, Session> map = new HashMap<>();
	/**
	 * 连接成功
	 * @param session
	 */
	@OnOpen
	public void onOpen(Session session) {
		log.info("后台查看连接成功");
		map.put(session.getId(), session);

	}

	/**
	 * 连接关闭
	 * @param session
	 */
	@OnClose
	public void onClose(Session session) {
		log.info("后台查看连接关闭");
		map.remove(session.getId());
	}

	/**
	 * 接收到消息
	 * @param text
	 */
	@OnMessage
	public String onMsg(String text) throws IOException {
		return "servet 后台查看发送：" + text;
	}

	/**
	 * 广播发送消息
	 * @param text
	 */
	public static void sendMessage(String text) {
		map.forEach((k, v) -> {
			try {
				v.getBasicRemote().sendText(text);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
	}
}
