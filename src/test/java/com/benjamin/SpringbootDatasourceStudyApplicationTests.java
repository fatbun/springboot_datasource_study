package com.benjamin;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class SpringbootDatasourceStudyApplicationTests {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private ApplicationContext applicationContext;

	@Test
	void contextLoads() throws Exception {
        System.out.println(dataSource.getClass());


    }

}
