package pro.niunai.bilibili.record.map.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.niunai.bilibili.record.map.mapper.MapMapper;
import pro.niunai.bilibili.record.map.pojo.MapInfo;
import pro.niunai.bilibili.record.map.pojo.MapVO;
import pro.niunai.bilibili.record.map.pojo.Msg;
import pro.niunai.bilibili.record.map.service.MapHandleService;

/**
 * @date: 2022/7/18 9:14
 */
@RestController
@Slf4j
public class a {
	@Autowired
	MapMapper mapMapper;

	@RequestMapping("/map")
	public MapVO map(Msg m) {
		log.debug("收到投图信息：{}",m);
		MapHandleService mapHandleService = new MapHandleService();
		if (m.getName() == null) {
			m.setName("乌冬面pp");
		}
		MapVO mapVO = mapMapper.selectByMap(mapHandleService.toMap(m.getMsg()));
		if (mapVO == null) {
			log.debug("数据库未发现地图，准备存入数据库");
			MapVO msg = mapHandleService.msg(m);
			log.debug("解析地图信息为：{}",m);
			int r = mapMapper.insert(msg);
			if (r == 1) {
				log.debug("数据库存入成功");
			} else {
				log.debug("数据库存入失败");
			}
			return msg;
		}
		log.debug("数据库发现地图");
		log.debug("解析地图信息为：{}",m);
		return mapVO;

	}
}
