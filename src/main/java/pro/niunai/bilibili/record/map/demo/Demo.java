package pro.niunai.bilibili.record.map.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * @date: 2022/7/20 20:06
 */
public class Demo {
	static String s = "{\"cmd\":\"DANMU_MSG\",\"info\":[[0,1,25,5816798,1658318064442,-984035851,0,\"00b7848e\",0,0,0,\"\",0,\"{}\",\"{}\",{\"mode\":0,\"show_player_type\":0,\"extra\":\"{\\\"send_from_me\\\":false,\\\"mode\\\":0,\\\"color\\\":5816798,\\\"dm_type\\\":0,\\\"font_size\\\":25,\\\"player_mode\\\":1,\\\"show_player_type\\\":0,\\\"content\\\":\\\"?\\\",\\\"user_hash\\\":\\\"12027022\\\",\\\"emoticon_unique\\\":\\\"\\\",\\\"bulge_display\\\":0,\\\"recommend_score\\\":0,\\\"main_state_dm_color\\\":\\\"\\\",\\\"objective_state_dm_color\\\":\\\"\\\",\\\"direction\\\":0,\\\"pk_direction\\\":0,\\\"quartet_direction\\\":0,\\\"anniversary_crowd\\\":0,\\\"yeah_space_type\\\":\\\"\\\",\\\"yeah_space_url\\\":\\\"\\\",\\\"jump_to_url\\\":\\\"\\\",\\\"space_type\\\":\\\"\\\",\\\"space_url\\\":\\\"\\\"}\"},{\"activity_identity\":\"\",\"activity_source\":0,\"not_show\":0}],\"?\",[544403990,\"蜜糖的日常\",0,0,0,10000,1,\"\"],[11,\"棉花花\",\"棉花大哥哥\",34348,9272486,\"\",0,9272486,9272486,9272486,0,1,1871001],[2,0,9868950,\"\\u003e50000\",0],[\"\",\"\"],0,0,null,{\"ts\":1658318064,\"ct\":\"C6411973\"},0,0,null,null,0,42]}";
	public static void main(String[] args) {
		JSONObject json = JSON.parseObject(s);
		JSONArray info = json.getJSONArray("info");
		System.out.println(info.getString(1));

	}
}
