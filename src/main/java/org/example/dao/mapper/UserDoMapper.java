package org.example.dao.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.dao.po.TbUserDo;

import java.util.List;

@Mapper
public interface UserDoMapper {

    List<TbUserDo> searchByAgeRange(String min, String max);

    @Insert("INSERT into tb_test_01 (mobile,name,age)VALUES(#{mobile},#{name},#{age})")
    int add(TbUserDo row);

    int update(TbUserDo row);

}
