package pro.niunai.bilibili.record.map.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import pro.niunai.bilibili.record.map.pojo.Msg;
import pro.niunai.bilibili.record.map.service.MapHandleService;
import sun.misc.GC;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
//		MapHandleService mapHandleService = new MapHandleService();
//		Msg m = new Msg();
//		m.setName("");
//		m.setMsg("SQG-9NT-9GF");
//		mapHandleService.msg(m);

/**
 * @date: 2022/7/20 20:06
 */
public class Demo {

	public static void main(String[] args) throws InterruptedException {
		int[] i = {2, 45, 4, 765, 5, 444, 23};
		Arrays.sort(i);
		System.out.println(Arrays.toString(i));
	}


}
