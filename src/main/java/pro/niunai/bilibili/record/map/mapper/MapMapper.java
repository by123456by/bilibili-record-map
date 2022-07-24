package pro.niunai.bilibili.record.map.mapper;

import org.apache.ibatis.annotations.Mapper;
import pro.niunai.bilibili.record.map.pojo.MapInfo;
import pro.niunai.bilibili.record.map.pojo.MapVO;

/**
 * @date: 2022/7/21 15:01
 */
public interface  MapMapper {
	//插入数据
	int insert(MapVO map);

	//根据图号查数据
	MapVO selectByMap(String map);
}
