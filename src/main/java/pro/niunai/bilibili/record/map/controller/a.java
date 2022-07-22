package pro.niunai.bilibili.record.map.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import pro.niunai.bilibili.record.map.mapper.MapMapper;
import pro.niunai.bilibili.record.map.pojo.MapInfo;

/**
 * @date: 2022/7/18 9:14
 */
@Controller
public class a {
	@Autowired
	MapMapper mapMapper;
	@RequestMapping("/a")
	public void a(){
		MapInfo mapInfo = new MapInfo();
		mapInfo.setName("12");
		mapMapper.insert(mapInfo);
	}
}
