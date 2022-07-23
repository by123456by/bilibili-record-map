package pro.niunai.bilibili.record.map.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @date: 2022/7/23 8:50
 */
@Data
public class MapVO {
	//投图人名
	private String userName;
	//原始弹幕
	private String danmu;
	//图号
	private String map;
	//投图时间
	private Integer createTimestamp;
	//当前状态
	private String status;
	//是否为图号
	private Integer isMap;
	//图名
	private String name;
	//图名
	private String description;
	//上传时间文本 格式为：15-5-2022 7:34:27
	private String uploadedPretty;
	//上传时间时间戳 十位
	private Integer uploaded;
	//真实地图编号
	private Integer dataId;
	//图号（冗余）
	private String courseId;
	//游戏风格 文本简写 例如 SMB3 （初步分析 超级马里奥三代）
	private String gameStyleName;
	//游戏风格编号
	private Integer gameStyle;
	//游戏主题 文本 例如 Castle （直译 城堡）
	private String themeName;
	//游戏主题编号
	private Integer theme;
	//游戏难度 文本 例如 Super expert （大概是 极难）
	private String difficultyName;
	//游戏难度编号
	private Integer difficulty;
	//游戏标签 多个按|分割
	private String tagsName;
	//游戏标签编号 多个按|分割
	private String tags;
	//最速通关时间 文本 例如 01:01.948
	private String worldRecordPretty;
	//最速通关时间 毫秒数
	private Integer worldRecord;
	//上传者通关时间 文本
	private String uploadTimePretty;
	//上传者通关时间 毫秒数
	private Integer uploadTime;
	//评论数
	private Integer numComments;
	//通关条件编号 0为无条件 文本存储
	private String clearConditionText;
	//通关条件 文本 无条件为null
	private String clearConditionName;
	//通关条件数量 比如需要100金币 为100
	private Integer clearConditionMagnitude;
	//通关数
	private Integer clears;
	//已通关的尝试数
	private Integer attempts;
	//通关率
	private String clearRate;
	//游玩人数
	private Integer plays;
	//多人对战游玩数？
	private Integer versusMatches;
	//多人合作游玩数？
	private Integer coopMatches;
	//点赞数
	private Integer likes;
	//点踩数
	private Integer boos;
	//游玩数
	private Integer uniquePlayersAndVersus;
	//本周点赞数
	private Integer weeklyLikes;
	//本周游玩数
	private Integer weeklyPlays;
}
