package pro.niunai.bilibili.record.map.conf;

import lombok.extern.slf4j.Slf4j;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pro.niunai.bilibili.record.map.service.MakeClientService;
import pro.niunai.bilibili.record.map.service.MessageHandleService;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.util.zip.DataFormatException;

/**
 * @author 本間Saki
 */
@Slf4j
@Component
public class WebSocket extends WebSocketClient {
    @Autowired
    MakeClientService makeClientService;
    @Autowired
    MessageHandleService messageHandleService;
	public WebSocket() throws URISyntaxException {
        super(new URI(ConfigProperties.getProperty("url")));
    }

    @Override
    public void onOpen(ServerHandshake shake) {
    }

    @Override
    public void onMessage(ByteBuffer message) {
        try {
            messageHandleService.messageHandle(message);
        } catch (DataFormatException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClose(int paramInt, String paramString, boolean paramBoolean) {
	    log.error("连接关闭");
//        System.out.println("Closed");
    }

    @Override
    public void onError(Exception e) {
        System.out.println(e);
    }

    @Override
    public void onMessage(String message) {
    }

}
