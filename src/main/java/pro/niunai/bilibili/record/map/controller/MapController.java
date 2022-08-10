package pro.niunai.bilibili.record.map.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pro.niunai.bilibili.record.map.mapper.MapMapper;
import pro.niunai.bilibili.record.map.pojo.*;
import pro.niunai.bilibili.record.map.service.MapHandleService;

import java.util.List;

import static pro.niunai.bilibili.record.map.pojo.ResponseCode.*;
import static pro.niunai.bilibili.record.map.pojo.Status.*;

/**
 * @date: 2022/7/18 9:14
 */
@RestController
@Slf4j
@Api(tags = "后台api")
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
	public JsonResult addMap(Danmu dm) {
		if (dm.getMsg() == null) {
			return JsonResult.failed(BAD_REQUEST, "没有弹幕信息");
		}
		if (dm.getName() == null) {
			return JsonResult.failed(BAD_REQUEST, "没有投图人信息");
		}

		JsonResult map = mapHandleService.map(dm);
		if (map.getState() == 440) {
			return map;
		} else if (map.getState() != 200) {
			mapHandleService.sendMsg(map);
			return map;
		}

		JsonResult jsonResult = mapHandleService.addMap((MapVO) map.getData());
		mapHandleService.sendMsg(jsonResult);
		return jsonResult;
	}

	@ApiOperation("获取全部投图列表")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "int"),
			@ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "int")
	})
	@GetMapping("/list")
	public JsonPage<MapVO> list(Integer page, Integer pageSize) {
		PageHelper.startPage(page, pageSize);
		List<MapVO> mapVOS = mapMapper.selectList();
		return JsonPage.restPage(new PageInfo<>(mapVOS));
	}

	@ApiOperation("获取全部未玩列表")
	@GetMapping("/list_noplay")
	public List<MapVO> list_nopay() {
		return mapMapper.selectListByNoPlay();
	}

	@ApiOperation("修改投图状态")
	@GetMapping("/play")
	public void list(String map, String status) {
		if (status == null) {
			status = PLAYED;
		}
		mapMapper.updateStatusByMap(map, status);
	}
}
