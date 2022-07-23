package pro.niunai.bilibili.record.map.service;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import pro.niunai.bilibili.record.map.pojo.MapInfo;
import pro.niunai.bilibili.record.map.pojo.Msg;
import pro.niunai.bilibili.record.map.pojo.MapVO;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @date: 2022/7/21 10:28
 */
@Component
@Slf4j
//存入数据库
//发送给前端后台
//发送给前端用户端
public class MapHandleService {
	public MapVO msg(Msg msg) {
		String mapText = toMap(msg.getMsg());
		if (mapText == null) {
			return null;
		}
		int i = verifyMap(mapText);
		if (i == 0) {
			MapInfo mapInfo = new MapInfo();
			try {
				mapInfo = getMapInfo(mapText);
			} catch (Exception e) {
				log.error("地图信息解析错误");
			}
			mapInfo.setUserName(msg.getName());
			mapInfo.setDanmu(msg.getMsg());
			mapInfo.setCreateTime(LocalDateTime.now());
			mapInfo.setMap(mapText);

			MapVO mapVO = new MapVO();
			BeanUtils.copyProperties(mapInfo, mapVO);

			StringBuilder sbTagsName = new StringBuilder();
			mapInfo.getTagsName().forEach(tag -> {
				sbTagsName.append(",").append(tag);
			});
			mapVO.setTagsName(sbTagsName.substring(1));

			StringBuilder sbTags = new StringBuilder();
			mapInfo.getTags().forEach(tag -> {
				sbTags.append(",").append(tag);
			});
			mapVO.setTags(sbTags.substring(1));

			mapVO.setClearConditionText(mapInfo.getClearCondition().toString());
			mapVO.setCreateTimestamp((int) (System.currentTimeMillis()/1000));
			mapVO.setIsMap(1);
			mapVO.setStatus("未玩");
			log.debug("解析地图信息：{}", mapVO);
			return mapVO;
		}

		return null;
	}

	/**
	 * 将弹幕消息预处理成图号
	 *
	 * @param text 消息
	 * @return 预处理后的图号
	 */
	public String toMap(String text) {
		text = text.replaceAll("\\s*", "");
		text = text.replaceAll("-", "");
		text = text.replaceAll("_", "");
		text = text.toUpperCase(Locale.ROOT);
		String reg = "[A-Z0-9]{9}";
		Pattern p = Pattern.compile(reg);
		Matcher m = p.matcher(text);
		if (m.find()) {
			String group = m.group(0);
			log.debug("识别到图号：{}", group);
			return group;
		}
		return null;
	}

	/**
	 * 验证图号是否正确
	 *
	 * @param text 图号
	 * @return 0正确 1格式错误 2验证错误 3为工匠号
	 */
	private int verifyMap(String text) {
		boolean matches = text.matches("[0123456789BCDFGHJKLMNPQRSTVWXY]{9}");
		if (!matches) {
			return 1;
		}
		String line = "0123456789BCDFGHJKLMNPQRSTVWXY";
		char[] chars = text.toCharArray();
		long mapi = 0;
		for (int i = 0; i < chars.length; i++) {
			char c = chars[i];
			int index = line.indexOf(c);
			long v = (long) (index * Math.pow(30, i));
			mapi += v;
		}
		String s = Long.toBinaryString(mapi);
		String binaryA = s.substring(0, 4);
		String binaryB = s.substring(4, 10);
		String binaryC = s.substring(10, 30);
		String binaryD = s.substring(30, 31);
		String binaryE = s.substring(31, 32);
		String binaryF = s.substring(32, 44);
		if (!"1000".equals(binaryA) || !"1".equals(binaryE)) {
			return 2;
		}
		if ("1".equals(binaryD)) {
			return 3;
		}
		String idStr = binaryF + binaryC;
		int id = Integer.parseInt(idStr, 2);
		int v = Integer.parseInt(binaryB, 2);
		id = id ^ 0x1680E07C;
		if ((id - 31) % 64 == v) {
			return 0;
		}
		return 2;
	}

	/**
	 * 获取地图信息
	 *
	 * @param map 图号
	 * @return 地图信息类
	 */
	private MapInfo getMapInfo(String map) {
		String url = "https://tgrcode.lifan.one/mm2/level_info/" + map;
		String s = HttpUtil.get(url);
		return JSON.parseObject(s, MapInfo.class);
	}
}
