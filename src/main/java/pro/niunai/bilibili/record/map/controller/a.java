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

import java.util.List;

/**
 * @date: 2022/7/18 9:14
 */
@RestController
@Slf4j
public class a {
	@Autowired
	MapMapper mapMapper;
	@Autowired
	MapHandleService mapHandleService;

	@RequestMapping("/map")
	public MapVO map(Msg m) {
		if (m.getMsg() == null) {
			return null;
		}
		if (m.getName() == null) {
			m.setName("乌冬面pp");
		}
		return mapHandleService.addMap(m);
	}
	@RequestMapping("/list")
	public List<MapVO> list(Msg m) {
		return mapMapper.selectlist();
	}@RequestMapping("/play")
	public void list(String map) {
		mapMapper.updateStatusByMap(map, "玩过了");
	}
}
