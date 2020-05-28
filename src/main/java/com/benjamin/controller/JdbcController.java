package com.benjamin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * Created by Ben Li.
 * Date: 2020/5/28
 */
@RestController
public class JdbcController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @RequestMapping("/department")
    public List<Map<String, Object>> department() {
        String sql = "select * from t_department";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql);
        return maps;
    }

    @RequestMapping("/department/{id}")
    public List<Map<String, Object>> selectById(@PathVariable("id") Long id) {
        String sql = "select * from t_department where id = ?";
        List<Map<String, Object>> maps = jdbcTemplate.queryForList(sql,
                new Object[]{id});

        return maps;
    }
}
