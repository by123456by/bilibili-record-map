package pro.niunai.bilibili.record.map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pro.niunai.bilibili.record.map.mapper.MapMapper;
import pro.niunai.bilibili.record.map.pojo.MapInfo;

@SpringBootTest
class BilibiliRecordMapApplicationTests {
	@Autowired
	MapMapper mapMapper;
	@Test
	void contextLoads() {

	}

}
