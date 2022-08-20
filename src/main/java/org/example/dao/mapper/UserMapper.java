package org.example.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.dao.po.TbUserPo;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from tb_test_01 where name like '%'||#{name}||'%' ")
    public List<TbUserPo> searchByName(String name);
}
