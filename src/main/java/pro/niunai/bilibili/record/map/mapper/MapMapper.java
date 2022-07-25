package pro.niunai.bilibili.record.map.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import pro.niunai.bilibili.record.map.pojo.MapInfo;
import pro.niunai.bilibili.record.map.pojo.MapVO;

import java.util.List;

/**
 * @date: 2022/7/21 15:01
 */
public interface  MapMapper {
	//插入数据
	int insert(MapVO map);
	//修改状态
	int updateStatusByMap(@Param("map") String map,@Param("status") String status);
	//根据图号查数据
	MapVO selectByMap(String map);
	//查询全部
	List<MapVO> selectlist();
}
