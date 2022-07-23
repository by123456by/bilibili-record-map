package pro.niunai.bilibili.record.map.conf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @date: 2022/7/23 8:45
 */
@Configuration
@MapperScan("pro.niunai.bilibili.record.map.mapper")
public class MybatisConfiguration {
}
