package pro.niunai.bilibili.record.map.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @date: 2022/7/25 9:59
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig {
	@Bean
	public ServerEndpointExporter serverEndpoint() {
		return new ServerEndpointExporter();
	}
}
