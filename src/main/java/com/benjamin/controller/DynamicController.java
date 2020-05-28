package com.benjamin.controller;

import com.benjamin.multi.DataSource;
import com.benjamin.multi.DataSourceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Ben Li.
 * Date: 2020/5/28
 */
@RestController
public class DynamicController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @DataSource(value = DataSourceType.MASTER)
    @RequestMapping("master")
    public List<Map<String, Object>> master() {
        String sql = "show tables";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        return maps;
    }

    @DataSource(value = DataSourceType.SLAVE)
    @RequestMapping("slave")
    public List<Map<String, Object>> slave() {
        String sql = "show tables";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);

        return maps;
    }
}
