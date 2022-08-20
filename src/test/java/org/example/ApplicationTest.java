package org.example;

import lombok.extern.slf4j.Slf4j;
import org.example.dao.mapper.UserMapper;
import org.example.dao.po.TbUserPo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class ApplicationTest {
    @Autowired
    UserMapper mapper;

    @Test
    public void testSearchByName(){
        List<TbUserPo> tbUserPos =mapper.searchByName("shamate");
        log.info("查询结果：{}",tbUserPos);
    }
}
