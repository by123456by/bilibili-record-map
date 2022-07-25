package pro.niunai.bilibili.record.map.controller;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.HashMap;

/**
 * @date: 2022/7/25 10:00
 */
@ServerEndpoint("/danmuWs")
@Component
public class WsServerEndpoint {
	public static HashMap<String, Session> map = new HashMap<>();
	/**
	 * 连接成功
	 * @param session
	 */
	@OnOpen
	public void onOpen(Session session) {
		System.out.println("连接成功");
		map.put(session.getId(), session);

	}

	/**
	 * 连接关闭
	 * @param session
	 */
	@OnClose
	public void onClose(Session session) {
		System.out.println("连接关闭");
		map.remove(session.getId());
	}

	/**
	 * 接收到消息
	 * @param text
	 */
	@OnMessage
	public String onMsg(String text) throws IOException {
		return "servet 发送：" + text;
	}
}