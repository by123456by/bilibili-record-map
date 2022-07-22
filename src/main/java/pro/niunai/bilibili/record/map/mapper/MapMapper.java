package pro.niunai.bilibili.record.map.mapper;

import org.apache.ibatis.annotations.Mapper;
import pro.niunai.bilibili.record.map.pojo.MapInfo;

/**
 * @date: 2022/7/21 15:01
 */
@Mapper
public interface  MapMapper {
	int insert(MapInfo map);
}
