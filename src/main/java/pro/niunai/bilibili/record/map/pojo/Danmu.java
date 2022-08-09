package pro.niunai.bilibili.record.map.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @date: 2022/8/9 9:54
 */
@Data
@ApiModel(value="弹幕信息")
public class Danmu {
	@ApiModelProperty(value="弹幕用户名",example="乌冬面pp")
	private String name;
	@ApiModelProperty(value="弹幕信息",example="乌冬面真香")
	private String msg;
}
