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
	@Autowired
	MapHandleService mapHandleService;

	@RequestMapping("/map")
	public MapVO map(Msg m) {
		return mapHandleService.addMap(m);
	}
}
