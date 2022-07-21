package pro.niunai.bilibili.record.map.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @date: 2022/7/21 11:11
 */
@NoArgsConstructor
@Data
public class MapInfo {
	private String userName;
	private String danmu;
	private LocalDateTime createTime;
	@JsonProperty("name")
	private String name;
	@JsonProperty("description")
	private String description;
	@JsonProperty("uploaded_pretty")
	private String uploadedPretty;
	@JsonProperty("uploaded")
	private Integer uploaded;
	@JsonProperty("course_id")
	private String courseId;
	@JsonProperty("game_style_name")
	private String gameStyleName;
	@JsonProperty("game_style")
	private Integer gameStyle;
	@JsonProperty("theme_name")
	private String themeName;
	@JsonProperty("theme")
	private Integer theme;
	@JsonProperty("difficulty_name")
	private String difficultyName;
	@JsonProperty("difficulty")
	private Integer difficulty;
	@JsonProperty("tags_name")
	private List<String> tagsName;
	@JsonProperty("tags")
	private List<Integer> tags;
	@JsonProperty("world_record_pretty")
	private String worldRecordPretty;
	@JsonProperty("world_record")
	private Integer worldRecord;
	@JsonProperty("upload_time_pretty")
	private String uploadTimePretty;
	@JsonProperty("upload_time")
	private Integer uploadTime;
	@JsonProperty("num_comments")
	private Integer numComments;
	@JsonProperty("clear_condition")
	private Long clearCondition;
	@JsonProperty("clear_condition_magnitude")
	private Integer clearConditionMagnitude;
	@JsonProperty("clears")
	private Integer clears;
	@JsonProperty("attempts")
	private Integer attempts;
	@JsonProperty("clear_rate")
	private String clearRate;
	@JsonProperty("plays")
	private Integer plays;
	@JsonProperty("versus_matches")
	private Integer versusMatches;
	@JsonProperty("coop_matches")
	private Integer coopMatches;
	@JsonProperty("likes")
	private Integer likes;
	@JsonProperty("boos")
	private Integer boos;
	@JsonProperty("unique_players_and_versus")
	private Integer uniquePlayersAndVersus;
	@JsonProperty("weekly_likes")
	private Integer weeklyLikes;
	@JsonProperty("weekly_plays")
	private Integer weeklyPlays;
}
