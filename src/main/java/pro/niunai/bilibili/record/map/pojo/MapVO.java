package pro.niunai.bilibili.record.map.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @date: 2022/7/23 8:50
 */
@Data
@ApiModel(value="地图信息VO")
public class MapVO {
	@ApiModelProperty(value="投图人名",example="乌冬面pp")
	private String userName;
	@ApiModelProperty(value="原始弹幕",example="SQG-9NT-9GF")
	private String danmu;
	@ApiModelProperty(value="图号",example="SQG9NT9GF")
	private String map;
	@ApiModelProperty(value="投图时间时间戳",example="1659194286",notes="十位")
	private Integer createTimestamp;
	@ApiModelProperty(value="当前状态",example="未玩",notes = "当前以文本形式存储，未来可能改为数值代码")
	private String status;
	@ApiModelProperty(value="是否为图号",example="1",notes = "0为工匠号，1为图号")
	private Integer isMap;
	@ApiModelProperty(value="图名",example="方舟³ ~ Ark³  (CHN精英入队图)")
	private String name;
	@ApiModelProperty(value="地图简介",example="100sec Speedrun")
	private String description;
	@ApiModelProperty(value="上传时间",example="10-7-2020 1:10:42")
	private String uploadedPretty;
	@ApiModelProperty(value="上传时间时间戳",example="1594343442",notes="十位")
	private Integer uploaded;
	@ApiModelProperty(value="真实地图编号",example="21741537")
	private Integer dataId;
	@ApiModelProperty(value="图号",example="SQG9NT9GF",notes="云端返回(冗余)")
	private String courseId;
	@ApiModelProperty(value="游戏风格",example="SMB1")
	private String gameStyleName;
	@ApiModelProperty(value="游戏风格编号",example="0")
	private Integer gameStyle;
	@ApiModelProperty(value="游戏主题",example="Castle")
	private String themeName;
	@ApiModelProperty(value="游戏主题编号",example="2")
	private Integer theme;
	@ApiModelProperty(value="游戏难度",example="Super expert")
	private String difficultyName;
	@ApiModelProperty(value="游戏难度编号",example="3")
	private Integer difficulty;
	@ApiModelProperty(value="游戏标签",example="Speedrun|Short and sweet",notes="多个按|分割")
	private String tagsName;
	@ApiModelProperty(value="游戏标签",example="3|6",notes="多个按|分割")
	private String tags;
	@ApiModelProperty(value="最速通关时间文本",example="01:39.940")
	private String worldRecordPretty;
	@ApiModelProperty(value="最速通关时间毫秒数",example="99940")
	private Integer worldRecord;
	@ApiModelProperty(value="上传者通关时间文本",example="01:39.983")
	private String uploadTimePretty;
	@ApiModelProperty(value="上传者通关时间毫秒数",example="99983")
	private Integer uploadTime;
	@ApiModelProperty(value="评论数",example="20")
	private Integer numComments;
	@ApiModelProperty(value="通关条件编号",example="4116396131",notes = "0为无条件,字符串")
	private String clearConditionText;
	@ApiModelProperty(value="通关条件",example="Reach the goal after grabbing at least/all (n) Coin(s).",notes="无条件为null")
	private String clearConditionName;
	@ApiModelProperty(value="通关条件数量",example="100")
	private Integer clearConditionMagnitude;
	@ApiModelProperty(value="通关数",example="9")
	private Integer clears;
	@ApiModelProperty(value="游玩数",example="72213",notes = "游玩数或者已通关的人的游玩数，大概。")
	private Integer attempts;
	@ApiModelProperty(value="通关率",example="0.01%")
	private String clearRate;
	@ApiModelProperty(value="游玩人数",example="2339")
	private Integer plays;
	@ApiModelProperty(value="多人对战游玩数",example="0",notes ="不确定")
	private Integer versusMatches;
	@ApiModelProperty(value="多人合作游玩数",example="99",notes ="不确定")
	private Integer coopMatches;
	@ApiModelProperty(value="点赞数",example="1")
	private Integer likes;
	@ApiModelProperty(value="点踩数",example="19")
	private Integer boos;
	@ApiModelProperty(value="独特的玩家与对战",example="823",notes ="不知道是什么")
	private Integer uniquePlayersAndVersus;
	@ApiModelProperty(value="本周点赞数",example="0")
	private Integer weeklyLikes;
	@ApiModelProperty(value="本周游玩数",example="6")
	private Integer weeklyPlays;
}
