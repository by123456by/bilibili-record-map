package pro.niunai.bilibili.record.map.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.niunai.bilibili.record.map.mapper.MapMapper;
import pro.niunai.bilibili.record.map.pojo.JsonResult;
import pro.niunai.bilibili.record.map.pojo.MapInfo;
import pro.niunai.bilibili.record.map.pojo.MapVO;
import pro.niunai.bilibili.record.map.pojo.Msg;
import pro.niunai.bilibili.record.map.service.MapHandleService;

import java.util.List;

import static pro.niunai.bilibili.record.map.pojo.ResponseCode.*;
import static pro.niunai.bilibili.record.map.pojo.Status.*;

/**
 * @date: 2022/7/18 9:14
 */
@RestController
@Slf4j
@Api(tags="后台api")
public class MapController {
	@Autowired
	MapMapper mapMapper;
	@Autowired
	MapHandleService mapHandleService;

	@ApiOperation("获取最近投图")
	@GetMapping("new-map")
	public JsonResult newMap() {
		return JsonResult.ok(mapMapper.selectMapByNew());
	}

	@ApiOperation("添加投图")
	@PostMapping("/add-map")
	public JsonResult addMap(Msg m) {
		if (m.getMsg() == null) {
			return JsonResult.failed(BAD_REQUEST,"没有弹幕信息");
		}
		if (m.getName() == null) {
			return JsonResult.failed(BAD_REQUEST,"没有投图人信息");
		}
		return JsonResult.ok(mapHandleService.addMap(m));
	}
	@ApiOperation("获取全部投图列表")
	@GetMapping("/list")
	public List<MapVO> list() {
		return mapMapper.selectlist();
	}
	@ApiOperation("修改投图状态")
	@GetMapping("/play")
	public void list(String map,String status) {
		if (status == null) {
			status = PLAYED;
		}
		mapMapper.updateStatusByMap(map, status);
	}
}
